package com.mroomsoft.asynctasksloadersample;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public class MainPresenter implements MainContract.Presenter  {
    MainContract.View mMainView;
    MainRepository mMainRepository;

    public MainPresenter(MainContract.View mainView, MainRepository mainRepository) {
        mMainView = mainView;
        mMainRepository = mainRepository;
    }

    @Override
    public void loadNews() {

    }
}
