package dc;

import com.alibaba.fastjson.JSON;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.GroupMemberAdmin;
import com.wear.bean.GroupMemberHeader;
import com.wear.bean.GroupMemberRequest;
import com.wear.bean.IGroupMember;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.disco.bean.request.RequestInvitationApprove;
import org.jivesoftware.smackx.disco.bean.request.RequestMembersRemove;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomSetpermission;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomInvitationList;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;

/* compiled from: GroupMemberRepository.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ!\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002J\u001c\u0010\u001a\u001a\u00020\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/wear/main/longDistance/repository/GroupMemberRepository;", "", "group", "Lcom/wear/bean/Group;", "(Lcom/wear/bean/Group;)V", "operateMemberRequest", "Lorg/jivesoftware/smackx/disco/bean/response/BaseResponse;", "memberId", "", "accept", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAdmin", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestGroupManagerMemberList", "", "Lcom/wear/bean/IGroupMember;", "updateGroupInvitationSetting", "mode", "", "isChecked", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlerSuspendCancellableCoroutine", "", "Lkotlinx/coroutines/CancellableContinuation;", DeliveryReceiptRequest.ELEMENT, "handlerSuspendCancellableCoroutineResponse", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class xc2 {

    @NotNull
    public final Group a;

    /* compiled from: GroupMemberRepository.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/wear/main/longDistance/repository/GroupMemberRepository$handlerSuspendCancellableCoroutine$1", "Lcom/wear/listenter/Listener;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponse", SaslStreamElements.Response.ELEMENT, "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements kv1 {
        public final /* synthetic */ yy3<Boolean> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(yy3<? super Boolean> yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.kv1
        public void a(@Nullable String str) {
            BaseResponse baseResponse = (BaseResponse) JSON.parseObject(str, BaseResponse.class);
            yy3<Boolean> yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(Boolean.valueOf(baseResponse.suc())));
        }

        @Override // dc.kv1
        public void onError(@Nullable Exception e) {
            yy3<Boolean> yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(Boolean.FALSE));
        }
    }

    /* compiled from: GroupMemberRepository.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/wear/main/longDistance/repository/GroupMemberRepository$handlerSuspendCancellableCoroutineResponse$1", "Lcom/wear/listenter/Listener;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponse", SaslStreamElements.Response.ELEMENT, "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements kv1 {
        public final /* synthetic */ yy3<BaseResponse> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(yy3<? super BaseResponse> yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.kv1
        public void a(@Nullable String str) {
            BaseResponse baseResponse = (BaseResponse) JSON.parseObject(str, BaseResponse.class);
            yy3<BaseResponse> yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponse));
        }

        @Override // dc.kv1
        public void onError(@Nullable Exception e) {
            yy3<BaseResponse> yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    public xc2(@NotNull Group group) {
        Intrinsics.checkNotNullParameter(group, "group");
        this.a = group;
    }

    public final void d(yy3<? super Boolean> yy3Var, Object obj) {
        zb2.O().C0(obj, WearUtils.k0(this.a.getId()), new a(yy3Var));
    }

    public final void e(yy3<? super BaseResponse> yy3Var, Object obj) {
        zb2.O().C0(obj, WearUtils.k0(this.a.getId()), new b(yy3Var));
    }

    @Nullable
    public final Object f(@NotNull String str, boolean z, @NotNull Continuation<? super BaseResponse> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        RequestInvitationApprove requestInvitationApprove = new RequestInvitationApprove();
        requestInvitationApprove.setRoomId(this.a.getId());
        requestInvitationApprove.setJid(str);
        requestInvitationApprove.setApproval(z ? 1 : 2);
        e(zy3Var, requestInvitationApprove);
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        RequestMembersRemove requestMembersRemove = new RequestMembersRemove();
        requestMembersRemove.setRoomId(this.a.getId());
        requestMembersRemove.setType(2);
        requestMembersRemove.setJid(WearUtils.i0(str));
        d(zy3Var, requestMembersRemove);
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @NotNull
    public final List<IGroupMember> h() {
        ArrayList arrayList = new ArrayList();
        ArrayList<GroupMember> list = this.a.getList();
        Intrinsics.checkNotNullExpressionValue(list, "group.list");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((GroupMember) obj).isAdmin()) {
                arrayList2.add(obj);
            }
        }
        List<GroupMember> listSortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new r12());
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSortedWith, 10));
        for (GroupMember groupMember : listSortedWith) {
            arrayList3.add(new GroupMemberAdmin(groupMember.getId(), groupMember.getNickName(), groupMember.getAvatar(), Boolean.valueOf(groupMember.isOwrn())));
        }
        arrayList.addAll(arrayList3);
        List<ResponseRoomInvitationList.InvitationListBean> invitationList = this.a.getInvitationList();
        Intrinsics.checkNotNullExpressionValue(invitationList, "group.invitationList");
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(invitationList, 10));
        for (ResponseRoomInvitationList.InvitationListBean invitationListBean : invitationList) {
            arrayList4.add(new GroupMemberRequest(invitationListBean.getJid(), invitationListBean.getNickName(), invitationListBean.getAvatar(), Integer.valueOf(invitationListBean.getType()), invitationListBean.getInvitedBy()));
        }
        if (!arrayList4.isEmpty()) {
            arrayList.add(new GroupMemberHeader(arrayList4.size()));
            arrayList.addAll(arrayList4);
        }
        return arrayList;
    }

    @Nullable
    public final Object i(int i, boolean z, @NotNull Continuation<? super Boolean> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        RequestRoomSetpermission requestRoomSetpermission = new RequestRoomSetpermission();
        requestRoomSetpermission.setRoomId(this.a.getId());
        if (i == 0) {
            requestRoomSetpermission.setMemberCanInvite(z ? Boxing.boxInt(1) : Boxing.boxInt(2));
        } else if (i == 1) {
            requestRoomSetpermission.setNeedApproval(z ? Boxing.boxInt(1) : Boxing.boxInt(2));
        }
        d(zy3Var, requestRoomSetpermission);
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }
}
