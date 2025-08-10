package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout;
import com.wear.ui.chat.pancel.helper.view.content.RelativeContentContainer;
import com.wear.ui.chat.widget.AutoHidePanelRecyclerView;
import com.wear.widget.BaseImageButton;
import com.wear.widget.ChatEditText;
import com.wear.widget.EmojisToastView;
import com.wear.widget.MyActionBar;
import com.wear.widget.chatMic.VoiceMessagePanelView;
import com.wear.widget.velvo.VelvoPreviewView;

/* loaded from: classes3.dex */
public abstract class ActivityChatBuildBinding extends ViewDataBinding {

    @NonNull
    public final MyActionBar a;

    @NonNull
    public final RelativeLayout b;

    @NonNull
    public final BaseImageButton c;

    @NonNull
    public final ChatEditText d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final BaseImageButton f;

    @NonNull
    public final BaseImageButton g;

    @NonNull
    public final BaseImageButton h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final TextView j;

    @NonNull
    public final PanelSwitchLayout k;

    @NonNull
    public final AutoHidePanelRecyclerView l;

    @NonNull
    public final VelvoPreviewView m;

    @NonNull
    public final VoiceMessagePanelView n;

    @Bindable
    public NewChatActivity.b o;

    @Bindable
    public ObservableField<String> p;

    public ActivityChatBuildBinding(Object obj, View view, int i, MyActionBar myActionBar, RelativeLayout relativeLayout, BaseImageButton baseImageButton, EmojisToastView emojisToastView, ChatEditText chatEditText, LinearLayout linearLayout, BaseImageButton baseImageButton2, BaseImageButton baseImageButton3, BaseImageButton baseImageButton4, RelativeContentContainer relativeContentContainer, LinearLayout linearLayout2, TextView textView, PanelChatContainerBinding panelChatContainerBinding, PanelSwitchLayout panelSwitchLayout, AutoHidePanelRecyclerView autoHidePanelRecyclerView, View view2, VelvoPreviewView velvoPreviewView, VoiceMessagePanelView voiceMessagePanelView) {
        super(obj, view, i);
        this.a = myActionBar;
        this.b = relativeLayout;
        this.c = baseImageButton;
        this.d = chatEditText;
        this.e = linearLayout;
        this.f = baseImageButton2;
        this.g = baseImageButton3;
        this.h = baseImageButton4;
        this.i = linearLayout2;
        this.j = textView;
        this.k = panelSwitchLayout;
        this.l = autoHidePanelRecyclerView;
        this.m = velvoPreviewView;
        this.n = voiceMessagePanelView;
    }

    @NonNull
    public static ActivityChatBuildBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChatBuildBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChatBuildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_build, null, false, obj);
    }

    public abstract void d(@Nullable ObservableField<String> observableField);

    public abstract void e(@Nullable NewChatActivity.b bVar);

    public abstract void f(@Nullable String str);
}
