package com.example.networkmanager_retrofitrxjava;

public class ResponseModel<T> {
    private int errorCode;
    private String errorMsg;
    private T data;//返回的实际数据结果

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /*
    * {
	"data": [{
		"desc": "扔物线",
		"id": 29,
		"imagePath": "https://www.wanandroid.com/blogimgs/1a8c327b-c0bb-47ce-817c-d7893ea5095d.png",
		"isVisible": 1,
		"order": 0,
		"title": "为什么要成为 GDE（谷歌认证开发专家）？我发现了盲点",
		"type": 0,
		"url": "https://url.rengwuxian.com/grytt"
	}],
	"errorCode": 0,
	"errorMsg": ""
}
    * */

}
