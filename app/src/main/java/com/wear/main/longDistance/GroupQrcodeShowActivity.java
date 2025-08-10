package com.wear.main.longDistance;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.BaseActivity;
import com.wear.bean.Group;
import com.wear.bean.socketio.scan.ScanBean;
import com.wear.main.MainActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPicture;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.ce3;
import dc.ch3;
import dc.ii;
import dc.kf;
import dc.nd3;
import dc.pj3;
import dc.qo;
import dc.qx3;
import dc.th4;
import dc.vg3;
import dc.ye3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeCreate;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class GroupQrcodeShowActivity extends BaseActivity {
    public boolean a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public String b;
    public Group c;
    public ResponseRoomQrcodeCreate.DataBean d;
    public boolean e;
    public Toast f;
    public ImageView g;
    public TextView h;

    @BindView(R.id.iv_qr_code_blur)
    public ImageView ivQrCodeBlur;

    @BindView(R.id.iv_qr_code_blur_bg)
    public ImageView ivQrCodeBlurBg;

    @BindView(R.id.iv_qrcode)
    public ImageView ivQrcode;

    @BindView(R.id.iv_user_img)
    public RoundedImageView ivUserImg;

    @BindView(R.id.root_qr_code)
    public SkinCompatConstraintLayout rootQrCode;

    @BindView(R.id.tv_group_name)
    public TextView tvGroupName;

    @BindView(R.id.tv_logo_des)
    public TextView tvLogoDes;

    @BindView(R.id.tv_qr_share_hint)
    public TextView tvQrShareHint;

    @BindView(R.id.tv_qr_update_hint)
    public TextView tvQrUpdateHint;

    @BindView(R.id.tv_save_qr)
    public TextView tvSaveQR;

    @BindView(R.id.tv_share_qr)
    public TextView tvShareQR;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(Bitmap bitmap) {
            GroupQrcodeShowActivity.this.ivQrcode.setImageBitmap(bitmap);
        }

        @Override // java.lang.Runnable
        public void run() {
            final Bitmap bitmapBuildBitmap;
            ScanBean scanBean = new ScanBean();
            scanBean.setA(StreamManagement.AckRequest.ELEMENT);
            scanBean.setT(500);
            scanBean.setMs(GroupQrcodeShowActivity.this.d.getEndtime());
            scanBean.setD(GroupQrcodeShowActivity.this.d.getCodeKey());
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(GroupQrcodeShowActivity.this.getResources(), R.drawable.ic_qr_code_logo);
            String strR = nd3.r(JSON.toJSONString(scanBean));
            int iA = ce3.a(GroupQrcodeShowActivity.this, 160.0f);
            try {
                HmsBuildBitmapOption hmsBuildBitmapOptionCreate = new HmsBuildBitmapOption.Creator().setQRLogoBitmap(bitmapDecodeResource).create();
                hmsBuildBitmapOptionCreate.toString();
                bitmapBuildBitmap = ScanUtil.buildBitmap(strR, 0, iA, iA, hmsBuildBitmapOptionCreate);
            } catch (Exception e) {
                e.printStackTrace();
                bitmapBuildBitmap = null;
            }
            GroupQrcodeShowActivity.this.runOnMainThread(new Runnable() { // from class: dc.e72
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(bitmapBuildBitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B4() {
        Bitmap bitmapT4 = t4();
        kf.v(this.activity).p(bitmapT4).a(new qo().j0(new qx3(25, 1))).A0(this.ivQrCodeBlurBg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x4(View view) {
        if (this.e) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.putExtra("isFinishToLongDistance", true);
            startActivity(intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z4(View view) {
        u4();
    }

    @NonNull
    public final File C4() throws IOException {
        Bitmap bitmapT4 = t4();
        File file = new File(getExternalFilesDir("qr_code"), WearUtils.E() + ".jpeg");
        if (!file.exists()) {
            file.createNewFile();
        }
        bitmapT4.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
        return file;
    }

    public final void D4() throws Exception {
        Uri uriForFile = FileProvider.getUriForFile(this, "com.lovense.wear.fileprovider", C4());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(MimeTypes.IMAGE_JPEG);
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        startActivity(Intent.createChooser(intent, "ShareImage"));
    }

    public final void E4(ImageView imageView, String str, String str2) {
        qo qoVarF = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default).f(ii.b);
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("http")) {
                str = WearUtils.e + str;
            }
            kf.w(imageView.getContext()).v(str).a(qoVarF).A0(imageView);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : str2.split(",", -1)) {
            if (!str3.startsWith("http")) {
                str3 = WearUtils.e + str3;
            }
            arrayList.add(str3);
        }
        if (arrayList.size() == 1) {
            arrayList.add("");
            arrayList.add("");
        }
        kf.w(imageView.getContext()).u(arrayList).a(qoVarF).A0(imageView);
    }

    public final void F4(String str, Drawable drawable) {
        this.g.setImageDrawable(drawable);
        this.h.setText(str);
        this.f.show();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_qrcode_show);
        ButterKnife.bind(this);
        this.a = getIntent().getBooleanExtra("isCanInvite", false);
        this.e = getIntent().getBooleanExtra("isForward", false);
        this.b = getIntent().getStringExtra("roomId");
        this.c = ch3.n().k(this.b);
        this.d = (ResponseRoomQrcodeCreate.DataBean) getIntent().getParcelableExtra("data");
        v4();
        Group group = this.c;
        if (group == null || group.isExit()) {
            finish();
            return;
        }
        this.abTitle.setTitle(ah4.e(R.string.group_chat_qr_code));
        this.abTitle.setBackAction(new MyActionBar.f() { // from class: dc.f72
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.x4(view);
            }
        });
        if (this.a) {
            this.abTitle.setYesAction(ah4.e(R.string.comman_forward), new MyActionBar.f() { // from class: dc.d72
                @Override // com.wear.widget.MyActionBar.f
                public final void performAction(View view) {
                    this.a.z4(view);
                }
            });
        }
        vg3.b().a(new a());
        E4(this.ivUserImg, this.c.getUrl(), this.c.getAvatar());
        this.tvGroupName.setText(this.c.getShowNickName());
        this.tvQrShareHint.setText(ah4.e(R.string.group_qr_no_approval_hint));
        this.tvTip.setText(String.format(ah4.e(R.string.qr_expire_date), be3.i(be3.i, new Date(this.d.getEndtime()))));
        this.tvLogoDes.setText(ah4.e(R.string.scan_qr_hint));
        this.tvQrUpdateHint.setText(ah4.e(R.string.qr_update_hint));
        this.tvSaveQR.setText(ah4.e(R.string.save_image));
        this.tvShareQR.setText(ah4.e(R.string.common_share));
        if (this.a) {
            return;
        }
        this.ivQrCodeBlur.setVisibility(0);
        this.tvQrShareHint.setVisibility(0);
        findViewById(R.id.group).setVisibility(8);
        this.ivQrCodeBlurBg.postDelayed(new Runnable() { // from class: dc.g72
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B4();
            }
        }, 200L);
    }

    @OnClick({R.id.iv_qr_code_save, R.id.iv_qr_code_share})
    public void onViewClicked(View view) {
        Intent intent;
        String str = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
        switch (view.getId()) {
            case R.id.iv_qr_code_save /* 2131363270 */:
                Bitmap bitmapT4 = t4();
                ContentResolver contentResolver = getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put("mime_type", MimeTypes.IMAGE_JPEG);
                contentValues.put("date_added", Long.valueOf(System.currentTimeMillis()));
                Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                try {
                    try {
                        bitmapT4.compress(Bitmap.CompressFormat.PNG, 100, contentResolver.openOutputStream(uriInsert));
                        F4(ah4.e(R.string.saved_image_hint), th4.d(this, R.drawable.ic_toast_success));
                        intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    }
                    intent.setData(uriInsert);
                    sendBroadcast(intent);
                    str = "group_qr_code_save_image";
                    ye3.i("Group QR code", "group_qr_code_save_image_click", "click", "group_qr_code_save_image", "button");
                    return;
                } catch (Throwable th) {
                    Intent intent2 = new Intent(str);
                    intent2.setData(uriInsert);
                    sendBroadcast(intent2);
                    throw th;
                }
            case R.id.iv_qr_code_share /* 2131363271 */:
                try {
                    D4();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                ye3.i("Group QR code", "group_qr_code_share_click", "click", "group_qr_code_share", "button");
                return;
            default:
                return;
        }
    }

    public final Bitmap t4() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.rootQrCode.getWidth(), this.rootQrCode.getHeight(), Bitmap.Config.ARGB_8888);
        this.rootQrCode.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public final void u4() {
        ye3.i("Group QR code", "group_qr_code_forward_click", "click", "group_qr_code_forward", "button");
        Bundle bundle = new Bundle();
        CommunMessage communMessage = new CommunMessage();
        EntityPicture entityPicture = new EntityPicture();
        try {
            entityPicture.setLocalUrl(C4().getAbsolutePath());
            communMessage.sendEntity(entityPicture);
            bundle.putSerializable("choose_message", communMessage);
            pj3.g(this, ForwardMessageActivity.class, bundle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void v4() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.toast_qr_code, (ViewGroup) null, false);
        this.g = (ImageView) viewInflate.findViewById(R.id.iv_toast_icon);
        this.h = (TextView) viewInflate.findViewById(R.id.tv_toast_title);
        Toast toast = new Toast(this);
        this.f = toast;
        toast.setGravity(17, 0, 0);
        this.f.setView(viewInflate);
    }
}
