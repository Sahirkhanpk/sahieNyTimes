package com.example.nytimesahir.api;



import androidx.annotation.NonNull;

import com.example.nytimesahir.Model.ApiResponse;
import com.example.nytimesahir.Model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by Muhammad Hassan on 4/26/2017.
 */

public interface IEndPoints {

    // get token
/*    @NonNull
    @GET("agentloc.php?")
    //@GET("token.php")
    @Headers("Content-Type: application/json")
    Observable<sendLocation> sendLocation(

            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("uid") String id);*/

    @GET("mostpopular/v2/mostviewed/{section}/{period}.json")
    Observable<ApiResponse> getNewsDetails(@Path("section") String section, @Path("period") String period,
                                         @Query("api-key") String apiKey);






}
