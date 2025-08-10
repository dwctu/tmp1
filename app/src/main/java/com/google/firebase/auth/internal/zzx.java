package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzza;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "DefaultFirebaseUserCreator")
/* loaded from: classes2.dex */
public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();

    @SafeParcelable.Field(getter = "getCachedTokenState", id = 1)
    private zzza zza;

    @SafeParcelable.Field(getter = "getDefaultAuthUserInfo", id = 2)
    private zzt zzb;

    @SafeParcelable.Field(getter = "getFirebaseAppName", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getUserType", id = 4)
    private String zzd;

    @SafeParcelable.Field(getter = "getUserInfos", id = 5)
    private List zze;

    @SafeParcelable.Field(getter = "getProviders", id = 6)
    private List zzf;

    @SafeParcelable.Field(getter = "getCurrentVersion", id = 7)
    private String zzg;

    @SafeParcelable.Field(getter = "isAnonymous", id = 8)
    private Boolean zzh;

    @SafeParcelable.Field(getter = "getMetadata", id = 9)
    private zzz zzi;

    @SafeParcelable.Field(getter = "isNewUser", id = 10)
    private boolean zzj;

    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 11)
    private com.google.firebase.auth.zze zzk;

    @SafeParcelable.Field(getter = "getMultiFactorInfoList", id = 12)
    private zzbb zzl;

    public zzx(FirebaseApp firebaseApp, List list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = "2";
        zzc(list);
    }

    public static FirebaseUser zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzxVar = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzxVar2 = (zzx) firebaseUser;
            zzxVar.zzg = zzxVar2.zzg;
            zzxVar.zzd = zzxVar2.zzd;
            zzxVar.zzi = zzxVar2.zzi;
        } else {
            zzxVar.zzi = null;
        }
        if (firebaseUser.zzd() != null) {
            zzxVar.zzh(firebaseUser.zzd());
        }
        if (!firebaseUser.isAnonymous()) {
            zzxVar.zzm();
        }
        return zzxVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final String getEmail() {
        return this.zzb.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @NonNull
    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @Nullable
    public final String getTenantId() {
        Map map;
        zzza zzzaVar = this.zza;
        if (zzzaVar == null || zzzaVar.zze() == null || (map = (Map) zzay.zza(zzzaVar.zze()).getClaims().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @NonNull
    public final String getUid() {
        return this.zzb.getUid();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean isAnonymous() {
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzza zzzaVar = this.zza;
            String signInProvider = zzzaVar != null ? zzay.zza(zzzaVar.zze()).getSignInProvider() : "";
            boolean z = false;
            if (this.zze.size() <= 1 && (signInProvider == null || !signInProvider.equals(SchedulerSupport.CUSTOM))) {
                z = true;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* bridge */ /* synthetic */ FirebaseUser zzb() {
        zzm();
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final synchronized FirebaseUser zzc(List list) {
        Preconditions.checkNotNull(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals("firebase")) {
                this.zzb = (zzt) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzt) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = (zzt) this.zze.get(0);
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final zzza zzd() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final String zze() {
        return this.zza.zze();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final String zzf() {
        return this.zza.zzh();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @Nullable
    public final List zzg() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzh(zzza zzzaVar) {
        this.zza = (zzza) Preconditions.checkNotNull(zzzaVar);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzi(List list) {
        Parcelable.Creator<zzbb> creator = zzbb.CREATOR;
        zzbb zzbbVar = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                }
            }
            zzbbVar = new zzbb(arrayList);
        }
        this.zzl = zzbbVar;
    }

    @Nullable
    public final com.google.firebase.auth.zze zzj() {
        return this.zzk;
    }

    public final zzx zzl(String str) {
        this.zzg = str;
        return this;
    }

    public final zzx zzm() {
        this.zzh = Boolean.FALSE;
        return this;
    }

    @Nullable
    public final List zzn() {
        zzbb zzbbVar = this.zzl;
        return zzbbVar != null ? zzbbVar.zza() : new ArrayList();
    }

    public final List zzo() {
        return this.zze;
    }

    public final void zzp(@Nullable com.google.firebase.auth.zze zzeVar) {
        this.zzk = zzeVar;
    }

    public final void zzq(boolean z) {
        this.zzj = z;
    }

    public final void zzr(zzz zzzVar) {
        this.zzi = zzzVar;
    }

    public final boolean zzs() {
        return this.zzj;
    }

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 1) zzza zzzaVar, @SafeParcelable.Param(id = 2) zzt zztVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) List list2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Boolean bool, @SafeParcelable.Param(id = 9) zzz zzzVar, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) com.google.firebase.auth.zze zzeVar, @SafeParcelable.Param(id = 12) zzbb zzbbVar) {
        this.zza = zzzaVar;
        this.zzb = zztVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzzVar;
        this.zzj = z;
        this.zzk = zzeVar;
        this.zzl = zzbbVar;
    }
}
