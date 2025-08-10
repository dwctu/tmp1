package com.wear.bean.data;

import com.google.android.exoplayer2.Player;
import com.lovense.wear.R;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ch3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTMsgExt.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\u0005\u001a\u0006\u0010\t\u001a\u00020\u0007\u001a\u0006\u0010\n\u001a\u00020\u0005\u001a\u0006\u0010\u000b\u001a\u00020\u0007\u001a\u0006\u0010\f\u001a\u00020\u0005\u001a\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0006\u0010\u0010\u001a\u00020\u0007\u001a\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\n\u0010\u0012\u001a\u00020\u000f*\u00020\u0013\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0014"}, d2 = {"isPrepared", "", "Lcom/google/android/exoplayer2/Player;", "(Lcom/google/android/exoplayer2/Player;)Z", "chatGPTGeneratingMsg", "Lcom/wear/bean/data/ChatGPTPatternBean;", "chatGPTStoryGeneratingMsg", "Lcom/wear/bean/data/ChatGPTStoryBean;", "createFirstChatGPTMsg", "createStoryChatGPTMsg", "generateClearPatternContextMsg", "generateClearStoryContentMsg", "generatePatterEnjoyMsg", "generatePatternErrorMsg", "sessionTaskId", "", "generateStoryEnjoyMsg", "generateStoryErrorMsg", "toTopicId", "Lcom/wear/network/presenter/bean/LoginUserBean;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTMsgExtKt {
    @NotNull
    public static final ChatGPTPatternBean chatGPTGeneratingMsg() {
        return new ChatGPTPatternBean(ch3.n().o().getRemoteAccountId(), WearUtils.E(), null, null, ah4.e(R.string.chatgpt_generating_hint), Integer.valueOf(ChatGPTPatternBeanKt.ITEM_CHAT_GPT_GENERATING), null, null, null, null, null, 1996, null);
    }

    @NotNull
    public static final ChatGPTStoryBean chatGPTStoryGeneratingMsg() {
        return new ChatGPTStoryBean(null, null, null, null, WearUtils.E(), ah4.e(R.string.chatgpt_generating_hint), ch3.n().o().getRemoteAccountId(), Integer.valueOf(ChatGPTPatternBeanKt.ITEM_CHAT_GPT_GENERATING), null, null, null, 1807, null);
    }

    @NotNull
    public static final ChatGPTPatternBean createFirstChatGPTMsg() {
        return new ChatGPTPatternBean(ch3.n().o().getRemoteAccountId(), WearUtils.E(), null, null, ah4.e(R.string.chatgpt_pattern_1st_msg), 10, null, null, null, null, null, 1996, null);
    }

    @NotNull
    public static final ChatGPTStoryBean createStoryChatGPTMsg() {
        return new ChatGPTStoryBean(null, null, null, null, WearUtils.E(), ah4.e(R.string.chatgpt_story_1st_msg), ch3.n().o().getRemoteAccountId(), 10, null, null, null, 1807, null);
    }

    @NotNull
    public static final ChatGPTPatternBean generateClearPatternContextMsg() {
        return new ChatGPTPatternBean(ch3.n().o().getRemoteAccountId(), WearUtils.E(), null, null, "", Integer.valueOf(ChatGPTPatternBeanKt.ITEM_CLEAR_CONTENT), null, null, null, null, null, 1996, null);
    }

    @NotNull
    public static final ChatGPTStoryBean generateClearStoryContentMsg() {
        return new ChatGPTStoryBean(null, null, null, null, WearUtils.E(), "", ch3.n().o().getRemoteAccountId(), Integer.valueOf(ChatGPTPatternBeanKt.ITEM_CLEAR_CONTENT), null, null, null, 1807, null);
    }

    @NotNull
    public static final ChatGPTPatternBean generatePatterEnjoyMsg() {
        return new ChatGPTPatternBean(ch3.n().o().getRemoteAccountId(), WearUtils.E(), null, null, ah4.e(R.string.chatgpt_pattern_success_msg), 10, null, null, null, null, null, 1996, null);
    }

    @NotNull
    public static final ChatGPTPatternBean generatePatternErrorMsg(@Nullable String str) {
        return new ChatGPTPatternBean(ch3.n().o().getRemoteAccountId(), WearUtils.E(), null, null, ah4.e(R.string.chatgpt_pattern_error_msg), 10, str, null, null, null, null, 1932, null);
    }

    @NotNull
    public static final ChatGPTStoryBean generateStoryEnjoyMsg() {
        return new ChatGPTStoryBean(null, null, null, null, WearUtils.E(), ah4.e(R.string.chatgpt_story_success_msg), ch3.n().o().getRemoteAccountId(), 10, null, null, null, 1807, null);
    }

    @NotNull
    public static final ChatGPTStoryBean generateStoryErrorMsg(@Nullable String str) {
        return new ChatGPTStoryBean(str, null, null, null, WearUtils.E(), ah4.e(R.string.chatgpt_pattern_story_msg), ch3.n().o().getRemoteAccountId(), 10, null, null, null, 1806, null);
    }

    public static final boolean isPrepared(@NotNull Player player) {
        Intrinsics.checkNotNullParameter(player, "<this>");
        return player.getPlaybackState() == 3 || player.getPlaybackState() == 2;
    }

    @NotNull
    public static final String toTopicId(@NotNull LoginUserBean loginUserBean) {
        Intrinsics.checkNotNullParameter(loginUserBean, "<this>");
        return "Story" + loginUserBean.getRemoteAccountId();
    }
}
