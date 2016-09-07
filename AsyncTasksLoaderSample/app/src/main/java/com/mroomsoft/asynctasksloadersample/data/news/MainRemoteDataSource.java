package com.mroomsoft.asynctasksloadersample.data.news;

import com.mroomsoft.asynctasksloadersample.data.APIService;
import com.mroomsoft.asynctasksloadersample.data.model.ItemModel;

import java.net.CookieManager;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public class MainRemoteDataSource implements BaseDataSource {
    private static MainRemoteDataSource INSTANCE = null;
    private Retrofit retrofit;
    public static MainRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainRemoteDataSource();
        }
        return INSTANCE;
    }

    private MainRemoteDataSource() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        httpClient.cookieJar(new JavaNetCookieJar(new CookieManager()));

        retrofit = new Retrofit.Builder()
                .baseUrl("https://deezerdevs-deezer.p.mashape.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Override
    public void loadNews(final BaseRepository.MyCallback callback) {
        APIService service = retrofit.create(APIService.class);
        Call<ItemModel> call = service.listNews("eminem");

        call.enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                callback.onLoaded(response.body().data);
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
