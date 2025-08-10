package com.google.android.play.core.internal;

import android.content.res.AssetManager;
import androidx.annotation.Nullable;
import com.google.common.primitives.UnsignedInts;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import pl.droidsonroids.gif.GifViewUtils;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzax {
    private final com.google.android.play.core.splitcompat.zza zza;

    @Nullable
    private XmlPullParser zzb;

    public zzax(com.google.android.play.core.splitcompat.zza zzaVar) {
        this.zza = zzaVar;
    }

    public final long zza() throws XmlPullParserException, IOException, NumberFormatException {
        if (this.zzb == null) {
            throw new XmlPullParserException("Manifest file needs to be loaded before parsing.");
        }
        while (true) {
            int next = this.zzb.next();
            if (next != 2) {
                if (next == 1) {
                    break;
                }
            } else if (this.zzb.getName().equals("manifest")) {
                String attributeValue = this.zzb.getAttributeValue(GifViewUtils.ANDROID_NS, "versionCode");
                String attributeValue2 = this.zzb.getAttributeValue(GifViewUtils.ANDROID_NS, "versionCodeMajor");
                if (attributeValue == null) {
                    throw new XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
                }
                try {
                    int i = Integer.parseInt(attributeValue);
                    if (attributeValue2 == null) {
                        return i;
                    }
                    try {
                        return (Integer.parseInt(attributeValue2) << 32) | (i & UnsignedInts.INT_MASK);
                    } catch (NumberFormatException e) {
                        throw new XmlPullParserException(String.format("Couldn't parse versionCodeMajor to int: %s", e.getMessage()));
                    }
                } catch (NumberFormatException e2) {
                    throw new XmlPullParserException(String.format("Couldn't parse versionCode to int: %s", e2.getMessage()));
                }
            }
        }
        throw new XmlPullParserException("Couldn't find manifest entry at top-level.");
    }

    public final void zzb(AssetManager assetManager, File file) throws IOException {
        this.zzb = assetManager.openXmlResourceParser(com.google.android.play.core.splitcompat.zza.zzc(assetManager, file), "AndroidManifest.xml");
    }
}
