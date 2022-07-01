package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class News {
    private String title;
    private String desc;
    private String url;
    private String imageurl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }
}
