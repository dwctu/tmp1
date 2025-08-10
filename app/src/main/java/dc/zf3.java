package dc;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AacUtil;
import com.wear.util.noisesuppressor.AutomaticGainControlUtils;
import com.wear.util.noisesuppressor.NoiseSuppressorUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.vosk.Recognizer;
import org.vosk.android.RecognitionListener;

/* compiled from: RemoteSpeechService.java */
/* loaded from: classes4.dex */
public class zf3 {
    public final Recognizer a;
    public final int b;
    public final int c;
    public final AudioRecord d;
    public final Handler e = new Handler(Looper.getMainLooper());
    public a f;

    @SuppressLint({"MissingPermission"})
    public zf3(Recognizer recognizer, float f) throws IOException {
        this.a = recognizer;
        int i = (int) f;
        this.b = i;
        int iRound = Math.round(i * 0.2f);
        this.c = iRound;
        AudioRecord.getMinBufferSize(i, 16, 2);
        AudioRecord audioRecord = new AudioRecord(6, i, 16, 2, iRound);
        this.d = audioRecord;
        if (audioRecord.getState() != 0) {
            return;
        }
        audioRecord.release();
        throw new IOException("Failed to initialize recorder. Microphone might be already in use.");
    }

    public void f() {
        this.d.release();
    }

    public boolean g(RecognitionListener recognitionListener) {
        if (this.f != null) {
            return false;
        }
        a aVar = new a(this, recognitionListener);
        this.f = aVar;
        aVar.start();
        return true;
    }

    public boolean h() {
        return i();
    }

    public final boolean i() throws InterruptedException {
        a aVar = this.f;
        if (aVar == null) {
            return false;
        }
        try {
            aVar.interrupt();
            this.f.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.f = null;
        return true;
    }

    /* compiled from: RemoteSpeechService.java */
    public final class a extends Thread {
        public final int a;
        public RecognitionListener b;
        public int c;
        public volatile boolean d;
        public volatile boolean e;

        public a(RecognitionListener recognitionListener, int i) {
            this.d = false;
            this.e = false;
            this.b = recognitionListener;
            if (i != -1) {
                this.a = (i * zf3.this.b) / 1000;
            } else {
                this.a = -1;
            }
            this.c = this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(IOException iOException) {
            this.b.onError(iOException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(String str) {
            this.b.onResult(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(String str) {
            this.b.onPartialResult(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            this.b.onTimeout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void j(String str) {
            this.b.onFinalResult(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException {
            int i;
            byte[] bArr;
            AutomaticGainControlUtils automaticGainControlUtils;
            short[] sArr;
            int i2;
            int i3;
            int i4;
            long j;
            NoiseSuppressorUtils noiseSuppressorUtils = new NoiseSuppressorUtils();
            long jNsxCreate = noiseSuppressorUtils.nsxCreate();
            noiseSuppressorUtils.nsxInit(jNsxCreate, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND);
            noiseSuppressorUtils.nsxSetPolicy(jNsxCreate, 2);
            AutomaticGainControlUtils automaticGainControlUtils2 = new AutomaticGainControlUtils();
            long jAgcCreate = automaticGainControlUtils2.agcCreate();
            automaticGainControlUtils2.agcInit(jAgcCreate, 0, 255, 3, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND);
            automaticGainControlUtils2.agcSetConfig(jAgcCreate, (short) 9, (short) 9, true);
            zf3.this.d.startRecording();
            if (zf3.this.d.getRecordingState() == 1) {
                zf3.this.d.stop();
                final IOException iOException = new IOException("Failed to start recording. Microphone might be already in use.");
                zf3.this.e.post(new Runnable() { // from class: dc.wc3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(iOException);
                    }
                });
            }
            int i5 = zf3.this.c;
            byte[] bArr2 = new byte[i5];
            while (!Thread.interrupted() && (this.a == -1 || this.c > 0)) {
                int i6 = zf3.this.d.read(bArr2, 0, i5);
                if (!this.d) {
                    if (this.e) {
                        zf3.this.a.reset();
                        this.e = false;
                    }
                    if (i6 < 0) {
                        throw new RuntimeException("error reading audio buffer");
                    }
                    int i7 = 320;
                    byte[] bArr3 = bArr2;
                    int iCeil = (int) Math.ceil(i5 / 320);
                    int i8 = iCeil * 160;
                    short[] sArr2 = new short[i8];
                    int i9 = 0;
                    while (i9 < iCeil) {
                        int i10 = i9 * 320;
                        long j2 = jAgcCreate;
                        byte[] bArr4 = bArr3;
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, i10, Math.min(i10 + 320, i5));
                        if (bArrCopyOfRange.length == i7) {
                            short[] sArr3 = new short[160];
                            short[] sArr4 = new short[160];
                            int i11 = i5;
                            short[] sArr5 = new short[160];
                            ByteBuffer.wrap(bArrCopyOfRange).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr3);
                            j = j2;
                            automaticGainControlUtils = automaticGainControlUtils2;
                            noiseSuppressorUtils.nsxProcess(jNsxCreate, sArr3, 1, sArr4);
                            sArr = sArr2;
                            i2 = i8;
                            i3 = iCeil;
                            bArr = bArr4;
                            i4 = i11;
                            automaticGainControlUtils.agcProcess(j, sArr4, 1, 160, sArr5, 0, 0, 0, false);
                            i = i9;
                            System.arraycopy(sArr5, 0, sArr, i * 160, 160);
                        } else {
                            i = i9;
                            bArr = bArr4;
                            automaticGainControlUtils = automaticGainControlUtils2;
                            sArr = sArr2;
                            i2 = i8;
                            i3 = iCeil;
                            i4 = i5;
                            j = j2;
                        }
                        i9 = i + 1;
                        i5 = i4;
                        sArr2 = sArr;
                        automaticGainControlUtils2 = automaticGainControlUtils;
                        bArr3 = bArr;
                        jAgcCreate = j;
                        i8 = i2;
                        iCeil = i3;
                        i7 = 320;
                    }
                    long j3 = jAgcCreate;
                    AutomaticGainControlUtils automaticGainControlUtils3 = automaticGainControlUtils2;
                    int i12 = i5;
                    byte[] bArr5 = bArr3;
                    if (zf3.this.a.acceptWaveForm(sArr2, i8)) {
                        final String result = zf3.this.a.getResult();
                        zf3.this.e.post(new Runnable() { // from class: dc.yc3
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d(result);
                            }
                        });
                    } else {
                        final String partialResult = zf3.this.a.getPartialResult();
                        zf3.this.e.post(new Runnable() { // from class: dc.zc3
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.f(partialResult);
                            }
                        });
                    }
                    if (this.a != -1) {
                        this.c -= i6;
                    }
                    i5 = i12;
                    automaticGainControlUtils2 = automaticGainControlUtils3;
                    bArr2 = bArr5;
                    jAgcCreate = j3;
                }
            }
            zf3.this.d.stop();
            noiseSuppressorUtils.nsxFree(jNsxCreate);
            automaticGainControlUtils2.agcFree(jAgcCreate);
            if (this.d) {
                return;
            }
            if (this.a != -1 && this.c <= 0) {
                zf3.this.e.post(new Runnable() { // from class: dc.xc3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h();
                    }
                });
            } else {
                final String finalResult = zf3.this.a.getFinalResult();
                zf3.this.e.post(new Runnable() { // from class: dc.vc3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(finalResult);
                    }
                });
            }
        }

        public a(zf3 zf3Var, RecognitionListener recognitionListener) {
            this(recognitionListener, -1);
        }
    }
}
