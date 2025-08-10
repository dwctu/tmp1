package com.wear.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyFeedbackBean implements Serializable {
    public DataDTO data;
    public String feedback;
    public String toyId;
    public List<ToyListDTO> toyList;
    public String type;

    public static class DataDTO {
        public Boolean connected;
        public String function;
        public Integer index;
        public Integer value;
    }

    public static class ToyListDTO {
        public Integer battery;
        public Boolean connected;
        public Integer fVersion;
        public String hVersion;
        public String id;
        public String name;
        public String nickname;
        public String type;
    }

    public ToyFeedbackBean() {
        this(null);
    }

    public ToyFeedbackBean(String str) {
        this.type = str;
    }
}
