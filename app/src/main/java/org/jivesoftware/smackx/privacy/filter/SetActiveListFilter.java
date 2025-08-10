package org.jivesoftware.smackx.privacy.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.privacy.packet.Privacy;

/* loaded from: classes5.dex */
public class SetActiveListFilter extends FlexibleStanzaTypeFilter<Privacy> {
    public static final SetActiveListFilter INSTANCE = new SetActiveListFilter();

    private SetActiveListFilter() {
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Privacy privacy) {
        if (privacy.getType() != IQ.Type.set) {
            return false;
        }
        return privacy.getActiveName() != null || privacy.isDeclineActiveList();
    }
}
