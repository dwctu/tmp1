package com.wear.widget.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.data.AudioBookList;
import com.wear.databinding.DialogAudioBookBinding;
import com.wear.ui.discover.voicebook.VoiceBookActivity;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.AudioBookDialog;
import dc.ce3;
import dc.kf;
import dc.qo;
import dc.qx3;
import dc.zq;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioBookDialog.kt */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000f\u0018\u0000 !2\u00020\u0001:\u0002!\"B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/wear/widget/dialog/AudioBookDialog;", "Landroid/app/Dialog;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/wear/ui/discover/voicebook/VoiceBookActivity;", "audioBookList", "", "Lcom/wear/bean/data/AudioBookList;", "position", "", "(Lcom/wear/ui/discover/voicebook/VoiceBookActivity;Ljava/util/List;I)V", "adapter", "Lcom/wear/widget/dialog/AudioBookDialog$DialogAudioAdapter;", "binding", "Lcom/wear/databinding/DialogAudioBookBinding;", "controllerCallback", "com/wear/widget/dialog/AudioBookDialog$controllerCallback$1", "Lcom/wear/widget/dialog/AudioBookDialog$controllerCallback$1;", "mediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "onPlayClick", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnPlayClick", "()Lkotlin/jvm/functions/Function2;", "setOnPlayClick", "(Lkotlin/jvm/functions/Function2;)V", "dismiss", "initDialog", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "DialogAudioAdapter", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class AudioBookDialog extends Dialog {

    @NotNull
    public final VoiceBookActivity a;

    @NotNull
    public final List<AudioBookList> b;
    public int c;
    public DialogAudioBookBinding d;
    public DialogAudioAdapter e;

    @Nullable
    public MediaControllerCompat f;

    @Nullable
    public Function2<? super View, ? super String, Unit> g;

    @NotNull
    public final a h;

    /* compiled from: AudioBookDialog.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/wear/widget/dialog/AudioBookDialog$DialogAudioAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/data/AudioBookList;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Lcom/wear/widget/dialog/AudioBookDialog;Ljava/util/List;)V", "convert", "", "holder", "item", "initTagAdapter", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "audioBook", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class DialogAudioAdapter extends BaseQuickAdapter<AudioBookList, BaseViewHolder> {
        public final /* synthetic */ AudioBookDialog z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogAudioAdapter(@NotNull AudioBookDialog audioBookDialog, List<AudioBookList> data) {
            super(R.layout.item_dialog_audio_book, CollectionsKt___CollectionsKt.toMutableList((Collection) data));
            Intrinsics.checkNotNullParameter(data, "data");
            this.z = audioBookDialog;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: I0, reason: merged with bridge method [inline-methods] */
        public void C(@NotNull BaseViewHolder holder, @NotNull AudioBookList item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.recyclerView);
            TextView textView = (TextView) holder.getView(R.id.tv_intro);
            J0(recyclerView, item);
            StringBuilder sb = new StringBuilder();
            Integer duration = item.getDuration();
            sb.append(duration != null ? Integer.valueOf(duration.intValue() / 60) : null);
            sb.append(" mins");
            holder.setText(R.id.tv_duration, sb.toString());
            textView.setText(item.getIntro());
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            holder.setText(R.id.tv_title, item.getTitle());
            if (item.isPlay()) {
                holder.setImageResource(R.id.iv_play, R.drawable.ic_audio_book_pause);
            } else {
                holder.setImageResource(R.id.iv_play, R.drawable.ic_audio_book_play);
            }
            qo qoVarJ0 = new qo().j0(new qx3(25, 2));
            Intrinsics.checkNotNullExpressionValue(qoVarJ0, "RequestOptions().transfo…lurTransformation(25, 2))");
            kf.z(this.z.a).v(item.getCoverUrl()).a(qoVarJ0).A0((ImageView) holder.getView(R.id.iv_cover_root));
            kf.z(this.z.a).v(item.getCoverUrl()).A0((ImageView) holder.getView(R.id.riv_audio_book_cover));
        }

        public final void J0(RecyclerView recyclerView, AudioBookList audioBookList) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.z.a);
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            List array = JSON.parseArray(audioBookList.getTagNameListDB(), String.class);
            Intrinsics.checkNotNullExpressionValue(array, "parseArray(audioBook.tag…stDB, String::class.java)");
            final List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) array);
            recyclerView.setAdapter(new BaseQuickAdapter<String, BaseViewHolder>(mutableList) { // from class: com.wear.widget.dialog.AudioBookDialog$DialogAudioAdapter$initTagAdapter$2
                @Override // com.chad.library.adapter.base.BaseQuickAdapter
                /* renamed from: I0, reason: merged with bridge method [inline-methods] */
                public void C(@NotNull BaseViewHolder holder, @NotNull String item) {
                    Intrinsics.checkNotNullParameter(holder, "holder");
                    Intrinsics.checkNotNullParameter(item, "item");
                    View view = holder.itemView;
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) view).setText(item);
                    ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int layoutPosition = holder.getLayoutPosition();
                    if (layoutPosition == 0) {
                        marginLayoutParams.leftMargin = ce3.a(J(), 16.0f);
                        marginLayoutParams.rightMargin = ce3.a(J(), 6.0f);
                    } else if (layoutPosition == getItemCount() - 1) {
                        marginLayoutParams.leftMargin = ce3.a(J(), 6.0f);
                        marginLayoutParams.rightMargin = ce3.a(J(), 16.0f);
                    } else {
                        marginLayoutParams.leftMargin = ce3.a(J(), 6.0f);
                        marginLayoutParams.rightMargin = ce3.a(J(), 6.0f);
                    }
                }
            });
        }
    }

    /* compiled from: AudioBookDialog.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017¨\u0006\u0006"}, d2 = {"com/wear/widget/dialog/AudioBookDialog$controllerCallback$1", "Landroid/support/v4/media/session/MediaControllerCompat$Callback;", "onPlaybackStateChanged", "", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends MediaControllerCompat.Callback {
        public a() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        @SuppressLint({"NotifyDataSetChanged"})
        public void onPlaybackStateChanged(@Nullable PlaybackStateCompat state) {
            DialogAudioAdapter dialogAudioAdapter = AudioBookDialog.this.e;
            if (dialogAudioAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                dialogAudioAdapter = null;
            }
            dialogAudioAdapter.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioBookDialog(@NotNull VoiceBookActivity activity, @NotNull List<AudioBookList> audioBookList, int i) {
        super(activity, R.style.dialog);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(audioBookList, "audioBookList");
        this.a = activity;
        this.b = audioBookList;
        this.c = i;
        this.h = new a();
    }

    public static final void f(AudioBookDialog this$0, BaseQuickAdapter a2, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(view, "view");
        DialogAudioAdapter dialogAudioAdapter = this$0.e;
        if (dialogAudioAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dialogAudioAdapter = null;
        }
        AudioBookList audioBookList = dialogAudioAdapter.K().get(i);
        Function2<? super View, ? super String, Unit> function2 = this$0.g;
        if (function2 != null) {
            String id = audioBookList.getId();
            Intrinsics.checkNotNullExpressionValue(id, "list.id");
            function2.invoke(view, id);
        }
    }

    public final void d() {
        WindowManager.LayoutParams attributes;
        WearUtils.q2(this);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setGravity(17);
            window2.getDecorView().setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        MediaControllerCompat mediaControllerCompat = this.f;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.h);
        }
        super.dismiss();
    }

    public final void g(@Nullable Function2<? super View, ? super String, Unit> function2) {
        this.g = function2;
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) throws IllegalStateException {
        super.onCreate(savedInstanceState);
        DialogAudioBookBinding dialogAudioBookBindingC = DialogAudioBookBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogAudioBookBindingC, "inflate(layoutInflater)");
        this.d = dialogAudioBookBindingC;
        DialogAudioBookBinding dialogAudioBookBinding = null;
        if (dialogAudioBookBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBindingC = null;
        }
        setContentView(dialogAudioBookBindingC.getRoot());
        d();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        DialogAudioBookBinding dialogAudioBookBinding2 = this.d;
        if (dialogAudioBookBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBinding2 = null;
        }
        dialogAudioBookBinding2.b.setLayoutManager(linearLayoutManager);
        DialogAudioAdapter dialogAudioAdapter = new DialogAudioAdapter(this, this.b);
        dialogAudioAdapter.n(R.id.iv_play);
        dialogAudioAdapter.A0(new zq() { // from class: dc.pp3
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AudioBookDialog.f(this.a, baseQuickAdapter, view, i);
            }
        });
        this.e = dialogAudioAdapter;
        DialogAudioBookBinding dialogAudioBookBinding3 = this.d;
        if (dialogAudioBookBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBinding3 = null;
        }
        RecyclerView recyclerView = dialogAudioBookBinding3.b;
        DialogAudioAdapter dialogAudioAdapter2 = this.e;
        if (dialogAudioAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dialogAudioAdapter2 = null;
        }
        recyclerView.setAdapter(dialogAudioAdapter2);
        DialogAudioBookBinding dialogAudioBookBinding4 = this.d;
        if (dialogAudioBookBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBinding4 = null;
        }
        dialogAudioBookBinding4.b.scrollToPosition(this.c);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        DialogAudioBookBinding dialogAudioBookBinding5 = this.d;
        if (dialogAudioBookBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBinding5 = null;
        }
        pagerSnapHelper.attachToRecyclerView(dialogAudioBookBinding5.b);
        MediaControllerCompat mediaController = MediaControllerCompat.getMediaController(this.a);
        this.f = mediaController;
        if (mediaController != null) {
            mediaController.registerCallback(this.h);
        }
        DialogAudioBookBinding dialogAudioBookBinding6 = this.d;
        if (dialogAudioBookBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogAudioBookBinding = dialogAudioBookBinding6;
        }
        dialogAudioBookBinding.b.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.wear.widget.dialog.AudioBookDialog.onCreate.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, newState);
                if (newState == 0) {
                    this.c = linearLayoutManager.findLastVisibleItemPosition();
                }
            }
        });
    }
}
