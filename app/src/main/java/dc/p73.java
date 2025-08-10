package dc;

import android.app.Activity;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.C;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.BaseActivity;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.AddFriendsRefreshList;
import com.wear.bean.event.ClearChatViewFriendIdEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.ext.ActivityKt;
import com.wear.util.WearUtils;
import dc.h14;
import dc.p73;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomExit;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;

/* compiled from: GroupRelationshipActionImpl.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0016\u0010 \u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/wear/ui/longDistance/action/impl/GroupRelationshipActionImpl;", "Lcom/wear/ui/longDistance/action/GroupRelationshipAction;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "email", "", "(Landroidx/lifecycle/LifecycleCoroutineScope;Ljava/lang/String;)V", "userSettingBean", "Lcom/wear/bean/UserSettingsBean;", "getUserSettingBean", "()Lcom/wear/bean/UserSettingsBean;", "userSettingBean$delegate", "Lkotlin/Lazy;", "addGroupToMuteNotification", "", "addGroupToTop", "clearGroupChatHistory", "deleteGroup", "dismissProgress", "isGroupMuteNotification", "", "isGroupTop", "leaveGroup", Callback.METHOD_NAME, "Lkotlin/Function0;", "notifyWorkActionMaskFlag", "isMute", "notifyWorkActionTop", "isTop", "removeGroupToMuteNotification", "removeGroupToTop", "showProgress", "trySendXmppMessage", AMPExtension.Action.ATTRIBUTE_NAME, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class p73 implements g73 {

    @NotNull
    public final LifecycleCoroutineScope a;

    @NotNull
    public final String b;

    @NotNull
    public final Lazy c;

    /* compiled from: GroupRelationshipActionImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Unit unit;
            UserSettingsBean userSettingsBeanQ = p73.this.q();
            if (userSettingsBeanQ != null) {
                userSettingsBeanQ.setMuteFlag(1);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                String strK0 = WearUtils.k0(p73.this.b);
                WearUtils.x.i.F(strK0, 1);
                WearUtils.x.i.B(true, strK0);
            }
            p73.this.t(true);
        }
    }

    /* compiled from: GroupRelationshipActionImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        public static final void a(p73 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            EventBus.getDefault().post(new AddFriendsRefreshList());
            ye3.d("F0012", WearUtils.A.toJson(MapsKt__MapsKt.mapOf(TuplesKt.to("who_oppo", WearUtils.k0(this$0.b)), TuplesKt.to("invite_result", 3))));
            this$0.p();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            p73.this.v();
            ch3 ch3VarN = ch3.n();
            String str = p73.this.b;
            final p73 p73Var = p73.this;
            ch3VarN.I(str, new dv1() { // from class: dc.k73
                @Override // dc.dv1
                public final void d() {
                    p73.b.a(p73Var);
                }
            });
        }
    }

    /* compiled from: GroupRelationshipActionImpl.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/wear/ui/longDistance/action/impl/GroupRelationshipActionImpl$leaveGroup$1", "Lcom/wear/listenter/Listener;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponse", SaslStreamElements.Response.ELEMENT, "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements kv1 {
        public final /* synthetic */ Function0<Unit> a;

        public c(Function0<Unit> function0) {
            this.a = function0;
        }

        @Override // dc.kv1
        public void a(@Nullable String str) {
            if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                this.a.invoke();
                EventBus.getDefault().post(new AddFriendsRefreshList());
            }
        }

        @Override // dc.kv1
        public void onError(@Nullable Exception e) {
        }
    }

    /* compiled from: GroupRelationshipActionImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Unit> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Unit unit;
            UserSettingsBean userSettingsBeanQ = p73.this.q();
            if (userSettingsBeanQ != null) {
                userSettingsBeanQ.setMuteFlag(0);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                String strK0 = WearUtils.k0(p73.this.b);
                WearUtils.x.i.F(strK0, 0);
                WearUtils.x.i.B(false, strK0);
            }
            p73.this.t(false);
        }
    }

    /* compiled from: GroupRelationshipActionImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.action.impl.GroupRelationshipActionImpl$trySendXmppMessage$delayJob$1", f = "GroupRelationshipActionImpl.kt", i = {}, l = {CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return p73.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            p73.this.p();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: GroupRelationshipActionImpl.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/longDistance/action/impl/GroupRelationshipActionImpl$trySendXmppMessage$runablePoxy$2", "Lcom/wear/backwork/XmppLoginListener;", "fail", "", "suc", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements ip1 {
        public final /* synthetic */ h14 b;

        public f(h14 h14Var) {
            this.b = h14Var;
        }

        @Override // dc.ip1
        public void G() {
            p73.this.p();
        }

        @Override // dc.ip1
        public void d() {
            h14.a.a(this.b, null, 1, null);
            p73.this.p();
        }
    }

    /* compiled from: GroupRelationshipActionImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/bean/UserSettingsBean;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<UserSettingsBean> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserSettingsBean invoke() {
            return WearUtils.x.i.g(WearUtils.j0(p73.this.b));
        }
    }

    public p73(@NotNull LifecycleCoroutineScope lifecycleScope, @NotNull String email) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(email, "email");
        this.a = lifecycleScope;
        this.b = email;
        this.c = LazyKt__LazyJVMKt.lazy(new g());
    }

    public static final void o(p73 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String strK0 = WearUtils.k0(this$0.b);
        WearUtils.A(strK0);
        DaoUtils.getCommunMessageDao().deleteByFriendEmail(this$0.b);
        DaoUtils.getEmojiFavoriteDao().deleteAllOwner(this$0.b);
        DaoUtils.getMessageHideDao().deleteAllHides(WearUtils.i0(zt3.k), strK0);
        DaoUtils.getMessageUnReadDao().deleteAllUnRead(WearUtils.i0(zt3.k), strK0);
        df3.e().c(this$0.b);
        EventBus.getDefault().post(new ClearChatViewFriendIdEvent(this$0.b));
        this$0.p();
        EventBus.getDefault().post(new AddFriendsRefreshList());
    }

    public static final void x(p73 this$0, Function0 action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        this$0.p();
        action.invoke();
    }

    @Override // dc.g73
    public void a() {
        Unit unit;
        UserSettingsBean userSettingsBeanQ = q();
        if (userSettingsBeanQ != null) {
            userSettingsBeanQ.setSetTop(0L);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            WearUtils.x.i.E(WearUtils.k0(this.b), 0L);
        }
        u(false);
    }

    @Override // dc.g73
    public void b() {
        w(new a());
    }

    @Override // dc.g73
    public void c() {
        Unit unit;
        UserSettingsBean userSettingsBeanQ = q();
        if (userSettingsBeanQ != null) {
            userSettingsBeanQ.setSetTop(be3.I().getTime());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            WearUtils.x.i.E(WearUtils.k0(this.b), be3.I().getTime());
        }
        u(true);
    }

    @Override // dc.g73
    public void d(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        RequestRoomExit requestRoomExit = new RequestRoomExit();
        requestRoomExit.setRoomId(this.b);
        requestRoomExit.setStatus(2);
        zb2.O().C0(requestRoomExit, WearUtils.k0(this.b), new c(callback));
    }

    @Override // dc.g73
    public void e() {
        w(new d());
    }

    @Override // dc.g73
    public boolean f() {
        UserSettingsBean userSettingsBeanQ = q();
        return (userSettingsBeanQ != null ? userSettingsBeanQ.getSetTop() : 0L) > 0;
    }

    @Override // dc.g73
    public void g() {
        IPeopleInfo iPeopleInfoS = ch3.n().s(this.b);
        if (iPeopleInfoS == null) {
            return;
        }
        if (na2.m().k(iPeopleInfoS)) {
            sg3.l(ah4.e(R.string.delete_failure));
        } else {
            w(new b());
        }
    }

    @Override // dc.g73
    public boolean h() {
        UserSettingsBean userSettingsBeanQ = q();
        return (userSettingsBeanQ != null ? userSettingsBeanQ.getMuteFlag() : 0) > 0;
    }

    @Override // dc.g73
    public void i() {
        v();
        vg3.b().a(new Runnable() { // from class: dc.j73
            @Override // java.lang.Runnable
            public final void run() {
                p73.o(this.a);
            }
        });
    }

    public final void p() {
        Activity activityE = ActivityKt.e();
        BaseActivity baseActivity = activityE instanceof BaseActivity ? (BaseActivity) activityE : null;
        if (baseActivity != null) {
            baseActivity.dismissLoadingProgress();
        }
    }

    public final UserSettingsBean q() {
        return (UserSettingsBean) this.c.getValue();
    }

    public final void t(boolean z) {
        String str = "jid=" + WearUtils.k0(this.b) + "&isOpen=" + (z ? 1 : 0) + "&time=" + be3.I().getTime();
        HashMap map = new HashMap();
        map.put("isChecked", String.valueOf(z));
        String str2 = this.b;
        int length = str2.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        map.put("friendEmail", str2.subSequence(i, length + 1).toString());
        String str3 = this.b;
        int length2 = str3.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length2) {
            boolean z5 = Intrinsics.compare((int) str3.charAt(!z4 ? i2 : length2), 32) <= 0;
            if (z4) {
                if (!z5) {
                    break;
                } else {
                    length2--;
                }
            } else if (z5) {
                i2++;
            } else {
                z4 = true;
            }
        }
        hp1.b(str, map, true, str3.subSequence(i2, length2 + 1).toString());
        EventBus.getDefault().post(new AddFriendsRefreshList());
    }

    public final void u(boolean z) {
        String str = "jid=" + WearUtils.k0(this.b) + "&isOpen=" + (z ? 1 : 0) + "&time=" + be3.I().getTime();
        HashMap map = new HashMap();
        map.put("isChecked", String.valueOf(z));
        String str2 = this.b;
        int length = str2.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        map.put("friendEmail", str2.subSequence(i, length + 1).toString());
        String str3 = this.b;
        int length2 = str3.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length2) {
            boolean z5 = Intrinsics.compare((int) str3.charAt(!z4 ? i2 : length2), 32) <= 0;
            if (z4) {
                if (!z5) {
                    break;
                } else {
                    length2--;
                }
            } else if (z5) {
                i2++;
            } else {
                z4 = true;
            }
        }
        hp1.c(str, map, true, str3.subSequence(i2, length2 + 1).toString());
        EventBus.getDefault().post(new AddFriendsRefreshList());
    }

    public final void v() {
        Activity activityE = ActivityKt.e();
        BaseActivity baseActivity = activityE instanceof BaseActivity ? (BaseActivity) activityE : null;
        if (baseActivity != null) {
            baseActivity.showLoadingProgress();
        }
    }

    public final void w(final Function0<Unit> function0) {
        gp1 gp1Var = new gp1(new Runnable() { // from class: dc.i73
            @Override // java.lang.Runnable
            public final void run() {
                p73.x(this.a, function0);
            }
        }, new f(uy3.d(this.a, null, null, new e(null), 3, null)));
        v();
        ep1.b().r(this, gp1Var);
    }
}
