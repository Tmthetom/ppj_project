package cz.tul.client;

import org.springframework.web.multipart.MultipartFile;
import retrofit.client.Response;
import retrofit.http.*;
import retrofit.mime.TypedFile;

public interface ServerApi {

    public static final String DOWNLOAD_PATH = "/Image/Download/{name}";
    public static final String UPLOAD_PATH = "/Image";

    @Multipart
    @POST(UPLOAD_PATH)
    public ImageStatus uploadImage(
            @Part("author") String authorId,
            @Part("name") String fileName,
            @Part("file") TypedFile imageFile);

    @Streaming
    @GET(DOWNLOAD_PATH)
    Response downloadImage(@Path("name") String name);
}
