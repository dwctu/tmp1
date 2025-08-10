package org.vosk;

import com.sun.jna.PointerType;
import java.io.IOException;

/* loaded from: classes5.dex */
public class Model extends PointerType implements AutoCloseable {
    public Model() {
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        LibVosk.vosk_model_free(getPointer());
    }

    public Model(String str) throws IOException {
        super(LibVosk.vosk_model_new(str));
        if (getPointer() == null) {
            throw new IOException("Failed to create a model");
        }
    }
}
