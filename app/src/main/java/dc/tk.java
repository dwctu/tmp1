package dc;

import androidx.annotation.NonNull;
import dc.ih;
import dc.lk;

/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class tk<Model> implements lk<Model, Model> {
    public static final tk<?> a = new tk<>();

    /* compiled from: UnitModelLoader.java */
    public static class a<Model> implements mk<Model, Model> {
        public static final a<?> a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) a;
        }

        @Override // dc.mk
        @NonNull
        public lk<Model, Model> b(pk pkVar) {
            return tk.c();
        }
    }

    /* compiled from: UnitModelLoader.java */
    public static class b<Model> implements ih<Model> {
        public final Model a;

        public b(Model model) {
            this.a = model;
        }

        @Override // dc.ih
        public void a() {
        }

        @Override // dc.ih
        @NonNull
        public sg c() {
            return sg.LOCAL;
        }

        @Override // dc.ih
        public void cancel() {
        }

        @Override // dc.ih
        public void d(@NonNull of ofVar, @NonNull ih.a<? super Model> aVar) {
            aVar.e(this.a);
        }

        @Override // dc.ih
        @NonNull
        public Class<Model> getDataClass() {
            return (Class<Model>) this.a.getClass();
        }
    }

    @Deprecated
    public tk() {
    }

    public static <T> tk<T> c() {
        return (tk<T>) a;
    }

    @Override // dc.lk
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // dc.lk
    public lk.a<Model> b(@NonNull Model model, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(model), new b(model));
    }
}
