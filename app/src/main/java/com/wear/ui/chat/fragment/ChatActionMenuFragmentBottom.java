package com.wear.ui.chat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.bean.chat.ChatActionMenuBean;
import com.wear.bean.event.LanguageEvent;
import com.wear.databinding.DialogFragmentChatActionMenuBinding;
import com.wear.ui.chat.adapter.ChatActionMenuAdapter;
import com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom;
import dc.ah4;
import dc.br;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatActionMenuFragmentBottom.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/DialogFragmentChatActionMenuBinding;", "()V", "groupType", "", "onChatActionMenuClickListener", "Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom$OnChatActionMenuClickListener;", "typeEnableMap", "", "", "assembleDataByGroup", "", "Lcom/wear/bean/chat/ChatActionMenuBean;", "initListener", "", "initRecyclerView", "onDestroy", "onLanguageChange", "event", "Lcom/wear/bean/event/LanguageEvent;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setOnChatActionMenuClickListener", "updateActionMenu", "type", "isEnable", "ChatActionMenuType", "Companion", "OnChatActionMenuClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatActionMenuFragmentBottom extends BaseBindingBottomDialogFragment<DialogFragmentChatActionMenuBinding> {

    @NotNull
    public static final c f = new c(null);
    public int c;

    @NotNull
    public final Map<Integer, Boolean> d;

    @Nullable
    public d e;

    /* compiled from: ChatActionMenuFragmentBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogFragmentChatActionMenuBinding> {
        public static final a a = new a();

        public a() {
            super(3, DialogFragmentChatActionMenuBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/DialogFragmentChatActionMenuBinding;", 0);
        }

        @NotNull
        public final DialogFragmentChatActionMenuBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return DialogFragmentChatActionMenuBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ DialogFragmentChatActionMenuBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: ChatActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom$ChatActionMenuType;", "", "type", "", "titleId", "icon", "descId", "(Ljava/lang/String;IIIII)V", "desc", "", "getDesc", "()Ljava/lang/String;", "getIcon", "()I", MessageBundle.TITLE_ENTRY, "getTitle", "getType", "LIVE", "SYNC", "DS", "PATTERN", "VIDEO", "VOICE", "ALARM", "PLAY_BACK", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        LIVE(0, R.string.message_notification_type_live, R.drawable.selector_chat_action_live, R.string.live_control_des),
        SYNC(1, R.string.message_notification_type_sync, R.drawable.selector_chat_action_sync, R.string.sync_control_des),
        DS(2, R.string.group_chat_menu_ds, R.drawable.icon_chat_action_ds, R.string.group_ds_des),
        PATTERN(3, R.string.main_patterns, R.drawable.icon_chat_action_pattern, R.string.patterns_des),
        VIDEO(4, R.string.chat_video, R.drawable.selector_chat_action_video, R.string.video_call_des),
        VOICE(5, R.string.chat_voice, R.drawable.selector_chat_action_voice, R.string.voice_call_des),
        ALARM(6, R.string.message_notification_type_alarm, R.drawable.icon_chat_action_alarm, R.string.alarm_des),
        PLAY_BACK(7, R.string.pattern_dialog_title, R.drawable.icon_chat_action_play_back, R.string.playback_des);

        private final int descId;
        private final int icon;
        private final int titleId;
        private final int type;

        b(int i, int i2, int i3, int i4) {
            this.type = i;
            this.titleId = i2;
            this.icon = i3;
            this.descId = i4;
        }

        @NotNull
        public final String getDesc() {
            String strE = ah4.e(this.descId);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(descId)");
            return strE;
        }

        public final int getIcon() {
            return this.icon;
        }

        @NotNull
        public final String getTitle() {
            String strE = ah4.e(this.titleId);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(titleId)");
            return strE;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: ChatActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom$Companion;", "", "()V", "GROUP_TYPE_CHAT", "", "GROUP_TYPE_CHAT_CONTROL_LINK", "GROUP_TYPE_CHAT_CONTROL_ROULETTE", "GROUP_TYPE_CHAT_GROUP", "TYPE_ALARM", "TYPE_DS", "TYPE_LIVE", "TYPE_PATTERN", "TYPE_PLAY_BACK", "TYPE_SYNC", "TYPE_VIDEO", "TYPE_VOICE", "newInstance", "Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom;", "groupType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ChatActionMenuFragmentBottom a(int i) {
            ChatActionMenuFragmentBottom chatActionMenuFragmentBottom = new ChatActionMenuFragmentBottom();
            chatActionMenuFragmentBottom.setArguments(BundleKt.bundleOf(TuplesKt.to("groupType", Integer.valueOf(i))));
            return chatActionMenuFragmentBottom;
        }
    }

    /* compiled from: ChatActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom$OnChatActionMenuClickListener;", "", "onChatActionMenuClick", "", "type", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface d {
        void n1(int i);
    }

    public ChatActionMenuFragmentBottom() {
        super(a.a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.d = linkedHashMap;
        Boolean bool = Boolean.TRUE;
        linkedHashMap.put(0, bool);
        linkedHashMap.put(1, bool);
        linkedHashMap.put(2, bool);
        linkedHashMap.put(3, bool);
        linkedHashMap.put(4, bool);
        linkedHashMap.put(5, bool);
        linkedHashMap.put(6, bool);
        linkedHashMap.put(7, bool);
    }

    public static final void B(ChatActionMenuFragmentBottom this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.wear.bean.chat.ChatActionMenuBean");
        ChatActionMenuBean chatActionMenuBean = (ChatActionMenuBean) item;
        d dVar = this$0.e;
        if (dVar != null) {
            dVar.n1(chatActionMenuBean.getType());
        }
        if (chatActionMenuBean.isEnable()) {
            this$0.dismiss();
        }
    }

    @JvmStatic
    @NotNull
    public static final ChatActionMenuFragmentBottom E(int i) {
        return f.a(i);
    }

    public static final void y(ChatActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public final void A() {
        RecyclerView.ItemAnimator itemAnimator = t().b.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        t().b.setLayoutManager(new LinearLayoutManager(requireContext()));
        ChatActionMenuAdapter chatActionMenuAdapter = new ChatActionMenuAdapter(u());
        chatActionMenuAdapter.E0(new br() { // from class: dc.bt2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChatActionMenuFragmentBottom.B(this.a, baseQuickAdapter, view, i);
            }
        });
        t().b.setAdapter(chatActionMenuAdapter);
    }

    public final void F(@NotNull d onChatActionMenuClickListener) {
        Intrinsics.checkNotNullParameter(onChatActionMenuClickListener, "onChatActionMenuClickListener");
        this.e = onChatActionMenuClickListener;
    }

    public final void I(int i, boolean z) {
        this.d.put(Integer.valueOf(i), Boolean.valueOf(z));
        if (isVisible()) {
            RecyclerView.Adapter adapter = t().b.getAdapter();
            ChatActionMenuAdapter chatActionMenuAdapter = adapter instanceof ChatActionMenuAdapter ? (ChatActionMenuAdapter) adapter : null;
            if (chatActionMenuAdapter == null) {
                return;
            }
            List<ChatActionMenuBean> listK = chatActionMenuAdapter.K();
            Iterator<ChatActionMenuBean> it = listK.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else {
                    if (it.next().getType() == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (i2 != -1) {
                listK.get(i2).setEnable(z);
                chatActionMenuAdapter.notifyItemChanged(i2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLanguageChange(@NotNull LanguageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        RecyclerView.Adapter adapter = t().b.getAdapter();
        ChatActionMenuAdapter chatActionMenuAdapter = adapter instanceof ChatActionMenuAdapter ? (ChatActionMenuAdapter) adapter : null;
        if (chatActionMenuAdapter == null) {
            return;
        }
        chatActionMenuAdapter.y0(u());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.c = arguments != null ? arguments.getInt("groupType", 0) : 0;
        A();
        v();
    }

    public final List<ChatActionMenuBean> u() {
        ArrayList arrayList = new ArrayList();
        int i = this.c;
        if (i == 0) {
            arrayList.add(0);
            arrayList.add(1);
            arrayList.add(3);
            arrayList.add(4);
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(7);
        } else if (i == 1) {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(6);
        } else if (i == 2 || i == 3) {
            arrayList.add(0);
            arrayList.add(1);
        }
        b[] bVarArrValues = b.values();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            for (b bVar : bVarArrValues) {
                if (bVar.getType() == iIntValue) {
                    String title = bVar.getTitle();
                    int icon = bVar.getIcon();
                    String desc = bVar.getDesc();
                    Boolean bool = this.d.get(Integer.valueOf(iIntValue));
                    arrayList2.add(new ChatActionMenuBean(title, icon, desc, iIntValue, bool != null ? bool.booleanValue() : true));
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        return CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
    }

    public final void v() {
        EventBus.getDefault().register(this);
        t().a.setOnClickListener(new View.OnClickListener() { // from class: dc.ct2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatActionMenuFragmentBottom.y(this.a, view);
            }
        });
    }
}
