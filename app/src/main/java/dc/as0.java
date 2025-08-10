package dc;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;
import com.google.android.exoplayer2.util.Util;
import java.util.Set;

/* compiled from: MediaSessionConnector.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class as0 {
    public static boolean $default$sameAs(MediaSessionConnector.MediaMetadataProvider _this, MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2) {
        if (mediaMetadataCompat == mediaMetadataCompat2) {
            return true;
        }
        if (mediaMetadataCompat.size() != mediaMetadataCompat2.size()) {
            return false;
        }
        Set<String> setKeySet = mediaMetadataCompat.keySet();
        Bundle bundle = mediaMetadataCompat.getBundle();
        Bundle bundle2 = mediaMetadataCompat2.getBundle();
        for (String str : setKeySet) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj != obj2) {
                if ((obj instanceof Bitmap) && (obj2 instanceof Bitmap)) {
                    if (!((Bitmap) obj).sameAs((Bitmap) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof RatingCompat) && (obj2 instanceof RatingCompat)) {
                    RatingCompat ratingCompat = (RatingCompat) obj;
                    RatingCompat ratingCompat2 = (RatingCompat) obj2;
                    if (ratingCompat.hasHeart() != ratingCompat2.hasHeart() || ratingCompat.isRated() != ratingCompat2.isRated() || ratingCompat.isThumbUp() != ratingCompat2.isThumbUp() || ratingCompat.getPercentRating() != ratingCompat2.getPercentRating() || ratingCompat.getStarRating() != ratingCompat2.getStarRating() || ratingCompat.getRatingStyle() != ratingCompat2.getRatingStyle()) {
                        return false;
                    }
                } else if (!Util.areEqual(obj, obj2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
