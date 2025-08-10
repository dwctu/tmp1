package org.jivesoftware.smack;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.debugger.ReflectionDebuggerFactory;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.debugger.SmackDebuggerFactory;
import org.jivesoftware.smack.parsing.ExceptionThrowingCallback;
import org.jivesoftware.smack.parsing.ParsingExceptionCallback;

/* loaded from: classes5.dex */
public final class SmackConfiguration {
    private static HostnameVerifier defaultHostnameVerififer = null;
    private static int defaultPacketReplyTimeout = 5000;
    private static int packetCollectorSize = 5000;
    private static List<String> defaultMechs = new ArrayList();
    public static Set<String> disabledSmackClasses = new HashSet();
    public static final List<XMPPInputOutputStream> compressionHandlers = new ArrayList(2);
    public static boolean smackInitialized = false;
    private static SmackDebuggerFactory debuggerFactory = new ReflectionDebuggerFactory();
    public static boolean DEBUG = false;
    private static ParsingExceptionCallback defaultCallback = new ExceptionThrowingCallback();

    public static void addCompressionHandler(XMPPInputOutputStream xMPPInputOutputStream) {
        compressionHandlers.add(xMPPInputOutputStream);
    }

    public static void addDisabledSmackClass(Class<?> cls) {
        addDisabledSmackClass(cls.getName());
    }

    public static void addSaslMech(String str) {
        if (defaultMechs.contains(str)) {
            return;
        }
        defaultMechs.add(str);
    }

    public static void addSaslMechs(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            addSaslMech(it.next());
        }
    }

    public static SmackDebugger createDebugger(XMPPConnection xMPPConnection, Writer writer, Reader reader) {
        SmackDebuggerFactory debuggerFactory2 = getDebuggerFactory();
        if (debuggerFactory2 == null) {
            return null;
        }
        return debuggerFactory2.create(xMPPConnection, writer, reader);
    }

    public static List<XMPPInputOutputStream> getCompresionHandlers() {
        List<XMPPInputOutputStream> list = compressionHandlers;
        ArrayList arrayList = new ArrayList(list.size());
        for (XMPPInputOutputStream xMPPInputOutputStream : list) {
            if (xMPPInputOutputStream.isSupported()) {
                arrayList.add(xMPPInputOutputStream);
            }
        }
        return arrayList;
    }

    public static SmackDebuggerFactory getDebuggerFactory() {
        return debuggerFactory;
    }

    public static HostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerififer;
    }

    public static int getDefaultPacketReplyTimeout() {
        if (defaultPacketReplyTimeout <= 0) {
            defaultPacketReplyTimeout = 5000;
        }
        return defaultPacketReplyTimeout;
    }

    public static ParsingExceptionCallback getDefaultParsingExceptionCallback() {
        return defaultCallback;
    }

    public static int getPacketCollectorSize() {
        return packetCollectorSize;
    }

    public static List<String> getSaslMechs() {
        return Collections.unmodifiableList(defaultMechs);
    }

    public static String getVersion() {
        return SmackInitialization.SMACK_VERSION;
    }

    public static boolean isDisabledSmackClass(String str) {
        for (String str2 : disabledSmackClasses) {
            if (str2.equals(str)) {
                return true;
            }
            int iLastIndexOf = str2.lastIndexOf(46);
            if (str2.length() > iLastIndexOf && !Character.isUpperCase(str2.charAt(iLastIndexOf + 1)) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSmackInitialized() {
        return smackInitialized;
    }

    public static void removeSaslMech(String str) {
        defaultMechs.remove(str);
    }

    public static void removeSaslMechs(Collection<String> collection) {
        defaultMechs.removeAll(collection);
    }

    public static void setDebuggerFactory(SmackDebuggerFactory smackDebuggerFactory) {
        debuggerFactory = smackDebuggerFactory;
    }

    public static void setDefaultHostnameVerifier(HostnameVerifier hostnameVerifier) {
        defaultHostnameVerififer = hostnameVerifier;
    }

    public static void setDefaultPacketReplyTimeout(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        defaultPacketReplyTimeout = i;
    }

    public static void setDefaultParsingExceptionCallback(ParsingExceptionCallback parsingExceptionCallback) {
        defaultCallback = parsingExceptionCallback;
    }

    public static void setPacketCollectorSize(int i) {
        packetCollectorSize = i;
    }

    public static void addDisabledSmackClass(String str) {
        disabledSmackClasses.add(str);
    }
}
