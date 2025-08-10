package com.wear.main.closeRange;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.GroupPatternSaveMemberAdapter;
import com.wear.bean.Pattern;
import com.wear.bean.event.ChatRoomMessageReflashEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPattern;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewCurveLineView;
import com.wear.widget.control.TouchControlView;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.cg3;
import dc.de0;
import dc.ff3;
import dc.h12;
import dc.kv1;
import dc.mp1;
import dc.na2;
import dc.nd3;
import dc.nf3;
import dc.rf3;
import dc.sg3;
import dc.wq1;
import dc.xe2;
import dc.zb2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.disco.bean.request.RequestMessageRecord;
import org.jivesoftware.smackx.disco.bean.request.RequestPatternOrAlarmList;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.ResponsePatternOrAlarmMessage;

/* loaded from: classes3.dex */
public class GroupPatternInfoActivity extends BaseActivity {
    public CommunMessage a;
    public EntityPattern b;
    public Pattern c;
    public GroupPatternSaveMemberAdapter d;
    public String f;

    @BindView(R.id.iv_play)
    public ImageView ivPlay;

    @BindView(R.id.iv_save)
    public ImageView ivSave;

    @BindView(R.id.iv_user_img)
    public RoundedImageView ivUserImg;
    public List<String> k;
    public Handler m;
    public Runnable n;

    @BindView(R.id.pattern_line)
    public NewCurveLineView pattern_line;

    @BindView(R.id.rv_member_accept)
    public RecyclerView rvMemberAccept;

    @BindView(R.id.tv_pattern_name)
    public TextView tvPatternName;

    @BindView(R.id.tv_play)
    public TextView tvPlay;

    @BindView(R.id.tv_save)
    public TextView tvSave;

    @BindView(R.id.tv_save_member)
    public TextView tvSaveMember;
    public ArrayList<ResponsePatternOrAlarmMessage.DataBean> e = new ArrayList<>();
    public String[] g = null;
    public int h = 0;
    public int i = 100;
    public boolean j = true;
    public boolean l = false;

    public class a implements kv1 {
        public a() {
        }

        @Override // dc.kv1
        public void a(String str) {
            try {
                ResponsePatternOrAlarmMessage responsePatternOrAlarmMessage = (ResponsePatternOrAlarmMessage) JSON.parseObject(str, ResponsePatternOrAlarmMessage.class);
                if (responsePatternOrAlarmMessage.getCode() != 1) {
                    GroupPatternInfoActivity.this.I4(false, 0, null);
                    return;
                }
                for (ResponsePatternOrAlarmMessage.DataBean dataBean : responsePatternOrAlarmMessage.getData()) {
                    String photo = dataBean.getPhoto();
                    if (!TextUtils.isEmpty(photo) && !photo.contains("UploadFiles/wear/avatar")) {
                        try {
                            String str2 = new String(Base64.decode(photo), "ISO-8859-1");
                            photo = (TextUtils.isEmpty(str2) || str2.length() > 512) ? "" : str2;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    dataBean.setPhoto(photo);
                }
                GroupPatternInfoActivity.this.I4(true, 0, responsePatternOrAlarmMessage.getData());
            } catch (Exception e2) {
                e2.printStackTrace();
                GroupPatternInfoActivity.this.I4(false, 0, null);
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            GroupPatternInfoActivity.this.I4(false, 0, null);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Pattern a;

        public b(Pattern pattern) {
            this.a = pattern;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupPatternInfoActivity groupPatternInfoActivity = GroupPatternInfoActivity.this;
            groupPatternInfoActivity.m.postDelayed(groupPatternInfoActivity.n, groupPatternInfoActivity.i);
            if (GroupPatternInfoActivity.this.j) {
                return;
            }
            int i = 0;
            if (GroupPatternInfoActivity.this.h >= GroupPatternInfoActivity.this.g.length - 1) {
                GroupPatternInfoActivity.this.j = true;
                GroupPatternInfoActivity.z4(GroupPatternInfoActivity.this);
                GroupPatternInfoActivity.this.application.G().u0();
                if (GroupPatternInfoActivity.this.j) {
                    GroupPatternInfoActivity.this.ivPlay.setImageResource(R.drawable.chat_group_pattern_play);
                } else {
                    GroupPatternInfoActivity.this.ivPlay.setImageResource(R.drawable.chat_group_pattern_pause);
                }
                GroupPatternInfoActivity.this.l = false;
            }
            if (GroupPatternInfoActivity.this.h >= 0 && GroupPatternInfoActivity.this.h < GroupPatternInfoActivity.this.g.length - 1) {
                String str = GroupPatternInfoActivity.this.g[GroupPatternInfoActivity.this.h];
                if (WearUtils.e1(str)) {
                    return;
                }
                GroupPatternInfoActivity groupPatternInfoActivity2 = GroupPatternInfoActivity.this;
                groupPatternInfoActivity2.pattern_line.a(groupPatternInfoActivity2.h, this.a, GroupPatternInfoActivity.this.g);
                if (this.a.getHead() == null) {
                    float f = WearUtils.q1(str) ? Float.parseFloat(str) : 0.0f;
                    GroupPatternInfoActivity.this.pattern_line.setFirstLinePoint(101.0f - f);
                    GroupPatternInfoActivity.this.application.G().W((int) f);
                    int i2 = GroupPatternInfoActivity.this.h % 10;
                } else {
                    GroupPatternInfoActivity.this.k = this.a.getHead().createCommands(str);
                    int i3 = GroupPatternInfoActivity.this.h % 10;
                    if (GroupPatternInfoActivity.this.k.size() != 0 && !WearUtils.e1((String) GroupPatternInfoActivity.this.k.get(GroupPatternInfoActivity.this.k.size() - 1))) {
                        String str2 = (String) GroupPatternInfoActivity.this.k.get(GroupPatternInfoActivity.this.k.size() - 1);
                        if (str2.split(",").length <= 2 || !this.a.getHead().isAllFunc()) {
                            GroupPatternInfoActivity.this.pattern_line.setBothLinePoint(str2);
                        } else {
                            GroupPatternInfoActivity.this.pattern_line.setBothLinePoint(str2.split(",")[0]);
                        }
                    }
                    Iterator it = GroupPatternInfoActivity.this.k.iterator();
                    while (it.hasNext()) {
                        de0.j("ble_pattern", "after cmd: " + ((String) it.next()));
                    }
                    if (mp1.h()) {
                        wq1.a(str, this.a, new ToyControlBuilder(false, true, true));
                    } else if (GroupPatternInfoActivity.this.k != null) {
                        for (String str3 : GroupPatternInfoActivity.this.k) {
                            if (GroupPatternInfoActivity.this.k.size() == 1 || i < GroupPatternInfoActivity.this.k.size() - 1) {
                                GroupPatternInfoActivity.this.application.G().g0(str3);
                            }
                            i++;
                        }
                    }
                }
                GroupPatternInfoActivity.A4(GroupPatternInfoActivity.this);
            }
        }
    }

    public class c implements kv1 {
        public c() {
        }

        @Override // dc.kv1
        public void a(String str) {
            try {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).getCode() == 1) {
                    GroupPatternInfoActivity.this.N4();
                } else {
                    GroupPatternInfoActivity.this.I4(false, 2, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                GroupPatternInfoActivity.this.I4(false, 2, null);
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            GroupPatternInfoActivity.this.I4(false, 2, null);
        }
    }

    public class d extends ff3 {
        public final /* synthetic */ boolean a;

        public class a implements Runnable {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ Object b;

            public a(boolean z, Object obj) {
                this.a = z;
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (!this.a) {
                    GroupPatternInfoActivity.this.I4(false, 1, null);
                    sg3.i(GroupPatternInfoActivity.this, R.string.file_notfound);
                    return;
                }
                File file = (File) this.b;
                String strN1 = WearUtils.N1(file.getPath());
                if (TextUtils.isEmpty(strN1) || strN1.contains("result")) {
                    if (file.exists()) {
                        file.delete();
                    }
                    sg3.h(R.string.file_notfound);
                    GroupPatternInfoActivity.this.I4(false, 1, null);
                    return;
                }
                Pattern pattern = new Pattern();
                pattern.setData(strN1);
                d dVar = d.this;
                GroupPatternInfoActivity.this.M4(pattern, dVar.a);
                GroupPatternInfoActivity.this.I4(false, 1, null);
            }
        }

        public d(boolean z) {
            this.a = z;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            GroupPatternInfoActivity.this.parentHandler.post(new a(z, obj));
        }
    }

    public class e implements nf3.d {
        public e() {
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) throws IOException {
            if (WearUtils.e1(str) || str.contains("result")) {
                GroupPatternInfoActivity.this.I4(false, 2, null);
                sg3.i(GroupPatternInfoActivity.this, R.string.file_notfound);
                return;
            }
            String strReplace = str.replace("\r", "");
            String status = GroupPatternInfoActivity.this.a.getStatus();
            if (WearUtils.e1(status)) {
                status = WearUtils.E();
            }
            if (rf3.o(strReplace)) {
                strReplace = rf3.r(strReplace);
            }
            WearUtils.m2(strReplace, status);
            Pattern pattern = new Pattern(status);
            pattern.setName(GroupPatternInfoActivity.this.b.getName());
            pattern.setCreator(WearUtils.y.r());
            pattern.setEmail(WearUtils.y.r());
            pattern.setAuthor(WearUtils.y.u().getUserName());
            pattern.setTimer(WearUtils.Q(GroupPatternInfoActivity.this.b.getTime()));
            pattern.setToyFunc(GroupPatternInfoActivity.this.b.getFeature());
            xe2.L0().t(pattern, true);
            GroupPatternInfoActivity.this.a.setStatus(pattern.getId());
            CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(GroupPatternInfoActivity.this.a.getId());
            if (communMessageFindById != null) {
                communMessageFindById.setStatus(pattern.getId());
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessageFindById);
                if (WearUtils.e1(DaoUtils.getCommunMessageDao().findById(GroupPatternInfoActivity.this.a.getId()).getStatus())) {
                    GroupPatternInfoActivity.this.a.setStatus(null);
                    sg3.i(GroupPatternInfoActivity.this, R.string.chat_save_pattern_failed);
                }
            }
            GroupPatternInfoActivity.this.I4(true, 2, null);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;

        public f(boolean z, int i, List list) {
            this.a = z;
            this.b = i;
            this.c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                int i = this.b;
                if (i == 2) {
                    GroupPatternInfoActivity.this.ivSave.setEnabled(false);
                    GroupPatternInfoActivity.this.ivSave.setImageResource(R.drawable.chat_group_saved);
                    GroupPatternInfoActivity.this.tvSave.setText(ah4.e(R.string.common_saved));
                    EventBus.getDefault().post(new ChatRoomMessageReflashEvent());
                    GroupPatternInfoActivity.this.L4();
                } else if (i == 1) {
                    GroupPatternInfoActivity.this.ivPlay.setEnabled(true);
                } else {
                    GroupPatternInfoActivity.this.e.clear();
                    GroupPatternInfoActivity.this.e.addAll(this.c);
                    GroupPatternInfoActivity.this.tvSaveMember.setText(String.format(ah4.e(R.string.group_chat_pattern_save_member), GroupPatternInfoActivity.this.e.size() + ""));
                    GroupPatternInfoActivity.this.d.notifyDataSetChanged();
                }
            } else {
                int i2 = this.b;
                if (i2 == 2) {
                    GroupPatternInfoActivity.this.ivSave.setEnabled(true);
                } else if (i2 == 1) {
                    GroupPatternInfoActivity.this.ivPlay.setEnabled(true);
                }
            }
            GroupPatternInfoActivity.this.progressDialog.dismiss();
        }
    }

    public static /* synthetic */ int A4(GroupPatternInfoActivity groupPatternInfoActivity) {
        int i = groupPatternInfoActivity.h;
        groupPatternInfoActivity.h = i + 1;
        return i;
    }

    public static /* synthetic */ int z4(GroupPatternInfoActivity groupPatternInfoActivity) {
        int i = groupPatternInfoActivity.h - 1;
        groupPatternInfoActivity.h = i;
        return i;
    }

    public final void I4(boolean z, int i, List<ResponsePatternOrAlarmMessage.DataBean> list) {
        this.parentHandler.post(new f(z, i, list));
    }

    public final boolean J4(Pattern pattern, boolean z) {
        if (pattern.getFile().exists()) {
            if (!pattern.setDataNoCheckFormat(WearUtils.N1(pattern.getFile().getPath()))) {
                return false;
            }
        } else if (!pattern.setDataNoCheckFormat(pattern.getData())) {
            return false;
        }
        if (pattern.getHead() == null) {
            this.g = pattern.getData().split(",");
            this.pattern_line.setShowBothLine(false);
        } else {
            this.g = pattern.getData().split(TouchControlView.P);
            if (pattern.getHead().isMulFunction()) {
                this.pattern_line.setShowBothLine(true);
            } else {
                this.pattern_line.setShowBothLine(false);
            }
        }
        return true;
    }

    public final void K4(boolean z) throws Throwable {
        if (z) {
            this.ivPlay.setEnabled(false);
        }
        Pattern pattern = this.c;
        if (pattern != null) {
            M4(pattern, z);
            return;
        }
        if (this.a.isSelfMessage(WearUtils.y.r()) && !WearUtils.e1(this.b.getLocalUrl())) {
            String strI = nd3.i(this.b.getLocalUrl());
            if (!WearUtils.e1(strI)) {
                File file = new File(strI);
                if (file.exists()) {
                    String strN1 = WearUtils.N1(file.getPath());
                    if (!TextUtils.isEmpty(strN1) && !strN1.contains("result")) {
                        Pattern pattern2 = new Pattern();
                        pattern2.setData(strN1);
                        M4(pattern2, z);
                        return;
                    } else {
                        if (file.exists()) {
                            file.delete();
                        }
                        if (z) {
                            sg3.h(R.string.file_notfound);
                            this.ivPlay.setEnabled(true);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        WearUtils.E0(true, this.b.getUrl(), new d(z));
    }

    public final void L4() {
        if (WearUtils.e1(this.a.getMsgId())) {
            this.ivSave.setEnabled(false);
            return;
        }
        this.progressDialog.show();
        zb2.O().C0(new RequestPatternOrAlarmList(this.f, this.a.getMsgId(), 1), WearUtils.j0(this.f), new a());
    }

    public final void M4(Pattern pattern, boolean z) {
        if (!z) {
            if (J4(pattern, false)) {
                this.pattern_line.a(0, pattern, this.g);
                return;
            }
            return;
        }
        if (J4(pattern, true)) {
            this.j = false;
            this.ivPlay.setTag("s");
            this.ivPlay.setImageResource(R.drawable.chat_group_pattern_pause);
            MusicControl.h0();
            h12.D.playPatternPause = true;
            if (MusicControl.h0().O()) {
                EventBus eventBus = EventBus.getDefault();
                MusicControl.h0();
                eventBus.post(h12.D);
            }
            this.h = 0;
            this.pattern_line.b();
            Handler handler = this.m;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.l = true;
            this.m = new Handler();
            this.n = new b(pattern);
            I4(true, 1, null);
            this.m.postDelayed(this.n, 0L);
        }
    }

    public final void N4() {
        nf3.b(this.b.getUrl(), new e());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        CommunMessage communMessageFindById;
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_pattern_info);
        ButterKnife.bind(this);
        CommunMessage communMessage = (CommunMessage) getIntent().getSerializableExtra("message");
        this.a = communMessage;
        if (WearUtils.e1(communMessage.getMsgId()) && (communMessageFindById = DaoUtils.getCommunMessageDao().findById(this.a.getId())) != null) {
            this.a.setMsgId(communMessageFindById.getMsgId());
        }
        String stringExtra = getIntent().getStringExtra("avatar");
        this.f = getIntent().getStringExtra("roomId");
        WearUtils.u2(this.ivUserImg, stringExtra);
        this.b = (EntityPattern) this.a.getDataBean();
        String status = this.a.getStatus();
        this.tvPatternName.setText(this.b.getName());
        this.c = xe2.L0().K(status);
        GroupPatternSaveMemberAdapter groupPatternSaveMemberAdapter = new GroupPatternSaveMemberAdapter(this.e, R.layout.item_group_pattern_save_member);
        this.d = groupPatternSaveMemberAdapter;
        cg3.f(this.rvMemberAccept, groupPatternSaveMemberAdapter);
        if (WearUtils.e1(status) || this.c == null) {
            this.ivSave.setEnabled(true);
            this.ivSave.setImageResource(R.drawable.chat_group_save);
            this.tvSave.setText(ah4.e(R.string.common_save));
        } else {
            this.ivSave.setEnabled(false);
            this.ivSave.setImageResource(R.drawable.chat_group_saved);
            this.tvSave.setText(ah4.e(R.string.common_saved));
        }
        this.tvSaveMember.setText(String.format(ah4.e(R.string.group_chat_pattern_save_member), this.e.size() + ""));
        L4();
        K4(false);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.application.G().u0();
    }

    @OnClick({R.id.iv_play, R.id.iv_save})
    public void onViewClicked(View view) throws Throwable {
        int id = view.getId();
        if (id != R.id.iv_play) {
            if (id != R.id.iv_save) {
                return;
            }
            this.ivSave.setEnabled(false);
            this.progressDialog.show();
            zb2.O().C0(new RequestMessageRecord(this.f, this.a.getMsgId(), 1), WearUtils.j0(this.f), new c());
            return;
        }
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        if (!this.l) {
            K4(true);
            return;
        }
        if (!view.getTag().toString().equals("s")) {
            this.j = false;
            ((ImageView) view).setImageResource(R.drawable.chat_group_pattern_pause);
            view.setTag("s");
        } else {
            this.j = true;
            ((ImageView) view).setImageResource(R.drawable.chat_group_pattern_play);
            view.setTag("p");
            this.application.G().u0();
        }
    }
}
