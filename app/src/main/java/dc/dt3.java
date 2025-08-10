package dc;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.lovense.wear.R;

/* compiled from: GlideRoundUtils.java */
/* loaded from: classes4.dex */
public class dt3 {

    /* compiled from: GlideRoundUtils.java */
    public class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Drawable b;
        public final /* synthetic */ String c;

        /* compiled from: GlideRoundUtils.java */
        /* renamed from: dc.dt3$a$a, reason: collision with other inner class name */
        public class C0173a extends wo<Drawable> {
            public C0173a() {
            }

            @Override // dc.cp
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
                if (((String) a.this.a.getTag(R.id.action_container)).equals(a.this.c)) {
                    if (Build.VERSION.SDK_INT <= 16) {
                        a.this.a.setBackgroundDrawable(drawable);
                    } else {
                        a.this.a.setBackground(drawable);
                    }
                }
            }

            @Override // dc.cp
            public void e(@Nullable Drawable drawable) {
            }
        }

        public a(View view, Drawable drawable, String str) {
            this.a = view;
            this.b = drawable;
            this.c = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.removeOnLayoutChangeListener(this);
            kf.x(this.a).k().E0(this.b).j0(new nl()).W(this.a.getMeasuredWidth(), this.a.getMeasuredHeight()).x0(new C0173a());
        }
    }

    /* compiled from: GlideRoundUtils.java */
    public class b extends wo<Drawable> {
        public final /* synthetic */ View d;

        public b(View view) {
            this.d = view;
        }

        @Override // dc.cp
        @RequiresApi(api = 16)
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
            if (Build.VERSION.SDK_INT <= 16) {
                this.d.setBackgroundDrawable(drawable);
            } else {
                this.d.setBackground(drawable);
            }
        }

        @Override // dc.cp
        public void e(@Nullable Drawable drawable) {
        }
    }

    /* compiled from: GlideRoundUtils.java */
    public class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Drawable b;
        public final /* synthetic */ float c;
        public final /* synthetic */ String d;

        /* compiled from: GlideRoundUtils.java */
        public class a extends wo<Drawable> {
            public a() {
            }

            @Override // dc.cp
            @RequiresApi(api = 16)
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
                if (((String) c.this.a.getTag(R.id.action_container)).equals(c.this.d)) {
                    if (Build.VERSION.SDK_INT <= 16) {
                        c.this.a.setBackgroundDrawable(drawable);
                    } else {
                        c.this.a.setBackground(drawable);
                    }
                }
            }

            @Override // dc.cp
            public void e(@Nullable Drawable drawable) {
            }
        }

        public c(View view, Drawable drawable, float f, String str) {
            this.a = view;
            this.b = drawable;
            this.c = f;
            this.d = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.removeOnLayoutChangeListener(this);
            kf.x(this.a).q(this.b).n0(new nl(), new dm((int) this.c)).W(this.a.getMeasuredWidth(), this.a.getMeasuredHeight()).x0(new a());
        }
    }

    /* compiled from: GlideRoundUtils.java */
    public class d extends wo<Drawable> {
        public final /* synthetic */ View d;

        public d(View view) {
            this.d = view;
        }

        @Override // dc.cp
        @RequiresApi(api = 16)
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
            if (Build.VERSION.SDK_INT <= 16) {
                this.d.setBackgroundDrawable(drawable);
            } else {
                this.d.setBackground(drawable);
            }
        }

        @Override // dc.cp
        public void e(@Nullable Drawable drawable) {
        }
    }

    /* compiled from: GlideRoundUtils.java */
    public class e implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Drawable b;
        public final /* synthetic */ String c;

        /* compiled from: GlideRoundUtils.java */
        public class a extends wo<Drawable> {
            public a() {
            }

            @Override // dc.cp
            @RequiresApi(api = 16)
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
                if (((String) e.this.a.getTag(R.id.action_container)).equals(e.this.c)) {
                    if (Build.VERSION.SDK_INT <= 16) {
                        e.this.a.setBackgroundDrawable(drawable);
                    } else {
                        e.this.a.setBackground(drawable);
                    }
                }
            }

            @Override // dc.cp
            public void e(@Nullable Drawable drawable) {
            }
        }

        public e(View view, Drawable drawable, String str) {
            this.a = view;
            this.b = drawable;
            this.c = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.removeOnLayoutChangeListener(this);
            kf.x(this.a).q(this.b).W(this.a.getMeasuredWidth(), this.a.getMeasuredHeight()).x0(new a());
        }
    }

    /* compiled from: GlideRoundUtils.java */
    public class f extends wo<Drawable> {
        public final /* synthetic */ View d;

        public f(View view) {
            this.d = view;
        }

        @Override // dc.cp
        @RequiresApi(api = 16)
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
            if (Build.VERSION.SDK_INT <= 16) {
                this.d.setBackgroundDrawable(drawable);
            } else {
                this.d.setBackground(drawable);
            }
        }

        @Override // dc.cp
        public void e(@Nullable Drawable drawable) {
        }
    }

    /* compiled from: GlideRoundUtils.java */
    public class g implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Drawable b;
        public final /* synthetic */ ct3 c;
        public final /* synthetic */ String d;

        /* compiled from: GlideRoundUtils.java */
        public class a extends wo<Drawable> {
            public a() {
            }

            @Override // dc.cp
            @RequiresApi(api = 16)
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
                if (((String) g.this.a.getTag(R.id.action_container)).equals(g.this.d)) {
                    if (Build.VERSION.SDK_INT <= 16) {
                        g.this.a.setBackgroundDrawable(drawable);
                    } else {
                        g.this.a.setBackground(drawable);
                    }
                }
            }

            @Override // dc.cp
            public void e(@Nullable Drawable drawable) {
            }
        }

        public g(View view, Drawable drawable, ct3 ct3Var, String str) {
            this.a = view;
            this.b = drawable;
            this.c = ct3Var;
            this.d = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.removeOnLayoutChangeListener(this);
            kf.x(this.a).q(this.b).j0(this.c).W(this.a.getMeasuredWidth(), this.a.getMeasuredHeight()).x0(new a());
        }
    }

    /* compiled from: GlideRoundUtils.java */
    public class h extends wo<Drawable> {
        public final /* synthetic */ View d;
        public final /* synthetic */ String e;

        public h(View view, String str) {
            this.d = view;
            this.e = str;
        }

        @Override // dc.cp
        @RequiresApi(api = 16)
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
            if (((String) this.d.getTag(R.id.action_container)).equals(this.e)) {
                if (Build.VERSION.SDK_INT <= 16) {
                    this.d.setBackgroundDrawable(drawable);
                } else {
                    this.d.setBackground(drawable);
                }
            }
        }

        @Override // dc.cp
        public void e(@Nullable Drawable drawable) {
        }
    }

    public static void a(View view, Drawable drawable, float f2, float f3, float f4, float f5, String str) {
        if (f2 == 0.0f && f3 == 0.0f && f4 == 0.0f && f5 == 0.0f) {
            view.addOnLayoutChangeListener(new e(view, drawable, str));
            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                return;
            }
            kf.x(view).q(drawable).W(view.getMeasuredWidth(), view.getMeasuredHeight()).x0(new f(view));
            return;
        }
        ct3 ct3Var = new ct3(view.getContext(), f2, f3, f4, f5);
        view.addOnLayoutChangeListener(new g(view, drawable, ct3Var, str));
        if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
            return;
        }
        kf.x(view).q(drawable).j0(ct3Var).W(view.getMeasuredWidth(), view.getMeasuredHeight()).x0(new h(view, str));
    }

    public static void b(View view, Drawable drawable, float f2, String str) {
        if (f2 == 0.0f) {
            view.addOnLayoutChangeListener(new a(view, drawable, str));
            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                return;
            }
            kf.x(view).k().E0(drawable).j0(new nl()).W(view.getMeasuredWidth(), view.getMeasuredHeight()).x0(new b(view));
            return;
        }
        view.addOnLayoutChangeListener(new c(view, drawable, f2, str));
        if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
            return;
        }
        kf.x(view).q(drawable).n0(new nl(), new dm((int) f2)).W(view.getMeasuredWidth(), view.getMeasuredHeight()).x0(new d(view));
    }
}
