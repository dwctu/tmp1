package com.wear.bean.request;

import com.wear.bean.data.ChatGPTPatternBean;
import com.wear.bean.data.ChatGPTPatternBeanKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CreatePatternRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toChatGPTErrorBean", "Lcom/wear/bean/data/ChatGPTPatternBean;", "Lcom/wear/bean/request/CreatePatternRequest;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CreatePatternRequestKt {
    @NotNull
    public static final ChatGPTPatternBean toChatGPTErrorBean(@NotNull CreatePatternRequest createPatternRequest) {
        Intrinsics.checkNotNullParameter(createPatternRequest, "<this>");
        return new ChatGPTPatternBean(null, createPatternRequest.getLocalMsgId(), null, null, createPatternRequest.getMsgText(), Integer.valueOf(ChatGPTPatternBeanKt.ITEM_MY_SELF_MESSAGE), null, null, null, null, Boolean.FALSE, 973, null);
    }
}
