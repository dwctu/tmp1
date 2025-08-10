package com.wear.ui.chat.action.im;

import com.google.firebase.analytics.FirebaseAnalytics;
import dc.nd3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AESMessageEncryption.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/wear/ui/chat/action/im/AESMessageEncryption;", "Lcom/wear/ui/chat/action/im/MessageEncryption;", "()V", "decode", "", FirebaseAnalytics.Param.CONTENT, "param", "encode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AESMessageEncryption implements MessageEncryption {
    @Override // com.wear.ui.chat.action.im.MessageEncryption
    @Nullable
    public String decode(@NotNull String content, @Nullable String param) {
        Intrinsics.checkNotNullParameter(content, "content");
        return nd3.d(content);
    }

    @Override // com.wear.ui.chat.action.im.MessageEncryption
    @Nullable
    public String encode(@NotNull String content, @Nullable String param) {
        Intrinsics.checkNotNullParameter(content, "content");
        return nd3.n(content);
    }
}
