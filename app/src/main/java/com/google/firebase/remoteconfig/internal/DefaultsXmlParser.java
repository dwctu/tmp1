package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class DefaultsXmlParser {
    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";

    public static Map<String, String> getDefaultsFromXml(Context context, int i) throws Resources.NotFoundException {
        Resources resources;
        HashMap map = new HashMap();
        try {
            resources = context.getResources();
        } catch (IOException | XmlPullParserException unused) {
        }
        if (resources == null) {
            return map;
        }
        XmlResourceParser xml = resources.getXml(i);
        String name = null;
        String text = null;
        String text2 = null;
        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
            if (eventType == 2) {
                name = xml.getName();
            } else if (eventType == 3) {
                if (xml.getName().equals(XML_TAG_ENTRY)) {
                    if (text != null && text2 != null) {
                        map.put(text, text2);
                    }
                    text = null;
                    text2 = null;
                }
                name = null;
            } else if (eventType == 4 && name != null) {
                char c = 65535;
                int iHashCode = name.hashCode();
                if (iHashCode != 106079) {
                    if (iHashCode == 111972721 && name.equals("value")) {
                        c = 1;
                    }
                } else if (name.equals(XML_TAG_KEY)) {
                    c = 0;
                }
                if (c == 0) {
                    text = xml.getText();
                } else if (c == 1) {
                    text2 = xml.getText();
                }
            }
        }
        return map;
    }
}
