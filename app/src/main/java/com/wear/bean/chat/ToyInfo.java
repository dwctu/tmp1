package com.wear.bean.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.wear.bean.Toy;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyInfo.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0017\u001a\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\r¨\u0006'"}, d2 = {"Lcom/wear/bean/chat/ToyInfo;", "Landroid/os/Parcelable;", "deviceType", "", "battery", "status", "control", "", "workMode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBattery", "()Ljava/lang/String;", "setBattery", "(Ljava/lang/String;)V", "getControl", "()Z", "setControl", "(Z)V", "getDeviceType", "fullName", "getFullName$annotations", "()V", "getFullName", "mac", "getMac$annotations", "getMac", "getStatus", "setStatus", "getWorkMode", "setWorkMode", "describeContents", "", "getDeviceTypeMac", "getDeviceTypeSymblo", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToyInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ToyInfo> CREATOR = new Creator();

    @NotNull
    private String battery;
    private boolean control;

    @NotNull
    private final String deviceType;

    @NotNull
    private String status;

    @Nullable
    private String workMode;

    /* compiled from: ToyInfo.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ToyInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ToyInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ToyInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ToyInfo[] newArray(int i) {
            return new ToyInfo[i];
        }
    }

    public ToyInfo() {
        this(null, null, null, false, null, 31, null);
    }

    public ToyInfo(@NotNull String deviceType, @NotNull String battery, @NotNull String status, boolean z, @Nullable String str) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(battery, "battery");
        Intrinsics.checkNotNullParameter(status, "status");
        this.deviceType = deviceType;
        this.battery = battery;
        this.status = status;
        this.control = z;
        this.workMode = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String getDeviceTypeMac(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = com.wear.util.WearUtils.e1(r8)
            if (r0 != 0) goto L61
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r1 = ":"
            r0.<init>(r1)
            r1 = 0
            java.util.List r8 = r0.split(r8, r1)
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L42
            int r0 = r8.size()
            java.util.ListIterator r0 = r8.listIterator(r0)
        L20:
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L42
            java.lang.Object r2 = r0.previous()
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.length()
            r3 = 1
            if (r2 != 0) goto L35
            r2 = 1
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 != 0) goto L20
            int r0 = r0.nextIndex()
            int r0 = r0 + r3
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.take(r8, r0)
            goto L46
        L42:
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L46:
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r8 = r8.toArray(r0)
            java.lang.String[] r8 = (java.lang.String[]) r8
            int r0 = r8.length
            r1 = 3
            if (r0 != r1) goto L61
            r0 = 2
            r1 = r8[r0]
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r2 = ";"
            java.lang.String r3 = ""
            java.lang.String r8 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r1, r2, r3, r4, r5, r6)
            goto L63
        L61:
            java.lang.String r8 = ""
        L63:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.chat.ToyInfo.getDeviceTypeMac(java.lang.String):java.lang.String");
    }

    public static /* synthetic */ void getFullName$annotations() {
    }

    public static /* synthetic */ void getMac$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getBattery() {
        return this.battery;
    }

    public final boolean getControl() {
        return this.control;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getDeviceTypeSymblo(@org.jetbrains.annotations.NotNull java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "deviceType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = com.wear.util.WearUtils.e1(r10)
            if (r0 != 0) goto L65
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r1 = ":"
            r0.<init>(r1)
            r1 = 0
            java.util.List r10 = r0.split(r10, r1)
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto L47
            int r0 = r10.size()
            java.util.ListIterator r0 = r10.listIterator(r0)
        L25:
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L47
            java.lang.Object r2 = r0.previous()
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.length()
            r3 = 1
            if (r2 != 0) goto L3a
            r2 = 1
            goto L3b
        L3a:
            r2 = 0
        L3b:
            if (r2 != 0) goto L25
            int r0 = r0.nextIndex()
            int r0 = r0 + r3
            java.util.List r10 = kotlin.collections.CollectionsKt___CollectionsKt.take(r10, r0)
            goto L4b
        L47:
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L4b:
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r10 = r10.toArray(r0)
            java.lang.String[] r10 = (java.lang.String[]) r10
            int r0 = r10.length
            r2 = 3
            if (r0 != r2) goto L65
            r3 = r10[r1]
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r4 = ";"
            java.lang.String r5 = ""
            java.lang.String r10 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r3, r4, r5, r6, r7, r8)
            goto L67
        L65:
            java.lang.String r10 = ""
        L67:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.chat.ToyInfo.getDeviceTypeSymblo(java.lang.String):java.lang.String");
    }

    @NotNull
    public final String getFullName() {
        String deviceTypeSymblo = getDeviceTypeSymblo(this.deviceType);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = deviceTypeSymblo.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String fullName = Toy.getFullName(lowerCase);
        Intrinsics.checkNotNullExpressionValue(fullName, "getFullName(getDeviceTyp…ase(Locale.getDefault()))");
        return fullName;
    }

    @NotNull
    public final String getMac() {
        return getDeviceTypeMac(this.deviceType);
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getWorkMode() {
        return this.workMode;
    }

    public final void setBattery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.battery = str;
    }

    public final void setControl(boolean z) {
        this.control = z;
    }

    public final void setStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setWorkMode(@Nullable String str) {
        this.workMode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.deviceType);
        parcel.writeString(this.battery);
        parcel.writeString(this.status);
        parcel.writeInt(this.control ? 1 : 0);
        parcel.writeString(this.workMode);
    }

    public /* synthetic */ ToyInfo(String str, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : str4);
    }
}
