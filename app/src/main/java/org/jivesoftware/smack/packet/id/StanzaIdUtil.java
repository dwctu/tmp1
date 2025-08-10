package org.jivesoftware.smack.packet.id;

import com.google.android.vending.expansion.downloader.Constants;
import java.util.concurrent.atomic.AtomicLong;
import org.jivesoftware.smack.util.StringUtils;

/* loaded from: classes5.dex */
public class StanzaIdUtil {
    private static final String PREFIX = StringUtils.randomString(5) + Constants.FILENAME_SEQUENCE_SEPARATOR;
    private static final AtomicLong ID = new AtomicLong();

    public static String newStanzaId() {
        return PREFIX + Long.toString(ID.incrementAndGet());
    }
}
