package dc;

import com.wear.bean.ConnectionUserBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConnectionsIntent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/wear/ui/longDistance/intent/ConnectionsIntent;", "", "()V", "AcceptUserRequest", "ConnectionsFriendList", "ConnectionsRequestList", "RejectUserRequest", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent$AcceptUserRequest;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent$ConnectionsFriendList;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent$ConnectionsRequestList;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent$RejectUserRequest;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public abstract class r93 {

    /* compiled from: ConnectionsIntent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/longDistance/intent/ConnectionsIntent$AcceptUserRequest;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent;", "email", "", "(Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends r93 {

        @NotNull
        public final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.a = email;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getA() {
            return this.a;
        }
    }

    /* compiled from: ConnectionsIntent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/ui/longDistance/intent/ConnectionsIntent$ConnectionsFriendList;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent;", "list", "", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends r93 {

        @NotNull
        public final List<tq> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull List<tq> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.a = list;
        }

        @NotNull
        public final List<tq> a() {
            return this.a;
        }
    }

    /* compiled from: ConnectionsIntent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/ui/longDistance/intent/ConnectionsIntent$ConnectionsRequestList;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent;", "list", "", "Lcom/wear/bean/ConnectionUserBean;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends r93 {

        @NotNull
        public final List<ConnectionUserBean> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull List<ConnectionUserBean> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.a = list;
        }

        @NotNull
        public final List<ConnectionUserBean> a() {
            return this.a;
        }
    }

    /* compiled from: ConnectionsIntent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/longDistance/intent/ConnectionsIntent$RejectUserRequest;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent;", "email", "", "(Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends r93 {

        @NotNull
        public final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.a = email;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getA() {
            return this.a;
        }
    }

    public r93() {
    }

    public /* synthetic */ r93(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
