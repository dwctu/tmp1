package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
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
import dc.zu1;

/* loaded from: classes3.dex */
public class ActivityChatBuildBindingImpl extends ActivityChatBuildBinding implements zu1.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts v = null;

    @Nullable
    public static final SparseIntArray w;

    @NonNull
    public final RelativeLayout q;

    @Nullable
    public final View.OnClickListener r;

    @Nullable
    public final View.OnClickListener s;
    public InverseBindingListener t;
    public long u;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivityChatBuildBindingImpl.this.d);
            ObservableField<String> observableField = ActivityChatBuildBindingImpl.this.p;
            if (observableField != null) {
                observableField.set(textString);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R.id.panel_chat_container, 5);
        sparseIntArray.put(R.id.actionbar, 6);
        sparseIntArray.put(R.id.control_end, 7);
        sparseIntArray.put(R.id.control_time, 8);
        sparseIntArray.put(R.id.v_top_line, 9);
        sparseIntArray.put(R.id.content_view, 10);
        sparseIntArray.put(R.id.recycler_view, 11);
        sparseIntArray.put(R.id.bottom_action, 12);
        sparseIntArray.put(R.id.chat_voice, 13);
        sparseIntArray.put(R.id.chat_message_container, 14);
        sparseIntArray.put(R.id.chat_emojis, 15);
        sparseIntArray.put(R.id.voice_message_panel_view, 16);
        sparseIntArray.put(R.id.chat_emojis_toast_layer, 17);
        sparseIntArray.put(R.id.velvo_preview, 18);
    }

    public ActivityChatBuildBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, v, w));
    }

    @Override // dc.zu1.a
    public final void a(int i, View view) {
        if (i == 1) {
            NewChatActivity.b bVar = this.o;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        NewChatActivity.b bVar2 = this.o;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    @Override // com.wear.databinding.ActivityChatBuildBinding
    public void d(@Nullable ObservableField<String> observableField) {
        updateRegistration(0, observableField);
        this.p = observableField;
        synchronized (this) {
            this.u |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ActivityChatBuildBinding
    public void e(@Nullable NewChatActivity.b bVar) {
        this.o = bVar;
        synchronized (this) {
            this.u |= 2;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.u;
            this.u = 0L;
        }
        ObservableField<String> observableField = this.p;
        long j2 = 9 & j;
        String str = (j2 == 0 || observableField == null) ? null : observableField.get();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.d, str);
        }
        if ((j & 8) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.d, null, null, null, this.t);
            this.f.setOnClickListener(this.s);
            this.g.setOnClickListener(this.r);
        }
    }

    @Override // com.wear.databinding.ActivityChatBuildBinding
    public void f(@Nullable String str) {
    }

    public final boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return g((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (14 == i) {
            e((NewChatActivity.b) obj);
        } else if (26 == i) {
            f((String) obj);
        } else {
            if (4 != i) {
                return false;
            }
            d((ObservableField) obj);
        }
        return true;
    }

    public ActivityChatBuildBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (MyActionBar) objArr[6], (RelativeLayout) objArr[12], (BaseImageButton) objArr[15], (EmojisToastView) objArr[17], (ChatEditText) objArr[4], (LinearLayout) objArr[14], (BaseImageButton) objArr[2], (BaseImageButton) objArr[3], (BaseImageButton) objArr[13], (RelativeContentContainer) objArr[10], (LinearLayout) objArr[7], (TextView) objArr[8], objArr[5] != null ? PanelChatContainerBinding.a((View) objArr[5]) : null, (PanelSwitchLayout) objArr[1], (AutoHidePanelRecyclerView) objArr[11], (View) objArr[9], (VelvoPreviewView) objArr[18], (VoiceMessagePanelView) objArr[16]);
        this.t = new a();
        this.u = -1L;
        this.d.setTag(null);
        this.f.setTag(null);
        this.g.setTag("open");
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.q = relativeLayout;
        relativeLayout.setTag(null);
        this.k.setTag(null);
        setRootTag(view);
        this.r = new zu1(this, 2);
        this.s = new zu1(this, 1);
        invalidateAll();
    }
}
