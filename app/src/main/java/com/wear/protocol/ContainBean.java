package com.wear.protocol;

import android.database.Cursor;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.wear.bean.ToyBean;
import com.wear.dao.DaoUtils;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityToy;
import com.wear.util.WearUtils;
import dc.ch3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ContainBean {
    public static SimpleDateFormat dbDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public HashMap<String, Object> dataMap;
    private CommunMessage entity;

    /* renamed from: com.wear.protocol.ContainBean$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$wear$protocol$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$wear$protocol$MessageType = iArr;
            try {
                iArr[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.pattern.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.audio.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.picture.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.toy.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.live.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.sync.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ContainBean(CommunMessage communMessage) {
        this.dataMap = new HashMap<>();
        this.entity = communMessage;
        Gson gson = WearUtils.A;
        HashMap<String, Object> map = (HashMap) gson.fromJson(gson.toJson(communMessage), HashMap.class);
        this.dataMap = map;
        map.put("realFrom", communMessage.getRealFrom());
        this.dataMap.put("from", communMessage.getFrom());
        this.dataMap.put("to", communMessage.getTo());
        this.dataMap.put("userId", communMessage.getUserId());
        if (communMessage.getReplyData() != null) {
            HashMap map2 = (HashMap) WearUtils.A.fromJson(communMessage.getReplyData(), HashMap.class);
            map2.remove("dataBean");
            this.dataMap.put("replyData", map2);
        }
        this.dataMap.put("feature", communMessage.setFeature());
        this.dataMap.remove("dataBean");
    }

    private CommunMessage getReplyMsg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("replyData")) {
                return (CommunMessage) WearUtils.A.fromJson(jSONObject.getString("replyData"), CommunMessage.class);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void onUpgradeDb_27_28(Cursor cursor) throws ParseException {
        String string = cursor.getString(cursor.getColumnIndex(TtmlNode.ATTR_ID));
        String string2 = cursor.getString(cursor.getColumnIndex("created"));
        String string3 = cursor.getString(cursor.getColumnIndex("fromJid"));
        String string4 = cursor.getString(cursor.getColumnIndex("toJid"));
        String string5 = cursor.getString(cursor.getColumnIndex("type"));
        String string6 = cursor.getString(cursor.getColumnIndex("text"));
        String string7 = cursor.getString(cursor.getColumnIndex(ImagesContract.URL));
        String string8 = cursor.getString(cursor.getColumnIndex("time"));
        String string9 = cursor.getString(cursor.getColumnIndex("typeDetail"));
        String str = "id:" + string + " created" + string2 + " fromJid" + string3 + " toJid" + string4 + " type" + string5 + " text" + string6 + " url" + string7 + " time" + string8 + " typeDetail" + string9 + " patternId" + cursor.getString(cursor.getColumnIndex("patternId"));
        if (WearUtils.e1(string5)) {
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setId(string);
        SimpleDateFormat simpleDateFormat = dbDate;
        if (string2.indexOf(".") > 0) {
            string2 = string2.substring(0, string2.indexOf("."));
        }
        communMessage.setCreated(simpleDateFormat.parse(string2));
        communMessage.setFrom(string3);
        communMessage.setTo(string4);
        communMessage.setUserId(ch3.n().p());
        tranOldData(communMessage, string5, string6, string7, string8, string9);
        if (DaoUtils.getCommunMessageDao().findById(string) == null) {
            DaoUtils.getCommunMessageDao().add(communMessage);
        }
    }

    private static void tranOldData(CommunMessage communMessage, String str, String str2, String str3, String str4, String str5) {
        switch (AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[MessageType.fromString(str).ordinal()]) {
            case 1:
                if (!WearUtils.e1(str5)) {
                    if (str5.toLowerCase().equals("graytext")) {
                        EntitySystem entitySystem = new EntitySystem();
                        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C200.toString(), null);
                        communMessage.sendEntity(entitySystem);
                        break;
                    }
                } else {
                    EntityChat entityChat = new EntityChat();
                    entityChat.setText(str2);
                    communMessage.sendEntity(entityChat);
                    break;
                }
                break;
            case 2:
                EntityPattern entityPattern = new EntityPattern();
                entityPattern.setFeature(PSOProgramService.VS_Key);
                entityPattern.setUrl(str3);
                entityPattern.setName(str2);
                entityPattern.setType(str5);
                entityPattern.setTime((int) CommunMessage.getTimeToSecond(str4));
                communMessage.sendEntity(entityPattern);
                break;
            case 3:
                EntityAudio entityAudio = new EntityAudio();
                entityAudio.setUrl(str3);
                entityAudio.setTime(Integer.valueOf(str4).intValue());
                communMessage.sendEntity(entityAudio);
                break;
            case 4:
                EntityPicture entityPicture = new EntityPicture();
                entityPicture.setUrl(str3);
                communMessage.sendEntity(entityPicture);
                break;
            case 5:
                EntityToy entityToy = new EntityToy();
                ToyBean toyBean = new ToyBean();
                toyBean.setV(Integer.parseInt(str2));
                entityToy.setAll(toyBean);
                entityToy.setCate(EntityToy.ToyOPTType.all.toString());
                communMessage.sendEntity(entityToy);
                break;
            case 6:
                EntityLive entityLive = new EntityLive();
                entityLive.setType(str2);
                communMessage.sendEntity(entityLive);
                break;
            case 7:
                EntitySync entitySync = new EntitySync();
                entitySync.setType(str2);
                communMessage.sendEntity(entitySync);
                break;
        }
    }

    public HashMap<String, Object> getDataMap() {
        return this.dataMap;
    }

    public CommunMessage getEntity() {
        return this.entity;
    }

    public String getJson() {
        HashMap<String, Object> map = this.dataMap;
        if (map != null) {
            return WearUtils.A.toJson(map);
        }
        return null;
    }

    public ContainBean(String str) {
        this.dataMap = new HashMap<>();
        CommunMessage replyMsg = getReplyMsg(str);
        HashMap map = (HashMap) WearUtils.A.fromJson(str, HashMap.class);
        this.dataMap = (HashMap) WearUtils.A.fromJson(str, HashMap.class);
        map.remove("replyData");
        CommunMessage communMessage = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
        this.entity = communMessage;
        if (replyMsg != null) {
            communMessage.setReplyData(WearUtils.A.toJson(replyMsg));
        }
    }
}
