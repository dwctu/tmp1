package com.wear.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.wear.bean.AccountSetting;
import com.wear.bean.Alarm;
import com.wear.bean.AlarmListItems;
import com.wear.bean.AlarmPattern;
import com.wear.bean.BackWork;
import com.wear.bean.ChatRoomSensitive;
import com.wear.bean.EmojiFavorite;
import com.wear.bean.GiftCard;
import com.wear.bean.HotPoint;
import com.wear.bean.LogType;
import com.wear.bean.MediaPattern;
import com.wear.bean.MergerMusic;
import com.wear.bean.MessageHide;
import com.wear.bean.MessageHideMig;
import com.wear.bean.MessageUnRead;
import com.wear.bean.MessageUnReadMig;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.bean.MusicSpotify;
import com.wear.bean.NewAccountBean;
import com.wear.bean.Orgy;
import com.wear.bean.OrgyLogBean;
import com.wear.bean.Pattern;
import com.wear.bean.Playlist;
import com.wear.bean.PlaylistItems;
import com.wear.bean.ProgramPattern;
import com.wear.bean.ReCall;
import com.wear.bean.RemoteGuideVibemate;
import com.wear.bean.SensitiveWord;
import com.wear.bean.Setting;
import com.wear.bean.SwitchBean;
import com.wear.bean.TestValue;
import com.wear.bean.ToyPinStatusBean;
import com.wear.bean.ToyRename;
import com.wear.bean.ToyStrength;
import com.wear.bean.ToyType;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageConfig;
import com.wear.bean.chat.RouletteUser;
import com.wear.bean.data.AudioBookList;
import com.wear.bean.data.ChatGPTPatternBean;
import com.wear.bean.data.ChatGPTStoryBean;
import com.wear.bean.data.TagList;
import com.wear.bean.official.OfficialMsg;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.CommunMessageMig;
import com.wear.protocol.ContainBean;
import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ws1;
import dc.xe3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DB_NAME = "wear.db";
    private static final int DB_VERSION = 94;
    private static DatabaseHelper instance;
    private Map<String, Dao> daos;
    private Context mContext;

    private DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 94);
        this.daos = new HashMap();
        this.mContext = context;
    }

    public static DatabaseHelper getHelper() {
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null) {
                    MyApplication myApplication = WearUtils.x;
                    if (myApplication == null) {
                        return null;
                    }
                    instance = new DatabaseHelper(myApplication);
                }
            }
        }
        return instance;
    }

    private void onUpgradeVersion23(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 22) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy add isSelect INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion24(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 23) {
            try {
                sQLiteDatabase.execSQL("alter table tb_message add typeDetail TEXT");
                sQLiteDatabase.execSQL("alter table tb_message add patternId TEXT");
                sQLiteDatabase.execSQL("alter table tb_message add isPlay INTEGER");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion25(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 24) {
            try {
                TableUtils.createTable(connectionSource, Playlist.class);
                TableUtils.createTable(connectionSource, PlaylistItems.class);
                sQLiteDatabase.execSQL("alter table tb_pattern add sortId TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion26(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 25) {
            try {
                sQLiteDatabase.execSQL("alter table tb_music add album TEXT");
                Cursor cursorQuery = this.mContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "album"}, "is_music > 0 and duration > 10000", null, "title_key");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                List<Music> listFindMusicSongIdBy = DaoUtils.getMusicDao().findMusicSongIdBy("" + cursorQuery.getLong(0));
                                if (listFindMusicSongIdBy != null) {
                                    for (Music music : listFindMusicSongIdBy) {
                                        music.setAlbum(cursorQuery.getString(1));
                                        DaoUtils.getMusicDao().update((MusicDao) music);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                }
                TableUtils.createTable(connectionSource, MusicPlaylist.class);
                TableUtils.createTable(connectionSource, MusicPlaylistItems.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion27(ConnectionSource connectionSource, int i) {
        if (i <= 26) {
            try {
                TableUtils.createTable(connectionSource, MergerMusic.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion28(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 27) {
            try {
                TableUtils.createTable(connectionSource, ToyRename.class);
                TableUtils.createTable(connectionSource, ProgramPattern.class);
                TableUtils.createTable(connectionSource, ToyType.class);
                sQLiteDatabase.execSQL("alter table tb_pattern add toyFunc TEXT");
                sQLiteDatabase.execSQL("alter table tb_user_setting add passiveConfig TEXT");
                TableUtils.dropTable(connectionSource, CommunMessage.class, true);
                TableUtils.createTable(connectionSource, CommunMessage.class);
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select * from tb_message", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        ContainBean.onUpgradeDb_27_28(cursorRawQuery);
                    }
                    cursorRawQuery.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion29(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 28) {
            try {
                TableUtils.createTable(connectionSource, Alarm.class);
                TableUtils.createTable(connectionSource, AlarmListItems.class);
                TableUtils.createTable(connectionSource, AlarmPattern.class);
                sQLiteDatabase.execSQL("alter table tb_user_setting add autoPlayAlarm boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion30(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 29) {
            try {
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add ringTime TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion31(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 30) {
            try {
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add ownerEmail TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion32(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 31) {
            try {
                sQLiteDatabase.execSQL("alter table tb_user_setting add audioVibration boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion33(ConnectionSource connectionSource, int i) {
        if (i <= 32) {
            try {
                TableUtils.createTable(connectionSource, LogType.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion34(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 33) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy add ledSetting INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion35(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 34) {
            try {
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add notify INTEGER default -1");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add version INTEGER default 1");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add notiType TEXT");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add soundurl TEXT");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add soundFileath TEXT");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add sendTime TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion36(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 35) {
            try {
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add receiveAlarmId TEXT");
                sQLiteDatabase.execSQL("alter table tb_setting add acceptPrivacyLogs boolean");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add alarmTitle TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion38(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 37) {
            try {
                TableUtils.createTable(connectionSource, HotPoint.class);
                sQLiteDatabase.execSQL("alter table tb_pattern add status TEXT");
                sQLiteDatabase.execSQL("alter table tb_pattern add isOnline boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion39(ConnectionSource connectionSource, int i) {
        if (i <= 38) {
            try {
                TableUtils.createTable(connectionSource, EmojiFavorite.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion40(ConnectionSource connectionSource, int i) {
        if (i <= 39) {
            try {
                TableUtils.createTable(connectionSource, BackWork.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion41(ConnectionSource connectionSource, int i) {
        if (i <= 40) {
            try {
                TableUtils.createTable(connectionSource, MessageHide.class);
                TableUtils.createTable(connectionSource, MessageUnRead.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion42(ConnectionSource connectionSource, int i) {
        if (i <= 41) {
            try {
                TableUtils.createTable(connectionSource, ReCall.class);
                if (i < 41) {
                    TableUtils.createTable(connectionSource, TestValue.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion43(ConnectionSource connectionSource, int i) {
        if (i <= 42) {
            try {
                TableUtils.createTable(connectionSource, SwitchBean.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion44(ConnectionSource connectionSource, int i) {
        if (i <= 43) {
            try {
                TableUtils.createTable(connectionSource, MediaPattern.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion45(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 44) {
            try {
                sQLiteDatabase.execSQL("alter table tb_setting add playMusicModel INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion46(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 45) {
            try {
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add accept INTEGER default 0");
                sQLiteDatabase.execSQL("alter table tb_commun_message add sendType INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion47(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 46) {
            try {
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add snoozeCount INTEGER default 0");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add snoozeDuration INTEGER default 0");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add duration INTEGER default 0");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add haveSnoozeCount INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion48(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 47) {
            try {
                sQLiteDatabase.execSQL("alter table tb_user_setting add friendsRequestClick boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion49(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 48) {
            try {
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add nextTime TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion50(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 49) {
            try {
                sQLiteDatabase.execSQL("alter table tb_user_setting add addTime INTEGER");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion51(ConnectionSource connectionSource, int i) {
        if (i <= 50) {
            try {
                TableUtils.createTable(connectionSource, AccountSetting.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion52(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 51) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy_type add aColor INTEGER default 7");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion53(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 52) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy add simpleToy INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion54(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 53) {
            try {
                sQLiteDatabase.execSQL("alter table tb_commun_message add sendStatus INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion55(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 54) {
            try {
                sQLiteDatabase.execSQL("alter table tb_pattern add lastUpdTime LONG default 0");
                sQLiteDatabase.execSQL("alter table tb_pattern add path TEXT");
                sQLiteDatabase.execSQL("alter table tb_pattern add isAnony boolean");
                sQLiteDatabase.execSQL("alter table tb_playlist add lastUpdTime LONG default 0");
                sQLiteDatabase.execSQL("alter table tb_playlist add status TEXT");
                sQLiteDatabase.execSQL("alter table tb_playlist_items add lastUpdTime LONG default 0");
                sQLiteDatabase.execSQL("alter table tb_playlist_items add status TEXT");
                sQLiteDatabase.execSQL("alter table tb_setting add sortKey boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion56(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 55) {
            try {
                sQLiteDatabase.execSQL("alter table tb_pattern add syncStatus INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion57(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 56) {
            try {
                sQLiteDatabase.execSQL("alter table tb_setting add firstInit boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion58(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 57) {
            try {
                sQLiteDatabase.execSQL("alter table tb_commun_message add receiveId TEXT");
                sQLiteDatabase.execSQL("alter table tb_commun_message add userId TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion59(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 58) {
            try {
                sQLiteDatabase.execSQL("alter table tb_log_type add timestamp TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion60(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 59) {
            try {
                sQLiteDatabase.execSQL("alter table tb_setting add theme INTEGER default 0");
                sQLiteDatabase.execSQL("alter table tb_setting add chatType INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion61(ConnectionSource connectionSource, int i) {
        if (i <= 60) {
            try {
                TableUtils.createTable(connectionSource, Orgy.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion62(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 61) {
            try {
                sQLiteDatabase.execSQL("alter table tb_commun_message add msgId TEXT");
                sQLiteDatabase.execSQL("alter table tb_commun_message add realFrom TEXT");
                sQLiteDatabase.execSQL("alter table tb_commun_message add realFromNickName TEXT");
                sQLiteDatabase.execSQL("alter table tb_commun_message add realFromPhoto TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion63(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 62) {
            try {
                TableUtils.createTable(connectionSource, ToyStrength.class);
                sQLiteDatabase.execSQL("alter table tb_setting add weakPasswordV INTEGER default 0");
                sQLiteDatabase.execSQL("alter table tb_setting add weakPasswordRed INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion64(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 63) {
            try {
                sQLiteDatabase.execSQL("alter table tb_log_type add userId TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion65(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 64) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy add uuid TEXT");
                TableUtils.createTable(connectionSource, ToyPinStatusBean.class);
                TableUtils.createTable(connectionSource, OrgyLogBean.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion66(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 65) {
            try {
                sQLiteDatabase.execSQL("alter table tb_log_type add spid TEXT");
                sQLiteDatabase.execSQL("alter table tb_user add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_toy add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_pattern add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_music add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_user_setting add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_log_type add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_setting add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_playlist add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_playlist_items add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_music_playlist add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_music_playlist_items add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_merger_music add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_toy_rename add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_program_pattern add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_toy_type add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_commun_message add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_alarm add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_alarm_lists add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_alarm_pattern add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_hot_point add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_emoji_favorite add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_back_work add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_msg_hide add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_msg_unread add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_test_values add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_re_call add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_switch_values add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_media_pattern add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_account_setting add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_orgy add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_toy_strength add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_toy_pin add isEncrypt boolean");
                sQLiteDatabase.execSQL("alter table tb_orgy_log add isEncrypt boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion67(ConnectionSource connectionSource, int i) {
        if (i <= 66) {
            try {
                TableUtils.createTable(connectionSource, MusicSpotify.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion69(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 68) {
            try {
                sQLiteDatabase.execSQL("alter table tb_pattern add emails TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion70(ConnectionSource connectionSource, int i) {
        if (i <= 69) {
            try {
                TableUtils.createTable(connectionSource, ControlLinkCommunMessage.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion71(ConnectionSource connectionSource, int i) {
        if (i <= 70) {
            try {
                TableUtils.createTable(connectionSource, SensitiveWord.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion72(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 71) {
            try {
                sQLiteDatabase.execSQL("alter table tb_pattern add isAllFun boolean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion73(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 72) {
            try {
                sQLiteDatabase.execSQL("alter table tb_commun_message add isShowEmojiAnim boolean");
                if (i > 69) {
                    sQLiteDatabase.execSQL("alter table tb_control_link_commun_message add isShowEmojiAnim boolean");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion74(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 73) {
            try {
                sQLiteDatabase.execSQL("alter table tb_commun_message add replyData TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion75(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 74) {
            try {
                TableUtils.createTable(connectionSource, ChatRoomSensitive.class);
                if (i > 70) {
                    sQLiteDatabase.execSQL("alter table tb_sensitive_word add categoryId TEXT");
                    sQLiteDatabase.execSQL("alter table tb_sensitive_word add ruleJsonData TEXT");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion76(ConnectionSource connectionSource, int i) {
        if (i <= 75) {
            try {
                TableUtils.createTable(connectionSource, CommunMessageMig.class);
                TableUtils.createTable(connectionSource, MessageUnReadMig.class);
                TableUtils.createTable(connectionSource, MessageHideMig.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion77(ConnectionSource connectionSource, int i) {
        if (i <= 76) {
            try {
                TableUtils.createTable(connectionSource, GiftCard.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion78(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 77) {
            try {
                sQLiteDatabase.execSQL("alter table tb_pattern add toyFeature TEXT");
                sQLiteDatabase.execSQL("alter table tb_playlist_items add toyFeature TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion79(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 78) {
            try {
                sQLiteDatabase.execSQL("alter table tb_pattern add createdTime INTEGER default 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion80(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 79) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy_strength add user TEXT");
                sQLiteDatabase.execSQL("alter table tb_toy_strength add suctionStrength TEXT");
                sQLiteDatabase.execSQL("alter table tb_toy_strength add thrustingStrength TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion81(ConnectionSource connectionSource, int i) {
        if (i <= 80) {
            try {
                TableUtils.createTable(connectionSource, RemoteGuideVibemate.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion82(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 81) {
            try {
                sQLiteDatabase.execSQL("alter table tb_gift_card add showExpireItem TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion83(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i) throws SQLException {
        if (i <= 82) {
            try {
                TableUtils.createTable(connectionSource, NewAccountBean.class);
                sQLiteDatabase.execSQL("alter table tb_user add remoteAccountId TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion84(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 83) {
            try {
                sQLiteDatabase.execSQL("alter table tb_pattern add toyName TEXT");
                sQLiteDatabase.execSQL("alter table tb_pattern add toySymbol TEXT");
                sQLiteDatabase.execSQL("alter table tb_pattern add toyVersion TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion85(SQLiteDatabase sQLiteDatabase, int i) {
        if (i <= 84) {
            try {
                sQLiteDatabase.delete("tb_commun_message", "fromAccountId", null);
                sQLiteDatabase.delete("tb_commun_message", "toAccountId", null);
                sQLiteDatabase.delete("tb_commun_message", "toAccountId", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion86(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 85) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy add formApp TEXT default 'Lovense Remote'");
                sQLiteDatabase.execSQL("alter table tb_toy add connectApp INTEGER default -1");
                sQLiteDatabase.execSQL("alter table tb_toy add updateTime Long");
                sQLiteDatabase.execSQL("alter table tb_toy_rename add updateTime Long");
                sQLiteDatabase.execSQL("alter table tb_toy_rename add formapp TEXT default 'Lovense Remote'");
                sQLiteDatabase.execSQL("alter table tb_toy_pin add updateTime Long");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void onUpgradeVersion87(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 86) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy_strength add depthStrength TEXT");
                sQLiteDatabase.execSQL("alter table tb_control_link_commun_message add extJsonStr TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion88(ConnectionSource connectionSource, int i) {
        if (i <= 87) {
            try {
                TableUtils.createTable(connectionSource, AudioBookList.class);
                TableUtils.createTable(connectionSource, TagList.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion89(ConnectionSource connectionSource, int i) {
        if (i <= 88) {
            try {
                TableUtils.createTable(connectionSource, ChatGPTPatternBean.class);
                TableUtils.createTable(connectionSource, ChatGPTStoryBean.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion90(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 89) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy_strength add vibration3Strength TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion91(ConnectionSource connectionSource, int i) {
        if (i <= 90) {
            try {
                TableUtils.createTable(connectionSource, Message.class);
                TableUtils.createTable(connectionSource, MessageConfig.class);
                TableUtils.createTable(connectionSource, RouletteUser.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion92(ConnectionSource connectionSource, int i) {
        if (i <= 91) {
            try {
                TableUtils.createTable(connectionSource, OfficialMsg.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion93(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 92) {
            try {
                sQLiteDatabase.execSQL("alter table tb_toy_strength add strokeMin INTEGER default 0");
                sQLiteDatabase.execSQL("alter table tb_toy_strength add strokeMax INTEGER default 100");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onUpgradeVersion94(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 93) {
            try {
                sQLiteDatabase.execSQL("alter table tb_log_type add isEnforced boolean");
                sQLiteDatabase.execSQL("alter table tb_orgy_log add activityId TEXT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper, android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.daos.clear();
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public synchronized Dao getDao(Class cls) throws java.sql.SQLException {
        Dao dao;
        String simpleName = cls.getSimpleName();
        dao = this.daos.containsKey(simpleName) ? this.daos.get(simpleName) : null;
        if (dao == null) {
            dao = super.getDao(cls);
            this.daos.put(simpleName, dao);
        }
        return dao;
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, ws1.class);
            TableUtils.createTable(connectionSource, Pattern.class);
            TableUtils.createTable(connectionSource, Music.class);
            TableUtils.createTable(connectionSource, UserSetting.class);
            TableUtils.createTable(connectionSource, LogType.class);
            TableUtils.createTable(connectionSource, Setting.class);
            TableUtils.createTable(connectionSource, Playlist.class);
            TableUtils.createTable(connectionSource, PlaylistItems.class);
            TableUtils.createTable(connectionSource, MusicPlaylist.class);
            TableUtils.createTable(connectionSource, MusicPlaylistItems.class);
            TableUtils.createTable(connectionSource, MergerMusic.class);
            TableUtils.createTable(connectionSource, ToyRename.class);
            TableUtils.createTable(connectionSource, ProgramPattern.class);
            TableUtils.createTable(connectionSource, ToyType.class);
            TableUtils.createTable(connectionSource, CommunMessage.class);
            TableUtils.createTable(connectionSource, Alarm.class);
            TableUtils.createTable(connectionSource, AlarmListItems.class);
            TableUtils.createTable(connectionSource, AlarmPattern.class);
            TableUtils.createTable(connectionSource, HotPoint.class);
            TableUtils.createTable(connectionSource, EmojiFavorite.class);
            TableUtils.createTable(connectionSource, BackWork.class);
            TableUtils.createTable(connectionSource, MessageHide.class);
            TableUtils.createTable(connectionSource, MessageUnRead.class);
            TableUtils.createTable(connectionSource, TestValue.class);
            TableUtils.createTable(connectionSource, ReCall.class);
            TableUtils.createTable(connectionSource, SwitchBean.class);
            TableUtils.createTable(connectionSource, MediaPattern.class);
            TableUtils.createTable(connectionSource, AccountSetting.class);
            TableUtils.createTable(connectionSource, Orgy.class);
            TableUtils.createTable(connectionSource, ToyStrength.class);
            TableUtils.createTable(connectionSource, ToyPinStatusBean.class);
            TableUtils.createTable(connectionSource, OrgyLogBean.class);
            TableUtils.createTable(connectionSource, MusicSpotify.class);
            TableUtils.createTable(connectionSource, ControlLinkCommunMessage.class);
            TableUtils.createTable(connectionSource, SensitiveWord.class);
            TableUtils.createTable(connectionSource, CommunMessageMig.class);
            TableUtils.createTable(connectionSource, Message.class);
            TableUtils.createTable(connectionSource, MessageConfig.class);
            TableUtils.createTable(connectionSource, RouletteUser.class);
            TableUtils.createTable(connectionSource, MessageUnReadMig.class);
            TableUtils.createTable(connectionSource, MessageHideMig.class);
            TableUtils.createTable(connectionSource, ChatRoomSensitive.class);
            TableUtils.createTable(connectionSource, GiftCard.class);
            TableUtils.createTable(connectionSource, RemoteGuideVibemate.class);
            TableUtils.createTable(connectionSource, NewAccountBean.class);
            TableUtils.createTable(connectionSource, AudioBookList.class);
            TableUtils.createTable(connectionSource, TagList.class);
            TableUtils.createTable(connectionSource, ChatGPTPatternBean.class);
            TableUtils.createTable(connectionSource, ChatGPTStoryBean.class);
            TableUtils.createTable(connectionSource, OfficialMsg.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onDowngrade(sQLiteDatabase, i, i2);
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) throws SQLException {
        xe3.a("Database", "oldVersion:" + i + "  newVersion:" + i2);
        if (i >= 94) {
            return;
        }
        onUpgradeVersion23(sQLiteDatabase, i);
        onUpgradeVersion24(sQLiteDatabase, i);
        onUpgradeVersion25(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion26(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion27(connectionSource, i);
        onUpgradeVersion28(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion29(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion30(sQLiteDatabase, i);
        onUpgradeVersion31(sQLiteDatabase, i);
        onUpgradeVersion32(sQLiteDatabase, i);
        onUpgradeVersion33(connectionSource, i);
        onUpgradeVersion34(sQLiteDatabase, i);
        onUpgradeVersion35(sQLiteDatabase, i);
        onUpgradeVersion36(sQLiteDatabase, i);
        onUpgradeVersion38(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion39(connectionSource, i);
        onUpgradeVersion40(connectionSource, i);
        onUpgradeVersion41(connectionSource, i);
        onUpgradeVersion42(connectionSource, i);
        onUpgradeVersion43(connectionSource, i);
        onUpgradeVersion44(connectionSource, i);
        onUpgradeVersion45(sQLiteDatabase, i);
        onUpgradeVersion46(sQLiteDatabase, i);
        onUpgradeVersion47(sQLiteDatabase, i);
        onUpgradeVersion48(sQLiteDatabase, i);
        onUpgradeVersion49(sQLiteDatabase, i);
        onUpgradeVersion50(sQLiteDatabase, i);
        onUpgradeVersion51(connectionSource, i);
        onUpgradeVersion52(sQLiteDatabase, i);
        onUpgradeVersion53(sQLiteDatabase, i);
        onUpgradeVersion54(sQLiteDatabase, i);
        onUpgradeVersion55(sQLiteDatabase, i);
        onUpgradeVersion56(sQLiteDatabase, i);
        onUpgradeVersion57(sQLiteDatabase, i);
        onUpgradeVersion58(sQLiteDatabase, i);
        onUpgradeVersion59(sQLiteDatabase, i);
        onUpgradeVersion60(sQLiteDatabase, i);
        onUpgradeVersion61(connectionSource, i);
        onUpgradeVersion62(sQLiteDatabase, i);
        onUpgradeVersion63(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion64(sQLiteDatabase, i);
        onUpgradeVersion65(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion66(sQLiteDatabase, i);
        onUpgradeVersion67(connectionSource, i);
        onUpgradeVersion69(sQLiteDatabase, i);
        onUpgradeVersion70(connectionSource, i);
        onUpgradeVersion71(connectionSource, i);
        onUpgradeVersion72(sQLiteDatabase, i);
        onUpgradeVersion73(sQLiteDatabase, i);
        onUpgradeVersion74(sQLiteDatabase, i);
        onUpgradeVersion75(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion76(connectionSource, i);
        onUpgradeVersion77(connectionSource, i);
        onUpgradeVersion78(sQLiteDatabase, i);
        onUpgradeVersion79(sQLiteDatabase, i);
        onUpgradeVersion80(sQLiteDatabase, i);
        onUpgradeVersion81(connectionSource, i);
        onUpgradeVersion82(sQLiteDatabase, i);
        onUpgradeVersion83(sQLiteDatabase, connectionSource, i);
        onUpgradeVersion84(sQLiteDatabase, i);
        onUpgradeVersion85(sQLiteDatabase, i);
        onUpgradeVersion86(sQLiteDatabase, i);
        onUpgradeVersion87(sQLiteDatabase, i);
        onUpgradeVersion88(connectionSource, i);
        onUpgradeVersion89(connectionSource, i);
        onUpgradeVersion90(sQLiteDatabase, i);
        onUpgradeVersion91(connectionSource, i);
        onUpgradeVersion92(connectionSource, i);
        onUpgradeVersion93(sQLiteDatabase, i);
        onUpgradeVersion94(sQLiteDatabase, i);
    }

    public static DatabaseHelper getHelper(Context context) {
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null) {
                    instance = new DatabaseHelper(context);
                }
            }
        }
        return instance;
    }
}
