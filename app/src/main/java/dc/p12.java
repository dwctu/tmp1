package dc;

import com.wear.bean.GroupMember;
import com.wear.util.WearUtils;
import java.util.Comparator;

/* compiled from: GroupControlPeopleCompare.java */
/* loaded from: classes3.dex */
public class p12 implements Comparator<GroupMember> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(GroupMember groupMember, GroupMember groupMember2) {
        if (groupMember.realOnline() && !groupMember2.realOnline()) {
            return -1;
        }
        if (!groupMember.realOnline() && groupMember2.realOnline()) {
            return 1;
        }
        if (groupMember.realOnline() && groupMember2.realOnline()) {
            if (!WearUtils.g1(groupMember.getToys()) && WearUtils.g1(groupMember2.getToys())) {
                return -1;
            }
            if (WearUtils.g1(groupMember.getToys()) && !WearUtils.g1(groupMember2.getToys())) {
                return 1;
            }
        }
        return uf3.a(groupMember.getShowNickName()).compareTo(uf3.a(groupMember2.getShowNickName()));
    }
}
