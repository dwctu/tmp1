package dc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseItemProvider.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u001d\u001a\u00020\u001e2\f\b\u0001\u0010\u001f\u001a\u00020 \"\u00020\u0006J\u0014\u0010!\u001a\u00020\u001e2\f\b\u0001\u0010\u001f\u001a\u00020 \"\u00020\u0006J\u001d\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H&¢\u0006\u0002\u0010&J+\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cH\u0016J\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J-\u0010-\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00102J-\u00103\u001a\u0002042\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00105J-\u00106\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00102J\u0018\u00107\u001a\u00020$2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0006H\u0016J-\u0010;\u001a\u0002042\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0002\u00105J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020$H\u0016J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020$H\u0016J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0006H\u0016J\u001b\u0010A\u001a\u00020\u001e2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0000¢\u0006\u0002\bCR+\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R+\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/chad/library/adapter/base/provider/BaseItemProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "clickViewIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getClickViewIds", "()Ljava/util/ArrayList;", "clickViewIds$delegate", "Lkotlin/Lazy;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "itemViewType", "getItemViewType", "()I", "layoutId", "getLayoutId", "longClickViewIds", "getLongClickViewIds", "longClickViewIds$delegate", "weakAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "addChildClickViewIds", "", "ids", "", "addChildLongClickViewIds", "convert", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "payloads", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "getAdapter", "getChildClickViewIds", "getChildLongClickViewIds", "onChildClick", "view", "Landroid/view/View;", "data", "position", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)V", "onChildLongClick", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)Z", "onClick", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onLongClick", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "onViewHolderCreated", "viewHolder", "setAdapter", "adapter", "setAdapter$com_github_CymChad_brvah", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class lr<T> {

    @Nullable
    public WeakReference<BaseProviderMultiAdapter<T>> a;

    @NotNull
    public final Lazy b;

    @NotNull
    public final Lazy c;

    /* compiled from: BaseItemProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003\"\u0004\b\u0000\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<ArrayList<Integer>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ArrayList<Integer> invoke() {
            return new ArrayList<>();
        }
    }

    /* compiled from: BaseItemProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003\"\u0004\b\u0000\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<ArrayList<Integer>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ArrayList<Integer> invoke() {
            return new ArrayList<>();
        }
    }

    public lr() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.b = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) a.a);
        this.c = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) b.a);
    }

    public abstract void a(@NotNull BaseViewHolder baseViewHolder, T t);

    public void b(@NotNull BaseViewHolder helper, T t, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    @Nullable
    public BaseProviderMultiAdapter<T> c() {
        WeakReference<BaseProviderMultiAdapter<T>> weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final ArrayList<Integer> d() {
        return f();
    }

    @NotNull
    public final ArrayList<Integer> e() {
        return i();
    }

    public final ArrayList<Integer> f() {
        return (ArrayList) this.b.getValue();
    }

    public abstract int g();

    @LayoutRes
    public abstract int h();

    public final ArrayList<Integer> i() {
        return (ArrayList) this.c.getValue();
    }

    public void j(@NotNull BaseViewHolder helper, @NotNull View view, T t, int i) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public boolean k(@NotNull BaseViewHolder helper, @NotNull View view, T t, int i) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    public void l(@NotNull BaseViewHolder helper, @NotNull View view, T t, int i) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @NotNull
    public BaseViewHolder m(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new BaseViewHolder(mr.a(parent, h()));
    }

    public boolean n(@NotNull BaseViewHolder helper, @NotNull View view, T t, int i) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    public void o(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void p(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void q(@NotNull BaseViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public final void r(@NotNull BaseProviderMultiAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.a = new WeakReference<>(adapter);
    }

    public final void s(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
    }
}
