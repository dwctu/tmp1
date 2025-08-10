package com.wear.ui.chat.action.im;

import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.at2;
import dc.bu1;
import dc.ch3;
import dc.eg3;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DHMessageEncryption.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/wear/ui/chat/action/im/DHMessageEncryption;", "Lcom/wear/ui/chat/action/im/MessageEncryption;", "()V", "decode", "", FirebaseAnalytics.Param.CONTENT, "param", "encode", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DHMessageEncryption implements MessageEncryption {

    @NotNull
    private static final String TAG = "DHMessageEncryption";

    @Override // com.wear.ui.chat.action.im.MessageEncryption
    @Nullable
    public String decode(@NotNull String content, @Nullable String param) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            String strH = eg3.h(bu1.a(), ch3.n().o().getAppAccountCode() + "_toyRoulettePrimary", null);
            if (!(param == null || param.length() == 0)) {
                if (!(strH == null || strH.length() == 0)) {
                    byte[] publicKey = Base64.decode(param, 2);
                    byte[] primaryKey = Base64.decode(strH, 2);
                    at2 at2Var = at2.a;
                    Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
                    Intrinsics.checkNotNullExpressionValue(primaryKey, "primaryKey");
                    byte[] bArrE = at2Var.e(publicKey, primaryKey);
                    byte[] base64String = Base64.decode(content, 2);
                    Intrinsics.checkNotNullExpressionValue(base64String, "base64String");
                    return new String(at2Var.a(base64String, bArrE), Charsets.UTF_8);
                }
            }
            String str = "encode: 解密失败，无法获取用户秘钥：publicKey=" + param + ",primaryKey=" + strH;
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return "unDecode message content";
        }
    }

    @Override // com.wear.ui.chat.action.im.MessageEncryption
    @Nullable
    public String encode(@NotNull String content, @Nullable String param) throws IllegalStateException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(content, "content");
        String strH = eg3.h(bu1.a(), ch3.n().o().getAppAccountCode() + "_toyRoulettePrimary", null);
        if (!(param == null || param.length() == 0)) {
            if (!(strH == null || strH.length() == 0)) {
                byte[] publicKey = Base64.decode(param, 2);
                byte[] primaryKey = Base64.decode(strH, 2);
                at2 at2Var = at2.a;
                Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
                Intrinsics.checkNotNullExpressionValue(primaryKey, "primaryKey");
                byte[] bArrE = at2Var.e(publicKey, primaryKey);
                byte[] bytes = content.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return Base64.encodeToString(at2Var.b(bytes, bArrE), 2);
            }
        }
        String str = "encode: 加密失败，无法获取用户秘钥：publicKey=" + param + ",primaryKey=" + strH;
        return null;
    }
}
