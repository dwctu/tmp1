package com.wear.dao;

import android.text.TextUtils;
import com.wear.bean.ChatRoomSensitive;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatRoomSensitiveDao extends BaseDao<ChatRoomSensitive> {
    public void deleteItemByRoomId(String str) {
        List<ChatRoomSensitive> listFindAll = findAll();
        if (listFindAll == null || listFindAll.size() <= 0) {
            return;
        }
        for (ChatRoomSensitive chatRoomSensitive : listFindAll) {
            if (TextUtils.equals(str, chatRoomSensitive.getRoomId())) {
                delT(chatRoomSensitive);
                return;
            }
        }
    }

    public ChatRoomSensitive findItemByRoomId(String str) {
        ChatRoomSensitive chatRoomSensitive = new ChatRoomSensitive();
        chatRoomSensitive.setRoomId(str);
        List<ChatRoomSensitive> listFindAll = findAll();
        if (listFindAll != null && listFindAll.size() > 0) {
            Iterator<ChatRoomSensitive> it = listFindAll.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChatRoomSensitive next = it.next();
                if (TextUtils.equals(str, next.getRoomId())) {
                    chatRoomSensitive = next;
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(chatRoomSensitive.getId())) {
            add((ChatRoomSensitiveDao) chatRoomSensitive);
        }
        List<ChatRoomSensitive> listFindAll2 = findAll();
        if (listFindAll2 == null || listFindAll2.size() <= 0) {
            return chatRoomSensitive;
        }
        for (ChatRoomSensitive chatRoomSensitive2 : listFindAll2) {
            if (TextUtils.equals(str, chatRoomSensitive2.getRoomId())) {
                return chatRoomSensitive2;
            }
        }
        return chatRoomSensitive;
    }
}
