package com.wear.bean;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.bean.handlerbean.HandlerUser;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.r12;
import dc.vd3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomInvitationList;

/* loaded from: classes3.dex */
public class Group extends BaseEntity implements HandlerUser, IPeopleInfo {
    private String banType;
    private String byWho;
    private transient CommunMessage draftMessage;
    private long enterTime;
    private Object flag;
    private transient CommunMessage lastMessage;
    private String mcs;
    private String name;
    private String remark;
    private String rns;
    private String rps;
    private int status;
    private String url;
    public LinkedHashMap<String, GroupMember> members = new LinkedHashMap<>();
    private transient List<ResponseRoomInvitationList.InvitationListBean> invitationList = new ArrayList();
    private LinkedList<String> aSelfMessage = new LinkedList<>();
    private long setTop = 0;

    public Group(String str) {
        setId(str);
        this.name = WearUtils.L0();
    }

    public void addAtMe(String str) {
        if (this.aSelfMessage == null) {
            this.aSelfMessage = new LinkedList<>();
        }
        if (this.aSelfMessage.contains(str)) {
            return;
        }
        this.aSelfMessage.add(str);
    }

    public void addMember(GroupMember groupMember) {
        if (groupMember == null) {
            return;
        }
        getMembers().put(groupMember.getJid(), groupMember);
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean addSendToMe() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean canAutomaticAddFriend() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean canSendMsg() {
        return true;
    }

    public void clearAtMe() {
        if (this.aSelfMessage == null) {
            this.aSelfMessage = new LinkedList<>();
        }
        this.aSelfMessage.clear();
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getAddTime() {
        return getEnterTime();
    }

    public int getAdmincounts() {
        Iterator<GroupMember> it = getList().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isAdmin()) {
                i++;
            }
        }
        return i;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    public String getAvatar() {
        if (isExit()) {
            return getRps();
        }
        ArrayList<GroupMember> list = getList();
        String strSubstring = "";
        for (int i = 0; i < list.size() && i <= 8; i++) {
            strSubstring = strSubstring + (list.get(i).getAvatar() + ", ");
        }
        if (TextUtils.isEmpty(strSubstring)) {
            return "";
        }
        if (strSubstring.length() > 2) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
        }
        setRps(strSubstring);
        return strSubstring;
    }

    public String getBanType() {
        return this.banType;
    }

    public String getByWho() {
        return this.byWho;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getDraftMessage() {
        return this.draftMessage;
    }

    public long getEnterTime() {
        return this.enterTime;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Object getFlag() {
        return this.flag;
    }

    public List<ResponseRoomInvitationList.InvitationListBean> getInvitationList() {
        if (this.invitationList == null) {
            this.invitationList = new ArrayList();
        }
        return this.invitationList;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getLastMessage() {
        return this.lastMessage;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public BaseEntity getLastOfficialNotice() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public List<Toy> getLinkedToys2() {
        return null;
    }

    public ArrayList<GroupMember> getList() {
        ArrayList<GroupMember> arrayList;
        try {
            arrayList = new ArrayList<>(getMembers().values());
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            arrayList = new ArrayList<>();
        }
        vd3.b(arrayList, new r12());
        return arrayList;
    }

    public String getMcs() {
        return this.mcs;
    }

    public GroupMember getMemberByJid(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getMembers().get(str);
    }

    public Map<String, GroupMember> getMembers() {
        if (this.members == null) {
            synchronized (this) {
                if (this.members == null) {
                    this.members = new LinkedHashMap<>();
                }
            }
        }
        return this.members;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getMoodMessage() {
        return null;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getRemark() {
        return this.remark;
    }

    public String getRns() {
        return this.rns;
    }

    public String getRps() {
        String str = this.rps;
        return str == null ? "" : str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getSetTop() {
        return this.setTop;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    /* renamed from: getShowName */
    public String getShowNickName() {
        if (!TextUtils.isEmpty(getUserName())) {
            return getUserName();
        }
        if (isExit()) {
            return getRns();
        }
        ArrayList<GroupMember> list = getList();
        String strSubstring = "";
        for (int i = 0; i < list.size() && i <= 5; i++) {
            strSubstring = strSubstring + (list.get(i).getNickName() + ", ");
        }
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        if (strSubstring.length() > 2) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
        }
        setRns(strSubstring);
        return strSubstring;
    }

    public String getShowNameByList(ArrayList<com.wear.bean.handlerbean.IGroupMember> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size() && i <= 5; i++) {
            String nickName = arrayList.get(i).getNickName();
            if (!TextUtils.isEmpty(nickName)) {
                sb.append(nickName);
                sb.append(", ");
            }
        }
        return !TextUtils.isEmpty(sb) ? sb.length() > 2 ? sb.substring(0, sb.length() - 2) : sb.toString() : "";
    }

    public int getStatus() {
        return this.status;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Presence.Mode getStatusMode() {
        return Presence.Mode.chat;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getTempName() {
        return !WearUtils.e1(getRemark()) ? getRemark() : getUserName();
    }

    @Override // com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return 0;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getToyStatus() {
        return "false";
    }

    public String getUrl() {
        return this.url;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getUserJid() {
        return WearUtils.k0(getId());
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getUserName() {
        return TextUtils.isEmpty(getName()) ? "" : this.name;
    }

    public LinkedList<String> getaSelfMessage() {
        if (this.aSelfMessage == null) {
            this.aSelfMessage = new LinkedList<>();
        }
        return this.aSelfMessage;
    }

    public boolean iIsAdamin() {
        GroupMember memberByJid = getMemberByJid(ch3.n().p());
        if (memberByJid != null) {
            return memberByJid.isAdmin();
        }
        return false;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser, com.wear.bean.handlerbean.IPeopleInfo
    public boolean isDateIng() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean isDeleteByFriend() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isExit() {
        return getStatus() != 1;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser, com.wear.bean.handlerbean.IPeopleInfo
    public boolean isFriend() {
        return true;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isGroup() {
        return true;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isOnline() {
        return true;
    }

    public boolean isRoomActive() {
        return WearUtils.e1(this.banType) || this.banType.equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
    }

    public boolean isRoomDisbanded() {
        return !WearUtils.e1(this.banType) && this.banType.equals("disbanded");
    }

    public boolean isRoomProhibited() {
        return !WearUtils.e1(this.banType) && this.banType.equals("prohibited");
    }

    @Override // com.wear.bean.handlerbean.HandlerUser, com.wear.bean.handlerbean.IPeopleInfo
    public boolean isShowInFriendsList() {
        return true;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String isSupportGroup() {
        return null;
    }

    public boolean onlyOneAdmin() {
        return getAdmincounts() <= 1;
    }

    public void remoteAtMe(String str) {
        if (this.aSelfMessage == null) {
            this.aSelfMessage = new LinkedList<>();
        }
        this.aSelfMessage.remove(str);
    }

    public void removeMemberByJid(String str) {
        getMembers().remove(str);
    }

    public void setBanType(String str) {
        this.banType = str;
    }

    public void setByWho(String str) {
        this.byWho = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setDraftMessage(CommunMessage communMessage) {
        this.draftMessage = communMessage;
    }

    public void setEnterTime(long j) {
        this.enterTime = j;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setFlag(Object obj) {
        this.flag = obj;
    }

    public void setInvitationList(List<ResponseRoomInvitationList.InvitationListBean> list) {
        if (this.invitationList == null) {
            this.invitationList = new ArrayList();
        }
        this.invitationList.clear();
        if (list == null || list.size() == 0) {
            return;
        }
        this.invitationList.addAll(list);
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastMessage(CommunMessage communMessage) {
        this.lastMessage = communMessage;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastOfficialNotice(BaseEntity baseEntity) {
    }

    public void setMcs(String str) {
        this.mcs = str;
    }

    public void setMembers(LinkedHashMap<String, GroupMember> linkedHashMap) {
        this.members = linkedHashMap;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRns(String str) {
        this.rns = str;
    }

    public void setRps(String str) {
        this.rps = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setSetTop(long j) {
        this.setTop = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean showBykey(String str) {
        String userName = getUserName();
        if (!TextUtils.isEmpty(userName) && userName.toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        String remark = getRemark();
        if (!TextUtils.isEmpty(remark) && remark.toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        if (isExit()) {
            String rns = getRns();
            if (!TextUtils.isEmpty(rns) && rns.toLowerCase().contains(str.toLowerCase())) {
                return true;
            }
        } else {
            ArrayList<GroupMember> list = getList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getNickName().toLowerCase().contains(str.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }
}
