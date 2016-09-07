package com.mroomsoft.asynctasksloadersample.data.news;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public interface BaseDataSource {
    void loadNews(BaseRepository.MyCallback callback);
}
