package com.wear.main.closeRange;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.NewCurveLineView;

/* loaded from: classes3.dex */
public class MusicRecordPreviewActivity_ViewBinding implements Unbinder {
    public MusicRecordPreviewActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MusicRecordPreviewActivity a;

        public a(MusicRecordPreviewActivity_ViewBinding musicRecordPreviewActivity_ViewBinding, MusicRecordPreviewActivity musicRecordPreviewActivity) {
            this.a = musicRecordPreviewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MusicRecordPreviewActivity a;

        public b(MusicRecordPreviewActivity_ViewBinding musicRecordPreviewActivity_ViewBinding, MusicRecordPreviewActivity musicRecordPreviewActivity) {
            this.a = musicRecordPreviewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MusicRecordPreviewActivity_ViewBinding(MusicRecordPreviewActivity musicRecordPreviewActivity, View view) {
        this.a = musicRecordPreviewActivity;
        musicRecordPreviewActivity.patternLine = (NewCurveLineView) Utils.findRequiredViewAsType(view, R.id.pattern_line, "field 'patternLine'", NewCurveLineView.class);
        musicRecordPreviewActivity.playTimes = (TextView) Utils.findRequiredViewAsType(view, R.id.play_times, "field 'playTimes'", TextView.class);
        musicRecordPreviewActivity.ivPause = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pause, "field 'ivPause'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_record_pause, "field 'llRecordPause' and method 'onViewClicked'");
        musicRecordPreviewActivity.llRecordPause = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_record_pause, "field 'llRecordPause'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, musicRecordPreviewActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_record_save, "field 'llRecordSave' and method 'onViewClicked'");
        musicRecordPreviewActivity.llRecordSave = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_record_save, "field 'llRecordSave'", LinearLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, musicRecordPreviewActivity));
        musicRecordPreviewActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        musicRecordPreviewActivity.tvRecordTotalTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_record_total_time, "field 'tvRecordTotalTime'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicRecordPreviewActivity musicRecordPreviewActivity = this.a;
        if (musicRecordPreviewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicRecordPreviewActivity.patternLine = null;
        musicRecordPreviewActivity.playTimes = null;
        musicRecordPreviewActivity.ivPause = null;
        musicRecordPreviewActivity.llRecordPause = null;
        musicRecordPreviewActivity.llRecordSave = null;
        musicRecordPreviewActivity.actionbar = null;
        musicRecordPreviewActivity.tvRecordTotalTime = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
