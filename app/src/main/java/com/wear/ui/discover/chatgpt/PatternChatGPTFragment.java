package com.wear.ui.discover.chatgpt;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.data.AskingData;
import com.wear.bean.data.ChatGPTPattern;
import com.wear.bean.data.ChatGPTPatternBean;
import com.wear.bean.data.ChatGPTPatternBeanKt;
import com.wear.bean.event.ChatGPTType;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.ChatGPTPatternDao;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.ui.discover.chatgpt.PatternChatGPTFragment;
import com.wear.ui.discover.chatgpt.adapter.ChatGPTAdapter;
import com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel;
import com.wear.ui.home.pattern.NewPatternActivity;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ar;
import dc.br;
import dc.ch3;
import dc.cs3;
import dc.eg3;
import dc.is3;
import dc.my2;
import dc.na2;
import dc.pj3;
import dc.ro2;
import dc.ue2;
import dc.uy3;
import dc.vn3;
import dc.wz3;
import dc.xe2;
import dc.ye3;
import dc.yn3;
import dc.zq;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PatternChatGPTFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0014J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/wear/ui/discover/chatgpt/PatternChatGPTFragment;", "Lcom/wear/ui/discover/chatgpt/ChatGPTFragment;", "()V", "adapter", "Lcom/wear/ui/discover/chatgpt/adapter/ChatGPTAdapter;", "askingList", "Ljava/util/ArrayList;", "Lcom/wear/bean/data/AskingData;", "Lkotlin/collections/ArrayList;", "disLikePattern", "", "bean", "Lcom/wear/bean/data/ChatGPTPatternBean;", "position", "", "getAskingList", "", "likePattern", "observableViewModelData", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "playPattern", "pattern", "Lcom/wear/bean/Pattern;", "savePattern", "chatGPTPatternBean", "sendAsking", "askingData", "sharePattern", "showMenuDialog", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PatternChatGPTFragment extends ChatGPTFragment {

    @NotNull
    public final ChatGPTAdapter f;

    @NotNull
    public final ArrayList<AskingData> g;

    /* compiled from: PatternChatGPTFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.PatternChatGPTFragment$disLikePattern$1", f = "PatternChatGPTFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ChatGPTPatternBean $bean;
        public int label;
        public final /* synthetic */ PatternChatGPTFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatGPTPatternBean chatGPTPatternBean, PatternChatGPTFragment patternChatGPTFragment, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$bean = chatGPTPatternBean;
            this.this$0 = patternChatGPTFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$bean, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ChatGPTPattern chatGPTPattern = (ChatGPTPattern) ro2.a(this.$bean.getPatternDB(), ChatGPTPattern.class);
            ChatGPTPatternDao chatGPTPatternDao = DaoUtils.getChatGPTPatternDao();
            if (chatGPTPattern != null) {
                ChatGPTPatternBean chatGPTPatternBean = this.$bean;
                PatternChatGPTFragment patternChatGPTFragment = this.this$0;
                Boolean disLike = chatGPTPattern.getDisLike();
                boolean z = !(disLike != null ? disLike.booleanValue() : false);
                if (z) {
                    chatGPTPattern.setLiked(Boxing.boxBoolean(false));
                }
                chatGPTPattern.setDisLike(Boxing.boxBoolean(z));
                String strC = ro2.c(chatGPTPattern);
                Intrinsics.checkNotNullExpressionValue(strC, "toJSONString(pattern)");
                chatGPTPatternBean.setPatternDB(strC);
                patternChatGPTFragment.f.notifyDataSetChanged();
                chatGPTPatternDao.update((ChatGPTPatternDao) chatGPTPatternBean);
                ye3.j("chatgpt pattern", "like_or_unlike_click", "click", "like_or_unlike", "button", z ? "2" : "0", chatGPTPatternBean.getSessionTaskId(), -1L);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PatternChatGPTFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.PatternChatGPTFragment$likePattern$1", f = "PatternChatGPTFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ChatGPTPatternBean $bean;
        public int label;
        public final /* synthetic */ PatternChatGPTFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChatGPTPatternBean chatGPTPatternBean, PatternChatGPTFragment patternChatGPTFragment, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$bean = chatGPTPatternBean;
            this.this$0 = patternChatGPTFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$bean, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ChatGPTPattern chatGPTPattern = (ChatGPTPattern) ro2.a(this.$bean.getPatternDB(), ChatGPTPattern.class);
            ChatGPTPatternDao chatGPTPatternDao = DaoUtils.getChatGPTPatternDao();
            if (chatGPTPattern != null) {
                ChatGPTPatternBean chatGPTPatternBean = this.$bean;
                PatternChatGPTFragment patternChatGPTFragment = this.this$0;
                Boolean boolIsLiked = chatGPTPattern.isLiked();
                boolean z = !(boolIsLiked != null ? boolIsLiked.booleanValue() : false);
                if (z) {
                    chatGPTPattern.setDisLike(Boxing.boxBoolean(false));
                }
                chatGPTPattern.setLiked(Boxing.boxBoolean(z));
                String strC = ro2.c(chatGPTPattern);
                Intrinsics.checkNotNullExpressionValue(strC, "toJSONString(pattern)");
                chatGPTPatternBean.setPatternDB(strC);
                patternChatGPTFragment.f.notifyDataSetChanged();
                chatGPTPatternDao.update((ChatGPTPatternDao) chatGPTPatternBean);
                ye3.j("chatgpt pattern", "like_or_unlike_click", "click", "like_or_unlike", "button", z ? "1" : "0", chatGPTPatternBean.getSessionTaskId(), -1L);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TextView.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2:98\n77#3:99\n*E\n"})
    public static final class c implements TextWatcher {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable r4) {
            /*
                r3 = this;
                com.wear.ui.discover.chatgpt.PatternChatGPTFragment r0 = com.wear.ui.discover.chatgpt.PatternChatGPTFragment.this
                com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r0 = r0.A()
                boolean r0 = r0.getH()
                if (r0 != 0) goto L36
                com.wear.ui.discover.chatgpt.PatternChatGPTFragment r0 = com.wear.ui.discover.chatgpt.PatternChatGPTFragment.this
                com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r0 = r0.A()
                r1 = 1
                r2 = 0
                if (r4 == 0) goto L32
                java.lang.String r4 = r4.toString()
                if (r4 == 0) goto L32
                java.lang.CharSequence r4 = kotlin.text.StringsKt__StringsKt.trim(r4)
                java.lang.String r4 = r4.toString()
                if (r4 == 0) goto L32
                int r4 = r4.length()
                if (r4 != 0) goto L2e
                r4 = 1
                goto L2f
            L2e:
                r4 = 0
            L2f:
                if (r4 != 0) goto L32
                goto L33
            L32:
                r1 = 0
            L33:
                r0.C(r1)
            L36:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.PatternChatGPTFragment.c.afterTextChanged(android.text.Editable):void");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    /* compiled from: PatternChatGPTFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.PatternChatGPTFragment$playPattern$1", f = "PatternChatGPTFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Pattern $pattern;
        public int label;
        public final /* synthetic */ PatternChatGPTFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Pattern pattern, PatternChatGPTFragment patternChatGPTFragment, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$pattern = pattern;
            this.this$0 = patternChatGPTFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$pattern, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pattern.setData(WearUtils.N1(this.$pattern.getFile().getAbsolutePath()));
            Bundle bundle = new Bundle();
            bundle.putSerializable("pattern", this.$pattern);
            bundle.putSerializable("from", "ChatGPT");
            ue2 ue2VarL0 = xe2.L0();
            Intrinsics.checkNotNull(ue2VarL0, "null cannot be cast to non-null type com.wear.main.patterns.PatternManagerImpl");
            ((xe2) ue2VarL0).J1(CollectionsKt__CollectionsKt.arrayListOf(this.$pattern));
            pj3.g(this.this$0.requireActivity(), PatternPlayActivity.class, bundle);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PatternChatGPTFragment.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"com/wear/ui/discover/chatgpt/PatternChatGPTFragment$savePattern$1", "Lcom/wear/widget/SavePatternDialog$ClickListener;", "doCancel", "", "doConfirm", "path", "", "name", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements yn3.c {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ PatternChatGPTFragment b;

        public e(Pattern pattern, PatternChatGPTFragment patternChatGPTFragment) {
            this.a = pattern;
            this.b = patternChatGPTFragment;
        }

        @Override // dc.yn3.c
        public void a(@Nullable String str, @Nullable String str2) {
            String timer = this.a.getTimer();
            Long lValueOf = (timer != null ? StringsKt__StringsKt.split$default((CharSequence) timer, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null) : null) != null ? Long.valueOf((Integer.parseInt((String) r0.get(0)) * 60) + Integer.parseInt((String) r0.get(1))) : null;
            if (str2 != null) {
                Pattern pattern = this.a;
                PatternChatGPTFragment patternChatGPTFragment = this.b;
                pattern.setName(str2);
                ye3.j("chatgpt pattern", "save_pattern_click", "click", pattern.getId(), "button", "", "", lValueOf != null ? lValueOf.longValue() : -1L);
                xe2.L0().t(pattern, true);
                pj3.f(patternChatGPTFragment.requireContext(), NewPatternActivity.class);
            }
        }

        @Override // dc.yn3.c
        public void doCancel() {
        }
    }

    /* compiled from: PatternChatGPTFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.PatternChatGPTFragment$showMenuDialog$2$1", f = "PatternChatGPTFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ChatGPTPatternBean $bean;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ChatGPTPatternBean chatGPTPatternBean, Continuation<? super f> continuation) {
            super(2, continuation);
            this.$bean = chatGPTPatternBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return PatternChatGPTFragment.this.new f(this.$bean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PatternChatGPTFragment.this.f.o0(this.$bean);
            DaoUtils.getChatGPTPatternDao().delById(this.$bean.getId());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PatternChatGPTFragment.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/wear/ui/discover/chatgpt/PatternChatGPTFragment$showMenuDialog$3", "Lcom/wear/widget/MenuNewDialog$HVInterface;", "showDown", "", "rootLayout", "Landroid/view/View;", "showTop", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements vn3.c {
        @Override // dc.vn3.c
        public void a(@Nullable View view) {
            if (view != null) {
                view.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_more_up2);
            }
        }

        @Override // dc.vn3.c
        public void b(@Nullable View view) {
            if (view != null) {
                view.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_more_down2);
            }
        }
    }

    public PatternChatGPTFragment() {
        ChatGPTAdapter chatGPTAdapter = new ChatGPTAdapter();
        chatGPTAdapter.n(R.id.iv_pattern_play);
        chatGPTAdapter.n(R.id.tv_preview);
        chatGPTAdapter.n(R.id.tv_save);
        chatGPTAdapter.n(R.id.block_sync);
        chatGPTAdapter.n(R.id.iv_pattern_liked);
        chatGPTAdapter.n(R.id.iv_pattern_disliked);
        chatGPTAdapter.n(R.id.iv_pattern_share);
        chatGPTAdapter.o(R.id.tv_chat_gpt_message);
        chatGPTAdapter.o(R.id.tv_my_self_message);
        this.f = chatGPTAdapter;
        String strE = ah4.e(R.string.gpt_another_pattern_item);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.gpt_another_pattern_item)");
        String strE2 = ah4.e(R.string.gpt_pattern_item_2);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.gpt_pattern_item_2)");
        String strE3 = ah4.e(R.string.gpt_pattern_item_3);
        Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.gpt_pattern_item_3)");
        String strE4 = ah4.e(R.string.gpt_pattern_item_1);
        Intrinsics.checkNotNullExpressionValue(strE4, "getString(R.string.gpt_pattern_item_1)");
        this.g = CollectionsKt__CollectionsKt.arrayListOf(new AskingData(strE, "PatternTplMsgId001"), new AskingData(strE2, "PatternTplMsgId002"), new AskingData(strE3, "PatternTplMsgId003"), new AskingData(strE4, "PatternTplMsgId004"));
    }

    public static final void A0(PatternChatGPTFragment this$0, ChatGPTType chatGPTType) {
        is3<Object> is3VarY;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (chatGPTType == null || chatGPTType != ChatGPTType.PATTERN) {
            return;
        }
        String strE = ah4.e(R.string.gpt_limited_return_times);
        boolean z = false;
        if (this$0.y() == null) {
            is3.b bVar = new is3.b(this$0.requireContext());
            bVar.b(false);
            bVar.m(false);
            bVar.p(strE);
            bVar.o(ah4.e(R.string.got_it));
            bVar.h(false);
            this$0.Q(cs3.h(bVar));
            is3<Object> is3VarY2 = this$0.y();
            if (is3VarY2 != null) {
                is3VarY2.show();
            }
        } else {
            is3<Object> is3VarY3 = this$0.y();
            if (is3VarY3 != null && !is3VarY3.isShowing()) {
                z = true;
            }
            if (z && (is3VarY = this$0.y()) != null) {
                is3VarY.show();
            }
        }
        ye3.i("chatgpt pattern", "no_time_popup_exposure", "exposure", "no_time_popup", "popup");
    }

    public static final void C0(PatternChatGPTFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v().f.setSelected(!bool.booleanValue());
    }

    public static final void E0(PatternChatGPTFragment this$0, BaseQuickAdapter a2, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(view, "view");
        ChatGPTPatternBean chatGPTPatternBean = (ChatGPTPatternBean) this$0.f.K().get(i);
        switch (view.getId()) {
            case R.id.block_sync /* 2131362176 */:
                if (!this$0.A().getH()) {
                    ChatGPTViewModel chatGPTViewModelA = this$0.A();
                    Context contextRequireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    String msgText = chatGPTPatternBean.getMsgText();
                    if (msgText == null) {
                        msgText = "";
                    }
                    ChatGPTViewModel.A(chatGPTViewModelA, contextRequireContext, msgText, null, null, 12, null);
                    this$0.f.o0(chatGPTPatternBean);
                    break;
                }
                break;
            case R.id.iv_pattern_disliked /* 2131363234 */:
                this$0.e0(chatGPTPatternBean, i);
                break;
            case R.id.iv_pattern_liked /* 2131363238 */:
                this$0.u0(chatGPTPatternBean, i);
                break;
            case R.id.iv_pattern_play /* 2131363240 */:
                Integer contentType = chatGPTPatternBean.getContentType();
                if (contentType != null && contentType.intValue() == 170) {
                    this$0.Q0(ChatGPTPatternBeanKt.toPattern(chatGPTPatternBean));
                    break;
                }
                break;
            case R.id.iv_pattern_share /* 2131363243 */:
                this$0.S0(chatGPTPatternBean);
                break;
            case R.id.tv_preview /* 2131365251 */:
                Integer contentType2 = chatGPTPatternBean.getContentType();
                if (contentType2 != null && contentType2.intValue() == 170) {
                    ye3.i("chatgpt pattern", "preview_click", "click", "prview", "button");
                    this$0.Q0(ChatGPTPatternBeanKt.toPattern(chatGPTPatternBean));
                    break;
                }
                break;
            case R.id.tv_save /* 2131365287 */:
                ye3.i("chatgpt pattern", "save_click", "click", "save", "button");
                this$0.R0(chatGPTPatternBean);
                break;
        }
    }

    public static final void J0(PatternChatGPTFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ChatGPTPatternBean chatGPTPatternBean = (ChatGPTPatternBean) this$0.f.K().get(i);
        Integer contentType = chatGPTPatternBean.getContentType();
        if (contentType != null && contentType.intValue() == 170) {
            this$0.Q0(ChatGPTPatternBeanKt.toPattern(chatGPTPatternBean));
        }
    }

    public static final boolean K0(PatternChatGPTFragment this$0, BaseQuickAdapter a2, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.T0(view, (ChatGPTPatternBean) this$0.f.K().get(i));
        return true;
    }

    public static final void M0(PatternChatGPTFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = this$0.v().c.getText().toString();
        if (this$0.A().getH()) {
            return;
        }
        if (string.length() > 0) {
            ChatGPTViewModel chatGPTViewModelA = this$0.A();
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            ChatGPTViewModel.A(chatGPTViewModelA, contextRequireContext, string, null, null, 12, null);
            this$0.v().c.setText("");
        }
    }

    public static final void P0(PatternChatGPTFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String topicId = eg3.h(this$0.requireContext(), ch3.n().o().getRemoteAccountId(), "");
        Intrinsics.checkNotNullExpressionValue(topicId, "topicId");
        if (topicId.length() > 0) {
            ChatGPTViewModel chatGPTViewModelA = this$0.A();
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            chatGPTViewModelA.i(contextRequireContext, "pattern");
            this$0.L();
            ye3.i("chatgpt pattern", "clear_click", "click", "clear", "button");
        }
    }

    public static final void U0(PatternChatGPTFragment this$0, ChatGPTPatternBean bean, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        Object systemService = this$0.requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipData clipDataNewPlainText = ClipData.newPlainText("simple text", bean.getMsgText());
        Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(\"simple text\", bean.msgText)");
        ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
    }

    public static final void W0(PatternChatGPTFragment this$0, ChatGPTPatternBean bean, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, this$0.new f(bean, null), 3, null);
    }

    public static final void w0(final PatternChatGPTFragment this$0, ChatGPTPatternBean it) {
        Integer contentType;
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer contentType2 = it.getContentType();
        if ((contentType2 != null && contentType2.intValue() == 170) || ((contentType = it.getContentType()) != null && contentType.intValue() == 10)) {
            Iterator it2 = this$0.f.K().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                Integer contentType3 = ((ChatGPTPatternBean) next).getContentType();
                if (contentType3 != null && contentType3.intValue() == 699050) {
                    break;
                }
            }
            ChatGPTPatternBean chatGPTPatternBean = (ChatGPTPatternBean) next;
            if (chatGPTPatternBean != null) {
                this$0.f.o0(chatGPTPatternBean);
            }
        }
        ChatGPTAdapter chatGPTAdapter = this$0.f;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        chatGPTAdapter.r(it);
        if (this$0.f.getItemCount() - 2 > 0) {
            this$0.f.notifyItemChanged(r5.getItemCount() - 2);
        }
        this$0.v().getRoot().postDelayed(new Runnable() { // from class: dc.ew2
            @Override // java.lang.Runnable
            public final void run() {
                PatternChatGPTFragment.x0(this.a);
            }
        }, 100L);
    }

    public static final void x0(PatternChatGPTFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L();
        RecyclerView.LayoutManager layoutManager = this$0.v().g.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPosition(this$0.f.getItemCount() - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void y0(com.wear.ui.discover.chatgpt.PatternChatGPTFragment r3, java.lang.Boolean r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.wear.databinding.FragmentChatGptBinding r0 = r3.v()
            android.widget.ImageView r0 = r0.e
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            boolean r4 = r4.booleanValue()
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L32
            com.wear.databinding.FragmentChatGptBinding r3 = r3.v()
            android.widget.EditText r3 = r3.c
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            int r3 = r3.length()
            if (r3 <= 0) goto L2e
            r3 = 1
            goto L2f
        L2e:
            r3 = 0
        L2f:
            if (r3 == 0) goto L32
            goto L33
        L32:
            r1 = 0
        L33:
            r0.setSelected(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.PatternChatGPTFragment.y0(com.wear.ui.discover.chatgpt.PatternChatGPTFragment, java.lang.Boolean):void");
    }

    public static final void z0(PatternChatGPTFragment this$0, Integer it) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v().h.setText(it + " left");
        TextView textView = this$0.v().h;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.intValue() > 0);
        eg3.k(this$0.requireContext(), "patternLefts", it.intValue());
    }

    @Override // com.wear.ui.discover.chatgpt.ChatGPTFragment
    public void O(@NotNull AskingData askingData) {
        Intrinsics.checkNotNullParameter(askingData, "askingData");
        if (A().getH()) {
            return;
        }
        int iIndexOf = this.g.indexOf(askingData) + 1;
        ChatGPTViewModel chatGPTViewModelA = A();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        chatGPTViewModelA.z(contextRequireContext, askingData.getTitle(), askingData, Integer.valueOf(iIndexOf));
    }

    public final void Q0(Pattern pattern) {
        if (my2.i.a().getB()) {
            na2.m().t();
        } else {
            uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new d(pattern, this, null), 3, null);
        }
    }

    public final void R0(ChatGPTPatternBean chatGPTPatternBean) {
        Integer contentType = chatGPTPatternBean.getContentType();
        if (contentType != null && contentType.intValue() == 170) {
            Pattern pattern = ChatGPTPatternBeanKt.toPattern(chatGPTPatternBean);
            new yn3(requireContext(), pattern.getPath(), pattern.getName(), new e(pattern, this));
        }
    }

    public final void S0(ChatGPTPatternBean chatGPTPatternBean) {
        ye3.j("chatgpt pattern", "share_click", "click", FirebaseAnalytics.Event.SHARE, "button", "", chatGPTPatternBean.getSessionTaskId(), -1L);
        ArrayList arrayList = new ArrayList();
        List<IPeopleInfo> users = ch3.i;
        Intrinsics.checkNotNullExpressionValue(users, "users");
        for (IPeopleInfo u : users) {
            if (u.isShowInFriendsList() && !u.isDateIng()) {
                Intrinsics.checkNotNullExpressionValue(u, "u");
                arrayList.add(u);
            }
        }
        if (arrayList.isEmpty()) {
            ToastUtils.z(ah4.e(R.string.gpt_add_friend_hint), new Object[0]);
            return;
        }
        Pattern pattern = ChatGPTPatternBeanKt.toPattern(chatGPTPatternBean);
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_pattern", pattern);
        pj3.g(getContext(), ForwardMessageActivity.class, bundle);
        ye3.j("chatgpt pattern", "send_pattern_click", "click", pattern.getId(), "button", "", chatGPTPatternBean.getSessionTaskId(), -1L);
    }

    public final void T0(View view, final ChatGPTPatternBean chatGPTPatternBean) {
        vn3 vn3Var = new vn3(requireContext());
        vn3Var.b(ah4.e(R.string.common_copy), false, true, new vn3.b() { // from class: dc.iw2
            @Override // dc.vn3.b
            public final void a(int i) {
                PatternChatGPTFragment.U0(this.a, chatGPTPatternBean, i);
            }
        }, R.drawable.icon_chat_copy_white);
        vn3Var.b(ah4.e(R.string.common_delete), false, true, new vn3.b() { // from class: dc.hw2
            @Override // dc.vn3.b
            public final void a(int i) {
                PatternChatGPTFragment.W0(this.a, chatGPTPatternBean, i);
            }
        }, R.drawable.icon_delete_trash_white);
        vn3Var.d(view, 0, 2, new g());
        vn3Var.show();
    }

    public final void e0(ChatGPTPatternBean chatGPTPatternBean, int i) {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new a(chatGPTPatternBean, this, null), 3, null);
    }

    @Override // com.wear.ui.discover.chatgpt.ChatGPTFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        v().g.setAdapter(this.f);
        v().c.setHint(ah4.e(R.string.hint_chatgpt_create_pattern));
        this.f.A0(new zq() { // from class: dc.yv2
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                PatternChatGPTFragment.E0(this.a, baseQuickAdapter, view2, i);
            }
        });
        this.f.E0(new br() { // from class: dc.bw2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                PatternChatGPTFragment.J0(this.a, baseQuickAdapter, view2, i);
            }
        });
        this.f.C0(new ar() { // from class: dc.gw2
            @Override // dc.ar
            public final boolean M1(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                return PatternChatGPTFragment.K0(this.a, baseQuickAdapter, view2, i);
            }
        });
        EditText editText = v().c;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.etInputChat");
        editText.addTextChangedListener(new c());
        v0();
        A().u();
        A().q("pattern");
        v().e.setOnClickListener(new View.OnClickListener() { // from class: dc.cw2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PatternChatGPTFragment.M0(this.a, view2);
            }
        });
        v().f.setOnClickListener(new View.OnClickListener() { // from class: dc.xv2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PatternChatGPTFragment.P0(this.a, view2);
            }
        });
    }

    @Override // com.wear.ui.discover.chatgpt.ChatGPTFragment
    @NotNull
    public List<AskingData> u() {
        return this.g;
    }

    public final void u0(ChatGPTPatternBean chatGPTPatternBean, int i) {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b(chatGPTPatternBean, this, null), 3, null);
    }

    public final void v0() {
        A().o().observe(getViewLifecycleOwner(), new Observer() { // from class: dc.zv2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatternChatGPTFragment.w0(this.a, (ChatGPTPatternBean) obj);
            }
        });
        A().s().observe(getViewLifecycleOwner(), new Observer() { // from class: dc.aw2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatternChatGPTFragment.y0(this.a, (Boolean) obj);
            }
        });
        A().r().observe(getViewLifecycleOwner(), new Observer() { // from class: dc.dw2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                PatternChatGPTFragment.z0(this.a, (Integer) obj);
            }
        });
        A().t().observe(getViewLifecycleOwner(), new Observer() { // from class: dc.fw2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatternChatGPTFragment.A0(this.a, (ChatGPTType) obj);
            }
        });
        A().w().observe(getViewLifecycleOwner(), new Observer() { // from class: dc.jw2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatternChatGPTFragment.C0(this.a, (Boolean) obj);
            }
        });
    }
}
