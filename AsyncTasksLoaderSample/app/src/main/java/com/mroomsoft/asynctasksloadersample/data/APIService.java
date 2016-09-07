package com.mroomsoft.asynctasksloadersample.data;

import com.mroomsoft.asynctasksloadersample.data.model.ItemModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Trong_iOS on 9/4/16.
 */
public interface APIService {
    @Headers({
            "X-Mashape-Key: 0l7NNcGN1emshwHFZXqsk0EqVMZgp1aTlyNjsnP6iZeWhOypVO",
            "Accept: text/plain"
    })
    @GET("search")
    Call<ItemModel> listNews(@Query("q") String q);
}
