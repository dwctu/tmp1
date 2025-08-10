package org.vosk.android;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import org.vosk.Recognizer;

/* loaded from: classes5.dex */
public class SpeechService {
    private static final float BUFFER_SIZE_SECONDS = 0.2f;
    private final int bufferSize;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Recognizer recognizer;
    private RecognizerThread recognizerThread;
    private final AudioRecord recorder;
    private final int sampleRate;

    @SuppressLint({"MissingPermission"})
    public SpeechService(Recognizer recognizer, float f) throws IOException {
        this.recognizer = recognizer;
        int i = (int) f;
        this.sampleRate = i;
        int iRound = Math.round(i * BUFFER_SIZE_SECONDS);
        this.bufferSize = iRound;
        AudioRecord audioRecord = new AudioRecord(6, i, 16, 2, iRound * 2);
        this.recorder = audioRecord;
        if (audioRecord.getState() != 0) {
            return;
        }
        audioRecord.release();
        throw new IOException("Failed to initialize recorder. Microphone might be already in use.");
    }

    private boolean stopRecognizerThread() throws InterruptedException {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread == null) {
            return false;
        }
        try {
            recognizerThread.interrupt();
            this.recognizerThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.recognizerThread = null;
        return true;
    }

    public boolean cancel() {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread != null) {
            recognizerThread.setPause(true);
        }
        return stopRecognizerThread();
    }

    public void reset() {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread != null) {
            recognizerThread.reset();
        }
    }

    public void setPause(boolean z) {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread != null) {
            recognizerThread.setPause(z);
        }
    }

    public void shutdown() {
        this.recorder.release();
    }

    public boolean startListening(RecognitionListener recognitionListener) {
        if (this.recognizerThread != null) {
            return false;
        }
        RecognizerThread recognizerThread = new RecognizerThread(this, recognitionListener);
        this.recognizerThread = recognizerThread;
        recognizerThread.start();
        return true;
    }

    public boolean stop() {
        return stopRecognizerThread();
    }

    public boolean startListening(RecognitionListener recognitionListener, int i) {
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
        private volatile boolean paused;
        private int remainingSamples;
        private volatile boolean reset;
        private final int timeoutSamples;

        public RecognizerThread(RecognitionListener recognitionListener, int i) {
            this.paused = false;
            this.reset = false;
            this.listener = recognitionListener;
            if (i != -1) {
                this.timeoutSamples = (i * SpeechService.this.sampleRate) / 1000;
            } else {
                this.timeoutSamples = -1;
            }
            this.remainingSamples = this.timeoutSamples;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(IOException iOException) {
            this.listener.onError(iOException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(String str) {
            this.listener.onResult(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(String str) {
            this.listener.onPartialResult(str);
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

        public void reset() {
            this.reset = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException {
            SpeechService.this.recorder.startRecording();
            if (SpeechService.this.recorder.getRecordingState() == 1) {
                SpeechService.this.recorder.stop();
                final IOException iOException = new IOException("Failed to start recording. Microphone might be already in use.");
                SpeechService.this.mainHandler.post(new Runnable() { // from class: dc.pe4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(iOException);
                    }
                });
            }
            int i = SpeechService.this.bufferSize;
            short[] sArr = new short[i];
            while (!Thread.interrupted() && (this.timeoutSamples == -1 || this.remainingSamples > 0)) {
                int i2 = SpeechService.this.recorder.read(sArr, 0, i);
                if (!this.paused) {
                    if (this.reset) {
                        SpeechService.this.recognizer.reset();
                        this.reset = false;
                    }
                    if (i2 < 0) {
                        throw new RuntimeException("error reading audio buffer");
                    }
                    if (SpeechService.this.recognizer.acceptWaveForm(sArr, i2)) {
                        final String result = SpeechService.this.recognizer.getResult();
                        SpeechService.this.mainHandler.post(new Runnable() { // from class: dc.re4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d(result);
                            }
                        });
                    } else {
                        final String partialResult = SpeechService.this.recognizer.getPartialResult();
                        SpeechService.this.mainHandler.post(new Runnable() { // from class: dc.se4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.f(partialResult);
                            }
                        });
                    }
                    if (this.timeoutSamples != -1) {
                        this.remainingSamples -= i2;
                    }
                }
            }
            SpeechService.this.recorder.stop();
            if (this.paused) {
                return;
            }
            if (this.timeoutSamples != -1 && this.remainingSamples <= 0) {
                SpeechService.this.mainHandler.post(new Runnable() { // from class: dc.oe4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h();
                    }
                });
            } else {
                final String finalResult = SpeechService.this.recognizer.getFinalResult();
                SpeechService.this.mainHandler.post(new Runnable() { // from class: dc.qe4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(finalResult);
                    }
                });
            }
        }

        public void setPause(boolean z) {
            this.paused = z;
        }

        public RecognizerThread(SpeechService speechService, RecognitionListener recognitionListener) {
            this(recognitionListener, -1);
        }
    }
}
