package org.jivesoftware.smack.parsing;

/* loaded from: classes5.dex */
public class UnparsablePacket {
    private final CharSequence content;
    private final Exception e;

    public UnparsablePacket(CharSequence charSequence, Exception exc) {
        this.content = charSequence;
        this.e = exc;
    }

    public CharSequence getContent() {
        return this.content;
    }

    public Exception getParsingException() {
        return this.e;
    }
}
