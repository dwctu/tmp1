package com.wear.widget.dialog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.util.MyApplication;
import dc.qd3;
import dc.sg3;
import dc.th4;
import java.io.File;
import java.io.IOException;
import xyz.doikki.videoplayer.player.BaseVideoView;

/* loaded from: classes4.dex */
public class LoveEmojisDialog extends AppCompatDialog {
    public Context a;
    public String b;

    @BindView(R.id.confirm_button)
    public Button confirmButton;

    @BindView(R.id.videoPlayer)
    public MyVideoView videoPlayer;

    public class a implements BaseVideoView.a {
        public a() {
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void a(int i) {
            String str = "onPlayStateChanged: 从新播放=" + i;
            if (i == 5) {
                LoveEmojisDialog.this.videoPlayer.d(true);
            }
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void b(int i) {
        }
    }

    public LoveEmojisDialog(Context context) throws IOException {
        super(context, R.style.Fulldialog);
        this.b = "ONEPLUS A6010";
        this.a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(File file) {
        if (file.exists()) {
            String string = file.toURI().toString();
            String str = "onCreate: 视频地址=" + string;
            this.videoPlayer.setUrl(string);
            if (TextUtils.equals(Build.MODEL, this.b)) {
                this.videoPlayer.setLooping(true);
            }
        }
    }

    public final void a() throws IOException {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_love_emojis, (ViewGroup) null);
        ButterKnife.bind(this, viewInflate);
        setContentView(viewInflate);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        if (!TextUtils.equals(Build.MODEL, this.b)) {
            this.videoPlayer.setBackgroundColor(th4.b(this.a, R.color.common_dialog_bg_color));
            this.videoPlayer.i(new a());
        }
        if (MyApplication.m0 == 0) {
            f(MyApplication.l0);
        }
        if (MyApplication.m0 == 1) {
            f(false);
        }
        if (MyApplication.m0 == 2) {
            f(true);
        }
        this.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: dc.mq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.c(view);
            }
        });
    }

    public final void f(boolean z) throws IOException {
        String str = z ? "love_emojis/black_pop.mp4" : "love_emojis/white_pop.mp4";
        if (!TextUtils.isEmpty(str)) {
            qd3.a(this.a, str, new qd3.a() { // from class: dc.nq3
                @Override // dc.qd3.a
                public final void a(File file) {
                    this.a.e(file);
                }
            });
        } else {
            dismiss();
            sg3.l("视频文件不存在！");
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.videoPlayer.start();
    }
}
