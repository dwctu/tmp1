package org.apache.cordova;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class AllowListPlugin extends CordovaPlugin {
    public static final String LOG_TAG = "CordovaAllowListPlugin";
    public static final String PLUGIN_NAME = "CordovaAllowListPlugin";
    private AllowList allowedIntents;
    private AllowList allowedNavigations;
    private AllowList allowedRequests;

    public class CustomConfigXmlParser extends ConfigXmlParser {
        private CordovaPreferences prefs;

        private CustomConfigXmlParser() {
            this.prefs = new CordovaPreferences();
        }

        @Override // org.apache.cordova.ConfigXmlParser
        public void handleEndTag(XmlPullParser xmlPullParser) {
        }

        @Override // org.apache.cordova.ConfigXmlParser
        public void handleStartTag(XmlPullParser xmlPullParser) {
            String attributeValue;
            String name = xmlPullParser.getName();
            boolean z = false;
            if (name.equals(FirebaseAnalytics.Param.CONTENT)) {
                AllowListPlugin.this.allowedNavigations.addAllowListEntry(xmlPullParser.getAttributeValue(null, "src"), false);
                return;
            }
            if (name.equals("allow-navigation")) {
                String attributeValue2 = xmlPullParser.getAttributeValue(null, XHTMLText.HREF);
                if (!"*".equals(attributeValue2)) {
                    AllowListPlugin.this.allowedNavigations.addAllowListEntry(attributeValue2, false);
                    return;
                }
                AllowListPlugin.this.allowedNavigations.addAllowListEntry("http://*/*", false);
                AllowListPlugin.this.allowedNavigations.addAllowListEntry("https://*/*", false);
                AllowListPlugin.this.allowedNavigations.addAllowListEntry("data:*", false);
                return;
            }
            if (name.equals("allow-intent")) {
                AllowListPlugin.this.allowedIntents.addAllowListEntry(xmlPullParser.getAttributeValue(null, XHTMLText.HREF), false);
                return;
            }
            if (!name.equals("access") || (attributeValue = xmlPullParser.getAttributeValue(null, "origin")) == null) {
                return;
            }
            if ("*".equals(attributeValue)) {
                AllowListPlugin.this.allowedRequests.addAllowListEntry("http://*/*", false);
                AllowListPlugin.this.allowedRequests.addAllowListEntry("https://*/*", false);
                return;
            }
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "subdomains");
            AllowList allowList = AllowListPlugin.this.allowedRequests;
            if (attributeValue3 != null && attributeValue3.compareToIgnoreCase("true") == 0) {
                z = true;
            }
            allowList.addAllowListEntry(attributeValue, z);
        }
    }

    public AllowListPlugin() {
    }

    public AllowList getAllowedIntents() {
        return this.allowedIntents;
    }

    public AllowList getAllowedNavigations() {
        return this.allowedNavigations;
    }

    public AllowList getAllowedRequests() {
        return this.allowedRequests;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void pluginInitialize() throws XmlPullParserException, IOException {
        if (this.allowedNavigations == null) {
            this.allowedNavigations = new AllowList();
            this.allowedIntents = new AllowList();
            this.allowedRequests = new AllowList();
            new CustomConfigXmlParser().parse(this.webView.getContext());
        }
    }

    public void setAllowedIntents(AllowList allowList) {
        this.allowedIntents = allowList;
    }

    public void setAllowedNavigations(AllowList allowList) {
        this.allowedNavigations = allowList;
    }

    public void setAllowedRequests(AllowList allowList) {
        this.allowedRequests = allowList;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Boolean shouldAllowNavigation(String str) {
        if (this.allowedNavigations.isUrlAllowListed(str)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Boolean shouldAllowRequest(String str) {
        Boolean bool = Boolean.TRUE;
        if (bool.equals(shouldAllowNavigation(str)) || this.allowedRequests.isUrlAllowListed(str)) {
            return bool;
        }
        return null;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Boolean shouldOpenExternalUrl(String str) {
        if (this.allowedIntents.isUrlAllowListed(str)) {
            return Boolean.TRUE;
        }
        return null;
    }

    public AllowListPlugin(Context context) throws XmlPullParserException, IOException {
        this(new AllowList(), new AllowList(), null);
        new CustomConfigXmlParser().parse(context);
    }

    public AllowListPlugin(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        this(new AllowList(), new AllowList(), null);
        new CustomConfigXmlParser().parse(xmlPullParser);
    }

    public AllowListPlugin(AllowList allowList, AllowList allowList2, AllowList allowList3) {
        if (allowList3 == null) {
            allowList3 = new AllowList();
            allowList3.addAllowListEntry("file:///*", false);
            allowList3.addAllowListEntry("data:*", false);
        }
        this.allowedNavigations = allowList;
        this.allowedIntents = allowList2;
        this.allowedRequests = allowList3;
    }
}
