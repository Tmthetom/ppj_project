package cz.tul.client;

import cz.tul.data.Image;
import retrofit.http.*;
import retrofit.mime.TypedFile;

import java.util.List;

public interface ServerApi {

    /* Implemented only for IMAGES (because using fileManager), other services are provided by REST annotation */

    public static final String IMAGES_PATH = "/images";
    public static final String IMAGE_PATH = IMAGES_PATH + "/{imageId}";
    public static final String IMAGE_FIND_AUTHOR = IMAGES_PATH + "/author/{userId}";
    public static final String IMAGE_FIND_NAME = IMAGES_PATH + "/name/{imageName}";
    public static final String IMAGE_FIND_TAG = IMAGES_PATH + "/tag/{tag}";

    @Multipart
    @PUT(IMAGE_PATH)
    public ImageStatus update(
            @Path("imageId") int imageId,
            @Part("name") String imageName);

    @Multipart
    @POST(IMAGES_PATH)
    public ImageStatus create(
            @Part("author") int authorId,
            @Part("name") String imageName,
            @Part("file") TypedFile imageFile);

    @GET(IMAGES_PATH)
    public List<Image> getAll(
    );

    @GET(IMAGE_PATH)
    public Image get(
            @Path("imageId") int imageId
    );

    @Streaming
    @GET(IMAGE_PATH + "/images")
    public byte[] getFile(
            @Path("imageId") int imageId
    );

    @GET(IMAGE_FIND_NAME)
    public List<Image> getByName(
            @Path("imageName") String imageName
    );

    @GET(IMAGE_FIND_AUTHOR)
    public List<Image> getByAuthor(
            @Path("userId") int userId
    );

    @GET(IMAGE_FIND_TAG)
    public List<Image> getByTag(
            @Path("tag") String tag
    );

    @DELETE(IMAGE_PATH)
    public void delete(
            @Path("imageId") int imageId
    );

    @DELETE(IMAGES_PATH)
    public void deleteAll(
    );
}
