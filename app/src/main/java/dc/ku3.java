package dc;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* compiled from: SmackStanzaIQFilter.java */
/* loaded from: classes4.dex */
public class ku3 implements StanzaFilter {
    public final Class<? extends IQ> a;

    public ku3(Class<? extends IQ> cls) {
        this.a = cls;
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        if (!this.a.isInstance(stanza)) {
            return false;
        }
        VCard vCard = (VCard) stanza;
        String str = ch3.n().p() + "/wearable";
        if (vCard.getFrom() != null) {
            return vCard.getFrom().equals(str);
        }
        return false;
    }
}
