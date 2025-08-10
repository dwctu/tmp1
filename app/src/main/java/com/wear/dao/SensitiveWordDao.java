package com.wear.dao;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.j256.ormlite.table.TableUtils;
import com.wear.bean.ChatRoomSensitive;
import com.wear.bean.MatchResult;
import com.wear.bean.SensitiveWord;
import com.wear.util.WearUtils;
import dc.ye3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class SensitiveWordDao extends BaseDao<SensitiveWord> {
    public static int CHAT = 1;
    public static int CHAT_ROOM = 2;
    public static int CONTROL_LINK = 3;
    public static int NOT_UPLOAD = 4;
    private ChatRoomSensitive chatRoomSensitive = new ChatRoomSensitive();

    public interface OnResultListener {
        void onResult(MatchResult matchResult);
    }

    private void buryingPoint(int i, boolean z, List<String> list, String str, boolean z2) {
        if (i == NOT_UPLOAD) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String lowerCase = str.toLowerCase();
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                if (lowerCase.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        HashMap map = new HashMap();
        map.put("chat_type", Integer.valueOf(i));
        map.put("type", Integer.valueOf(z ? 1 : 0));
        map.put("reason", WearUtils.A.toJson(arrayList));
        map.put(DownloadService.KEY_CONTENT_ID, str);
        map.put(FirebaseAnalytics.Param.LEVEL, Integer.valueOf(z2 ? 1 : 0));
        String json = WearUtils.A.toJson(map);
        String str3 = "buryingPoint: contentmap=" + json;
        ye3.d("M0044", json);
    }

    private String decode(String str) {
        String str2 = new String(Base64.decode(str.getBytes(), 0));
        String str3 = "decode: base64正则解密后=" + str2;
        return str2;
    }

    private boolean isMatch(String str, String str2) {
        String str3 = "isMatch: 匹配的敏感句=" + str2;
        return Pattern.compile(str, 74).matcher(str2).find();
    }

    private void toCombineWord(int i, String str, List<SensitiveWord.RulesDTO> list, OnResultListener onResultListener) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (SensitiveWord.RulesDTO rulesDTO : list) {
            if (TextUtils.equals(rulesDTO.getType(), "combined") && rulesDTO.getList() != null && rulesDTO.getList().size() > 0) {
                Iterator<SensitiveWord.RulesDTO.ListDTO> it = rulesDTO.getList().iterator();
                while (true) {
                    if (it.hasNext()) {
                        SensitiveWord.RulesDTO.ListDTO next = it.next();
                        if (!TextUtils.isEmpty(next.getReg()) && !TextUtils.equals(this.chatRoomSensitive.getPartId(), rulesDTO.getPartId()) && isMatch(decode(next.getReg()), str)) {
                            MatchResult matchResult = new MatchResult(next.getKey(), next.getDefaultText(), true);
                            this.chatRoomSensitive.setCount(0);
                            this.chatRoomSensitive.setPartId("");
                            this.chatRoomSensitive.setWord("");
                            DaoUtils.getChatRoomSensitiveDao().updateOrAdd(this.chatRoomSensitive);
                            if (onResultListener != null) {
                                onResultListener.onResult(matchResult);
                            }
                            buryingPoint(i, false, next.getSensitive(), str, true);
                        }
                    }
                }
            }
        }
    }

    public void clear() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), SensitiveWord.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ChatRoomSensitive getChatRoomSensitive() {
        return this.chatRoomSensitive;
    }

    public void setChatRoomSensitive(ChatRoomSensitive chatRoomSensitive) {
        this.chatRoomSensitive = chatRoomSensitive;
    }

    public void toMatchSensitiveResult(int i, String str, OnResultListener onResultListener) {
        List<SensitiveWord> listFindAll = findAll();
        if (listFindAll != null && listFindAll.size() > 0) {
            for (SensitiveWord sensitiveWord : listFindAll) {
                if (sensitiveWord.getActive().booleanValue() && sensitiveWord.getRules() != null && listFindAll.size() > 0) {
                    for (SensitiveWord.RulesDTO rulesDTO : sensitiveWord.getRules()) {
                        if (TextUtils.equals(rulesDTO.getType(), "exact") && rulesDTO.getList() != null && rulesDTO.getList().size() > 0) {
                            for (SensitiveWord.RulesDTO.ListDTO listDTO : rulesDTO.getList()) {
                                if (!TextUtils.isEmpty(listDTO.getReg()) && isMatch(decode(listDTO.getReg()), str)) {
                                    this.chatRoomSensitive.setCount(0);
                                    this.chatRoomSensitive.setPartId("");
                                    this.chatRoomSensitive.setWord("");
                                    MatchResult matchResult = new MatchResult(listDTO.getKey(), listDTO.getDefaultText(), true);
                                    DaoUtils.getChatRoomSensitiveDao().updateOrAdd(this.chatRoomSensitive);
                                    if (onResultListener != null) {
                                        onResultListener.onResult(matchResult);
                                    }
                                    buryingPoint(i, true, listDTO.getSensitive(), str, true);
                                    return;
                                }
                            }
                        }
                        if (TextUtils.equals(rulesDTO.getType(), "combined") && rulesDTO.getList() != null && rulesDTO.getList().size() > 0) {
                            for (SensitiveWord.RulesDTO.ListDTO listDTO2 : rulesDTO.getList()) {
                                if (!TextUtils.isEmpty(listDTO2.getReg()) && isMatch(decode(listDTO2.getReg()), str)) {
                                    if (TextUtils.isEmpty(this.chatRoomSensitive.getPartId())) {
                                        this.chatRoomSensitive.setPartId(rulesDTO.getPartId());
                                        this.chatRoomSensitive.setWord(str);
                                        this.chatRoomSensitive.setCount(0);
                                        DaoUtils.getChatRoomSensitiveDao().updateOrAdd(this.chatRoomSensitive);
                                        buryingPoint(i, false, listDTO2.getSensitive(), str, false);
                                        toCombineWord(i, str, sensitiveWord.getRules(), onResultListener);
                                        return;
                                    }
                                    if (!TextUtils.equals(this.chatRoomSensitive.getPartId(), rulesDTO.getPartId())) {
                                        MatchResult matchResult2 = new MatchResult(listDTO2.getKey(), listDTO2.getDefaultText(), true);
                                        this.chatRoomSensitive.setCount(0);
                                        this.chatRoomSensitive.setPartId("");
                                        this.chatRoomSensitive.setWord("");
                                        DaoUtils.getChatRoomSensitiveDao().updateOrAdd(this.chatRoomSensitive);
                                        if (onResultListener != null) {
                                            onResultListener.onResult(matchResult2);
                                        }
                                        buryingPoint(i, false, listDTO2.getSensitive(), str, true);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int count = this.chatRoomSensitive.getCount();
        if (count >= 9) {
            this.chatRoomSensitive.setWord("");
            this.chatRoomSensitive.setPartId("");
            this.chatRoomSensitive.setCount(0);
        } else if (!TextUtils.isEmpty(this.chatRoomSensitive.getPartId())) {
            this.chatRoomSensitive.setCount(count + 1);
        }
        DaoUtils.getChatRoomSensitiveDao().updateOrAdd(this.chatRoomSensitive);
        if (onResultListener != null) {
            onResultListener.onResult(null);
        }
    }
}
