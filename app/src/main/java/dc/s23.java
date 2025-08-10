package dc;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.errcode.ErrorCode;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonCodeUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/ui/discover/xremote/utils/CommonCodeUtils;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class s23 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: CommonCodeUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/discover/xremote/utils/CommonCodeUtils$Companion;", "", "()V", "setErrorCode", "Lorg/json/JSONObject;", "errorCode", "Lorg/apache/cordova/errcode/ErrorCode;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JSONObject a(@NotNull ErrorCode errorCode) throws JSONException {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(XHTMLText.CODE, errorCode.getCode());
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, errorCode.getMessage());
            return jSONObject;
        }
    }
}
