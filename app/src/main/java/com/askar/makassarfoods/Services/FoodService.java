package com.askar.makassarfoods.Services;

import com.askar.makassarfoods.Models.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FoodService {
    @GET("/muhammadaskar/rest-api/foods")
    Call<List<Food>> getFood();

    @GET("/muhammadaskar/public-api/dessert")
    Call<List<Food>> getDessert();

//    @POST("/muhammadaskar11/rest-api/foods")
//    Call<Food> addFood(@Body Food food);
//
//    @PUT("/muhammadaskar11/rest-api/foods")
//    Call<Food> editFood(@Path("id") int id, @Body Food food);
}
