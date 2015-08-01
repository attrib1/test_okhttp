package com.example.admin.test_okhttp;


import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    TextView textResult;
    private ListView mListView;
    private  Adapter mAdapter;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.listView);
        new SimpleTask().execute();
    }

    private void showData(String jsonString) {
        Gson gson = new Gson();
        MyModel myModel = gson.fromJson(jsonString,MyModel.class);
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
         List<MyModel.PostsEntity> posts = myModel.getPosts();
        /*for (MyModel.PostsEntity post : posts) {

            builder.append(post.getTitle());
            builder.append("\n\n");
        }*/
        //Toast.makeText(this,builder.toString(), Toast.LENGTH_SHORT).show();
       // textResult.setText(builder.toString());
        mAdapter = new Adapter(this, posts);
        mListView.setAdapter(mAdapter);
    }

    class SimpleTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            OkHttpClient okHttpClient = new OkHttpClient();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url("http://blog.teamtreehouse.com/api/get_recent_summary/").build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    return "Not Success - code : " + response.code();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "Error - " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            showData(s);
        }
    }//End SimpleTask
}

