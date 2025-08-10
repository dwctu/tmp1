package com.wear.ui.longDistance.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityShortVideo;
import com.wear.ui.longDistance.video.component.CompleteView;
import com.wear.ui.longDistance.video.component.StandardVideoController;
import com.wear.ui.longDistance.video.component.VodControlView;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.util.WearUtils;
import com.wear.widget.llong.GesLayout;
import dc.fe3;
import dc.ha3;
import dc.sg3;
import io.agora.rtc2.internal.CommonUtility;
import java.io.File;
import java.io.IOException;
import xyz.doikki.videocontroller.component.GestureView;
import xyz.doikki.videoplayer.player.BaseVideoView;

/* loaded from: classes4.dex */
public class VideoPlayerActivity extends BaseActivity implements View.OnClickListener {
    public EntityShortVideo a;
    public CompleteView b;
    public VodControlView c;
    public StandardVideoController e;

    @BindView(R.id.ac_video_ges_layout)
    public GesLayout gesLayout;

    @BindView(R.id.player)
    public MyVideoView mVideoView;

    @BindView(R.id.pic_big_view)
    public SubsamplingScaleImageView pic_big_view;

    @BindView(R.id.ac_video_root_layout)
    public RelativeLayout rlVideo;
    public boolean d = false;
    public final BaseVideoView.a f = new f();

    public class a implements ha3 {
        public a() {
        }

        @Override // dc.ha3
        public void a() {
            VideoPlayerActivity.this.finish();
        }
    }

    public class b implements ha3 {
        public b() {
        }

        @Override // dc.ha3
        public void a() {
            VideoPlayerActivity.this.finish();
        }
    }

    public class c implements fe3.b {
        public c() {
        }

        @Override // dc.fe3.b
        public void a(long j) {
        }

        @Override // dc.fe3.b
        public void b(String str) {
            VideoPlayerActivity.this.dissDialog();
            sg3.e(VideoPlayerActivity.this, R.string.chat_message_item_save_error);
        }

        @Override // dc.fe3.b
        public void c(String str) {
            VideoPlayerActivity.this.dissDialog();
            VideoPlayerActivity.this.mVideoView.setUrl("file:" + str);
            VideoPlayerActivity.this.mVideoView.start();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayerActivity.this.finish();
        }
    }

    public class e implements GesLayout.e {
        public e() {
        }

        @Override // com.wear.widget.llong.GesLayout.e
        public void b() {
            VideoPlayerActivity.this.finish();
        }
    }

    public class f extends BaseVideoView.b {
        public f() {
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void a(int i) {
            if (i != 3) {
                if (i == 5 && VideoPlayerActivity.this.d) {
                    VideoPlayerActivity.this.finish();
                    return;
                }
                return;
            }
            int[] videoSize = VideoPlayerActivity.this.mVideoView.getVideoSize();
            String str = " 视频宽：" + videoSize[0];
            String str2 = "视频高：" + videoSize[1];
            VideoPlayerActivity.this.dissDialog();
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.b, xyz.doikki.videoplayer.player.BaseVideoView.a
        public void b(int i) {
        }
    }

    public static void u4(Activity activity, EntityShortVideo entityShortVideo) {
        Intent intent = new Intent(activity, (Class<?>) VideoPlayerActivity.class);
        intent.putExtra("entityShortVideo", entityShortVideo);
        activity.startActivity(intent);
    }

    public static void v4(Activity activity, String str) {
        EntityShortVideo entityShortVideo = new EntityShortVideo();
        entityShortVideo.setVideoUrl(str);
        u4(activity, entityShortVideo);
    }

    public static void w4(Activity activity, EntityShortVideo entityShortVideo, int i) {
        Intent intent = new Intent(activity, (Class<?>) VideoPlayerActivity.class);
        intent.putExtra("entityShortVideo", entityShortVideo);
        activity.startActivityForResult(intent, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CompleteView) {
            this.b.setCloseViewVisibility();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WearUtils.C(this);
        Window window = getWindow();
        dissDialog();
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            attributes.flags = 1024 | attributes.flags;
            window.addFlags(512);
        } else {
            window.addFlags(1024);
        }
        setContentView(R.layout.activity_video_play_dkplayer);
        ButterKnife.bind(this);
        t4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IOException {
        super.onDestroy();
        MyVideoView myVideoView = this.mVideoView;
        if (myVideoView != null) {
            myVideoView.u();
        }
        StandardVideoController standardVideoController = this.e;
        if (standardVideoController != null) {
            standardVideoController.A();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MyVideoView myVideoView = this.mVideoView;
        if (myVideoView != null) {
            myVideoView.pause();
        }
        if (this.d) {
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyVideoView myVideoView = this.mVideoView;
        if (myVideoView != null) {
            myVideoView.w();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public final void t4() {
        Intent intent = getIntent();
        if (intent != null) {
            EntityShortVideo entityShortVideo = (EntityShortVideo) intent.getSerializableExtra("entityShortVideo");
            this.a = entityShortVideo;
            if (entityShortVideo instanceof EntityBurnShortVideo) {
                this.d = true;
            }
            if (this.d) {
                getWindow().setFlags(8192, 8192);
            }
            this.e = new StandardVideoController(this);
            if (!this.d) {
                CompleteView completeView = new CompleteView(this);
                this.b = completeView;
                this.e.l(completeView);
                this.b.setOnClickListener(this);
                this.b.setOnCloseListener(new a());
            }
            VodControlView vodControlView = new VodControlView(this);
            this.c = vodControlView;
            vodControlView.k(false);
            this.c.setBurnAfterRead(this.d);
            this.e.l(this.c);
            this.c.setOnCloseListener(new b());
            this.e.l(new GestureView(this));
            this.e.setCanChangePosition(!this.d);
            this.e.setGestureEnabled(false);
            this.e.setAdaptCutout(true);
            this.e.setDoubleTapTogglePlayEnabled(!this.d);
            this.mVideoView.setVideoController(this.e);
            this.mVideoView.i(this.f);
            this.e.show();
            String videoLocalUrl = this.a.getVideoLocalUrl();
            File file = TextUtils.isEmpty(videoLocalUrl) ? null : new File(videoLocalUrl);
            if (WearUtils.e1(videoLocalUrl) || !(file.exists() || videoLocalUrl.startsWith(CommonUtility.PREFIX_URI))) {
                EntityShortVideo entityShortVideo2 = this.a;
                if (entityShortVideo2 == null || WearUtils.e1(entityShortVideo2.getVideoUrl())) {
                    sg3.e(this, R.string.chat_message_item_save_error);
                    finish();
                    return;
                }
                String[] strArrSplit = this.a.getVideoUrl().replace(".mp4", "").split("/");
                String str = strArrSplit[strArrSplit.length - 1];
                File file2 = new File(WearUtils.T("video").getAbsolutePath(), str);
                if (file2.exists()) {
                    videoLocalUrl = file2.toURI().toString();
                } else {
                    showDialog();
                    cancleDelay();
                    if (this.a.getVideoUrl().startsWith("https://") || this.a.getVideoUrl().startsWith("http://")) {
                        videoLocalUrl = this.a.getVideoUrl();
                    } else {
                        videoLocalUrl = WearUtils.e + this.a.getVideoUrl();
                    }
                    new fe3().n(videoLocalUrl, str, this, false, new c());
                }
            } else if (file.exists()) {
                videoLocalUrl = "file://" + videoLocalUrl;
            }
            this.mVideoView.setUrl(videoLocalUrl);
            this.mVideoView.start();
        }
        this.pic_big_view.setOnClickListener(new d());
        this.pic_big_view.setVisibility(0);
        this.gesLayout.setGesListener(new e());
    }
}
