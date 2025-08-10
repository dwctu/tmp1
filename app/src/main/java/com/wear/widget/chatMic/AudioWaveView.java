package com.wear.widget.chatMic;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.media.MediaRecorder;
import android.util.AttributeSet;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import com.wear.widget.chatMic.AudioWaveView;
import dc.th4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skin.support.widget.SkinCompatView;

/* compiled from: AudioWaveView.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020#H\u0016J\u000e\u0010&\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010'\u001a\u00020#H\u0002J\u0006\u0010(\u001a\u00020\u001cJ\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0014J\u0006\u0010,\u001a\u00020#J\u0006\u0010-\u001a\u00020#R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\n*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/wear/widget/chatMic/AudioWaveView;", "Lskin/support/widget/SkinCompatView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backgroundPaint", "Landroid/graphics/Paint;", "defaultBackgroundColor", "", "drawableLinesPoint", "", "Landroid/graphics/RectF;", "filterVolume", "isActive", "", "lineWidth", "mMediaRecorder", "Landroid/media/MediaRecorder;", "paint", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "path$delegate", "Lkotlin/Lazy;", "recordDb", "", "selectedBackgroundColor", "step", "dp", "getDp", "(I)I", "addDrawableLinesPoint", "", "count", "applySkin", "bindMediaRecorder", "generateBackgroundColor", "getRecordDb", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startAnimation", "stopAnimation", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class AudioWaveView extends SkinCompatView {

    @NotNull
    public final Paint b;
    public int c;
    public int d;

    @NotNull
    public final Paint e;
    public final int f;
    public final int g;

    @NotNull
    public final List<RectF> h;

    @Nullable
    public MediaRecorder i;
    public final int j;
    public boolean k;
    public double l;

    @NotNull
    public final Lazy m;

    /* compiled from: AudioWaveView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Path;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Path> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Path invoke() {
            return new Path();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioWaveView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Paint paint = new Paint();
        paint.setColor(th4.b(context, R.color.lvs_ui_standard_systemText2));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.b = paint;
        Paint paint2 = new Paint();
        d();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        this.e = paint2;
        this.f = e(4);
        this.g = e(1);
        this.h = new ArrayList();
        this.j = 50;
        this.m = LazyKt__LazyJVMKt.lazy(a.a);
    }

    public static final void b(AudioWaveView this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.i != null && this$0.k) {
            for (RectF rectF : this$0.h) {
                float f = 1;
                rectF.left -= f;
                rectF.right -= f;
            }
            if (i <= this$0.f && !this$0.h.isEmpty()) {
                this$0.invalidate();
                this$0.a(i + 1);
                return;
            }
            try {
            } catch (IllegalStateException unused) {
            }
            double maxAmplitude = this$0.i != null ? r11.getMaxAmplitude() : 0.0d;
            double d = maxAmplitude / 1.0d;
            this$0.l = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (d > 1.0d) {
                this$0.l = 20 * Math.log10(d);
            }
            double d2 = this$0.l;
            if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this$0.a(0);
                return;
            }
            double d3 = d2 - this$0.j;
            this$0.l = d3;
            double height = (d3 / (100 - r0)) * ((this$0.getHeight() / 2) - this$0.g);
            float f2 = 2;
            this$0.h.add(new RectF(this$0.getWidth() - this$0.g, (float) (((this$0.getHeight() / f2) - this$0.g) - height), this$0.getWidth(), (float) ((this$0.getHeight() / f2) + this$0.g + height)));
            this$0.a(0);
        }
    }

    private final Path getPath() {
        return (Path) this.m.getValue();
    }

    @Override // skin.support.widget.SkinCompatView, dc.aj4
    public void P1() {
        super.P1();
        this.b.setColor(th4.b(getContext(), R.color.lvs_ui_standard_systemText2));
        d();
    }

    public final void a(final int i) {
        post(new Runnable() { // from class: dc.io3
            @Override // java.lang.Runnable
            public final void run() {
                AudioWaveView.b(this.a, i);
            }
        });
    }

    public final void c(@NotNull MediaRecorder mMediaRecorder) {
        Intrinsics.checkNotNullParameter(mMediaRecorder, "mMediaRecorder");
        this.i = mMediaRecorder;
    }

    public final void d() {
        ColorStateList colorStateListC = th4.c(getContext(), R.color.bg_voice_message_panel_input);
        this.d = colorStateListC.getColorForState(new int[]{-16842913}, 0);
        this.c = colorStateListC.getColorForState(new int[]{android.R.attr.state_selected}, 0);
    }

    public final int e(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void g() {
        this.k = true;
        a(0);
    }

    /* renamed from: getRecordDb, reason: from getter */
    public final double getL() {
        return this.l;
    }

    public final void h() {
        this.k = false;
        this.h.clear();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Iterator<RectF> it = this.h.iterator();
        while (it.hasNext()) {
            RectF next = it.next();
            canvas.drawRoundRect(next, 99.0f, 99.0f, this.b);
            if (next.right <= 0.0f) {
                it.remove();
            }
        }
        getPath().reset();
        float f = 2;
        getPath().addRect((getHeight() / f) + (getWidth() - getHeight()), f * this.g, getWidth(), getHeight() - (this.g * 2), Path.Direction.CCW);
        getPath().addArc(getWidth() - getHeight(), this.g * 2, getWidth(), getHeight() - (this.g * 2), 270.0f, 180.0f);
        getPath().setFillType(Path.FillType.EVEN_ODD);
        this.e.setColor(isSelected() ? this.c : this.d);
        canvas.drawPath(getPath(), this.e);
    }
}
