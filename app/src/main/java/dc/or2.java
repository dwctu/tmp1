package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.bean.chat.RouletteUser;
import com.wear.dao.DaoUtils;
import com.wear.ui.chat.action.im.AESMessageEncryption;
import com.wear.ui.chat.action.im.DHMessageEncryption;
import com.wear.ui.chat.action.im.MessageEncryption;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageCodingAction.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004J&\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/wear/ui/chat/action/MessageCodingAction;", "", "()V", "TYPE_MESSAGE_AES", "", "TYPE_MESSAGE_DH", "TYPE_MESSAGE_NONE", "messageEncryption", "Lcom/wear/ui/chat/action/im/MessageEncryption;", "decode", "userAccountCode", FirebaseAnalytics.Param.CONTENT, "encryptionMode", "encode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class or2 {

    @NotNull
    public static final or2 a = new or2();

    @Nullable
    public static MessageEncryption b;

    @Nullable
    public final String a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str2 == null || str2.length() == 0) {
            return str2;
        }
        if (str3 == null || str3.length() == 0) {
            str3 = "NONE";
        }
        int iHashCode = str3.hashCode();
        if (iHashCode == 2180) {
            if (str3.equals("DH")) {
                if (b == null) {
                    b = new DHMessageEncryption();
                }
                RouletteUser rouletteUserFindRouletteUser = DaoUtils.getRouletteUserDao().findRouletteUser(str);
                if (rouletteUserFindRouletteUser == null) {
                    return null;
                }
                MessageEncryption messageEncryption = b;
                if (messageEncryption != null) {
                    return messageEncryption.decode(str2, rouletteUserFindRouletteUser.getPublicKey());
                }
                return null;
            }
            return "不支持的加密方式";
        }
        if (iHashCode != 64687) {
            if (iHashCode == 2402104 && str3.equals("NONE")) {
                return str2;
            }
        } else if (str3.equals("AES")) {
            if (b == null) {
                b = new AESMessageEncryption();
            }
            MessageEncryption messageEncryption2 = b;
            if (messageEncryption2 != null) {
                return messageEncryption2.decode(str2, null);
            }
            return null;
        }
        return "不支持的加密方式";
    }

    @Nullable
    public final String b(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str == null || str.length() == 0) {
            return str2;
        }
        if (str2 == null || str2.length() == 0) {
            return str2;
        }
        if (str3 == null || str3.length() == 0) {
            str3 = "NONE";
        }
        int iHashCode = str3.hashCode();
        if (iHashCode == 2180) {
            if (str3.equals("DH")) {
                if (b == null) {
                    b = new DHMessageEncryption();
                }
                RouletteUser rouletteUserFindRouletteUser = DaoUtils.getRouletteUserDao().findRouletteUser(str);
                if (rouletteUserFindRouletteUser == null) {
                    return null;
                }
                MessageEncryption messageEncryption = b;
                if (messageEncryption != null) {
                    return messageEncryption.encode(str2, rouletteUserFindRouletteUser.getPublicKey());
                }
                return null;
            }
            return "不支持的加密方式";
        }
        if (iHashCode != 64687) {
            if (iHashCode == 2402104 && str3.equals("NONE")) {
                return str2;
            }
        } else if (str3.equals("AES")) {
            if (b == null) {
                b = new AESMessageEncryption();
            }
            MessageEncryption messageEncryption2 = b;
            if (messageEncryption2 != null) {
                return messageEncryption2.encode(str2, null);
            }
            return null;
        }
        return "不支持的加密方式";
    }
}
