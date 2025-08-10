package dc;

import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import java.util.Comparator;

/* compiled from: ControlLinkCommunMessageCompare.java */
/* loaded from: classes3.dex */
public class o12 implements Comparator<ControlLinkCommunMessage> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ControlLinkCommunMessage controlLinkCommunMessage, ControlLinkCommunMessage controlLinkCommunMessage2) {
        return controlLinkCommunMessage.getCreateTime() > controlLinkCommunMessage2.getCreateTime() ? -1 : 1;
    }
}
