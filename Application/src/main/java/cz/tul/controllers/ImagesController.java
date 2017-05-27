package cz.tul.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.tul.data.Tag;
import cz.tul.services.ImageService;
import cz.tul.services.TagService;
import org.apache.log4j.Logger;
import cz.tul.client.FileManager;
import cz.tul.client.ImageStatus;
import cz.tul.client.ServerApi;
import cz.tul.data.Image;
import cz.tul.data.User;
import cz.tul.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;

@RestController
public class ImagesController {

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ImageService imageService;

    private FileManager fileManager;

    public void setFileManager() {
        try {
            fileManager = FileManager.get();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(ImagesController.class);
            logger.error("Unable to set file manager:", e);
        }
    }

    @RequestMapping(value = ServerApi.IMAGE_PATH, method = RequestMethod.PUT)
    public ResponseEntity<ImageStatus> update(
            @PathVariable("imageId") int imageId,
            @RequestPart(value = "name") String imageName
    ) {
        Image image = null;

        try {
            if (imageService.exists(imageId)){
                image = imageService.get(imageId);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            Logger logger = Logger.getLogger(ImagesController.class);
            logger.error("Unable to parse imageId = " + imageId + ":", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            image.setName(imageName);
        }
        catch (Exception e) {
            Logger logger = Logger.getLogger(ImagesController.class);
            logger.error("Unable to parse imageName = " + imageName + ":", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ImageStatus state = new ImageStatus(ImageStatus.ImageState.READY);
        imageService.update(image);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    @RequestMapping(value = ServerApi.IMAGES_PATH, method = RequestMethod.POST)
    public ResponseEntity<ImageStatus> create(
            @RequestParam("author") int authorId,
            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile imageFile
    ) {
        User author = null;
        Image image = null;
        int randomId = 0 + (int)(Math.random() * Integer.MAX_VALUE);
        String fileName = authorId + "_" + name + "_" + randomId;

        try {
            author = userService.get(authorId);
            if (!userService.exists(author)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            Logger logger = Logger.getLogger(ImagesController.class);
            logger.error("Unable to parse author id = " + authorId + ":", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ImageStatus state = new ImageStatus(ImageStatus.ImageState.READY);
        try{
            image = new Image(author, name, "");
            imageService.create(image);

            if (image.getPath().equals("")){
                setFileManager();
                fileManager.saveImageData(fileName, imageFile.getInputStream());
                image.setPath(fileName);
                imageService.update(image);
            }
        }
        catch (Exception e){
            Logger logger = Logger.getLogger(ImagesController.class);
            logger.error("Unable to parse image path = " + authorId + ":", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    @RequestMapping(value = ServerApi.IMAGES_PATH, method = RequestMethod.GET)
    public ResponseEntity<List<Image>> getAll() {
        List<Image> images = imageService.getAll();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @RequestMapping(value = ServerApi.IMAGE_PATH, method = RequestMethod.GET)
    public ResponseEntity<Image> get(
            @PathVariable("imageId") int imageId
    ) {
        Image image = imageService.get(imageId);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @RequestMapping(value = ServerApi.IMAGE_PATH + "/images", method = RequestMethod.GET)
    public HttpEntity<byte[]> getFile(
            @PathVariable("imageId") int imageId
    ) {
        Image image = imageService.get(imageId);

        byte[] imageFile = new byte[0];
        HttpHeaders headers = new HttpHeaders();
        setFileManager();
        if(fileManager.imageExists(image.getPath())) {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                fileManager.retrieveImage(image.getPath(), baos);
                imageFile = baos.toByteArray();
                headers.setContentLength(imageFile.length);
                String mime = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageFile));
                headers.setContentType(MediaType.valueOf(mime));
            } catch (IOException e) {
                Logger logger = Logger.getLogger(ImagesController.class);
                logger.error("Unable to get file:", e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new HttpEntity<>(imageFile, headers);
    }

    @RequestMapping(value = ServerApi.IMAGE_FIND_NAME, method = RequestMethod.GET)
    public ResponseEntity<List<Image>> getByName(
            @PathVariable("imageName") String imageName
    ) {
        List<Image> images = imageService.getByName(imageName);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @RequestMapping(value = ServerApi.IMAGE_FIND_AUTHOR, method = RequestMethod.GET)
    public ResponseEntity<List<Image>> getByAuthor(
            @PathVariable("userId") int userId
    ) {
        User user = userService.get(userId);
        List<Image> images = imageService.getByAuthor(user);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @RequestMapping(value = ServerApi.IMAGE_FIND_TAG, method = RequestMethod.GET)
    public ResponseEntity<List<Image>> getByTag(
            @PathVariable("tag") String tag
    ) {
        Tag tagObject = tagService.get(tag);
        List<Image> images = imageService.getByTag(tagObject);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @RequestMapping(value = ServerApi.IMAGE_PATH, method = RequestMethod.DELETE)
    public ResponseEntity<Image> delete(@PathVariable("imageId") int imageId) {
        if (imageService.exists(imageId)){
            Image image = imageService.get(imageId);
            imageService.delete(image);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = ServerApi.IMAGES_PATH, method = RequestMethod.DELETE)
    public ResponseEntity<Image> deleteAll() {
        imageService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
