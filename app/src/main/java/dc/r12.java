package dc;

import com.wear.bean.handlerbean.IGroupPeopleInfo;
import com.wear.util.WearUtils;
import java.util.Comparator;

/* compiled from: GroupPeopleCompare.java */
/* loaded from: classes3.dex */
public class r12 implements Comparator<IGroupPeopleInfo> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(IGroupPeopleInfo iGroupPeopleInfo, IGroupPeopleInfo iGroupPeopleInfo2) {
        if (iGroupPeopleInfo.isOwrn()) {
            return -1;
        }
        if (iGroupPeopleInfo2.isOwrn()) {
            return 1;
        }
        if (iGroupPeopleInfo.getEnterTime() != iGroupPeopleInfo2.getEnterTime()) {
            return iGroupPeopleInfo.getEnterTime() < iGroupPeopleInfo2.getEnterTime() ? -1 : 1;
        }
        if (!WearUtils.e1(iGroupPeopleInfo.getUserName()) && !WearUtils.e1(iGroupPeopleInfo2.getUserName())) {
            return iGroupPeopleInfo.getUserName().compareTo(iGroupPeopleInfo2.getUserName());
        }
        if (!WearUtils.e1(iGroupPeopleInfo.getUserName()) || WearUtils.e1(iGroupPeopleInfo2.getUserName())) {
            return (WearUtils.e1(iGroupPeopleInfo.getUserName()) || !WearUtils.e1(iGroupPeopleInfo2.getUserName())) ? 0 : -1;
        }
        return 1;
    }
}
