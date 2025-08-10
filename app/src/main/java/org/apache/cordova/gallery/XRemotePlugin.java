package org.apache.cordova.gallery;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.JsonSyntaxException;
import com.wear.ui.discover.xremote.activity.XRemoteActivity;
import dc.s23;
import dc.sg3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.errcode.ErrorCode;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: XRemotePlugin.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0012"}, d2 = {"Lorg/apache/cordova/gallery/XRemotePlugin;", "Lorg/apache/cordova/CordovaPlugin;", "()V", "authorizedLogin", "", "message", "", "callbackContext", "Lorg/apache/cordova/CallbackContext;", "execute", "", AMPExtension.Action.ATTRIBUTE_NAME, "args", "Lorg/json/JSONArray;", "getAppAccountInfoV2", "getScope", "getScopeList", "toast", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class XRemotePlugin extends CordovaPlugin {
    private final void authorizedLogin(String message, CallbackContext callbackContext) {
        AppCompatActivity activity = this.cordova.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.wear.ui.discover.xremote.activity.XRemoteActivity");
        ((XRemoteActivity) activity).S4(message, callbackContext);
    }

    private final void getAppAccountInfoV2(String message, CallbackContext callbackContext) {
        AppCompatActivity activity = this.cordova.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.wear.ui.discover.xremote.activity.XRemoteActivity");
        ((XRemoteActivity) activity).T4(message, callbackContext);
    }

    private final void getScope(String message, CallbackContext callbackContext) {
        AppCompatActivity activity = this.cordova.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.wear.ui.discover.xremote.activity.XRemoteActivity");
        ((XRemoteActivity) activity).a5(message, callbackContext);
    }

    private final void getScopeList(CallbackContext callbackContext) throws JSONException, JsonSyntaxException {
        AppCompatActivity activity = this.cordova.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.wear.ui.discover.xremote.activity.XRemoteActivity");
        ((XRemoteActivity) activity).d5(callbackContext);
    }

    private final void toast(String message) {
        if (message != null) {
            sg3.l(message);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(@NotNull String action, @NotNull JSONArray args, @NotNull CallbackContext callbackContext) throws JSONException {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callbackContext, "callbackContext");
        switch (action.hashCode()) {
            case -1322888562:
                if (action.equals("authorizedLogin")) {
                    try {
                        authorizedLogin(args.getJSONObject(0).getString("applicationId"), callbackContext);
                    } catch (Exception e) {
                        callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
                        e.printStackTrace();
                    }
                    return true;
                }
                return false;
            case -785307349:
                if (action.equals("getAuthCode")) {
                    try {
                        JSONObject jSONObject = args.getJSONObject(0);
                        getAppAccountInfoV2(jSONObject.getString("scope"), callbackContext);
                        String str = "getAuthCode: " + jSONObject;
                    } catch (Exception e2) {
                        callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
                        e2.printStackTrace();
                    }
                    return true;
                }
                return false;
            case 110532135:
                if (action.equals("toast")) {
                    toast(args.getString(0));
                    return true;
                }
                return false;
            case 639820370:
                if (action.equals("getAuthSetting")) {
                    try {
                        getScopeList(callbackContext);
                    } catch (Exception e3) {
                        callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
                        e3.printStackTrace();
                    }
                    return true;
                }
                return false;
            case 1475610601:
                if (action.equals("authorize")) {
                    try {
                        getScope(args.getJSONObject(0).getString("scope"), callbackContext);
                    } catch (Exception e4) {
                        callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
                        e4.printStackTrace();
                    }
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}
