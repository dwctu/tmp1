package com.wear.ui.discover.voicebook;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.wear.bean.data.AudioBookList;
import com.wear.bean.data.AudioBookListBean;
import com.wear.bean.data.AudioBookTagBean;
import com.wear.bean.data.TagList;
import com.wear.dao.DaoUtils;
import com.wear.network.protocol.exception.NetException;
import dc.ad4;
import dc.bd4;
import dc.eg3;
import dc.n04;
import dc.ro2;
import dc.sy3;
import dc.tn2;
import dc.uy3;
import dc.vc4;
import dc.wz3;
import dc.yc4;
import dc.zn2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.json.JSONObject;

/* compiled from: VoiceBookViewModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170#R'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\bR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\bR'\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0018\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/wear/ui/discover/voicebook/VoiceBookViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "audioBookList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/wear/bean/data/AudioBookList;", "getAudioBookList", "()Landroidx/lifecycle/MutableLiveData;", "audioBookList$delegate", "Lkotlin/Lazy;", "filterText", "", "getFilterText", "filterText$delegate", "hideProgressBar", "", "getHideProgressBar", "hideProgressBar$delegate", "netWorkConnected", "getNetWorkConnected", "netWorkConnected$delegate", "tagList", "Lcom/wear/bean/data/TagList;", "getTagList", "tagList$delegate", "downloadPattern", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lcom/wear/bean/data/AudioBookList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "featAudioBookList", "featAudioBookTagList", "filterTag", "data", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceBookViewModel extends ViewModel {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(h.a);

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public final Lazy c = LazyKt__LazyJVMKt.lazy(e.a);

    @NotNull
    public final Lazy d = LazyKt__LazyJVMKt.lazy(g.a);

    @NotNull
    public final Lazy e = LazyKt__LazyJVMKt.lazy(f.a);

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/wear/bean/data/AudioBookList;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<MutableLiveData<List<? extends AudioBookList>>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<List<AudioBookList>> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicebook.VoiceBookViewModel$downloadPattern$2", f = "VoiceBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ AudioBookList $audioBookList;
        public final /* synthetic */ Context $context;
        public int label;
        public final /* synthetic */ VoiceBookViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AudioBookList audioBookList, Context context, VoiceBookViewModel voiceBookViewModel, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$audioBookList = audioBookList;
            this.$context = context;
            this.this$0 = voiceBookViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$audioBookList, this.$context, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IOException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            vc4 vc4VarB = new vc4.b().b();
            yc4.a aVar = new yc4.a();
            aVar.d();
            aVar.k(this.$audioBookList.getPatternUrl());
            try {
                ad4 ad4VarExecute = vc4VarB.a(aVar.b()).execute();
                if (ad4VarExecute.isSuccessful()) {
                    File file = new File(this.$context.getExternalFilesDir("wear/audioBook"), this.$audioBookList.getId() + ".json");
                    bd4 bd4VarB = ad4VarExecute.b();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bd4VarB != null ? bd4VarB.byteStream() : null));
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        bufferedWriter.write(line);
                    }
                    bufferedReader.close();
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                this.this$0.h().postValue(Boxing.boxBoolean(true));
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/voicebook/VoiceBookViewModel$featAudioBookList$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements zn2<String> {
        public final /* synthetic */ Context b;

        /* compiled from: VoiceBookViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.voicebook.VoiceBookViewModel$featAudioBookList$1$onSuccess$1$1", f = "VoiceBookViewModel.kt", i = {}, l = {CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ AudioBookListBean $audioBookListBean;
            public final /* synthetic */ Context $context;
            public Object L$0;
            public Object L$1;
            public Object L$2;
            public int label;
            public final /* synthetic */ VoiceBookViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, AudioBookListBean audioBookListBean, VoiceBookViewModel voiceBookViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$audioBookListBean = audioBookListBean;
                this.this$0 = voiceBookViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$context, this.$audioBookListBean, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a aVar;
                Context context;
                VoiceBookViewModel voiceBookViewModel;
                Iterator it;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Object objB = eg3.b(this.$context, "audio_book_update_time", Boxing.boxLong(0L));
                    Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type kotlin.Long");
                    if (((Long) objB).longValue() >= this.$audioBookListBean.getData().getLastUpdateTimestamp()) {
                        aVar = this;
                        aVar.this$0.h().postValue(Boxing.boxBoolean(true));
                        return Unit.INSTANCE;
                    }
                    List<AudioBookList> list = this.$audioBookListBean.getData().getList();
                    VoiceBookViewModel voiceBookViewModel2 = this.this$0;
                    context = this.$context;
                    voiceBookViewModel = voiceBookViewModel2;
                    it = list.iterator();
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.L$2;
                    context = (Context) this.L$1;
                    voiceBookViewModel = (VoiceBookViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                aVar = this;
                while (it.hasNext()) {
                    AudioBookList audioBookList = (AudioBookList) it.next();
                    DaoUtils.getAudioBookListDao().updateOrAdd(audioBookList);
                    aVar.L$0 = voiceBookViewModel;
                    aVar.L$1 = context;
                    aVar.L$2 = it;
                    aVar.label = 1;
                    if (voiceBookViewModel.b(context, audioBookList, aVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                eg3.i(aVar.$context, "audio_book_update_time", Boxing.boxLong(aVar.$audioBookListBean.getData().getLastUpdateTimestamp()));
                aVar.this$0.f().postValue(aVar.$audioBookListBean.getData().getList());
                aVar.this$0.h().postValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
        }

        public c(Context context) {
            this.b = context;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            if (str != null) {
                VoiceBookViewModel voiceBookViewModel = VoiceBookViewModel.this;
                uy3.d(ViewModelKt.getViewModelScope(voiceBookViewModel), null, null, new a(this.b, (AudioBookListBean) ro2.a(str, AudioBookListBean.class), voiceBookViewModel, null), 3, null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            VoiceBookViewModel.this.h().postValue(Boolean.TRUE);
        }
    }

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/voicebook/VoiceBookViewModel$featAudioBookTagList$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements zn2<String> {
        public final /* synthetic */ Context b;

        /* compiled from: VoiceBookViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.voicebook.VoiceBookViewModel$featAudioBookTagList$1$onSuccess$1$1", f = "VoiceBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ AudioBookTagBean $audioBookTagBean;
            public final /* synthetic */ Context $context;
            public int label;
            public final /* synthetic */ VoiceBookViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, AudioBookTagBean audioBookTagBean, VoiceBookViewModel voiceBookViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$audioBookTagBean = audioBookTagBean;
                this.this$0 = voiceBookViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$context, this.$audioBookTagBean, this.this$0, continuation);
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
                Object objB = eg3.b(this.$context, "audio_book_tag_update_time", Boxing.boxLong(0L));
                Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type kotlin.Long");
                if (((Long) objB).longValue() < this.$audioBookTagBean.getData().getLastUpdateTimestamp()) {
                    Iterator<T> it = this.$audioBookTagBean.getData().getList().iterator();
                    while (it.hasNext()) {
                        DaoUtils.getAudioBookTagDao().updateOrAdd((TagList) it.next());
                    }
                    eg3.i(this.$context, "audio_book_tag_update_time", Boxing.boxLong(this.$audioBookTagBean.getData().getLastUpdateTimestamp()));
                    this.this$0.j().postValue(this.$audioBookTagBean.getData().getList());
                }
                return Unit.INSTANCE;
            }
        }

        public d(Context context) {
            this.b = context;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            if (str != null) {
                VoiceBookViewModel voiceBookViewModel = VoiceBookViewModel.this;
                uy3.d(ViewModelKt.getViewModelScope(voiceBookViewModel), null, null, new a(this.b, (AudioBookTagBean) ro2.a(str, AudioBookTagBean.class), voiceBookViewModel, null), 3, null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
        }
    }

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<MutableLiveData<String>> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<String> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<MutableLiveData<Boolean>> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<Boolean> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<MutableLiveData<Boolean>> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<Boolean> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceBookViewModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/wear/bean/data/TagList;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<MutableLiveData<List<? extends TagList>>> {
        public static final h a = new h();

        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<List<TagList>> invoke() {
            return new MutableLiveData<>();
        }
    }

    public final Object b(Context context, AudioBookList audioBookList, Continuation<? super Unit> continuation) {
        Object objG = sy3.g(n04.b(), new b(audioBookList, context, this, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final void c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<AudioBookList> listFindAll = DaoUtils.getAudioBookListDao().findAll();
        if (listFindAll != null) {
            f().postValue(listFindAll);
            h().setValue(Boolean.TRUE);
        }
        tn2.x(context).m("/audiobook/list", new JSONObject().toString(), new c(context));
    }

    public final void d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<TagList> listFindAll = DaoUtils.getAudioBookTagDao().findAll();
        if (listFindAll != null) {
            j().setValue(listFindAll);
        } else {
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting())) {
                i().setValue(Boolean.FALSE);
                return;
            }
        }
        tn2.x(context).l("/audiobook/taglist", new HashMap(), new d(context));
    }

    public final void e(@NotNull List<TagList> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        StringBuilder sb = new StringBuilder();
        for (TagList tagList : data) {
            if (tagList.getSelect()) {
                sb.append(tagList.getName());
            }
        }
        g().postValue(sb.toString());
    }

    @NotNull
    public final MutableLiveData<List<AudioBookList>> f() {
        return (MutableLiveData) this.b.getValue();
    }

    @NotNull
    public final MutableLiveData<String> g() {
        return (MutableLiveData) this.c.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> h() {
        return (MutableLiveData) this.e.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return (MutableLiveData) this.d.getValue();
    }

    @NotNull
    public final MutableLiveData<List<TagList>> j() {
        return (MutableLiveData) this.a.getValue();
    }
}
