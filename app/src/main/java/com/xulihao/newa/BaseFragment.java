package com.xulihao.newa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 濠 on 2016/10/29.
 */
public abstract class BaseFragment extends android.support.v4.app.Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(getActivity());
        initData();
        return mRecyclerView;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/toutiao/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsURL newsURL = retrofit.create(NewsURL.class);
        Call<NewsBean> call = newsURL.getString(getType(), "9f9dfb6f819c3f7a616646bf98724f2e");
        call.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                Log.i("ljd", "onResponse: " + response.body().toString());
                NewsBean bean = response.body();
                List<NewsBean.ResultBean.DataBean> data = bean.getResult().getData();
                NewsAdapter adapter = new NewsAdapter(data, getActivity());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                Log.i("ljd", "onResponse: " + t.getMessage());


            }
        });
    }

    public abstract String getType();
}
