package com.example.admin.test_okhttp;

import java.util.List;


public class MyModel {

    private int count_total;
    private int pages;
    private int count;
    private List<PostsEntity> posts;
    private String status;

    public void setCount_total(int count_total) {
        this.count_total = count_total;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPosts(List<PostsEntity> posts) {
        this.posts = posts;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount_total() {
        return count_total;
    }

    public int getPages() {
        return pages;
    }

    public int getCount() {
        return count;
    }

    public List<PostsEntity> getPosts() {
        return posts;
    }

    public String getStatus() {
        return status;
    }

    public static class PostsEntity {

        protected String date;
        protected String thumbnail;
        protected String author;
        protected int id;
        protected String title;
        protected String url;

        public void setDate(String date) {
            this.date = date;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDate() {
            return date;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public String getAuthor() {
            return author;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }
    }
}
