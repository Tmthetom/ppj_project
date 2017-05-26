package cz.tul.controllers;

import cz.tul.services.ImageService;
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

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLConnection;

@RestController
public class ImageController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    private FileManager fileManager;

    @RequestMapping(value = ServerApi.UPLOAD_PATH, method = RequestMethod.POST)
    public ResponseEntity<ImageStatus> uploadImage(
            @RequestParam("author") String authorId,
            @RequestParam("name") String fileName,
            @RequestParam("file") MultipartFile imageFile
    ) {
        User author = null;
        Image image = null;

        try {
            author = userService.get(Integer.parseInt(authorId));
            if (!userService.exists(author)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            Logger logger = Logger.getLogger(ImageController.class);
            logger.error("Unable to parse author id = " + authorId + ":", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ImageStatus state = new ImageStatus(ImageStatus.ImageState.READY);
        try{
            image = new Image(author, fileName, "");
            imageService.create(image);

            if (image.getPath().equals("")){
                setFileManager();
                int id = image.getId_image();
                fileManager.saveImageData(id + "", imageFile.getInputStream());
            }
        }
        catch (Exception e){
            Logger logger = Logger.getLogger(ImageController.class);
            logger.error("Unable to parse image path = " + authorId + ":", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(state, HttpStatus.OK);
    }

//    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
//    @ResponseBody
//    public FileSystemResource getFile(@PathVariable("file_name") String fileName) {
//        return new FileSystemResource(myService.getFileFor(fileName));
//    }

    @RequestMapping(value = ServerApi.DOWNLOAD_PATH, method = RequestMethod.GET)
    public
    @ResponseBody
    HttpEntity<byte[]> downloadImage(@PathVariable("name") String name, HttpServletResponse response) {

        byte[] image = new byte[0];
        HttpHeaders headers = new HttpHeaders();

        setFileManager();
        if (fileManager.imageExists(name)) {
            try {

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                fileManager.copyImageData(name, bos);
                image = bos.toByteArray();
                headers.setContentLength(image.length);
                String mime = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(image));
                headers.setContentType(MediaType.valueOf(mime)); //or what ever type it is
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return new HttpEntity<byte[]>(image, headers);
    }

    public void setFileManager() {
        try {
            fileManager = FileManager.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
