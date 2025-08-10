package com.wear.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FirebaseUserToyInfo.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/wear/bean/FirebaseUserToyInfo;", "", "encryptJid", "", "toys", "", "Lcom/wear/bean/FirebaseToyInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getEncryptJid", "()Ljava/lang/String;", "setEncryptJid", "(Ljava/lang/String;)V", "getToys", "()Ljava/util/List;", "setToys", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FirebaseUserToyInfo {

    @Nullable
    private String encryptJid;

    @Nullable
    private List<FirebaseToyInfo> toys;

    public FirebaseUserToyInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public FirebaseUserToyInfo(@Nullable String str, @Nullable List<FirebaseToyInfo> list) {
        this.encryptJid = str;
        this.toys = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirebaseUserToyInfo copy$default(FirebaseUserToyInfo firebaseUserToyInfo, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firebaseUserToyInfo.encryptJid;
        }
        if ((i & 2) != 0) {
            list = firebaseUserToyInfo.toys;
        }
        return firebaseUserToyInfo.copy(str, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEncryptJid() {
        return this.encryptJid;
    }

    @Nullable
    public final List<FirebaseToyInfo> component2() {
        return this.toys;
    }

    @NotNull
    public final FirebaseUserToyInfo copy(@Nullable String encryptJid, @Nullable List<FirebaseToyInfo> toys) {
        return new FirebaseUserToyInfo(encryptJid, toys);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirebaseUserToyInfo)) {
            return false;
        }
        FirebaseUserToyInfo firebaseUserToyInfo = (FirebaseUserToyInfo) other;
        return Intrinsics.areEqual(this.encryptJid, firebaseUserToyInfo.encryptJid) && Intrinsics.areEqual(this.toys, firebaseUserToyInfo.toys);
    }

    @Nullable
    public final String getEncryptJid() {
        return this.encryptJid;
    }

    @Nullable
    public final List<FirebaseToyInfo> getToys() {
        return this.toys;
    }

    public int hashCode() {
        String str = this.encryptJid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<FirebaseToyInfo> list = this.toys;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setEncryptJid(@Nullable String str) {
        this.encryptJid = str;
    }

    public final void setToys(@Nullable List<FirebaseToyInfo> list) {
        this.toys = list;
    }

    @NotNull
    public String toString() {
        return "FirebaseUserToyInfo(encryptJid=" + this.encryptJid + ", toys=" + this.toys + ')';
    }

    public /* synthetic */ FirebaseUserToyInfo(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list);
    }
}
