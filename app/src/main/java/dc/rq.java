package dc;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.diff.BrvahListUpdateCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* compiled from: BrvahAsyncDiffer.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001/B%\u0012\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00132\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J%\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00028\u00002\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0013J(\u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J \u0010(\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0013\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000eJ\u0014\u0010-\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ$\u0010.\u001a\u00020\u00132\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007R\u0018\u0010\u0003\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/diff/DifferImp;", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "config", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;)V", "mListeners", "", "Lcom/chad/library/adapter/base/diff/ListChangeListener;", "mMainThreadExecutor", "Ljava/util/concurrent/Executor;", "mMaxScheduledGeneration", "", "mUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "sMainThreadExecutor", "addData", "", "data", "(Ljava/lang/Object;)V", FirebaseAnalytics.Param.INDEX, "(ILjava/lang/Object;)V", "addList", "list", "", "addListListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "changeData", "newData", "payload", "(ILjava/lang/Object;Ljava/lang/Object;)V", "clearAllListListener", "latchList", "newList", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "commitCallback", "Ljava/lang/Runnable;", "onCurrentListChanged", "previousList", DiscoverItems.Item.REMOVE_ACTION, "t", "removeAt", "removeListListener", "submitList", "MainThreadExecutor", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class rq<T> {

    @NotNull
    public final BaseQuickAdapter<T, ?> a;

    @NotNull
    public final sq<T> b;

    @NotNull
    public Executor c;

    @NotNull
    public final Executor d;

    /* compiled from: BrvahAsyncDiffer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer$MainThreadExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "execute", "", "command", "Ljava/lang/Runnable;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Executor {

        @NotNull
        public final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NotNull Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            this.a.post(command);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.concurrent.Executor] */
    public rq(@NotNull BaseQuickAdapter<T, ?> adapter, @NotNull sq<T> config) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(config, "config");
        this.a = adapter;
        this.b = config;
        new BrvahListUpdateCallback(adapter);
        a aVar = new a();
        this.d = aVar;
        ?? a2 = config.getA();
        this.c = a2 != 0 ? a2 : aVar;
        new CopyOnWriteArrayList();
    }
}
