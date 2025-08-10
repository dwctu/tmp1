package dc;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import dc.l51;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import pl.droidsonroids.gif.GifViewUtils;

/* compiled from: AndroidManifestParser.java */
/* loaded from: classes2.dex */
public final class m51 {
    public static l51.a a(@NonNull XmlResourceParser xmlResourceParser) {
        l51.a aVar = new l51.a();
        xmlResourceParser.getAttributeValue(GifViewUtils.ANDROID_NS, "name");
        aVar.a = xmlResourceParser.getAttributeBooleanValue(GifViewUtils.ANDROID_NS, "supportsPictureInPicture", false);
        return aVar;
    }

    @NonNull
    public static l51 b(@NonNull Context context, int i) throws XmlPullParserException, IOException {
        l51 l51Var = new l51();
        XmlResourceParser xmlResourceParserOpenXmlResourceParser = context.getAssets().openXmlResourceParser(i, "AndroidManifest.xml");
        do {
            if (xmlResourceParserOpenXmlResourceParser.getEventType() == 2) {
                String name = xmlResourceParserOpenXmlResourceParser.getName();
                if (TextUtils.equals("manifest", name)) {
                    l51Var.a = xmlResourceParserOpenXmlResourceParser.getAttributeValue(null, "package");
                }
                if (TextUtils.equals("uses-sdk", name)) {
                    l51Var.b = f(xmlResourceParserOpenXmlResourceParser);
                }
                if (TextUtils.equals("uses-permission", name) || TextUtils.equals("uses-permission-sdk-23", name) || TextUtils.equals("uses-permission-sdk-m", name)) {
                    l51Var.c.add(d(xmlResourceParserOpenXmlResourceParser));
                }
                if (TextUtils.equals(MimeTypes.BASE_TYPE_APPLICATION, name)) {
                    l51Var.d = c(xmlResourceParserOpenXmlResourceParser);
                }
                if (TextUtils.equals(ActivityChooserModel.ATTRIBUTE_ACTIVITY, name) || TextUtils.equals("activity-alias", name)) {
                    l51Var.e.add(a(xmlResourceParserOpenXmlResourceParser));
                }
                if (TextUtils.equals(NotificationCompat.CATEGORY_SERVICE, name)) {
                    l51Var.f.add(e(xmlResourceParserOpenXmlResourceParser));
                }
            }
        } while (xmlResourceParserOpenXmlResourceParser.next() != 1);
        xmlResourceParserOpenXmlResourceParser.close();
        return l51Var;
    }

    public static l51.b c(@NonNull XmlResourceParser xmlResourceParser) {
        l51.b bVar = new l51.b();
        xmlResourceParser.getAttributeValue(GifViewUtils.ANDROID_NS, "name");
        bVar.a = xmlResourceParser.getAttributeBooleanValue(GifViewUtils.ANDROID_NS, "requestLegacyExternalStorage", false);
        return bVar;
    }

    public static l51.c d(@NonNull XmlResourceParser xmlResourceParser) {
        l51.c cVar = new l51.c();
        cVar.a = xmlResourceParser.getAttributeValue(GifViewUtils.ANDROID_NS, "name");
        cVar.b = xmlResourceParser.getAttributeIntValue(GifViewUtils.ANDROID_NS, "maxSdkVersion", Integer.MAX_VALUE);
        cVar.c = xmlResourceParser.getAttributeIntValue(GifViewUtils.ANDROID_NS, "usesPermissionFlags", 0);
        return cVar;
    }

    public static l51.d e(@NonNull XmlResourceParser xmlResourceParser) {
        l51.d dVar = new l51.d();
        dVar.a = xmlResourceParser.getAttributeValue(GifViewUtils.ANDROID_NS, "name");
        dVar.b = xmlResourceParser.getAttributeValue(GifViewUtils.ANDROID_NS, "permission");
        return dVar;
    }

    public static l51.e f(@NonNull XmlResourceParser xmlResourceParser) {
        l51.e eVar = new l51.e();
        eVar.a = xmlResourceParser.getAttributeIntValue(GifViewUtils.ANDROID_NS, "minSdkVersion", 0);
        return eVar;
    }
}
