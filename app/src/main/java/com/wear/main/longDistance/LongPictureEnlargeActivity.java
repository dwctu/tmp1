package com.wear.main.longDistance;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.lovense.wear.R;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.bean.MessageHide;
import com.wear.dao.DaoUtils;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityUnSupport;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.PictureUsedDialog;
import dc.ah4;
import dc.be3;
import dc.cs3;
import dc.ej3;
import dc.fg3;
import dc.fu1;
import dc.gp1;
import dc.ie3;
import dc.ii;
import dc.ip1;
import dc.is3;
import dc.kf;
import dc.pj3;
import dc.q61;
import dc.qo;
import dc.qx3;
import dc.sg3;
import dc.u51;
import dc.yg;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class LongPictureEnlargeActivity extends QRCodeActivity {
    public List<GifImageView> A;
    public GifImageView B;
    public PictureUsedDialog C;
    public yg<Bitmap> D;
    public List<CommunMessage> E;
    public List<CommunMessage> F;
    public boolean G;
    public boolean K;
    public Handler L;
    public ImageView t;
    public ImageView u;
    public f w;
    public ViewPager2 x;
    public List<CommunMessage> y;
    public HashMap<String, String> z;
    public String m = "";
    public String n = "";
    public String o = "";
    public boolean p = false;
    public List<CommunMessage> q = new ArrayList();
    public int s = -1;
    public List<String> v = new ArrayList();

    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            if (LongPictureEnlargeActivity.this.v == null || LongPictureEnlargeActivity.this.v.size() <= 0) {
                return;
            }
            LongPictureEnlargeActivity longPictureEnlargeActivity = LongPictureEnlargeActivity.this;
            longPictureEnlargeActivity.M5((String) longPictureEnlargeActivity.v.get(LongPictureEnlargeActivity.this.x.getCurrentItem()));
        }
    }

    public class b implements ip1 {
        public b(LongPictureEnlargeActivity longPictureEnlargeActivity) {
        }

        @Override // dc.ip1
        public void G() {
            sg3.h(R.string.chat_recall_fail);
        }

        @Override // dc.ip1
        public void d() {
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 111) {
                if (LongPictureEnlargeActivity.this.K) {
                    LongPictureEnlargeActivity.this.t.setVisibility(0);
                } else {
                    LongPictureEnlargeActivity.this.t.setVisibility(8);
                }
            }
        }
    }

    public class d implements u51 {
        public final /* synthetic */ int a;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(LongPictureEnlargeActivity.this);
            }
        }

        public d(int i) {
            this.a = i;
        }

        @Override // dc.u51
        public void a(@NonNull List<String> list, boolean z) {
            is3.b bVar = new is3.b(LongPictureEnlargeActivity.this.activity);
            bVar.p(ah4.e(R.string.app_open_camera_permission));
            bVar.o(ah4.e(R.string.common_confirm));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new a());
            cs3.h(bVar).show();
        }

        @Override // dc.u51
        public void b(@NonNull List<String> list, boolean z) {
            CommunMessage communMessage;
            if (z) {
                PictureUsedDialog pictureUsedDialog = LongPictureEnlargeActivity.this.C;
                if (pictureUsedDialog != null) {
                    pictureUsedDialog.dismiss();
                }
                if (LongPictureEnlargeActivity.this.q == null || LongPictureEnlargeActivity.this.q.size() <= 0 || (communMessage = (CommunMessage) LongPictureEnlargeActivity.this.q.get(this.a)) == null) {
                    return;
                }
                LongPictureEnlargeActivity.this.c6(this.a, ((EntityPicture) communMessage.getDataBean()).getType());
            }
        }
    }

    public class e extends RecyclerView.ViewHolder {
        public e(@NonNull LongPictureEnlargeActivity longPictureEnlargeActivity, View view) {
            super(view);
        }
    }

    public class f extends RecyclerView.Adapter {
        public f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void m(View view) {
            LongPictureEnlargeActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void o(int i, boolean z, int i2) {
            if (i2 == 0) {
                LongPictureEnlargeActivity longPictureEnlargeActivity = LongPictureEnlargeActivity.this;
                longPictureEnlargeActivity.I5((CommunMessage) longPictureEnlargeActivity.q.get(i));
                return;
            }
            if (i2 == 1) {
                LongPictureEnlargeActivity.this.b6(i);
                return;
            }
            if (i2 == 2) {
                LongPictureEnlargeActivity longPictureEnlargeActivity2 = LongPictureEnlargeActivity.this;
                longPictureEnlargeActivity2.H5((CommunMessage) longPictureEnlargeActivity2.q.get(i), i);
                return;
            }
            if (i2 == 3) {
                LongPictureEnlargeActivity longPictureEnlargeActivity3 = LongPictureEnlargeActivity.this;
                longPictureEnlargeActivity3.K5((CommunMessage) longPictureEnlargeActivity3.q.get(i), i);
                return;
            }
            if (i2 == 4) {
                if (!z) {
                    LongPictureEnlargeActivity.this.d6(i);
                    return;
                } else {
                    LongPictureEnlargeActivity longPictureEnlargeActivity4 = LongPictureEnlargeActivity.this;
                    longPictureEnlargeActivity4.a6((CommunMessage) longPictureEnlargeActivity4.q.get(i), i);
                    return;
                }
            }
            if (i2 == 5) {
                LongPictureEnlargeActivity.this.d6(i);
            } else {
                if (i2 != 7) {
                    return;
                }
                LongPictureEnlargeActivity.this.C.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean q(final int i, final boolean z, View view) {
            if (!LongPictureEnlargeActivity.this.getIntent().getBooleanExtra("can_long_click", true)) {
                return false;
            }
            String str = "点击第几张图" + (i + 1);
            LongPictureEnlargeActivity longPictureEnlargeActivity = LongPictureEnlargeActivity.this;
            LongPictureEnlargeActivity longPictureEnlargeActivity2 = LongPictureEnlargeActivity.this;
            longPictureEnlargeActivity.C = new PictureUsedDialog(longPictureEnlargeActivity2, Boolean.valueOf(longPictureEnlargeActivity2.K), Boolean.valueOf(z), Boolean.valueOf(LongPictureEnlargeActivity.this.G), new PictureUsedDialog.b() { // from class: dc.s72
                @Override // com.wear.widget.PictureUsedDialog.b
                public final void a(int i2) {
                    this.a.o(i, z, i2);
                }
            });
            LongPictureEnlargeActivity.this.C.show();
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LongPictureEnlargeActivity.this.v.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            LongPictureEnlargeActivity.this.u = (ImageView) viewHolder.itemView.findViewById(R.id.picture_img);
            LongPictureEnlargeActivity longPictureEnlargeActivity = LongPictureEnlargeActivity.this;
            if (longPictureEnlargeActivity.z.get(((CommunMessage) longPictureEnlargeActivity.q.get(i)).getId()) != null) {
                LongPictureEnlargeActivity longPictureEnlargeActivity2 = LongPictureEnlargeActivity.this;
                longPictureEnlargeActivity2.G = true;
                ej3.a(longPictureEnlargeActivity2).v((String) LongPictureEnlargeActivity.this.v.get(i)).a(qo.p0(LongPictureEnlargeActivity.this.D)).A0(LongPictureEnlargeActivity.this.u);
            } else {
                LongPictureEnlargeActivity longPictureEnlargeActivity3 = LongPictureEnlargeActivity.this;
                longPictureEnlargeActivity3.G = false;
                ej3.a(longPictureEnlargeActivity3).v((String) LongPictureEnlargeActivity.this.v.get(i)).A0(LongPictureEnlargeActivity.this.u);
            }
            ((TextView) viewHolder.itemView.findViewById(R.id.index_tv)).setText(String.format("%d/%d", Integer.valueOf(i + 1), Integer.valueOf(LongPictureEnlargeActivity.this.v.size())));
            final boolean z = !WearUtils.e1(DaoUtils.getReCallDao().canRecall(((CommunMessage) LongPictureEnlargeActivity.this.q.get(i)).getId()));
            LongPictureEnlargeActivity.this.u.setOnClickListener(new View.OnClickListener() { // from class: dc.t72
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.m(view);
                }
            });
            LongPictureEnlargeActivity.this.u.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.u72
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.a.q(i, z, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new e(LongPictureEnlargeActivity.this, LayoutInflater.from(LongPictureEnlargeActivity.this).inflate(R.layout.item_img_view_pger, viewGroup, false));
        }
    }

    public LongPictureEnlargeActivity() {
        new ie3();
        this.y = new ArrayList();
        this.z = new HashMap<>();
        this.A = new ArrayList();
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = false;
        this.L = new c(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P5(View view) {
        String str = "下载第" + this.x.getCurrentItem() + "张";
        b6(this.x.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R5(View view) {
        Intent intent = new Intent(this, (Class<?>) ChatPicturesActivity.class);
        if (WearUtils.e1(this.m)) {
            intent.putExtra("extras_friend_id", this.o);
        } else {
            intent.putExtra("extras_friend_id", this.m);
        }
        intent.putExtra("extras_massage_id", this.n);
        startActivityForResult(intent, 999);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T5(View view) {
        d6(this.x.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V5(String str) {
        try {
            boolean z = true;
            HmsScan[] hmsScanArrDecodeWithBitmap = ScanUtil.decodeWithBitmap(this, WearUtils.J1(str), new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScanBase.QRCODE_SCAN_TYPE, HmsScanBase.DATAMATRIX_SCAN_TYPE).setPhotoMode(true).create());
            if (hmsScanArrDecodeWithBitmap == null || hmsScanArrDecodeWithBitmap.length <= 0) {
                z = false;
            }
            this.K = z;
            this.L.sendEmptyMessage(111);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X5(CommunMessage communMessage, int i) {
        this.F.add(communMessage);
        PictureUsedDialog pictureUsedDialog = this.C;
        if (pictureUsedDialog != null) {
            pictureUsedDialog.dismiss();
        }
        this.q.remove(communMessage);
        this.y.remove(communMessage);
        this.v.remove(i);
        this.w.notifyDataSetChanged();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("recallCommunMessage", (Serializable) this.F);
        intent.putExtras(bundle);
        intent.putExtra("recall", true);
        setResult(-1, intent);
        if (this.v.size() == 0) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z5(int i) {
        try {
            HmsScan[] hmsScanArrDecodeWithBitmap = ScanUtil.decodeWithBitmap(this, WearUtils.J1(this.v.get(i)), new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScanBase.QRCODE_SCAN_TYPE, HmsScanBase.DATAMATRIX_SCAN_TYPE).setPhotoMode(true).create());
            if (hmsScanArrDecodeWithBitmap == null || hmsScanArrDecodeWithBitmap.length <= 0) {
                sg3.h(R.string.qrcode_not_lovense_qrcode);
            } else {
                g6(hmsScanArrDecodeWithBitmap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void H5(CommunMessage communMessage, int i) {
        PictureUsedDialog pictureUsedDialog = this.C;
        if (pictureUsedDialog != null) {
            pictureUsedDialog.dismiss();
        }
        this.q.remove(communMessage);
        this.y.remove(communMessage);
        this.v.remove(i);
        this.w.notifyDataSetChanged();
        this.E.add(communMessage);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("communMessage", (Serializable) this.E);
        intent.putExtras(bundle);
        intent.putExtra("delect", true);
        setResult(-1, intent);
        if (this.v.size() == 0) {
            finish();
        }
        String str = "imgList的长度===" + this.v;
    }

    public final void I5(CommunMessage communMessage) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_message", communMessage);
        pj3.g(this, ForwardMessageActivity.class, bundle);
        this.C.dismiss();
    }

    public final List<String> J5(List<CommunMessage> list) {
        for (CommunMessage communMessage : list) {
            if (communMessage.getType() == MessageType.picture || communMessage.getType() == MessageType.burnpicture) {
                if (communMessage.getDataBean() != null) {
                    String url = ((EntityPicture) communMessage.getDataBean()).getUrl();
                    String localUrl = ((EntityPicture) communMessage.getDataBean()).getLocalUrl();
                    String type = ((EntityPicture) communMessage.getDataBean()).getType();
                    boolean z = !WearUtils.e1(type) && type.equals("emoji");
                    if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists())) {
                        this.v.add(Uri.fromFile(z ? WearUtils.Z(localUrl) : WearUtils.c0(localUrl)).toString());
                    } else if (!TextUtils.isEmpty(url)) {
                        String strB = fu1.b(this, WearUtils.e + url.replace("thum_", ""));
                        File file = new File(strB);
                        if (WearUtils.e1(strB) || !file.exists()) {
                            this.v.add(WearUtils.e + url.replace("thum_", ""));
                        } else {
                            this.v.add(strB);
                        }
                    }
                }
            }
        }
        return this.v;
    }

    public final void K5(CommunMessage communMessage, int i) {
        this.C.dismiss();
        if (N5(communMessage.getId())) {
            this.G = false;
            f6(communMessage.getId());
            ej3.a(this).v(this.v.get(i)).A0(this.u);
        } else {
            e6(communMessage.getId());
            this.G = true;
            String str = "图片====" + this.v.get(i);
            try {
                kf.z(this).v(this.v.get(i)).a(qo.p0(this.D)).f(ii.d).h0(true).A0(this.u);
            } catch (Exception e2) {
                String str2 = "报错===" + e2.toString();
                e2.printStackTrace();
            }
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("hideMap", this.z);
        intent.putExtras(bundle);
        intent.putExtra("hide", true);
        setResult(-1, intent);
    }

    public final void L5() {
        this.m = getIntent().getStringExtra("extras_friend_id");
        this.n = getIntent().getStringExtra("extras_massage_id");
        this.o = getIntent().getStringExtra("extras_room_id");
        this.p = getIntent().getBooleanExtra("notShow", false);
        if (WearUtils.e1(this.o)) {
            this.z = DaoUtils.getMessageHideDao().getHidesToMap(WearUtils.y.p(), WearUtils.j0(this.m));
        } else {
            this.z = DaoUtils.getMessageHideDao().getHidesToMap(WearUtils.y.p(), WearUtils.j0(this.o));
        }
        this.D = new yg<>(new qx3(50));
        if (WearUtils.e1(this.o)) {
            List<CommunMessage> listFindAllPictures = DaoUtils.getCommunMessageDao().findAllPictures(WearUtils.y.p(), WearUtils.j0(this.m));
            this.y = listFindAllPictures;
            if (listFindAllPictures != null) {
                this.q = listFindAllPictures;
            }
            if (this.q.size() > 0) {
                Collections.reverse(this.q);
                int i = 0;
                for (CommunMessage communMessage : this.q) {
                    communMessage.setDataBean(communMessage.syncDecryptBean());
                    if (communMessage.getId().equals(this.n)) {
                        this.s = i;
                    }
                    i++;
                }
            }
        } else {
            String str = "room111111==" + this.o + "room222222==" + WearUtils.j0(this.o);
            ArrayList arrayList = new ArrayList();
            arrayList.add(MessageType.picture);
            List<CommunMessage> listFindMessageByType = DaoUtils.getCommunMessageDao().findMessageByType(WearUtils.y.p(), WearUtils.k0(this.o), null, true, true, arrayList, 0, 0);
            if (listFindMessageByType == null || listFindMessageByType.size() == 0) {
                sg3.l(ah4.e(R.string.quoted_content_deleted));
                return;
            }
            int i2 = 0;
            for (CommunMessage communMessage2 : listFindMessageByType) {
                if (be3.E(communMessage2.getCreated(), communMessage2.getSendStatus())) {
                    communMessage2.setSendStatus(4);
                }
                communMessage2.setDataBean(communMessage2.syncDecryptBean());
                if (communMessage2.getId().equals(this.n)) {
                    this.s = i2;
                }
                i2++;
            }
            List<CommunMessage> listFilterMessages = EntityUnSupport.filterMessages(listFindMessageByType);
            this.y = listFilterMessages;
            if (listFilterMessages != null) {
                this.q = listFilterMessages;
            }
        }
        String str2 = "friendId====" + this.m;
        ImageView imageView = (ImageView) findViewById(R.id.v_image_download);
        this.x = (ViewPager2) findViewById(R.id.viewPager);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.v72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.P5(view);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.v_images_list);
        if (this.p) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: dc.p72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R5(view);
            }
        });
        this.t = (ImageView) findViewById(R.id.v_image_scan);
        String str3 = "currentShowIndex===" + this.s;
        List<String> list = this.v;
        if (list != null && list.size() > 0) {
            this.v.clear();
        }
        this.v = J5(this.q);
        for (int i3 = 0; i3 < this.v.size(); i3++) {
            GifImageView gifImageView = new GifImageView(this);
            this.B = gifImageView;
            gifImageView.setImageResource(R.drawable.error_picture);
            this.A.add(this.B);
        }
        this.w = new f();
        this.x.setOrientation(0);
        this.x.setAdapter(this.w);
        this.x.setCurrentItem(this.s, false);
        List<String> list2 = this.v;
        if (list2 != null && list2.size() > 0) {
            M5(this.v.get(this.x.getCurrentItem()));
        }
        this.t.setOnClickListener(new View.OnClickListener() { // from class: dc.q72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.T5(view);
            }
        });
        this.x.registerOnPageChangeCallback(new a());
    }

    public final void M5(final String str) {
        new Thread(new Runnable() { // from class: dc.w72
            @Override // java.lang.Runnable
            public final void run() {
                this.a.V5(str);
            }
        }).start();
    }

    public boolean N5(String str) {
        return (this.z == null || WearUtils.e1(str) || this.z.get(str) == null) ? false : true;
    }

    public final void a6(final CommunMessage communMessage, final int i) {
        new gp1(new Runnable() { // from class: dc.o72
            @Override // java.lang.Runnable
            public final void run() {
                this.a.X5(communMessage, i);
            }
        }, new b(this)).run();
        if (this.v.size() == 0) {
            finish();
        }
    }

    public final void b6(int i) {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.READ_MEDIA_IMAGES");
        q61VarM.j(new d(i));
    }

    public final void c6(int i, String str) {
        String str2 = this.v.get(i);
        fg3.f(str2, TextUtils.equals("emoji", str) ? "gif" : fg3.d(str2));
    }

    public final void d6(final int i) {
        PictureUsedDialog pictureUsedDialog = this.C;
        if (pictureUsedDialog != null) {
            pictureUsedDialog.dismiss();
        }
        new Thread(new Runnable() { // from class: dc.r72
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Z5(i);
            }
        }).start();
    }

    public void e6(String str) {
        if (WearUtils.e1(str) || WearUtils.e1(WearUtils.y.p())) {
            return;
        }
        MessageHide messageHide = new MessageHide();
        messageHide.setId(str);
        messageHide.setOwnerJid(WearUtils.y.p());
        if (WearUtils.e1(this.m)) {
            messageHide.setFriendJid(WearUtils.j0(this.o));
        } else {
            messageHide.setFriendJid(WearUtils.j0(this.m));
        }
        DaoUtils.getMessageHideDao().addIfNotExist(messageHide);
        this.z.put(str, str);
    }

    public void f6(String str) {
        if (this.z == null || WearUtils.e1(str)) {
            return;
        }
        this.z.remove(str);
        DaoUtils.getMessageHideDao().delById(str);
    }

    public final void g6(HmsScan[] hmsScanArr) {
        for (HmsScan hmsScan : hmsScanArr) {
            String str = "扫码结果" + hmsScan.showResult;
            Z4(hmsScan.getOriginalValue());
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 999 && i2 == -1 && intent != null) {
            if (intent.getBooleanExtra("delect", false) && intent.getSerializableExtra("communMessage") != null) {
                List list = (List) intent.getSerializableExtra("communMessage");
                Intent intent2 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("communMessage", (Serializable) list);
                intent2.putExtras(bundle);
                intent2.putExtra("delect", true);
                setResult(-1, intent2);
            }
            if (intent.getBooleanExtra("recall", false) && intent.getSerializableExtra("recallCommunMessage") != null) {
                List list2 = (List) intent.getSerializableExtra("recallCommunMessage");
                Intent intent3 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("recallCommunMessage", (Serializable) list2);
                intent3.putExtras(bundle2);
                intent3.putExtra("recall", true);
                setResult(-1, intent3);
            }
            if (intent.getBooleanExtra("hide", false) && intent.getSerializableExtra("hideMap") != null) {
                Map map = (Map) intent.getSerializableExtra("hideMap");
                Intent intent4 = new Intent();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("hideMap", (Serializable) map);
                intent4.putExtras(bundle3);
                intent4.putExtra("hide", true);
                setResult(-1, intent4);
            }
            finish();
        }
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_picture_enlarge2);
        L5();
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.clear();
        this.y.clear();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyApplication.N().q0(this);
    }
}
