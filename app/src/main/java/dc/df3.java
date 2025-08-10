package dc;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.wear.bean.Group;
import com.wear.bean.MessageUnRead;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityChatABean;
import com.wear.util.WearUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: MsgUnReadUtils.java */
/* loaded from: classes4.dex */
public class df3 {
    public static volatile df3 d = new df3();
    public HashMap<String, MessageUnRead> a = new HashMap<>();
    public int b = 0;
    public Map<String, Integer> c = new HashMap();

    public static df3 e() {
        return d;
    }

    public int a(String str) {
        return b(str, 1);
    }

    public int b(String str, int i) {
        this.b += i;
        Integer num = this.c.get(str);
        if (num == null) {
            num = 0;
            this.c.put(str, num);
        }
        Integer numValueOf = Integer.valueOf(num.intValue() + i);
        this.c.put(str, numValueOf);
        return numValueOf.intValue();
    }

    public int c(String str) {
        Integer num = this.c.get(str);
        if (num == null) {
            num = 0;
        }
        this.b -= num.intValue();
        this.c.remove(str);
        return this.b;
    }

    public void d(String str) {
        if (WearUtils.e1(str) || WearUtils.e1(zt3.k)) {
            return;
        }
        String strI0 = WearUtils.i0(zt3.k);
        if (DaoUtils.getMessageUnReadDao().isExistUnRead(strI0, str)) {
            DaoUtils.getMessageUnReadDao().delById(DaoUtils.getMessageUnReadDao().getUnRead(strI0, str).getId());
        }
        if (this.a.get(str) != null) {
            this.a.remove(str);
        }
    }

    public int f() {
        int iIntValue;
        int i = 0;
        try {
            iIntValue = 0;
            for (String str : this.c.keySet()) {
                try {
                    IPeopleInfo iPeopleInfoS = ch3.n().s(str);
                    n82 n82Var = WearUtils.x.i;
                    String strJ0 = WearUtils.j0(str);
                    if (iPeopleInfoS != null && n82Var != null) {
                        if (n82Var.o(WearUtils.j0(str)) || WearUtils.w1(str) || n82Var.n(strJ0) || !iPeopleInfoS.isShowInFriendsList()) {
                            iIntValue += this.c.get(str).intValue();
                        }
                    }
                } catch (Exception unused) {
                    i = iIntValue;
                    iIntValue = i;
                    return (this.b - iIntValue) + mu3.c;
                }
            }
        } catch (Exception unused2) {
        }
        return (this.b - iIntValue) + mu3.c;
    }

    public int g(String str) {
        Integer num = this.c.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public CommunMessage h(String str) {
        if (!WearUtils.e1(str) && !WearUtils.e1(zt3.k)) {
            String strI0 = WearUtils.i0(zt3.k);
            if (DaoUtils.getMessageUnReadDao().isExistUnRead(strI0, str)) {
                return DaoUtils.getCommunMessageDao().findById(DaoUtils.getMessageUnReadDao().getUnRead(strI0, str).getId());
            }
        }
        return null;
    }

    public void i() {
        if (WearUtils.e1(zt3.k)) {
            return;
        }
        String strI0 = WearUtils.i0(zt3.k);
        String str = "initUnReadCountByLogin : " + strI0;
        List<MessageUnRead> allLoginUserUnReads = DaoUtils.getMessageUnReadDao().getAllLoginUserUnReads(strI0);
        this.c.clear();
        int i = 0;
        if (allLoginUserUnReads != null && allLoginUserUnReads.size() > 0) {
            String str2 = "initUnReadCountByLogin unReadDbRecords = " + allLoginUserUnReads.size();
            Iterator<MessageUnRead> it = allLoginUserUnReads.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                String friendJid = it.next().getFriendJid();
                String str3 = "id====" + WearUtils.g0(friendJid);
                IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(friendJid));
                if (iPeopleInfoS == null) {
                    String str4 = "friend = null:" + i2 + "  friendJid = " + friendJid;
                } else {
                    CommunMessage communMessageH = h(friendJid);
                    String str5 = "unReadCommunMessage:" + communMessageH;
                    if (communMessageH != null) {
                        int iFindUnReadSize = DaoUtils.getCommunMessageDao().findUnReadSize(strI0, friendJid, 0, 10, communMessageH.getCreated(), true);
                        String str6 = "unReadSize:" + iFindUnReadSize;
                        this.c.put(WearUtils.g0(friendJid), Integer.valueOf(iFindUnReadSize));
                        i2 += iFindUnReadSize;
                        String str7 = "muteCount111111:" + i2;
                        if (iPeopleInfoS instanceof Group) {
                            Group group = (Group) iPeopleInfoS;
                            group.clearAtMe();
                            List<CommunMessage> listFindUnReadByPage = DaoUtils.getCommunMessageDao().findUnReadByPage(WearUtils.y.p(), friendJid, 0, 10, iFindUnReadSize);
                            Collections.reverse(listFindUnReadByPage);
                            for (CommunMessage communMessage : listFindUnReadByPage) {
                                communMessage.setDataBean(communMessage.syncDecryptBean());
                                if ((communMessage.getDataBean() instanceof EntityChat) && !communMessage.getFrom().equals(strI0)) {
                                    EntityChat entityChat = (EntityChat) communMessage.getDataBean();
                                    if (entityChat.getPeopleData() != null) {
                                        Iterator<EntityChatABean> it2 = entityChat.getPeopleData().iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                if (strI0.equals(it2.next().getJid())) {
                                                    group.addAtMe(communMessage.getId());
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i = i2;
        }
        String str8 = "muteCount:" + i;
        n(i);
    }

    public void j() {
        Map<String, Integer> map = this.c;
        if (map != null) {
            map.clear();
        }
    }

    public int k(String str) {
        Integer num = this.c.get(str);
        if (num != null) {
            if (num.intValue() > 1) {
                this.c.put(str, Integer.valueOf(num.intValue() - 1));
            } else {
                this.c.remove(str);
            }
            this.b--;
        }
        return this.b;
    }

    public void l(String str, String str2) {
        m(str, str2, true);
    }

    public void m(String str, String str2, boolean z) {
        if (WearUtils.e1(str) || WearUtils.e1(zt3.k)) {
            return;
        }
        String strI0 = WearUtils.i0(zt3.k);
        if (this.a.get(str) == null) {
            if (DaoUtils.getMessageUnReadDao().isExistUnRead(strI0, str)) {
                this.a.put(str, DaoUtils.getMessageUnReadDao().getUnRead(strI0, str));
            } else {
                MessageUnRead messageUnRead = new MessageUnRead();
                messageUnRead.setId(str2);
                messageUnRead.setOwnerJid(strI0);
                messageUnRead.setFriendJid(str);
                DaoUtils.getMessageUnReadDao().updateOrAdd(messageUnRead);
                this.a.put(str, messageUnRead);
            }
        }
        if (z) {
            a(WearUtils.g0(str));
            LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent("com.wear.messageTip"));
        }
    }

    public void n(int i) {
        this.b = i;
    }

    public void o(String str, String str2) {
        if (this.a.get(str) != null) {
            CommunMessage communMessageH = h(str);
            CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(str2);
            if (communMessageH == null || communMessageFindById == null) {
                return;
            }
            if (!be3.C(communMessageH.getCreated(), communMessageFindById.getCreated(), 0) || communMessageH.getId().equals(communMessageFindById.getId())) {
                k(WearUtils.g0(str));
                IPeopleInfo iPeopleInfoS = WearUtils.y.s(WearUtils.g0(str));
                if (iPeopleInfoS != null && !WearUtils.e1(iPeopleInfoS.getId()) && !WearUtils.e1(WearUtils.y.p())) {
                    iPeopleInfoS.setLastMessage(DaoUtils.getCommunMessageDao().findLastMessage(WearUtils.y.p(), WearUtils.j0(iPeopleInfoS.getId())));
                }
                if (iPeopleInfoS instanceof Group) {
                    ((Group) iPeopleInfoS).remoteAtMe(str2);
                }
                LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent("com.wear.messageTip"));
            }
        }
    }
}
