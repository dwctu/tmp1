package com.wear.ui.chat.action.im;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageEncryption.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/chat/action/im/MessageEncryption;", "", "decode", "", FirebaseAnalytics.Param.CONTENT, "param", "encode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface MessageEncryption {

    /* compiled from: MessageEncryption.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ String decode$default(MessageEncryption messageEncryption, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return messageEncryption.decode(str, str2);
        }

        public static /* synthetic */ String encode$default(MessageEncryption messageEncryption, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return messageEncryption.encode(str, str2);
        }
    }

    @Nullable
    String decode(@NotNull String content, @Nullable String param);

    @Nullable
    String encode(@NotNull String content, @Nullable String param);
}
