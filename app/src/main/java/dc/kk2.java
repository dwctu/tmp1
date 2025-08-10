package dc;

import com.component.dxtoy.business.longc.aapattern.bean.AAPatternItemBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PatternIterator.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003J\u0014\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018J\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/wear/main/toy/solacepro/pattern/iterator/PatternIterator;", "", "batchSize", "", "isRange100", "", "(IZ)V", "cmdIndex", "data", "", "Lcom/component/dxtoy/business/longc/aapattern/bean/AAPatternItemBean;", "finishInsertData", "isFirstBatch", "()Z", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "sendDataCount", "cleanData", "", "getDataSize", "getNextSendSize", "insert", "cmdValue", "insertList", "", "next", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class kk2 {
    public final int a;
    public final boolean b;
    public int f;

    @NotNull
    public List<AAPatternItemBean> c = new ArrayList();
    public boolean d = true;
    public int e = 1;

    @NotNull
    public final ReentrantLock g = new ReentrantLock();

    public kk2(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public final void a() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            this.c.clear();
            this.e = 1;
            this.d = true;
            this.f = 0;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int b() {
        return this.c.size();
    }

    public final int c() {
        return RangesKt___RangesKt.coerceAtMost(this.c.size() - this.f, this.a);
    }

    public final boolean d(@NotNull List<Integer> cmdValue) {
        Intrinsics.checkNotNullParameter(cmdValue, "cmdValue");
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(cmdValue, 10));
            Iterator<T> it = cmdValue.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                int i = this.e;
                this.e = i + 1;
                arrayList.add(new AAPatternItemBean(i, iIntValue));
            }
            return this.c.addAll(arrayList);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: e, reason: from getter */
    public final boolean getB() {
        return this.b;
    }

    @Nullable
    public final List<AAPatternItemBean> f() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            de0.v("zbf", "pattern data size = " + this.c.size() + " , lastSendDataIndex = " + this.f);
            if (this.f >= this.c.size()) {
                return null;
            }
            int i = this.d ? this.a * 2 : this.a;
            this.d = false;
            int iMin = Math.min(this.f + i, this.c.size());
            List<AAPatternItemBean> listSubList = this.c.subList(this.f, iMin);
            this.f = iMin;
            return listSubList;
        } finally {
            reentrantLock.unlock();
        }
    }
}
