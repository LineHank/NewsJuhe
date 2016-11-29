package com.xulihao.newa;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by zz on 2016/10/14.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private List<NewsBean.ResultBean.DataBean> mData;
    private LayoutInflater inflater;
    private Context context;
    public NewsAdapter(List<NewsBean.ResultBean.DataBean> mData, Context context) {
        this.mData = mData;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(mData.get(position).getThumbnail_pic_s()).into(holder.imageView);
        holder.tv_author.setText(mData.get(position).getAuthor_name());
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_time.setText(mData.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        if (mData!=null){
            return mData.size();
        }
        return 0;
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_title;
        TextView tv_author;
        TextView tv_time;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
            tv_title = ( TextView) itemView.findViewById(R.id.tv_title);
            tv_author = ( TextView) itemView.findViewById(R.id.tv_author);
            tv_time = ( TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
