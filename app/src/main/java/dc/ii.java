package dc;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
public abstract class ii {
    public static final ii a = new a();
    public static final ii b = new b();
    public static final ii c = new c();
    public static final ii d = new d();
    public static final ii e = new e();

    /* compiled from: DiskCacheStrategy.java */
    public class a extends ii {
        @Override // dc.ii
        public boolean a() {
            return true;
        }

        @Override // dc.ii
        public boolean b() {
            return true;
        }

        @Override // dc.ii
        public boolean c(sg sgVar) {
            return sgVar == sg.REMOTE;
        }

        @Override // dc.ii
        public boolean d(boolean z, sg sgVar, ug ugVar) {
            return (sgVar == sg.RESOURCE_DISK_CACHE || sgVar == sg.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    public class b extends ii {
        @Override // dc.ii
        public boolean a() {
            return false;
        }

        @Override // dc.ii
        public boolean b() {
            return false;
        }

        @Override // dc.ii
        public boolean c(sg sgVar) {
            return false;
        }

        @Override // dc.ii
        public boolean d(boolean z, sg sgVar, ug ugVar) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    public class c extends ii {
        @Override // dc.ii
        public boolean a() {
            return true;
        }

        @Override // dc.ii
        public boolean b() {
            return false;
        }

        @Override // dc.ii
        public boolean c(sg sgVar) {
            return (sgVar == sg.DATA_DISK_CACHE || sgVar == sg.MEMORY_CACHE) ? false : true;
        }

        @Override // dc.ii
        public boolean d(boolean z, sg sgVar, ug ugVar) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    public class d extends ii {
        @Override // dc.ii
        public boolean a() {
            return false;
        }

        @Override // dc.ii
        public boolean b() {
            return true;
        }

        @Override // dc.ii
        public boolean c(sg sgVar) {
            return false;
        }

        @Override // dc.ii
        public boolean d(boolean z, sg sgVar, ug ugVar) {
            return (sgVar == sg.RESOURCE_DISK_CACHE || sgVar == sg.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    public class e extends ii {
        @Override // dc.ii
        public boolean a() {
            return true;
        }

        @Override // dc.ii
        public boolean b() {
            return true;
        }

        @Override // dc.ii
        public boolean c(sg sgVar) {
            return sgVar == sg.REMOTE;
        }

        @Override // dc.ii
        public boolean d(boolean z, sg sgVar, ug ugVar) {
            return ((z && sgVar == sg.DATA_DISK_CACHE) || sgVar == sg.LOCAL) && ugVar == ug.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(sg sgVar);

    public abstract boolean d(boolean z, sg sgVar, ug ugVar);
}
