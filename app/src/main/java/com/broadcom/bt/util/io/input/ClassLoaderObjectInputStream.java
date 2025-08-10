package com.broadcom.bt.util.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* loaded from: classes.dex */
public class ClassLoaderObjectInputStream extends ObjectInputStream {
    private ClassLoader classLoader;

    public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream) throws IOException {
        super(inputStream);
        this.classLoader = classLoader;
    }

    @Override // java.io.ObjectInputStream
    public Class resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.classLoader);
        return cls != null ? cls : super.resolveClass(objectStreamClass);
    }
}
