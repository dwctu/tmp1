package com.wear.network.presenter.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: DiscoverAdvertisementBean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/wear/network/presenter/bean/DiscoverAdvertisementBean;", "", "result", "", XHTMLText.CODE, "", "message", "", "data", "Lcom/wear/network/presenter/bean/DiscoverAdvertisementBean$DataBean;", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/network/presenter/bean/DiscoverAdvertisementBean$DataBean;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/wear/network/presenter/bean/DiscoverAdvertisementBean$DataBean;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getResult", "()Ljava/lang/Boolean;", "setResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/network/presenter/bean/DiscoverAdvertisementBean$DataBean;)Lcom/wear/network/presenter/bean/DiscoverAdvertisementBean;", "equals", "other", "hashCode", "toString", "DataBean", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DiscoverAdvertisementBean {

    @Nullable
    private final Integer code;

    @Nullable
    private final DataBean data;

    @Nullable
    private String message;

    @Nullable
    private Boolean result;

    /* compiled from: DiscoverAdvertisementBean.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006)"}, d2 = {"Lcom/wear/network/presenter/bean/DiscoverAdvertisementBean$DataBean;", "", "lightImgUrl", "", "darkImgUrl", "clickImgSkip", "appScheme", TtmlNode.ATTR_ID, "packageName", "androidSkipAppRunPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroidSkipAppRunPage", "()Ljava/lang/String;", "setAndroidSkipAppRunPage", "(Ljava/lang/String;)V", "getAppScheme", "setAppScheme", "getClickImgSkip", "setClickImgSkip", "getDarkImgUrl", "setDarkImgUrl", "getId", "setId", "getLightImgUrl", "setLightImgUrl", "getPackageName", "setPackageName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final /* data */ class DataBean {

        @Nullable
        private String androidSkipAppRunPage;

        @Nullable
        private String appScheme;

        @Nullable
        private String clickImgSkip;

        @Nullable
        private String darkImgUrl;

        @Nullable
        private String id;

        @Nullable
        private String lightImgUrl;

        @Nullable
        private String packageName;

        public DataBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            this.lightImgUrl = str;
            this.darkImgUrl = str2;
            this.clickImgSkip = str3;
            this.appScheme = str4;
            this.id = str5;
            this.packageName = str6;
            this.androidSkipAppRunPage = str7;
        }

        public static /* synthetic */ DataBean copy$default(DataBean dataBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dataBean.lightImgUrl;
            }
            if ((i & 2) != 0) {
                str2 = dataBean.darkImgUrl;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = dataBean.clickImgSkip;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = dataBean.appScheme;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = dataBean.id;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = dataBean.packageName;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = dataBean.androidSkipAppRunPage;
            }
            return dataBean.copy(str, str8, str9, str10, str11, str12, str7);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getLightImgUrl() {
            return this.lightImgUrl;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getDarkImgUrl() {
            return this.darkImgUrl;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getClickImgSkip() {
            return this.clickImgSkip;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getAppScheme() {
            return this.appScheme;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getAndroidSkipAppRunPage() {
            return this.androidSkipAppRunPage;
        }

        @NotNull
        public final DataBean copy(@Nullable String lightImgUrl, @Nullable String darkImgUrl, @Nullable String clickImgSkip, @Nullable String appScheme, @Nullable String id, @Nullable String packageName, @Nullable String androidSkipAppRunPage) {
            return new DataBean(lightImgUrl, darkImgUrl, clickImgSkip, appScheme, id, packageName, androidSkipAppRunPage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataBean)) {
                return false;
            }
            DataBean dataBean = (DataBean) other;
            return Intrinsics.areEqual(this.lightImgUrl, dataBean.lightImgUrl) && Intrinsics.areEqual(this.darkImgUrl, dataBean.darkImgUrl) && Intrinsics.areEqual(this.clickImgSkip, dataBean.clickImgSkip) && Intrinsics.areEqual(this.appScheme, dataBean.appScheme) && Intrinsics.areEqual(this.id, dataBean.id) && Intrinsics.areEqual(this.packageName, dataBean.packageName) && Intrinsics.areEqual(this.androidSkipAppRunPage, dataBean.androidSkipAppRunPage);
        }

        @Nullable
        public final String getAndroidSkipAppRunPage() {
            return this.androidSkipAppRunPage;
        }

        @Nullable
        public final String getAppScheme() {
            return this.appScheme;
        }

        @Nullable
        public final String getClickImgSkip() {
            return this.clickImgSkip;
        }

        @Nullable
        public final String getDarkImgUrl() {
            return this.darkImgUrl;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getLightImgUrl() {
            return this.lightImgUrl;
        }

        @Nullable
        public final String getPackageName() {
            return this.packageName;
        }

        public int hashCode() {
            String str = this.lightImgUrl;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.darkImgUrl;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.clickImgSkip;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.appScheme;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.id;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.packageName;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.androidSkipAppRunPage;
            return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
        }

        public final void setAndroidSkipAppRunPage(@Nullable String str) {
            this.androidSkipAppRunPage = str;
        }

        public final void setAppScheme(@Nullable String str) {
            this.appScheme = str;
        }

        public final void setClickImgSkip(@Nullable String str) {
            this.clickImgSkip = str;
        }

        public final void setDarkImgUrl(@Nullable String str) {
            this.darkImgUrl = str;
        }

        public final void setId(@Nullable String str) {
            this.id = str;
        }

        public final void setLightImgUrl(@Nullable String str) {
            this.lightImgUrl = str;
        }

        public final void setPackageName(@Nullable String str) {
            this.packageName = str;
        }

        @NotNull
        public String toString() {
            return "DataBean(lightImgUrl=" + this.lightImgUrl + ", darkImgUrl=" + this.darkImgUrl + ", clickImgSkip=" + this.clickImgSkip + ", appScheme=" + this.appScheme + ", id=" + this.id + ", packageName=" + this.packageName + ", androidSkipAppRunPage=" + this.androidSkipAppRunPage + ')';
        }
    }

    public DiscoverAdvertisementBean(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable DataBean dataBean) {
        this.result = bool;
        this.code = num;
        this.message = str;
        this.data = dataBean;
    }

    public static /* synthetic */ DiscoverAdvertisementBean copy$default(DiscoverAdvertisementBean discoverAdvertisementBean, Boolean bool, Integer num, String str, DataBean dataBean, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = discoverAdvertisementBean.result;
        }
        if ((i & 2) != 0) {
            num = discoverAdvertisementBean.code;
        }
        if ((i & 4) != 0) {
            str = discoverAdvertisementBean.message;
        }
        if ((i & 8) != 0) {
            dataBean = discoverAdvertisementBean.data;
        }
        return discoverAdvertisementBean.copy(bool, num, str, dataBean);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final DataBean getData() {
        return this.data;
    }

    @NotNull
    public final DiscoverAdvertisementBean copy(@Nullable Boolean result, @Nullable Integer code, @Nullable String message, @Nullable DataBean data) {
        return new DiscoverAdvertisementBean(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscoverAdvertisementBean)) {
            return false;
        }
        DiscoverAdvertisementBean discoverAdvertisementBean = (DiscoverAdvertisementBean) other;
        return Intrinsics.areEqual(this.result, discoverAdvertisementBean.result) && Intrinsics.areEqual(this.code, discoverAdvertisementBean.code) && Intrinsics.areEqual(this.message, discoverAdvertisementBean.message) && Intrinsics.areEqual(this.data, discoverAdvertisementBean.data);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final DataBean getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Boolean bool = this.result;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.code;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        DataBean dataBean = this.data;
        return iHashCode3 + (dataBean != null ? dataBean.hashCode() : 0);
    }

    public final void setMessage(@Nullable String str) {
        this.message = str;
    }

    public final void setResult(@Nullable Boolean bool) {
        this.result = bool;
    }

    @NotNull
    public String toString() {
        return "DiscoverAdvertisementBean(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }
}
