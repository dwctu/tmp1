package dc;

import com.wear.protocol.CommunMessage;
import java.util.Comparator;

/* compiled from: CommunMessageCompare.java */
/* loaded from: classes3.dex */
public class n12 implements Comparator<CommunMessage> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(CommunMessage communMessage, CommunMessage communMessage2) {
        return communMessage.getCreated().getTime() > communMessage2.getCreated().getTime() ? -1 : 1;
    }
}
