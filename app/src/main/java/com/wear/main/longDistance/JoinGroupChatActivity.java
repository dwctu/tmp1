package com.wear.main.longDistance;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.bv1;
import dc.ch3;
import dc.cs3;
import dc.hu3;
import dc.ii;
import dc.is3;
import dc.kf;
import dc.kv1;
import dc.pj3;
import dc.qo;
import dc.sg3;
import dc.tg3;
import dc.zb2;
import java.util.ArrayList;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomQrcodeJoin;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeInfo;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeJoin;

/* loaded from: classes3.dex */
public class JoinGroupChatActivity extends BaseActivity {
    public ResponseRoomQrcodeInfo.DataBean a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public String b;

    @BindView(R.id.iv_user_img)
    public RoundedImageView ivUserImg;

    @BindView(R.id.tv_count)
    public TextView tvCount;

    @BindView(R.id.tv_group_name)
    public TextView tvGroupName;

    public class a implements kv1 {

        /* renamed from: com.wear.main.longDistance.JoinGroupChatActivity$a$a, reason: collision with other inner class name */
        public class C0120a implements bv1 {
            public C0120a() {
            }

            @Override // dc.bv1
            public void Q(String str) {
                pj3.j(JoinGroupChatActivity.this, ChatRoomActivity.class, "roomId", str);
                JoinGroupChatActivity.this.finish();
            }

            @Override // dc.bv1
            public void r1(String str) {
                JoinGroupChatActivity.this.finish();
            }
        }

        public class b implements bv1 {
            public b() {
            }

            @Override // dc.bv1
            public void Q(String str) {
                JoinGroupChatActivity.this.progressDialog.dismiss();
                pj3.j(JoinGroupChatActivity.this, ChatRoomActivity.class, "roomId", str);
                JoinGroupChatActivity.this.finish();
            }

            @Override // dc.bv1
            public void r1(String str) {
                JoinGroupChatActivity.this.progressDialog.dismiss();
            }
        }

        public a() {
        }

        @Override // dc.kv1
        public void a(String str) {
            JoinGroupChatActivity.this.dissDialog();
            ResponseRoomQrcodeJoin responseRoomQrcodeJoin = (ResponseRoomQrcodeJoin) JSON.parseObject(str, ResponseRoomQrcodeJoin.class);
            if (responseRoomQrcodeJoin.suc()) {
                hu3.z(JoinGroupChatActivity.this.application).r(responseRoomQrcodeJoin.data, new C0120a(), true);
                return;
            }
            int i = responseRoomQrcodeJoin.code;
            if (i == 2) {
                JoinGroupChatActivity.this.v4(R.string.group_chat_qr_scan_error4);
                return;
            }
            if (i == 3) {
                JoinGroupChatActivity.this.v4(R.string.group_chat_qr_scan_error1);
                return;
            }
            if (i == 4) {
                JoinGroupChatActivity.this.v4(R.string.group_chat_member_invitations);
                return;
            }
            if (i == 5) {
                JoinGroupChatActivity.this.v4(R.string.group_chat_qr_scan_error2);
                return;
            }
            if (i == 6) {
                String str2 = responseRoomQrcodeJoin.data;
                if (ch3.n().k(str2) == null) {
                    hu3.z(JoinGroupChatActivity.this.application).q(str2, new b());
                    return;
                } else {
                    pj3.j(JoinGroupChatActivity.this, ChatRoomActivity.class, "roomId", str2);
                    return;
                }
            }
            if (i == 7) {
                JoinGroupChatActivity.this.v4(R.string.group_chat_qr_scan_error3);
                return;
            }
            if (responseRoomQrcodeJoin.getCode() != 0) {
                JoinGroupChatActivity.this.v4(R.string.lan_api_connect_service_error);
                return;
            }
            sg3.l(responseRoomQrcodeJoin.getMsg() + "");
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            JoinGroupChatActivity.this.v4(R.string.scan_check_you_internet);
            JoinGroupChatActivity.this.dissDialog();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                JoinGroupChatActivity.this.finish();
            }
        }

        public b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (JoinGroupChatActivity.this.isFinishing() || JoinGroupChatActivity.this.isDestroyed()) {
                return;
            }
            cs3.k(JoinGroupChatActivity.this, ah4.e(this.a), new a()).show();
        }
    }

    @OnClick({R.id.tv_join})
    public void onClick() {
        showDialog();
        RequestRoomQrcodeJoin requestRoomQrcodeJoin = new RequestRoomQrcodeJoin();
        requestRoomQrcodeJoin.codeKey = this.b;
        zb2.O().B0(requestRoomQrcodeJoin, new a());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_join_group_chat);
        ButterKnife.bind(this);
        this.a = (ResponseRoomQrcodeInfo.DataBean) getIntent().getParcelableExtra("data");
        this.b = getIntent().getStringExtra("qrcode");
        this.tvGroupName.setText(this.a.getRoomName());
        this.tvCount.setText("(" + this.a.getTotal() + ")");
        qo qoVarF = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default).f(ii.b);
        String strC = tg3.c(this.a.getUrl());
        if (TextUtils.isEmpty(strC)) {
            strC = tg3.b(this.a.getMergeUrl());
            if (!TextUtils.isEmpty(strC)) {
                ArrayList arrayList = new ArrayList();
                for (String str : strC.split(",", -1)) {
                    if (!str.startsWith("http")) {
                        str = WearUtils.e + str;
                    }
                    arrayList.add(str);
                }
                if (arrayList.size() == 1) {
                    arrayList.add("");
                    arrayList.add("");
                }
                kf.w(this.ivUserImg.getContext()).u(arrayList).a(qoVarF).A0(this.ivUserImg);
                return;
            }
        }
        if (!strC.startsWith("http")) {
            strC = WearUtils.e + strC;
        }
        kf.w(this.ivUserImg.getContext()).v(strC).a(qoVarF).A0(this.ivUserImg);
    }

    public final void v4(int i) {
        runOnMainThread(new b(i));
    }
}
