package com.wear.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ManagerGroupStatus.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/wear/bean/ManagerGroupStatus;", "", "()V", "GroupCheckChange", "GroupMemberList", "Init", "OperateGroupMember", "RemoveAdmin", "Lcom/wear/bean/ManagerGroupStatus$GroupCheckChange;", "Lcom/wear/bean/ManagerGroupStatus$GroupMemberList;", "Lcom/wear/bean/ManagerGroupStatus$Init;", "Lcom/wear/bean/ManagerGroupStatus$OperateGroupMember;", "Lcom/wear/bean/ManagerGroupStatus$RemoveAdmin;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ManagerGroupStatus {

    /* compiled from: ManagerGroupStatus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/wear/bean/ManagerGroupStatus$GroupCheckChange;", "Lcom/wear/bean/ManagerGroupStatus;", "mode", "", "isChecked", "", "(IZ)V", "()Z", "getMode", "()I", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GroupCheckChange extends ManagerGroupStatus {
        private final boolean isChecked;
        private final int mode;

        public GroupCheckChange(int i, boolean z) {
            super(null);
            this.mode = i;
            this.isChecked = z;
        }

        public final int getMode() {
            return this.mode;
        }

        /* renamed from: isChecked, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }
    }

    /* compiled from: ManagerGroupStatus.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/bean/ManagerGroupStatus$GroupMemberList;", "Lcom/wear/bean/ManagerGroupStatus;", "list", "", "Lcom/wear/bean/IGroupMember;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GroupMemberList extends ManagerGroupStatus {

        @NotNull
        private final List<IGroupMember> list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupMemberList(@NotNull List<IGroupMember> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        @NotNull
        public final List<IGroupMember> getList() {
            return this.list;
        }
    }

    /* compiled from: ManagerGroupStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/ManagerGroupStatus$Init;", "Lcom/wear/bean/ManagerGroupStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Init extends ManagerGroupStatus {

        @NotNull
        public static final Init INSTANCE = new Init();

        private Init() {
            super(null);
        }
    }

    /* compiled from: ManagerGroupStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/ManagerGroupStatus$OperateGroupMember;", "Lcom/wear/bean/ManagerGroupStatus;", "item", "Lcom/wear/bean/IGroupMember;", "(Lcom/wear/bean/IGroupMember;)V", "getItem", "()Lcom/wear/bean/IGroupMember;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class OperateGroupMember extends ManagerGroupStatus {

        @NotNull
        private final IGroupMember item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OperateGroupMember(@NotNull IGroupMember item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        @NotNull
        public final IGroupMember getItem() {
            return this.item;
        }
    }

    /* compiled from: ManagerGroupStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/ManagerGroupStatus$RemoveAdmin;", "Lcom/wear/bean/ManagerGroupStatus;", "item", "Lcom/wear/bean/IGroupMember;", "(Lcom/wear/bean/IGroupMember;)V", "getItem", "()Lcom/wear/bean/IGroupMember;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RemoveAdmin extends ManagerGroupStatus {

        @NotNull
        private final IGroupMember item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveAdmin(@NotNull IGroupMember item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        @NotNull
        public final IGroupMember getItem() {
            return this.item;
        }
    }

    private ManagerGroupStatus() {
    }

    public /* synthetic */ ManagerGroupStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
