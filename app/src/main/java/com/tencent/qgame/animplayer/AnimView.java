package com.tencent.qgame.animplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.tencent.qgame.animplayer.textureview.InnerTextureView;
import dc.bh1;
import dc.bi1;
import dc.ch1;
import dc.dh1;
import dc.di1;
import dc.eh1;
import dc.fh1;
import dc.ii1;
import dc.ng1;
import dc.oh1;
import dc.pg1;
import dc.wg1;
import dc.xh1;
import io.agora.rtc2.video.VideoCaptureFormat;
import io.agora.rtm2.RtmConstants;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: AnimView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000µ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001M\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010m\u001a\u00020l\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010n\u0012\b\b\u0002\u0010p\u001a\u00020\u0010¢\u0006\u0004\bq\u0010rJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J/\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0014¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\"\u0010\u0006J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0010H\u0007¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0010H\u0016¢\u0006\u0004\b5\u00101J\u0017\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0017\u00108\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b8\u0010<J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0017H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u001b\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100HH\u0016¢\u0006\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010KR\u001d\u0010Q\u001a\u00020M8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010[R\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001d\u0010j\u001a\u00020f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010N\u001a\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010R¨\u0006s"}, d2 = {"Lcom/tencent/qgame/animplayer/AnimView;", "Ldc/wg1;", "Landroid/widget/FrameLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "", "i", "()V", "Lkotlin/Function0;", "f", "l", "(Lkotlin/jvm/functions/Function0;)V", "a", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "surface", "", VideoCaptureFormat.keyWidth, VideoCaptureFormat.keyHeight, "onSurfaceTextureSizeChanged", "(Landroid/graphics/SurfaceTexture;II)V", "onSurfaceTextureUpdated", "(Landroid/graphics/SurfaceTexture;)V", "", "onSurfaceTextureDestroyed", "(Landroid/graphics/SurfaceTexture;)Z", "onSurfaceTextureAvailable", "w", XHTMLText.H, "oldw", "oldh", "onSizeChanged", "(IIII)V", "onAttachedToWindow", "onDetachedFromWindow", "Ldc/dh1;", "animListener", "setAnimListener", "(Ldc/dh1;)V", "Ldc/eh1;", "fetchResource", "setFetchResource", "(Ldc/eh1;)V", "Ldc/fh1;", "resourceClickListener", "setOnResourceClickListener", "(Ldc/fh1;)V", "playLoop", "setLoop", "(I)V", "mode", "setVideoMode", VideoCaptureFormat.keyFPS, "setFps", "Ldc/di1;", "type", "setScaleType", "(Ldc/di1;)V", "Ldc/bi1;", "scaleType", "(Ldc/bi1;)V", "isMute", "setMute", "(Z)V", "Ljava/io/File;", "file", "k", "(Ljava/io/File;)V", "Ldc/ch1;", "fileContainer", "j", "(Ldc/ch1;)V", "Lkotlin/Pair;", "getRealSize", "()Lkotlin/Pair;", "Ldc/ch1;", "lastFile", "com/tencent/qgame/animplayer/AnimView$a$a", "Lkotlin/Lazy;", "getAnimProxyListener", "()Lcom/tencent/qgame/animplayer/AnimView$a$a;", "animProxyListener", "Z", "needPrepareTextureView", "Lcom/tencent/qgame/animplayer/textureview/InnerTextureView;", "e", "Lcom/tencent/qgame/animplayer/textureview/InnerTextureView;", "innerTextureView", "c", "Landroid/graphics/SurfaceTexture;", "Ldc/pg1;", "Ldc/pg1;", "player", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "prepareTextureViewRunnable", "Ldc/ii1;", "g", "Ldc/ii1;", "scaleTypeUtil", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "Ldc/dh1;", "Landroid/os/Handler;", "b", "getUiHandler", "()Landroid/os/Handler;", "uiHandler", "onSizeChangedCalled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animplayer_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public class AnimView extends FrameLayout implements wg1, TextureView.SurfaceTextureListener {
    public static final /* synthetic */ KProperty[] l = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AnimView.class), "uiHandler", "getUiHandler()Landroid/os/Handler;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AnimView.class), "animProxyListener", "getAnimProxyListener()Lcom/tencent/qgame/animplayer/AnimView$animProxyListener$2$1;"))};

    /* renamed from: a, reason: from kotlin metadata */
    public pg1 player;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy uiHandler;

    /* renamed from: c, reason: from kotlin metadata */
    public SurfaceTexture surface;

    /* renamed from: d, reason: from kotlin metadata */
    public dh1 animListener;

    /* renamed from: e, reason: from kotlin metadata */
    public InnerTextureView innerTextureView;

    /* renamed from: f, reason: from kotlin metadata */
    public ch1 lastFile;

    /* renamed from: g, reason: from kotlin metadata */
    public final ii1 scaleTypeUtil;

    /* renamed from: h, reason: from kotlin metadata */
    public final Lazy animProxyListener;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean onSizeChangedCalled;

    /* renamed from: j, reason: from kotlin metadata */
    public boolean needPrepareTextureView;

    /* renamed from: k, reason: from kotlin metadata */
    public final Runnable prepareTextureViewRunnable;

    /* compiled from: AnimView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0007\n\u0002\b\u0003*\u0001\u0000\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/tencent/qgame/animplayer/AnimView$a$a", "a", "()Lcom/tencent/qgame/animplayer/AnimView$a$a;"}, k = 3, mv = {1, 4, 0})
    public static final class a extends Lambda implements Function0<C0067a> {

        /* compiled from: AnimView.kt */
        /* renamed from: com.tencent.qgame.animplayer.AnimView$a$a, reason: collision with other inner class name */
        public static final class C0067a implements dh1 {
            public C0067a() {
            }

            @Override // dc.dh1
            public void a() {
                AnimView.this.i();
                dh1 dh1Var = AnimView.this.animListener;
                if (dh1Var != null) {
                    dh1Var.a();
                }
            }

            @Override // dc.dh1
            public void b() {
                AnimView.this.i();
                dh1 dh1Var = AnimView.this.animListener;
                if (dh1Var != null) {
                    dh1Var.b();
                }
            }

            @Override // dc.dh1
            public void c(int i, @Nullable String str) {
                dh1 dh1Var = AnimView.this.animListener;
                if (dh1Var != null) {
                    dh1Var.c(i, str);
                }
            }

            @Override // dc.dh1
            public void d() {
                dh1 dh1Var = AnimView.this.animListener;
                if (dh1Var != null) {
                    dh1Var.d();
                }
            }

            @Override // dc.dh1
            public void e(int i, @Nullable ng1 ng1Var) {
                dh1 dh1Var = AnimView.this.animListener;
                if (dh1Var != null) {
                    dh1Var.e(i, ng1Var);
                }
            }

            @Override // dc.dh1
            public boolean f(@NotNull ng1 config) {
                Intrinsics.checkParameterIsNotNull(config, "config");
                AnimView.this.scaleTypeUtil.k(config.j(), config.d());
                dh1 dh1Var = AnimView.this.animListener;
                return dh1Var != null ? dh1Var.f(config) : dh1.a.a(this, config);
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C0067a invoke() {
            return new C0067a();
        }
    }

    /* compiled from: AnimView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnimView.this.removeAllViews();
        }
    }

    /* compiled from: AnimView.kt */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            InnerTextureView innerTextureView = AnimView.this.innerTextureView;
            if (innerTextureView != null) {
                innerTextureView.setSurfaceTextureListener(null);
            }
            AnimView.this.innerTextureView = null;
            AnimView.this.removeAllViews();
        }
    }

    /* compiled from: AnimView.kt */
    public static final class d implements Runnable {
        public final /* synthetic */ Context b;

        public d(Context context) {
            this.b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnimView.this.removeAllViews();
            AnimView animView = AnimView.this;
            InnerTextureView innerTextureView = new InnerTextureView(this.b, null, 0, 6, null);
            innerTextureView.setPlayer(AnimView.d(AnimView.this));
            innerTextureView.setOpaque(false);
            innerTextureView.setSurfaceTextureListener(AnimView.this);
            innerTextureView.setLayoutParams(AnimView.this.scaleTypeUtil.c(innerTextureView));
            animView.innerTextureView = innerTextureView;
            AnimView animView2 = AnimView.this;
            animView2.addView(animView2.innerTextureView);
        }
    }

    /* compiled from: AnimView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ch1 $fileContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ch1 ch1Var) {
            super(0);
            this.$fileContainer = ch1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (AnimView.this.getVisibility() != 0) {
                xh1.c.b("AnimPlayer.AnimView", "AnimView is GONE, can't play");
            } else {
                if (AnimView.d(AnimView.this).o()) {
                    xh1.c.b("AnimPlayer.AnimView", "is running can not start");
                    return;
                }
                AnimView.this.lastFile = this.$fileContainer;
                AnimView.d(AnimView.this).B(this.$fileContainer);
            }
        }
    }

    /* compiled from: AnimView.kt */
    public static final class f implements Runnable {
        public final /* synthetic */ Function0 a;

        public f(Function0 function0) {
            this.a = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();
        }
    }

    /* compiled from: AnimView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/os/Handler;", "a", "()Landroid/os/Handler;"}, k = 3, mv = {1, 4, 0})
    public static final class g extends Lambda implements Function0<Handler> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    @JvmOverloads
    public AnimView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public AnimView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AnimView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ pg1 d(AnimView animView) {
        pg1 pg1Var = animView.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return pg1Var;
    }

    private final a.C0067a getAnimProxyListener() {
        Lazy lazy = this.animProxyListener;
        KProperty kProperty = l[1];
        return (a.C0067a) lazy.getValue();
    }

    private final Handler getUiHandler() {
        Lazy lazy = this.uiHandler;
        KProperty kProperty = l[0];
        return (Handler) lazy.getValue();
    }

    @Override // dc.wg1
    public void a() {
        if (this.onSizeChangedCalled) {
            getUiHandler().post(this.prepareTextureViewRunnable);
        } else {
            xh1.c.b("AnimPlayer.AnimView", "onSizeChanged not called");
            this.needPrepareTextureView = true;
        }
    }

    @Override // dc.wg1
    @NotNull
    public Pair<Integer, Integer> getRealSize() {
        return this.scaleTypeUtil.d();
    }

    @Override // dc.wg1
    @Nullable
    public SurfaceTexture getSurfaceTexture() {
        SurfaceTexture surfaceTexture;
        InnerTextureView innerTextureView = this.innerTextureView;
        return (innerTextureView == null || (surfaceTexture = innerTextureView.getSurfaceTexture()) == null) ? this.surface : surfaceTexture;
    }

    public final void i() {
        ch1 ch1Var = this.lastFile;
        if (ch1Var != null) {
            ch1Var.close();
        }
        l(new b());
    }

    public void j(@NotNull ch1 fileContainer) {
        Intrinsics.checkParameterIsNotNull(fileContainer, "fileContainer");
        l(new e(fileContainer));
    }

    public void k(@NotNull File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            j(new bh1(file));
        } catch (Throwable unused) {
            getAnimProxyListener().c(RtmConstants.RTM_ERR_EXCEED_CHANNEL_LIMITATION, "0x7 file can't read");
            getAnimProxyListener().a();
        }
    }

    public final void l(Function0<Unit> f2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            f2.invoke();
        } else {
            getUiHandler().post(new f(f2));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ch1 ch1Var;
        xh1.c.d("AnimPlayer.AnimView", "onAttachedToWindow");
        super.onAttachedToWindow();
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.v(false);
        pg1 pg1Var2 = this.player;
        if (pg1Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        if (pg1Var2.i() <= 0 || (ch1Var = this.lastFile) == null) {
            return;
        }
        j(ch1Var);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        xh1.c.d("AnimPlayer.AnimView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.v(true);
        pg1 pg1Var2 = this.player;
        if (pg1Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var2.q();
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        xh1.c.d("AnimPlayer.AnimView", "onSizeChanged w=" + w + ", h=" + h);
        this.scaleTypeUtil.i(w, h);
        this.onSizeChangedCalled = true;
        if (this.needPrepareTextureView) {
            this.needPrepareTextureView = false;
            a();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        xh1.c.d("AnimPlayer.AnimView", "onSurfaceTextureAvailable width=" + width + " height=" + height);
        this.surface = surface;
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.p(width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        xh1.c.d("AnimPlayer.AnimView", "onSurfaceTextureDestroyed");
        this.surface = null;
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.q();
        getUiHandler().post(new c());
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        xh1.c.d("AnimPlayer.AnimView", "onSurfaceTextureSizeChanged " + width + " x " + height);
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.r(width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
    }

    public void setAnimListener(@Nullable dh1 animListener) {
        this.animListener = animListener;
    }

    public void setFetchResource(@Nullable eh1 fetchResource) {
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        oh1 oh1VarA = pg1Var.j().a();
        if (oh1VarA != null) {
            oh1VarA.w(fetchResource);
        }
    }

    public void setFps(int fps) {
        xh1.c.d("AnimPlayer.AnimView", "setFps=" + fps);
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.u(fps);
    }

    public void setLoop(int playLoop) {
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.y(playLoop);
    }

    public void setMute(boolean isMute) {
        xh1.c.b("AnimPlayer.AnimView", "set mute=" + isMute);
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.x(isMute);
    }

    public void setOnResourceClickListener(@Nullable fh1 resourceClickListener) {
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        oh1 oh1VarA = pg1Var.j().a();
        if (oh1VarA != null) {
            oh1VarA.v(resourceClickListener);
        }
    }

    public void setScaleType(@NotNull di1 type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.scaleTypeUtil.h(type);
    }

    @Deprecated(message = "Compatible older version mp4")
    public final void setVideoMode(int mode) {
        pg1 pg1Var = this.player;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.A(mode);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.uiHandler = LazyKt__LazyJVMKt.lazy(g.a);
        this.scaleTypeUtil = new ii1();
        this.animProxyListener = LazyKt__LazyJVMKt.lazy(new a());
        this.prepareTextureViewRunnable = new d(context);
        i();
        pg1 pg1Var = new pg1(this);
        this.player = pg1Var;
        if (pg1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        pg1Var.t(getAnimProxyListener());
    }

    public void setScaleType(@NotNull bi1 scaleType) {
        Intrinsics.checkParameterIsNotNull(scaleType, "scaleType");
        this.scaleTypeUtil.j(scaleType);
    }
}
