package com.broadcom.bt.util.mime4j.field.contenttype.parser;

/* loaded from: classes.dex */
public class Token {
    public int beginColumn;
    public int beginLine;
    public int endColumn;
    public int endLine;
    public String image;
    public int kind;
    public Token next;
    public Token specialToken;

    public static final Token newToken(int i) {
        return new Token();
    }

    public String toString() {
        return this.image;
    }
}
