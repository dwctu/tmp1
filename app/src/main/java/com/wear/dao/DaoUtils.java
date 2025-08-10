package com.wear.dao;

import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.wear.bean.Alarm;
import com.wear.bean.AlarmListItems;
import com.wear.bean.BackWork;
import com.wear.bean.MessageHide;
import com.wear.bean.MessageUnRead;
import com.wear.bean.NewAccountBean;
import com.wear.bean.Pattern;
import com.wear.bean.Playlist;
import com.wear.bean.UserSetting;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.nd3;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DaoUtils {
    public static AccountSettingDao accountSettingDao;
    public static AccountDao accoutDao;
    public static AlarmDao alarmDao;
    public static AlarmListDao alarmListDao;
    public static AlarmPatternDao alarmPatternDao;
    private static AudioBookListDao audioBookListDao;
    private static AudioBookTagDao audioBookTagDao;
    public static BackWorkDao backWorkDao;
    private static ChatGPTPatternDao chatGPTPatternDao;
    private static ChatGPTStoryDao chatGPTStoryDao;
    public static ChatMessageConfigDao chatMessageConfigDao;
    public static ChatMessageDao chatMessageDao;
    public static ChatRoomSensitiveDao chatRoomSensitiveDao;
    public static CommunMessageDao communMessageDao;
    public static CommunMessageMigDao communMessageMigDao;
    public static ControlLinkCommunMessageDao controlLinkCommunMessageDao;
    public static EmojiFavoriteDao emojiFavoriteDao;
    public static GiftCardDao giftCardDao;
    public static HotPoingDao hotPoingDao;
    public static LogDao logDao;
    public static MediaPatternDao mediaPatternDao;
    public static MergerMusicDao mergerMusicDao;
    public static MessageHideDao messageHideDao;
    public static MessageHideMigDao messageHideMigDao;
    public static MessageUnReadDao messageUnReadDao;
    public static MessageUnReadMigDao messageUnReadMigDao;
    public static MusicDao musicDao;
    public static MusicPlaylistDao musicPlaylistDao;
    public static MusicPlaylistItemsDao musicPlaylistItemsDao;
    public static MusicSpotifyDao musicSpotifyDao;
    private static OfficialMessageDao officialaMessageDao;
    public static OrgyDao orgyDao;
    public static OrgyLogDao orgyLogDao;
    public static PatternDao patternDao;
    public static PlaylistDao playlistDao;
    public static PlaylistItemsDao playlistItemsDao;
    public static ProgramPatternDao programPatternDao;
    public static ReCallDao reCallDao;
    public static RemoteGuideVibematedDao remoteGuideVibematedDao;
    public static RouletteUserDao rouletteUserDao;
    public static SensitiveWordDao sensitiveWordDao;
    public static SettingDao settingDao;
    public static SwitchDao switchDao;
    public static TestValueDao testValueDao;
    public static ToyDao toyDao;
    public static ToyPinStatusDao toyPinStatusDao;
    public static ToyRenameDao toyRenameDao;
    public static ToyStrengthDao toyStrengthDao;
    public static ToyTypeDao toyTypeDao;
    public static UserDao userDao;
    public static UserSettingDao userSettingDao;

    private static void executeEmailChangeAction(LoginUserBean loginUserBean, NewAccountBean newAccountBean) {
        String email = loginUserBean.getEmail();
        new EmailChangeAction(WearUtils.X(nd3.f(newAccountBean.getEmail())), email).execute();
        newAccountBean.setEmail(nd3.p(WearUtils.i0(email)));
        getAccoutDao().update((AccountDao) newAccountBean);
    }

    public static AccountSettingDao getAccountSettingDao() {
        if (accountSettingDao == null) {
            accountSettingDao = new AccountSettingDao();
        }
        return accountSettingDao;
    }

    public static AccountDao getAccoutDao() {
        if (accoutDao == null) {
            accoutDao = new AccountDao();
        }
        return accoutDao;
    }

    public static AlarmDao getAlarmDao() {
        if (alarmDao == null) {
            alarmDao = new AlarmDao();
        }
        return alarmDao;
    }

    public static AlarmListDao getAlarmListDao() {
        if (alarmListDao == null) {
            alarmListDao = new AlarmListDao();
        }
        return alarmListDao;
    }

    public static AlarmPatternDao getAlarmPatternDao() {
        if (alarmPatternDao == null) {
            alarmPatternDao = new AlarmPatternDao();
        }
        return alarmPatternDao;
    }

    public static AudioBookListDao getAudioBookListDao() {
        if (audioBookListDao == null) {
            audioBookListDao = new AudioBookListDao();
        }
        return audioBookListDao;
    }

    public static AudioBookTagDao getAudioBookTagDao() {
        if (audioBookTagDao == null) {
            audioBookTagDao = new AudioBookTagDao();
        }
        return audioBookTagDao;
    }

    public static BackWorkDao getBackWorkDao() {
        if (backWorkDao == null) {
            backWorkDao = new BackWorkDao();
        }
        return backWorkDao;
    }

    public static ChatGPTPatternDao getChatGPTPatternDao() {
        if (chatGPTPatternDao == null) {
            chatGPTPatternDao = new ChatGPTPatternDao();
        }
        return chatGPTPatternDao;
    }

    public static ChatGPTStoryDao getChatGPTStoryDao() {
        if (chatGPTStoryDao == null) {
            chatGPTStoryDao = new ChatGPTStoryDao();
        }
        return chatGPTStoryDao;
    }

    public static ChatMessageConfigDao getChatMessageConfigDao() {
        if (chatMessageConfigDao == null) {
            chatMessageConfigDao = new ChatMessageConfigDao();
        }
        return chatMessageConfigDao;
    }

    public static ChatMessageDao getChatMessageDao() {
        if (chatMessageDao == null) {
            chatMessageDao = new ChatMessageDao();
        }
        return chatMessageDao;
    }

    public static ChatRoomSensitiveDao getChatRoomSensitiveDao() {
        if (chatRoomSensitiveDao == null) {
            chatRoomSensitiveDao = new ChatRoomSensitiveDao();
        }
        return chatRoomSensitiveDao;
    }

    public static CommunMessageDao getCommunMessageDao() {
        if (communMessageDao == null) {
            communMessageDao = new CommunMessageDao();
        }
        return communMessageDao;
    }

    public static CommunMessageMigDao getCommunMessageMigDao() {
        if (communMessageMigDao == null) {
            communMessageMigDao = new CommunMessageMigDao();
        }
        return communMessageMigDao;
    }

    public static ControlLinkCommunMessageDao getControlLinkCommunMessageDao() {
        if (controlLinkCommunMessageDao == null) {
            controlLinkCommunMessageDao = new ControlLinkCommunMessageDao();
        }
        return controlLinkCommunMessageDao;
    }

    public static EmojiFavoriteDao getEmojiFavoriteDao() {
        if (emojiFavoriteDao == null) {
            emojiFavoriteDao = new EmojiFavoriteDao();
        }
        return emojiFavoriteDao;
    }

    public static GiftCardDao getGiftCardDao() {
        if (giftCardDao == null) {
            giftCardDao = new GiftCardDao();
        }
        return giftCardDao;
    }

    public static HotPoingDao getHotPoingDao() {
        if (hotPoingDao == null) {
            hotPoingDao = new HotPoingDao();
        }
        return hotPoingDao;
    }

    public static LogDao getLogDao() {
        if (logDao == null) {
            logDao = new LogDao();
        }
        return logDao;
    }

    public static MediaPatternDao getMediaPatternDao() {
        if (mediaPatternDao == null) {
            mediaPatternDao = new MediaPatternDao();
        }
        return mediaPatternDao;
    }

    public static MergerMusicDao getMergerMusicDao() {
        if (mergerMusicDao == null) {
            mergerMusicDao = new MergerMusicDao();
        }
        return mergerMusicDao;
    }

    public static MessageHideDao getMessageHideDao() {
        if (messageHideDao == null) {
            messageHideDao = new MessageHideDao();
        }
        return messageHideDao;
    }

    public static MessageHideMigDao getMessageHideMigDao() {
        if (messageHideMigDao == null) {
            messageHideMigDao = new MessageHideMigDao();
        }
        return messageHideMigDao;
    }

    public static MessageUnReadDao getMessageUnReadDao() {
        if (messageUnReadDao == null) {
            messageUnReadDao = new MessageUnReadDao();
        }
        return messageUnReadDao;
    }

    public static MessageUnReadMigDao getMessageUnReadMigDao() {
        if (messageUnReadMigDao == null) {
            messageUnReadMigDao = new MessageUnReadMigDao();
        }
        return messageUnReadMigDao;
    }

    public static MusicDao getMusicDao() {
        if (musicDao == null) {
            musicDao = new MusicDao();
        }
        return musicDao;
    }

    public static MusicPlaylistDao getMusicPlaylistDao() {
        if (musicPlaylistDao == null) {
            musicPlaylistDao = new MusicPlaylistDao();
        }
        return musicPlaylistDao;
    }

    public static MusicPlaylistItemsDao getMusicPlaylistItemsDao() {
        if (musicPlaylistItemsDao == null) {
            musicPlaylistItemsDao = new MusicPlaylistItemsDao();
        }
        return musicPlaylistItemsDao;
    }

    public static MusicSpotifyDao getMusicSpotifyDao() {
        if (musicSpotifyDao == null) {
            musicSpotifyDao = new MusicSpotifyDao();
        }
        return musicSpotifyDao;
    }

    public static OfficialMessageDao getOfficialaMessageDao() {
        if (officialaMessageDao == null) {
            officialaMessageDao = new OfficialMessageDao();
        }
        return officialaMessageDao;
    }

    public static OrgyDao getOrgyDao() {
        if (orgyDao == null) {
            orgyDao = new OrgyDao();
        }
        return orgyDao;
    }

    public static OrgyLogDao getOrgyLogDao() {
        if (orgyLogDao == null) {
            orgyLogDao = new OrgyLogDao();
        }
        return orgyLogDao;
    }

    public static PatternDao getPatternDao() {
        if (patternDao == null) {
            patternDao = new PatternDao();
        }
        return patternDao;
    }

    public static PlaylistDao getPlaylistDao() {
        if (playlistDao == null) {
            playlistDao = new PlaylistDao();
        }
        return playlistDao;
    }

    public static PlaylistItemsDao getPlaylistItemsDao() {
        if (playlistItemsDao == null) {
            playlistItemsDao = new PlaylistItemsDao();
        }
        return playlistItemsDao;
    }

    public static ProgramPatternDao getProgramPatternDao() {
        if (programPatternDao == null) {
            programPatternDao = new ProgramPatternDao();
        }
        return programPatternDao;
    }

    public static ReCallDao getReCallDao() {
        if (reCallDao == null) {
            reCallDao = new ReCallDao();
        }
        return reCallDao;
    }

    public static RemoteGuideVibematedDao getRemoteGuideVibematedDao() {
        if (remoteGuideVibematedDao == null) {
            remoteGuideVibematedDao = new RemoteGuideVibematedDao();
        }
        return remoteGuideVibematedDao;
    }

    public static RouletteUserDao getRouletteUserDao() {
        if (rouletteUserDao == null) {
            rouletteUserDao = new RouletteUserDao();
        }
        return rouletteUserDao;
    }

    public static SensitiveWordDao getSensitiveWordDao() {
        if (sensitiveWordDao == null) {
            sensitiveWordDao = new SensitiveWordDao();
        }
        return sensitiveWordDao;
    }

    public static SettingDao getSettingDao() {
        if (settingDao == null) {
            settingDao = new SettingDao();
        }
        return settingDao;
    }

    public static SwitchDao getSwitchDao() {
        if (switchDao == null) {
            switchDao = new SwitchDao();
        }
        return switchDao;
    }

    public static TestValueDao getTestValueDao() {
        if (testValueDao == null) {
            testValueDao = new TestValueDao();
        }
        return testValueDao;
    }

    public static ToyDao getToyDao() {
        if (toyDao == null) {
            toyDao = new ToyDao();
        }
        return toyDao;
    }

    public static ToyPinStatusDao getToyPinStatusDao() {
        if (toyPinStatusDao == null) {
            toyPinStatusDao = new ToyPinStatusDao();
        }
        return toyPinStatusDao;
    }

    public static ToyRenameDao getToyRenameDao() {
        if (toyRenameDao == null) {
            toyRenameDao = new ToyRenameDao();
        }
        return toyRenameDao;
    }

    public static ToyStrengthDao getToyStrengthDao() {
        if (toyStrengthDao == null) {
            toyStrengthDao = new ToyStrengthDao();
        }
        return toyStrengthDao;
    }

    public static ToyTypeDao getToyTypeDao() {
        if (toyTypeDao == null) {
            toyTypeDao = new ToyTypeDao();
        }
        return toyTypeDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public static UserSettingDao getUserSettingDao() {
        if (userSettingDao == null) {
            userSettingDao = new UserSettingDao();
        }
        return userSettingDao;
    }

    public static void upDateEmail(LoginUserBean loginUserBean) {
        try {
            NewAccountBean remoteAccountId = getAccoutDao().getRemoteAccountId(loginUserBean.getRemoteAccountId());
            if (ch3.n().u() != null) {
                ch3.n().u().setId(loginUserBean.getEmail());
            }
            if (remoteAccountId != null) {
                if (remoteAccountId.getEmail().equals(nd3.p(WearUtils.i0(loginUserBean.getEmail())))) {
                    return;
                }
                executeEmailChangeAction(loginUserBean, remoteAccountId);
            } else {
                NewAccountBean newAccountBean = new NewAccountBean();
                newAccountBean.setEmail(nd3.p(WearUtils.i0(loginUserBean.getEmail())));
                newAccountBean.setRemoteAccountId(loginUserBean.getRemoteAccountId());
                getAccoutDao().updateOrAdd(newAccountBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateFriendEmail(String str, String str2) {
        String str3 = "oldFriendEmail====" + str + "-----newFriendEmail===" + str2;
        List<CommunMessage> listFindFriend = getCommunMessageDao().findFriend(ch3.n().p(), WearUtils.i0(str));
        for (CommunMessage communMessage : listFindFriend) {
            if (communMessage.getFrom().equals(WearUtils.i0(str))) {
                communMessage.setFrom(WearUtils.i0(str2));
            }
            if (communMessage.getTo().equals(WearUtils.i0(str))) {
                communMessage.setTo(WearUtils.i0(str2));
            }
        }
        getCommunMessageDao().update(listFindFriend);
        List<CommunMessage> listFindGroupFriend = getCommunMessageDao().findGroupFriend(ch3.n().p(), WearUtils.i0(str));
        Iterator<CommunMessage> it = listFindGroupFriend.iterator();
        while (it.hasNext()) {
            it.next().setRealFrom(WearUtils.i0(str2));
        }
        getCommunMessageDao().update(listFindGroupFriend);
        List<Alarm> listFindByFriendEmails = getAlarmDao().findByFriendEmails(str);
        Iterator<Alarm> it2 = listFindByFriendEmails.iterator();
        while (it2.hasNext()) {
            it2.next().setFriendEmail(str2);
        }
        getAlarmDao().update(listFindByFriendEmails);
        List<AlarmListItems> listFindFriedndAlarmList = getAlarmListDao().findFriedndAlarmList(str);
        for (AlarmListItems alarmListItems : listFindFriedndAlarmList) {
            alarmListItems.setOwnerEmail(str2);
            alarmListItems.setFriendEmail(str2);
        }
        getAlarmListDao().update(listFindFriedndAlarmList);
        List<Pattern> listFindPatternsByEmail = getPatternDao().findPatternsByEmail(str);
        Iterator<Pattern> it3 = listFindPatternsByEmail.iterator();
        while (it3.hasNext()) {
            it3.next().setEmail(str2);
        }
        getPatternDao().update(listFindPatternsByEmail);
        List<Pattern> listFindPatternsByCreator = getPatternDao().findPatternsByCreator(str);
        Iterator<Pattern> it4 = listFindPatternsByCreator.iterator();
        while (it4.hasNext()) {
            it4.next().setCreator(str2);
        }
        getPatternDao().update(listFindPatternsByCreator);
        List<Playlist> listFindByEmail = getPlaylistDao().findByEmail(str);
        Iterator<Playlist> it5 = listFindByEmail.iterator();
        while (it5.hasNext()) {
            it5.next().setEmail(str2);
        }
        getPlaylistDao().update(listFindByEmail);
        List<MessageHide> friendHides = getMessageHideDao().getFriendHides(WearUtils.j0(str));
        Iterator<MessageHide> it6 = friendHides.iterator();
        while (it6.hasNext()) {
            it6.next().setFriendJid(WearUtils.j0(str2));
        }
        getMessageHideDao().update(friendHides);
        String str4 = "加密前userId" + WearUtils.y.r() + InternalFrame.ID + str;
        String str5 = "加密后userId" + nd3.p(WearUtils.y.r()) + InternalFrame.ID + nd3.p(str);
        UserSetting userSettingFindUserSettingsByUserIdAndFriendUserId = getUserSettingDao().findUserSettingsByUserIdAndFriendUserId(WearUtils.y.r(), str);
        if (userSettingFindUserSettingsByUserIdAndFriendUserId != null) {
            userSettingFindUserSettingsByUserIdAndFriendUserId.setFriendUserId(str2);
            getUserSettingDao().update((UserSettingDao) userSettingFindUserSettingsByUserIdAndFriendUserId);
        }
        List<BackWork> works = getBackWorkDao().getWorks(WearUtils.y.r());
        for (BackWork backWork : works) {
            backWork.setStaticParams(backWork.getStaticParams().replace(WearUtils.i0(str), WearUtils.i0(str2)));
            backWork.setStatus(backWork.getStatus().replace(str, str2));
            backWork.setTargetEmail(WearUtils.i0(str2));
        }
        getBackWorkDao().update(works);
        List<MessageUnRead> unReads = getMessageUnReadDao().getUnReads(WearUtils.i0(WearUtils.y.r()), WearUtils.i0(str));
        if (unReads == null || unReads.size() <= 0) {
            return;
        }
        Iterator<MessageUnRead> it7 = unReads.iterator();
        while (it7.hasNext()) {
            it7.next().setFriendJid(WearUtils.i0(str2));
        }
        getMessageUnReadDao().update(unReads);
    }
}
