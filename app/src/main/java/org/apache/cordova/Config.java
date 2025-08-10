package org.apache.cordova;

import android.app.Activity;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

@Deprecated
/* loaded from: classes5.dex */
public class Config {
    private static final String TAG = "Config";
    public static ConfigXmlParser parser;

    private Config() {
    }

    public static String getErrorUrl() {
        return parser.getPreferences().getString("errorurl", null);
    }

    public static List<PluginEntry> getPluginEntries() {
        return parser.getPluginEntries();
    }

    public static CordovaPreferences getPreferences() {
        return parser.getPreferences();
    }

    public static String getStartUrl() {
        ConfigXmlParser configXmlParser = parser;
        return configXmlParser == null ? "file:///android_asset/www/index.html" : configXmlParser.getLaunchUrl();
    }

    public static void init(Activity activity) throws XmlPullParserException, IOException {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        parser = configXmlParser;
        configXmlParser.parse(activity);
        parser.getPreferences().setPreferencesBundle(activity.getIntent().getExtras());
    }

    public static boolean isInitialized() {
        return parser != null;
    }

    public static void init() {
        if (parser == null) {
            parser = new ConfigXmlParser();
        }
    }
}
