package dc;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import dc.la;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class h8 implements i8, f8 {
    public final Path a = new Path();
    public final Path b = new Path();
    public final Path c = new Path();
    public final List<i8> d = new ArrayList();
    public final la e;

    /* compiled from: MergePathsContent.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[la.a.values().length];
            a = iArr;
            try {
                iArr[la.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[la.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[la.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[la.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[la.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public h8(la laVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        laVar.c();
        this.e = laVar;
    }

    public final void a() {
        for (int i = 0; i < this.d.size(); i++) {
            this.c.addPath(this.d.get(i).getPath());
        }
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        for (int i = 0; i < this.d.size(); i++) {
            this.d.get(i).b(list, list2);
        }
    }

    @TargetApi(19)
    public final void c(Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.d.size() - 1; size >= 1; size--) {
            i8 i8Var = this.d.get(size);
            if (i8Var instanceof z7) {
                z7 z7Var = (z7) i8Var;
                List<i8> listI = z7Var.i();
                for (int size2 = listI.size() - 1; size2 >= 0; size2--) {
                    Path path = listI.get(size2).getPath();
                    path.transform(z7Var.j());
                    this.b.addPath(path);
                }
            } else {
                this.b.addPath(i8Var.getPath());
            }
        }
        i8 i8Var2 = this.d.get(0);
        if (i8Var2 instanceof z7) {
            z7 z7Var2 = (z7) i8Var2;
            List<i8> listI2 = z7Var2.i();
            for (int i = 0; i < listI2.size(); i++) {
                Path path2 = listI2.get(i).getPath();
                path2.transform(z7Var2.j());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(i8Var2.getPath());
        }
        this.c.op(this.a, this.b, op);
    }

    @Override // dc.f8
    public void f(ListIterator<y7> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            y7 y7VarPrevious = listIterator.previous();
            if (y7VarPrevious instanceof i8) {
                this.d.add((i8) y7VarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // dc.i8
    public Path getPath() {
        this.c.reset();
        if (this.e.d()) {
            return this.c;
        }
        int i = a.a[this.e.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            c(Path.Op.UNION);
        } else if (i == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            c(Path.Op.INTERSECT);
        } else if (i == 5) {
            c(Path.Op.XOR);
        }
        return this.c;
    }
}
