package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FallingView.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002:\u00046789B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010+\u001a\u00020%H\u0014J\u0010\u0010,\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010-\u001a\u00020%H\u0016J\u001a\u0010.\u001a\u00020%\"\u0004\b\u0000\u0010/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/0\u0018J\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0014J\u0014\u00103\u001a\u00020%2\n\u00100\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002J\u0006\u00104\u001a\u00020%J\u0006\u00105\u001a\u00020%R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/wear/widget/FallingView;", "Landroid/widget/FrameLayout;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "kotlin.jvm.PlatformType", "cacheHolder", "Ljava/util/HashSet;", "Lcom/wear/widget/FallingView$Holder;", "Lkotlin/collections/HashSet;", "fallingListener", "Lcom/wear/widget/FallingView$OnFallingListener;", "handlerTask", "Landroid/os/Handler;", "iFallingAdapter", "Lcom/wear/widget/FallingView$IFallingAdapter;", "isStop", "", "()Z", "setStop", "(Z)V", "lastStartTime", "", "paint", "Landroid/graphics/Paint;", "position", "timeOn", "assistLine", "", "path", "Landroid/graphics/Path;", "canvas", "Landroid/graphics/Canvas;", "initView", "onDetachedFromWindow", "onDraw", "run", "setAdapter", ExifInterface.GPS_DIRECTION_TRUE, "adapter", "setOnFallingListener", "onFallingListener", "showItem", "startFalling", "stopFalling", "Config", "Holder", "IFallingAdapter", "OnFallingListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class FallingView extends FrameLayout implements Runnable {
    public final String a;

    @NotNull
    public Handler b;

    @Nullable
    public c<?> c;
    public int d;

    @Nullable
    public d e;
    public long f;

    @NotNull
    public final HashSet<b> g;
    public boolean h;

    @NotNull
    public final Paint i;

    /* compiled from: FallingView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/wear/widget/FallingView$Config;", "", "()V", "anim", "Landroid/view/animation/Animation;", "getAnim", "()Landroid/view/animation/Animation;", "setAnim", "(Landroid/view/animation/Animation;)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public long a;

        @Nullable
        public Animation b;

        @Nullable
        public Path c;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Animation getB() {
            return this.b;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Path getC() {
            return this.c;
        }

        /* renamed from: c, reason: from getter */
        public final long getA() {
            return this.a;
        }

        public final void d(@Nullable Animation animation) {
            this.b = animation;
        }

        public final void e(@Nullable Path path) {
            this.c = path;
        }

        public final void f(long j) {
            this.a = j;
        }
    }

    /* compiled from: FallingView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/wear/widget/FallingView$Holder;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "config", "Lcom/wear/widget/FallingView$Config;", "getConfig", "()Lcom/wear/widget/FallingView$Config;", "setConfig", "(Lcom/wear/widget/FallingView$Config;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "getView", "()Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        @NotNull
        public final View a;

        @NotNull
        public a b;
        public int c;

        public b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = view;
            this.b = new a();
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getB() {
            return this.b;
        }

        /* renamed from: b, reason: from getter */
        public final int getC() {
            return this.c;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final View getA() {
            return this.a;
        }

        public final void d(int i) {
            this.c = i;
        }
    }

    /* compiled from: FallingView.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/wear/widget/FallingView$IFallingAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "layoutId", "", "(I)V", "datas", "", "getDatas", "()Ljava/util/List;", "setDatas", "(Ljava/util/List;)V", "getLayoutId", "()I", "convert", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/wear/widget/FallingView$Holder;", "convertAnim", "Landroid/view/animation/Animation;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class c<T> {
        public final int a;

        @Nullable
        public List<? extends T> b;

        public c(@LayoutRes int i) {
            this.a = i;
        }

        public abstract void a(@NotNull ViewGroup viewGroup, @NotNull b bVar);

        @NotNull
        public abstract Animation b(@NotNull ViewGroup viewGroup, @NotNull b bVar);

        @Nullable
        public final List<T> c() {
            return this.b;
        }

        /* renamed from: d, reason: from getter */
        public final int getA() {
            return this.a;
        }

        public final void e(@Nullable List<? extends T> list) {
            this.b = list;
        }
    }

    /* compiled from: FallingView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/wear/widget/FallingView$OnFallingListener;", "", "onStart", "", "onStop", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface d {
        void onStart();

        void onStop();
    }

    /* compiled from: FallingView.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/wear/widget/FallingView$showItem$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements Animation.AnimationListener {
        public final /* synthetic */ Ref.ObjectRef<b> b;

        public e(Ref.ObjectRef<b> objectRef) {
            this.b = objectRef;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            FallingView.this.removeView(this.b.element.getA());
            if (FallingView.this.getChildCount() == 0) {
                FallingView.this.setStop(true);
                d dVar = FallingView.this.e;
                if (dVar != null) {
                    dVar.onStop();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FallingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = FallingView.class.getSimpleName();
        this.b = new Handler();
        this.g = new HashSet<>();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStrokeWidth(4.0f);
        this.i = paint;
        c(context, null);
    }

    public final void b(Path path, Canvas canvas) {
        canvas.drawPath(path, this.i);
    }

    public final void c(Context context, AttributeSet attributeSet) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, com.wear.widget.FallingView$b] */
    public final void d(c<?> cVar) {
        d dVar;
        if (this.d == 0 && (dVar = this.e) != null) {
            dVar.onStart();
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.g.isEmpty()) {
            View inflate = LayoutInflater.from(getContext()).inflate(cVar.getA(), (ViewGroup) this, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate");
            objectRef.element = new b(inflate);
        } else {
            Iterator<b> it = this.g.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "cacheHolder.iterator()");
            ?? next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            objectRef.element = next;
            it.remove();
        }
        ((b) objectRef.element).d(this.d);
        addView(((b) objectRef.element).getA());
        cVar.a(this, (b) objectRef.element);
        ((b) objectRef.element).getB().d(cVar.b(this, (b) objectRef.element));
        Animation b2 = ((b) objectRef.element).getB().getB();
        if (b2 != null) {
            b2.setAnimationListener(new e(objectRef));
        }
        ((b) objectRef.element).getA().startAnimation(((b) objectRef.element).getB().getB());
        this.b.postDelayed(this, ((b) objectRef.element).getB().getA() - this.f);
        this.f = ((b) objectRef.element).getB().getA();
        this.d++;
    }

    public final void e() {
        if (this.c == null) {
            return;
        }
        this.d = 0;
        System.currentTimeMillis();
        this.b.post(this);
    }

    public final void f() {
        this.b.removeCallbacks(this);
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (it.hasNext()) {
            it.next().clearAnimation();
        }
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Iterator<T> it = this.g.iterator();
        while (it.hasNext()) {
            Path c2 = ((b) it.next()).getB().getC();
            if (c2 != null) {
                b(c2, canvas);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?> cVar;
        if (this.h || (cVar = this.c) == null) {
            return;
        }
        List<?> listC = cVar.c();
        if (listC == null || listC.isEmpty()) {
            return;
        }
        int i = this.d;
        List<?> listC2 = cVar.c();
        Intrinsics.checkNotNull(listC2);
        if (i >= listC2.size() - 1) {
            return;
        }
        d(cVar);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void setAdapter(@NotNull c<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.c = adapter;
    }

    public final void setOnFallingListener(@NotNull d onFallingListener) {
        Intrinsics.checkNotNullParameter(onFallingListener, "onFallingListener");
        this.e = onFallingListener;
    }

    public final void setStop(boolean z) {
        this.h = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FallingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = FallingView.class.getSimpleName();
        this.b = new Handler();
        this.g = new HashSet<>();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStrokeWidth(4.0f);
        this.i = paint;
        c(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FallingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = FallingView.class.getSimpleName();
        this.b = new Handler();
        this.g = new HashSet<>();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStrokeWidth(4.0f);
        this.i = paint;
        c(context, attributeSet);
    }
}
