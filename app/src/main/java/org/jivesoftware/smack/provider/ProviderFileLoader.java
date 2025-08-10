package org.jivesoftware.smack.provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes5.dex */
public class ProviderFileLoader implements ProviderLoader {
    private static final Logger LOGGER = Logger.getLogger(ProviderFileLoader.class.getName());
    private List<Exception> exceptions;
    private final Collection<ExtensionProviderInfo> extProviders;
    private final Collection<IQProviderInfo> iqProviders;
    private final Collection<StreamFeatureProviderInfo> sfProviders;

    public ProviderFileLoader(InputStream inputStream) {
        this(inputStream, ProviderFileLoader.class.getClassLoader());
    }

    @Override // org.jivesoftware.smack.provider.ProviderLoader
    public Collection<ExtensionProviderInfo> getExtensionProviderInfo() {
        return this.extProviders;
    }

    @Override // org.jivesoftware.smack.provider.ProviderLoader
    public Collection<IQProviderInfo> getIQProviderInfo() {
        return this.iqProviders;
    }

    public List<Exception> getLoadingExceptions() {
        return Collections.unmodifiableList(this.exceptions);
    }

    @Override // org.jivesoftware.smack.provider.ProviderLoader
    public Collection<StreamFeatureProviderInfo> getStreamFeatureProviderInfo() {
        return this.sfProviders;
    }

    public ProviderFileLoader(InputStream inputStream, ClassLoader classLoader) throws IOException {
        this.iqProviders = new LinkedList();
        this.extProviders = new LinkedList();
        this.sfProviders = new LinkedList();
        this.exceptions = new LinkedList();
        try {
            try {
                XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                xmlPullParserNewPullParser.setInput(inputStream, "UTF-8");
                int eventType = xmlPullParserNewPullParser.getEventType();
                do {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        try {
                            if (!"smackProviders".equals(name)) {
                                xmlPullParserNewPullParser.next();
                                xmlPullParserNewPullParser.next();
                                String strNextText = xmlPullParserNewPullParser.nextText();
                                xmlPullParserNewPullParser.next();
                                xmlPullParserNewPullParser.next();
                                String strNextText2 = xmlPullParserNewPullParser.nextText();
                                xmlPullParserNewPullParser.next();
                                xmlPullParserNewPullParser.next();
                                String strNextText3 = xmlPullParserNewPullParser.nextText();
                                try {
                                    Class<?> clsLoadClass = classLoader.loadClass(strNextText3);
                                    char c = 65535;
                                    int iHashCode = name.hashCode();
                                    if (iHashCode != -797518000) {
                                        if (iHashCode != 80611175) {
                                            if (iHashCode == 1834143545 && name.equals("iqProvider")) {
                                                c = 0;
                                            }
                                        } else if (name.equals("streamFeatureProvider")) {
                                            c = 2;
                                        }
                                    } else if (name.equals("extensionProvider")) {
                                        c = 1;
                                    }
                                    if (c != 0) {
                                        if (c != 1) {
                                            if (c != 2) {
                                                LOGGER.warning("Unknown provider type: " + name);
                                            } else {
                                                this.sfProviders.add(new StreamFeatureProviderInfo(strNextText, strNextText2, (ExtensionElementProvider) clsLoadClass.newInstance()));
                                            }
                                        } else if (ExtensionElementProvider.class.isAssignableFrom(clsLoadClass)) {
                                            this.extProviders.add(new ExtensionProviderInfo(strNextText, strNextText2, (ExtensionElementProvider) clsLoadClass.newInstance()));
                                        } else {
                                            this.exceptions.add(new IllegalArgumentException(strNextText3 + " is not a PacketExtensionProvider"));
                                        }
                                    } else if (IQProvider.class.isAssignableFrom(clsLoadClass)) {
                                        this.iqProviders.add(new IQProviderInfo(strNextText, strNextText2, (IQProvider) clsLoadClass.newInstance()));
                                    } else {
                                        this.exceptions.add(new IllegalArgumentException(strNextText3 + " is not a IQProvider"));
                                    }
                                } catch (ClassNotFoundException e) {
                                    LOGGER.log(Level.SEVERE, "Could not find provider class", (Throwable) e);
                                    this.exceptions.add(e);
                                } catch (InstantiationException e2) {
                                    LOGGER.log(Level.SEVERE, "Could not instanciate " + strNextText3, (Throwable) e2);
                                    this.exceptions.add(e2);
                                }
                            }
                        } catch (IllegalArgumentException e3) {
                            LOGGER.log(Level.SEVERE, "Invalid provider type found [" + name + "] when expecting iqProvider or extensionProvider", (Throwable) e3);
                            this.exceptions.add(e3);
                        }
                    }
                    eventType = xmlPullParserNewPullParser.next();
                } while (eventType != 1);
            } catch (Exception e4) {
                LOGGER.log(Level.SEVERE, "Unknown error occurred while parsing provider file", (Throwable) e4);
                this.exceptions.add(e4);
            }
        } finally {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
