package com.mroomsoft.asynctasksloadersample.data.news;

import com.mroomsoft.asynctasksloadersample.data.model.NewsModel;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public class MainRepository implements BaseRepository {
    static MainRepository INSTANCE = null;
    MainRemoteDataSource mMainRemoteDataSource;

    public static MainRepository getInstance(MainRemoteDataSource remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new MainRepository(remoteDataSource);
        }
        return INSTANCE;
    }

    private MainRepository(MainRemoteDataSource remoteDataSource) {
        mMainRemoteDataSource = remoteDataSource;
    }

    @Override
    public void loadNews(MyCallback<NewsModel> callback) {
        mMainRemoteDataSource.loadNews(callback);
    }
}
