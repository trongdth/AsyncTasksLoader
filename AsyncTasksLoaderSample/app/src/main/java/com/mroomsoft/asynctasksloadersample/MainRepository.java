package com.mroomsoft.asynctasksloadersample;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public class MainRepository implements BaseRepository {
    static MainRepository INSTANCE = null;
    MainRemoteDataSource mMainRemoteDataSource;

    public static MainRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainRepository();
        }
        return INSTANCE;
    }

    private MainRepository() {
        mMainRemoteDataSource = new MainRemoteDataSource();
    }
}
