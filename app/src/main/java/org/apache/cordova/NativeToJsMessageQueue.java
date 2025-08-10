package org.apache.cordova;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.cordova.PluginResult;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes5.dex */
public class NativeToJsMessageQueue {
    private static int COMBINED_RESPONSE_CUTOFF = 16777216;
    public static final boolean DISABLE_EXEC_CHAINING = false;
    private static final boolean FORCE_ENCODE_USING_EVAL = false;
    private static final String LOG_TAG = "JsMessageQueue";
    private BridgeMode activeBridgeMode;
    private boolean paused;
    private final LinkedList<JsMessage> queue = new LinkedList<>();
    private ArrayList<BridgeMode> bridgeModes = new ArrayList<>();

    public static abstract class BridgeMode {
        public void notifyOfFlush(NativeToJsMessageQueue nativeToJsMessageQueue, boolean z) {
        }

        public abstract void onNativeToJsMessageAvailable(NativeToJsMessageQueue nativeToJsMessageQueue);

        public void reset() {
        }
    }

    public static class EvalBridgeMode extends BridgeMode {
        private final CordovaInterface cordova;
        private final CordovaWebViewEngine engine;

        public EvalBridgeMode(CordovaWebViewEngine cordovaWebViewEngine, CordovaInterface cordovaInterface) {
            this.engine = cordovaWebViewEngine;
            this.cordova = cordovaInterface;
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue nativeToJsMessageQueue) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.NativeToJsMessageQueue.EvalBridgeMode.1
                @Override // java.lang.Runnable
                public void run() {
                    String strPopAndEncodeAsJs = nativeToJsMessageQueue.popAndEncodeAsJs();
                    if (strPopAndEncodeAsJs != null) {
                        EvalBridgeMode.this.engine.evaluateJavascript(strPopAndEncodeAsJs, null);
                    }
                }
            });
        }
    }

    public static class LoadUrlBridgeMode extends BridgeMode {
        private final CordovaInterface cordova;
        private final CordovaWebViewEngine engine;

        public LoadUrlBridgeMode(CordovaWebViewEngine cordovaWebViewEngine, CordovaInterface cordovaInterface) {
            this.engine = cordovaWebViewEngine;
            this.cordova = cordovaInterface;
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue nativeToJsMessageQueue) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.NativeToJsMessageQueue.LoadUrlBridgeMode.1
                @Override // java.lang.Runnable
                public void run() {
                    String strPopAndEncodeAsJs = nativeToJsMessageQueue.popAndEncodeAsJs();
                    if (strPopAndEncodeAsJs != null) {
                        LoadUrlBridgeMode.this.engine.loadUrl("javascript:" + strPopAndEncodeAsJs, false);
                    }
                }
            });
        }
    }

    public static class NoOpBridgeMode extends BridgeMode {
        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable(NativeToJsMessageQueue nativeToJsMessageQueue) {
        }
    }

    public static class OnlineEventsBridgeMode extends BridgeMode {
        private final OnlineEventsBridgeModeDelegate delegate;
        private boolean ignoreNextFlush;
        private boolean online;

        public interface OnlineEventsBridgeModeDelegate {
            void runOnUiThread(Runnable runnable);

            void setNetworkAvailable(boolean z);
        }

        public OnlineEventsBridgeMode(OnlineEventsBridgeModeDelegate onlineEventsBridgeModeDelegate) {
            this.delegate = onlineEventsBridgeModeDelegate;
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void notifyOfFlush(NativeToJsMessageQueue nativeToJsMessageQueue, boolean z) {
            if (!z || this.ignoreNextFlush) {
                return;
            }
            this.online = !this.online;
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue nativeToJsMessageQueue) {
            this.delegate.runOnUiThread(new Runnable() { // from class: org.apache.cordova.NativeToJsMessageQueue.OnlineEventsBridgeMode.2
                @Override // java.lang.Runnable
                public void run() {
                    if (nativeToJsMessageQueue.isEmpty()) {
                        return;
                    }
                    OnlineEventsBridgeMode.this.ignoreNextFlush = false;
                    OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(OnlineEventsBridgeMode.this.online);
                }
            });
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void reset() {
            this.delegate.runOnUiThread(new Runnable() { // from class: org.apache.cordova.NativeToJsMessageQueue.OnlineEventsBridgeMode.1
                @Override // java.lang.Runnable
                public void run() {
                    OnlineEventsBridgeMode.this.online = false;
                    OnlineEventsBridgeMode.this.ignoreNextFlush = true;
                    OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(true);
                }
            });
        }
    }

    private int calculatePackedMessageLength(JsMessage jsMessage) {
        int iCalculateEncodedLength = jsMessage.calculateEncodedLength();
        return String.valueOf(iCalculateEncodedLength).length() + iCalculateEncodedLength + 1;
    }

    private void enqueueMessage(JsMessage jsMessage) {
        synchronized (this) {
            if (this.activeBridgeMode == null) {
                LOG.d(LOG_TAG, "Dropping Native->JS message due to disabled bridge");
                return;
            }
            this.queue.add(jsMessage);
            if (!this.paused) {
                this.activeBridgeMode.onNativeToJsMessageAvailable(this);
            }
        }
    }

    private void packMessage(JsMessage jsMessage, StringBuilder sb) {
        sb.append(jsMessage.calculateEncodedLength());
        sb.append(' ');
        jsMessage.encodeAsMessage(sb);
    }

    public void addBridgeMode(BridgeMode bridgeMode) {
        this.bridgeModes.add(bridgeMode);
    }

    public void addJavaScript(String str) {
        enqueueMessage(new JsMessage(str));
    }

    public void addPluginResult(PluginResult pluginResult, String str) {
        if (str == null) {
            LOG.e(LOG_TAG, "Got plugin result with no callbackId", new Throwable());
            return;
        }
        boolean z = pluginResult.getStatus() == PluginResult.Status.NO_RESULT.ordinal();
        boolean keepCallback = pluginResult.getKeepCallback();
        if (z && keepCallback) {
            return;
        }
        enqueueMessage(new JsMessage(pluginResult, str));
    }

    public boolean isBridgeEnabled() {
        return this.activeBridgeMode != null;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public String popAndEncode(boolean z) {
        int i;
        synchronized (this) {
            BridgeMode bridgeMode = this.activeBridgeMode;
            if (bridgeMode == null) {
                return null;
            }
            bridgeMode.notifyOfFlush(this, z);
            if (this.queue.isEmpty()) {
                return null;
            }
            Iterator<JsMessage> it = this.queue.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                int iCalculatePackedMessageLength = calculatePackedMessageLength(it.next());
                if (i2 > 0 && (i = COMBINED_RESPONSE_CUTOFF) > 0 && i3 + iCalculatePackedMessageLength > i) {
                    break;
                }
                i3 += iCalculatePackedMessageLength;
                i2++;
            }
            StringBuilder sb = new StringBuilder(i3);
            for (int i4 = 0; i4 < i2; i4++) {
                packMessage(this.queue.removeFirst(), sb);
            }
            if (!this.queue.isEmpty()) {
                sb.append('*');
            }
            return sb.toString();
        }
    }

    public String popAndEncodeAsJs() {
        int i;
        synchronized (this) {
            if (this.queue.size() == 0) {
                return null;
            }
            Iterator<JsMessage> it = this.queue.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                int iCalculateEncodedLength = it.next().calculateEncodedLength() + 50;
                if (i2 > 0 && (i = COMBINED_RESPONSE_CUTOFF) > 0 && i3 + iCalculateEncodedLength > i) {
                    break;
                }
                i3 += iCalculateEncodedLength;
                i2++;
            }
            int i4 = i2 == this.queue.size() ? 1 : 0;
            StringBuilder sb = new StringBuilder(i3 + (i4 != 0 ? 0 : 100));
            for (int i5 = 0; i5 < i2; i5++) {
                JsMessage jsMessageRemoveFirst = this.queue.removeFirst();
                if (i4 == 0 || i5 + 1 != i2) {
                    sb.append("try{");
                    jsMessageRemoveFirst.encodeAsJsMessage(sb);
                    sb.append("}finally{");
                } else {
                    jsMessageRemoveFirst.encodeAsJsMessage(sb);
                }
            }
            if (i4 == 0) {
                sb.append("window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);");
            }
            while (i4 < i2) {
                sb.append(MessageFormatter.DELIM_STOP);
                i4++;
            }
            return sb.toString();
        }
    }

    public void reset() {
        synchronized (this) {
            this.queue.clear();
            setBridgeMode(-1);
        }
    }

    public void setBridgeMode(int i) {
        if (i < -1 || i >= this.bridgeModes.size()) {
            LOG.d(LOG_TAG, "Invalid NativeToJsBridgeMode: " + i);
            return;
        }
        BridgeMode bridgeMode = i < 0 ? null : this.bridgeModes.get(i);
        if (bridgeMode != this.activeBridgeMode) {
            StringBuilder sb = new StringBuilder();
            sb.append("Set native->JS mode to ");
            sb.append(bridgeMode == null ? "null" : bridgeMode.getClass().getSimpleName());
            LOG.d(LOG_TAG, sb.toString());
            synchronized (this) {
                this.activeBridgeMode = bridgeMode;
                if (bridgeMode != null) {
                    bridgeMode.reset();
                    if (!this.paused && !this.queue.isEmpty()) {
                        bridgeMode.onNativeToJsMessageAvailable(this);
                    }
                }
            }
        }
    }

    public void setPaused(boolean z) {
        BridgeMode bridgeMode;
        if (this.paused && z) {
            LOG.e(LOG_TAG, "nested call to setPaused detected.", new Throwable());
        }
        this.paused = z;
        if (z) {
            return;
        }
        synchronized (this) {
            if (!this.queue.isEmpty() && (bridgeMode = this.activeBridgeMode) != null) {
                bridgeMode.onNativeToJsMessageAvailable(this);
            }
        }
    }

    public static class JsMessage {
        public final String jsPayloadOrCallbackId;
        public final PluginResult pluginResult;

        public JsMessage(String str) {
            Objects.requireNonNull(str);
            this.jsPayloadOrCallbackId = str;
            this.pluginResult = null;
        }

        public static int calculateEncodedLengthHelper(PluginResult pluginResult) {
            switch (pluginResult.getMessageType()) {
                case 1:
                    return pluginResult.getStrMessage().length() + 1;
                case 2:
                default:
                    return pluginResult.getMessage().length();
                case 3:
                    return pluginResult.getMessage().length() + 1;
                case 4:
                case 5:
                    return 1;
                case 6:
                    return pluginResult.getMessage().length() + 1;
                case 7:
                    return pluginResult.getMessage().length() + 1;
                case 8:
                    int length = 1;
                    for (int i = 0; i < pluginResult.getMultipartMessagesSize(); i++) {
                        int iCalculateEncodedLengthHelper = calculateEncodedLengthHelper(pluginResult.getMultipartMessage(i));
                        length += String.valueOf(iCalculateEncodedLengthHelper).length() + 1 + iCalculateEncodedLengthHelper;
                    }
                    return length;
            }
        }

        public static void encodeAsMessageHelper(StringBuilder sb, PluginResult pluginResult) {
            switch (pluginResult.getMessageType()) {
                case 1:
                    sb.append('s');
                    sb.append(pluginResult.getStrMessage());
                    break;
                case 2:
                default:
                    sb.append(pluginResult.getMessage());
                    break;
                case 3:
                    sb.append('n');
                    sb.append(pluginResult.getMessage());
                    break;
                case 4:
                    sb.append(pluginResult.getMessage().charAt(0));
                    break;
                case 5:
                    sb.append('N');
                    break;
                case 6:
                    sb.append('A');
                    sb.append(pluginResult.getMessage());
                    break;
                case 7:
                    sb.append('S');
                    sb.append(pluginResult.getMessage());
                    break;
                case 8:
                    sb.append('M');
                    for (int i = 0; i < pluginResult.getMultipartMessagesSize(); i++) {
                        PluginResult multipartMessage = pluginResult.getMultipartMessage(i);
                        sb.append(String.valueOf(calculateEncodedLengthHelper(multipartMessage)));
                        sb.append(' ');
                        encodeAsMessageHelper(sb, multipartMessage);
                    }
                    break;
            }
        }

        public void buildJsMessage(StringBuilder sb) {
            int messageType = this.pluginResult.getMessageType();
            if (messageType == 5) {
                sb.append("null");
                return;
            }
            if (messageType == 6) {
                sb.append("cordova.require('cordova/base64').toArrayBuffer('");
                sb.append(this.pluginResult.getMessage());
                sb.append("')");
                return;
            }
            if (messageType == 7) {
                sb.append("atob('");
                sb.append(this.pluginResult.getMessage());
                sb.append("')");
            } else {
                if (messageType != 8) {
                    sb.append(this.pluginResult.getMessage());
                    return;
                }
                int multipartMessagesSize = this.pluginResult.getMultipartMessagesSize();
                for (int i = 0; i < multipartMessagesSize; i++) {
                    new JsMessage(this.pluginResult.getMultipartMessage(i), this.jsPayloadOrCallbackId).buildJsMessage(sb);
                    if (i < multipartMessagesSize - 1) {
                        sb.append(",");
                    }
                }
            }
        }

        public int calculateEncodedLength() {
            PluginResult pluginResult = this.pluginResult;
            return pluginResult == null ? this.jsPayloadOrCallbackId.length() + 1 : String.valueOf(pluginResult.getStatus()).length() + 2 + 1 + this.jsPayloadOrCallbackId.length() + 1 + calculateEncodedLengthHelper(this.pluginResult);
        }

        public void encodeAsJsMessage(StringBuilder sb) {
            PluginResult pluginResult = this.pluginResult;
            if (pluginResult == null) {
                sb.append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = pluginResult.getStatus();
            boolean z = status == PluginResult.Status.OK.ordinal() || status == PluginResult.Status.NO_RESULT.ordinal();
            sb.append("cordova.callbackFromNative('");
            sb.append(this.jsPayloadOrCallbackId);
            sb.append("',");
            sb.append(z);
            sb.append(",");
            sb.append(status);
            sb.append(",[");
            buildJsMessage(sb);
            sb.append("],");
            sb.append(this.pluginResult.getKeepCallback());
            sb.append(");");
        }

        public void encodeAsMessage(StringBuilder sb) {
            PluginResult pluginResult = this.pluginResult;
            if (pluginResult == null) {
                sb.append('J');
                sb.append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = pluginResult.getStatus();
            boolean z = status == PluginResult.Status.NO_RESULT.ordinal();
            boolean z2 = status == PluginResult.Status.OK.ordinal();
            boolean keepCallback = this.pluginResult.getKeepCallback();
            sb.append((z || z2) ? 'S' : 'F');
            sb.append(keepCallback ? '1' : '0');
            sb.append(status);
            sb.append(' ');
            sb.append(this.jsPayloadOrCallbackId);
            sb.append(' ');
            encodeAsMessageHelper(sb, this.pluginResult);
        }

        public JsMessage(PluginResult pluginResult, String str) {
            if (str != null && pluginResult != null) {
                this.jsPayloadOrCallbackId = str;
                this.pluginResult = pluginResult;
                return;
            }
            throw null;
        }
    }
}
