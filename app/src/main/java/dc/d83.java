package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.socketio.controlLink.request.ControlPermissionRequest;
import com.wear.bean.socketio.controlLink.response.ControlLinkPermissionResponse;
import com.wear.ext.ActivityKt;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.as3;
import dc.yr3;
import dc.zr3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;

/* compiled from: ControlLinkPermissionControl.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 \u009c\u00012\u00020\u0001:\u0006\u009c\u0001\u009d\u0001\u009e\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020)2\u0006\u0010^\u001a\u00020)J\u001e\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020a2\u0006\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020)J\u000e\u0010b\u001a\u00020[2\u0006\u0010c\u001a\u00020\u0004J\u0006\u0010d\u001a\u00020\u0004J\u0006\u0010e\u001a\u00020\u0004J\u0006\u0010f\u001a\u00020\u0004J\u0006\u0010g\u001a\u00020\u0004J\u0006\u0010h\u001a\u00020\u0004J\u0006\u0010i\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020[2\u0006\u0010j\u001a\u00020\u0004J\u0010\u0010k\u001a\u00020[2\b\u0010l\u001a\u0004\u0018\u00010/J\u0010\u0010m\u001a\u00020[2\b\u0010n\u001a\u0004\u0018\u00010\u0013J\b\u0010o\u001a\u0004\u0018\u00010pJ\u0015\u0010q\u001a\u00020[2\b\u0010r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u0006\u0010s\u001a\u00020\u0004J\u0006\u0010t\u001a\u00020\u0004J\u0010\u0010u\u001a\u00020\u00042\b\u0010v\u001a\u0004\u0018\u00010wJ\u000e\u00107\u001a\u00020[2\u0006\u0010x\u001a\u00020\u0004J\u0006\u0010y\u001a\u00020[JT\u0010z\u001a\u00020[2\u0006\u0010`\u001a\u00020a2\u0006\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020)2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u00042$\u0010~\u001a \u0012\u0016\u0012\u00140\u0004¢\u0006\u000f\b\u0080\u0001\u0012\n\b\u0081\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020[0\u007fJ\u0012\u0010\u0083\u0001\u001a\u00020[2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010aJ\u0012\u0010\u0085\u0001\u001a\u00020[2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0019J\u0007\u0010\u0086\u0001\u001a\u00020[J\u0007\u0010\u0087\u0001\u001a\u00020[J\u0007\u0010\u0088\u0001\u001a\u00020[J\u0007\u0010\u0089\u0001\u001a\u00020[J\u0010\u0010\u008a\u0001\u001a\u00020[2\u0007\u0010\u008b\u0001\u001a\u00020\u0004J\u000f\u0010\u008c\u0001\u001a\u00020[2\u0006\u0010]\u001a\u00020#J\u000f\u0010\u008d\u0001\u001a\u00020[2\u0006\u0010]\u001a\u00020)J\u0007\u0010\u008e\u0001\u001a\u00020[J\u0018\u0010\u008f\u0001\u001a\u00020[2\u0006\u00108\u001a\u00020\u00042\u0007\u0010\u0090\u0001\u001a\u00020)J\u001a\u0010\u0091\u0001\u001a\u00020[2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010)2\u0006\u00106\u001a\u00020\u0004JI\u0010\u0093\u0001\u001a\u00020[2\u0006\u0010v\u001a\u00020w2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010)2\u0007\u0010\u0095\u0001\u001a\u00020\u00042$\u0010~\u001a \u0012\u0016\u0012\u00140\u0004¢\u0006\u000f\b\u0080\u0001\u0012\n\b\u0081\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020[0\u007fJI\u0010\u0096\u0001\u001a\u00020[2\u0006\u0010v\u001a\u00020w2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010)2\u0007\u0010\u0095\u0001\u001a\u00020\u00042$\u0010~\u001a \u0012\u0016\u0012\u00140\u0004¢\u0006\u000f\b\u0080\u0001\u0012\n\b\u0081\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020[0\u007fJI\u0010\u0097\u0001\u001a\u00020[2\u0006\u0010v\u001a\u00020w2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010)2\u0007\u0010\u0095\u0001\u001a\u00020\u00042$\u0010~\u001a \u0012\u0016\u0012\u00140\u0004¢\u0006\u000f\b\u0080\u0001\u0012\n\b\u0081\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020[0\u007fJ>\u0010\u0098\u0001\u001a\u00020[2\u0006\u0010{\u001a\u00020|2\u0007\u0010\u0084\u0001\u001a\u00020)2$\u0010~\u001a \u0012\u0016\u0012\u00140\u0004¢\u0006\u000f\b\u0080\u0001\u0012\n\b\u0081\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020[0\u007fJ@\u0010\u0099\u0001\u001a\u00020[2\u0006\u0010{\u001a\u00020|2\u0007\u0010\u0084\u0001\u001a\u00020#2$\u0010~\u001a \u0012\u0016\u0012\u00140\u0004¢\u0006\u000f\b\u0080\u0001\u0012\n\b\u0081\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020[0\u007fH\u0002J\u0010\u0010\u009a\u0001\u001a\u00020\u00042\u0007\u0010\u009b\u0001\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020)05X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eR\u001c\u0010;\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010+\"\u0004\b=\u0010-R\u001a\u0010>\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR\u001c\u0010A\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010+\"\u0004\bC\u0010-R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u00020G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bH\u0010IR\u0010\u0010L\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001b\u0010R\u001a\u00020S8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010K\u001a\u0004\bT\u0010UR\u001a\u0010W\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\f\"\u0004\bY\u0010\u000e¨\u0006\u009f\u0001"}, d2 = {"Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl;", "", "()V", "chooseSyncTypeIsLdr", "", "getChooseSyncTypeIsLdr", "()Ljava/lang/Boolean;", "setChooseSyncTypeIsLdr", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "controlLiveAlreadyEnd", "getControlLiveAlreadyEnd", "()Z", "setControlLiveAlreadyEnd", "(Z)V", "controlPermissionIsOld", "getControlPermissionIsOld", "setControlPermissionIsOld", "controlResponse", "Lcom/wear/bean/socketio/controlLink/response/ControlLinkPermissionResponse;", "getControlResponse", "()Lcom/wear/bean/socketio/controlLink/response/ControlLinkPermissionResponse;", "setControlResponse", "(Lcom/wear/bean/socketio/controlLink/response/ControlLinkPermissionResponse;)V", "controlSyncType", "Lcom/wear/protocol/EntitySync$SyncOPTType;", "getControlSyncType", "()Lcom/wear/protocol/EntitySync$SyncOPTType;", "setControlSyncType", "(Lcom/wear/protocol/EntitySync$SyncOPTType;)V", "isRequestControling", "mControlDataIsNull", "getMControlDataIsNull", "setMControlDataIsNull", "mControlType", "Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$ControlType;", "getMControlType", "()Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$ControlType;", "setMControlType", "(Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$ControlType;)V", "mControlTypeControlled", "", "getMControlTypeControlled", "()Ljava/lang/String;", "setMControlTypeControlled", "(Ljava/lang/String;)V", "mPermissionResponse", "Lcom/wear/bean/ControlLinkBean$ControlPermissionResponse;", "getMPermissionResponse", "()Lcom/wear/bean/ControlLinkBean$ControlPermissionResponse;", "setMPermissionResponse", "(Lcom/wear/bean/ControlLinkBean$ControlPermissionResponse;)V", "messageList", "", "needShowDialog", "needShowFriendDialog", "needShowOldDialog", "getNeedShowOldDialog", "setNeedShowOldDialog", "needShowOldDialogType", "getNeedShowOldDialogType", "setNeedShowOldDialogType", "needShowRequestDialog", "getNeedShowRequestDialog", "setNeedShowRequestDialog", "needShowRequestDialogType", "getNeedShowRequestDialogType", "setNeedShowRequestDialogType", "permissionActiveDialog", "Lcom/wear/widget/dialog/ControlLinkPermissionDialog;", "permissionDialog", "Lcom/wear/widget/dialog/ControlLinkRequestControlDialog;", "getPermissionDialog", "()Lcom/wear/widget/dialog/ControlLinkRequestControlDialog;", "permissionDialog$delegate", "Lkotlin/Lazy;", "permissionEnsureDialog", "permissionNeedDialog", "getPermissionNeedDialog", "()Lcom/wear/widget/dialog/ControlLinkPermissionDialog;", "setPermissionNeedDialog", "(Lcom/wear/widget/dialog/ControlLinkPermissionDialog;)V", "responseControlDialog", "Lcom/wear/widget/dialog/ControlLinkResponseControlDialog;", "getResponseControlDialog", "()Lcom/wear/widget/dialog/ControlLinkResponseControlDialog;", "responseControlDialog$delegate", "showControlerView", "getShowControlerView", "setShowControlerView", "agreeOrRefuseControlPermission", "", "isAgree", "controlType", "linkId", "cancelRequest", "isRequest", "Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$ControlResult;", "checkControlEnd", "isEnd", "checkExistUntreatedLiveRequest", "checkExistUntreatedRequest", "checkExistUntreatedSyncRequest", "checkJoinedHaveLiveRequest", "checkJoinedHaveSyncRequest", "checkNullAndOpen", "isLdr", "controlLinkRequestControlInfo", "permissionResponse", "controlResponseInfo", SaslStreamElements.Response.ELEMENT, "getControlLinkChatActivity", "Lcom/wear/ui/longDistance/controlLink/ControlLinkChatActivity;", "isOldVersion", "permissionIsOld", "isOpenControlPermission", "isOverTime", "isShowPermissionRed", "context", "Landroid/content/Context;", "mNeed", "onDestory", "requestOrCancelControlPermission", "view", "Landroid/view/View;", "isAgainInto", Callback.METHOD_NAME, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "saveMessageByCancelOrExpired", "mType", "saveSyncStatus", "sendMessageByCancelOrExpired", "sendSystemMessage", "sendSystemMessageDeclined", "sendSystemMessageExpired", "setControlDataIsNull", "isNull", "setControlType", "setControlTypeControlled", "setControlerViewModel", "setOldDialog", "mNeedShowOldDialogType", "setRequestDialog", "linkPermissionType", "showPermissionActiveDialog", "textStr", "cancel", "showPermissionEnsureDialog", "showPermissionNeedDialog", "showPermissionRequestDialog", "showPermissionResponseDialog", "showToastByClickAgain", "isJoiner", "Companion", "ControlResult", "ControlType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class d83 {

    @NotNull
    public static final b u = new b(null);

    @NotNull
    public static final Lazy<d83> v = LazyKt__LazyJVMKt.lazy(a.a);

    @Nullable
    public ControlLinkBean.ControlPermissionResponse a;

    @Nullable
    public String b;

    @Nullable
    public ControlLinkPermissionResponse c;

    @Nullable
    public Boolean d;

    @Nullable
    public Boolean e;

    @NotNull
    public final Lazy f;

    @NotNull
    public final Lazy g;

    @Nullable
    public yr3 h;

    @Nullable
    public yr3 i;

    @Nullable
    public yr3 j;
    public boolean k;
    public boolean l;
    public boolean m;

    @Nullable
    public EntitySync.SyncOPTType n;

    @Nullable
    public Boolean o;

    @NotNull
    public List<String> p;
    public boolean q;
    public boolean r;

    @Nullable
    public String s;
    public boolean t;

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<d83> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d83 invoke() {
            return new d83();
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl;", "getInstance$annotations", "getInstance", "()Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d83 a() {
            return (d83) d83.v.getValue();
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$ControlResult;", "", "(Ljava/lang/String;I)V", DeliveryReceiptRequest.ELEMENT, "cancel", "accept", "decline", "expired", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum c {
        request,
        cancel,
        accept,
        decline,
        expired
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$ControlType;", "", "(Ljava/lang/String;I)V", "live_control", "sync_control", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum d {
        live_control,
        sync_control
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/widget/dialog/ControlLinkRequestControlDialog;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<zr3> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final zr3 invoke() {
            FragmentActivity currentActivity = MyApplication.K;
            Intrinsics.checkNotNullExpressionValue(currentActivity, "currentActivity");
            return new zr3(currentActivity);
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/widget/dialog/ControlLinkResponseControlDialog;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<as3> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final as3 invoke() {
            FragmentActivity currentActivity = MyApplication.K;
            Intrinsics.checkNotNullExpressionValue(currentActivity, "currentActivity");
            return new as3(currentActivity);
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$showPermissionActiveDialog$1", "Lcom/wear/widget/dialog/ControlLinkPermissionDialog$Listener;", "cancel", "", "ok", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements yr3.a {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public g(Function1<? super Boolean, Unit> function1) {
            this.a = function1;
        }

        @Override // dc.yr3.a
        public void a() {
            this.a.invoke(Boolean.TRUE);
        }

        @Override // dc.yr3.a
        public void cancel() {
            this.a.invoke(Boolean.FALSE);
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$showPermissionEnsureDialog$1", "Lcom/wear/widget/dialog/ControlLinkPermissionDialog$Listener;", "cancel", "", "ok", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class h implements yr3.a {
        public final /* synthetic */ Function1<Boolean, Unit> a;
        public final /* synthetic */ d83 b;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Function1<? super Boolean, Unit> function1, d83 d83Var) {
            this.a = function1;
            this.b = d83Var;
        }

        @Override // dc.yr3.a
        public void a() {
            this.a.invoke(Boolean.TRUE);
            if (this.b.k) {
                this.b.k = false;
                yr3 h = this.b.getH();
                if (h != null) {
                    h.show();
                }
            }
        }

        @Override // dc.yr3.a
        public void cancel() {
            this.b.k = false;
            this.a.invoke(Boolean.FALSE);
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$showPermissionNeedDialog$1", "Lcom/wear/widget/dialog/ControlLinkPermissionDialog$Listener;", "cancel", "", "ok", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class i implements yr3.a {
        public final /* synthetic */ Function1<Boolean, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Function1<? super Boolean, Unit> function1) {
            this.b = function1;
        }

        @Override // dc.yr3.a
        public void a() {
            d83.this.H(Boolean.FALSE);
            this.b.invoke(Boolean.TRUE);
            if (ChatSyncControl.N0().t != null) {
                Dialog dialog = ChatSyncControl.N0().t;
                if (dialog != null && dialog.isShowing()) {
                    ChatSyncControl.N0().t.dismiss();
                }
            }
            if (ChatLiveControl.q0().v != null) {
                Dialog dialog2 = ChatSyncControl.N0().t;
                if (dialog2 != null && dialog2.isShowing()) {
                    ChatSyncControl.N0().t.dismiss();
                }
            }
        }

        @Override // dc.yr3.a
        public void cancel() {
            this.b.invoke(Boolean.FALSE);
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$showPermissionRequestDialog$1", "Lcom/wear/widget/dialog/ControlLinkRequestControlDialog$Listener;", "accept", "", "decline", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class j implements zr3.a {
        public final /* synthetic */ Function1<Boolean, Unit> a;
        public final /* synthetic */ d83 b;

        /* JADX WARN: Multi-variable type inference failed */
        public j(Function1<? super Boolean, Unit> function1, d83 d83Var) {
            this.a = function1;
            this.b = d83Var;
        }

        @Override // dc.zr3.a
        public void a() {
            this.a.invoke(Boolean.FALSE);
            if (this.b.l) {
                ControlLinkChatActivity controlLinkChatActivityS = this.b.s();
                if (controlLinkChatActivityS != null) {
                    controlLinkChatActivityS.d6();
                }
                this.b.l = false;
            }
        }

        @Override // dc.zr3.a
        public void accept() {
            this.a.invoke(Boolean.TRUE);
            if (this.b.l) {
                ControlLinkChatActivity controlLinkChatActivityS = this.b.s();
                if (controlLinkChatActivityS != null) {
                    controlLinkChatActivityS.d6();
                }
                this.b.l = false;
            }
        }
    }

    /* compiled from: ControlLinkPermissionControl.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$showPermissionResponseDialog$1", "Lcom/wear/widget/dialog/ControlLinkResponseControlDialog$Listener;", "cancel", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class k implements as3.a {
        public final /* synthetic */ Function1<Boolean, Unit> a;
        public final /* synthetic */ d83 b;

        /* JADX WARN: Multi-variable type inference failed */
        public k(Function1<? super Boolean, Unit> function1, d83 d83Var) {
            this.a = function1;
            this.b = d83Var;
        }

        @Override // dc.as3.a
        public void cancel() {
            this.a.invoke(Boolean.TRUE);
            if (this.b.l) {
                ControlLinkChatActivity controlLinkChatActivityS = this.b.s();
                if (controlLinkChatActivityS != null) {
                    controlLinkChatActivityS.d6();
                }
                this.b.l = false;
            }
        }
    }

    public d83() {
        d dVar = d.live_control;
        this.b = "";
        Boolean bool = Boolean.FALSE;
        this.d = bool;
        this.e = bool;
        this.f = LazyKt__LazyJVMKt.lazy(f.a);
        this.g = LazyKt__LazyJVMKt.lazy(e.a);
        this.o = bool;
        this.p = new ArrayList();
        this.s = "";
    }

    @NotNull
    public static final d83 w() {
        return u.a();
    }

    /* renamed from: A, reason: from getter */
    public final boolean getT() {
        return this.t;
    }

    /* renamed from: B, reason: from getter */
    public final boolean getR() {
        return this.r;
    }

    @Nullable
    /* renamed from: C, reason: from getter */
    public final String getS() {
        return this.s;
    }

    @NotNull
    public final zr3 D() {
        return (zr3) this.g.getValue();
    }

    @Nullable
    /* renamed from: E, reason: from getter */
    public final yr3 getH() {
        return this.h;
    }

    @NotNull
    public final as3 F() {
        return (as3) this.f.getValue();
    }

    /* renamed from: G, reason: from getter */
    public final boolean getQ() {
        return this.q;
    }

    public final void H(@Nullable Boolean bool) {
        this.d = bool;
    }

    public final boolean I() {
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        return controlPermissionResponse != null && controlPermissionResponse.getOpenControlPermission();
    }

    public final boolean J() {
        ControlLinkPermissionResponse controlLinkPermissionResponse = this.c;
        return Intrinsics.areEqual(controlLinkPermissionResponse != null ? controlLinkPermissionResponse.getOperationType() : null, c.expired.name());
    }

    public final boolean K(@Nullable Context context) {
        if (pf3.d(context)) {
            return false;
        }
        return eg3.d(context, "key_first_into_create_contril_link", true);
    }

    public final void L(boolean z) {
        this.l = z;
    }

    public final void M() {
        D().a();
        F().b();
    }

    public final void N(@NotNull c isRequest, @NotNull d controlType, @NotNull String linkId, @NotNull View view, boolean z, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(isRequest, "isRequest");
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        Intrinsics.checkNotNullParameter(linkId, "linkId");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        if (controlPermissionResponse == null || !controlPermissionResponse.getOpenControlPermission()) {
            return;
        }
        if (z) {
            f0(view, controlType, callback);
            return;
        }
        c cVar = c.request;
        if (g(isRequest, controlType, linkId)) {
            f0(view, controlType, callback);
        }
    }

    public final void O(@Nullable c cVar) {
        if (cVar == null) {
            return;
        }
        this.p.add(cVar.name());
    }

    public final void P(@Nullable EntitySync.SyncOPTType syncOPTType) {
        this.n = syncOPTType;
    }

    public final void Q() {
        if (this.p.size() > 0) {
            for (String str : this.p) {
                if (Intrinsics.areEqual(str, c.cancel.name())) {
                    R();
                } else if (Intrinsics.areEqual(str, c.expired.name())) {
                    T();
                }
            }
            this.p.clear();
        }
    }

    public final void R() {
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C708.toString(), ah4.e(R.string.control_link_cancel_trigger));
        c83.R1().w1(entitySystem);
    }

    public final void S() {
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C710.toString(), ah4.e(R.string.control_link_cancel_declined));
        c83.R1().w1(entitySystem);
    }

    public final void T() {
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C709.toString(), ah4.e(R.string.control_link_cancel_expired));
        c83.R1().w1(entitySystem);
    }

    public final void U(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    public final void V(@NotNull d controlType) {
        Intrinsics.checkNotNullParameter(controlType, "controlType");
    }

    public final void W(@NotNull String controlType) {
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        this.b = controlType;
    }

    public final void X() {
        this.q = !this.q;
    }

    public final void Y(boolean z, @NotNull String mNeedShowOldDialogType) {
        Intrinsics.checkNotNullParameter(mNeedShowOldDialogType, "mNeedShowOldDialogType");
        this.t = z;
    }

    public final void Z(@Nullable String str, boolean z) {
        if (WearUtils.e1(str)) {
            str = "";
        }
        this.s = str;
        this.r = z;
    }

    public final void a0(boolean z) {
        this.q = z;
    }

    public final void b0(@NotNull Context context, @Nullable String str, boolean z, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        yr3 yr3Var = new yr3(context, str, z);
        this.i = yr3Var;
        if (yr3Var != null) {
            yr3Var.f(new g(callback));
        }
        yr3 yr3Var2 = this.i;
        if (yr3Var2 != null) {
            yr3Var2.show();
        }
    }

    public final void c0(@NotNull Context context, @Nullable String str, boolean z, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        yr3 yr3Var = new yr3(context, str, z);
        this.j = yr3Var;
        if (yr3Var != null) {
            yr3Var.f(new h(callback, this));
        }
        yr3 yr3Var2 = this.j;
        if (yr3Var2 != null) {
            yr3Var2.show();
        }
    }

    public final void d0(@NotNull Context context, @Nullable String str, boolean z, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        yr3 yr3Var = this.h;
        boolean z2 = false;
        if (yr3Var != null && yr3Var.isShowing()) {
            return;
        }
        yr3 yr3Var2 = new yr3(context, str, z);
        this.h = yr3Var2;
        yr3Var2.f(new i(callback));
        yr3 yr3Var3 = this.j;
        if (yr3Var3 != null && yr3Var3.isShowing()) {
            z2 = true;
        }
        if (z2) {
            this.k = true;
            return;
        }
        H(Boolean.TRUE);
        yr3 yr3Var4 = this.h;
        if (yr3Var4 != null) {
            yr3Var4.show();
        }
    }

    public final void e0(@NotNull View view, @NotNull String mType, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mType, "mType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (D().e()) {
            return;
        }
        D().i(mType);
        D().h(new j(callback, this));
        ye3.g("control_link_recevice_permission_popup_exposure", "exposure", "control_link_recevice_permission_popup", "popup", Intrinsics.areEqual(mType, d.live_control.name()) ? "1" : "2", c83.R1().S1(), JSON.toJSONString(WearUtils.x.G().m()));
        D().j(view);
    }

    public final void f(boolean z, @NotNull String controlType, @NotNull String linkId) {
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        Intrinsics.checkNotNullParameter(linkId, "linkId");
        if (!uf2.v().D("cl_control_permission_handle_ts", new ControlPermissionRequest(WearUtils.E(), linkId, controlType, z ? "accept" : "decline")) || z) {
            return;
        }
        if (Intrinsics.areEqual(controlType, d.live_control.name())) {
            ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
            if (controlPermissionResponse != null) {
                controlPermissionResponse.setCreatorExistUntreatedLiveControlRequest(false);
            }
        } else {
            ControlLinkBean.ControlPermissionResponse controlPermissionResponse2 = this.a;
            if (controlPermissionResponse2 != null) {
                controlPermissionResponse2.setCreatorExistUntreatedSyncControlRequest(false);
            }
        }
        M();
    }

    public final void f0(View view, d dVar, Function1<? super Boolean, Unit> function1) {
        F().k(dVar);
        F().j(new k(function1, this));
        F().l(view);
    }

    public final boolean g(@NotNull c isRequest, @NotNull d controlType, @NotNull String linkId) {
        Intrinsics.checkNotNullParameter(isRequest, "isRequest");
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        Intrinsics.checkNotNullParameter(linkId, "linkId");
        this.c = null;
        boolean zD = uf2.v().D("cl_control_permission_request_ts", new ControlPermissionRequest(WearUtils.E(), linkId, controlType.toString(), isRequest == c.request ? DeliveryReceiptRequest.ELEMENT : "cancel"));
        if (zD) {
            c83.R1().o2();
        }
        return zD;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if ((r0 != null && r0.getCreatorExistUntreatedLiveControlRequest()) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g0(boolean r4) {
        /*
            r3 = this;
            com.wear.bean.ControlLinkBean$ControlPermissionResponse r0 = r3.a
            r1 = 0
            if (r0 == 0) goto L76
            dc.as3 r0 = r3.F()
            boolean r0 = r0.f()
            r2 = 1
            if (r0 != 0) goto L2e
            com.wear.bean.ControlLinkBean$ControlPermissionResponse r0 = r3.a
            if (r0 == 0) goto L1c
            boolean r0 = r0.getCreatorExistUntreatedSyncControlRequest()
            if (r0 != r2) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 != 0) goto L2e
            com.wear.bean.ControlLinkBean$ControlPermissionResponse r0 = r3.a
            if (r0 == 0) goto L2b
            boolean r0 = r0.getCreatorExistUntreatedLiveControlRequest()
            if (r0 != r2) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            if (r0 == 0) goto L76
        L2e:
            if (r4 == 0) goto L53
            com.wear.bean.ControlLinkBean$ControlPermissionResponse r4 = r3.a
            if (r4 == 0) goto L3b
            boolean r4 = r4.getCreatorExistUntreatedLiveControlRequest()
            if (r4 != r2) goto L3b
            r1 = 1
        L3b:
            if (r1 == 0) goto L48
            r4 = 2131887872(0x7f120700, float:1.9410363E38)
            java.lang.String r4 = dc.ah4.e(r4)
            dc.sg3.l(r4)
            goto L75
        L48:
            r4 = 2131886825(0x7f1202e9, float:1.940824E38)
            java.lang.String r4 = dc.ah4.e(r4)
            dc.sg3.l(r4)
            goto L75
        L53:
            com.wear.bean.ControlLinkBean$ControlPermissionResponse r4 = r3.a
            if (r4 == 0) goto L5e
            boolean r4 = r4.getCreatorExistUntreatedLiveControlRequest()
            if (r4 != r2) goto L5e
            r1 = 1
        L5e:
            if (r1 == 0) goto L6b
            r4 = 2131886789(0x7f1202c5, float:1.9408167E38)
            java.lang.String r4 = dc.ah4.e(r4)
            dc.sg3.l(r4)
            goto L75
        L6b:
            r4 = 2131886826(0x7f1202ea, float:1.9408242E38)
            java.lang.String r4 = dc.ah4.e(r4)
            dc.sg3.l(r4)
        L75:
            return r2
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.d83.g0(boolean):boolean");
    }

    public final void h(boolean z) {
        yr3 yr3Var = this.h;
        if (!(yr3Var != null && yr3Var.isShowing())) {
            z = false;
        }
        this.m = z;
    }

    public final boolean i() {
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        return controlPermissionResponse != null && controlPermissionResponse.getCreatorExistUntreatedLiveControlRequest();
    }

    public final boolean j() {
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        if (controlPermissionResponse != null && controlPermissionResponse.getCreatorExistUntreatedLiveControlRequest()) {
            return true;
        }
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse2 = this.a;
        return controlPermissionResponse2 != null && controlPermissionResponse2.getCreatorExistUntreatedSyncControlRequest();
    }

    public final boolean k() {
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        return controlPermissionResponse != null && controlPermissionResponse.getCreatorExistUntreatedSyncControlRequest();
    }

    public final boolean l() {
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        return controlPermissionResponse != null && controlPermissionResponse.getJoinerHasLiveControlPermission();
    }

    public final boolean m() {
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        return controlPermissionResponse != null && controlPermissionResponse.getJoinerHasSyncControlPermission();
    }

    public final boolean n() {
        ControlLinkBean.ControlPermissionResponse controlPermissionResponse = this.a;
        if (controlPermissionResponse != null) {
            if ((controlPermissionResponse != null ? Boolean.valueOf(controlPermissionResponse.getOpenControlPermission()) : null) != null) {
                ControlLinkBean.ControlPermissionResponse controlPermissionResponse2 = this.a;
                if (controlPermissionResponse2 != null && controlPermissionResponse2.getOpenControlPermission()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void o(boolean z) {
        this.o = Boolean.valueOf(z);
    }

    public final void p(@Nullable ControlLinkBean.ControlPermissionResponse controlPermissionResponse) {
        this.a = controlPermissionResponse;
    }

    public final void q(@Nullable ControlLinkPermissionResponse controlLinkPermissionResponse) {
        this.c = controlLinkPermissionResponse;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final Boolean getO() {
        return this.o;
    }

    @Nullable
    public final ControlLinkChatActivity s() {
        if (!(ActivityKt.e() instanceof ControlLinkChatActivity)) {
            return null;
        }
        Activity activityE = ActivityKt.e();
        Intrinsics.checkNotNull(activityE, "null cannot be cast to non-null type com.wear.ui.longDistance.controlLink.ControlLinkChatActivity");
        return (ControlLinkChatActivity) activityE;
    }

    /* renamed from: t, reason: from getter */
    public final boolean getM() {
        return this.m;
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final Boolean getD() {
        return this.d;
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final EntitySync.SyncOPTType getN() {
        return this.n;
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final Boolean getE() {
        return this.e;
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final String getB() {
        return this.b;
    }

    @Nullable
    /* renamed from: z, reason: from getter */
    public final ControlLinkBean.ControlPermissionResponse getA() {
        return this.a;
    }
}
