package org.vosk.android;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;
import org.vosk.Recognizer;

/* loaded from: classes5.dex */
public class SpeechStreamService {
    private static final float BUFFER_SIZE_SECONDS = 0.2f;
    private final int bufferSize;
    private final InputStream inputStream;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Recognizer recognizer;
    private Thread recognizerThread;
    private final int sampleRate;

    public SpeechStreamService(Recognizer recognizer, InputStream inputStream, float f) {
        this.recognizer = recognizer;
        int i = (int) f;
        this.sampleRate = i;
        this.inputStream = inputStream;
        this.bufferSize = Math.round(i * BUFFER_SIZE_SECONDS * 2.0f);
    }

    public boolean start(RecognitionListener recognitionListener) {
        if (this.recognizerThread != null) {
            return false;
        }
        RecognizerThread recognizerThread = new RecognizerThread(this, recognitionListener);
        this.recognizerThread = recognizerThread;
        recognizerThread.start();
        return true;
    }

    public boolean stop() throws InterruptedException {
        Thread thread = this.recognizerThread;
        if (thread == null) {
            return false;
        }
        try {
            thread.interrupt();
            this.recognizerThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.recognizerThread = null;
        return true;
    }

    public boolean start(RecognitionListener recognitionListener, int i) {
        if (this.recognizerThread != null) {
            return false;
        }
        RecognizerThread recognizerThread = new RecognizerThread(recognitionListener, i);
        this.recognizerThread = recognizerThread;
        recognizerThread.start();
        return true;
    }

    public final class RecognizerThread extends Thread {
        private static final int NO_TIMEOUT = -1;
        public RecognitionListener listener;
        private int remainingSamples;
        private final int timeoutSamples;

        public RecognizerThread(RecognitionListener recognitionListener, int i) {
            this.listener = recognitionListener;
            if (i != -1) {
                this.timeoutSamples = (i * SpeechStreamService.this.sampleRate) / 1000;
            } else {
                this.timeoutSamples = -1;
            }
            this.remainingSamples = this.timeoutSamples;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(String str) {
            this.listener.onResult(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(String str) {
            this.listener.onPartialResult(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(IOException iOException) {
            this.listener.onError(iOException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            this.listener.onTimeout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void j(String str) {
            this.listener.onFinalResult(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            int i;
            int i2 = SpeechStreamService.this.bufferSize;
            byte[] bArr = new byte[i2];
            while (!Thread.interrupted() && (this.timeoutSamples == -1 || this.remainingSamples > 0)) {
                try {
                    i = SpeechStreamService.this.inputStream.read(bArr, 0, i2);
                } catch (IOException e) {
                    SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: dc.ve4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.f(e);
                        }
                    });
                }
                if (i < 0) {
                    break;
                }
                if (SpeechStreamService.this.recognizer.acceptWaveForm(bArr, i)) {
                    final String result = SpeechStreamService.this.recognizer.getResult();
                    SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: dc.te4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.b(result);
                        }
                    });
                } else {
                    final String partialResult = SpeechStreamService.this.recognizer.getPartialResult();
                    SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: dc.we4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.d(partialResult);
                        }
                    });
                }
                if (this.timeoutSamples != -1) {
                    this.remainingSamples -= i;
                }
            }
            if (this.timeoutSamples != -1 && this.remainingSamples <= 0) {
                SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: dc.ue4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h();
                    }
                });
            } else {
                final String finalResult = SpeechStreamService.this.recognizer.getFinalResult();
                SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: dc.xe4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(finalResult);
                    }
                });
            }
        }

        public RecognizerThread(SpeechStreamService speechStreamService, RecognitionListener recognitionListener) {
            this(recognitionListener, -1);
        }
    }
}
