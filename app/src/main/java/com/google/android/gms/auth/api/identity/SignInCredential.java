package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
@SafeParcelable.Class(creator = "SignInCredentialCreator")
/* loaded from: classes2.dex */
public final class SignInCredential extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zbk();

    @SafeParcelable.Field(getter = "getId", id = 1)
    private final String zba;

    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    private final String zbb;

    @Nullable
    @SafeParcelable.Field(getter = "getGivenName", id = 3)
    private final String zbc;

    @Nullable
    @SafeParcelable.Field(getter = "getFamilyName", id = 4)
    private final String zbd;

    @Nullable
    @SafeParcelable.Field(getter = "getProfilePictureUri", id = 5)
    private final Uri zbe;

    @Nullable
    @SafeParcelable.Field(getter = "getPassword", id = 6)
    private final String zbf;

    @Nullable
    @SafeParcelable.Field(getter = "getGoogleIdToken", id = 7)
    private final String zbg;

    @SafeParcelable.Constructor
    public SignInCredential(@RecentlyNonNull @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 5) Uri uri, @Nullable @SafeParcelable.Param(id = 6) String str5, @Nullable @SafeParcelable.Param(id = 7) String str6) {
        this.zba = Preconditions.checkNotEmpty(str);
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = uri;
        this.zbf = str5;
        this.zbg = str6;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        return Objects.equal(this.zba, signInCredential.zba) && Objects.equal(this.zbb, signInCredential.zbb) && Objects.equal(this.zbc, signInCredential.zbc) && Objects.equal(this.zbd, signInCredential.zbd) && Objects.equal(this.zbe, signInCredential.zbe) && Objects.equal(this.zbf, signInCredential.zbf) && Objects.equal(this.zbg, signInCredential.zbg);
    }

    @RecentlyNullable
    public String getDisplayName() {
        return this.zbb;
    }

    @RecentlyNullable
    public String getFamilyName() {
        return this.zbd;
    }

    @RecentlyNullable
    public String getGivenName() {
        return this.zbc;
    }

    @RecentlyNullable
    public String getGoogleIdToken() {
        return this.zbg;
    }

    @RecentlyNonNull
    public String getId() {
        return this.zba;
    }

    @RecentlyNullable
    public String getPassword() {
        return this.zbf;
    }

    @RecentlyNullable
    public Uri getProfilePictureUri() {
        return this.zbe;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 4, getFamilyName(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 7, getGoogleIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
