package org.jivesoftware.smack.parsing;

/* loaded from: classes5.dex */
public class ExceptionThrowingCallback extends ParsingExceptionCallback {
    @Override // org.jivesoftware.smack.parsing.ParsingExceptionCallback
    public void handleUnparsablePacket(UnparsablePacket unparsablePacket) throws Exception {
        throw unparsablePacket.getParsingException();
    }
}
