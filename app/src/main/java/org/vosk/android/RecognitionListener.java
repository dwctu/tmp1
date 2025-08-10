package org.vosk.android;

/* loaded from: classes5.dex */
public interface RecognitionListener {
    void onError(Exception exc);

    void onFinalResult(String str);

    void onPartialResult(String str);

    void onResult(String str);

    void onTimeout();
}
