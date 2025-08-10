package com.wear.widget.iwatcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import dc.be3;
import dc.ns3;
import dc.os3;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes4.dex */
public class ImageWatcher extends FrameLayout implements GestureDetector.OnGestureListener, ViewPager.OnPageChangeListener {
    public List<GifImageView> A;
    public List<String> B;
    public List<ns3> C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public i K;
    public boolean L;
    public h M;
    public final AnimatorListenerAdapter N;
    public final TypeEvaluator<Integer> O;
    public int P;
    public final Handler a;
    public int b;
    public int c;
    public final float d;
    public final TextView e;
    public GifImageView f;
    public ImageView g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final float n;
    public float o;
    public double p;
    public float q;
    public float r;
    public float s;
    public ValueAnimator t;
    public ValueAnimator u;
    public boolean v;
    public final GestureDetector w;
    public j x;
    public f y;
    public final ViewPager z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ImageWatcher.this.v = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ImageWatcher.this.v = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ImageWatcher.this.v = true;
            ImageWatcher.this.m = 7;
        }
    }

    public class b implements TypeEvaluator<Integer> {
        public b(ImageWatcher imageWatcher) {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer evaluate(float f, Integer num, Integer num2) {
            int iIntValue = num.intValue();
            int iIntValue2 = num2.intValue();
            return Integer.valueOf(Color.argb((int) (Color.alpha(iIntValue) + ((Color.alpha(iIntValue2) - Color.alpha(iIntValue)) * f)), (int) (Color.red(iIntValue) + ((Color.red(iIntValue2) - Color.red(iIntValue)) * f)), (int) (Color.green(iIntValue) + ((Color.green(iIntValue2) - Color.green(iIntValue)) * f)), (int) (Color.blue(iIntValue) + (f * (Color.blue(iIntValue2) - Color.blue(iIntValue))))));
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ImageWatcher.this.g != null) {
                ImageWatcher.this.g.setVisibility(0);
            }
            ImageWatcher.this.setVisibility(8);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ImageWatcher imageWatcher = ImageWatcher.this;
            imageWatcher.setBackgroundColor(imageWatcher.O.evaluate(fFloatValue, Integer.valueOf(this.a), Integer.valueOf(this.b)).intValue());
        }
    }

    public static class e extends Handler {
        public WeakReference<ImageWatcher> a;

        public e(ImageWatcher imageWatcher) {
            this.a = new WeakReference<>(imageWatcher);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a.get() != null) {
                ImageWatcher imageWatcher = this.a.get();
                if (message.what == 1) {
                    if (imageWatcher.F) {
                        return;
                    }
                    imageWatcher.B();
                } else {
                    throw new RuntimeException("Unknown message " + message);
                }
            }
        }
    }

    public class f extends PagerAdapter {
        public final FrameLayout.LayoutParams a = new FrameLayout.LayoutParams(-1, -1);
        public final SparseArray<GifImageView> b = new SparseArray<>();
        public final SparseArray<Object> c = new SparseArray<>();
        public boolean d;

        public class a implements g {
            public final /* synthetic */ GifImageView a;
            public final /* synthetic */ int b;
            public final /* synthetic */ boolean c;

            public a(GifImageView gifImageView, int i, boolean z) {
                this.a = gifImageView;
                this.b = i;
                this.c = z;
            }

            @Override // com.wear.widget.iwatcher.ImageWatcher.g
            public void a(Drawable drawable) {
                f.this.c(this.b, true, false);
            }

            @Override // com.wear.widget.iwatcher.ImageWatcher.g
            public void b(Bitmap bitmap) {
                int i;
                int i2;
                int i3;
                int i4;
                String str;
                float width = bitmap.getWidth();
                float height = bitmap.getHeight();
                if ((width * 1.0f) / height > (ImageWatcher.this.j * 1.0f) / ImageWatcher.this.k) {
                    int i5 = ImageWatcher.this.j;
                    i3 = (int) (((i5 * 1.0f) / width) * height);
                    int i6 = (ImageWatcher.this.k - i3) / 2;
                    this.a.setTag(R.id.image_orientation, "horizontal");
                    i2 = i5;
                    i4 = i6;
                    i = 0;
                } else {
                    int i7 = ImageWatcher.this.k;
                    int i8 = (int) (((i7 * 1.0f) / height) * width);
                    i = (ImageWatcher.this.j - i8) / 2;
                    this.a.setTag(R.id.image_orientation, "vertical");
                    i2 = i8;
                    i3 = i7;
                    i4 = 0;
                }
                DiskCache diskCache = ImageLoader.getInstance().getDiskCache();
                if (this.b >= ImageWatcher.this.B.size()) {
                    str = "" + be3.I().getTime();
                } else {
                    str = (String) ImageWatcher.this.B.get(this.b);
                }
                File file = diskCache.get(str);
                if (!file.exists() || ImageWatcher.this.L) {
                    this.a.setImageBitmap(bitmap);
                    f.this.c.put(this.b, bitmap);
                    h hVar = ImageWatcher.this.M;
                    if (hVar != null) {
                        hVar.b(this.b, this.a, bitmap);
                    }
                } else {
                    try {
                        GifDrawable gifDrawable = new GifDrawable(file);
                        this.a.setImageDrawable(gifDrawable);
                        f.this.c.put(this.b, gifDrawable);
                        h hVar2 = ImageWatcher.this.M;
                        if (hVar2 != null) {
                            hVar2.b(this.b, this.a, gifDrawable);
                        }
                    } catch (Exception unused) {
                        f.this.c.put(this.b, bitmap);
                        h hVar3 = ImageWatcher.this.M;
                        if (hVar3 != null) {
                            hVar3.b(this.b, this.a, bitmap);
                        }
                    }
                }
                f.this.c(this.b, false, false);
                os3 os3VarO = os3.o(this.a, R.id.state_default);
                os3VarO.n(i2);
                os3VarO.d(i3);
                os3VarO.l(i);
                os3VarO.m(i4);
                if (this.c) {
                    ImageWatcher.this.t(this.a, os3VarO);
                    return;
                }
                os3.f(this.a, os3VarO.a);
                this.a.setAlpha(0.0f);
                this.a.animate().alpha(1.0f).start();
            }
        }

        public f() {
        }

        public void c(int i, boolean z, boolean z2) {
            GifImageView gifImageView = this.b.get(i);
            if (gifImageView != null) {
                FrameLayout frameLayout = (FrameLayout) gifImageView.getParent();
                MaterialProgressView materialProgressView = (MaterialProgressView) frameLayout.getChildAt(1);
                if (z) {
                    materialProgressView.setVisibility(0);
                    materialProgressView.b();
                } else {
                    materialProgressView.c();
                    materialProgressView.setVisibility(8);
                }
                ImageView imageView = (ImageView) frameLayout.getChildAt(2);
                imageView.setAlpha(1.0f);
                imageView.setVisibility(z2 ? 0 : 8);
            }
        }

        public final boolean d(GifImageView gifImageView, int i, boolean z) {
            os3 os3VarO = os3.o(gifImageView, R.id.state_origin);
            os3VarO.a(0.0f);
            os3VarO.i(1.5f);
            os3VarO.k(1.5f);
            boolean z2 = false;
            if (i < ImageWatcher.this.A.size()) {
                GifImageView gifImageView2 = (GifImageView) ImageWatcher.this.A.get(i);
                if (i == ImageWatcher.this.D && !z) {
                    ImageWatcher.this.f = gifImageView;
                    ImageWatcher.this.g = gifImageView2;
                    z2 = true;
                }
                ns3 ns3Var = (ns3) ImageWatcher.this.C.get(ImageWatcher.this.D);
                int[] iArr = new int[2];
                gifImageView2.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                int unused = ImageWatcher.this.i;
                gifImageView.setTranslationX(ns3Var.c());
                gifImageView.setTranslationY(ns3Var.d());
                gifImageView.getLayoutParams().width = gifImageView2.getWidth();
                gifImageView.getLayoutParams().height = gifImageView2.getHeight();
                os3 os3VarO2 = os3.o(gifImageView, R.id.state_origin);
                os3VarO2.n(gifImageView2.getWidth());
                os3VarO2.d(gifImageView2.getHeight());
                Drawable drawable = gifImageView2.getDrawable();
                if (drawable != null) {
                    int iWidth = drawable.getBounds().width();
                    int iHeight = drawable.getBounds().height();
                    os3 os3VarO3 = os3.o(gifImageView, R.id.state_thumb);
                    os3VarO3.n(iWidth);
                    os3VarO3.d(iHeight);
                    os3VarO3.l((ImageWatcher.this.j - iWidth) / 2);
                    os3VarO3.m((ImageWatcher.this.k - iHeight) / 2);
                    gifImageView.setImageDrawable(drawable);
                    this.c.put(i, drawable);
                    h hVar = ImageWatcher.this.M;
                    if (hVar != null) {
                        hVar.b(i, gifImageView, drawable);
                    }
                    if (z2) {
                        ImageWatcher.this.t(gifImageView, os3VarO3);
                    } else {
                        os3.f(gifImageView, os3VarO3.a);
                    }
                }
            }
            os3.b(gifImageView, R.id.state_default);
            ImageWatcher.this.K.a(gifImageView.getContext(), (String) ImageWatcher.this.B.get(i), new a(gifImageView, i, z2));
            if (z2) {
                ImageWatcher.this.g.setVisibility(4);
                ImageWatcher.this.s(ViewCompat.MEASURED_STATE_MASK);
            }
            return z2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
            this.b.remove(i);
            this.c.remove(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
        public int getCount() {
            if (ImageWatcher.this.B != null) {
                return ImageWatcher.this.B.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            viewGroup.addView(frameLayout);
            GifImageView gifImageView = new GifImageView(viewGroup.getContext());
            gifImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(gifImageView);
            this.b.put(i, gifImageView);
            View materialProgressView = new MaterialProgressView(viewGroup.getContext());
            FrameLayout.LayoutParams layoutParams = this.a;
            layoutParams.gravity = 17;
            materialProgressView.setLayoutParams(layoutParams);
            frameLayout.addView(materialProgressView);
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(ImageWatcher.this.h);
            frameLayout.addView(imageView);
            imageView.setVisibility(8);
            if (d(gifImageView, i, this.d)) {
                this.d = true;
            }
            return frameLayout;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public interface g {
        void a(Drawable drawable);

        void b(Bitmap bitmap);
    }

    public interface h {
        void a(int i);

        void b(int i, GifImageView gifImageView, Object obj);
    }

    public interface i {
        void a(Context context, String str, g gVar);
    }

    public interface j {
        void K3(ImageView imageView, String str, int i);
    }

    public ImageWatcher(Context context) {
        this(context, null);
    }

    public final void A() {
        os3 os3VarE;
        GifImageView gifImageView = this.f;
        if (gifImageView == null || (os3VarE = os3.e(gifImageView, R.id.state_default)) == null) {
            return;
        }
        os3 os3VarO = os3.o(this.f, R.id.state_current);
        String str = "AAA  vsCurrent.scaleX :" + os3VarO.f + "###  vsDefault.scaleX:" + os3VarE.f;
        float f2 = os3VarO.f;
        float f3 = os3VarE.f;
        if (f2 < f3) {
            f2 = f3;
        }
        float f4 = os3VarO.g;
        float f5 = os3VarE.g;
        if (f4 < f5) {
            f4 = f5;
        }
        os3 os3VarC = os3.c(os3VarE, R.id.state_temp);
        os3VarC.h(f2);
        os3VarC.j(f4);
        this.f.setTag(R.id.state_temp, os3VarC);
        t(this.f, os3VarC);
        s(ViewCompat.MEASURED_STATE_MASK);
    }

    public boolean B() {
        GifImageView gifImageView = this.f;
        if (gifImageView == null) {
            return false;
        }
        os3 os3VarO = os3.o(gifImageView, R.id.state_current);
        os3 os3VarE = os3.e(this.f, R.id.state_default);
        if (os3VarE == null || (os3VarO.g <= os3VarE.g && os3VarO.f <= os3VarE.f)) {
            this.s = 0.0f;
        } else {
            this.s = 1.0f;
        }
        y();
        return true;
    }

    public void C(MotionEvent motionEvent) {
        int i2 = this.m;
        if (i2 == 3) {
            y();
        } else if (i2 == 5 || i2 == 6) {
            A();
        } else if (i2 == 2) {
            w();
        }
        try {
            this.z.onTouchEvent(motionEvent);
        } catch (Exception unused) {
        }
    }

    public final void D(int i2) {
        this.P = i2;
        if (this.B.size() <= 1) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.e.setText((i2 + 1) + " / " + this.B.size());
    }

    public void E(ImageView imageView, List<GifImageView> list, List<String> list2, List<ns3> list3, boolean z, h hVar) throws Resources.NotFoundException {
        String str;
        Objects.requireNonNull(this.K, "please invoke `setLoader` first [loader == null]");
        if (imageView != null && list != null && list2 != null && list.size() >= 1 && list2.size() >= list.size()) {
            int iIndexOf = list.indexOf(imageView);
            this.D = iIndexOf;
            if (iIndexOf < 0) {
                throw new IllegalArgumentException("param ImageView i must be a member of the List <ImageView> imageGroupList!");
            }
            if (imageView.getDrawable() == null) {
                return;
            }
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.u = null;
            this.M = hVar;
            this.A = list;
            this.B = list2;
            this.C = list3;
            this.F = z;
            this.g = null;
            this.f = null;
            setVisibility(0);
            ViewPager viewPager = this.z;
            f fVar = new f();
            this.y = fVar;
            viewPager.setAdapter(fVar);
            this.z.setCurrentItem(this.D);
            D(this.D);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("i[" + imageView + "]");
        sb.append("#imageGroupList ");
        String str2 = "null";
        if (list == null) {
            str = "null";
        } else {
            str = "size : " + list.size();
        }
        sb.append(str);
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append("#urlList ");
        if (list2 != null) {
            str2 = "size :" + list2.size();
        }
        sb2.append(str2);
        throw new IllegalArgumentException("error params \n" + sb2.toString());
    }

    public Object getImageResource() {
        return this.y.c.get(this.P);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.u = null;
        ValueAnimator valueAnimator2 = this.t;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.t = null;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) throws Resources.NotFoundException {
        this.m = 1;
        os3.o(this.f, R.id.state_touch_down);
        this.z.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.E == 0;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        j jVar = this.x;
        if (jVar != null) {
            jVar.K3(this.f, this.B.get(this.z.getCurrentItem()), this.z.getCurrentItem());
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        this.E = i3;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.f = (GifImageView) this.y.b.get(i2);
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (i2 < this.A.size()) {
            GifImageView gifImageView = this.A.get(i2);
            this.g = gifImageView;
            if (gifImageView.getDrawable() != null) {
                this.g.setVisibility(4);
            }
        }
        D(i2);
        ImageView imageView2 = (ImageView) this.y.b.get(i2 - 1);
        if (os3.e(imageView2, R.id.state_default) != null) {
            os3.g(imageView2, R.id.state_default).b().start();
        }
        ImageView imageView3 = (ImageView) this.y.b.get(i2 + 1);
        if (os3.e(imageView3, R.id.state_default) != null) {
            os3.g(imageView3, R.id.state_default).b().start();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) throws Resources.NotFoundException {
        float x = motionEvent != null ? motionEvent2.getX() - motionEvent.getX() : 0.0f;
        float y = motionEvent != null ? motionEvent2.getY() - motionEvent.getY() : 0.0f;
        if (this.m == 1 && (Math.abs(x) > this.n || Math.abs(y) > this.n)) {
            os3 os3VarO = os3.o(this.f, R.id.state_current);
            os3 os3VarE = os3.e(this.f, R.id.state_default);
            if (os3VarE == null) {
                this.m = 4;
            } else if (os3VarO.g > os3VarE.g || os3VarO.f > os3VarE.f) {
                if (this.m != 2) {
                    os3.o(this.f, R.id.state_touch_drag);
                }
                this.m = 2;
                String str = (String) this.f.getTag(R.id.image_orientation);
                if ("horizontal".equals(str)) {
                    float f4 = (os3VarE.b * (os3VarO.f - 1.0f)) / 2.0f;
                    float f5 = os3VarO.d;
                    if (f5 >= f4 && x > 0.0f) {
                        this.m = 4;
                    } else if (f5 <= (-f4) && x < 0.0f) {
                        this.m = 4;
                    }
                } else if ("vertical".equals(str)) {
                    int i2 = os3VarE.b;
                    float f6 = os3VarO.f;
                    float f7 = i2 * f6;
                    int i3 = this.j;
                    if (f7 > i3) {
                        float f8 = ((i2 * f6) / 2.0f) - (i2 / 2);
                        float f9 = (i3 - ((i2 * f6) / 2.0f)) - (i2 / 2);
                        float f10 = os3VarO.d;
                        if (f10 >= f8 && x > 0.0f) {
                            this.m = 4;
                        } else if (f10 <= f9 && x < 0.0f) {
                            this.m = 4;
                        }
                    } else if (Math.abs(x) > Math.abs(y)) {
                        this.m = 4;
                    }
                }
            } else {
                float fAbs = Math.abs(x);
                float f11 = this.n;
                if (fAbs < f11 && y > f11 * 3.0f) {
                    this.m = 3;
                } else if (Math.abs(x) > this.n) {
                    this.m = 4;
                }
            }
        }
        int i4 = this.m;
        if (i4 == 4) {
            try {
                this.z.onTouchEvent(motionEvent2);
                return false;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        if (i4 == 5) {
            z(motionEvent2);
            return false;
        }
        if (i4 == 3) {
            x(motionEvent2, motionEvent);
            return false;
        }
        if (i4 != 2) {
            return false;
        }
        v(motionEvent2, motionEvent);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.a.hasMessages(1)) {
            this.a.sendEmptyMessageDelayed(1, 350L);
            return false;
        }
        this.a.removeMessages(1);
        u();
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.j = i2;
        this.k = i3;
        this.b = i2 / 2;
        this.c = i3 / 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GifImageView gifImageView = this.f;
        if (gifImageView == null || this.v) {
            return true;
        }
        os3 os3VarE = os3.e(gifImageView, R.id.state_default);
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            C(motionEvent);
        } else if (action != 5) {
            if (action == 6 && os3VarE != null && this.m != 4 && motionEvent.getPointerCount() - 1 < 2) {
                this.m = 6;
            }
        } else if ((os3VarE != null && this.m != 4) || this.E == 0) {
            if (this.m != 5) {
                this.o = 0.0f;
                this.p = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.q = 0.0f;
                this.r = 0.0f;
                os3.o(this.f, R.id.state_touch_scale_rotate);
            }
            this.m = 5;
        }
        return this.w.onTouchEvent(motionEvent);
    }

    public final void s(int i2) {
        if (i2 == this.l) {
            return;
        }
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i3 = this.l;
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        this.t = duration;
        duration.addUpdateListener(new d(i3, i2));
        this.t.start();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.l = i2;
        super.setBackgroundColor(i2);
    }

    public void setErrorImageRes(int i2) {
        this.h = i2;
    }

    public void setLoader(i iVar) {
        this.K = iVar;
    }

    public void setOnPictureLongPressListener(j jVar) {
        this.x = jVar;
    }

    public void setSkipImageLoaderCache(boolean z) {
        this.L = z;
    }

    public void setTranslucentStatus(int i2) {
        this.i = i2;
        this.e.setTranslationY(this.d - i2);
    }

    public final void t(ImageView imageView, os3 os3Var) {
        if (imageView == null) {
            return;
        }
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        os3.b bVarG = os3.g(imageView, os3Var.a);
        bVarG.a(this.N);
        ValueAnimator valueAnimatorB = bVarG.b();
        this.u = valueAnimatorB;
        if (valueAnimatorB != null) {
            if (os3Var.a == R.id.state_origin) {
                valueAnimatorB.addListener(new c());
            }
            this.u.start();
        }
    }

    public final void u() {
        os3 os3VarE;
        GifImageView gifImageView = this.f;
        if (gifImageView == null) {
            return;
        }
        if ((!this.F || this.G) && (os3VarE = os3.e(gifImageView, R.id.state_default)) != null) {
            os3 os3VarO = os3.o(this.f, R.id.state_current);
            if (os3VarO.g <= os3VarE.g) {
                float f2 = os3VarO.f;
                float f3 = os3VarE.f;
                if (f2 <= f3) {
                    float f4 = ((3.8f - f3) * 0.4f) + f3;
                    GifImageView gifImageView2 = this.f;
                    os3 os3VarO2 = os3.o(gifImageView2, R.id.state_temp);
                    os3VarO2.h(f4);
                    os3VarO2.j(f4);
                    t(gifImageView2, os3VarO2);
                    return;
                }
            }
            t(this.f, os3VarE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[PHI: r11
  0x00a1: PHI (r11v11 float) = (r11v6 float), (r11v17 float), (r11v18 float) binds: [B:27:0x009f, B:14:0x005c, B:17:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v(android.view.MotionEvent r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            pl.droidsonroids.gif.GifImageView r0 = r10.f
            if (r0 != 0) goto L5
            return
        L5:
            float r0 = r11.getY()
            float r1 = r12.getY()
            float r0 = r0 - r1
            float r11 = r11.getX()
            float r12 = r12.getX()
            float r11 = r11 - r12
            pl.droidsonroids.gif.GifImageView r12 = r10.f
            r1 = 2131364625(0x7f0a0b11, float:1.8349092E38)
            dc.os3 r12 = dc.os3.e(r12, r1)
            if (r12 != 0) goto L23
            return
        L23:
            pl.droidsonroids.gif.GifImageView r1 = r10.f
            r2 = 2131364630(0x7f0a0b16, float:1.8349102E38)
            dc.os3 r1 = dc.os3.e(r1, r2)
            if (r1 != 0) goto L2f
            return
        L2f:
            float r2 = r1.d
            r3 = 1070386381(0x3fcccccd, float:1.6)
            float r4 = r11 * r3
            float r2 = r2 + r4
            pl.droidsonroids.gif.GifImageView r4 = r10.f
            r5 = 2131362978(0x7f0a04a2, float:1.8345752E38)
            java.lang.Object r4 = r4.getTag(r5)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "horizontal"
            boolean r5 = r5.equals(r4)
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 1039516303(0x3df5c28f, float:0.12)
            if (r5 == 0) goto L65
            int r11 = r12.b
            float r11 = (float) r11
            float r12 = r1.f
            r4 = 1065353216(0x3f800000, float:1.0)
            float r12 = r12 - r4
            float r11 = r11 * r12
            float r11 = r11 / r6
            int r12 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r12 <= 0) goto L5f
            goto La1
        L5f:
            float r11 = -r11
            int r12 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r12 >= 0) goto Lae
            goto La1
        L65:
            java.lang.String r5 = "vertical"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto Lae
            int r12 = r12.b
            float r4 = (float) r12
            float r5 = r1.f
            float r4 = r4 * r5
            int r8 = r10.j
            float r9 = (float) r8
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 > 0) goto L8b
            float r11 = java.lang.Math.abs(r11)
            float r12 = java.lang.Math.abs(r0)
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto Lae
            r11 = 4
            r10.m = r11
            goto Lae
        L8b:
            float r11 = (float) r12
            float r11 = r11 * r5
            float r11 = r11 / r6
            int r4 = r12 / 2
            float r4 = (float) r4
            float r11 = r11 - r4
            float r4 = (float) r8
            float r8 = (float) r12
            float r8 = r8 * r5
            float r8 = r8 / r6
            float r4 = r4 - r8
            int r12 = r12 / 2
            float r12 = (float) r12
            float r4 = r4 - r12
            int r12 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r12 <= 0) goto La6
        La1:
            float r2 = r2 - r11
            float r2 = r2 * r7
            float r2 = r2 + r11
            goto Lae
        La6:
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 >= 0) goto Lae
            float r2 = r2 - r4
            float r2 = r2 * r7
            float r2 = r2 + r4
        Lae:
            pl.droidsonroids.gif.GifImageView r11 = r10.f
            r11.setTranslationX(r2)
            pl.droidsonroids.gif.GifImageView r11 = r10.f
            float r12 = r1.e
            float r0 = r0 * r3
            float r12 = r12 + r0
            r11.setTranslationY(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.iwatcher.ImageWatcher.v(android.view.MotionEvent, android.view.MotionEvent):void");
    }

    public final void w() {
        os3 os3VarE;
        float f2;
        float f3;
        float f4;
        GifImageView gifImageView = this.f;
        if (gifImageView == null || (os3VarE = os3.e(gifImageView, R.id.state_default)) == null) {
            return;
        }
        os3 os3VarO = os3.o(this.f, R.id.state_current);
        String str = (String) this.f.getTag(R.id.image_orientation);
        if ("horizontal".equals(str)) {
            f3 = (os3VarE.b * (os3VarO.f - 1.0f)) / 2.0f;
            float f5 = os3VarO.d;
            if (f5 <= f3) {
                f3 = -f3;
                if (f5 >= f3) {
                    f3 = f5;
                }
            }
            int i2 = os3VarE.c;
            float f6 = os3VarO.g;
            float f7 = i2 * f6;
            int i3 = this.k;
            if (f7 <= i3) {
                f4 = os3VarE.e;
            } else {
                f4 = ((i2 * f6) / 2.0f) - (i2 / 2);
                float f8 = (i3 - ((i2 * f6) / 2.0f)) - (i2 / 2);
                float f9 = os3VarO.e;
                if (f9 <= f4) {
                    f4 = f9 < f8 ? f8 : f9;
                }
            }
        } else {
            if (!"vertical".equals(str)) {
                return;
            }
            float f10 = (os3VarE.c * (os3VarO.g - 1.0f)) / 2.0f;
            float f11 = os3VarO.e;
            if (f11 <= f10) {
                f10 = -f10;
                if (f11 >= f10) {
                    f10 = f11;
                }
            }
            int i4 = os3VarE.b;
            float f12 = os3VarO.f;
            float f13 = i4 * f12;
            int i5 = this.j;
            if (f13 <= i5) {
                f2 = os3VarE.d;
            } else {
                f2 = ((i4 * f12) / 2.0f) - (i4 / 2);
                float f14 = (i5 - ((i4 * f12) / 2.0f)) - (i4 / 2);
                float f15 = os3VarO.d;
                if (f15 <= f2) {
                    f2 = f15 < f14 ? f14 : f15;
                }
            }
            float f16 = f10;
            f3 = f2;
            f4 = f16;
        }
        if (os3VarO.d == f3 && os3VarO.e == f4) {
            return;
        }
        GifImageView gifImageView2 = this.f;
        os3 os3VarO2 = os3.o(gifImageView2, R.id.state_temp);
        os3VarO2.l(f3);
        os3VarO2.m(f4);
        t(gifImageView2, os3VarO2);
    }

    public final void x(MotionEvent motionEvent, MotionEvent motionEvent2) {
        os3 os3VarE;
        GifImageView gifImageView = this.f;
        if (gifImageView == null || (os3VarE = os3.e(gifImageView, R.id.state_touch_down)) == null) {
            return;
        }
        this.s = 1.0f;
        float y = motionEvent.getY() - motionEvent2.getY();
        float x = motionEvent.getX() - motionEvent2.getX();
        if (y > 0.0f) {
            this.s -= y / getHeight();
        }
        if (this.s < 0.5f) {
            this.s = 0.5f;
        }
        this.f.setTranslationX(os3VarE.d + x);
        this.f.setTranslationY(os3VarE.e + y);
        this.f.setScaleX(os3VarE.f * this.s);
        this.f.setScaleY(os3VarE.g * this.s);
        setBackgroundColor(this.O.evaluate(this.s, 0, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK)).intValue());
    }

    public final void y() {
        ns3 ns3Var;
        GifImageView gifImageView = this.f;
        if (gifImageView == null) {
            return;
        }
        if (this.s > 0.9f && !this.F) {
            os3 os3VarE = os3.e(gifImageView, R.id.state_default);
            if (os3VarE == null) {
                return;
            }
            t(this.f, os3VarE);
            s(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        os3 os3VarE2 = os3.e(gifImageView, R.id.state_origin);
        if (os3VarE2 == null) {
            return;
        }
        if (os3VarE2.i == 0.0f) {
            os3VarE2.l(this.f.getTranslationX());
            os3VarE2.m(this.f.getTranslationY());
        }
        List<ns3> list = this.C;
        if (list != null) {
            int size = list.size();
            int i2 = this.P;
            if (size > i2 && i2 >= 0 && (ns3Var = this.C.get(i2)) != null) {
                os3VarE2.l(ns3Var.c());
                os3VarE2.m(ns3Var.d());
                os3VarE2.n(ns3Var.b());
                os3VarE2.d(ns3Var.a());
            }
        }
        if (this.G) {
            this.G = false;
        }
        h hVar = this.M;
        if (hVar != null) {
            hVar.a(this.P);
        }
        this.a.removeMessages(1);
        t(this.f, os3VarE2);
        s(0);
        ((FrameLayout) this.f.getParent()).getChildAt(2).animate().alpha(0.0f).start();
    }

    public final void z(MotionEvent motionEvent) {
        os3 os3VarE;
        GifImageView gifImageView = this.f;
        if (gifImageView == null || os3.e(gifImageView, R.id.state_default) == null || (os3VarE = os3.e(this.f, R.id.state_touch_scale_rotate)) == null || motionEvent.getPointerCount() < 2) {
            return;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        double degrees = Math.toDegrees(Math.atan(x / y));
        if (y < 0.0f) {
            degrees += 180.0d;
        }
        if (this.p == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.p = degrees;
        }
        float f2 = (os3VarE.h + ((float) (this.p - degrees))) % 360.0f;
        if (f2 > 180.0f) {
            f2 -= 360.0f;
        } else if (f2 < -180.0f) {
            f2 += 360.0f;
        }
        this.f.setRotation(f2);
        float fSqrt = (float) Math.sqrt((x * x) + (y * y));
        if (this.o == 0.0f) {
            this.o = fSqrt;
        }
        float f3 = (this.o - fSqrt) / (this.j * 0.8f);
        float f4 = os3VarE.f - f3;
        float f5 = 3.8f;
        if (f4 < 0.5f) {
            f4 = 0.5f;
        } else if (f4 > 3.8f) {
            f4 = 3.8f;
        }
        this.f.setScaleX(f4);
        float f6 = os3VarE.g - f3;
        if (f6 < 0.5f) {
            f5 = 0.5f;
        } else if (f6 <= 3.8f) {
            f5 = f6;
        }
        this.f.setScaleY(f5);
        float x2 = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
        float y2 = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        if (this.q == 0.0f && this.r == 0.0f) {
            this.q = x2;
            this.r = y2;
        }
        float f7 = os3VarE.d - (this.q - x2);
        int i2 = this.b;
        if (f7 > i2) {
            f7 = i2;
        } else if (f7 < (-i2)) {
            i2 = -i2;
            f7 = i2;
        }
        this.f.setTranslationX(f7);
        float f8 = os3VarE.e - (this.r - y2);
        int i3 = this.c;
        if (f8 > i3) {
            f8 = i3;
        } else if (f8 < (-i3)) {
            i3 = -i3;
            f8 = i3;
        }
        this.f.setTranslationY(f8);
    }

    public ImageWatcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = R.drawable.error_picture;
        this.l = 0;
        this.m = 0;
        this.N = new a();
        this.O = new b(this);
        this.P = 0;
        this.a = new e(this);
        this.w = new GestureDetector(context, this);
        this.n = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewPager viewPager = new ViewPager(getContext());
        this.z = viewPager;
        addView(viewPager);
        viewPager.addOnPageChangeListener(this);
        setVisibility(4);
        TextView textView = new TextView(context);
        this.e = textView;
        addView(textView);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        float fApplyDimension = TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics()) + 0.5f;
        this.d = fApplyDimension;
        textView.setTranslationY(fApplyDimension);
    }
}
