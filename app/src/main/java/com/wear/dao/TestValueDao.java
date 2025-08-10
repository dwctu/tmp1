package com.wear.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.table.TableUtils;
import com.wear.bean.MediaPattern;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.bean.TestValue;
import com.wear.bean.User;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.rf3;
import dc.xe2;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;

/* loaded from: classes3.dex */
public class TestValueDao extends BaseDao<TestValue> {
    public static final String CHAT_KEYBOARD_HEIGHT_KEY = "chat_keyboard_height_key";
    public static final String CHAT_KEYBOARD_HEIGHT_TYPE = "chat_keyboard_height_type";
    public static final String CHAT_MIGRATE_KEY = "chat_migrate_key";
    public static final String CHAT_MIGRATE_TYPE = "chat_migrate_type";
    public static final String CHAT_MIGRATE_USERJID_WEARABLE_KEY = "chat_migrate_userjid_wearable_key";
    public static final String CHAT_MIGRATE_USERJID_WEARABLE_TYPE = "chat_migrate_userjid_wearable_type";
    public static final String CHAT_NOTE = "chat_note";
    public static final String CONTROL_LINK_CHAT_NOTE = "cpntrol_link_chat_note";
    public static final String CONTROL_LINK_READ_MSG_RECORD = "control_link_read_msg_record";
    public static final String EMOJI_RECENT_KEY = "emoji_recent_key";
    public static final String EMOJI_RECENT_TYPE = "emoji_recent_type";
    public static final String HOME_BANNER_HIDE = "home_banner_hide";
    public static final String HOME_PLAY_PATTERN_HIS = "HOME_PLAY_PATTERN_HIS";
    public static final String LAN_API_AUTHORIZE_TYPE = "authorizes_lan_api_control_toy_platform";
    public static final String LAN_API_DATA_TYPE = "authorizes_lan_api_control_data";
    public static final String LAN_API_UID_TYPE = "authorizes_lan_api_control_toy_uid";
    public static final String MULTI_TOYS_TIP_KEY = "multi_toys_tip_key";
    public static final String MULTI_TOYS_TIP_TYPE = "multi_toys_tip_type";
    public static final String NINJA_MODE_SWITCH_TYPE = "ninja_mode_switch";
    public static final String NOTIFICATION_RED_DOT_VISIBLE_TYPE = "notification_red_dot";
    public static final String SAVE_KEY_KEEP_SCREEN_KEY = "keepScreenKey";
    public static final String SAVE_KEY_KEEP_SCREEN_TYPE = "keepScreen";
    public static final String SAVE_KEY_KEEP_TOY_AUTOSWITH_TYPE = "toyAutoSwith";
    public static final String SAVE_KEY_KEEP_TOY_LASTLEVEL_TYPE = "toyAutoLastLevel";
    public static final String SAVE_KEY_LAST_LI_KEY = "LastLIKey";
    public static final String SAVE_KEY_LAST_LI_TYPE = "LastLI";
    public static final String SAVE_KEY_TEST_ACCOUNT_TYPE = "0";
    public static final String SAVE_KEY_TEST_SYNC_PATTERN_TIME_TYPE = "2";
    public static final String SAVE_KEY_US_TYPE = "999";
    public static final String SAVE_KEY_VIDEOTOY_RECORD_KEY = "VideoToyRecord";
    public static final String SAVE_KEY_VIDEOTOY_RECORD_TYPE = "1";
    public static final String SEX_MACHINE_TIP_KEY = "sex_machine_tip_key";
    public static final String SEX_MACHINE_TIP_TYPE = "sex_machine_tip_type";
    public static final String SHOW_COMMON_PSW_DIALOG_TYPE = "show_common_psw_dialog_type";
    public static final String SHOW_VERIFY_EMAIL_DIALOG_TYPE = "show_verify_email_dialog_type";
    public static final String SHOW_WEAK_PSW_DIALOG_TYPE = "show_weak_psw_dialog_type";
    public static final String SPOTIFY_TOKEN_DATA_TYPE = "spotify_token_data";

    public void addSyncPatternTimeTag(String str) {
        if (WearUtils.e1(str)) {
            str = OfflineMessageRequest.ELEMENT;
        }
        save(str, str, "2");
    }

    public void cleanRecords() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), TestValue.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String str, String str2) {
        TestValue existKey = getExistKey(nd3.u(str), str2);
        if (existKey != null) {
            delT(existKey);
        }
    }

    public List<TestValue> getAllType(String str) {
        try {
            return this.dao.queryBuilder().orderBy("created", false).where().eq("type", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TestValue getExistKey(String str, String str2) {
        List listQuery;
        try {
            if (WearUtils.e1(str) || WearUtils.e1(str2) || (listQuery = this.dao.queryBuilder().where().eq("type", str2).and().eq("key", str).query()) == null || listQuery.size() <= 0) {
                return null;
            }
            return (TestValue) listQuery.get(0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    public <T> List<User> getUserList(String str) {
        ArrayList arrayList = new ArrayList();
        if (WearUtils.e1(str)) {
            return arrayList;
        }
        TestValue existKey = getExistKey(nd3.u(str), SAVE_KEY_US_TYPE);
        if (existKey != null) {
            String strI = WearUtils.e1(existKey.getValue()) ? "" : nd3.i(existKey.getValue());
            if (WearUtils.e1(strI)) {
                return arrayList;
            }
            try {
                arrayList = (List) new Gson().fromJson(strI, new TypeToken<List<User>>() { // from class: com.wear.dao.TestValueDao.1
                }.getType());
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public String getValue(String str, String str2) {
        String strU = nd3.u(str);
        TestValue existKey = (WearUtils.e1(strU) || WearUtils.e1(str2)) ? null : getExistKey(strU, str2);
        if (existKey == null || WearUtils.e1(existKey.getValue())) {
            return null;
        }
        return nd3.i(existKey.getValue());
    }

    public boolean isSyncPatternTime(String str) {
        if (WearUtils.e1(str)) {
            str = OfflineMessageRequest.ELEMENT;
        }
        return getExistKey(nd3.u(str), "2") != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    public synchronized void resetRecordList() {
        ArrayList<MediaPattern> arrayList = new ArrayList();
        TestValue existKey = getExistKey(nd3.u(SAVE_KEY_VIDEOTOY_RECORD_KEY), "1");
        if (existKey != null) {
            String strI = WearUtils.e1(existKey.getValue()) ? "" : nd3.i(existKey.getValue());
            if (WearUtils.e1(strI)) {
                return;
            } else {
                try {
                    arrayList = (List) new Gson().fromJson(strI, new TypeToken<List<MediaPattern>>() { // from class: com.wear.dao.TestValueDao.2
                    }.getType());
                } catch (Exception unused) {
                }
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (arrayList.size() > 0) {
            for (MediaPattern mediaPattern : arrayList) {
                if (mediaPattern != null && (mediaPattern == null || !WearUtils.e1(mediaPattern.getPatternJson()))) {
                    try {
                        Pattern pattern = (Pattern) WearUtils.A.fromJson(mediaPattern.getPatternJson(), Pattern.class);
                        if (pattern != null) {
                            File fileE0 = WearUtils.e0("temp/" + mediaPattern.getPatternId() + "temp");
                            if (fileE0 != null && fileE0.exists()) {
                                String strN1 = WearUtils.N1(fileE0.getPath());
                                if (rf3.o(strN1)) {
                                    strN1 = rf3.r(strN1);
                                }
                                String strReplace = strN1.replace(PatternHead.P_M_DEF, PatternHead.P_M);
                                Pattern pattern2 = new Pattern();
                                pattern2.setDataNoCheckFormat(strReplace);
                                pattern2.setDataString(strReplace);
                                if (pattern != null && !WearUtils.e1(pattern2.getData()) && pattern2.getData().split(";").length > 0) {
                                    pattern.setTimer(pattern2.calculateTime(pattern2.getData().split(";").length, 100));
                                    WearUtils.l2(pattern.getId(), WearUtils.r0(strReplace));
                                    xe2.L0().t(pattern, true);
                                    DaoUtils.getMediaPatternDao().addIfNotExist(mediaPattern);
                                }
                                fileE0.delete();
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            DaoUtils.getTestValueDao().delete(SAVE_KEY_VIDEOTOY_RECORD_KEY, "1");
        }
    }

    public void save(String str, String str2, String str3) {
        String strU = nd3.u(str);
        String strU2 = nd3.u(str2);
        TestValue existKey = getExistKey(strU, str3);
        if (existKey != null) {
            existKey.setValue(strU2);
            update((TestValueDao) existKey);
            return;
        }
        TestValue testValue = new TestValue();
        testValue.setKey(strU);
        testValue.setValue(strU2);
        testValue.setType(str3);
        add((TestValueDao) testValue);
    }

    public <T> void setDataList(String str, List<T> list, String str2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    save(str, new Gson().toJson(list), str2);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        save(str, "", str2);
    }
}
