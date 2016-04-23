package app.shopspot.nilezia.songsao.controller.http;

import app.shopspot.nilezia.songsao.model.PhotoListItemModel;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by NileZia on 16/3/2559.
 */
public interface ApiConnector {
    @GET("data/{keyword}/{limit}/{page}")
    Call<PhotoListItemModel> LoadPhotoList
            (@Path("keyword") String keyword,
             @Path("limit") int limit,
             @Path("page") int page);


}
