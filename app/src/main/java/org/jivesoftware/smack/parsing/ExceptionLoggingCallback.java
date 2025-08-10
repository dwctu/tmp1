package org.jivesoftware.smack.parsing;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class ExceptionLoggingCallback extends ParsingExceptionCallback {
    private static final Logger LOGGER = Logger.getLogger(ExceptionLoggingCallback.class.getName());

    @Override // org.jivesoftware.smack.parsing.ParsingExceptionCallback
    public void handleUnparsablePacket(UnparsablePacket unparsablePacket) throws Exception {
        Logger logger = LOGGER;
        logger.log(Level.SEVERE, "Smack message parsing exception: ", (Throwable) unparsablePacket.getParsingException());
        logger.severe("Unparsed content: " + ((Object) unparsablePacket.getContent()));
    }
}
