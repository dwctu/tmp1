package com.wear.bean;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotificationBean.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006#"}, d2 = {"Lcom/wear/bean/NotificationWrapper;", "", "notificationId", "", "notificationType", "Lcom/wear/bean/NotificationType;", "number", "contentText", "", "intent", "Landroid/content/Intent;", "contentTitle", "(ILcom/wear/bean/NotificationType;ILjava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V", "getContentText", "()Ljava/lang/String;", "getContentTitle", "getIntent", "()Landroid/content/Intent;", "getNotificationId", "()I", "getNotificationType", "()Lcom/wear/bean/NotificationType;", "getNumber", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NotificationWrapper {

    @NotNull
    private final String contentText;

    @Nullable
    private final String contentTitle;

    @NotNull
    private final Intent intent;
    private final int notificationId;

    @NotNull
    private final NotificationType notificationType;
    private final int number;

    public NotificationWrapper(int i, @NotNull NotificationType notificationType, int i2, @NotNull String contentText, @NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(notificationType, "notificationType");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.notificationId = i;
        this.notificationType = notificationType;
        this.number = i2;
        this.contentText = contentText;
        this.intent = intent;
        this.contentTitle = str;
    }

    public static /* synthetic */ NotificationWrapper copy$default(NotificationWrapper notificationWrapper, int i, NotificationType notificationType, int i2, String str, Intent intent, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = notificationWrapper.notificationId;
        }
        if ((i3 & 2) != 0) {
            notificationType = notificationWrapper.notificationType;
        }
        NotificationType notificationType2 = notificationType;
        if ((i3 & 4) != 0) {
            i2 = notificationWrapper.number;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str = notificationWrapper.contentText;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            intent = notificationWrapper.intent;
        }
        Intent intent2 = intent;
        if ((i3 & 32) != 0) {
            str2 = notificationWrapper.contentTitle;
        }
        return notificationWrapper.copy(i, notificationType2, i4, str3, intent2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNotificationId() {
        return this.notificationId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final NotificationType getNotificationType() {
        return this.notificationType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getContentText() {
        return this.contentText;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final Intent getIntent() {
        return this.intent;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @NotNull
    public final NotificationWrapper copy(int notificationId, @NotNull NotificationType notificationType, int number, @NotNull String contentText, @NotNull Intent intent, @Nullable String contentTitle) {
        Intrinsics.checkNotNullParameter(notificationType, "notificationType");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(intent, "intent");
        return new NotificationWrapper(notificationId, notificationType, number, contentText, intent, contentTitle);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationWrapper)) {
            return false;
        }
        NotificationWrapper notificationWrapper = (NotificationWrapper) other;
        return this.notificationId == notificationWrapper.notificationId && this.notificationType == notificationWrapper.notificationType && this.number == notificationWrapper.number && Intrinsics.areEqual(this.contentText, notificationWrapper.contentText) && Intrinsics.areEqual(this.intent, notificationWrapper.intent) && Intrinsics.areEqual(this.contentTitle, notificationWrapper.contentTitle);
    }

    @NotNull
    public final String getContentText() {
        return this.contentText;
    }

    @Nullable
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @NotNull
    public final Intent getIntent() {
        return this.intent;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    @NotNull
    public final NotificationType getNotificationType() {
        return this.notificationType;
    }

    public final int getNumber() {
        return this.number;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.notificationId * 31) + this.notificationType.hashCode()) * 31) + this.number) * 31) + this.contentText.hashCode()) * 31) + this.intent.hashCode()) * 31;
        String str = this.contentTitle;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "NotificationWrapper(notificationId=" + this.notificationId + ", notificationType=" + this.notificationType + ", number=" + this.number + ", contentText=" + this.contentText + ", intent=" + this.intent + ", contentTitle=" + this.contentTitle + ')';
    }

    public /* synthetic */ NotificationWrapper(int i, NotificationType notificationType, int i2, String str, Intent intent, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, notificationType, i2, str, intent, (i3 & 32) != 0 ? null : str2);
    }
}
