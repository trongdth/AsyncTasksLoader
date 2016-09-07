package com.mroomsoft.asynctasksloadersample.news;

import com.mroomsoft.asynctasksloadersample.data.model.NewsModel;
import com.mroomsoft.asynctasksloadersample.data.news.BaseRepository.MyCallback;
import com.mroomsoft.asynctasksloadersample.data.news.MainRepository;

import java.util.List;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public class MainPresenter implements MainContract.Presenter {
    MainContract.View mMainView;
    MainRepository mMainRepository;

    public MainPresenter(MainContract.View mainView, MainRepository mainRepository) {
        mMainView = mainView;
        mMainRepository = mainRepository;
    }

    @Override
    public void loadNews() {
        mMainView.showIndicator(true);
        mMainRepository.loadNews(new MyCallback<NewsModel>() {
            @Override
            public void onLoaded(List<NewsModel> result) {
                mMainView.showIndicator(false);
                mMainView.onResult(result);
            }
        });
    }
}
