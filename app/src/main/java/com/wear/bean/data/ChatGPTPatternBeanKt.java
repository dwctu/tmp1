package com.wear.bean.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.wear.bean.Pattern;
import com.wear.util.WearUtils;
import dc.o93;
import dc.ro2;
import dc.ye3;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatGPTPatternBean.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u0012\u0010\n\u001a\u00020\b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"ITEM_CHAT_GPT_GENERATING", "", "ITEM_CHAT_GPT_MESSAGE", "ITEM_CHAT_GPT_PATTERN", "ITEM_CHAT_GPT_STORY", "ITEM_CLEAR_CONTENT", "ITEM_MY_SELF_MESSAGE", "addFailedS0009", "", "Lcom/wear/bean/data/ChatGPTPatternResponse;", "addSucS0009", "Lcom/wear/bean/data/ChatGPTPatternBean;", "time", "", "toPattern", "Lcom/wear/bean/Pattern;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTPatternBeanKt {
    public static final int ITEM_CHAT_GPT_GENERATING = 699050;
    public static final int ITEM_CHAT_GPT_MESSAGE = 10;
    public static final int ITEM_CHAT_GPT_PATTERN = 170;
    public static final int ITEM_CHAT_GPT_STORY = 43690;
    public static final int ITEM_CLEAR_CONTENT = 11184810;
    public static final int ITEM_MY_SELF_MESSAGE = 2730;

    public static final void addFailedS0009(@NotNull ChatGPTPatternResponse chatGPTPatternResponse) {
        String failCode;
        Intrinsics.checkNotNullParameter(chatGPTPatternResponse, "<this>");
        HashMap map = new HashMap();
        map.put("page_name", "chatgpt pattern");
        map.put("event_id", "generate_pattern_failed");
        map.put("element_id", "generate_pattern");
        if (Integer.parseInt(chatGPTPatternResponse.getCode()) == 0) {
            ChatGPTPatternBean data = chatGPTPatternResponse.getData();
            if (data == null || (failCode = data.getFailCode()) == null) {
                failCode = "";
            }
            map.put("element_name", failCode);
        } else {
            map.put("element_name", chatGPTPatternResponse.getCode());
        }
        map.put("toys", WearUtils.x.G().m());
        ye3.e("S0009", map);
    }

    public static final void addSucS0009(@NotNull ChatGPTPatternBean chatGPTPatternBean, long j) {
        Object string;
        Long patternDurationMilliseconds;
        Intrinsics.checkNotNullParameter(chatGPTPatternBean, "<this>");
        HashMap map = new HashMap();
        map.put("page_name", "chatgpt pattern");
        map.put("event_id", "generate_pattern_success");
        map.put("element_id", "generate_pattern");
        map.put("element_name", Long.valueOf(j));
        ChatGPTPattern msg = chatGPTPatternBean.getMsg();
        if (msg == null || (patternDurationMilliseconds = msg.getPatternDurationMilliseconds()) == null || (string = Long.valueOf(patternDurationMilliseconds.longValue() / 1000).toString()) == null) {
            string = 0;
        }
        map.put(TypedValues.TransitionType.S_DURATION, string);
        map.put("toys", WearUtils.x.G().m());
        ye3.e("S0009", map);
    }

    @NotNull
    public static final Pattern toPattern(@NotNull ChatGPTPatternBean chatGPTPatternBean) {
        Intrinsics.checkNotNullParameter(chatGPTPatternBean, "<this>");
        Pattern pattern = new Pattern();
        ChatGPTPattern chatGPTPattern = (ChatGPTPattern) ro2.a(chatGPTPatternBean.getPatternDB(), ChatGPTPattern.class);
        pattern.setId(chatGPTPatternBean.getId());
        pattern.setAnony(false);
        if (chatGPTPattern != null) {
            pattern.setName(chatGPTPattern.getPatternName());
            pattern.setPath(chatGPTPattern.getPatternFileUrl());
            pattern.setCdnPath(chatGPTPattern.getPatternFileUrl());
            Long patternDurationMilliseconds = chatGPTPattern.getPatternDurationMilliseconds();
            pattern.setTimer(patternDurationMilliseconds != null ? o93.b(patternDurationMilliseconds.longValue()) : null);
        }
        pattern.setEmail(WearUtils.y.r());
        pattern.setCreator(WearUtils.y.r());
        pattern.setToyFunc("");
        pattern.setAuthor("ChatGPT");
        return pattern;
    }
}
