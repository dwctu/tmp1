package org.vosk;

import com.sun.jna.PointerType;
import java.io.IOException;

/* loaded from: classes5.dex */
public class SpeakerModel extends PointerType implements AutoCloseable {
    public SpeakerModel() {
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        LibVosk.vosk_spk_model_free(getPointer());
    }

    public SpeakerModel(String str) throws IOException {
        super(LibVosk.vosk_spk_model_new(str));
        if (getPointer() == null) {
            throw new IOException("Failed to create a speaker model");
        }
    }
}
