package com.mroomsoft.asynctasksloadersample;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private RecyclerView mRecycleView;
    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadControls();


        MainRepository mainRepository = MainRepository.getInstance();
        mPresenter = new MainPresenter(this, mainRepository);

        mPresenter.loadNews();
    }

    private void loadControls() {
        mRecycleView = (RecyclerView) findViewById(R.id.news_list);
    }
}
