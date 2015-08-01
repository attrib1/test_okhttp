package com.example.admin.test_okhttp;

import android.app.Activity;
import android.app.Application;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class Post_Activity extends ActionBarActivity {

    public String URL = "https://api.github.com/markdown/raw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        new SimplePostTask().execute(URL);

    }

    private class SimplePostTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            OkHttpClient okHttpClient = new OkHttpClient();
           // MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
            RequestBody mData = new FormEncodingBuilder()
                    .add("post_data", "From Android.สวัสดี")
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder
                    .url("http://192.168.1.102/android_PostData_Test/index.php")
                    .post(mData)
                    .build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    return "Insert Successful";
                } else {
                    return "Not Insert Successful";
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "Error - " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("dd", s);
            showdata(s);
        }
    }

    private void showdata(String s) {
        Toast.makeText(getApplication(), s, Toast.LENGTH_SHORT).show();
    }
}
