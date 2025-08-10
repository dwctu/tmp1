package com.amazonaws.regions;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RegionUtils {
    public static List<Region> a;
    public static final Log b = LogFactory.c("com.amazonaws.request");

    public static Region a(String str) {
        for (Region region : c()) {
            if (region.d().equals(str)) {
                return region;
            }
        }
        return null;
    }

    public static Region b(String str) {
        String host = d(str).getHost();
        for (Region region : c()) {
            Iterator<String> it = region.g().values().iterator();
            while (it.hasNext()) {
                if (d(it.next()).getHost().equals(host)) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException("No region found with any service for endpoint " + str);
    }

    public static synchronized List<Region> c() {
        if (a == null) {
            e();
        }
        return a;
    }

    public static URI d(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getHost() != null) {
                return uri;
            }
            return new URI("http://" + str);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to parse service endpoint: " + e.getMessage());
        }
    }

    public static synchronized void e() {
        if (System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride") != null) {
            try {
                h();
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Couldn't find regions override file specified", e);
            }
        }
        if (a == null) {
            g();
        }
        if (a == null) {
            throw new RuntimeException("Failed to initialize the regions.");
        }
    }

    public static void f(InputStream inputStream) {
        try {
            a = new RegionMetadataParser().e(inputStream);
        } catch (Exception e) {
            b.f("Failed to parse regional endpoints", e);
        }
    }

    public static void g() {
        Log log = b;
        if (log.isDebugEnabled()) {
            log.a("Initializing the regions with default regions");
        }
        a = RegionDefaults.a();
    }

    public static void h() throws FileNotFoundException {
        String property = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
        Log log = b;
        if (log.isDebugEnabled()) {
            log.a("Using local override of the regions file (" + property + ") to initiate regions data...");
        }
        f(new FileInputStream(new File(property)));
    }
}
