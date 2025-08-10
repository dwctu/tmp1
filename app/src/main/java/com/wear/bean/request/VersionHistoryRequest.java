package com.wear.bean.request;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Locale;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* loaded from: classes3.dex */
public class VersionHistoryRequest implements Serializable {

    @SerializedName(DataLayout.ELEMENT)
    private Integer page;

    @SerializedName("pageSize")
    private Integer pageSize;

    @SerializedName("pf")
    private String pf = DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE;

    @SerializedName("lang")
    private String lang = Locale.getDefault().getLanguage();

    public VersionHistoryRequest() {
    }

    public String getLang() {
        return this.lang;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public String getPf() {
        return this.pf;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public void setPf(String str) {
        this.pf = str;
    }

    public String toString() {
        return "pf=" + this.pf + "&lang=" + this.lang + "&page=" + this.page + "&pageSize=" + this.pageSize;
    }

    public VersionHistoryRequest(Integer num, Integer num2) {
        this.page = num;
        this.pageSize = num2;
    }
}
