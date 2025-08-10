package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class MethodParameterContext extends FunctionParameterContext {
    private Method method;

    public MethodParameterContext(Function function, Object[] objArr, int i, Method method) {
        super(function, objArr, i);
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }
}
