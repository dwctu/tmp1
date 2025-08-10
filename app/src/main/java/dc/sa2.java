package dc;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityShortVideo;
import java.util.HashMap;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: ILDRControlUi.java */
/* loaded from: classes3.dex */
public interface sa2 {
    void A0(CommunMessage communMessage, int i);

    IPeopleInfo C();

    void C2(CommunMessage communMessage);

    boolean E();

    boolean H1(boolean z);

    View H2(String str);

    void H3(CommunMessage communMessage, EntityShortVideo entityShortVideo);

    void K();

    void M(EntityPattern entityPattern);

    void P();

    void Q1(HashMap<String, String> map);

    void R2(int i, CommunMessage communMessage);

    void T0(CommunMessage communMessage);

    HashMap<String, GifImageView> U3();

    void W3();

    void X2();

    void Z2();

    void Z3();

    String b0();

    void cancleDelay();

    List<CommunMessage> d0();

    void dissDialog();

    String getUserName();

    void m2(CommunMessage communMessage);

    void n();

    void notifyDataSetChanged();

    boolean o();

    void q();

    HashMap<String, String> r();

    void s3(CommunMessage communMessage);

    void showDialog();

    void t();

    void v();

    void v1(CommunMessage communMessage);

    void x3(CommunMessage communMessage, Bitmap bitmap, ImageView imageView);
}
