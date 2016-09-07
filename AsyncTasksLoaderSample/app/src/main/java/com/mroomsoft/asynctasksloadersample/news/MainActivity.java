package com.mroomsoft.asynctasksloadersample.news;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mroomsoft.asynctasksloadersample.R;
import com.mroomsoft.asynctasksloadersample.data.model.NewsModel;
import com.mroomsoft.asynctasksloadersample.data.news.MainRemoteDataSource;
import com.mroomsoft.asynctasksloadersample.data.news.MainRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private RecyclerView mRecycleView;
    ProgressDialog mDialog;
    private MainContract.Presenter mPresenter;
    private List<NewsModel> listNews = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadControls();


        MainRepository mainRepository = MainRepository.getInstance(MainRemoteDataSource.getInstance());

        mPresenter = new MainPresenter(this, mainRepository);
        mPresenter.loadNews();
    }

    private void loadControls() {
        mRecycleView = (RecyclerView) findViewById(R.id.news_list);
        mDialog = new ProgressDialog(this);
    }

    @Override
    public void onResult(List<NewsModel> list) {
        listNews = list;
        newsAdapter = new NewsAdapter(listNews, mItemListener, this);

        mRecycleView.setAdapter(newsAdapter);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    @Override
    public void showIndicator(boolean value) {
        if (value) {
            mDialog.setMessage("Please wait...");
            mDialog.setCancelable(false);
            mDialog.show();
        } else {
            mDialog.hide();
        }
    }

    ItemListener mItemListener = new ItemListener() {
        @Override
        public void onItemClick(int index) {
            final NewsModel recipe = listNews.get(index);

        }
    };

    public static class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private ItemListener mItemListener;
        private List<NewsModel> mListNews;
        private Context mContext;

        public NewsAdapter(List<NewsModel> listNews, ItemListener itemListener, Context context) {
            mListNews = listNews;
            mItemListener = itemListener;
            mContext = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_item, parent, false);
            return new ViewHolder(v, mItemListener);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            NewsModel news = mListNews.get(position);

            holder.tvLink.setText(news.getLink());
            holder.tvName.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mListNews.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ItemListener mItemListener;

            public TextView tvName, tvLink;

            public ViewHolder(View itemView, ItemListener itemListener) {
                super(itemView);

                tvName = (TextView)itemView.findViewById(R.id.tvName);
                tvLink = (TextView)itemView.findViewById(R.id.tvLink);

                mItemListener = itemListener;
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                mItemListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public interface ItemListener {
        void onItemClick(int index);
    }
}
