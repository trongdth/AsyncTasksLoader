package com.mroomsoft.asynctasksloadersample.news;

import com.mroomsoft.asynctasksloadersample.data.model.NewsModel;

import java.util.List;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public interface MainContract {
    interface View {
        void onResult(List<NewsModel> list);
        void showIndicator(boolean value);
    }

    interface Presenter {
        void loadNews();
    }
}
