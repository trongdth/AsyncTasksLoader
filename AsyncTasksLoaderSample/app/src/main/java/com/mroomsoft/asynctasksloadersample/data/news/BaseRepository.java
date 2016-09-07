package com.mroomsoft.asynctasksloadersample.data.news;

import com.mroomsoft.asynctasksloadersample.data.model.NewsModel;

import java.util.List;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public interface BaseRepository {
    interface MyCallback<T> {
        void onLoaded(List<T> result);
    }

    void loadNews(MyCallback<NewsModel> callback);
}
