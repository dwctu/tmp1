package dc;

import android.content.ContentUris;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.lovense.wear.R;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityBurnPicture;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.util.camera.videocompressor.VideoController;
import dc.so2;
import io.agora.rtc2.internal.CommonUtility;
import io.microshow.rxffmpeg.RxFFmpegCommandList;
import io.microshow.rxffmpeg.RxFFmpegInvoke;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: UploadAndCompressTask.java */
/* loaded from: classes4.dex */
public class fk3 extends AsyncTask<MediaFile, b, CommunMessage> {
    public static final String e = fk3.class.getSimpleName();
    public final String a;
    public final boolean b;
    public final String c;
    public ah3 d;

    /* compiled from: UploadAndCompressTask.java */
    public class a implements RxFFmpegInvoke.IFFmpegListener {
        public final /* synthetic */ CommunMessage a;

        public a(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onCancel() {
        }

        @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onError(String str) {
            fk3.this.E(this.a, str);
        }

        @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onFinish() {
        }

        @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
        public void onProgress(int i, long j) {
            fk3.this.publishProgress(new b(Math.round(i * 0.3f) + 40, this.a));
        }
    }

    /* compiled from: UploadAndCompressTask.java */
    public static class b {
        public int a;
        public CommunMessage b;

        public b(int i, CommunMessage communMessage) {
            this.a = i;
            this.b = communMessage;
        }

        public CommunMessage a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    public fk3(String str, boolean z, String str2) {
        this.a = str;
        this.c = str2;
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(CommunMessage communMessage, int i) {
        publishProgress(new b(Math.round(i * 0.1f), communMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(CommunMessage communMessage, float f) {
        publishProgress(new b(Math.round((TextUtils.equals("arm64-v8a", Build.CPU_ABI) ? 0.3f : 0.6f) * f) + 10, communMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(CommunMessage communMessage, float f) {
        publishProgress(new b(Math.round(f * 0.6f) + 10, communMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(CommunMessage communMessage) {
        this.d.c1(communMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(CommunMessage communMessage) {
        this.d.c1(communMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(CommunMessage communMessage) {
        if (m()) {
            this.d.L3(communMessage);
        } else {
            DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(CommunMessage communMessage, int i) {
        publishProgress(new b(i, communMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(CommunMessage communMessage, int i) {
        publishProgress(new b(Math.round(i * 0.3f) + 70, communMessage));
    }

    public final boolean D(CommunMessage communMessage) {
        return zb2.O().l0(communMessage);
    }

    public final void E(final CommunMessage communMessage, String str) {
        String str2 = "onError :" + str;
        communMessage.setSendStatus(4);
        WearUtils.x.m.post(new Runnable() { // from class: dc.zj3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w(communMessage);
            }
        });
    }

    @Override // android.os.AsyncTask
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(CommunMessage communMessage) {
        if (communMessage == null) {
            return;
        }
        if (communMessage.getDataBean() instanceof EntityPicture) {
            EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
            String str = "onPostExecute url: " + entityPicture.getUrl();
            if (m()) {
                this.d.h0(entityPicture.getUrl(), communMessage, 0);
                return;
            } else {
                communMessage.sendEntity(entityPicture);
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                return;
            }
        }
        if (communMessage.getDataBean() instanceof EntityShortVideo) {
            EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage.getDataBean();
            String str2 = "onPostExecute url: " + entityShortVideo.getVideoUrl();
            if (m()) {
                this.d.b3(null, communMessage, 0);
            } else {
                communMessage.sendEntity(entityShortVideo);
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(b... bVarArr) {
        b bVar = bVarArr[0];
        if (!m() || bVar.b() <= 0) {
            String str = "isCallBackAvailable == false progress = " + bVarArr[0].b();
            return;
        }
        String str2 = "messageId = " + bVar.a().getId() + "& progress = " + bVar.b();
        this.d.i1(bVar.a(), bVar.b());
    }

    public final void H(String str, EntityShortVideo entityShortVideo) throws SecurityException, IOException, IllegalArgumentException {
        String str2 = WearUtils.T("videouploadpic").getAbsolutePath() + "/" + WearUtils.E();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i = Build.VERSION.SDK_INT;
        if (i < 29 || !str.startsWith(CommonUtility.PREFIX_URI)) {
            mediaMetadataRetriever.setDataSource(str);
        } else {
            mediaMetadataRetriever.setDataSource(WearUtils.x, Uri.parse(str));
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        ri3.a(MyApplication.N(), frameAtTime, str2);
        entityShortVideo.setPicLocalUrl(str2);
        entityShortVideo.setPicW(frameAtTime.getWidth());
        entityShortVideo.setPicH(frameAtTime.getHeight());
        entityShortVideo.setVideoLocalUrl(str);
        entityShortVideo.setVideoW(frameAtTime.getWidth());
        entityShortVideo.setVideoH(frameAtTime.getHeight());
        entityShortVideo.setShowProgressBar(true);
        try {
            if (i >= 29) {
                mediaMetadataRetriever.close();
            } else {
                mediaMetadataRetriever.release();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void I(ah3 ah3Var) {
        this.d = ah3Var;
    }

    public final void J(EntityPicture entityPicture, final CommunMessage communMessage) throws IOException {
        String str = "upload picture path: " + entityPicture.getCompressPath();
        File file = new File(entityPicture.getCompressPath());
        ad4 ad4VarExecute = tn2.x(WearUtils.x).E("/wear/chat/sendPic", file, le3.f(file), new so2.b() { // from class: dc.yj3
            @Override // dc.so2.b
            public final void a(int i) {
                this.a.y(communMessage, i);
            }
        }).execute();
        if (!ad4VarExecute.isSuccessful() || ad4VarExecute.b() == null) {
            E(communMessage, ad4VarExecute.x());
        } else {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(ad4VarExecute.b().string(), NormalResponse.class);
            if (normalResponse.isResult()) {
                entityPicture.setUrl(normalResponse.getMessage());
                communMessage.sendEntity(entityPicture);
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage);
            } else {
                E(communMessage, String.format("error code =  %s", normalResponse.getCode()));
            }
        }
        ad4VarExecute.close();
    }

    public final void K(EntityShortVideo entityShortVideo, final CommunMessage communMessage) throws Exception {
        String videoLocalUrl = entityShortVideo.getVideoLocalUrl();
        String str = "upload Video : path = " + videoLocalUrl;
        File file = new File(videoLocalUrl);
        String str2 = "videoFile length = " + file.length();
        ad4 ad4VarExecute = tn2.x(WearUtils.x).E("/wear/chat/sendVideo", file, MimeTypes.VIDEO_MP4, new so2.b() { // from class: dc.uj3
            @Override // dc.so2.b
            public final void a(int i) {
                this.a.A(communMessage, i);
            }
        }).execute();
        if (!ad4VarExecute.isSuccessful() || ad4VarExecute.b() == null) {
            E(communMessage, ad4VarExecute.x());
        } else {
            String strString = ad4VarExecute.b().string();
            String str3 = "uploadVideoResponse : " + strString;
            JSONObject object = JSON.parseObject(strString);
            Boolean bool = object.getBoolean("result");
            String string = object.getString("data");
            if (bool.booleanValue()) {
                entityShortVideo.setVideoUrl(string);
            } else {
                E(communMessage, String.format("error code = %s" + object.getString(XHTMLText.CODE), new Object[0]));
            }
        }
        ad4VarExecute.close();
    }

    public final void L(EntityShortVideo entityShortVideo, final CommunMessage communMessage) throws IOException {
        String str = "uploadShortVideoFrame : path = " + entityShortVideo.getPicLocalUrl();
        File file = new File(entityShortVideo.getPicLocalUrl());
        ad4 ad4VarExecute = tn2.x(WearUtils.x).E("/wear/chat/sendPic", file, le3.f(file), new so2.b() { // from class: dc.xj3
            @Override // dc.so2.b
            public final void a(int i) {
                this.a.C(communMessage, i);
            }
        }).execute();
        if (!ad4VarExecute.isSuccessful() || ad4VarExecute.b() == null) {
            E(communMessage, ad4VarExecute.x());
        } else {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(ad4VarExecute.b().string(), NormalResponse.class);
            if (normalResponse.isResult()) {
                entityShortVideo.setPicUrl(normalResponse.getMessage());
                communMessage.sendEntity(entityShortVideo);
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage);
            } else {
                E(communMessage, String.format("error code %s", normalResponse.getCode()));
            }
        }
        ad4VarExecute.close();
    }

    public final int c(int i, int i2) {
        int i3 = 1;
        if (i * i2 > 2073600) {
            while ((i / i3) * (i2 / i3) > 2073600) {
                i3 *= 2;
            }
        }
        return i3;
    }

    public final String d(EntityShortVideo entityShortVideo, final CommunMessage communMessage) throws Exception {
        String videoLocalUrl = entityShortVideo.getVideoLocalUrl();
        String str = "video path : " + videoLocalUrl;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (Build.VERSION.SDK_INT < 29 || !videoLocalUrl.startsWith(CommonUtility.PREFIX_URI)) {
            mediaMetadataRetriever.setDataSource(videoLocalUrl);
        } else {
            mediaMetadataRetriever.setDataSource(WearUtils.x, Uri.parse(videoLocalUrl));
        }
        int i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        String str2 = "compressVideo 压缩前width:" + i;
        String str3 = "compressVideo 压缩前height:" + i2;
        String str4 = "compressVideo 压缩前bitrate:" + i3;
        String str5 = "compressVideo 压缩前duration=" + i4;
        String str6 = "compressVideo 压缩前rotation=" + i5;
        int iC = c(i, i2);
        String str7 = "inSampleSize = " + iC;
        int i6 = i / iC;
        int i7 = i2 / iC;
        int iMin = iC > 1 ? 1500000 : Math.min(1500000, i3);
        boolean z = i3 >= 1500000 && i4 > 30000;
        String str8 = "need ffmpeg = " + z;
        File fileT = WearUtils.T("video");
        File file = new File(fileT, WearUtils.E() + ".mp4");
        if (z) {
            File file2 = new File(fileT, WearUtils.E() + ".mp4");
            VideoController videoControllerD = VideoController.d();
            String absolutePath = file2.getAbsolutePath();
            String str9 = Build.CPU_ABI;
            videoControllerD.b(videoLocalUrl, absolutePath, TextUtils.equals("arm64-v8a", str9) ? 0 : iMin, new VideoController.a() { // from class: dc.wj3
                @Override // com.wear.util.camera.videocompressor.VideoController.a
                public final void onProgress(float f) {
                    this.a.o(communMessage, f);
                }
            });
            if (!TextUtils.equals("arm64-v8a", str9)) {
                return file2.getAbsolutePath();
            }
            if (i5 == 90 || i5 == 270) {
                i7 = i6;
                i6 = i7;
            }
            RxFFmpegInvoke.getInstance().runCommand(e(file.getAbsolutePath(), i6, i7, iMin, file2.getAbsolutePath()).build(), new a(communMessage));
        } else {
            VideoController.d().b(videoLocalUrl, file.getAbsolutePath(), 0, new VideoController.a() { // from class: dc.bk3
                @Override // com.wear.util.camera.videocompressor.VideoController.a
                public final void onProgress(float f) {
                    this.a.q(communMessage, f);
                }
            });
        }
        return file.getAbsolutePath();
    }

    public final RxFFmpegCommandList e(String str, int i, int i2, int i3, String str2) {
        RxFFmpegCommandList rxFFmpegCommandList = new RxFFmpegCommandList();
        rxFFmpegCommandList.append("-noautorotate");
        rxFFmpegCommandList.append("-i");
        rxFFmpegCommandList.append(str2);
        rxFFmpegCommandList.append("-s");
        rxFFmpegCommandList.append(String.format("%sx%s", Integer.valueOf(i), Integer.valueOf(i2)));
        rxFFmpegCommandList.append("-b:v");
        rxFFmpegCommandList.append(String.valueOf(i3));
        rxFFmpegCommandList.append(str);
        return rxFFmpegCommandList;
    }

    public final CommunMessage f(MediaFile mediaFile) {
        CommunMessage communMessageJ = j();
        communMessageJ.setSendStatus(2);
        try {
            if (mediaFile.b() > 0) {
                l(mediaFile, communMessageJ);
            } else {
                k(mediaFile, communMessageJ);
            }
            return communMessageJ;
        } catch (Exception e2) {
            E(communMessageJ, e2.getMessage());
            return null;
        }
    }

    public final EntityPicture g(MediaFile mediaFile, CommunMessage communMessage) throws Exception {
        EntityPicture entityBurnPicture = this.b ? new EntityBurnPicture() : new EntityPicture();
        Uri uriFromFile = (Build.VERSION.SDK_INT < 29 || mediaFile.e() <= 0) ? Uri.fromFile(new File(mediaFile.f())) : ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaFile.e());
        if (!le3.e(uriFromFile, WearUtils.x).contains("gif")) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(WearUtils.x.getContentResolver().openInputStream(uriFromFile), null, options);
            String strG = qe3.g(WearUtils.x, uriFromFile, bitmapDecodeStream);
            Bitmap bitmapL = WearUtils.l(WearUtils.x, bitmapDecodeStream, strG);
            if (bitmapL != null) {
                Bitmap bitmapI2 = WearUtils.I2(bitmapL);
                String strD0 = WearUtils.d0();
                WearUtils.e2(bitmapI2, strD0);
                entityBurnPicture.setW(bitmapL.getWidth());
                entityBurnPicture.setH(bitmapL.getHeight());
                entityBurnPicture.setLocalUrl(strD0);
                entityBurnPicture.setOriginalPath(strG);
                entityBurnPicture.setMediaId(mediaFile.e());
                entityBurnPicture.setCompressPath(WearUtils.c0(strD0).getAbsolutePath());
            }
        } else if (WearUtils.M0(WearUtils.x.getContentResolver().openInputStream(uriFromFile)) >= 1048576) {
            ToastUtils.x(R.string.send_gif_faile_maxzie);
        } else {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            if (BitmapFactory.decodeStream(WearUtils.x.getContentResolver().openInputStream(uriFromFile), null, options2) != null) {
                String strD02 = WearUtils.d0();
                WearUtils.f2(WearUtils.x.getContentResolver().openInputStream(uriFromFile), strD02);
                entityBurnPicture.setW(r9.getWidth());
                entityBurnPicture.setH(r9.getHeight());
                entityBurnPicture.setType("emoji");
                entityBurnPicture.setLocalUrl(strD02);
                entityBurnPicture.setCompressPath(WearUtils.a0(strD02).getAbsolutePath());
            }
        }
        return entityBurnPicture;
    }

    public final EntityShortVideo h(MediaFile mediaFile) throws SecurityException, IOException, IllegalArgumentException {
        EntityShortVideo entityBurnShortVideo = this.b ? new EntityBurnShortVideo() : new EntityShortVideo();
        entityBurnShortVideo.setDuration((int) mediaFile.b());
        H((Build.VERSION.SDK_INT < 29 || mediaFile.e() <= 0) ? mediaFile.f() : ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaFile.e()).toString(), entityBurnShortVideo);
        return entityBurnShortVideo;
    }

    @Override // android.os.AsyncTask
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public CommunMessage doInBackground(MediaFile... mediaFileArr) {
        CommunMessage communMessageF = f(mediaFileArr[0]);
        if (communMessageF == null || communMessageF.getSendStatus() == 4) {
            return null;
        }
        return communMessageF;
    }

    public final CommunMessage j() {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(this.a);
        communMessage.setCreated(new Date());
        communMessage.setUserId(WearUtils.y.p());
        communMessage.setId(this.c);
        return communMessage;
    }

    public final void k(MediaFile mediaFile, final CommunMessage communMessage) throws Exception {
        EntityPicture entityPictureG = g(mediaFile, communMessage);
        communMessage.sendEntity(entityPictureG);
        communMessage.setSendStatus(2);
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        if (m()) {
            WearUtils.x.m.post(new Runnable() { // from class: dc.vj3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.s(communMessage);
                }
            });
        } else {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        }
        J(entityPictureG, communMessage);
    }

    public final void l(MediaFile mediaFile, final CommunMessage communMessage) throws Exception {
        EntityShortVideo entityShortVideoH = h(mediaFile);
        communMessage.sendEntity(entityShortVideoH);
        communMessage.setSendStatus(2);
        if (D(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        }
        if (m()) {
            WearUtils.x.m.post(new Runnable() { // from class: dc.ak3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u(communMessage);
                }
            });
        } else {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        }
        L(entityShortVideoH, communMessage);
        synchronized (fk3.class) {
            entityShortVideoH.setVideoLocalUrl(d(entityShortVideoH, communMessage));
            K(entityShortVideoH, communMessage);
        }
    }

    public final boolean m() {
        return this.d != null;
    }
}
