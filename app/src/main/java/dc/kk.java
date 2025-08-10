package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class kk<A, B> {
    public final sp<b<A>, B> a;

    /* compiled from: ModelCache.java */
    public class a extends sp<b<A>, B> {
        public a(kk kkVar, long j) {
            super(j);
        }

        @Override // dc.sp
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(@NonNull b<A> bVar, @Nullable B b) {
            bVar.c();
        }
    }

    /* compiled from: ModelCache.java */
    @VisibleForTesting
    public static final class b<A> {
        public static final Queue<b<?>> d = wp.f(0);
        public int a;
        public int b;
        public A c;

        public static <A> b<A> a(A a, int i, int i2) {
            b<A> bVar;
            Queue<b<?>> queue = d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a, i, i2);
            return bVar;
        }

        public final void b(A a, int i, int i2) {
            this.c = a;
            this.b = i;
            this.a = i2;
        }

        public void c() {
            Queue<b<?>> queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c);
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public kk(long j) {
        this.a = new a(this, j);
    }

    @Nullable
    public B a(A a2, int i, int i2) {
        b<A> bVarA = b.a(a2, i, i2);
        B bG = this.a.g(bVarA);
        bVarA.c();
        return bG;
    }

    public void b(A a2, int i, int i2, B b2) {
        this.a.k(b.a(a2, i, i2), b2);
    }
}
