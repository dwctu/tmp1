package com.wear.bean;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class SetLocalToyResponse {
    private String email;
    private String id;
    private HashMap<String, ToysBean> toys;
    private String username;

    public static class ToysBean {
        private String id;
        private String name;
        private String nickName;
        private String version;

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getVersion() {
            return this.version;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public HashMap<String, ToysBean> getToys() {
        return this.toys;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setToys(HashMap<String, ToysBean> map) {
        this.toys = map;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
