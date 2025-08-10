package org.apache.cordova;

import android.net.Uri;
import com.broadcom.bt.util.io.IOUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.ResourceConstants;

/* loaded from: classes5.dex */
public class AllowList {
    public static final String TAG = "CordovaAllowList";
    private ArrayList<URLPattern> allowList = new ArrayList<>();

    public static class URLPattern {
        public Pattern host;
        public Pattern path;
        public Integer port;
        public Pattern scheme;

        public URLPattern(String str, String str2, String str3, String str4) throws MalformedURLException {
            if (str != null) {
                try {
                    if ("*".equals(str)) {
                        this.scheme = null;
                    } else {
                        this.scheme = Pattern.compile(regexFromPattern(str, false), 2);
                    }
                } catch (NumberFormatException unused) {
                    throw new MalformedURLException("Port must be a number");
                }
            } else {
                this.scheme = null;
            }
            if ("*".equals(str2)) {
                this.host = null;
            } else if (str2.startsWith("*.")) {
                this.host = Pattern.compile("([a-z0-9.-]*\\.)?" + regexFromPattern(str2.substring(2), false), 2);
            } else {
                this.host = Pattern.compile(regexFromPattern(str2, false), 2);
            }
            if (str3 == null || "*".equals(str3)) {
                this.port = null;
            } else {
                this.port = Integer.valueOf(Integer.parseInt(str3, 10));
            }
            if (str4 != null && !ResourceConstants.EXT_CMT_START.equals(str4)) {
                this.path = Pattern.compile(regexFromPattern(str4, true));
                return;
            }
            this.path = null;
        }

        private String regexFromPattern(String str, boolean z) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '*' && z) {
                    sb.append(".");
                } else if ("\\.[]{}()^$?+|".indexOf(cCharAt) > -1) {
                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                }
                sb.append(cCharAt);
            }
            return sb.toString();
        }

        public boolean matches(Uri uri) {
            try {
                Pattern pattern = this.scheme;
                if (pattern != null && !pattern.matcher(uri.getScheme()).matches()) {
                    return false;
                }
                Pattern pattern2 = this.host;
                if (pattern2 != null && !pattern2.matcher(uri.getHost()).matches()) {
                    return false;
                }
                Integer num = this.port;
                if (num != null && !num.equals(Integer.valueOf(uri.getPort()))) {
                    return false;
                }
                Pattern pattern3 = this.path;
                if (pattern3 != null) {
                    if (!pattern3.matcher(uri.getPath()).matches()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                LOG.d(AllowList.TAG, e.toString());
                return false;
            }
        }
    }

    public void addAllowListEntry(String str, boolean z) {
        String str2 = "*";
        if (this.allowList != null) {
            try {
                if (str.compareTo("*") == 0) {
                    LOG.d(TAG, "Unlimited access to network resources");
                    this.allowList = null;
                    return;
                }
                Matcher matcher = Pattern.compile("^((\\*|[A-Za-z-]+):(//)?)?(\\*|((\\*\\.)?[^*/:]+))?(:(\\d+))?(/.*)?").matcher(str);
                if (matcher.matches()) {
                    String strGroup = matcher.group(2);
                    String strGroup2 = matcher.group(4);
                    if ((!"file".equals(strGroup) && !FirebaseAnalytics.Param.CONTENT.equals(strGroup)) || strGroup2 != null) {
                        str2 = strGroup2;
                    }
                    String strGroup3 = matcher.group(8);
                    String strGroup4 = matcher.group(9);
                    if (strGroup != null) {
                        this.allowList.add(new URLPattern(strGroup, str2, strGroup3, strGroup4));
                    } else {
                        this.allowList.add(new URLPattern("http", str2, strGroup3, strGroup4));
                        this.allowList.add(new URLPattern("https", str2, strGroup3, strGroup4));
                    }
                }
            } catch (Exception unused) {
                LOG.d(TAG, "Failed to add origin %s", str);
            }
        }
    }

    public boolean isUrlAllowListed(String str) {
        if (this.allowList == null) {
            return true;
        }
        Uri uri = Uri.parse(str);
        Iterator<URLPattern> it = this.allowList.iterator();
        while (it.hasNext()) {
            if (it.next().matches(uri)) {
                return true;
            }
        }
        return false;
    }
}
