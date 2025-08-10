package org.apache.cordova.gallery;

import androidx.appcompat.app.AppCompatActivity;
import com.wear.ui.discover.xremote.activity.XRemoteActivity;
import dc.s23;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.errcode.ErrorCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: AppBaseInfoPlugin.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\r"}, d2 = {"Lorg/apache/cordova/gallery/AppBaseInfoPlugin;", "Lorg/apache/cordova/CordovaPlugin;", "()V", "execute", "", AMPExtension.Action.ATTRIBUTE_NAME, "", "args", "Lorg/json/JSONArray;", "callbackContext", "Lorg/apache/cordova/CallbackContext;", "getAppBaseInfo", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AppBaseInfoPlugin extends CordovaPlugin {
    private final void getAppBaseInfo(CallbackContext callbackContext) {
        AppCompatActivity activity = this.cordova.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.wear.ui.discover.xremote.activity.XRemoteActivity");
        ((XRemoteActivity) activity).U4(callbackContext);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(@Nullable String action, @NotNull JSONArray args, @Nullable CallbackContext callbackContext) throws JSONException {
        Intrinsics.checkNotNullParameter(args, "args");
        String str = "action====" + action;
        if (!Intrinsics.areEqual(action, "getAppBaseInfo")) {
            return false;
        }
        try {
            getAppBaseInfo(callbackContext);
            return true;
        } catch (Exception e) {
            if (callbackContext != null) {
                callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
            }
            e.printStackTrace();
            return true;
        }
    }
}
