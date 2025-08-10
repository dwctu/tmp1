package com.spotify.sdk.android.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class AuthorizationResponse implements Parcelable {
    public static final Parcelable.Creator<AuthorizationResponse> CREATOR = new a();
    public final c a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;

    public class a implements Parcelable.Creator<AuthorizationResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthorizationResponse createFromParcel(Parcel parcel) {
            return new AuthorizationResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AuthorizationResponse[] newArray(int i) {
            return new AuthorizationResponse[i];
        }
    }

    public static class b {
        public c a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;

        public AuthorizationResponse a() {
            return new AuthorizationResponse(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        public b b(String str) {
            this.c = str;
            return this;
        }

        public b c(String str) {
            this.b = str;
            return this;
        }

        public b d(String str) {
            this.e = str;
            return this;
        }

        public b e(int i) {
            this.f = i;
            return this;
        }

        public b f(String str) {
            this.d = str;
            return this;
        }

        public b g(c cVar) {
            this.a = cVar;
            return this;
        }
    }

    public enum c {
        CODE(XHTMLText.CODE),
        TOKEN("token"),
        ERROR("error"),
        EMPTY("empty"),
        UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);

        private final String mType;

        c(String str) {
            this.mType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mType;
        }
    }

    public /* synthetic */ AuthorizationResponse(c cVar, String str, String str2, String str3, String str4, int i, a aVar) {
        this(cVar, str, str2, str3, str4, i);
    }

    public static AuthorizationResponse a(Uri uri) {
        b bVar = new b();
        if (uri == null) {
            bVar.g(c.EMPTY);
            return bVar.a();
        }
        String queryParameter = uri.getQueryParameter("error");
        if (queryParameter != null) {
            String queryParameter2 = uri.getQueryParameter("state");
            bVar.d(queryParameter);
            bVar.f(queryParameter2);
            bVar.g(c.ERROR);
            return bVar.a();
        }
        String queryParameter3 = uri.getQueryParameter(XHTMLText.CODE);
        if (queryParameter3 != null) {
            String queryParameter4 = uri.getQueryParameter("state");
            bVar.c(queryParameter3);
            bVar.f(queryParameter4);
            bVar.g(c.CODE);
            return bVar.a();
        }
        String encodedFragment = uri.getEncodedFragment();
        if (encodedFragment == null || encodedFragment.length() <= 0) {
            bVar.g(c.UNKNOWN);
            return bVar.a();
        }
        String strDecode = null;
        String strDecode2 = null;
        String strDecode3 = null;
        for (String str : encodedFragment.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length == 2) {
                if (strArrSplit[0].startsWith("access_token")) {
                    strDecode = Uri.decode(strArrSplit[1]);
                }
                if (strArrSplit[0].startsWith("state")) {
                    strDecode2 = Uri.decode(strArrSplit[1]);
                }
                if (strArrSplit[0].startsWith("expires_in")) {
                    strDecode3 = Uri.decode(strArrSplit[1]);
                }
            }
        }
        bVar.b(strDecode);
        bVar.f(strDecode2);
        if (strDecode3 != null) {
            try {
                bVar.e(Integer.parseInt(strDecode3));
            } catch (NumberFormatException unused) {
            }
        }
        bVar.g(c.TOKEN);
        return bVar.a();
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public c e() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeString(this.c);
        parcel.writeString(this.b);
        parcel.writeInt(this.a.ordinal());
    }

    public AuthorizationResponse(c cVar, String str, String str2, String str3, String str4, int i) {
        this.a = cVar == null ? c.UNKNOWN : cVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i;
    }

    public AuthorizationResponse(Parcel parcel) {
        this.f = parcel.readInt();
        this.e = parcel.readString();
        this.d = parcel.readString();
        this.c = parcel.readString();
        this.b = parcel.readString();
        this.a = c.values()[parcel.readInt()];
    }
}
