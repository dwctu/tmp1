package com.wear.main.longDistance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.bean.event.ChatPictureEvent;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.iwatcher.ImageWatcher;
import dc.bo3;
import dc.gg3;
import dc.ie3;
import dc.ol1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatPicturesActivity extends QRCodeActivity implements View.OnClickListener {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.iv_delete_action)
    public View deleteAction;

    @BindView(R.id.expression_gridview)
    public GridView mGridView;
    public ol1 p;

    @BindView(R.id.tv_select_number)
    public TextView selectNumber;
    public boolean v;

    @BindView(R.id.v_image_download)
    public ImageView vImageDownload;

    @BindView(R.id.v_image_scan)
    public ImageView vImageScan;

    @BindView(R.id.v_image_watcher)
    public ImageWatcher vImageWatcher;
    public String m = "";
    public String n = "";
    public boolean o = false;
    public List<CommunMessage> q = new ArrayList();
    public boolean s = false;
    public ArrayList<String> t = new ArrayList<>();
    public int u = -1;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            ChatPicturesActivity chatPicturesActivity;
            ImageView imageView;
            super.handleMessage(message);
            if (message.what == 153 && (imageView = (chatPicturesActivity = ChatPicturesActivity.this).vImageScan) != null) {
                if (chatPicturesActivity.v) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
        }
    }

    public class b implements ImageWatcher.i {

        public class a extends SimpleImageLoadingListener {
            public final /* synthetic */ ImageWatcher.g a;

            public a(b bVar, ImageWatcher.g gVar) {
                this.a = gVar;
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                this.a.b(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                this.a.a(null);
            }
        }

        public b(ChatPicturesActivity chatPicturesActivity) {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.i
        public void a(Context context, String str, ImageWatcher.g gVar) {
            ImageLoader.getInstance().loadImage(str, MyApplication.Y, new a(this, gVar));
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatPicturesActivity chatPicturesActivity = ChatPicturesActivity.this;
            if (chatPicturesActivity.s || chatPicturesActivity.t.size() > 0) {
                ChatPicturesActivity.this.v5();
            }
            ChatPicturesActivity.this.finish();
        }
    }

    public class d implements MyActionBar.f {
        public d() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatPicturesActivity chatPicturesActivity = ChatPicturesActivity.this;
            chatPicturesActivity.o = !chatPicturesActivity.o;
            chatPicturesActivity.u5();
        }
    }

    public class e implements bo3.d {
        public e() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            for (CommunMessage communMessage : ChatPicturesActivity.this.p.c.values()) {
                ChatPicturesActivity.this.t.add(communMessage.getId());
                ChatPicturesActivity.this.q.remove(communMessage);
                DaoUtils.getCommunMessageDao().delT(communMessage);
            }
            ChatPicturesActivity.this.p.c.clear();
            ChatPicturesActivity.this.p.notifyDataSetChanged();
            ChatPicturesActivity.this.y5();
            if (ChatPicturesActivity.this.q.size() == 0) {
                ChatPicturesActivity.this.v5();
                ChatPicturesActivity.this.finish();
            }
        }
    }

    public ChatPicturesActivity() {
        new a(Looper.getMainLooper());
        new ArrayList();
        new ArrayList();
        this.v = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.iv_delete_action) {
            return;
        }
        w5();
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_chat_pictures);
        ButterKnife.bind(this);
        this.m = getIntent().getStringExtra("extras_friend_id");
        this.n = getIntent().getStringExtra("extras_massage_id");
        List<CommunMessage> listFindAllPictures = DaoUtils.getCommunMessageDao().findAllPictures(WearUtils.y.p(), WearUtils.j0(this.m));
        if (listFindAllPictures != null) {
            this.q = listFindAllPictures;
        }
        if (this.q.size() > 0) {
            Collections.reverse(this.q);
            int i = 0;
            for (CommunMessage communMessage : this.q) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
                if (communMessage.getId().equals(this.n)) {
                    this.u = i;
                }
                i++;
            }
        }
        ol1 ol1Var = new ol1(this);
        this.p = ol1Var;
        this.mGridView.setAdapter((ListAdapter) ol1Var);
        u5();
        this.deleteAction.setOnClickListener(this);
        this.vImageWatcher.setTranslucentStatus(gg3.g(this));
        this.vImageWatcher.setErrorImageRes(R.drawable.error_picture);
        this.vImageWatcher.setOnPictureLongPressListener(null);
        this.vImageWatcher.setLoader(new b(this));
        new ie3();
        this.actionbar.setBackAction(new c());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int i = this.u;
        if (i != -1) {
            this.mGridView.smoothScrollToPosition(i);
            this.u = -1;
        }
        MyApplication.N().q0(this);
    }

    public final void u5() {
        if (this.o) {
            this.deleteAction.setVisibility(0);
        } else {
            this.deleteAction.setVisibility(8);
        }
        this.p.c.clear();
        this.p.notifyDataSetChanged();
        z5();
        y5();
    }

    public final void v5() {
        setResult(-1);
        EventBus.getDefault().post(new ChatPictureEvent(this.s, this.t));
    }

    public final void w5() {
        if (this.p.d() > 0) {
            bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_chat_picture);
            bo3Var.show();
            bo3Var.d(R.id.touch_delete, new e());
            bo3Var.d(R.id.touch_cancel, null);
        }
    }

    public void x5() {
        Intent intent = new Intent(this, (Class<?>) LongPictureEnlargeActivity.class);
        intent.putExtra("notShow", true);
        intent.putExtra("extras_friend_id", this.m);
        intent.putExtra("extras_massage_id", this.n);
        intent.putExtra("can_long_click", false);
        startActivity(intent);
    }

    public void y5() {
        int iD = this.p.d();
        if (iD <= 0) {
            this.selectNumber.setVisibility(8);
            this.deleteAction.setAlpha(0.4f);
            this.deleteAction.setEnabled(false);
            return;
        }
        this.selectNumber.setVisibility(0);
        this.selectNumber.setText("(" + iD + ")");
        this.deleteAction.setAlpha(1.0f);
        this.deleteAction.setEnabled(true);
    }

    public final void z5() {
        this.actionbar.setYesAction(this.o ? R.string.common_cancel : R.string.common_select, new d());
        if (this.o) {
            this.actionbar.setBackVisibility(8);
        } else {
            this.actionbar.setBackVisibility(0);
        }
    }
}
