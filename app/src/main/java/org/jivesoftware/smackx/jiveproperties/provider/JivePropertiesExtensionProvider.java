package org.jivesoftware.smackx.jiveproperties.provider;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.jiveproperties.JivePropertiesManager;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class JivePropertiesExtensionProvider extends ExtensionElementProvider<JivePropertiesExtension> {
    private static final Logger LOGGER = Logger.getLogger(JivePropertiesExtensionProvider.class.getName());

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r0v28, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v31, types: [java.lang.Integer] */
    @Override // org.jivesoftware.smack.provider.Provider
    public JivePropertiesExtension parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException, NumberFormatException, ClassNotFoundException {
        String object;
        HashMap map = new HashMap();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2 && xmlPullParser.getName().equals("property")) {
                boolean z = false;
                String attributeValue = null;
                String strNextText = null;
                String strNextText2 = null;
                String str = null;
                while (!z) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 2) {
                        String name = xmlPullParser.getName();
                        if (name.equals("name")) {
                            strNextText2 = xmlPullParser.nextText();
                        } else if (name.equals("value")) {
                            attributeValue = xmlPullParser.getAttributeValue("", "type");
                            strNextText = xmlPullParser.nextText();
                        }
                    } else if (next2 == 3 && xmlPullParser.getName().equals("property")) {
                        if (TypedValues.Custom.S_INT.equals(attributeValue)) {
                            object = Integer.valueOf(strNextText);
                        } else if ("long".equals(attributeValue)) {
                            object = Long.valueOf(strNextText);
                        } else if (TypedValues.Custom.S_FLOAT.equals(attributeValue)) {
                            object = Float.valueOf(strNextText);
                        } else if ("double".equals(attributeValue)) {
                            object = Double.valueOf(strNextText);
                        } else if (TypedValues.Custom.S_BOOLEAN.equals(attributeValue)) {
                            object = Boolean.valueOf(strNextText);
                        } else {
                            if (TypedValues.Custom.S_STRING.equals(attributeValue)) {
                                str = strNextText;
                            } else if ("java-object".equals(attributeValue)) {
                                if (JivePropertiesManager.isJavaObjectEnabled()) {
                                    try {
                                        object = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(strNextText))).readObject();
                                    } catch (Exception e) {
                                        LOGGER.log(Level.SEVERE, "Error parsing java object", (Throwable) e);
                                    }
                                } else {
                                    LOGGER.severe("JavaObject is not enabled. Enable with JivePropertiesManager.setJavaObjectEnabled(true)");
                                }
                            }
                            if (strNextText2 != null && str != null) {
                                map.put(strNextText2, str);
                            }
                            z = true;
                        }
                        str = object;
                        if (strNextText2 != null) {
                            map.put(strNextText2, str);
                        }
                        z = true;
                    }
                }
            } else if (next == 3 && xmlPullParser.getName().equals(JivePropertiesExtension.ELEMENT)) {
                return new JivePropertiesExtension(map);
            }
        }
    }
}
