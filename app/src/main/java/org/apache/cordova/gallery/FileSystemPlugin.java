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

/* compiled from: FileSystemPlugin.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000e"}, d2 = {"Lorg/apache/cordova/gallery/FileSystemPlugin;", "Lorg/apache/cordova/CordovaPlugin;", "()V", "execute", "", AMPExtension.Action.ATTRIBUTE_NAME, "", "args", "Lorg/json/JSONArray;", "callbackContext", "Lorg/apache/cordova/CallbackContext;", "saveImageToPhotosAlbum", "", "fileData", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemPlugin extends CordovaPlugin {
    private final void saveImageToPhotosAlbum(String fileData, CallbackContext callbackContext) {
        AppCompatActivity activity = this.cordova.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.wear.ui.discover.xremote.activity.XRemoteActivity");
        ((XRemoteActivity) activity).w5(fileData, callbackContext);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(@Nullable String action, @NotNull JSONArray args, @Nullable CallbackContext callbackContext) throws JSONException {
        Intrinsics.checkNotNullParameter(args, "args");
        String str = "action====" + action;
        if (!Intrinsics.areEqual(action, "saveImageToPhotosAlbum")) {
            return false;
        }
        try {
            String string = args.getJSONObject(0).getString("fileData");
            Intrinsics.checkNotNullExpressionValue(string, "message.getString(\"fileData\")");
            saveImageToPhotosAlbum(string, callbackContext);
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
