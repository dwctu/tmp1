package org.apache.cordova.gallery;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.ToyFeedbackBean;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.bean.event.ToyGserEvent;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.ToyDialog;
import dc.ToyControlBuilder;
import dc.be3;
import dc.ff2;
import dc.or1;
import dc.pc1;
import dc.rq1;
import dc.s23;
import dc.xc1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.errcode.ErrorCode;
import org.apache.cordova.gallery.XRemoteToyPlugin;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: XRemoteToyPlugin.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u0019H\u0016J\u0012\u0010#\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010$H\u0007J\u0012\u0010#\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010%H\u0007J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0017H\u0007J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010'H\u0007J\u0006\u0010(\u001a\u00020\u0019J\b\u0010)\u001a\u00020\u0019H\u0014J\u001a\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0002J\u001a\u0010/\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00100\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u00101\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00102\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u00103\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lorg/apache/cordova/gallery/XRemoteToyPlugin;", "Lorg/apache/cordova/CordovaPlugin;", "()V", "feedbackModeListener", "Lorg/apache/cordova/CallbackContext;", "toysChangeListener", "transitionErrorCode", "", "", "Lorg/apache/cordova/errcode/ErrorCode;", "execute", "", AMPExtension.Action.ATTRIBUTE_NAME, "args", "Lorg/json/JSONArray;", "callbackContext", "getErrorCode", "Lorg/json/JSONObject;", "errorCode", "getIntArr", "", "event", "Lcom/wear/bean/event/ToyCtrlGameEvent;", "Lcom/wear/bean/event/ToyGserEvent;", "getToyInfo", "", "handleToyChange", "initTransitionErrorCode", "levelInflation", "", "value", "levelToPercent", FirebaseAnalytics.Param.LEVEL, "maxLevel", "onDestroy", "onMessage", "Lcom/lovense/btservice/work/EventBusToyConnectEvent;", "Lcom/wear/bean/event/ChangeToyEvent;", "onMessageEvent", "Lcom/wear/bean/ToySelectEvent;", "openMyToysDialog", "pluginInitialize", "sendCommand", "parameters", "sendMsg", "bean", "Lcom/wear/bean/ToyFeedbackBean;", "sendOrder", "setToysChangeListener", "startFeedbackMode", "stopFeedbackMode", "stopToy", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class XRemoteToyPlugin extends CordovaPlugin {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String DATA_INFLATION = "inflation";

    @Deprecated
    @NotNull
    private static final String DATA_ROTITAION = "rotitaion";

    @Deprecated
    @NotNull
    private static final String DATA_VIBRATION = "vibration";

    @Deprecated
    @NotNull
    public static final String TAG = "XRemoteToyPlugin";

    @Deprecated
    @NotNull
    private static final String TYPE_BUTTON_DOWN = "button-down";

    @Deprecated
    @NotNull
    private static final String TYPE_BUTTON_PRESSED = "button-pressed";

    @Deprecated
    @NotNull
    private static final String TYPE_BUTTON_UP = "button-up";

    @Deprecated
    @NotNull
    private static final String TYPE_DEPTH_CHANGED = "depth-changed";

    @Deprecated
    @NotNull
    private static final String TYPE_FUNCTION_STRENGTH_CHANGED = "function-strength-changed";

    @Deprecated
    @NotNull
    private static final String TYPE_SHAKE = "shake";

    @Deprecated
    @NotNull
    private static final String TYPE_SHAKE_FREQUENCY_CHANGED = "shake-frequency-changed";

    @Nullable
    private CallbackContext feedbackModeListener;

    @Nullable
    private CallbackContext toysChangeListener;

    @NotNull
    private Map<String, ErrorCode> transitionErrorCode = new LinkedHashMap();

    /* compiled from: XRemoteToyPlugin.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lorg/apache/cordova/gallery/XRemoteToyPlugin$Companion;", "", "()V", "DATA_INFLATION", "", "DATA_ROTITAION", "DATA_VIBRATION", "TAG", "TYPE_BUTTON_DOWN", "TYPE_BUTTON_PRESSED", "TYPE_BUTTON_UP", "TYPE_DEPTH_CHANGED", "TYPE_FUNCTION_STRENGTH_CHANGED", "TYPE_SHAKE", "TYPE_SHAKE_FREQUENCY_CHANGED", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execute$lambda-0, reason: not valid java name */
    public static final void m1599execute$lambda0(XRemoteToyPlugin this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openMyToysDialog();
    }

    private final JSONObject getErrorCode(String errorCode) {
        s23.a aVar = s23.a;
        ErrorCode errorCode2 = this.transitionErrorCode.get(errorCode);
        if (errorCode2 == null) {
            errorCode2 = ErrorCode.Error10000.INSTANCE;
        }
        return aVar.a(errorCode2);
    }

    private final int[] getIntArr(ToyCtrlGameEvent event) {
        List listEmptyList;
        String str = event.value;
        Intrinsics.checkNotNullExpressionValue(str, "event.value");
        String strSubstring = str.substring(0, event.value.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        List<String> listSplit = new Regex(SignatureImpl.INNER_SEP).split(strSubstring, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listEmptyList = CollectionsKt___CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length != 4) {
            return null;
        }
        try {
            return new int[]{Integer.parseInt(strArr[1]), Intrinsics.areEqual(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, strArr[2]) ? 100 : Integer.parseInt(strArr[2]), Integer.parseInt(strArr[3])};
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final void getToyInfo(CallbackContext callbackContext) {
        if (callbackContext != null) {
            callbackContext.success(getToyInfo());
        }
    }

    private final void handleToyChange() {
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, getToyInfo());
        pluginResult.setKeepCallback(true);
        CallbackContext callbackContext = this.toysChangeListener;
        if (callbackContext != null) {
            callbackContext.sendPluginResult(pluginResult);
        }
    }

    private final void initTransitionErrorCode() {
        this.transitionErrorCode.put("400", ErrorCode.Error30000.INSTANCE);
        this.transitionErrorCode.put("401", ErrorCode.Error30001.INSTANCE);
        this.transitionErrorCode.put("402", ErrorCode.Error30002.INSTANCE);
        this.transitionErrorCode.put("403", ErrorCode.Error30003.INSTANCE);
        this.transitionErrorCode.put("404", ErrorCode.Error10001.INSTANCE);
        this.transitionErrorCode.put("500", ErrorCode.Error30004.INSTANCE);
        this.transitionErrorCode.put("601", ErrorCode.Error20101.INSTANCE);
    }

    private final int levelInflation(int value) {
        if (value > 0 && value <= 150) {
            return 1;
        }
        if (150 >= value || value > 210) {
            return 210 < value ? 3 : 0;
        }
        return 2;
    }

    private final int levelToPercent(int level, int maxLevel) {
        if (level == maxLevel) {
            return 20;
        }
        return (int) ((level * 20.0d) / maxLevel);
    }

    private final void sendCommand(JSONObject parameters, CallbackContext callbackContext) {
        int iF = ff2.n().f(parameters.get("command").toString(), null, null);
        if (iF == 200) {
            if (callbackContext != null) {
                callbackContext.success();
            }
        } else if (callbackContext != null) {
            callbackContext.error(getErrorCode(String.valueOf(iF)));
        }
    }

    private final void sendMsg(ToyFeedbackBean bean) {
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, new JSONObject(WearUtils.A.toJson(bean)));
        pluginResult.setKeepCallback(true);
        CallbackContext callbackContext = this.feedbackModeListener;
        if (callbackContext != null) {
            callbackContext.sendPluginResult(pluginResult);
        }
    }

    private final void sendOrder(JSONObject parameters, CallbackContext callbackContext) throws JSONException {
        Toy toyR = pc1.a.R(parameters.getString("toyId"));
        if (toyR != null) {
            ToyControlBuilder toyControlBuilder = new ToyControlBuilder(true, true, false, ToyControlBuilder.a.SETTING_ONLY);
            if (!parameters.has(SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY)) {
                if (parameters.has(PSOProgramService.VS_Key)) {
                    int i = parameters.getInt(PSOProgramService.VS_Key);
                    rq1 rq1Var = rq1.d;
                    String address = toyR.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "it.address");
                    rq1Var.a(address, i, toyControlBuilder);
                    return;
                }
                return;
            }
            JSONObject jSONObject = parameters.getJSONObject(SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "order.keys()");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                arrayList.add(next);
                arrayList2.add(String.valueOf(jSONObject.getInt(next)));
            }
            rq1 rq1Var2 = rq1.d;
            String address2 = toyR.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "it.address");
            rq1Var2.o(address2, arrayList, arrayList2, toyControlBuilder);
        }
    }

    private final void setToysChangeListener(CallbackContext callbackContext) {
        this.toysChangeListener = callbackContext;
    }

    private final void startFeedbackMode(JSONObject parameters, CallbackContext feedbackModeListener) throws JSONException {
        int i;
        this.feedbackModeListener = feedbackModeListener;
        int i2 = 0;
        if (parameters == null || !parameters.has("toyIdList")) {
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isFeedbackModeEnable()) {
                    or1.a aVar = or1.a;
                    aVar.g(next);
                    aVar.c(next, 3);
                    i2 = 1;
                }
            }
            i = i2;
        } else {
            JSONArray jSONArray = parameters.getJSONArray("toyIdList");
            int length = jSONArray.length();
            i = 0;
            while (i2 < length) {
                Toy toyR = pc1.a.R(jSONArray.getString(i2));
                if (toyR != null && toyR.isFeedbackModeEnable()) {
                    or1.a aVar2 = or1.a;
                    aVar2.g(toyR);
                    aVar2.c(toyR, 3);
                    i = 1;
                }
                i2++;
            }
        }
        if (i != 0 || feedbackModeListener == null) {
            return;
        }
        feedbackModeListener.error(s23.a.a(ErrorCode.Error30005.INSTANCE));
    }

    private final void stopFeedbackMode(JSONObject parameters) throws JSONException {
        if (parameters == null || !parameters.has("toyIdList")) {
            or1.a aVar = or1.a;
            aVar.h();
            aVar.b(0);
            return;
        }
        JSONArray jSONArray = parameters.getJSONArray("toyIdList");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Toy toyR = pc1.a.R(jSONArray.getString(i));
            if (toyR != null && toyR.isFeedbackModeEnable()) {
                or1.a aVar2 = or1.a;
                aVar2.i(toyR);
                aVar2.c(toyR, 0);
            }
        }
    }

    private final void stopToy(JSONObject parameters, CallbackContext callbackContext) throws JSONException {
        Toy toyR = pc1.a.R(parameters.getString("toyId"));
        if (toyR != null) {
            rq1.d.r(toyR.getAddress());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(@Nullable String action, @NotNull JSONArray args, @Nullable CallbackContext callbackContext) throws JSONException {
        Intrinsics.checkNotNullParameter(args, "args");
        if (action != null) {
            switch (action.hashCode()) {
                case -912792502:
                    if (action.equals("startFeedbackMode")) {
                        try {
                            startFeedbackMode(args.length() > 0 ? args.getJSONObject(0) : null, callbackContext);
                        } catch (Exception e) {
                            if (callbackContext != null) {
                                callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
                            }
                            e.printStackTrace();
                        }
                        return true;
                    }
                    break;
                case -528052507:
                    if (action.equals("getMyToysInfo")) {
                        getToyInfo(callbackContext);
                        return true;
                    }
                    break;
                case -145049622:
                    if (action.equals("stopFeedbackMode")) {
                        try {
                            stopFeedbackMode(args.length() > 0 ? args.getJSONObject(0) : null);
                        } catch (Exception e2) {
                            if (callbackContext != null) {
                                callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
                            }
                            e2.printStackTrace();
                        }
                        return true;
                    }
                    break;
                case 3540994:
                    if (action.equals("stop")) {
                        try {
                            JSONObject parameters = args.getJSONObject(0);
                            Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
                            stopToy(parameters, callbackContext);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return true;
                    }
                    break;
                case 11877542:
                    if (action.equals("sendOrder")) {
                        try {
                            JSONObject parameters2 = args.getJSONObject(0);
                            Intrinsics.checkNotNullExpressionValue(parameters2, "parameters");
                            sendOrder(parameters2, callbackContext);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        return true;
                    }
                    break;
                case 686923427:
                    if (action.equals("sendCommand")) {
                        try {
                            JSONObject parameters3 = args.getJSONObject(0);
                            Intrinsics.checkNotNullExpressionValue(parameters3, "parameters");
                            sendCommand(parameters3, callbackContext);
                        } catch (Exception e5) {
                            if (callbackContext != null) {
                                callbackContext.error(s23.a.a(ErrorCode.Error20100.INSTANCE));
                            }
                            e5.printStackTrace();
                        }
                        return true;
                    }
                    break;
                case 808533683:
                    if (action.equals("openMyToysDialog")) {
                        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: dc.me4
                            @Override // java.lang.Runnable
                            public final void run() {
                                XRemoteToyPlugin.m1599execute$lambda0(this.a);
                            }
                        });
                        return true;
                    }
                    break;
                case 1981140231:
                    if (action.equals("setMyToysChangeListener")) {
                        setToysChangeListener(callbackContext);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        this.toysChangeListener = null;
        this.feedbackModeListener = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@Nullable ChangeToyEvent event) {
        handleToyChange();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable ToySelectEvent event) {
        handleToyChange();
    }

    public final void openMyToysDialog() {
        ToyDialog.j.a().show(this.cordova.getActivity().getSupportFragmentManager(), "");
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void pluginInitialize() {
        super.pluginInitialize();
        EventBus.getDefault().register(this);
        initTransitionErrorCode();
    }

    private final JSONObject getToyInfo() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<Toy> it = pc1.a.o().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showName", next.getName());
            String defineRename = next.getDefineRename();
            if (defineRename == null) {
                defineRename = "";
            }
            jSONObject.put("alias", defineRename);
            jSONObject.put("firmwareVersion", String.valueOf(next.getToyVersion()));
            String type = next.getType();
            Intrinsics.checkNotNullExpressionValue(type, "toy.type");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = type.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            jSONObject.put("type", lowerCase);
            String deviceId = next.getDeviceId();
            Intrinsics.checkNotNullExpressionValue(deviceId, "toy.deviceId");
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
            String lowerCase2 = deviceId.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            jSONObject.put("toyId", lowerCase2);
            jSONObject.put("status", String.valueOf(next.getStatus()));
            String str = "status===" + next.getStatus();
            jSONObject.put("battery", String.valueOf(next.getBattery()));
            jSONObject.put("isSupportFeedbackMode", next.isFeedbackModeEnable());
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("toyList", jSONArray);
        return jSONObject2;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@Nullable xc1 xc1Var) {
        handleToyChange();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@NotNull ToyCtrlGameEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.type == 21) {
            String str = "ToyEvent Value: " + event.value;
            int[] intArr = getIntArr(event);
            if (intArr != null) {
                pc1 pc1Var = pc1.a;
                String str2 = event.address;
                Intrinsics.checkNotNullExpressionValue(str2, "event.address");
                Toy toyO = pc1Var.O(str2);
                if (toyO == null || !toyO.isFeedbackModeEnable()) {
                    return;
                }
                ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
                toyFeedbackBean.feedback = WearUtils.B ? event.value : null;
                toyFeedbackBean.toyId = toyO.getDeviceId();
                ToyFeedbackBean.DataDTO dataDTO = new ToyFeedbackBean.DataDTO();
                toyFeedbackBean.data = dataDTO;
                switch (intArr[0]) {
                    case 0:
                        toyFeedbackBean.type = TYPE_BUTTON_DOWN;
                        dataDTO.index = Integer.valueOf(intArr[1]);
                        toyO.setFeedbackDownTime(be3.r());
                        break;
                    case 1:
                        toyFeedbackBean.type = TYPE_BUTTON_UP;
                        dataDTO.index = Integer.valueOf(intArr[1]);
                        break;
                    case 2:
                        toyFeedbackBean.type = TYPE_FUNCTION_STRENGTH_CHANGED;
                        dataDTO.function = DATA_VIBRATION;
                        dataDTO.index = Integer.valueOf(intArr[1]);
                        toyFeedbackBean.data.value = Integer.valueOf(intArr[2]);
                        break;
                    case 3:
                        toyFeedbackBean.type = TYPE_FUNCTION_STRENGTH_CHANGED;
                        dataDTO.function = DATA_ROTITAION;
                        dataDTO.index = Integer.valueOf(intArr[1]);
                        toyFeedbackBean.data.value = Integer.valueOf(intArr[2]);
                        break;
                    case 4:
                        toyFeedbackBean.type = TYPE_SHAKE_FREQUENCY_CHANGED;
                        dataDTO.value = Integer.valueOf(levelToPercent(intArr[2], 4));
                        break;
                    case 5:
                        return;
                    case 6:
                        toyFeedbackBean.type = TYPE_DEPTH_CHANGED;
                        dataDTO.value = Integer.valueOf(levelToPercent(intArr[2], 3));
                        break;
                    case 7:
                    case 10:
                        toyFeedbackBean.type = TYPE_FUNCTION_STRENGTH_CHANGED;
                        dataDTO.function = DATA_INFLATION;
                        dataDTO.index = Integer.valueOf(intArr[1]);
                        toyFeedbackBean.data.value = Integer.valueOf(levelInflation(intArr[2] * 10));
                        break;
                    case 8:
                        return;
                    case 9:
                        toyFeedbackBean.type = TYPE_FUNCTION_STRENGTH_CHANGED;
                        dataDTO.function = DATA_INFLATION;
                        dataDTO.index = Integer.valueOf(intArr[1]);
                        toyFeedbackBean.data.value = 0;
                        break;
                }
                Integer num = toyFeedbackBean.data.index;
                if (num != null && num != null && num.intValue() == 100) {
                    toyFeedbackBean.data.index = 0;
                    sendMsg(toyFeedbackBean);
                    if (intArr[0] == 2 && toyO.isSupportV1V2()) {
                        toyFeedbackBean.data.index = 1;
                        sendMsg(toyFeedbackBean);
                    }
                } else {
                    sendMsg(toyFeedbackBean);
                }
                if (intArr[0] != 1 || be3.r() - toyO.getFeedbackDownTime() > 300) {
                    return;
                }
                toyFeedbackBean.type = TYPE_BUTTON_PRESSED;
                sendMsg(toyFeedbackBean);
            }
        }
    }

    private final int[] getIntArr(ToyGserEvent event) {
        List listEmptyList;
        if (event == null || TextUtils.isEmpty(event.getValue())) {
            return null;
        }
        List<String> listSplit = new Regex(SignatureImpl.INNER_SEP).split(StringsKt__StringsJVMKt.replace$default(event.getValue(), ";", "", false, 4, (Object) null), 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listEmptyList = CollectionsKt___CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length != 3) {
            return null;
        }
        try {
            return new int[]{Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])};
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@NotNull ToyGserEvent event) {
        Toy toyO;
        Intrinsics.checkNotNullParameter(event, "event");
        String str = "ToyGserEvent__value: " + event;
        int[] intArr = getIntArr(event);
        if (intArr == null || intArr.length != 2 || (toyO = pc1.a.O(event.getAddress())) == null || !toyO.isFeedbackModeEnable()) {
            return;
        }
        ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
        toyFeedbackBean.feedback = WearUtils.B ? event.getValue() : null;
        toyFeedbackBean.type = TYPE_SHAKE_FREQUENCY_CHANGED;
        toyFeedbackBean.toyId = toyO.getDeviceId();
        ToyFeedbackBean.DataDTO dataDTO = new ToyFeedbackBean.DataDTO();
        toyFeedbackBean.data = dataDTO;
        dataDTO.value = Integer.valueOf(levelToPercent(intArr[0], 4));
        sendMsg(toyFeedbackBean);
        if (intArr[1] == 1) {
            ToyFeedbackBean toyFeedbackBean2 = new ToyFeedbackBean();
            toyFeedbackBean2.feedback = WearUtils.B ? event.getValue() : null;
            toyFeedbackBean2.type = TYPE_SHAKE;
            toyFeedbackBean2.toyId = toyO.getDeviceId();
            sendMsg(toyFeedbackBean2);
        }
    }
}
