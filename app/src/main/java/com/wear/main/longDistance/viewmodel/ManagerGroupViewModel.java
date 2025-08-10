package com.wear.main.longDistance.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lovense.wear.R;
import com.wear.bean.Group;
import com.wear.bean.GroupMemberAdmin;
import com.wear.bean.GroupMemberRequest;
import com.wear.bean.IGroupMember;
import com.wear.bean.ManagerGroupStatus;
import com.wear.bean.event.GroupInvitationSettingEvent;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ch3;
import dc.g44;
import dc.o44;
import dc.q44;
import dc.sg3;
import dc.uy3;
import dc.wz3;
import dc.xc2;
import dc.zb2;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomSettingInfo;

/* compiled from: ManagerGroupViewModel.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0015J\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001bJ\u0006\u0010,\u001a\u00020\u001bJ\u0016\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020&R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u00062"}, d2 = {"Lcom/wear/main/longDistance/viewmodel/ManagerGroupViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wear/bean/ManagerGroupStatus;", "group", "Lcom/wear/bean/Group;", "getGroup", "()Lcom/wear/bean/Group;", "group$delegate", "Lkotlin/Lazy;", "groupMemberRepository", "Lcom/wear/main/longDistance/repository/GroupMemberRepository;", "getGroupMemberRepository", "()Lcom/wear/main/longDistance/repository/GroupMemberRepository;", "groupMemberRepository$delegate", "roomIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "getRoomIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "acceptInvitation", "", "item", "Lcom/wear/bean/GroupMemberRequest;", "getGroupName", "handlerGroupInvitationSettingEvent", "event", "Lcom/wear/bean/event/GroupInvitationSettingEvent;", "handlerOperateMemberRequest", SaslStreamElements.Response.ELEMENT, "Lorg/jivesoftware/smackx/disco/bean/response/BaseResponse;", "isSameRoom", "", "roomId", "rejectInvitation", "removeAdmin", "Lcom/wear/bean/GroupMemberAdmin;", "requestGroupManagerMemberList", "requestGroupSettingInfo", "updateGroupSetting", "mode", "", "isChecked", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ManagerGroupViewModel extends ViewModel {

    @NotNull
    public final o44<String> a;

    @NotNull
    public final Lazy b;

    @NotNull
    public final Lazy c;

    @NotNull
    public final g44<ManagerGroupStatus> d;

    @NotNull
    public final o44<ManagerGroupStatus> e;

    /* compiled from: ManagerGroupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.longDistance.viewmodel.ManagerGroupViewModel$acceptInvitation$1", f = "ManagerGroupViewModel.kt", i = {}, l = {CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ GroupMemberRequest $item;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupMemberRequest groupMemberRequest, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$item = groupMemberRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ManagerGroupViewModel.this.new a(this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                xc2 xc2VarG = ManagerGroupViewModel.this.g();
                if (xc2VarG != null) {
                    String jid = this.$item.getJid();
                    if (jid == null) {
                        return Unit.INSTANCE;
                    }
                    this.label = 1;
                    obj = xc2VarG.f(jid, true, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BaseResponse baseResponse = (BaseResponse) obj;
            if (baseResponse != null) {
                ManagerGroupViewModel.this.l(baseResponse, this.$item);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ManagerGroupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/bean/Group;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Group> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Group invoke() {
            return ch3.n().k(WearUtils.A0(ManagerGroupViewModel.this.i().getValue()));
        }
    }

    /* compiled from: ManagerGroupViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/longDistance/repository/GroupMemberRepository;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<xc2> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final xc2 invoke() {
            Group groupF = ManagerGroupViewModel.this.f();
            if (groupF != null) {
                return new xc2(groupF);
            }
            return null;
        }
    }

    /* compiled from: ManagerGroupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.longDistance.viewmodel.ManagerGroupViewModel$rejectInvitation$1", f = "ManagerGroupViewModel.kt", i = {}, l = {CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ GroupMemberRequest $item;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GroupMemberRequest groupMemberRequest, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$item = groupMemberRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ManagerGroupViewModel.this.new d(this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                xc2 xc2VarG = ManagerGroupViewModel.this.g();
                if (xc2VarG != null) {
                    String jid = this.$item.getJid();
                    if (jid == null) {
                        return Unit.INSTANCE;
                    }
                    this.label = 1;
                    obj = xc2VarG.f(jid, false, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BaseResponse baseResponse = (BaseResponse) obj;
            if (baseResponse != null) {
                ManagerGroupViewModel.this.l(baseResponse, this.$item);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ManagerGroupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.longDistance.viewmodel.ManagerGroupViewModel$removeAdmin$1", f = "ManagerGroupViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ GroupMemberAdmin $item;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(GroupMemberAdmin groupMemberAdmin, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$item = groupMemberAdmin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ManagerGroupViewModel.this.new e(this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object value;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                xc2 xc2VarG = ManagerGroupViewModel.this.g();
                if (xc2VarG == null) {
                    return Unit.INSTANCE;
                }
                String id = this.$item.getId();
                if (id == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                obj = xc2VarG.g(id, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                return Unit.INSTANCE;
            }
            g44 g44Var = ManagerGroupViewModel.this.d;
            GroupMemberAdmin groupMemberAdmin = this.$item;
            do {
                value = g44Var.getValue();
            } while (!g44Var.compareAndSet(value, new ManagerGroupStatus.RemoveAdmin(groupMemberAdmin)));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ManagerGroupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.longDistance.viewmodel.ManagerGroupViewModel$updateGroupSetting$1", f = "ManagerGroupViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $isChecked;
        public final /* synthetic */ int $mode;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i, boolean z, Continuation<? super f> continuation) {
            super(2, continuation);
            this.$mode = i;
            this.$isChecked = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ManagerGroupViewModel.this.new f(this.$mode, this.$isChecked, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                xc2 xc2VarG = ManagerGroupViewModel.this.g();
                if (xc2VarG == null) {
                    return Unit.INSTANCE;
                }
                int i2 = this.$mode;
                boolean z = this.$isChecked;
                this.label = 1;
                obj = xc2VarG.i(i2, z, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                ManagerGroupViewModel.this.q();
            } else {
                new ManagerGroupStatus.GroupCheckChange(this.$mode, !this.$isChecked);
            }
            return Unit.INSTANCE;
        }
    }

    public ManagerGroupViewModel(@NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.a = savedStateHandle.getStateFlow("roomId", null);
        this.b = LazyKt__LazyJVMKt.lazy(new b());
        this.c = LazyKt__LazyJVMKt.lazy(new c());
        g44<ManagerGroupStatus> g44VarA = q44.a(ManagerGroupStatus.Init.INSTANCE);
        this.d = g44VarA;
        this.e = g44VarA;
    }

    public final void a(@NotNull GroupMemberRequest item) {
        Intrinsics.checkNotNullParameter(item, "item");
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new a(item, null), 3, null);
    }

    public final Group f() {
        return (Group) this.b.getValue();
    }

    public final xc2 g() {
        return (xc2) this.c.getValue();
    }

    @Nullable
    public final String h() {
        Group groupF = f();
        if (groupF != null) {
            return groupF.getShowNickName();
        }
        return null;
    }

    @NotNull
    public final o44<String> i() {
        return this.a;
    }

    @NotNull
    public final o44<ManagerGroupStatus> j() {
        return this.e;
    }

    public final void k(@Nullable GroupInvitationSettingEvent groupInvitationSettingEvent) {
        if (groupInvitationSettingEvent != null && m(groupInvitationSettingEvent.roomId) && groupInvitationSettingEvent.suc && groupInvitationSettingEvent.responseRoomSettingInfo.suc()) {
            ResponseRoomSettingInfo responseRoomSettingInfo = groupInvitationSettingEvent.responseRoomSettingInfo;
            int memberCanInvite = responseRoomSettingInfo.getRoom().getMemberCanInvite();
            g44<ManagerGroupStatus> g44Var = this.d;
            do {
            } while (!g44Var.compareAndSet(g44Var.getValue(), new ManagerGroupStatus.GroupCheckChange(0, memberCanInvite == 1)));
            g44<ManagerGroupStatus> g44Var2 = this.d;
            do {
            } while (!g44Var2.compareAndSet(g44Var2.getValue(), new ManagerGroupStatus.GroupCheckChange(1, responseRoomSettingInfo.getRoom().getNeedApproval() == 1)));
        }
    }

    public final void l(BaseResponse baseResponse, GroupMemberRequest groupMemberRequest) {
        if (baseResponse.suc()) {
            g44<ManagerGroupStatus> g44Var = this.d;
            while (!g44Var.compareAndSet(g44Var.getValue(), new ManagerGroupStatus.OperateGroupMember(groupMemberRequest))) {
            }
            return;
        }
        if (baseResponse.getCode() == 50105) {
            sg3.l(ah4.e(R.string.group_chat_none_members));
            return;
        }
        if (baseResponse.getCode() == 50103) {
            sg3.l(ah4.e(R.string.group_user_create_50groups));
            return;
        }
        if (baseResponse.getCode() == 50104) {
            sg3.l(ah4.e(R.string.group_support_100people));
            return;
        }
        if (baseResponse.getCode() == 0) {
            sg3.l(ah4.g(baseResponse.getMsg() + ""));
            return;
        }
        sg3.l(WearUtils.a2() + baseResponse.code);
    }

    public final boolean m(@Nullable String str) {
        return Intrinsics.areEqual(str, this.a.getValue());
    }

    public final void n(@NotNull GroupMemberRequest item) {
        Intrinsics.checkNotNullParameter(item, "item");
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new d(item, null), 3, null);
    }

    public final void o(@NotNull GroupMemberAdmin item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (!Intrinsics.areEqual(item.getIsOwner(), Boolean.TRUE)) {
            uy3.d(ViewModelKt.getViewModelScope(this), null, null, new e(item, null), 3, null);
            return;
        }
        String strE = ah4.e(R.string.group_chat_dismiss_note);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.group_chat_dismiss_note)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{item.getName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        sg3.l(str);
    }

    public final void p() {
        List<IGroupMember> listH;
        xc2 xc2VarG = g();
        if (xc2VarG == null || (listH = xc2VarG.h()) == null) {
            return;
        }
        g44<ManagerGroupStatus> g44Var = this.d;
        while (!g44Var.compareAndSet(g44Var.getValue(), new ManagerGroupStatus.GroupMemberList(listH))) {
        }
    }

    public final void q() {
        zb2.O().R(this.a.getValue());
    }

    public final void r(int i, boolean z) {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new f(i, z, null), 3, null);
    }
}
