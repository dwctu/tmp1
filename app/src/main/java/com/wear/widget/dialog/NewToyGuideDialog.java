package com.wear.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.util.MyApplication;
import dc.ah4;
import dc.is3;
import dc.qd3;
import dc.sg3;
import dc.th4;
import java.io.File;
import java.io.IOException;
import xyz.doikki.videoplayer.player.BaseVideoView;

/* loaded from: classes4.dex */
public class NewToyGuideDialog extends is3 {

    @BindView(R.id.button)
    public Button button;
    public boolean f;
    public boolean g;
    public b h;

    @BindView(R.id.title)
    public TextView title;

    @BindView(R.id.videoPlayer)
    public MyVideoView videoPlayer;

    public class a implements BaseVideoView.a {
        public a() {
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void a(int i) {
            String str = "onPlayStateChanged: 从新播放=" + i;
            if (i == 5) {
                NewToyGuideDialog.this.videoPlayer.d(true);
            }
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void b(int i) {
        }
    }

    public interface b {
        void a();
    }

    public NewToyGuideDialog(Context context) {
        super(context);
        this.f = true;
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) throws IOException {
        b bVar = this.h;
        if (bVar != null) {
            bVar.a();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(File file) {
        if (file.exists()) {
            String string = file.toURI().toString();
            String str = "onCreate: 视频地址=" + string;
            this.videoPlayer.setUrl(string);
            if (this.f) {
                this.videoPlayer.setLooping(true);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() throws IOException {
        super.dismiss();
        MyVideoView myVideoView = this.videoPlayer;
        if (myVideoView != null) {
            myVideoView.u();
        }
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_new_toy_guide_layout;
    }

    @Override // dc.is3
    public void h() {
        this.a = new is3.a();
        super.h();
        this.videoPlayer.setBackgroundColor(th4.b(this.b, R.color.common_dialog_bg_color));
        if (!this.f) {
            this.videoPlayer.i(new a());
        }
        this.button.setOnClickListener(new View.OnClickListener() { // from class: dc.qq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.a.q(view);
            }
        });
    }

    @Override // dc.is3, dc.lf3
    public void onDestroy() throws IOException {
        super.onDestroy();
        this.videoPlayer.u();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.videoPlayer.start();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        String str = "onWindowFocusChanged: " + z + "NewToyGuideDialog";
        if (z) {
            this.videoPlayer.start();
        }
    }

    public void setOnButtonClick(b bVar) {
        this.h = bVar;
    }

    @Override // dc.is3, android.app.Dialog
    public void show() {
        super.show();
        this.title.setText(this.g ? ah4.e(R.string.remote_control_guide1) : ah4.e(R.string.remote_control_guide2));
        if (MyApplication.m0 == 0) {
            t(MyApplication.l0);
        }
        if (MyApplication.m0 == 1) {
            t(false);
        }
        if (MyApplication.m0 == 2) {
            t(true);
        }
        this.videoPlayer.start();
    }

    public final void t(boolean z) throws IOException {
        String str = this.g ? z ? "new_toy_guide/dark_choose_ball.mp4" : "new_toy_guide/light_choose_ball.mp4" : z ? "new_toy_guide/dark_combine_separate.mp4" : "new_toy_guide/light_combine_separate.mp4";
        if (!TextUtils.isEmpty(str)) {
            qd3.a(this.b, str, new qd3.a() { // from class: dc.rq3
                @Override // dc.qd3.a
                public final void a(File file) {
                    this.a.s(file);
                }
            });
        } else {
            dismiss();
            sg3.l("视频文件不存在！");
        }
    }

    public NewToyGuideDialog(Context context, int i) {
        super(context, i);
        this.f = true;
        this.g = false;
    }

    public NewToyGuideDialog(Context context, boolean z) {
        super(context);
        this.f = true;
        this.g = false;
        this.g = z;
    }
}
