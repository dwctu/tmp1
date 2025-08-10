package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.ig0;
import dc.jg0;
import dc.kg0;
import dc.lg0;
import dc.mg0;
import dc.ng0;
import dc.og0;
import dc.pg0;
import dc.qg0;
import io.agora.rtc2.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class SubsamplingScaleImageView extends View {
    public PointF A;
    public Float B;
    public PointF C;
    public PointF D;
    public int E;
    public int F;
    public int G;
    public Rect K;
    public Rect L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public GestureDetector Q;
    public og0 R;
    public final Object S;
    public mg0<? extends ng0> T;
    public mg0<? extends og0> U;
    public PointF V;
    public float W;
    public Bitmap a;
    public final float a0;
    public boolean b;
    public float b0;
    public boolean c;
    public boolean c0;
    public Uri d;
    public PointF d0;
    public int e;
    public PointF e0;
    public Map<Integer, List<j>> f;
    public PointF f0;
    public boolean g;
    public c g0;
    public int h;
    public boolean h0;
    public float i;
    public boolean i0;
    public float j;
    public g j0;
    public int k;
    public h k0;
    public int l;
    public View.OnLongClickListener l0;
    public int m;
    public Handler m0;
    public int n;
    public Paint n0;
    public int o;
    public Paint o0;
    public boolean p;
    public Paint p0;
    public boolean q;
    public i q0;
    public boolean r;
    public Matrix r0;
    public boolean s;
    public RectF s0;
    public float t;
    public float[] t0;
    public int u;
    public float[] u0;
    public int v;
    public float v0;
    public float w;
    public float x;
    public PointF y;
    public PointF z;
    public static final String w0 = SubsamplingScaleImageView.class.getSimpleName();
    public static final List<Integer> x0 = Arrays.asList(0, 90, 180, Integer.valueOf(Constants.VIDEO_ORIENTATION_270), -1);
    public static final List<Integer> y0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> z0 = Arrays.asList(2, 1);
    public static final List<Integer> A0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> B0 = Arrays.asList(2, 1, 3);
    public static int C0 = Integer.MAX_VALUE;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && SubsamplingScaleImageView.this.l0 != null) {
                SubsamplingScaleImageView.this.P = 0;
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.l0);
                SubsamplingScaleImageView.this.performLongClick();
                SubsamplingScaleImageView.super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!SubsamplingScaleImageView.this.r || !SubsamplingScaleImageView.this.h0 || SubsamplingScaleImageView.this.y == null) {
                return super.onDoubleTapEvent(motionEvent);
            }
            SubsamplingScaleImageView.this.setGestureDetector(this.a);
            if (!SubsamplingScaleImageView.this.s) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                subsamplingScaleImageView.W(subsamplingScaleImageView.M0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
            SubsamplingScaleImageView.this.V = new PointF(motionEvent.getX(), motionEvent.getY());
            SubsamplingScaleImageView.this.z = new PointF(SubsamplingScaleImageView.this.y.x, SubsamplingScaleImageView.this.y.y);
            SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
            subsamplingScaleImageView2.x = subsamplingScaleImageView2.w;
            SubsamplingScaleImageView.this.O = true;
            SubsamplingScaleImageView.this.M = true;
            SubsamplingScaleImageView.this.b0 = -1.0f;
            SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
            subsamplingScaleImageView3.e0 = subsamplingScaleImageView3.M0(subsamplingScaleImageView3.V);
            SubsamplingScaleImageView.this.f0 = new PointF(motionEvent.getX(), motionEvent.getY());
            SubsamplingScaleImageView.this.d0 = new PointF(SubsamplingScaleImageView.this.e0.x, SubsamplingScaleImageView.this.e0.y);
            SubsamplingScaleImageView.this.c0 = false;
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!SubsamplingScaleImageView.this.q || !SubsamplingScaleImageView.this.h0 || SubsamplingScaleImageView.this.y == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || SubsamplingScaleImageView.this.M))) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            PointF pointF = new PointF(SubsamplingScaleImageView.this.y.x + (f * 0.25f), SubsamplingScaleImageView.this.y.y + (f2 * 0.25f));
            d dVar = new d(SubsamplingScaleImageView.this, new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.w, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.w), (a) null);
            dVar.e(1);
            d.a(dVar, false);
            d.b(dVar, 3);
            dVar.c();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    public final class d {
        public final float a;
        public final PointF b;
        public final PointF c;
        public long d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;
        public f i;

        public /* synthetic */ d(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2, a aVar) {
            this(f, pointF, pointF2);
        }

        public static /* synthetic */ d a(d dVar, boolean z) {
            dVar.h(z);
            return dVar;
        }

        public static /* synthetic */ d b(d dVar, int i) {
            dVar.g(i);
            return dVar;
        }

        public void c() {
            PointF pointF;
            if (SubsamplingScaleImageView.this.g0 != null && SubsamplingScaleImageView.this.g0.m != null) {
                try {
                    SubsamplingScaleImageView.this.g0.m.b();
                } catch (Exception unused) {
                    String unused2 = SubsamplingScaleImageView.w0;
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float fL0 = SubsamplingScaleImageView.this.l0(this.a);
            if (this.h) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.b;
                float f = pointF2.x;
                float f2 = pointF2.y;
                pointF = new PointF();
                SubsamplingScaleImageView.K(subsamplingScaleImageView, f, f2, fL0, pointF);
            } else {
                pointF = this.b;
            }
            a aVar = null;
            SubsamplingScaleImageView.this.g0 = new c(aVar);
            SubsamplingScaleImageView.this.g0.a = SubsamplingScaleImageView.this.w;
            SubsamplingScaleImageView.this.g0.b = fL0;
            SubsamplingScaleImageView.this.g0.l = System.currentTimeMillis();
            SubsamplingScaleImageView.this.g0.e = pointF;
            SubsamplingScaleImageView.this.g0.c = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.g0.d = pointF;
            SubsamplingScaleImageView.this.g0.f = SubsamplingScaleImageView.this.E0(pointF);
            SubsamplingScaleImageView.this.g0.g = new PointF(paddingLeft, paddingTop);
            SubsamplingScaleImageView.this.g0.h = this.d;
            SubsamplingScaleImageView.this.g0.i = this.g;
            SubsamplingScaleImageView.this.g0.j = this.e;
            SubsamplingScaleImageView.this.g0.k = this.f;
            SubsamplingScaleImageView.this.g0.l = System.currentTimeMillis();
            SubsamplingScaleImageView.this.g0.m = this.i;
            PointF pointF3 = this.c;
            if (pointF3 != null) {
                float f3 = pointF3.x - (SubsamplingScaleImageView.this.g0.c.x * fL0);
                float f4 = this.c.y - (SubsamplingScaleImageView.this.g0.c.y * fL0);
                i iVar = new i(fL0, new PointF(f3, f4), aVar);
                SubsamplingScaleImageView.this.d0(true, iVar);
                SubsamplingScaleImageView.this.g0.g = new PointF(this.c.x + (iVar.b.x - f3), this.c.y + (iVar.b.y - f4));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public d d(long j) {
            this.d = j;
            return this;
        }

        public d e(int i) {
            if (SubsamplingScaleImageView.z0.contains(Integer.valueOf(i))) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public d f(boolean z) {
            this.g = z;
            return this;
        }

        public final d g(int i) {
            this.f = i;
            return this;
        }

        public final d h(boolean z) {
            this.h = z;
            return this;
        }

        public /* synthetic */ d(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, a aVar) {
            this(f, pointF);
        }

        public /* synthetic */ d(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, a aVar) {
            this(pointF);
        }

        public d(PointF pointF) {
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = SubsamplingScaleImageView.this.w;
            this.b = pointF;
            this.c = null;
        }

        public d(float f, PointF pointF) {
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = f;
            this.b = pointF;
            this.c = null;
        }

        public d(float f, PointF pointF, PointF pointF2) {
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = f;
            this.b = pointF;
            this.c = pointF2;
        }
    }

    public static class e extends AsyncTask<Void, Void, Integer> {
        public final WeakReference<SubsamplingScaleImageView> a;
        public final WeakReference<Context> b;
        public final WeakReference<mg0<? extends ng0>> c;
        public final Uri d;
        public final boolean e;
        public Bitmap f;
        public Exception g;

        public e(SubsamplingScaleImageView subsamplingScaleImageView, Context context, mg0<? extends ng0> mg0Var, Uri uri, boolean z) {
            this.a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(mg0Var);
            this.d = uri;
            this.e = z;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                String string = this.d.toString();
                Context context = this.b.get();
                mg0<? extends ng0> mg0Var = this.c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.a.get();
                if (context == null || mg0Var == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.U("BitmapLoadTask.doInBackground", new Object[0]);
                this.f = mg0Var.a().a(context, this.d);
                return Integer.valueOf(subsamplingScaleImageView.e0(context, string));
            } catch (Exception e) {
                String unused = SubsamplingScaleImageView.w0;
                this.g = e;
                return null;
            } catch (OutOfMemoryError e2) {
                String unused2 = SubsamplingScaleImageView.w0;
                this.g = new RuntimeException(e2);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.a.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.f;
                if (bitmap != null && num != null) {
                    if (this.e) {
                        subsamplingScaleImageView.p0(bitmap);
                        return;
                    } else {
                        subsamplingScaleImageView.o0(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.g == null || subsamplingScaleImageView.j0 == null) {
                    return;
                }
                if (this.e) {
                    subsamplingScaleImageView.j0.b(this.g);
                } else {
                    subsamplingScaleImageView.j0.f(this.g);
                }
            }
        }
    }

    public interface f {
        void a();

        void b();

        void onComplete();
    }

    public interface g {
        void a();

        void b(Exception exc);

        void c(Exception exc);

        void d();

        void e();

        void f(Exception exc);
    }

    public interface h {
        void a(float f, int i);

        void b(PointF pointF, int i);
    }

    public static class i {
        public float a;
        public PointF b;

        public /* synthetic */ i(float f, PointF pointF, a aVar) {
            this(f, pointF);
        }

        public i(float f, PointF pointF) {
            this.a = f;
            this.b = pointF;
        }
    }

    public static class j {
        public Rect a;
        public int b;
        public Bitmap c;
        public boolean d;
        public boolean e;
        public Rect f;
        public Rect g;

        public j() {
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    public static class k extends AsyncTask<Void, Void, Bitmap> {
        public final WeakReference<SubsamplingScaleImageView> a;
        public final WeakReference<og0> b;
        public final WeakReference<j> c;
        public Exception d;

        public k(SubsamplingScaleImageView subsamplingScaleImageView, og0 og0Var, j jVar) {
            this.a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(og0Var);
            this.c = new WeakReference<>(jVar);
            jVar.d = true;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmapB;
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.a.get();
                og0 og0Var = this.b.get();
                j jVar = this.c.get();
                if (og0Var == null || jVar == null || subsamplingScaleImageView == null || !og0Var.isReady() || !jVar.e) {
                    if (jVar == null) {
                        return null;
                    }
                    jVar.d = false;
                    return null;
                }
                subsamplingScaleImageView.U("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", jVar.a, Integer.valueOf(jVar.b));
                synchronized (subsamplingScaleImageView.S) {
                    subsamplingScaleImageView.b0(jVar.a, jVar.g);
                    if (subsamplingScaleImageView.K != null) {
                        jVar.g.offset(subsamplingScaleImageView.K.left, subsamplingScaleImageView.K.top);
                    }
                    bitmapB = og0Var.b(jVar.g, jVar.b);
                }
                return bitmapB;
            } catch (Exception e) {
                String unused = SubsamplingScaleImageView.w0;
                this.d = e;
                return null;
            } catch (OutOfMemoryError e2) {
                String unused2 = SubsamplingScaleImageView.w0;
                this.d = new RuntimeException(e2);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.a.get();
            j jVar = this.c.get();
            if (subsamplingScaleImageView == null || jVar == null) {
                return;
            }
            if (bitmap != null) {
                jVar.c = bitmap;
                jVar.d = false;
                subsamplingScaleImageView.r0();
            } else {
                if (this.d == null || subsamplingScaleImageView.j0 == null) {
                    return;
                }
                subsamplingScaleImageView.j0.c(this.d);
            }
        }
    }

    public static class l extends AsyncTask<Void, Void, int[]> {
        public final WeakReference<SubsamplingScaleImageView> a;
        public final WeakReference<Context> b;
        public final WeakReference<mg0<? extends og0>> c;
        public final Uri d;
        public og0 e;
        public Exception f;

        public l(SubsamplingScaleImageView subsamplingScaleImageView, Context context, mg0<? extends og0> mg0Var, Uri uri) {
            this.a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(mg0Var);
            this.d = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int[] doInBackground(Void... voidArr) {
            try {
                String string = this.d.toString();
                Context context = this.b.get();
                mg0<? extends og0> mg0Var = this.c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.a.get();
                if (context == null || mg0Var == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.U("TilesInitTask.doInBackground", new Object[0]);
                og0 og0VarA = mg0Var.a();
                this.e = og0VarA;
                Point pointA = og0VarA.a(context, this.d);
                int iWidth = pointA.x;
                int iHeight = pointA.y;
                int iE0 = subsamplingScaleImageView.e0(context, string);
                if (subsamplingScaleImageView.K != null) {
                    iWidth = subsamplingScaleImageView.K.width();
                    iHeight = subsamplingScaleImageView.K.height();
                }
                return new int[]{iWidth, iHeight, iE0};
            } catch (Exception e) {
                String unused = SubsamplingScaleImageView.w0;
                this.f = e;
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.a.get();
            if (subsamplingScaleImageView != null) {
                og0 og0Var = this.e;
                if (og0Var != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.s0(og0Var, iArr[0], iArr[1], iArr[2]);
                } else {
                    if (this.f == null || subsamplingScaleImageView.j0 == null) {
                        return;
                    }
                    subsamplingScaleImageView.j0.f(this.f);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int resourceId;
        String string;
        super(context, attributeSet);
        this.h = 0;
        this.i = 2.0f;
        this.j = m0();
        this.k = -1;
        this.l = 1;
        this.m = 1;
        int i2 = C0;
        this.n = i2;
        this.o = i2;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = 1.0f;
        this.u = 1;
        this.v = 500;
        this.S = new Object();
        this.T = new lg0(pg0.class);
        this.U = new lg0(qg0.class);
        this.t0 = new float[8];
        this.u0 = new float[8];
        this.v0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setGestureDetector(context);
        this.m0 = new Handler(new a());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, kg0.SubsamplingScaleImageView);
            int i3 = kg0.SubsamplingScaleImageView_assetName;
            if (typedArrayObtainStyledAttributes.hasValue(i3) && (string = typedArrayObtainStyledAttributes.getString(i3)) != null && string.length() > 0) {
                ig0 ig0VarA = ig0.a(string);
                ig0VarA.l();
                setImage(ig0VarA);
            }
            int i4 = kg0.SubsamplingScaleImageView_src;
            if (typedArrayObtainStyledAttributes.hasValue(i4) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i4, 0)) > 0) {
                ig0 ig0VarJ = ig0.j(resourceId);
                ig0VarJ.l();
                setImage(ig0VarJ);
            }
            int i5 = kg0.SubsamplingScaleImageView_panEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                setPanEnabled(typedArrayObtainStyledAttributes.getBoolean(i5, true));
            }
            int i6 = kg0.SubsamplingScaleImageView_zoomEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i6)) {
                setZoomEnabled(typedArrayObtainStyledAttributes.getBoolean(i6, true));
            }
            int i7 = kg0.SubsamplingScaleImageView_quickScaleEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i7)) {
                setQuickScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(i7, true));
            }
            int i8 = kg0.SubsamplingScaleImageView_tileBackgroundColor;
            if (typedArrayObtainStyledAttributes.hasValue(i8)) {
                setTileBackgroundColor(typedArrayObtainStyledAttributes.getColor(i8, Color.argb(0, 0, 0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.a0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public static /* synthetic */ PointF K(SubsamplingScaleImageView subsamplingScaleImageView, float f2, float f3, float f4, PointF pointF) {
        subsamplingScaleImageView.k0(f2, f3, f4, pointF);
        return pointF;
    }

    @AnyThread
    private int getRequiredRotation() {
        int i2 = this.h;
        return i2 == -1 ? this.G : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.Q = new GestureDetector(context, new b(context));
    }

    public final int A0() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.F : this.E;
    }

    public final void B0(float f2, PointF pointF, int i2) {
        h hVar = this.k0;
        if (hVar != null) {
            float f3 = this.w;
            if (f3 != f2) {
                hVar.a(f3, i2);
            }
            if (this.y.equals(pointF)) {
                return;
            }
            this.k0.b(getCenter(), i2);
        }
    }

    public final void C0(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    public final PointF D0(float f2, float f3, PointF pointF) {
        if (this.y == null) {
            return null;
        }
        pointF.set(G0(f2), H0(f3));
        return pointF;
    }

    public final PointF E0(PointF pointF) {
        return D0(pointF.x, pointF.y, new PointF());
    }

    public final Rect F0(Rect rect, Rect rect2) {
        rect2.set((int) G0(rect.left), (int) H0(rect.top), (int) G0(rect.right), (int) H0(rect.bottom));
        return rect2;
    }

    public final float G0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.w) + pointF.x;
    }

    public final float H0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.w) + pointF.y;
    }

    public final boolean I0(j jVar) {
        return N0(0.0f) <= ((float) jVar.a.right) && ((float) jVar.a.left) <= N0((float) getWidth()) && O0(0.0f) <= ((float) jVar.a.bottom) && ((float) jVar.a.top) <= O0((float) getHeight());
    }

    public final PointF J0(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.q0 == null) {
            this.q0 = new i(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.q0.a = f4;
        this.q0.b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        d0(true, this.q0);
        return this.q0.b;
    }

    public final PointF K0(float f2, float f3) {
        return L0(f2, f3, new PointF());
    }

    public final PointF L0(float f2, float f3, PointF pointF) {
        if (this.y == null) {
            return null;
        }
        pointF.set(N0(f2), O0(f3));
        return pointF;
    }

    public final PointF M0(PointF pointF) {
        return L0(pointF.x, pointF.y, new PointF());
    }

    public final float N0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.w;
    }

    public final float O0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.w;
    }

    public final int Q(float f2) {
        int iRound;
        if (this.k > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.k / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int iA0 = (int) (A0() * f2);
        int iZ0 = (int) (z0() * f2);
        if (iA0 == 0 || iZ0 == 0) {
            return 32;
        }
        int i2 = 1;
        if (z0() > iZ0 || A0() > iA0) {
            iRound = Math.round(z0() / iZ0);
            int iRound2 = Math.round(A0() / iA0);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= iRound) {
                return i2;
            }
            i2 = i3;
        }
    }

    public final boolean R() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zI0 = i0();
        if (!this.i0 && zI0) {
            u0();
            this.i0 = true;
            n0();
            g gVar = this.j0;
            if (gVar != null) {
                gVar.a();
            }
        }
        return zI0;
    }

    public final boolean S() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.E > 0 && this.F > 0 && (this.a != null || i0());
        if (!this.h0 && z) {
            u0();
            this.h0 = true;
            q0();
            g gVar = this.j0;
            if (gVar != null) {
                gVar.e();
            }
        }
        return z;
    }

    public final void T() {
        if (this.n0 == null) {
            Paint paint = new Paint();
            this.n0 = paint;
            paint.setAntiAlias(true);
            this.n0.setFilterBitmap(true);
            this.n0.setDither(true);
        }
        if (this.o0 == null && this.g) {
            Paint paint2 = new Paint();
            this.o0 = paint2;
            paint2.setTextSize(18.0f);
            this.o0.setColor(-65281);
            this.o0.setStyle(Paint.Style.STROKE);
        }
    }

    @AnyThread
    public final void U(String str, Object... objArr) {
        if (this.g) {
            String.format(str, objArr);
        }
    }

    public final float V(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    public final void W(PointF pointF, PointF pointF2) {
        if (!this.q) {
            PointF pointF3 = this.D;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = A0() / 2;
                pointF.y = z0() / 2;
            }
        }
        float fMin = Math.min(this.i, this.t);
        boolean z = ((double) this.w) <= ((double) fMin) * 0.9d;
        if (!z) {
            fMin = m0();
        }
        float f2 = fMin;
        int i2 = this.u;
        if (i2 == 3) {
            setScaleAndCenter(f2, pointF);
        } else if (i2 == 2 || !z || !this.q) {
            d dVar = new d(this, f2, pointF, (a) null);
            dVar.f(false);
            dVar.d(this.v);
            d.b(dVar, 4);
            dVar.c();
        } else if (i2 == 1) {
            d dVar2 = new d(this, f2, pointF, pointF2, null);
            dVar2.f(false);
            dVar2.d(this.v);
            d.b(dVar2, 4);
            dVar2.c();
        }
        invalidate();
    }

    public final float X(int i2, long j2, float f2, float f3, long j3) {
        if (i2 == 1) {
            return Z(j2, f2, f3, j3);
        }
        if (i2 == 2) {
            return Y(j2, f2, f3, j3);
        }
        throw new IllegalStateException("Unexpected easing type: " + i2);
    }

    public final float Y(long j2, float f2, float f3, long j3) {
        float f4;
        float f5 = j2 / (j3 / 2.0f);
        if (f5 < 1.0f) {
            f4 = (f3 / 2.0f) * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f6 * (f6 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    public final float Z(long j2, float f2, float f3, long j3) {
        float f4 = j2 / j3;
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    public final void a0(AsyncTask<Void, Void, ?> asyncTask) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.p && Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                return;
            } catch (Exception unused) {
            }
        }
        asyncTask.execute(new Void[0]);
    }

    @AnyThread
    public final void b0(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i2 = rect.top;
            int i3 = this.F;
            rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
        } else if (getRequiredRotation() != 180) {
            int i4 = this.E;
            rect2.set(i4 - rect.bottom, rect.left, i4 - rect.top, rect.right);
        } else {
            int i5 = this.E;
            int i6 = i5 - rect.right;
            int i7 = this.F;
            rect2.set(i6, i7 - rect.bottom, i5 - rect.left, i7 - rect.top);
        }
    }

    public final void c0(boolean z) {
        boolean z2;
        float f2 = 0.0f;
        if (this.y == null) {
            z2 = true;
            this.y = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.q0 == null) {
            this.q0 = new i(f2, new PointF(0.0f, 0.0f), null);
        }
        this.q0.a = this.w;
        this.q0.b.set(this.y);
        d0(z, this.q0);
        this.w = this.q0.a;
        this.y.set(this.q0.b);
        if (z2) {
            this.y.set(J0(A0() / 2, z0() / 2, this.w));
        }
    }

    public final void d0(boolean z, i iVar) {
        float fMax;
        int iMax;
        float fMax2;
        if (this.l == 2 && j0()) {
            z = false;
        }
        PointF pointF = iVar.b;
        float fL0 = l0(iVar.a);
        float fA0 = A0() * fL0;
        float fZ0 = z0() * fL0;
        if (this.l == 3 && j0()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - fA0);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - fZ0);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - fA0);
            pointF.y = Math.max(pointF.y, getHeight() - fZ0);
        } else {
            pointF.x = Math.max(pointF.x, -fA0);
            pointF.y = Math.max(pointF.y, -fZ0);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.l == 3 && j0()) {
            fMax = Math.max(0, getWidth() / 2);
            iMax = Math.max(0, getHeight() / 2);
        } else {
            if (z) {
                fMax = Math.max(0.0f, (getWidth() - fA0) * paddingLeft);
                fMax2 = Math.max(0.0f, (getHeight() - fZ0) * paddingTop);
                pointF.x = Math.min(pointF.x, fMax);
                pointF.y = Math.min(pointF.y, fMax2);
                iVar.a = fL0;
            }
            fMax = Math.max(0, getWidth());
            iMax = Math.max(0, getHeight());
        }
        fMax2 = iMax;
        pointF.x = Math.min(pointF.x, fMax);
        pointF.y = Math.min(pointF.y, fMax2);
        iVar.a = fL0;
    }

    @AnyThread
    public final int e0(Context context, String str) {
        int i2 = 0;
        if (!str.startsWith(FirebaseAnalytics.Param.CONTENT)) {
            if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
                return 0;
            }
            try {
                int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt != 1 && attributeInt != 0) {
                    if (attributeInt == 6) {
                        return 90;
                    }
                    if (attributeInt == 3) {
                        return 180;
                    }
                    if (attributeInt == 8) {
                        return Constants.VIDEO_ORIENTATION_270;
                    }
                    String str2 = "Unsupported EXIF orientation: " + attributeInt;
                    return 0;
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i3 = cursorQuery.getInt(0);
                if (!x0.contains(Integer.valueOf(i3)) || i3 == -1) {
                    String str3 = "Unsupported orientation: " + i3;
                } else {
                    i2 = i3;
                }
            }
            if (cursorQuery == null) {
                return i2;
            }
        } catch (Exception unused2) {
            if (cursorQuery == null) {
                return 0;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        cursorQuery.close();
        return i2;
    }

    public final Point f0(Canvas canvas) {
        int iIntValue;
        int iIntValue2;
        int i2 = 2048;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                iIntValue = ((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue();
            } catch (Exception unused) {
                iIntValue = 2048;
            }
            try {
                iIntValue2 = ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                i2 = iIntValue;
            } catch (Exception unused2) {
                i2 = iIntValue;
                iIntValue2 = 2048;
                return new Point(Math.min(i2, this.n), Math.min(iIntValue2, this.o));
            }
        } else {
            iIntValue2 = 2048;
        }
        return new Point(Math.min(i2, this.n), Math.min(iIntValue2, this.o));
    }

    public final synchronized void g0(Point point) {
        U("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        i iVar = new i(0.0f, new PointF(0.0f, 0.0f), null);
        this.q0 = iVar;
        d0(true, iVar);
        int iQ = Q(this.q0.a);
        this.e = iQ;
        if (iQ > 1) {
            this.e = iQ / 2;
        }
        if (this.e != 1 || this.K != null || A0() >= point.x || z0() >= point.y) {
            h0(point);
            Iterator<j> it = this.f.get(Integer.valueOf(this.e)).iterator();
            while (it.hasNext()) {
                a0(new k(this, this.R, it.next()));
            }
            v0(true);
        } else {
            this.R.recycle();
            this.R = null;
            a0(new e(this, getContext(), this.T, this.d, false));
        }
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return K0(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.i;
    }

    public final float getMinScale() {
        return m0();
    }

    public final int getOrientation() {
        return this.h;
    }

    public final int getSHeight() {
        return this.F;
    }

    public final int getSWidth() {
        return this.E;
    }

    public final float getScale() {
        return this.w;
    }

    public final jg0 getState() {
        if (this.y == null || this.E <= 0 || this.F <= 0) {
            return null;
        }
        return new jg0(getScale(), getCenter(), getOrientation());
    }

    public final void h0(Point point) {
        int i2 = 1;
        U("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.f = new LinkedHashMap();
        int i3 = this.e;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int iA0 = A0() / i4;
            int iZ0 = z0() / i5;
            int i6 = iA0 / i3;
            int i7 = iZ0 / i3;
            while (true) {
                if (i6 + i4 + i2 <= point.x && (i6 <= getWidth() * 1.25d || i3 >= this.e)) {
                    break;
                }
                i4++;
                iA0 = A0() / i4;
                i6 = iA0 / i3;
                i2 = 1;
            }
            while (true) {
                if (i7 + i5 + i2 <= point.y && (i7 <= getHeight() * 1.25d || i3 >= this.e)) {
                    break;
                }
                i5++;
                iZ0 = z0() / i5;
                i7 = iZ0 / i3;
                i2 = 1;
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    j jVar = new j(null);
                    jVar.b = i3;
                    jVar.e = i3 == this.e;
                    jVar.a = new Rect(i8 * iA0, i9 * iZ0, i8 == i4 + (-1) ? A0() : (i8 + 1) * iA0, i9 == i5 + (-1) ? z0() : (i9 + 1) * iZ0);
                    jVar.f = new Rect(0, 0, 0, 0);
                    jVar.g = new Rect(jVar.a);
                    arrayList.add(jVar);
                    i9++;
                }
                i8++;
            }
            this.f.put(Integer.valueOf(i3), arrayList);
            if (i3 == 1) {
                return;
            }
            i3 /= 2;
            i2 = 1;
        }
    }

    public final boolean i0() {
        boolean z = true;
        if (this.a != null && !this.b) {
            return true;
        }
        Map<Integer, List<j>> map = this.f;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<j>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.e) {
                for (j jVar : entry.getValue()) {
                    if (jVar.d || jVar.c == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public final boolean j0() {
        return this.h0;
    }

    public final PointF k0(float f2, float f3, float f4, PointF pointF) {
        PointF pointFJ0 = J0(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - pointFJ0.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - pointFJ0.y) / f4);
        return pointF;
    }

    public final float l0(float f2) {
        return Math.min(this.i, Math.max(m0(), f2));
    }

    public final float m0() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i2 = this.m;
        if (i2 == 2) {
            return Math.max((getWidth() - paddingLeft) / A0(), (getHeight() - paddingBottom) / z0());
        }
        if (i2 == 3) {
            float f2 = this.j;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingLeft) / A0(), (getHeight() - paddingBottom) / z0());
    }

    public void n0() {
    }

    public final synchronized void o0(Bitmap bitmap, int i2, boolean z) {
        g gVar;
        U("onImageLoaded", new Object[0]);
        int i3 = this.E;
        if (i3 > 0 && this.F > 0 && (i3 != bitmap.getWidth() || this.F != bitmap.getHeight())) {
            x0(false);
        }
        Bitmap bitmap2 = this.a;
        if (bitmap2 != null && !this.c) {
            bitmap2.recycle();
        }
        if (this.a != null && this.c && (gVar = this.j0) != null) {
            gVar.d();
        }
        this.b = false;
        this.c = z;
        this.a = bitmap;
        this.E = bitmap.getWidth();
        this.F = bitmap.getHeight();
        this.G = i2;
        boolean zS = S();
        boolean zR = R();
        if (zS || zR) {
            invalidate();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        float height;
        int i2;
        super.onDraw(canvas);
        T();
        if (this.E == 0 || this.F == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.f == null && this.R != null) {
            g0(f0(canvas));
        }
        if (S()) {
            u0();
            if (this.g0 != null) {
                float f2 = this.w;
                if (this.A == null) {
                    this.A = new PointF(0.0f, 0.0f);
                }
                this.A.set(this.y);
                long jCurrentTimeMillis = System.currentTimeMillis() - this.g0.l;
                boolean z = jCurrentTimeMillis > this.g0.h;
                long jMin = Math.min(jCurrentTimeMillis, this.g0.h);
                this.w = X(this.g0.j, jMin, this.g0.a, this.g0.b - this.g0.a, this.g0.h);
                float fX = X(this.g0.j, jMin, this.g0.f.x, this.g0.g.x - this.g0.f.x, this.g0.h);
                float fX2 = X(this.g0.j, jMin, this.g0.f.y, this.g0.g.y - this.g0.f.y, this.g0.h);
                this.y.x -= G0(this.g0.d.x) - fX;
                this.y.y -= H0(this.g0.d.y) - fX2;
                c0(z || this.g0.a == this.g0.b);
                B0(f2, this.A, this.g0.k);
                v0(z);
                if (z) {
                    if (this.g0.m != null) {
                        try {
                            this.g0.m.onComplete();
                        } catch (Exception unused) {
                        }
                    }
                    this.g0 = null;
                }
                invalidate();
            }
            if (this.f == null || !i0()) {
                if (this.a != null) {
                    float width = this.w;
                    if (this.b) {
                        width *= this.E / r0.getWidth();
                        height = this.w * (this.F / this.a.getHeight());
                    } else {
                        height = width;
                    }
                    if (this.r0 == null) {
                        this.r0 = new Matrix();
                    }
                    this.r0.reset();
                    this.r0.postScale(width, height);
                    this.r0.postRotate(getRequiredRotation());
                    Matrix matrix = this.r0;
                    PointF pointF = this.y;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.r0;
                        float f3 = this.w;
                        matrix2.postTranslate(this.E * f3, f3 * this.F);
                    } else if (getRequiredRotation() == 90) {
                        this.r0.postTranslate(this.w * this.F, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.r0.postTranslate(0.0f, this.w * this.E);
                    }
                    if (this.p0 != null) {
                        if (this.s0 == null) {
                            this.s0 = new RectF();
                        }
                        this.s0.set(0.0f, 0.0f, this.b ? this.a.getWidth() : this.E, this.b ? this.a.getHeight() : this.F);
                        this.r0.mapRect(this.s0);
                        canvas.drawRect(this.s0, this.p0);
                    }
                    canvas.drawBitmap(this.a, this.r0, this.n0);
                }
            } else {
                int iMin = Math.min(this.e, Q(this.w));
                boolean z2 = false;
                for (Map.Entry<Integer, List<j>> entry : this.f.entrySet()) {
                    if (entry.getKey().intValue() == iMin) {
                        for (j jVar : entry.getValue()) {
                            if (jVar.e && (jVar.d || jVar.c == null)) {
                                z2 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<j>> entry2 : this.f.entrySet()) {
                    if (entry2.getKey().intValue() == iMin || z2) {
                        for (j jVar2 : entry2.getValue()) {
                            F0(jVar2.a, jVar2.f);
                            if (jVar2.d || jVar2.c == null) {
                                i2 = iMin;
                                if (jVar2.d && this.g) {
                                    canvas.drawText("LOADING", jVar2.f.left + 5, jVar2.f.top + 35, this.o0);
                                }
                            } else {
                                if (this.p0 != null) {
                                    canvas.drawRect(jVar2.f, this.p0);
                                }
                                if (this.r0 == null) {
                                    this.r0 = new Matrix();
                                }
                                this.r0.reset();
                                i2 = iMin;
                                C0(this.t0, 0.0f, 0.0f, jVar2.c.getWidth(), 0.0f, jVar2.c.getWidth(), jVar2.c.getHeight(), 0.0f, jVar2.c.getHeight());
                                if (getRequiredRotation() == 0) {
                                    C0(this.u0, jVar2.f.left, jVar2.f.top, jVar2.f.right, jVar2.f.top, jVar2.f.right, jVar2.f.bottom, jVar2.f.left, jVar2.f.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    C0(this.u0, jVar2.f.right, jVar2.f.top, jVar2.f.right, jVar2.f.bottom, jVar2.f.left, jVar2.f.bottom, jVar2.f.left, jVar2.f.top);
                                } else if (getRequiredRotation() == 180) {
                                    C0(this.u0, jVar2.f.right, jVar2.f.bottom, jVar2.f.left, jVar2.f.bottom, jVar2.f.left, jVar2.f.top, jVar2.f.right, jVar2.f.top);
                                } else if (getRequiredRotation() == 270) {
                                    C0(this.u0, jVar2.f.left, jVar2.f.bottom, jVar2.f.left, jVar2.f.top, jVar2.f.right, jVar2.f.top, jVar2.f.right, jVar2.f.bottom);
                                }
                                this.r0.setPolyToPoly(this.t0, 0, this.u0, 0, 4);
                                canvas.drawBitmap(jVar2.c, this.r0, this.n0);
                                if (this.g) {
                                    canvas.drawRect(jVar2.f, this.o0);
                                }
                            }
                            if (jVar2.e && this.g) {
                                canvas.drawText("ISS " + jVar2.b + " RECT " + jVar2.a.top + "," + jVar2.a.left + "," + jVar2.a.bottom + "," + jVar2.a.right, jVar2.f.left + 5, jVar2.f.top + 15, this.o0);
                            }
                            iMin = i2;
                        }
                    }
                    iMin = iMin;
                }
            }
            if (this.g) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.w)));
                canvas.drawText(sb.toString(), 5.0f, 15.0f, this.o0);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.y.x)) + SignatureImpl.INNER_SEP + String.format(locale, "%.2f", Float.valueOf(this.y.y)), 5.0f, 35.0f, this.o0);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + SignatureImpl.INNER_SEP + String.format(locale, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.o0);
                this.o0.setStrokeWidth(2.0f);
                c cVar = this.g0;
                if (cVar != null) {
                    PointF pointFE0 = E0(cVar.c);
                    PointF pointFE02 = E0(this.g0.e);
                    PointF pointFE03 = E0(this.g0.d);
                    canvas.drawCircle(pointFE0.x, pointFE0.y, 10.0f, this.o0);
                    this.o0.setColor(SupportMenu.CATEGORY_MASK);
                    canvas.drawCircle(pointFE02.x, pointFE02.y, 20.0f, this.o0);
                    this.o0.setColor(-16776961);
                    canvas.drawCircle(pointFE03.x, pointFE03.y, 25.0f, this.o0);
                    this.o0.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.o0);
                }
                if (this.V != null) {
                    this.o0.setColor(SupportMenu.CATEGORY_MASK);
                    PointF pointF2 = this.V;
                    canvas.drawCircle(pointF2.x, pointF2.y, 20.0f, this.o0);
                }
                if (this.e0 != null) {
                    this.o0.setColor(-16776961);
                    canvas.drawCircle(G0(this.e0.x), H0(this.e0.y), 35.0f, this.o0);
                }
                if (this.f0 != null) {
                    this.o0.setColor(-16711681);
                    PointF pointF3 = this.f0;
                    canvas.drawCircle(pointF3.x, pointF3.y, 30.0f, this.o0);
                }
                this.o0.setColor(-65281);
                this.o0.setStrokeWidth(1.0f);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.E > 0 && this.F > 0) {
            if (z && z2) {
                size = A0();
                size2 = z0();
            } else if (z2) {
                size2 = (int) ((z0() / A0()) * size);
            } else if (z) {
                size = (int) ((A0() / z0()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        U("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
        PointF center = getCenter();
        if (!this.h0 || center == null) {
            return;
        }
        this.g0 = null;
        this.B = Float.valueOf(this.w);
        this.C = center;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        GestureDetector gestureDetector;
        c cVar = this.g0;
        if (cVar != null && !cVar.i) {
            w0(true);
            return true;
        }
        c cVar2 = this.g0;
        if (cVar2 != null && cVar2.m != null) {
            try {
                this.g0.m.a();
            } catch (Exception unused) {
            }
        }
        this.g0 = null;
        if (this.y == null) {
            return true;
        }
        if (!this.O && ((gestureDetector = this.Q) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.M = false;
            this.N = false;
            this.P = 0;
            return true;
        }
        if (this.z == null) {
            this.z = new PointF(0.0f, 0.0f);
        }
        if (this.A == null) {
            this.A = new PointF(0.0f, 0.0f);
        }
        if (this.V == null) {
            this.V = new PointF(0.0f, 0.0f);
        }
        float f2 = this.w;
        this.A.set(this.y);
        boolean zT0 = t0(motionEvent);
        B0(f2, this.A, 2);
        return zT0 || super.onTouchEvent(motionEvent);
    }

    public final synchronized void p0(Bitmap bitmap) {
        U("onPreviewLoaded", new Object[0]);
        if (this.a == null && !this.i0) {
            Rect rect = this.L;
            if (rect != null) {
                this.a = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.L.height());
            } else {
                this.a = bitmap;
            }
            this.b = true;
            if (S()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    public void q0() {
    }

    public final synchronized void r0() {
        Bitmap bitmap;
        U("onTileLoaded", new Object[0]);
        S();
        R();
        if (i0() && (bitmap = this.a) != null) {
            if (!this.c) {
                bitmap.recycle();
            }
            this.a = null;
            g gVar = this.j0;
            if (gVar != null && this.c) {
                gVar.d();
            }
            this.b = false;
            this.c = false;
        }
        invalidate();
    }

    public final synchronized void s0(og0 og0Var, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        U("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.h));
        int i9 = this.E;
        if (i9 > 0 && (i8 = this.F) > 0 && (i9 != i2 || i8 != i3)) {
            x0(false);
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                if (!this.c) {
                    bitmap.recycle();
                }
                this.a = null;
                g gVar = this.j0;
                if (gVar != null && this.c) {
                    gVar.d();
                }
                this.b = false;
                this.c = false;
            }
        }
        this.R = og0Var;
        this.E = i2;
        this.F = i3;
        this.G = i4;
        S();
        if (!R() && (i5 = this.n) > 0 && i5 != (i6 = C0) && (i7 = this.o) > 0 && i7 != i6 && getWidth() > 0 && getHeight() > 0) {
            g0(new Point(this.n, this.o));
        }
        invalidate();
        requestLayout();
    }

    public final void setBitmapDecoderClass(Class<? extends ng0> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.T = new lg0(cls);
    }

    public final void setBitmapDecoderFactory(mg0<? extends ng0> mg0Var) {
        if (mg0Var == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.T = mg0Var;
    }

    public final void setDebug(boolean z) {
        this.g = z;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.v = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.t = f2;
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (y0.contains(Integer.valueOf(i2))) {
            this.u = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i2);
    }

    public final void setImage(ig0 ig0Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setImage(ig0Var, null, null);
    }

    public final void setMaxScale(float f2) {
        this.i = f2;
    }

    public void setMaxTileSize(int i2) {
        this.n = i2;
        this.o = i2;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinScale(float f2) {
        this.j = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinimumScaleType(int i2) {
        if (!B0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid scale type: " + i2);
        }
        this.m = i2;
        if (j0()) {
            c0(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.k = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
        if (j0()) {
            x0(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(g gVar) {
        this.j0 = gVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.l0 = onLongClickListener;
    }

    public void setOnStateChangedListener(h hVar) {
        this.k0 = hVar;
    }

    public final void setOrientation(int i2) {
        if (!x0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid orientation: " + i2);
        }
        this.h = i2;
        x0(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        PointF pointF;
        this.q = z;
        if (z || (pointF = this.y) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.w * (A0() / 2));
        this.y.y = (getHeight() / 2) - (this.w * (z0() / 2));
        if (j0()) {
            v0(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i2) {
        if (!A0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i2);
        }
        this.l = i2;
        if (j0()) {
            c0(true);
            invalidate();
        }
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.p = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.s = z;
    }

    public final void setRegionDecoderClass(Class<? extends og0> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.U = new lg0(cls);
    }

    public final void setRegionDecoderFactory(mg0<? extends og0> mg0Var) {
        if (mg0Var == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.U = mg0Var;
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.g0 = null;
        this.B = Float.valueOf(f2);
        this.C = pointF;
        this.D = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.p0 = null;
        } else {
            Paint paint = new Paint();
            this.p0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.p0.setColor(i2);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.r = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r1 != 262) goto L122;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x039b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean t0(@androidx.annotation.NonNull android.view.MotionEvent r13) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.t0(android.view.MotionEvent):boolean");
    }

    public final void u0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.E <= 0 || this.F <= 0) {
            return;
        }
        if (this.C != null && (f2 = this.B) != null) {
            this.w = f2.floatValue();
            if (this.y == null) {
                this.y = new PointF();
            }
            this.y.x = (getWidth() / 2) - (this.w * this.C.x);
            this.y.y = (getHeight() / 2) - (this.w * this.C.y);
            this.C = null;
            this.B = null;
            c0(true);
            v0(true);
        }
        c0(false);
    }

    public final void v0(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.R == null || this.f == null) {
            return;
        }
        int iMin = Math.min(this.e, Q(this.w));
        Iterator<Map.Entry<Integer, List<j>>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            for (j jVar : it.next().getValue()) {
                if (jVar.b < iMin || (jVar.b > iMin && jVar.b != this.e)) {
                    jVar.e = false;
                    if (jVar.c != null) {
                        jVar.c.recycle();
                        jVar.c = null;
                    }
                }
                if (jVar.b == iMin) {
                    if (I0(jVar)) {
                        jVar.e = true;
                        if (!jVar.d && jVar.c == null && z) {
                            a0(new k(this, this.R, jVar));
                        }
                    } else if (jVar.b != this.e) {
                        jVar.e = false;
                        if (jVar.c != null) {
                            jVar.c.recycle();
                            jVar.c = null;
                        }
                    }
                } else if (jVar.b == this.e) {
                    jVar.e = true;
                }
            }
        }
    }

    public final void w0(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void x0(boolean z) {
        g gVar;
        U("reset newImage=" + z, new Object[0]);
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = Float.valueOf(0.0f);
        this.C = null;
        this.D = null;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.e = 0;
        this.V = null;
        this.W = 0.0f;
        this.b0 = 0.0f;
        this.c0 = false;
        this.e0 = null;
        this.d0 = null;
        this.f0 = null;
        this.g0 = null;
        this.q0 = null;
        this.r0 = null;
        this.s0 = null;
        if (z) {
            this.d = null;
            if (this.R != null) {
                synchronized (this.S) {
                    this.R.recycle();
                    this.R = null;
                }
            }
            Bitmap bitmap = this.a;
            if (bitmap != null && !this.c) {
                bitmap.recycle();
            }
            if (this.a != null && this.c && (gVar = this.j0) != null) {
                gVar.d();
            }
            this.E = 0;
            this.F = 0;
            this.G = 0;
            this.K = null;
            this.L = null;
            this.h0 = false;
            this.i0 = false;
            this.a = null;
            this.b = false;
            this.c = false;
        }
        Map<Integer, List<j>> map = this.f;
        if (map != null) {
            Iterator<Map.Entry<Integer, List<j>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (j jVar : it.next().getValue()) {
                    jVar.e = false;
                    if (jVar.c != null) {
                        jVar.c.recycle();
                        jVar.c = null;
                    }
                }
            }
            this.f = null;
        }
        setGestureDetector(getContext());
    }

    public final void y0(jg0 jg0Var) {
        if (jg0Var == null || jg0Var.a() == null || !x0.contains(Integer.valueOf(jg0Var.b()))) {
            return;
        }
        this.h = jg0Var.b();
        this.B = Float.valueOf(jg0Var.c());
        this.C = jg0Var.a();
        invalidate();
    }

    public final int z0() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.E : this.F;
    }

    public final void setImage(ig0 ig0Var, jg0 jg0Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setImage(ig0Var, null, jg0Var);
    }

    public final void setImage(ig0 ig0Var, ig0 ig0Var2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setImage(ig0Var, ig0Var2, null);
    }

    public void setMaxTileSize(int i2, int i3) {
        this.n = i2;
        this.o = i3;
    }

    public final void setImage(ig0 ig0Var, ig0 ig0Var2, jg0 jg0Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Objects.requireNonNull(ig0Var, "imageSource must not be null");
        x0(true);
        if (jg0Var != null) {
            y0(jg0Var);
        }
        if (ig0Var2 != null) {
            if (ig0Var.b() == null) {
                if (ig0Var.f() > 0 && ig0Var.d() > 0) {
                    this.E = ig0Var.f();
                    this.F = ig0Var.d();
                    this.L = ig0Var2.e();
                    if (ig0Var2.b() != null) {
                        this.c = ig0Var2.i();
                        p0(ig0Var2.b());
                    } else {
                        Uri uriH = ig0Var2.h();
                        if (uriH == null && ig0Var2.c() != null) {
                            uriH = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + ig0Var2.c());
                        }
                        a0(new e(this, getContext(), this.T, uriH, true));
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                }
            } else {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
        }
        if (ig0Var.b() != null && ig0Var.e() != null) {
            o0(Bitmap.createBitmap(ig0Var.b(), ig0Var.e().left, ig0Var.e().top, ig0Var.e().width(), ig0Var.e().height()), 0, false);
            return;
        }
        if (ig0Var.b() != null) {
            o0(ig0Var.b(), 0, ig0Var.i());
            return;
        }
        this.K = ig0Var.e();
        Uri uriH2 = ig0Var.h();
        this.d = uriH2;
        if (uriH2 == null && ig0Var.c() != null) {
            this.d = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + ig0Var.c());
        }
        if (!ig0Var.g() && this.K == null) {
            a0(new e(this, getContext(), this.T, this.d, false));
        } else {
            a0(new l(this, getContext(), this.U, this.d));
        }
    }

    public static class c {
        public float a;
        public float b;
        public PointF c;
        public PointF d;
        public PointF e;
        public PointF f;
        public PointF g;
        public long h;
        public boolean i;
        public int j;
        public int k;
        public long l;
        public f m;

        public c() {
            this.h = 500L;
            this.i = true;
            this.j = 2;
            this.k = 1;
            this.l = System.currentTimeMillis();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
