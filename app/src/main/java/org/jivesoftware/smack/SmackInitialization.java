package org.jivesoftware.smack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.compression.Java7ZlibInputOutputStream;
import org.jivesoftware.smack.initializer.SmackInitializer;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.provider.BindIQProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.sasl.core.SASLXOauth2Mechanism;
import org.jivesoftware.smack.sasl.core.SCRAMSHA1Mechanism;
import org.jivesoftware.smack.util.FileUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public final class SmackInitialization {
    private static final String DEFAULT_CONFIG_FILE = "classpath:assets/org.jivesoftware.smack/smack-config.xml";
    private static final Logger LOGGER = Logger.getLogger(SmackInitialization.class.getName());
    public static final String SMACK_VERSION;

    static {
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FileUtils.getStreamForUrl("classpath:assets/org.jivesoftware.smack/version", null)));
            line = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "IOException closing stream", (Throwable) e);
            }
        } catch (Exception e2) {
            LOGGER.log(Level.SEVERE, "Could not determine Smack version", (Throwable) e2);
            line = "unkown";
        }
        SMACK_VERSION = line;
        String property = System.getProperty("smack.disabledClasses");
        if (property != null) {
            for (String str : property.split(",")) {
                SmackConfiguration.disabledSmackClasses.add(str);
            }
        }
        try {
            FileUtils.addLines("classpath:org.jivesoftware.smack/disabledClasses", SmackConfiguration.disabledSmackClasses);
            try {
                String[] strArr = (String[]) Class.forName("org.jivesoftware.smack.CustomSmackConfiguration").getField("DISABLED_SMACK_CLASSES").get(null);
                if (strArr != null) {
                    LOGGER.warning("Using CustomSmackConfig is deprecated and will be removed in a future release");
                    for (String str2 : strArr) {
                        SmackConfiguration.disabledSmackClasses.add(str2);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            }
            try {
                try {
                    processConfigFile(FileUtils.getStreamForUrl(DEFAULT_CONFIG_FILE, null), null);
                    SmackConfiguration.compressionHandlers.add(new Java7ZlibInputOutputStream());
                    try {
                        if (Boolean.getBoolean("smack.debugEnabled")) {
                            SmackConfiguration.DEBUG = true;
                        }
                    } catch (Exception unused2) {
                    }
                    SASLAuthentication.registerSASLMechanism(new SCRAMSHA1Mechanism());
                    SASLAuthentication.registerSASLMechanism(new SASLXOauth2Mechanism());
                    ProviderManager.addIQProvider(Bind.ELEMENT, Bind.NAMESPACE, new BindIQProvider());
                    SmackConfiguration.smackInitialized = true;
                } catch (Exception e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (Exception e4) {
                throw new IllegalStateException(e4);
            }
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static void loadSmackClass(String str, boolean z, ClassLoader classLoader) throws Exception {
        try {
            Class<?> cls = Class.forName(str, true, classLoader);
            if (!SmackInitializer.class.isAssignableFrom(cls)) {
                LOGGER.log(Level.FINE, "Loaded " + str);
                return;
            }
            List<Exception> listInitialize = ((SmackInitializer) cls.newInstance()).initialize();
            if (listInitialize != null && listInitialize.size() != 0) {
                Iterator<Exception> it = listInitialize.iterator();
                while (it.hasNext()) {
                    LOGGER.log(Level.SEVERE, "Exception in loadSmackClass", (Throwable) it.next());
                }
            } else {
                LOGGER.log(Level.FINE, "Loaded SmackInitializer " + str);
            }
        } catch (ClassNotFoundException e) {
            Level level = z ? Level.FINE : Level.WARNING;
            LOGGER.log(level, "A startup class '" + str + "' could not be loaded.");
            if (!z) {
                throw e;
            }
        }
    }

    private static void parseClassesToLoad(XmlPullParser xmlPullParser, boolean z, Collection<Exception> collection, ClassLoader classLoader) throws Exception {
        String name = xmlPullParser.getName();
        while (true) {
            int next = xmlPullParser.next();
            String name2 = xmlPullParser.getName();
            if (next == 2 && "className".equals(name2)) {
                String strNextText = xmlPullParser.nextText();
                if (!SmackConfiguration.isDisabledSmackClass(strNextText)) {
                    try {
                        loadSmackClass(strNextText, z, classLoader);
                    } catch (Exception e) {
                        if (collection == null) {
                            throw e;
                        }
                        collection.add(e);
                    }
                }
            }
            if (next == 3 && name.equals(name2)) {
                return;
            }
        }
    }

    public static void processConfigFile(InputStream inputStream, Collection<Exception> collection) throws Exception {
        processConfigFile(inputStream, collection, SmackInitialization.class.getClassLoader());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        org.jivesoftware.smack.SmackInitialization.LOGGER.log(java.util.logging.Level.SEVERE, "Error while closing config file input stream", (java.lang.Throwable) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void processConfigFile(java.io.InputStream r4, java.util.Collection<java.lang.Exception> r5, java.lang.ClassLoader r6) throws java.lang.Exception {
        /*
            org.xmlpull.v1.XmlPullParserFactory r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance()
            org.xmlpull.v1.XmlPullParser r0 = r0.newPullParser()
            java.lang.String r1 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r2 = 1
            r0.setFeature(r1, r2)
            java.lang.String r1 = "UTF-8"
            r0.setInput(r4, r1)
            int r1 = r0.getEventType()
        L17:
            r3 = 2
            if (r1 != r3) goto L3a
            java.lang.String r1 = r0.getName()
            java.lang.String r3 = "startupClasses"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L2b
            r1 = 0
            parseClassesToLoad(r0, r1, r5, r6)
            goto L3a
        L2b:
            java.lang.String r1 = r0.getName()
            java.lang.String r3 = "optionalStartupClasses"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L3a
            parseClassesToLoad(r0, r2, r5, r6)
        L3a:
            int r1 = r0.next()
            if (r1 != r2) goto L17
            r4.close()     // Catch: java.io.IOException -> L44
            goto L4e
        L44:
            r4 = move-exception
            java.util.logging.Logger r5 = org.jivesoftware.smack.SmackInitialization.LOGGER
            java.util.logging.Level r6 = java.util.logging.Level.SEVERE
            java.lang.String r0 = "Error while closing config file input stream"
            r5.log(r6, r0, r4)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.SmackInitialization.processConfigFile(java.io.InputStream, java.util.Collection, java.lang.ClassLoader):void");
    }
}
