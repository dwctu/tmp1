package com.wear.bean.socketio.msg.response;

/* loaded from: classes3.dex */
public class MessageErrorResponse {
    private Integer code;
    private String content;
    private String remark;
    private String source;
    private String title;
    private String type;
    private String url;

    public Integer getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
