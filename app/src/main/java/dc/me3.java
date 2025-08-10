package dc;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.bean.FirebaseToyInfo;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: FirebaseLogUtils.java */
/* loaded from: classes4.dex */
public class me3 {

    /* compiled from: FirebaseLogUtils.java */
    public enum a {
        PRIVATE_CHAT_LIVE_CONTROL("1v1 live control"),
        PRIVATE_CHAT_SYNC_CONTROL("1v1 sync control"),
        PRIVATE_CHAT_VIDEO_CONTROL("1v1 video control"),
        PRIVATE_CHAT_VOICE_CONTROL("1v1 voice control"),
        GROUP_CHAT_SYNC_CONTROL("group sync control"),
        GROUP_CHAT_DS_CONTROL("group D&S control"),
        CONTROL_LINK_CHAT_LIVE_CONTROL("control link live control"),
        CONTROL_LINK_CHAT_SYNC_CONTROL("control link sync control"),
        REMOTE_CONTROL("remote control"),
        PATTERN_PLAY("pattern"),
        SOUND_CONTROL("soundControl"),
        MUSIC_PLAY("music"),
        SPEED_MODE("speed mode"),
        OTHERS("others");

        private String value;

        a(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* compiled from: FirebaseLogUtils.java */
    public enum b {
        USER_ID("userId"),
        TOY_INFO("toyInfo"),
        BUSINESS_SCENE("businessScene");

        private String key;

        b(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }
    }

    /* compiled from: FirebaseLogUtils.java */
    public enum c {
        HOME_UI_ENTER("homeUIEnter"),
        LONG_DISTANCE_UI_ENTER("longDistanceUIEnter"),
        DISCOVER_UI_ENTER("discoverUIEnter"),
        ME_UI_ENTER("meUIEnter"),
        MY_TOYS_LIST_UI_ENTER("myToysListUIEnter"),
        MY_TOYS_LIST_UI_EXIT("myToysListUIExit"),
        SEARCH_TOYS_START("searchToysStart"),
        SEARCH_TOYS_STOP("searchToysStop"),
        REMOTE_CONTROL_UI_ENTER("remoteControlUIEnter"),
        REMOTE_CONTROL_UI_EXIT("remoteControlUIExit"),
        MY_PATTERNS_UI_ENTER("myPatternsUIEnter"),
        MY_PATTERNS_UI_EXIT("myPatternsUIExit"),
        MUSIC_UI_ENTER("musicUIEnter"),
        MUSIC_UI_EXIT("musicUIExit"),
        ALARM_UI_ENTER("alarmUIEnter"),
        ALARM_UI_EXIT("alarmUIExit"),
        SOUND_UI_ENTER("soundUIEnter"),
        SOUND_UI_EXIT("soundUIExit"),
        MY_PATTERNS_PLAY_UI_ENTER("myPatternsPlayUIEnter"),
        MY_PATTERNS_PLAY_UI_EXIT("myPatternsPlayUIExit"),
        PRIVATE_CHAT_UI_ENTER("privateChatUIEnter"),
        PRIVATE_CHAT_UI_EXIT("privateChatUIExit"),
        CONTROL_LINK_CHAT_UI_ENTER("controllinkChatUIEnter"),
        CONTROL_LINK_CHAT_UI_EXIT("controllinkChatUIExit"),
        DATING_CHAT_UI_ENTER("datingChatUIEnter"),
        DATING_CHAT_UI_EXIT("datingChatUIExit"),
        GROUP_CHAT_UI_ENTER("groupChatUIEnter"),
        GROUP_CHAT_UI_EXIT("groupChatUIExit"),
        PATTERN_STORE_UI_ENTER("patternStoreUIEnter"),
        PATTERN_STORE_UI_EXIT("patternStoreUIExit"),
        SPEED_MODE_UI_ENTER("speedModeUIEnter"),
        SPEED_MODE_UI_EXIT("speedModeUIExit"),
        CONTROL_LINK_UI_ENTER("controlLinkUIEnter"),
        CONTROL_LINK_UI_EXIT("controlLinkUIExit"),
        WISH_LIST_UI_ENTER("wishListUIEnter"),
        WISH_LIST_UI_EXIT("wishListUIExit"),
        GIFT_UI_ENTER("giftUIEnter"),
        GIFT_UI_EXIT("giftUIExit"),
        LOGIN_UI_ENTER("loginUIEnter"),
        LOGIN_SUCCESS("loginSuccess"),
        ME_PROFILE_UI_ENTER("meProfileUIEnter"),
        ME_PROFILE_UI_EXIT("meProfileUIExit"),
        ME_SETTINGS_UI_ENTER("meSettingsUIEnter"),
        ME_SETTINGS_UI_EXIT("meSettingsUIExit"),
        ME_PRIVACY_UI_ENTER("mePrivacyUIEnter"),
        ME_PRIVACY_UI_EXIT("mePrivacyUIExit"),
        ME_ABOUT_UI_ENTER("meAboutUIEnter"),
        ME_ABOUT_UI_EXIT("meAboutUIExit"),
        ME_HELP_UI_ENTER("meHelpUIEnter"),
        ME_HELP_UI_EXIT("meHelpUIExit"),
        LOGOUT_CLICK("logoutClick"),
        LOGOUT_SUCCESS("logoutSuccess"),
        PRIVATE_CHAT_LIVE_CONTROL_BEGIN("privateChatLiveControlBegin"),
        PRIVATE_CHAT_LIVE_CONTROL_END("privateChatLiveControlEnd"),
        PRIVATE_CHAT_SYNC_CONTROL_MIRROR_BEGIN("privateChatSyncControlMirrorBegin"),
        PRIVATE_CHAT_SYNC_CONTROL_NORMAL_BEGIN("privateChatSyncControlNormalBegin"),
        PRIVATE_CHAT_SYNC_CONTROL_SENCE_BEGIN("privateChatSyncControlSenceBegin"),
        PRIVATE_CHAT_SYNC_CONTROL_PATTERN_BEGIN("privateChatSyncControlPatternBegin"),
        PRIVATE_CHAT_SYNC_CONTROL_END("privateChatSyncControlEnd"),
        PRIVATE_CHAT_VIDEO_CONTROL_REMOTE_BEGIN("privateChatVideoControlRemoteBegin"),
        PRIVATE_CHAT_VIDEO_CONTROL_SENCE_BEGIN("privateChatVideoControlSenceBegin"),
        PRIVATE_CHAT_VIDEO_CONTROL_END("privateChatVideoControlEnd"),
        PRIVATE_CHAT_VOICE_CONTROL_REMOTE_BEGIN("privateChatVoiceControlRemoteBegin"),
        PRIVATE_CHAT_VOICE_CONTROL_SENCE_BEGIN("privateChatVoiceControlSenceBegin"),
        PRIVATE_CHAT_VOICE_CONTROL_END("privateChatVoiceControlEnd"),
        GROUP_CHAT_SYNC_CONTROL_MIRROR_BEGIN("groupChatSyncControlMirrorBegin"),
        GROUP_CHAT_SYNC_CONTROL_SENCE_BEGIN("groupChatSyncControlSenceBegin"),
        GROUP_CHAT_SYNC_CONTROL_PATTERN_BEGIN("groupChatSyncControlPatternBegin"),
        GROUP_CHAT_SYNC_CONTROL_END("groupChatSyncControlEnd"),
        GROUP_CHAT_DS_CONTROL_BEGIN("groupChatDAndSControlBegin"),
        GROUP_CHAT_DS_CONTROL_SENDER_MODE("groupChatDAndSControlSenderMode"),
        GROUP_CHAT_DS_CONTROL_RECIVER_MODE("groupChatDAndSControlReciverMode"),
        GROUP_CHAT_DS_CONTROL_PATTERN_BEGIN("groupChatDAndSControlPatternBegin"),
        GROUP_CHAT_DS_CONTROL_END("groupChatDAndSControlEnd"),
        CONTROL_LINK_LIVE_CONTROL_BEGIN("controllinkLiveControlBegin"),
        CONTROL_LINK_LIVE_CONTROL_END("controllinkLiveControlEnd"),
        CONTROL_LINK_SYNC_CONTROL_MIRROR_BEGIN("controllinkSyncControlMirrorBegin"),
        CONTROL_LINK_SYNC_CONTROL_NORMAL_BEGIN("controllinkSyncControlNormalBegin"),
        CONTROL_LINK_SYNC_CONTROL_SENCE_BEGIN("controllinkSyncControlSenceBegin"),
        CONTROL_LINK_SYNC_CONTROL_PATTERN_BEGIN("controllinkSyncControlPatternBegin"),
        CONTROL_LINK_SYNC_CONTROL_END("controllinkSyncControlEnd"),
        DATING_LIVE_CONTROL_BEGIN("datingLiveControlBegin"),
        DATING_LIVE_CONTROL_END("datingLiveControlEnd"),
        DATING_SYNC_CONTROL_NORMAL_BEGIN("datingSyncControlNormalBegin"),
        DATING_SYNC_CONTROL_MIRROR_BEGIN("datingSyncControlMirrorBegin"),
        DATING_SYNC_CONTROL_SENCE_BEGIN("datingSyncControlSenceBegin"),
        DATING_SYNC_CONTROL_PATTERN_BEGIN("datingSyncControlPatternBegin"),
        DATING_SYNC_CONTROL_END("datingSyncControlEnd");

        private String value;

        c(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static String a() {
        return WearUtils.A.toJson(b(pc1.a.o()));
    }

    public static List<FirebaseToyInfo> b(List<Toy> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Toy toy : list) {
                arrayList.add(new FirebaseToyInfo(toy.getDeviceType(), Integer.valueOf(toy.getBattery()), Boolean.valueOf(toy.isConnected()), Boolean.valueOf(toy.isConnected()), Integer.valueOf(toy.getDisConnectType())));
            }
        }
        return arrayList;
    }

    public static void c(c cVar) {
        FirebaseCrashlytics.getInstance().log(cVar.getValue());
        String str = "log: " + cVar.getValue();
    }

    public static void d(c cVar, String str) {
        FirebaseCrashlytics.getInstance().log(cVar.getValue() + SignatureImpl.INNER_SEP + str);
        String str2 = "log:  " + cVar.getValue() + ":  " + str;
    }

    public static void e(a aVar) {
        f(b.BUSINESS_SCENE, aVar.getValue());
        String str = "setBusinessCustomKey:" + aVar.getValue();
    }

    public static void f(b bVar, String str) {
        FirebaseCrashlytics.getInstance().setCustomKey(bVar.getKey(), str);
    }

    public static void g() {
        f(b.TOY_INFO, a());
        String str = "setToyInfoCustomKey:" + a();
    }

    public static void h(String str) {
        f(b.USER_ID, str);
        FirebaseCrashlytics.getInstance().setUserId(str);
        String str2 = "setUserCustomKey:" + str;
    }
}
