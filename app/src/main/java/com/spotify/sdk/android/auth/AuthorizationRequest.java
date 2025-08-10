package com.spotify.sdk.android.auth;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AuthorizationRequest implements Parcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new a();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String[] e;
    public final boolean f;
    public final Map<String, String> g;
    public final String h;

    public class a implements Parcelable.Creator<AuthorizationRequest> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthorizationRequest createFromParcel(Parcel parcel) {
            return new AuthorizationRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AuthorizationRequest[] newArray(int i) {
            return new AuthorizationRequest[i];
        }
    }

    public static class b {
        public final String a;
        public final AuthorizationResponse.c b;
        public final String c;
        public String d;
        public String[] e;
        public boolean f;
        public String g;
        public final Map<String, String> h = new HashMap();

        public b(String str, AuthorizationResponse.c cVar, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("Client ID can't be null");
            }
            if (cVar == null) {
                throw new IllegalArgumentException("Response type can't be null");
            }
            if (str2 == null || str2.length() == 0) {
                throw new IllegalArgumentException("Redirect URI can't be null or empty");
            }
            this.a = str;
            this.b = cVar;
            this.c = str2;
        }

        public AuthorizationRequest a() {
            return new AuthorizationRequest(this.a, this.b, this.c, this.d, this.e, this.f, this.h, this.g, null);
        }

        public b b(String[] strArr) {
            this.e = strArr;
            return this;
        }
    }

    public /* synthetic */ AuthorizationRequest(String str, AuthorizationResponse.c cVar, String str2, String str3, String[] strArr, boolean z, Map map, String str4, a aVar) {
        this(str, cVar, str2, str3, strArr, z, map, str4);
    }

    public String a() {
        return TextUtils.isEmpty(this.h) ? "android-sdk" : this.h;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] e() {
        return this.e;
    }

    public String f() {
        return this.d;
    }

    public final String g() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.e) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public Uri h() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https").authority("accounts.spotify.com").appendPath("authorize").appendQueryParameter("client_id", this.a).appendQueryParameter("response_type", this.b).appendQueryParameter("redirect_uri", this.c).appendQueryParameter("show_dialog", String.valueOf(this.f)).appendQueryParameter("utm_source", "spotify-sdk").appendQueryParameter("utm_medium", "android-sdk").appendQueryParameter("utm_campaign", a());
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            builder.appendQueryParameter("scope", g());
        }
        String str = this.d;
        if (str != null) {
            builder.appendQueryParameter("state", str);
        }
        if (this.g.size() > 0) {
            for (Map.Entry<String, String> entry : this.g.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeStringArray(this.e);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeString(this.h);
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.g.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        parcel.writeBundle(bundle);
    }

    public AuthorizationRequest(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.createStringArray();
        this.f = parcel.readByte() == 1;
        this.g = new HashMap();
        this.h = parcel.readString();
        Bundle bundle = parcel.readBundle(AuthorizationRequest.class.getClassLoader());
        for (String str : bundle.keySet()) {
            this.g.put(str, bundle.getString(str));
        }
    }

    public AuthorizationRequest(String str, AuthorizationResponse.c cVar, String str2, String str3, String[] strArr, boolean z, Map<String, String> map, String str4) {
        this.a = str;
        this.b = cVar.toString();
        this.c = str2;
        this.d = str3;
        this.e = strArr;
        this.f = z;
        this.g = map;
        this.h = str4;
    }
}
