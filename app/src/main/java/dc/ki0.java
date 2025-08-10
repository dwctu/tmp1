package dc;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: NubiaImpl.java */
/* loaded from: classes.dex */
public class ki0 implements wh0 {
    public final Context a;

    public ki0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) throws RemoteException {
        if (this.a == null || vh0Var == null) {
            return;
        }
        if (!a()) {
            xh0.a("Only supports Android 10.0 and above for Nubia");
            vh0Var.b(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt(XHTMLText.CODE, -1) == 0 ? bundleCall.getString(TtmlNode.ATTR_ID) : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + bundleCall.getString("message"));
            }
            xh0.a("OAID query success: " + string);
            vh0Var.a(string);
        } catch (Exception e) {
            xh0.a(e);
            vh0Var.b(e);
        }
    }
}
