package com.wear.bean;

import android.text.TextUtils;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.jf3;
import dc.tu1;
import dc.zb2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class GroupMember implements Serializable, com.wear.bean.handlerbean.IGroupMember, IPeopleInfo {
    private int affiliation;
    private transient int dSStatus;
    private long enterTime;
    private String jid;
    private String nickName;
    private boolean onLine;
    private String openfireStatus;
    private String photo;
    private String scStatus;
    private transient int status;
    private boolean supportMultiToOne;
    private transient ArrayList<Toy> toys;

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getAddTime() {
        return 0L;
    }

    public int getAffiliation() {
        return this.affiliation;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    public String getAvatar() {
        if (!WearUtils.e1(getPhoto())) {
            return getPhoto();
        }
        User userV = ch3.n().v(getId());
        if (userV != null) {
            return userV.getAvatar();
        }
        String strM = zb2.O().M(getJid());
        return TextUtils.isEmpty(strM) ? "" : strM;
    }

    public int getDSStatus() {
        return this.dSStatus;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getDraftMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IGroupPeopleInfo
    public long getEnterTime() {
        return this.enterTime;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Object getFlag() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IPeopleInfo
    public String getId() {
        return WearUtils.g0(getJid());
    }

    public String getJid() {
        return this.jid;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getLastMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public BaseEntity getLastOfficialNotice() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public List<Toy> getLinkedToys2() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getMoodMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember
    public String getNickName() {
        String str = this.nickName;
        if (str != null) {
            return str;
        }
        User userV = ch3.n().v(getId());
        return (userV == null || !userV.isShowInFriendsList() || TextUtils.isEmpty(userV.getRemark())) ? this.nickName : userV.getRemark();
    }

    public int getOpenfireStatus() {
        if (WearUtils.e1(this.openfireStatus) || this.openfireStatus.equals("chat")) {
            return 1;
        }
        if (this.openfireStatus.equals("dnd")) {
            return 2;
        }
        return this.openfireStatus.equals("away") ? 3 : 1;
    }

    public String getPhoto() {
        return this.photo;
    }

    public String getRealNickName() {
        String str = this.nickName;
        return str == null ? "" : str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getRemark() {
        return null;
    }

    public boolean getScStatus() {
        return (WearUtils.e1(this.scStatus) || this.scStatus.equals("not_buys") || !this.scStatus.equals("buys")) ? false : true;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getSetTop() {
        return 0L;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    /* renamed from: getShowName */
    public String getShowNickName() {
        return getNickName();
    }

    public int getStatus() {
        return this.status;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Presence.Mode getStatusMode() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getTempName() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return 0;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getToyStatus() {
        return null;
    }

    public ArrayList<Toy> getToys() {
        ArrayList<Toy> arrayList = this.toys;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getUserJid() {
        return getJid();
    }

    @Override // com.wear.bean.handlerbean.IGroupPeopleInfo, com.wear.bean.handlerbean.IPeopleInfo
    public String getUserName() {
        return getNickName();
    }

    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IGroupPeopleInfo
    public boolean isAdmin() {
        int i = this.affiliation;
        return 10 == i || 20 == i;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isDateIng() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isExit() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isFriend() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isGroup() {
        return false;
    }

    public boolean isOnLine() {
        return this.onLine;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isOnline() {
        return isOnLine();
    }

    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IGroupPeopleInfo
    public boolean isOwrn() {
        return 10 == this.affiliation;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isShowInFriendsList() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String isSupportGroup() {
        return null;
    }

    public boolean isSupportMultiToOne() {
        return this.supportMultiToOne;
    }

    public boolean realOnline() {
        return isOnLine() && getOpenfireStatus() != 3;
    }

    public void setAffiliation(int i) {
        this.affiliation = i;
    }

    public void setDSStatus(int i) {
        this.dSStatus = i;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setDraftMessage(CommunMessage communMessage) {
    }

    public void setEnterTime(long j) {
        this.enterTime = j;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setFlag(Object obj) {
    }

    public void setJid(String str) {
        this.jid = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastMessage(CommunMessage communMessage) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastOfficialNotice(BaseEntity baseEntity) {
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOnLine(boolean z) {
        this.onLine = z;
    }

    public void setOpenfireStatus(String str) {
        this.openfireStatus = str;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember
    public void setPermission(int i) {
        setAffiliation(i);
    }

    public void setPhoto(String str) {
        this.photo = str;
    }

    public void setRealToy(ArrayList<Toy> arrayList) {
        this.toys = arrayList;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setRemark(String str) {
    }

    public void setScStatus(String str) {
        this.scStatus = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setSetTop(long j) {
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSupportMultiToOne(boolean z) {
        this.supportMultiToOne = z;
    }

    public void setToys(List<SyncLinkToy.ToysBean> list) {
        if (list == null) {
            ArrayList<Toy> arrayList = this.toys;
            if (arrayList == null) {
                this.toys = new ArrayList<>();
                return;
            } else {
                arrayList.clear();
                return;
            }
        }
        ArrayList<Toy> arrayList2 = new ArrayList<>();
        for (SyncLinkToy.ToysBean toysBean : list) {
            if (!WearUtils.e1(toysBean.getId()) && "true".equals(toysBean.getStatus())) {
                Toy toy = new Toy();
                toy.setDeviceId(toysBean.getId());
                tu1.a(toy);
                try {
                    toy.setVersion(Integer.valueOf(Integer.parseInt(toysBean.getType().split(";")[0].split(SignatureImpl.INNER_SEP)[1])));
                } catch (Exception unused) {
                }
                toy.setName(jf3.b(toysBean.getType()));
                toy.synNameToType();
                toy.setStatus(WearUtils.y1(toysBean.getStatus()) ? 1 : 0);
                toy.setBattery(toysBean.getBattery());
                toy.setIsSelect(Integer.valueOf(toysBean.isControl() ? 1 : 0));
                toy.setWorkMode(toysBean.getWorkMode());
                try {
                    toy.setVersion(Integer.valueOf(Integer.parseInt(toysBean.getfVersion())));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                arrayList2.add(toy);
            }
        }
        this.toys = arrayList2;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean showBykey(String str) {
        String userName;
        User userV = ch3.n().v(getId());
        if (userV == null || !userV.isShowInFriendsList()) {
            userName = this.nickName;
        } else {
            String remark = userV.getRemark();
            if (TextUtils.isEmpty(remark)) {
                String str2 = this.nickName;
                if (!TextUtils.isEmpty(str2) && str2.toLowerCase().contains(str.toLowerCase())) {
                    return true;
                }
            } else if (remark.toLowerCase().contains(str.toLowerCase())) {
                return true;
            }
            userName = userV.getUserName();
        }
        return !TextUtils.isEmpty(userName) && userName.toLowerCase().contains(str.toLowerCase());
    }

    public boolean showBykeyWithNickName(String str) {
        String nickName = getNickName();
        return !TextUtils.isEmpty(nickName) && nickName.toLowerCase().contains(str.toLowerCase());
    }
}
