package com.wear.ui.longDistance;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.FileProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.util.camera.TakeView;
import com.wear.util.camera.record.widget.CameraView;
import com.wear.util.camera.record.widget.FocusImageView;
import dc.ah4;
import dc.eg3;
import dc.gg3;
import dc.kh3;
import dc.kn3;
import dc.li3;
import dc.q61;
import dc.ri3;
import dc.t51;
import dc.tg3;
import dc.th4;
import dc.u51;
import dc.vg3;
import dc.ye3;
import io.agora.rtc2.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class CameraNewActivity extends BaseActivity implements SensorEventListener, kh3.a, View.OnTouchListener, CameraView.d {
    public static int C;
    public static int D;
    public long B;
    public int a;
    public MediaPlayer c;
    public Bitmap f;
    public int g;

    @BindView(R.id.ac_camera_iv_burn)
    public ImageView ivBurn;

    @BindView(R.id.ac_camera_iv_cancle)
    public ImageView ivCancle;

    @BindView(R.id.ac_camera_iv_flash)
    public ImageView ivFlash;

    @BindView(R.id.ac_camera_preview_photo)
    public ImageView ivPreview;

    @BindView(R.id.ac_camera_iv_roate)
    public ImageView ivRoate;
    public String j;
    public String k;
    public String l;

    @BindView(R.id.ac_camera_root_layout)
    public RelativeLayout llScreanRootLayout;

    @BindView(R.id.ac_camera_ll_pb)
    public LinearLayout ll_pb_loading;
    public String m;

    @BindView(R.id.ac_camera_cameraview)
    public CameraView mCameraView;

    @BindView(R.id.ac_camera_focusImageView)
    public FocusImageView mFocus;

    @BindView(R.id.ac_camera_surfaceview)
    public SurfaceView mSurfaceView;
    public boolean n;
    public boolean o;

    @BindView(R.id.ac_camera_pb)
    public ProgressBar pb_loading;
    public kh3 q;
    public OrientationEventListener t;

    @BindView(R.id.ac_camera_takeview)
    public TakeView takeView;

    @BindView(R.id.ac_camera_tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_duration)
    public TextView tvDuration;

    @BindView(R.id.ac_camera_tv_send)
    public TextView tvSend;

    @BindView(R.id.ac_camera_tv_photo)
    public TextView tvTakeType;

    @BindView(R.id.tv_tip)
    public TextView tvTips;
    public float u;
    public float v;
    public Camera.AutoFocusCallback b = new c();
    public boolean d = false;
    public int e = 0;
    public int h = 0;
    public byte[] i = null;
    public boolean p = false;
    public Camera.PictureCallback s = new d();
    public Handler w = new Handler();
    public float x = 0.0f;
    public float y = 30.0f;
    public float z = 1.0f;
    public Runnable A = new e();

    public class a implements MediaPlayer.OnCompletionListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
            CameraNewActivity.this.c.stop();
            CameraNewActivity.this.c.reset();
        }
    }

    public class b implements kn3.d {
        public b() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(CameraNewActivity.this);
        }
    }

    public class c implements Camera.AutoFocusCallback {
        public c() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            String str = "----onAutoFocus====" + z;
            if (z) {
                CameraNewActivity.this.mFocus.b();
            } else {
                CameraNewActivity.this.mFocus.a();
            }
        }
    }

    public class d implements Camera.PictureCallback {
        public d() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            CameraNewActivity.this.e = 0;
            CameraNewActivity.this.d = true;
            if (bArr != null) {
                CameraNewActivity.this.i = new byte[bArr.length];
                CameraNewActivity.this.i = (byte[]) bArr.clone();
                CameraNewActivity.this.q5();
            }
            CameraNewActivity.this.p = false;
        }
    }

    public class e implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb;
                String str;
                CameraNewActivity cameraNewActivity = CameraNewActivity.this;
                cameraNewActivity.takeView.setProgress(cameraNewActivity.x);
                int iCeil = ((int) Math.ceil(CameraNewActivity.this.x)) - 1;
                if (iCeil > 30) {
                    iCeil = 30;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("00:");
                if (iCeil < 10) {
                    sb = new StringBuilder();
                    str = "0";
                } else {
                    sb = new StringBuilder();
                    str = "";
                }
                sb.append(str);
                sb.append(iCeil);
                sb2.append(sb.toString());
                CameraNewActivity.this.tvTakeType.setText(sb2.toString());
                CameraNewActivity.this.tvTakeType.setVisibility(0);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraNewActivity cameraNewActivity = CameraNewActivity.this;
                cameraNewActivity.takeView.w(cameraNewActivity.x < CameraNewActivity.this.z);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraNewActivity.this.pb_loading.setVisibility(4);
                CameraNewActivity.this.ll_pb_loading.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CameraNewActivity.this.mSurfaceView.getLayoutParams();
                layoutParams.width = -1;
                int i = CameraNewActivity.D;
                if (i % 180 == 0 || i == -1) {
                    layoutParams.height = -1;
                } else {
                    layoutParams.height = (int) ((gg3.e(CameraNewActivity.this) * (CameraNewActivity.this.mCameraView.getDataWidth() + 0.1f)) / (CameraNewActivity.this.mCameraView.getDataHeight() + 0.1f));
                }
                CameraNewActivity.this.mSurfaceView.setLayoutParams(layoutParams);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraNewActivity.this.ll_pb_loading.setVisibility(4);
                CameraNewActivity.this.g5();
            }
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            CameraNewActivity.D = CameraNewActivity.C;
            CameraNewActivity.this.x = 0.0f;
            try {
                File file = new File(CameraNewActivity.this.k);
                if (file.exists()) {
                    file.delete();
                }
                CameraNewActivity cameraNewActivity = CameraNewActivity.this;
                cameraNewActivity.mCameraView.setSavePath(cameraNewActivity.k);
                CameraNewActivity.this.mCameraView.g();
                while (CameraNewActivity.this.x < CameraNewActivity.this.y) {
                    CameraNewActivity cameraNewActivity2 = CameraNewActivity.this;
                    TakeView takeView = cameraNewActivity2.takeView;
                    if (TakeView.p) {
                        break;
                    }
                    CameraNewActivity.O4(cameraNewActivity2, 0.05f);
                    CameraNewActivity.this.runOnMainThread(new a());
                    Thread.sleep(50L);
                }
                CameraNewActivity.this.runOnMainThread(new b());
                CameraNewActivity.this.mCameraView.i();
            } catch (Exception e) {
                e.printStackTrace();
            }
            CameraNewActivity.this.runOnMainThread(new c());
            CameraNewActivity.this.w.postDelayed(new d(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    public class f implements TakeView.h {
        public f() {
        }

        @Override // com.wear.util.camera.TakeView.h
        public void a() {
            CameraNewActivity.this.e = 0;
            CameraNewActivity.this.d = true;
            try {
                if (CameraNewActivity.this.mCameraView.getmCamera().e() == null || CameraNewActivity.this.p) {
                    return;
                }
                CameraNewActivity.this.p = true;
                CameraNewActivity.this.mCameraView.getmCamera().e().takePicture(null, null, CameraNewActivity.this.s);
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }

        @Override // com.wear.util.camera.TakeView.h
        public void b() {
            CameraNewActivity.this.f5();
        }

        @Override // com.wear.util.camera.TakeView.h
        public void c() {
            CameraNewActivity.this.g5();
        }

        @Override // com.wear.util.camera.TakeView.h
        public void d() {
            CameraNewActivity.this.Z4();
            CameraNewActivity.this.W2();
        }
    }

    public class g extends OrientationEventListener {
        public g(Context context, int i) {
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            CameraNewActivity cameraNewActivity = CameraNewActivity.this;
            cameraNewActivity.v = cameraNewActivity.u;
            if (i >= 225 && i <= 315) {
                CameraNewActivity.this.u = 270.0f;
                CameraNewActivity.C = Constants.VIDEO_ORIENTATION_270;
                CameraNewActivity cameraNewActivity2 = CameraNewActivity.this;
                cameraNewActivity2.p5(cameraNewActivity2.v, CameraNewActivity.this.u);
            }
            if (i >= 45 && i <= 135) {
                CameraNewActivity.this.u = 90.0f;
                CameraNewActivity.C = 90;
                CameraNewActivity cameraNewActivity3 = CameraNewActivity.this;
                cameraNewActivity3.p5(cameraNewActivity3.v, CameraNewActivity.this.u);
            }
            if (i < 45 || i > 315) {
                CameraNewActivity.this.u = 0.0f;
                CameraNewActivity.C = 0;
                CameraNewActivity cameraNewActivity4 = CameraNewActivity.this;
                cameraNewActivity4.p5(cameraNewActivity4.v, CameraNewActivity.this.u);
            }
            if (i > 135 && i < 225) {
                CameraNewActivity.this.u = 0.0f;
                CameraNewActivity.C = 0;
                CameraNewActivity cameraNewActivity5 = CameraNewActivity.this;
                cameraNewActivity5.p5(cameraNewActivity5.v, CameraNewActivity.this.u);
            }
            if (i == -1) {
                CameraNewActivity.this.u = 0.0f;
                CameraNewActivity.C = 0;
                CameraNewActivity cameraNewActivity6 = CameraNewActivity.this;
                cameraNewActivity6.p5(cameraNewActivity6.v, CameraNewActivity.this.u);
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            String str;
            int iCeil = ((int) Math.ceil(CameraNewActivity.this.x)) - 1;
            if (iCeil < 1) {
                iCeil = 1;
            }
            if (iCeil > 30) {
                iCeil = 30;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("00:");
            if (iCeil < 10) {
                sb = new StringBuilder();
                str = "0";
            } else {
                sb = new StringBuilder();
                str = "";
            }
            sb.append(str);
            sb.append(iCeil);
            sb2.append(sb.toString());
            CameraNewActivity.this.tvDuration.setText(sb2.toString());
            CameraNewActivity.this.tvTakeType.setVisibility(8);
            CameraNewActivity.this.e = 1;
            CameraNewActivity.this.d = true;
            CameraNewActivity.this.q5();
            CameraNewActivity.this.X4();
            CameraNewActivity.this.mCameraView.i();
            CameraNewActivity cameraNewActivity = CameraNewActivity.this;
            cameraNewActivity.h5(cameraNewActivity.k);
        }
    }

    public class i implements u51 {
        public i() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            CameraNewActivity.this.finish();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                CameraNewActivity.this.i5();
            }
        }
    }

    public class j implements SurfaceHolder.Callback {
        public final /* synthetic */ String a;

        public j(String str) {
            this.a = str;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            if (CameraNewActivity.this.o) {
                CameraNewActivity.this.b5(this.a);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (CameraNewActivity.this.c != null) {
                CameraNewActivity.this.c.release();
                CameraNewActivity.this.c = null;
            }
        }
    }

    public class k implements MediaPlayer.OnPreparedListener {
        public k() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            CameraNewActivity.this.c.start();
            CameraNewActivity.this.c.setDisplay(CameraNewActivity.this.mSurfaceView.getHolder());
        }
    }

    public static /* synthetic */ float O4(CameraNewActivity cameraNewActivity, float f2) {
        float f3 = cameraNewActivity.x + f2;
        cameraNewActivity.x = f3;
        return f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        o5(false);
    }

    public int T4() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.h, cameraInfo);
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = Constants.VIDEO_ORIENTATION_270;
            }
        }
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i2) % 360)) % 360 : ((cameraInfo.orientation - i2) + 360) % 360;
    }

    public int U4(float f2, float f3) {
        if (Math.abs(f2) <= 6.0f || Math.abs(f3) >= 4.0f) {
            return (Math.abs(f3) <= 6.0f || Math.abs(f2) >= 4.0f || f3 > 6.0f) ? 0 : 180;
        }
        if (f2 > 6.0f) {
            return Constants.VIDEO_ORIENTATION_270;
        }
        return 90;
    }

    public final void V4() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        this.mCameraView.setVisibility(4);
        if (!this.d) {
            l5(false);
            return;
        }
        try {
            if (this.e == 1 && (mediaPlayer = this.c) != null && mediaPlayer.isPlaying() && (mediaPlayer2 = this.c) != null && mediaPlayer2.isPlaying()) {
                this.c.stop();
                this.c.release();
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
        this.e = 0;
        this.d = false;
        k5();
        q5();
        o5(false);
    }

    public final void W2() {
        this.e = 1;
        this.d = false;
        q5();
        e5();
        vg3.b().a(this.A);
    }

    public final void W4() {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO");
        q61VarM.j(new i());
    }

    public final void X4() {
        try {
            Camera.Parameters parameters = this.mCameraView.getmCamera().e().getParameters();
            if (TextUtils.equals("off", parameters.getFlashMode())) {
                return;
            }
            parameters.setFlashMode("off");
            this.mCameraView.getmCamera().e().setParameters(parameters);
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().setCustomKey("type", "关闪光灯异常");
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void Y4() {
        File file = new File(this.j);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(this.k);
        if (file2.exists()) {
            file2.delete();
        }
        File file3 = new File(this.l);
        if (file3.exists()) {
            file3.delete();
        }
        File file4 = new File(this.m);
        if (file4.exists()) {
            file4.delete();
        }
    }

    public final void Z4() {
        File file = new File(this.k);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // dc.kh3.a
    public void a3() {
        if (this.mCameraView.getCameraId() == 1) {
            return;
        }
        this.mCameraView.d(new Point(this.mCameraView.getWidth() / 2, this.mCameraView.getHeight() / 2), this.b);
    }

    public final void a5() {
        int numberOfCameras = Camera.getNumberOfCameras();
        this.g = numberOfCameras;
        if (numberOfCameras <= 1) {
            this.ivCancle.setVisibility(8);
        }
    }

    public final void b5(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            if (this.c == null) {
                this.c = new MediaPlayer();
            }
            File file = new File(str);
            Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(this.activity, "com.lovense.wear.fileprovider", file) : Uri.fromFile(file);
            this.c.reset();
            this.c.setDataSource(this, uriForFile);
            this.c.prepareAsync();
            this.c.setOnPreparedListener(new k());
            this.c.setOnCompletionListener(new a());
            this.c.setLooping(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e5() {
        Camera.Parameters parameters = this.mCameraView.getmCamera().e().getParameters();
        if (TextUtils.equals("on", parameters.getFlashMode())) {
            try {
                parameters.setFlashMode("torch");
                this.mCameraView.getmCamera().e().setParameters(parameters);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    e2.getMessage();
                }
                FirebaseCrashlytics.getInstance().setCustomKey("type", "开闪光灯异常");
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
        }
    }

    public void f5() {
        this.e = 0;
        this.d = false;
        k5();
    }

    public void g5() {
        runOnMainThread(new h());
    }

    public final void h5(String str) {
        this.mSurfaceView.setVisibility(0);
        this.o = true;
        this.mSurfaceView.getHolder().addCallback(new j(str));
    }

    public void i5() {
        j5(false);
    }

    public final void j5(boolean z) {
        if (z) {
            this.mCameraView.j(this.h);
        } else {
            this.mCameraView.setCameraId(this.h);
            this.mCameraView.onResume();
        }
    }

    public final void k5() {
        this.e = 0;
        this.d = false;
        q5();
        j5(false);
    }

    @Override // com.wear.util.camera.record.widget.CameraView.d
    public void l1() {
        runOnUiThread(new Runnable() { // from class: dc.v53
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.d5();
            }
        });
    }

    public final void l5(boolean z) throws IllegalStateException {
        MediaPlayer mediaPlayer;
        if (this.e == 0) {
            Intent intent = new Intent();
            intent.putExtra("takeType", 0);
            if (z) {
                if (this.e == 0) {
                    tg3.h(this.f, this.j);
                }
                File file = new File(this.j);
                intent.putExtra("imageUri", Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(this.activity, "com.lovense.wear.fileprovider", file) : Uri.fromFile(file));
                intent.putExtra("imagePath", this.j);
                intent.putExtra("isBurnAfterReading", eg3.d(this, "isCameraBurn", true));
                HashMap map = new HashMap();
                map.put("chat_type", Integer.valueOf(this.a));
                map.put("type", 1);
                ye3.e("M0071", map);
            } else {
                Y4();
            }
            setResult(-1, intent);
            finish();
            return;
        }
        if (!z) {
            Y4();
            Intent intent2 = new Intent();
            intent2.putExtra("takeType", 0);
            setResult(-1, intent2);
            finish();
            return;
        }
        try {
            if (this.d && (mediaPlayer = this.c) != null && mediaPlayer.isPlaying()) {
                this.c.stop();
                this.c.release();
            }
            m5(this.mCameraView.getDataWidth(), this.mCameraView.getDataHeight());
        } catch (IllegalArgumentException | IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public final void m5(int i2, int i3) throws SecurityException, IOException, IllegalArgumentException {
        Intent intent = new Intent();
        intent.putExtra("takeType", 1);
        File file = new File(this.k);
        long length = file.length();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            mediaMetadataRetriever.setDataSource(this, FileProvider.getUriForFile(this, "com.lovense.wear.fileprovider", file));
        } else {
            mediaMetadataRetriever.setDataSource(this.k);
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        intent.putExtra(TypedValues.TransitionType.S_DURATION, mediaMetadataRetriever.extractMetadata(9) != null ? Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) : 0);
        ri3.a(MyApplication.N(), frameAtTime, this.m);
        try {
            if (i4 >= 29) {
                mediaMetadataRetriever.close();
            } else {
                mediaMetadataRetriever.release();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put("chat_type", Integer.valueOf(this.a));
        map.put("type", 2);
        ye3.e("M0071", map);
        intent.putExtra("recordFilePath", this.k);
        intent.putExtra("picFramePath", this.m);
        intent.putExtra("videoWidth", i2);
        intent.putExtra("videoHeight", i3);
        intent.putExtra("videoSize", length);
        intent.putExtra("isBurnAfterReading", eg3.d(this, "isCameraBurn", true));
        setResult(-1, intent);
        finish();
    }

    public final void n5() {
        this.ivPreview.setVisibility(0);
        byte[] bArr = this.i;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Matrix matrix = new Matrix();
        int i2 = C;
        if (i2 != 0 && i2 != 90 && i2 != 180 && i2 != 270 && i2 != 360) {
            C = 0;
        }
        int iT4 = (T4() + C) % 360;
        if (this.h == 0) {
            matrix.setRotate(iT4);
        } else {
            matrix.setRotate((360 - iT4) % 360);
            matrix.postScale(-1.0f, 1.0f);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
        this.f = bitmapCreateBitmap;
        this.ivPreview.setImageBitmap(bitmapCreateBitmap);
    }

    public final void o5(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.h == 0 && this.n && this.mCameraView.getmCamera().e() != null) {
            boolean zD = eg3.d(this, "isCameraFlash", false);
            Camera.Parameters parameters = this.mCameraView.getmCamera().e().getParameters();
            if (z) {
                if (zD) {
                    this.ivFlash.setImageDrawable(th4.d(this.application, R.drawable.chat_camera_photo_flash_disable));
                    eg3.j(this, "isCameraFlash", false);
                    parameters.setFlashMode("off");
                } else {
                    this.ivFlash.setImageDrawable(th4.d(this.application, R.drawable.chat_camera_photo_flash_enable));
                    eg3.j(this, "isCameraFlash", true);
                    if (this.e != 1 || this.d) {
                        parameters.setFlashMode("on");
                    } else {
                        parameters.setFlashMode("torch");
                    }
                }
            } else if (zD) {
                this.ivFlash.setImageDrawable(th4.d(this.application, R.drawable.chat_camera_photo_flash_enable));
                if (this.e != 1 || this.d) {
                    parameters.setFlashMode("on");
                } else {
                    parameters.setFlashMode("torch");
                }
            } else {
                this.ivFlash.setImageDrawable(th4.d(this.application, R.drawable.chat_camera_photo_flash_disable));
                parameters.setFlashMode("off");
            }
            try {
                this.mCameraView.getmCamera().e().setParameters(parameters);
            } catch (Exception e2) {
                FirebaseCrashlytics.getInstance().setCustomKey("type", "设置闪光灯异常");
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 888 && i3 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
            intent.getIntArrayExtra("grant_results");
            if (booleanExtra) {
                i5();
            } else {
                new kn3((Context) this, ah4.e(R.string.app_open_camera_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new b()).show();
            }
        }
    }

    @OnClick({R.id.ac_camera_iv_burn, R.id.ac_camera_iv_flash, R.id.ac_camera_tv_cancel, R.id.ac_camera_tv_send, R.id.ac_camera_iv_roate, R.id.ac_camera_iv_cancle, R.id.tv_tip})
    public void onClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int id = view.getId();
        if (id == R.id.ac_camera_tv_cancel) {
            V4();
        }
        if (id == R.id.ac_camera_tv_send) {
            l5(true);
            return;
        }
        switch (id) {
            case R.id.ac_camera_iv_burn /* 2131361825 */:
                boolean zD = eg3.d(this, "isCameraBurn", true);
                eg3.j(this, "isCameraBurn", !zD);
                this.ivBurn.setImageResource(!zD ? R.drawable.chat_camera_burn_enable : R.drawable.chat_camera_burn_disable);
                break;
            case R.id.ac_camera_iv_cancle /* 2131361826 */:
                finish();
                break;
            case R.id.ac_camera_iv_flash /* 2131361827 */:
                o5(true);
                break;
            case R.id.ac_camera_iv_roate /* 2131361828 */:
                s5();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        WearUtils.C(this);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            attributes.flags = 1024 | attributes.flags;
            window.addFlags(512);
        } else {
            window.addFlags(1024);
        }
        setContentView(R.layout.activity_camera_new);
        ButterKnife.bind(this);
        this.j = getIntent().getStringExtra("filePath");
        this.a = getIntent().getIntExtra("chatType", 1);
        a5();
        this.k = WearUtils.T("video").getAbsolutePath() + "/" + WearUtils.E();
        File file = new File(this.k);
        if (file.exists()) {
            file.delete();
        }
        this.l = WearUtils.T("video").getAbsolutePath() + "/" + WearUtils.E();
        File file2 = new File(this.l);
        if (file2.exists()) {
            file2.delete();
        }
        this.m = WearUtils.T("video").getAbsolutePath() + "/" + WearUtils.E();
        File file3 = new File(this.m);
        if (file3.exists()) {
            file3.delete();
        }
        this.l = file2.getAbsolutePath();
        this.mCameraView.setSavePath(this.k);
        this.mCameraView.setOnTouchListener(this);
        this.mCameraView.b(3);
        this.mCameraView.setOnSurfaceCreatedListener(this);
        this.takeView.setTakeListener(new f());
        this.n = li3.a(this.activity);
        kh3 kh3VarB = kh3.b();
        this.q = kh3VarB;
        kh3VarB.e(this);
        g gVar = new g(this, 3);
        this.t = gVar;
        if (gVar.canDetectOrientation()) {
            this.t.enable();
        } else {
            this.t.disable();
        }
        this.ivBurn.setImageResource(eg3.d(this, "isCameraBurn", true) ? R.drawable.chat_camera_burn_enable : R.drawable.chat_camera_burn_disable);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IllegalStateException {
        super.onDestroy();
        CameraView cameraView = this.mCameraView;
        if (cameraView != null) {
            cameraView.onPause();
        }
        MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.c.stop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        V4();
        return true;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() throws IllegalStateException {
        super.onPause();
        try {
            MediaPlayer mediaPlayer = this.c;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.c.stop();
            this.c.release();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        super.onPointerCaptureChanged(z);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            W4();
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
            finish();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
        }
        float[] fArr2 = sensorEvent.values;
        C = U4(fArr2[0], fArr2[1]);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.q == null || this.mCameraView.getVisibility() != 0) {
            return;
        }
        this.q.c();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mCameraView.e(motionEvent);
        if (this.mCameraView.getCameraId() == 1) {
            return false;
        }
        int width = this.mCameraView.getWidth();
        int height = this.mCameraView.getHeight();
        if (motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f2 = width;
            float f3 = height;
            this.mCameraView.d(new Point((int) ((y * f2) / f3), (int) (((f2 - x) * f3) / f2)), this.b);
            this.mFocus.c(new Point((int) x, (int) y));
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || Build.VERSION.SDK_INT < 19) {
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final void p5(float f2, float f3) {
        if (f2 == f3) {
            return;
        }
        int i2 = f3 == 90.0f ? -90 : f3 == 270.0f ? 90 : 0;
        r5(this.ivRoate, i2);
        r5(this.ivFlash, i2);
        r5(this.ivBurn, i2);
    }

    public final void q5() {
        if (this.e == 0) {
            if (this.d) {
                this.ivCancle.setVisibility(0);
                this.tvSend.setVisibility(0);
                this.tvCancel.setVisibility(0);
                this.tvDuration.setVisibility(4);
                this.tvCancel.setText(ah4.e(R.string.button_retake));
                this.tvTips.setVisibility(8);
                this.ivRoate.setVisibility(8);
                this.ivPreview.setVisibility(0);
                this.mCameraView.setVisibility(4);
                this.ivFlash.setVisibility(4);
                n5();
            } else {
                this.ivCancle.setVisibility(0);
                this.tvSend.setVisibility(4);
                this.tvCancel.setVisibility(4);
                this.tvDuration.setVisibility(4);
                this.tvCancel.setText(ah4.e(R.string.common_cancel));
                this.ivPreview.setVisibility(4);
                this.ivRoate.setVisibility(0);
                this.mCameraView.setVisibility(0);
                this.ivFlash.setVisibility(0);
                this.tvTips.setVisibility(0);
            }
            this.mSurfaceView.setVisibility(8);
        } else {
            if (this.d) {
                this.ivCancle.setVisibility(0);
                this.tvSend.setVisibility(0);
                this.tvCancel.setVisibility(0);
                this.tvDuration.setVisibility(0);
                this.mCameraView.setVisibility(4);
                this.tvCancel.setText(ah4.e(R.string.button_retake));
                this.tvTips.setVisibility(8);
                this.ivFlash.setVisibility(4);
                this.ivRoate.setVisibility(8);
            } else {
                this.ivCancle.setVisibility(0);
                this.tvSend.setVisibility(4);
                this.tvCancel.setVisibility(4);
                this.tvDuration.setVisibility(4);
                this.mCameraView.setVisibility(0);
                this.mSurfaceView.setVisibility(8);
                this.tvCancel.setText(ah4.e(R.string.common_cancel));
                this.ivFlash.setVisibility(0);
                this.ivRoate.setVisibility(0);
                this.tvTips.setVisibility(0);
            }
            this.ivPreview.setVisibility(4);
        }
        this.tvTakeType.setVisibility(8);
        this.takeView.setTakeState(this.e, this.d);
    }

    public final void r5(ImageView imageView, int i2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, Key.ROTATION, i2);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat.start();
    }

    public final void s5() {
        if (this.g <= 1 || System.currentTimeMillis() - this.B < ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return;
        }
        this.B = System.currentTimeMillis();
        if (this.h == 0) {
            this.ivFlash.setImageDrawable(th4.d(this.application, R.drawable.chat_camera_photo_flash_disable));
            this.ivFlash.setEnabled(false);
        } else {
            this.ivFlash.setEnabled(true);
        }
        int i2 = this.h + 1;
        this.h = i2;
        if (i2 > 1) {
            this.h = 0;
        }
        j5(true);
    }
}
