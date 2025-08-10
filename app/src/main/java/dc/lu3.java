package dc;

import com.wear.bean.Account;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* compiled from: SmackStanzaIQListener.java */
/* loaded from: classes4.dex */
public class lu3 implements StanzaListener {
    public lu3(hu3 hu3Var) {
        MyApplication myApplication = WearUtils.x;
    }

    @Override // org.jivesoftware.smack.StanzaListener
    public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
        if (stanza instanceof VCard) {
            VCard vCard = (VCard) stanza;
            String strG0 = WearUtils.g0(vCard.getFrom());
            Account accountU = WearUtils.y.u();
            if (accountU != null && strG0.equals(accountU.getId())) {
                hu3.u0(vCard);
            }
        }
    }
}
