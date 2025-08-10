package org.jivesoftware.smackx.privacy;

import java.util.List;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;

/* loaded from: classes5.dex */
public interface PrivacyListListener {
    void setPrivacyList(String str, List<PrivacyItem> list);

    void updatedPrivacyList(String str);
}
