package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.z64;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: ThreadSafeHeap.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000602j\u0002`3B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0005J\u0011\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b \u0010\u0012J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010¢\u0006\u0004\b$\u0010#J\u001f\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'R \u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u0010#¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", DiscoverItems.Item.REMOVE_ACTION, "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", FirebaseAnalytics.Param.INDEX, "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class y64<T extends z64 & Comparable<? super T>> {

    @NotNull
    private volatile /* synthetic */ int _size = 0;

    @Nullable
    public T[] a;

    @PublishedApi
    public final void a(@NotNull T t) {
        if (a04.a()) {
            if (!(t.b() == null)) {
                throw new AssertionError();
            }
        }
        t.a(this);
        z64[] z64VarArrF = f();
        int i = get_size();
        j(i + 1);
        z64VarArrF[i] = t;
        t.setIndex(i);
        l(i);
    }

    @PublishedApi
    @Nullable
    public final T b() {
        T[] tArr = this.a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    /* renamed from: c, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean d() {
        return get_size() == 0;
    }

    @Nullable
    public final T e() {
        T t;
        synchronized (this) {
            t = (T) b();
        }
        return t;
    }

    public final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new z64[4];
            this.a = tArr2;
            return tArr2;
        }
        if (get_size() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, get_size() * 2);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((z64[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    public final boolean g(@NotNull T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.b() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (a04.a()) {
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(index);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T h(int r8) {
        /*
            r7 = this;
            boolean r0 = dc.a04.a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1a
            int r0 = r7.get_size()
            if (r0 <= 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L14
            goto L1a
        L14:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L1a:
            T extends dc.z64 & java.lang.Comparable<? super T>[] r0 = r7.a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r3 = r7.get_size()
            r4 = -1
            int r3 = r3 + r4
            r7.j(r3)
            int r3 = r7.get_size()
            if (r8 >= r3) goto L57
            int r3 = r7.get_size()
            r7.m(r8, r3)
            int r3 = r8 + (-1)
            int r3 = r3 / 2
            if (r8 <= 0) goto L54
            r5 = r0[r8]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            r6 = r0[r3]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L54
            r7.m(r8, r3)
            r7.l(r3)
            goto L57
        L54:
            r7.k(r8)
        L57:
            int r8 = r7.get_size()
            r8 = r0[r8]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            boolean r3 = dc.a04.a()
            if (r3 == 0) goto L76
            dc.y64 r3 = r8.b()
            if (r3 != r7) goto L6d
            r1 = 1
        L6d:
            if (r1 == 0) goto L70
            goto L76
        L70:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L76:
            r1 = 0
            r8.a(r1)
            r8.setIndex(r4)
            int r2 = r7.get_size()
            r0[r2] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.y64.h(int):dc.z64");
    }

    @Nullable
    public final T i() {
        T t;
        synchronized (this) {
            t = get_size() > 0 ? (T) h(0) : null;
        }
        return t;
    }

    public final void j(int i) {
        this._size = i;
    }

    public final void k(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= get_size()) {
                return;
            }
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i3 = i2 + 1;
            if (i3 < get_size()) {
                T t = tArr[i3];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            Intrinsics.checkNotNull(t3);
            T t4 = tArr[i2];
            Intrinsics.checkNotNull(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    public final void l(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    public final void m(int i, int i2) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[i2];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }
}
