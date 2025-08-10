package com.wear.dao;

import com.wear.bean.AccountSetting;
import com.wear.bean.Alarm;
import com.wear.bean.AlarmListItems;
import com.wear.bean.BackWork;
import com.wear.bean.MessageHide;
import com.wear.bean.MessageUnRead;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.bean.Orgy;
import com.wear.bean.Pattern;
import com.wear.bean.Playlist;
import com.wear.bean.Setting;
import com.wear.bean.SwitchBean;
import com.wear.bean.ToyStrength;
import com.wear.bean.UserSetting;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import dc.lp1;
import dc.nd3;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class EmailChangeAction {
    private final String newEmail;
    private final String oldEmail;

    public EmailChangeAction(String str, String str2) {
        this.oldEmail = str;
        this.newEmail = str2;
    }

    private void updateAccountSettingConfig() {
        List<AccountSetting> listFindByEmail = DaoUtils.getAccountSettingDao().findByEmail(this.oldEmail);
        Iterator<AccountSetting> it = listFindByEmail.iterator();
        while (it.hasNext()) {
            it.next().setUserId(this.newEmail);
        }
        DaoUtils.getAccountSettingDao().update(listFindByEmail);
    }

    private void updateAlarmConfig() {
        List<Alarm> listFindByEmail = DaoUtils.getAlarmDao().findByEmail(this.oldEmail);
        Iterator<Alarm> it = listFindByEmail.iterator();
        while (it.hasNext()) {
            it.next().setOwnerEmail(this.newEmail);
        }
        DaoUtils.getAlarmDao().update(listFindByEmail);
        List<AlarmListItems> listFindAlarmList = DaoUtils.getAlarmListDao().findAlarmList(this.oldEmail);
        Iterator<AlarmListItems> it2 = listFindAlarmList.iterator();
        while (it2.hasNext()) {
            it2.next().setOwnerEmail(this.newEmail);
        }
        DaoUtils.getAlarmListDao().update(listFindAlarmList);
    }

    private void updateBackWorkConfig() {
        List<BackWork> works = DaoUtils.getBackWorkDao().getWorks(this.oldEmail);
        Iterator<BackWork> it = works.iterator();
        while (it.hasNext()) {
            it.next().setOwner(this.newEmail);
        }
        DaoUtils.getBackWorkDao().update(works);
    }

    private void updateCommunMessageConfig() {
        List<CommunMessage> listFindByEmails = DaoUtils.getCommunMessageDao().findByEmails(WearUtils.i0(this.oldEmail));
        for (CommunMessage communMessage : listFindByEmails) {
            communMessage.setUserId(WearUtils.i0(this.newEmail));
            if (communMessage.getFrom().equals(WearUtils.i0(this.oldEmail))) {
                communMessage.setFrom(WearUtils.i0(this.newEmail));
            }
            if (communMessage.getTo().equals(WearUtils.i0(this.oldEmail))) {
                communMessage.setTo(WearUtils.i0(this.newEmail));
            }
        }
        DaoUtils.getCommunMessageDao().update(listFindByEmails);
    }

    private void updateGroupCommunMessageConfig() {
        List<CommunMessage> listFindGroupFriend = DaoUtils.getCommunMessageDao().findGroupFriend(WearUtils.i0(this.oldEmail), WearUtils.i0(this.oldEmail));
        for (CommunMessage communMessage : listFindGroupFriend) {
            communMessage.setUserId(WearUtils.i0(this.newEmail));
            if (communMessage.getFrom().equals(WearUtils.i0(this.oldEmail))) {
                communMessage.setFrom(WearUtils.i0(this.newEmail));
            }
            communMessage.setRealFrom(WearUtils.i0(this.newEmail));
        }
        DaoUtils.getCommunMessageDao().update(listFindGroupFriend);
    }

    private void updateMessageHideConfig() {
        List<MessageHide> ownerHides = DaoUtils.getMessageHideDao().getOwnerHides(WearUtils.i0(this.oldEmail));
        Iterator<MessageHide> it = ownerHides.iterator();
        while (it.hasNext()) {
            it.next().setOwnerJid(WearUtils.i0(this.newEmail));
        }
        DaoUtils.getMessageHideDao().update(ownerHides);
    }

    private void updateMusicConfig() {
        List<MusicPlaylist> listFindByEmail = DaoUtils.getMusicPlaylistDao().findByEmail(this.oldEmail);
        Iterator<MusicPlaylist> it = listFindByEmail.iterator();
        while (it.hasNext()) {
            it.next().setEmail(this.newEmail);
        }
        DaoUtils.getMusicPlaylistDao().update(listFindByEmail);
        List<MusicPlaylistItems> listFindByEmail2 = DaoUtils.getMusicPlaylistItemsDao().findByEmail(this.oldEmail);
        Iterator<MusicPlaylistItems> it2 = listFindByEmail2.iterator();
        while (it2.hasNext()) {
            it2.next().setEmail(this.newEmail);
        }
        DaoUtils.getMusicPlaylistItemsDao().update(listFindByEmail2);
    }

    private void updateOrgyConfig() {
        List<Orgy> userIdList = DaoUtils.getOrgyDao().getUserIdList(this.oldEmail);
        if (userIdList != null) {
            for (Orgy orgy : userIdList) {
                DaoUtils.getOrgyDao().delT(orgy);
                orgy.setId(this.newEmail);
                DaoUtils.getOrgyDao().updateOrAdd(orgy);
            }
        }
    }

    private void updatePatternConfig() {
        List<Pattern> listFindPatternsByEmail = DaoUtils.getPatternDao().findPatternsByEmail(this.oldEmail);
        Iterator<Pattern> it = listFindPatternsByEmail.iterator();
        while (it.hasNext()) {
            it.next().setEmail(this.newEmail);
        }
        DaoUtils.getPatternDao().update(listFindPatternsByEmail);
        List<Pattern> listFindPatternsByCreator = DaoUtils.getPatternDao().findPatternsByCreator(this.oldEmail);
        Iterator<Pattern> it2 = listFindPatternsByCreator.iterator();
        while (it2.hasNext()) {
            it2.next().setCreator(this.newEmail);
        }
        DaoUtils.getPatternDao().update(listFindPatternsByCreator);
    }

    private void updatePlayListConfig() {
        List<Playlist> listFindByEmail = DaoUtils.getPlaylistDao().findByEmail(this.oldEmail);
        Iterator<Playlist> it = listFindByEmail.iterator();
        while (it.hasNext()) {
            it.next().setEmail(this.newEmail);
        }
        DaoUtils.getPlaylistDao().update(listFindByEmail);
    }

    private void updateSettingConfig() {
        Setting settingFindById = DaoUtils.getSettingDao().findById(this.oldEmail);
        if (settingFindById != null) {
            DaoUtils.getSettingDao().delT(settingFindById);
            settingFindById.setId(this.newEmail);
            DaoUtils.getSettingDao().updateOrAdd(settingFindById);
        }
    }

    private void updateSwitchConfig() {
        List<SwitchBean> listFindByEmail = DaoUtils.getSwitchDao().findByEmail(this.oldEmail);
        if (listFindByEmail != null) {
            Iterator<SwitchBean> it = listFindByEmail.iterator();
            while (it.hasNext()) {
                it.next().setOwner(this.newEmail);
            }
        }
        DaoUtils.getSwitchDao().update(listFindByEmail);
    }

    private void updateToyConfig() {
        lp1.a.f(this.oldEmail, this.newEmail);
    }

    private void updateToyStrengthConfig() {
        List<ToyStrength> listFindAll = DaoUtils.getToyStrengthDao().findAll();
        if (listFindAll != null) {
            for (ToyStrength toyStrength : listFindAll) {
                DaoUtils.getToyStrengthDao().delT(toyStrength);
                toyStrength.setId(this.newEmail);
                DaoUtils.getToyStrengthDao().updateOrAdd(toyStrength);
            }
        }
    }

    private void updateUnreadMessageConfig() {
        try {
            String str = "消息未读加密前" + WearUtils.i0(this.oldEmail) + "消息未读加密后" + nd3.p(WearUtils.i0(this.oldEmail));
            List<MessageUnRead> allLoginUserUnReads = DaoUtils.getMessageUnReadDao().getAllLoginUserUnReads(WearUtils.i0(this.oldEmail));
            if (allLoginUserUnReads == null || allLoginUserUnReads.size() <= 0) {
                return;
            }
            Iterator<MessageUnRead> it = allLoginUserUnReads.iterator();
            while (it.hasNext()) {
                it.next().setOwnerJid(WearUtils.i0(this.newEmail));
            }
            DaoUtils.getMessageUnReadDao().update(allLoginUserUnReads);
        } catch (Exception e) {
            String str2 = "错误===" + e;
            e.printStackTrace();
        }
    }

    private void updateUserSettingConfig() {
        List<UserSetting> listFindUserSettingsByUserId = DaoUtils.getUserSettingDao().findUserSettingsByUserId(this.oldEmail);
        Iterator<UserSetting> it = listFindUserSettingsByUserId.iterator();
        while (it.hasNext()) {
            it.next().setUserId(this.newEmail);
        }
        DaoUtils.getUserSettingDao().update(listFindUserSettingsByUserId);
    }

    public void execute() {
        String str = "新邮箱===" + this.newEmail + "旧邮箱===" + this.oldEmail;
        updateToyConfig();
        updateAccountSettingConfig();
        updateAlarmConfig();
        updateMusicConfig();
        updateBackWorkConfig();
        updatePatternConfig();
        updateUserSettingConfig();
        updateCommunMessageConfig();
        updateGroupCommunMessageConfig();
        updatePlayListConfig();
        updateMessageHideConfig();
        updateSettingConfig();
        updateOrgyConfig();
        updateToyStrengthConfig();
        updateUnreadMessageConfig();
        updateSwitchConfig();
    }
}
