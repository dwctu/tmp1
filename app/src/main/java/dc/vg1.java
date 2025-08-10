package dc;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import io.agora.rtc2.video.VideoCaptureFormat;
import io.agora.rtm2.RtmConstants;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HardDecoder.kt */
/* loaded from: classes3.dex */
public final class vg1 extends sg1 implements SurfaceTexture.OnFrameAvailableListener {
    public static final /* synthetic */ KProperty[] w = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(vg1.class), "bufferInfo", "getBufferInfo()Landroid/media/MediaCodec$BufferInfo;"))};
    public Surface m;
    public SurfaceTexture n;
    public final Lazy o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public MediaFormat v;

    /* compiled from: HardDecoder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/media/MediaCodec$BufferInfo;", "a", "()Landroid/media/MediaCodec$BufferInfo;"}, k = 3, mv = {1, 4, 0})
    public static final class a extends Lambda implements Function0<MediaCodec.BufferInfo> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediaCodec.BufferInfo invoke() {
            return new MediaCodec.BufferInfo();
        }
    }

    /* compiled from: HardDecoder.kt */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            vg1.this.k().j().d();
            xg1 xg1VarL = vg1.this.l();
            if (xg1VarL != null) {
                xg1VarL.d();
            }
            vg1.this.w(null);
            vg1.this.b();
            vg1.this.h();
        }
    }

    /* compiled from: HardDecoder.kt */
    public static final class c implements Runnable {
        public final /* synthetic */ MediaCodec b;
        public final /* synthetic */ MediaExtractor c;

        public c(MediaCodec mediaCodec, MediaExtractor mediaExtractor) {
            this.b = mediaCodec;
            this.c = mediaExtractor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            xg1 xg1VarL = vg1.this.l();
            if (xg1VarL != null) {
                xg1VarL.h();
            }
            try {
                xh1.c.d("AnimPlayer.HardDecoder", "release");
                MediaCodec mediaCodec = this.b;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    mediaCodec.release();
                }
                MediaExtractor mediaExtractor = this.c;
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
                SurfaceTexture surfaceTexture = vg1.this.n;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                vg1.this.n = null;
                vg1.this.n().b();
                vg1.this.k().j().g();
                xg1 xg1VarL2 = vg1.this.l();
                if (xg1VarL2 != null) {
                    xg1VarL2.g();
                }
                Surface surface = vg1.this.m;
                if (surface != null) {
                    surface.release();
                }
                vg1.this.m = null;
            } catch (Throwable th) {
                xh1.c.c("AnimPlayer.HardDecoder", "release e=" + th, th);
            }
            vg1.this.x(false);
            vg1.this.a();
            if (vg1.this.p) {
                vg1.this.K();
            }
        }
    }

    /* compiled from: HardDecoder.kt */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                SurfaceTexture surfaceTexture = vg1.this.n;
                if (surfaceTexture != null) {
                    surfaceTexture.updateTexImage();
                    xg1 xg1VarL = vg1.this.l();
                    if (xg1VarL != null) {
                        xg1VarL.c();
                    }
                    vg1.this.k().j().i();
                    xg1 xg1VarL2 = vg1.this.l();
                    if (xg1VarL2 != null) {
                        xg1VarL2.swapBuffers();
                    }
                }
            } catch (Throwable th) {
                xh1.c.c("AnimPlayer.HardDecoder", "render exception=" + th, th);
            }
        }
    }

    /* compiled from: HardDecoder.kt */
    public static final class e implements Runnable {
        public final /* synthetic */ ch1 b;

        public e(ch1 ch1Var) {
            this.b = ch1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            vg1.this.P(this.b);
        }
    }

    /* compiled from: HardDecoder.kt */
    public static final class f implements Runnable {
        public final /* synthetic */ MediaCodec a;
        public final /* synthetic */ vg1 b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ Ref.ObjectRef d;

        public f(MediaCodec mediaCodec, vg1 vg1Var, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
            this.a = mediaCodec;
            this.b = vg1Var;
            this.c = objectRef2;
            this.d = objectRef3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            try {
                vg1 vg1Var = this.b;
                MediaExtractor mediaExtractor = (MediaExtractor) this.c.element;
                MediaCodec mediaCodec = this.a;
                Intrinsics.checkExpressionValueIsNotNull(mediaCodec, "this");
                vg1Var.O(mediaExtractor, mediaCodec);
            } catch (Throwable th) {
                xh1.c.c("AnimPlayer.HardDecoder", "MediaCodec exception e=" + th, th);
                this.b.c(RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION, "0x2 MediaCodec exception e=" + th);
                this.b.M((MediaCodec) this.d.element, (MediaExtractor) this.c.element);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vg1(@NotNull pg1 player) {
        super(player);
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.o = LazyKt__LazyJVMKt.lazy(a.a);
    }

    public final void K() {
        xh1.c.d("AnimPlayer.HardDecoder", "destroyInner");
        Handler handlerA = m().a();
        if (handlerA != null) {
            handlerA.post(new b());
        }
    }

    public final MediaCodec.BufferInfo L() {
        Lazy lazy = this.o;
        KProperty kProperty = w[0];
        return (MediaCodec.BufferInfo) lazy.getValue();
    }

    public final void M(MediaCodec mediaCodec, MediaExtractor mediaExtractor) {
        Handler handlerA = m().a();
        if (handlerA != null) {
            handlerA.post(new c(mediaCodec, mediaExtractor));
        }
    }

    public final void N() {
        Handler handlerA = m().a();
        if (handlerA != null) {
            handlerA.post(new d());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void O(android.media.MediaExtractor r21, android.media.MediaCodec r22) throws android.media.MediaCodec.CryptoException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.vg1.O(android.media.MediaExtractor, android.media.MediaCodec):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v27, types: [T, android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r12v5, types: [T, android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r12v9, types: [T, android.media.MediaFormat] */
    public final void P(ch1 ch1Var) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        try {
            ci1 ci1Var = ci1.c;
            ?? C = ci1Var.c(ch1Var);
            objectRef.element = C;
            int iF = ci1Var.f((MediaExtractor) C);
            if (iF < 0) {
                throw new RuntimeException("No video track found");
            }
            ((MediaExtractor) objectRef.element).selectTrack(iF);
            ?? trackFormat = ((MediaExtractor) objectRef.element).getTrackFormat(iF);
            objectRef3.element = trackFormat;
            if (((MediaFormat) trackFormat) == null) {
                throw new RuntimeException("format is null");
            }
            if (ci1Var.a((MediaFormat) trackFormat)) {
                int i = Build.VERSION.SDK_INT;
                if (i < 21 || !ci1Var.b(MimeTypes.VIDEO_H265)) {
                    c(RtmConstants.RTM_ERR_ALREADY_JOIN_CHANNEL, "0x8 hevc not support sdk:" + i + ",support hevc:" + ci1Var.b(MimeTypes.VIDEO_H265));
                    M(null, null);
                    return;
                }
            }
            this.q = ((MediaFormat) objectRef3.element).getInteger(VideoCaptureFormat.keyWidth);
            int integer = ((MediaFormat) objectRef3.element).getInteger(VideoCaptureFormat.keyHeight);
            this.r = integer;
            this.s = this.q;
            this.t = integer;
            xh1 xh1Var = xh1.c;
            xh1Var.d("AnimPlayer.HardDecoder", "Video size is " + this.q + " x " + this.r);
            boolean z = this.q % 16 != 0 && k().g();
            this.u = z;
            try {
                if (!s(z)) {
                    throw new RuntimeException("render create fail");
                }
                r(this.q, this.r);
                xg1 xg1VarL = l();
                if (xg1VarL != null) {
                    SurfaceTexture surfaceTexture = new SurfaceTexture(xg1VarL.e());
                    surfaceTexture.setOnFrameAvailableListener(this);
                    surfaceTexture.setDefaultBufferSize(this.q, this.r);
                    this.n = surfaceTexture;
                    xg1VarL.h();
                }
                try {
                    String string = ((MediaFormat) objectRef3.element).getString("mime");
                    if (string == null) {
                        string = "";
                    }
                    xh1Var.d("AnimPlayer.HardDecoder", "Video MIME is " + string);
                    ?? CreateDecoderByType = MediaCodec.createDecoderByType(string);
                    if (this.u) {
                        ((MediaFormat) objectRef3.element).setInteger("color-format", 19);
                        CreateDecoderByType.configure((MediaFormat) objectRef3.element, null, null, 0);
                    } else {
                        Surface surface = new Surface(this.n);
                        this.m = surface;
                        CreateDecoderByType.configure((MediaFormat) objectRef3.element, surface, null, 0);
                    }
                    CreateDecoderByType.start();
                    Handler handlerA = i().a();
                    if (handlerA != null) {
                        handlerA.post(new f(CreateDecoderByType, this, objectRef3, objectRef, objectRef2));
                    }
                    objectRef2.element = CreateDecoderByType;
                } catch (Throwable th) {
                    xh1.c.c("AnimPlayer.HardDecoder", "MediaCodec configure exception e=" + th, th);
                    c(RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION, "0x2 MediaCodec exception e=" + th);
                    M((MediaCodec) objectRef2.element, (MediaExtractor) objectRef.element);
                }
            } catch (Throwable th2) {
                c(RtmConstants.RTM_ERR_PUBLISH_TOPIC_MESSAGE_FAILED, "0x4 render create fail e=" + th2);
                M(null, null);
            }
        } catch (Throwable th3) {
            xh1.c.c("AnimPlayer.HardDecoder", "MediaExtractor exception e=" + th3, th3);
            c(10001, "0x1 MediaExtractor exception e=" + th3);
            M((MediaCodec) objectRef2.element, (MediaExtractor) objectRef.element);
        }
    }

    public final byte[] Q(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = this.s;
        int i2 = this.t;
        int i3 = i * i2;
        System.arraycopy(bArr, 0, bArr2, 0, i * i2);
        int i4 = i3;
        int i5 = i4;
        while (i4 < (i3 * 3) / 2) {
            bArr2[i5] = bArr[i4];
            bArr2[(i3 / 4) + i5] = bArr[i4 + 1];
            i4 += 2;
            i5++;
        }
        return bArr2;
    }

    public final void R(byte[] bArr, int i, int i2, int i3, byte[] bArr2, int i4, int i5) {
        for (int i6 = 0; i6 < i3; i6++) {
            if (i6 < i5) {
                System.arraycopy(bArr, (i6 * i2) + i, bArr2, i6 * i4, i4);
            }
        }
    }

    public final void S(MediaCodec mediaCodec, int i) {
        ByteBuffer byteBuffer = mediaCodec.getOutputBuffers()[i];
        if (byteBuffer != null) {
            byteBuffer.position(0);
            byteBuffer.limit(L().offset + L().size);
            int iRemaining = byteBuffer.remaining();
            byte[] bArrQ = new byte[iRemaining];
            byteBuffer.get(bArrQ);
            if (true ^ (iRemaining == 0)) {
                int i2 = this.q;
                int i3 = this.r;
                byte[] bArr = new byte[i2 * i3];
                byte[] bArr2 = new byte[(i2 * i3) / 4];
                byte[] bArr3 = new byte[(i2 * i3) / 4];
                MediaFormat mediaFormat = this.v;
                if (mediaFormat != null && mediaFormat.getInteger("color-format") == 21) {
                    bArrQ = Q(bArrQ);
                }
                R(bArrQ, 0, this.s, this.t, bArr, this.q, this.r);
                int i4 = this.s;
                int i5 = this.t;
                R(bArrQ, i4 * i5, i4 / 2, i5 / 2, bArr2, this.q / 2, this.r / 2);
                int i6 = this.s;
                int i7 = this.t;
                R(bArrQ, ((i6 * i7) * 5) / 4, i6 / 2, i7 / 2, bArr3, this.q / 2, this.r / 2);
                xg1 xg1VarL = l();
                if (xg1VarL != null) {
                    xg1VarL.b(this.q, this.r, bArr, bArr2, bArr3);
                }
                N();
            }
        }
    }

    @Override // dc.sg1
    public void g() {
        if (!o()) {
            K();
        } else {
            this.p = true;
            A();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(@Nullable SurfaceTexture surfaceTexture) {
        if (p()) {
            return;
        }
        xh1.c.a("AnimPlayer.HardDecoder", "onFrameAvailable");
        N();
    }

    @Override // dc.sg1
    public void z(@NotNull ch1 fileContainer) {
        Intrinsics.checkParameterIsNotNull(fileContainer, "fileContainer");
        y(false);
        this.p = false;
        x(true);
        Handler handlerA = m().a();
        if (handlerA != null) {
            handlerA.post(new e(fileContainer));
        }
    }
}
