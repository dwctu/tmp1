package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: XRemoteAppUserBean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/wear/bean/XRemoteAppUserBean;", "", "result", "", XHTMLText.CODE, "", "message", "", "data", "Lcom/wear/bean/XRemoteAppUserBean$DataBean;", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/bean/XRemoteAppUserBean$DataBean;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/wear/bean/XRemoteAppUserBean$DataBean;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getResult", "()Ljava/lang/Boolean;", "setResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/bean/XRemoteAppUserBean$DataBean;)Lcom/wear/bean/XRemoteAppUserBean;", "equals", "other", "hashCode", "toString", "DataBean", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class XRemoteAppUserBean {

    @Nullable
    private final Integer code;

    @Nullable
    private final DataBean data;

    @Nullable
    private String message;

    @Nullable
    private Boolean result;

    public XRemoteAppUserBean(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable DataBean dataBean) {
        this.result = bool;
        this.code = num;
        this.message = str;
        this.data = dataBean;
    }

    public static /* synthetic */ XRemoteAppUserBean copy$default(XRemoteAppUserBean xRemoteAppUserBean, Boolean bool, Integer num, String str, DataBean dataBean, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = xRemoteAppUserBean.result;
        }
        if ((i & 2) != 0) {
            num = xRemoteAppUserBean.code;
        }
        if ((i & 4) != 0) {
            str = xRemoteAppUserBean.message;
        }
        if ((i & 8) != 0) {
            dataBean = xRemoteAppUserBean.data;
        }
        return xRemoteAppUserBean.copy(bool, num, str, dataBean);
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
    public final XRemoteAppUserBean copy(@Nullable Boolean result, @Nullable Integer code, @Nullable String message, @Nullable DataBean data) {
        return new XRemoteAppUserBean(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XRemoteAppUserBean)) {
            return false;
        }
        XRemoteAppUserBean xRemoteAppUserBean = (XRemoteAppUserBean) other;
        return Intrinsics.areEqual(this.result, xRemoteAppUserBean.result) && Intrinsics.areEqual(this.code, xRemoteAppUserBean.code) && Intrinsics.areEqual(this.message, xRemoteAppUserBean.message) && Intrinsics.areEqual(this.data, xRemoteAppUserBean.data);
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
        return "XRemoteAppUserBean(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    /* compiled from: XRemoteAppUserBean.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/wear/bean/XRemoteAppUserBean$DataBean;", "", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/wear/bean/XRemoteAppUserBean$DataBean$Application;", "applicationAccountList", "", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "version", "", "(Lcom/wear/bean/XRemoteAppUserBean$DataBean$Application;Ljava/util/List;Ljava/lang/String;)V", "getApplication", "()Lcom/wear/bean/XRemoteAppUserBean$DataBean$Application;", "getApplicationAccountList", "()Ljava/util/List;", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Application", "ApplicationAccount", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final /* data */ class DataBean {

        @Nullable
        private final Application application;

        @Nullable
        private final List<ApplicationAccount> applicationAccountList;

        @Nullable
        private String version;

        /* compiled from: XRemoteAppUserBean.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/wear/bean/XRemoteAppUserBean$DataBean$Application;", "", "applicationInfo", "", "applicationName", "applicationIconUrl", "applicationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationIconUrl", "()Ljava/lang/String;", "getApplicationId", "getApplicationInfo", "getApplicationName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final /* data */ class Application {

            @Nullable
            private final String applicationIconUrl;

            @Nullable
            private final String applicationId;

            @Nullable
            private final String applicationInfo;

            @Nullable
            private final String applicationName;

            public Application(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
                this.applicationInfo = str;
                this.applicationName = str2;
                this.applicationIconUrl = str3;
                this.applicationId = str4;
            }

            public static /* synthetic */ Application copy$default(Application application, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = application.applicationInfo;
                }
                if ((i & 2) != 0) {
                    str2 = application.applicationName;
                }
                if ((i & 4) != 0) {
                    str3 = application.applicationIconUrl;
                }
                if ((i & 8) != 0) {
                    str4 = application.applicationId;
                }
                return application.copy(str, str2, str3, str4);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getApplicationInfo() {
                return this.applicationInfo;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final String getApplicationName() {
                return this.applicationName;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final String getApplicationIconUrl() {
                return this.applicationIconUrl;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final String getApplicationId() {
                return this.applicationId;
            }

            @NotNull
            public final Application copy(@Nullable String applicationInfo, @Nullable String applicationName, @Nullable String applicationIconUrl, @Nullable String applicationId) {
                return new Application(applicationInfo, applicationName, applicationIconUrl, applicationId);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Application)) {
                    return false;
                }
                Application application = (Application) other;
                return Intrinsics.areEqual(this.applicationInfo, application.applicationInfo) && Intrinsics.areEqual(this.applicationName, application.applicationName) && Intrinsics.areEqual(this.applicationIconUrl, application.applicationIconUrl) && Intrinsics.areEqual(this.applicationId, application.applicationId);
            }

            @Nullable
            public final String getApplicationIconUrl() {
                return this.applicationIconUrl;
            }

            @Nullable
            public final String getApplicationId() {
                return this.applicationId;
            }

            @Nullable
            public final String getApplicationInfo() {
                return this.applicationInfo;
            }

            @Nullable
            public final String getApplicationName() {
                return this.applicationName;
            }

            public int hashCode() {
                String str = this.applicationInfo;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.applicationName;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.applicationIconUrl;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.applicationId;
                return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Application(applicationInfo=" + this.applicationInfo + ", applicationName=" + this.applicationName + ", applicationIconUrl=" + this.applicationIconUrl + ", applicationId=" + this.applicationId + ')';
            }
        }

        public DataBean(@Nullable Application application, @Nullable List<ApplicationAccount> list, @Nullable String str) {
            this.application = application;
            this.applicationAccountList = list;
            this.version = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataBean copy$default(DataBean dataBean, Application application, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                application = dataBean.application;
            }
            if ((i & 2) != 0) {
                list = dataBean.applicationAccountList;
            }
            if ((i & 4) != 0) {
                str = dataBean.version;
            }
            return dataBean.copy(application, list, str);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        @Nullable
        public final List<ApplicationAccount> component2() {
            return this.applicationAccountList;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        @NotNull
        public final DataBean copy(@Nullable Application application, @Nullable List<ApplicationAccount> applicationAccountList, @Nullable String version) {
            return new DataBean(application, applicationAccountList, version);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataBean)) {
                return false;
            }
            DataBean dataBean = (DataBean) other;
            return Intrinsics.areEqual(this.application, dataBean.application) && Intrinsics.areEqual(this.applicationAccountList, dataBean.applicationAccountList) && Intrinsics.areEqual(this.version, dataBean.version);
        }

        @Nullable
        public final Application getApplication() {
            return this.application;
        }

        @Nullable
        public final List<ApplicationAccount> getApplicationAccountList() {
            return this.applicationAccountList;
        }

        @Nullable
        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            Application application = this.application;
            int iHashCode = (application == null ? 0 : application.hashCode()) * 31;
            List<ApplicationAccount> list = this.applicationAccountList;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            String str = this.version;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public final void setVersion(@Nullable String str) {
            this.version = str;
        }

        @NotNull
        public String toString() {
            return "DataBean(application=" + this.application + ", applicationAccountList=" + this.applicationAccountList + ", version=" + this.version + ')';
        }

        /* compiled from: XRemoteAppUserBean.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0016H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\""}, d2 = {"Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "accountType", "applicationAccountId", "ctoken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountType", "()Ljava/lang/String;", "getApplicationAccountId", "getCtoken", "getUsername", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", DownloaderServiceMarshaller.PARAMS_FLAGS, "CREATOR", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final /* data */ class ApplicationAccount implements Parcelable {

            /* renamed from: CREATOR, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @Nullable
            private final String accountType;

            @Nullable
            private final String applicationAccountId;

            @Nullable
            private final String ctoken;

            @Nullable
            private final String username;

            /* compiled from: XRemoteAppUserBean.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.wear.bean.XRemoteAppUserBean$DataBean$ApplicationAccount$CREATOR, reason: from kotlin metadata */
            public static final class Companion implements Parcelable.Creator<ApplicationAccount> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public ApplicationAccount createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ApplicationAccount(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public ApplicationAccount[] newArray(int size) {
                    return new ApplicationAccount[size];
                }
            }

            public ApplicationAccount(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
                this.username = str;
                this.accountType = str2;
                this.applicationAccountId = str3;
                this.ctoken = str4;
            }

            public static /* synthetic */ ApplicationAccount copy$default(ApplicationAccount applicationAccount, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = applicationAccount.username;
                }
                if ((i & 2) != 0) {
                    str2 = applicationAccount.accountType;
                }
                if ((i & 4) != 0) {
                    str3 = applicationAccount.applicationAccountId;
                }
                if ((i & 8) != 0) {
                    str4 = applicationAccount.ctoken;
                }
                return applicationAccount.copy(str, str2, str3, str4);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final String getAccountType() {
                return this.accountType;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final String getApplicationAccountId() {
                return this.applicationAccountId;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final String getCtoken() {
                return this.ctoken;
            }

            @NotNull
            public final ApplicationAccount copy(@Nullable String username, @Nullable String accountType, @Nullable String applicationAccountId, @Nullable String ctoken) {
                return new ApplicationAccount(username, accountType, applicationAccountId, ctoken);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ApplicationAccount)) {
                    return false;
                }
                ApplicationAccount applicationAccount = (ApplicationAccount) other;
                return Intrinsics.areEqual(this.username, applicationAccount.username) && Intrinsics.areEqual(this.accountType, applicationAccount.accountType) && Intrinsics.areEqual(this.applicationAccountId, applicationAccount.applicationAccountId) && Intrinsics.areEqual(this.ctoken, applicationAccount.ctoken);
            }

            @Nullable
            public final String getAccountType() {
                return this.accountType;
            }

            @Nullable
            public final String getApplicationAccountId() {
                return this.applicationAccountId;
            }

            @Nullable
            public final String getCtoken() {
                return this.ctoken;
            }

            @Nullable
            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                String str = this.username;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.accountType;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.applicationAccountId;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.ctoken;
                return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "ApplicationAccount(username=" + this.username + ", accountType=" + this.accountType + ", applicationAccountId=" + this.applicationAccountId + ", ctoken=" + this.ctoken + ')';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeString(this.username);
                dest.writeString(this.accountType);
                dest.writeString(this.applicationAccountId);
                dest.writeString(this.ctoken);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public ApplicationAccount(@NotNull Parcel parcel) {
                this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                Intrinsics.checkNotNullParameter(parcel, "parcel");
            }
        }

        public /* synthetic */ DataBean(Application application, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(application, (i & 2) != 0 ? new ArrayList() : list, str);
        }
    }
}
