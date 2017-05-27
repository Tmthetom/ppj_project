package cz.tul.client;

import retrofit.client.Response;
import retrofit.http.*;
import retrofit.mime.TypedFile;

public interface ServerApi {

    public static final String IMAGE_PATH = "/Image/{id_image}";
    public static final String IMAGES_PATH = "/Image";

    @Multipart
    @POST(IMAGES_PATH)
    public ImageStatus uploadImage(
            @Part("author") String authorId,
            @Part("name") String fileName,
            @Part("file") TypedFile imageFile);

    @Streaming
    @GET(IMAGE_PATH)
    Response downloadImage(@Path("name") String name);
}
