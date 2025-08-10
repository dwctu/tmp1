package com.wear.bean.request;

import com.wear.bean.data.ChatGPTPatternBeanKt;
import com.wear.bean.data.ChatGPTStoryBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CreateStoryRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toChatGPTStoryErrorBean", "Lcom/wear/bean/data/ChatGPTStoryBean;", "Lcom/wear/bean/request/CreateStoryRequest;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CreateStoryRequestKt {
    @NotNull
    public static final ChatGPTStoryBean toChatGPTStoryErrorBean(@NotNull CreateStoryRequest createStoryRequest) {
        Intrinsics.checkNotNullParameter(createStoryRequest, "<this>");
        return new ChatGPTStoryBean(null, null, null, null, createStoryRequest.getLocalMsgId(), createStoryRequest.getMsgText(), null, Integer.valueOf(ChatGPTPatternBeanKt.ITEM_MY_SELF_MESSAGE), null, null, Boolean.FALSE, 847, null);
    }
}
