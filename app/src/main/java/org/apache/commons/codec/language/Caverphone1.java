package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.widget.control.FingImageLayout;
import java.util.Locale;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes5.dex */
public class Caverphone1 extends AbstractCaverphone {
    private static final String SIX_1 = "111111";

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return SIX_1;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", StreamInitiation.ELEMENT).replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", "k").replaceAll(XHTMLText.Q, "k").replaceAll("x", "k").replaceAll(PSOProgramService.VS_Key, "f").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "t").replaceAll("ph", "fh").replaceAll("b", "p").replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", ExifInterface.GPS_MEASUREMENT_3D).replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll("w", "2").replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll(XHTMLText.H, "2").replaceAll("r3", "R3").replaceAll("ry", "Ry").replaceAll(StreamManagement.AckRequest.ELEMENT, "2").replaceAll("l3", "L3").replaceAll("ly", "Ly").replaceAll("l", "2").replaceAll("j", FingImageLayout.ObjectAnimatorY).replaceAll("y3", "Y3").replaceAll(FingImageLayout.ObjectAnimatorY, "2").replaceAll("2", "").replaceAll(ExifInterface.GPS_MEASUREMENT_3D, "") + SIX_1).substring(0, 6);
    }
}
