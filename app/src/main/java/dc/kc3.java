package dc;

import com.wear.bean.me.OnlineStatusUserBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: OnlineStatusUserIntent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/wear/ui/me/intent/OnlineStatusUserIntent;", "", "()V", "FriendList", "Lcom/wear/ui/me/intent/OnlineStatusUserIntent$FriendList;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public abstract class kc3 {

    /* compiled from: OnlineStatusUserIntent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/ui/me/intent/OnlineStatusUserIntent$FriendList;", "Lcom/wear/ui/me/intent/OnlineStatusUserIntent;", "list", "", "Lcom/wear/bean/me/OnlineStatusUserBean;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends kc3 {

        @NotNull
        public final List<OnlineStatusUserBean> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull List<OnlineStatusUserBean> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.a = list;
        }

        @NotNull
        public final List<OnlineStatusUserBean> a() {
            return this.a;
        }
    }

    public kc3() {
    }

    public /* synthetic */ kc3(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
