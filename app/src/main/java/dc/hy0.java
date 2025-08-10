package dc;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* compiled from: HttpDataSource.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class hy0 {
    public static /* synthetic */ boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = Ascii.toLowerCase(str);
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        return ((lowerCase.contains("text") && !lowerCase.contains(MimeTypes.TEXT_VTT)) || lowerCase.contains(XHTMLExtension.ELEMENT) || lowerCase.contains("xml")) ? false : true;
    }
}
