package com.hp.hpl.sparta;

/* loaded from: classes2.dex */
public class ParseException extends Exception {
    private Throwable cause_;
    private int lineNumber_;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }
}
