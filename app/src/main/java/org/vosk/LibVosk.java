package org.vosk;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

/* loaded from: classes5.dex */
public class LibVosk {
    static {
        Native.register((Class<?>) LibVosk.class, "vosk");
    }

    public static void setLogLevel(LogLevel logLevel) {
        vosk_set_log_level(logLevel.getValue());
    }

    public static native void vosk_model_free(Pointer pointer);

    public static native Pointer vosk_model_new(String str);

    public static native boolean vosk_recognizer_accept_waveform(Pointer pointer, byte[] bArr, int i);

    public static native boolean vosk_recognizer_accept_waveform_f(Pointer pointer, float[] fArr, int i);

    public static native boolean vosk_recognizer_accept_waveform_s(Pointer pointer, short[] sArr, int i);

    public static native String vosk_recognizer_final_result(Pointer pointer);

    public static native void vosk_recognizer_free(Pointer pointer);

    public static native Pointer vosk_recognizer_new(Model model, float f);

    public static native Pointer vosk_recognizer_new_grm(Pointer pointer, float f, String str);

    public static native Pointer vosk_recognizer_new_spk(Pointer pointer, float f, Pointer pointer2);

    public static native String vosk_recognizer_partial_result(Pointer pointer);

    public static native void vosk_recognizer_reset(Pointer pointer);

    public static native String vosk_recognizer_result(Pointer pointer);

    public static native void vosk_recognizer_set_grm(Pointer pointer, String str);

    public static native void vosk_recognizer_set_max_alternatives(Pointer pointer, int i);

    public static native void vosk_recognizer_set_partial_words(Pointer pointer, boolean z);

    public static native void vosk_recognizer_set_spk_model(Pointer pointer, Pointer pointer2);

    public static native void vosk_recognizer_set_words(Pointer pointer, boolean z);

    public static native void vosk_set_log_level(int i);

    public static native void vosk_spk_model_free(Pointer pointer);

    public static native Pointer vosk_spk_model_new(String str);
}
