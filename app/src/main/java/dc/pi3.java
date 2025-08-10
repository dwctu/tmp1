package dc;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* compiled from: VideoEncoderCore.java */
/* loaded from: classes4.dex */
public class pi3 {
    public AudioRecord b;
    public MediaCodec c;
    public int i;
    public int j;
    public Thread k;
    public a l;
    public Surface m;
    public MediaMuxer n;
    public MediaCodec o;
    public MediaCodec.BufferInfo p;
    public int q;
    public boolean r;
    public String a = MimeTypes.AUDIO_AAC;
    public int d = 128000;
    public int e = OpusUtil.SAMPLE_RATE;
    public int f = 2;
    public int g = 12;
    public int h = 2;
    public Object s = new Object();

    /* compiled from: VideoEncoderCore.java */
    public class a implements Runnable {
        public b a;
        public long e;
        public long f;
        public boolean i;
        public boolean b = true;
        public boolean c = false;
        public long d = -1;
        public boolean g = false;
        public Object h = new Object();

        public a() {
        }

        public final boolean a() throws MediaCodec.CryptoException, IOException {
            int iDequeueOutputBuffer;
            int iDequeueInputBuffer = pi3.this.c.dequeueInputBuffer(0L);
            if (iDequeueInputBuffer >= 0) {
                ByteBuffer byteBufferC = c(pi3.this.c, iDequeueInputBuffer);
                byteBufferC.clear();
                int i = pi3.this.b.read(byteBufferC, pi3.this.i);
                if (i > 0) {
                    if (this.d != -1) {
                        pi3.this.c.queueInputBuffer(iDequeueInputBuffer, 0, i, ((System.nanoTime() - this.d) - this.e) / 1000, this.b ? 0 : 4);
                    } else {
                        pi3.this.c.queueInputBuffer(iDequeueInputBuffer, 0, i, 0L, this.b ? 0 : 4);
                    }
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            do {
                iDequeueOutputBuffer = pi3.this.c.dequeueOutputBuffer(bufferInfo, 0L);
                if (iDequeueOutputBuffer >= 0) {
                    if ((bufferInfo.flags & 4) != 0) {
                        pi3.this.c.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        return true;
                    }
                    ByteBuffer byteBufferD = d(pi3.this.c, iDequeueOutputBuffer);
                    byteBufferD.position(bufferInfo.offset);
                    if (pi3.this.r && bufferInfo.presentationTimeUs > 0) {
                        try {
                            pi3.this.n.writeSampleData(pi3.this.j, byteBufferD, bufferInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    pi3.this.c.releaseOutputBuffer(iDequeueOutputBuffer, false);
                } else if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer == -2) {
                    synchronized (pi3.this.s) {
                        pi3 pi3Var = pi3.this;
                        pi3Var.j = pi3Var.n.addTrack(pi3.this.c.getOutputFormat());
                        String str = "add audio track-->" + pi3.this.j;
                        if (pi3.this.j >= 0 && pi3.this.q >= 0) {
                            pi3.this.n.start();
                            pi3.this.r = true;
                        }
                    }
                }
            } while (iDequeueOutputBuffer >= 0);
            return false;
        }

        public final void b() throws IOException {
            while (!a()) {
            }
        }

        public final ByteBuffer c(MediaCodec mediaCodec, int i) {
            return Build.VERSION.SDK_INT >= 21 ? mediaCodec.getInputBuffer(i) : mediaCodec.getInputBuffers()[i];
        }

        public final ByteBuffer d(MediaCodec mediaCodec, int i) {
            return Build.VERSION.SDK_INT >= 21 ? mediaCodec.getOutputBuffer(i) : mediaCodec.getOutputBuffers()[i];
        }

        public void e() {
            this.g = true;
            this.f = System.nanoTime();
        }

        public void f() {
            long jNanoTime = System.nanoTime() - this.f;
            this.f = jNanoTime;
            this.e += jNanoTime;
            this.g = false;
        }

        public void g() throws MediaCodec.CryptoException {
            try {
                if (!this.c) {
                    if (this.g) {
                        if (this.b) {
                            this.a.sendEmptyMessage(2);
                        } else {
                            b();
                            this.a.sendEmptyMessage(3);
                        }
                    } else if (this.b) {
                        a();
                        this.a.sendEmptyMessage(2);
                    } else {
                        b();
                        this.a.sendEmptyMessage(3);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void h() {
            this.d = System.nanoTime();
            this.a.sendEmptyMessage(2);
        }

        public void i() {
            this.b = false;
        }

        public void j() {
            this.a.sendEmptyMessage(4);
        }

        public void k() {
            this.a.sendEmptyMessage(5);
        }

        public void l() {
            synchronized (this.h) {
                if (this.i) {
                    this.a.sendEmptyMessage(0);
                } else {
                    try {
                        this.h.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.a.sendEmptyMessage(0);
                }
            }
        }

        public void m() {
            this.a.sendEmptyMessage(1);
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.a = new b(this);
            synchronized (this.h) {
                this.i = true;
                this.h.notify();
            }
            Looper.loop();
            synchronized (this.h) {
                this.i = false;
                this.a = null;
            }
        }
    }

    /* compiled from: VideoEncoderCore.java */
    public static class b extends Handler {
        public WeakReference<a> a;

        public b(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws MediaCodec.CryptoException {
            int i = message.what;
            a aVar = this.a.get();
            if (aVar == null) {
                return;
            }
            if (i == 0) {
                aVar.h();
                return;
            }
            if (i == 1) {
                aVar.i();
                return;
            }
            if (i == 2) {
                aVar.g();
                return;
            }
            if (i == 3) {
                Looper.myLooper().quit();
            } else if (i == 4) {
                aVar.e();
            } else {
                if (i != 5) {
                    return;
                }
                aVar.f();
            }
        }
    }

    public pi3(int i, int i2, int i3, String str) throws IllegalStateException, IOException {
        try {
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(this.a, this.e, this.f);
            mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
            mediaFormatCreateAudioFormat.setInteger("bitrate", this.d);
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(this.a);
            this.c = mediaCodecCreateEncoderByType;
            mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.i = AudioRecord.getMinBufferSize(this.e, this.g, this.h);
            this.b = new AudioRecord(1, this.e, this.g, this.h, this.i);
            this.c.start();
            this.b.startRecording();
            this.p = new MediaCodec.BufferInfo();
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, i, i2);
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            mediaFormatCreateVideoFormat.setInteger("bitrate", i3);
            mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
            mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
            MediaCodec mediaCodecCreateEncoderByType2 = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);
            this.o = mediaCodecCreateEncoderByType2;
            mediaCodecCreateEncoderByType2.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.m = this.o.createInputSurface();
            this.o.start();
            this.n = new MediaMuxer(str, 0);
            this.q = -1;
            this.j = -1;
            this.r = false;
            this.l = new a();
            Thread thread = new Thread(this.l);
            this.k = thread;
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        throw new java.lang.RuntimeException("format changed twice");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void k(boolean r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L7
            android.media.MediaCodec r0 = r7.o
            r0.signalEndOfInputStream()
        L7:
            android.media.MediaCodec r0 = r7.o
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
        Ld:
            android.media.MediaCodec r1 = r7.o
            android.media.MediaCodec$BufferInfo r2 = r7.p
            r3 = 10000(0x2710, double:4.9407E-320)
            int r1 = r1.dequeueOutputBuffer(r2, r3)
            r2 = -1
            if (r1 != r2) goto L1e
            if (r8 != 0) goto Ld
            goto La9
        L1e:
            r2 = -3
            if (r1 != r2) goto L28
            android.media.MediaCodec r0 = r7.o
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            goto Ld
        L28:
            r2 = -2
            if (r1 != r2) goto L6b
            java.lang.Object r2 = r7.s
            monitor-enter(r2)
            boolean r1 = r7.r     // Catch: java.lang.Throwable -> L68
            if (r1 != 0) goto L60
            android.media.MediaCodec r1 = r7.o     // Catch: java.lang.Throwable -> L68
            android.media.MediaFormat r1 = r1.getOutputFormat()     // Catch: java.lang.Throwable -> L68
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r3.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r4 = "encoder output format changed: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L68
            r3.append(r1)     // Catch: java.lang.Throwable -> L68
            r3.toString()     // Catch: java.lang.Throwable -> L68
            android.media.MediaMuxer r3 = r7.n     // Catch: java.lang.Throwable -> L68
            int r1 = r3.addTrack(r1)     // Catch: java.lang.Throwable -> L68
            r7.q = r1     // Catch: java.lang.Throwable -> L68
            if (r1 < 0) goto L5e
            int r1 = r7.j     // Catch: java.lang.Throwable -> L68
            if (r1 < 0) goto L5e
            android.media.MediaMuxer r1 = r7.n     // Catch: java.lang.Throwable -> L68
            r1.start()     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r7.r = r1     // Catch: java.lang.Throwable -> L68
        L5e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L68
            goto Ld
        L60:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L68
            java.lang.String r0 = "format changed twice"
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L68
            throw r8     // Catch: java.lang.Throwable -> L68
        L68:
            r8 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L68
            throw r8
        L6b:
            if (r1 >= 0) goto L7e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "unexpected result from encoder.dequeueOutputBuffer: "
            r2.append(r3)
            r2.append(r1)
            r2.toString()
            goto Ld
        L7e:
            r2 = r0[r1]
            if (r2 == 0) goto Laa
            android.media.MediaCodec$BufferInfo r3 = r7.p
            int r4 = r3.flags
            r4 = r4 & 2
            r5 = 0
            if (r4 == 0) goto L8d
            r3.size = r5
        L8d:
            int r4 = r3.size
            if (r4 == 0) goto L9c
            boolean r4 = r7.r
            if (r4 == 0) goto L9c
            android.media.MediaMuxer r4 = r7.n
            int r6 = r7.q
            r4.writeSampleData(r6, r2, r3)
        L9c:
            android.media.MediaCodec r2 = r7.o
            r2.releaseOutputBuffer(r1, r5)
            android.media.MediaCodec$BufferInfo r1 = r7.p
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto Ld
        La9:
            return
        Laa:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "encoderOutputBuffer "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = " was null"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.pi3.k(boolean):void");
    }

    public Surface l() {
        return this.m;
    }

    public void m() {
        this.l.j();
    }

    public void n() throws IllegalStateException {
        MediaCodec mediaCodec = this.o;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.o.release();
            this.o = null;
        }
        MediaCodec mediaCodec2 = this.c;
        if (mediaCodec2 != null) {
            mediaCodec2.stop();
            this.c.release();
            this.c = null;
        }
        AudioRecord audioRecord = this.b;
        if (audioRecord != null) {
            audioRecord.stop();
            this.b.release();
            this.b = null;
        }
        MediaMuxer mediaMuxer = this.n;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                this.n.release();
                this.n = null;
            } catch (IllegalStateException unused) {
                this.n = null;
            }
        }
    }

    public void o() {
        this.l.k();
    }

    public void p() {
        this.l.l();
    }

    public void q() throws InterruptedException {
        this.l.m();
        Thread thread = this.k;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
