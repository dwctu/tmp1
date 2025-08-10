package dc;

import com.wear.bean.handlerbean.IPeopleInfo;
import java.util.Comparator;

/* compiled from: PeopleCompare.java */
/* loaded from: classes3.dex */
public class t12 implements Comparator<IPeopleInfo> {
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b4  */
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compare(com.wear.bean.handlerbean.IPeopleInfo r19, com.wear.bean.handlerbean.IPeopleInfo r20) {
        /*
            r18 = this;
            long r0 = r19.getSetTop()
            r2 = -1
            r3 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L14
            long r0 = r20.getSetTop()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 > 0) goto L14
            return r2
        L14:
            long r0 = r19.getSetTop()
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 > 0) goto L26
            long r0 = r20.getSetTop()
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 <= 0) goto L26
            return r5
        L26:
            r0 = r19
            boolean r1 = r0 instanceof com.wear.bean.official.OfficialAcount
            r6 = 0
            if (r1 == 0) goto L2f
            r7 = r6
            goto L33
        L2f:
            com.wear.protocol.CommunMessage r7 = r19.getDraftMessage()
        L33:
            if (r1 == 0) goto L3a
            com.wear.bean.BaseEntity r8 = r19.getLastOfficialNotice()
            goto L3e
        L3a:
            com.wear.protocol.CommunMessage r8 = r19.getLastMessage()
        L3e:
            r9 = r20
            boolean r10 = r9 instanceof com.wear.bean.official.OfficialAcount
            if (r10 == 0) goto L45
            goto L49
        L45:
            com.wear.protocol.CommunMessage r6 = r19.getDraftMessage()
        L49:
            if (r10 == 0) goto L50
            com.wear.bean.BaseEntity r11 = r20.getLastOfficialNotice()
            goto L54
        L50:
            com.wear.protocol.CommunMessage r11 = r20.getLastMessage()
        L54:
            if (r7 == 0) goto L5f
            java.util.Date r7 = r7.getCreated()
            long r12 = r7.getTime()
            goto L60
        L5f:
            r12 = r3
        L60:
            r14 = -1
            if (r8 == 0) goto L78
            boolean r1 = r8 instanceof com.wear.bean.official.OfficialMsg
            if (r1 == 0) goto L6f
            com.wear.bean.official.OfficialMsg r8 = (com.wear.bean.official.OfficialMsg) r8
            long r7 = r8.getUserReceiveTime()
            goto L7e
        L6f:
            java.util.Date r1 = r8.getCreated()
            long r7 = r1.getTime()
            goto L7e
        L78:
            if (r1 == 0) goto L7d
            r7 = r14
            r12 = r7
            goto L7e
        L7d:
            r7 = r3
        L7e:
            if (r6 == 0) goto L89
            java.util.Date r1 = r6.getCreated()
            long r16 = r1.getTime()
            goto L8b
        L89:
            r16 = r3
        L8b:
            if (r11 == 0) goto La1
            boolean r1 = r11 instanceof com.wear.bean.official.OfficialMsg
            if (r1 == 0) goto L98
            com.wear.bean.official.OfficialMsg r11 = (com.wear.bean.official.OfficialMsg) r11
            long r3 = r11.getUserReceiveTime()
            goto La5
        L98:
            java.util.Date r1 = r11.getCreated()
            long r3 = r1.getTime()
            goto La5
        La1:
            if (r10 == 0) goto La5
            r3 = r14
            goto La7
        La5:
            r14 = r16
        La7:
            long r6 = java.lang.Math.max(r12, r7)
            long r3 = java.lang.Math.max(r14, r3)
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 <= 0) goto Lb4
            return r2
        Lb4:
            if (r1 >= 0) goto Lb7
            return r5
        Lb7:
            boolean r1 = r19.isOnline()
            if (r1 == 0) goto Lc4
            boolean r1 = r20.isOnline()
            if (r1 != 0) goto Lc4
            return r2
        Lc4:
            boolean r0 = r19.isOnline()
            if (r0 != 0) goto Ld1
            boolean r0 = r20.isOnline()
            if (r0 == 0) goto Ld1
            return r5
        Ld1:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.t12.compare(com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IPeopleInfo):int");
    }
}
