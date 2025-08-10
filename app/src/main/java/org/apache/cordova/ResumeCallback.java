package org.apache.cordova;

import java.util.ArrayList;
import org.apache.cordova.PluginResult;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ResumeCallback extends CallbackContext {
    private final String TAG;
    private PluginManager pluginManager;
    private String serviceName;

    public ResumeCallback(String str, PluginManager pluginManager) {
        super("resumecallback", null);
        this.TAG = "CordovaResumeCallback";
        this.serviceName = str;
        this.pluginManager = pluginManager;
    }

    @Override // org.apache.cordova.CallbackContext
    public void sendPluginResult(PluginResult pluginResult) throws JSONException {
        synchronized (this) {
            if (this.finished) {
                LOG.w("CordovaResumeCallback", this.serviceName + " attempted to send a second callback to ResumeCallback\nResult was: " + pluginResult.getMessage());
                return;
            }
            this.finished = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("pluginServiceName", this.serviceName);
                jSONObject2.put("pluginStatus", PluginResult.StatusMessages[pluginResult.getStatus()]);
                jSONObject.put(AMPExtension.Action.ATTRIBUTE_NAME, StreamManagement.Resume.ELEMENT);
                jSONObject.put("pendingResult", jSONObject2);
            } catch (JSONException unused) {
                LOG.e("CordovaResumeCallback", "Unable to create resume object for Activity Result");
            }
            PluginResult.Status status = PluginResult.Status.OK;
            PluginResult pluginResult2 = new PluginResult(status, jSONObject);
            ArrayList arrayList = new ArrayList();
            arrayList.add(pluginResult2);
            arrayList.add(pluginResult);
            ((CoreAndroid) this.pluginManager.getPlugin(CoreAndroid.PLUGIN_NAME)).sendResumeEvent(new PluginResult(status, arrayList));
        }
    }
}
