package com.example.admin.test_okhttp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class Adapter extends BaseAdapter {
    ViewHolder mViewHolder;
    private LayoutInflater mInflater;
    List<MyModel.PostsEntity> mPosts;
    public Adapter(Activity activity, List<MyModel.PostsEntity> posts) {
        mPosts = posts;
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_list_view, parent, false);
            mViewHolder = new ViewHolder();
            mViewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.post_thumbnail);
            mViewHolder.author = (TextView) convertView.findViewById(R.id.post_author);
            mViewHolder.title = (TextView) convertView.findViewById(R.id.post_title);
            mViewHolder.date = (TextView) convertView.findViewById(R.id.post_date);

            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        MyModel.PostsEntity post = mPosts.get(position);

        mViewHolder.author.setText(post.getAuthor());
        mViewHolder.title.setText(post.title);
        mViewHolder.date.setText(post.date);

        return convertView;
    }
    private class ViewHolder{
        ImageView thumbnail;
        TextView title;
        TextView author;
        TextView date;
    }
}
