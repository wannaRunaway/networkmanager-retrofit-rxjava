package com.example.networkmanager_retrofitrxjava;

import java.io.Serializable;

public class MyBanner implements Serializable {
    /*
    * {
		"desc": "扔物线",
		"id": 29,
		"imagePath": "https://www.wanandroid.com/blogimgs/1a8c327b-c0bb-47ce-817c-d7893ea5095d.png",
		"isVisible": 1,
		"order": 0,
		"title": "为什么要成为 GDE（谷歌认证开发专家）？我发现了盲点",
		"type": 0,
		"url": "https://url.rengwuxian.com/grytt"
	}
    * */
    private String desc, title, imagePath;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
