package com.wear.bean.data;

import com.wear.util.WearUtils;
import dc.ye3;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatGPTStoryResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"addFailedS0009", "", "Lcom/wear/bean/data/ChatGPTStoryResponse;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTStoryResponseKt {
    public static final void addFailedS0009(@NotNull ChatGPTStoryResponse chatGPTStoryResponse) {
        String failCode;
        Intrinsics.checkNotNullParameter(chatGPTStoryResponse, "<this>");
        HashMap map = new HashMap();
        map.put("page_name", "chatgpt story");
        map.put("event_id", "generate_story_failed");
        map.put("element_id", "generate_story");
        if (Integer.parseInt(chatGPTStoryResponse.getCode()) == 0) {
            ChatGPTStoryBean data = chatGPTStoryResponse.getData();
            if (data == null || (failCode = data.getFailCode()) == null) {
                failCode = "";
            }
            map.put("element_name", failCode);
        } else {
            map.put("element_name", chatGPTStoryResponse.getCode());
        }
        map.put("toys", WearUtils.x.G().m());
        ye3.e("S0009", map);
    }
}
