package dc;

import com.wear.bean.handlerbean.IPeopleInfo;
import java.util.Comparator;

/* compiled from: PeopleCreateGroupCompare.java */
/* loaded from: classes3.dex */
public class u12 implements Comparator<IPeopleInfo> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(IPeopleInfo iPeopleInfo, IPeopleInfo iPeopleInfo2) {
        return uf3.a(iPeopleInfo.getShowNickName()).compareTo(uf3.a(iPeopleInfo2.getShowNickName()));
    }
}
