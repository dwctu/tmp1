package com.wear.main.closeRange;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MusicRecordActivity_ViewBinding implements Unbinder {
    public MusicRecordActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MusicRecordActivity a;

        public a(MusicRecordActivity_ViewBinding musicRecordActivity_ViewBinding, MusicRecordActivity musicRecordActivity) {
            this.a = musicRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IOException {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MusicRecordActivity a;

        public b(MusicRecordActivity_ViewBinding musicRecordActivity_ViewBinding, MusicRecordActivity musicRecordActivity) {
            this.a = musicRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IOException {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MusicRecordActivity a;

        public c(MusicRecordActivity_ViewBinding musicRecordActivity_ViewBinding, MusicRecordActivity musicRecordActivity) {
            this.a = musicRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IOException {
            this.a.onViewClicked(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MusicRecordActivity a;

        public d(MusicRecordActivity_ViewBinding musicRecordActivity_ViewBinding, MusicRecordActivity musicRecordActivity) {
            this.a = musicRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IOException {
            this.a.onViewClicked(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MusicRecordActivity a;

        public e(MusicRecordActivity_ViewBinding musicRecordActivity_ViewBinding, MusicRecordActivity musicRecordActivity) {
            this.a = musicRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IOException {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MusicRecordActivity_ViewBinding(MusicRecordActivity musicRecordActivity, View view) {
        this.a = musicRecordActivity;
        musicRecordActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        musicRecordActivity.ivMusicRecord = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_music_record, "field 'ivMusicRecord'", ImageView.class);
        musicRecordActivity.tvRecordTimes = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_record_times, "field 'tvRecordTimes'", TextView.class);
        musicRecordActivity.tvMusicRecordName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_music_record_name, "field 'tvMusicRecordName'", TextView.class);
        musicRecordActivity.tvMusicRecordProgress = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_music_record_progress, "field 'tvMusicRecordProgress'", TextView.class);
        musicRecordActivity.sbMusicRecord = (SeekBar) Utils.findRequiredViewAsType(view, R.id.sb_music_record, "field 'sbMusicRecord'", SeekBar.class);
        musicRecordActivity.tvMusicRecordTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_music_record_time, "field 'tvMusicRecordTime'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_re_recording, "field 'llReRecording' and method 'onViewClicked'");
        musicRecordActivity.llReRecording = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_re_recording, "field 'llReRecording'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, musicRecordActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_record_preview, "field 'llRecordPreview' and method 'onViewClicked'");
        musicRecordActivity.llRecordPreview = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_record_preview, "field 'llRecordPreview'", LinearLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, musicRecordActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_record_save, "field 'llRecordSave' and method 'onViewClicked'");
        musicRecordActivity.llRecordSave = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_record_save, "field 'llRecordSave'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, musicRecordActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_record_pause, "field 'llRecordPause' and method 'onViewClicked'");
        musicRecordActivity.llRecordPause = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.ll_record_pause, "field 'llRecordPause'", LinearLayout.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, musicRecordActivity));
        musicRecordActivity.ivPause = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pause, "field 'ivPause'", ImageView.class);
        musicRecordActivity.llPlaying = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_playing, "field 'llPlaying'", LinearLayout.class);
        musicRecordActivity.llLoadStatus = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_load_status, "field 'llLoadStatus'", LinearLayout.class);
        musicRecordActivity.llBottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_bottom, "field 'llBottom'", LinearLayout.class);
        musicRecordActivity.tvMusicRecordName1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_music_record_name_1, "field 'tvMusicRecordName1'", TextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_music_record_status, "field 'tvMusicRecordStatus' and method 'onViewClicked'");
        musicRecordActivity.tvMusicRecordStatus = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_music_record_status, "field 'tvMusicRecordStatus'", TextView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, musicRecordActivity));
        musicRecordActivity.ivLoading = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_loading, "field 'ivLoading'", ImageView.class);
        musicRecordActivity.mLlRecordProgress = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_record_progress, "field 'mLlRecordProgress'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicRecordActivity musicRecordActivity = this.a;
        if (musicRecordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicRecordActivity.actionbar = null;
        musicRecordActivity.ivMusicRecord = null;
        musicRecordActivity.tvRecordTimes = null;
        musicRecordActivity.tvMusicRecordName = null;
        musicRecordActivity.tvMusicRecordProgress = null;
        musicRecordActivity.sbMusicRecord = null;
        musicRecordActivity.tvMusicRecordTime = null;
        musicRecordActivity.llReRecording = null;
        musicRecordActivity.llRecordPreview = null;
        musicRecordActivity.llRecordSave = null;
        musicRecordActivity.llRecordPause = null;
        musicRecordActivity.ivPause = null;
        musicRecordActivity.llPlaying = null;
        musicRecordActivity.llLoadStatus = null;
        musicRecordActivity.llBottom = null;
        musicRecordActivity.tvMusicRecordName1 = null;
        musicRecordActivity.tvMusicRecordStatus = null;
        musicRecordActivity.ivLoading = null;
        musicRecordActivity.mLlRecordProgress = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}
