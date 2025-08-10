package com.wear.main.longDistance.alarm;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.GroupAlarmSaveMemberAdapter;
import com.wear.bean.AlarmListItems;
import com.wear.bean.Group;
import com.wear.bean.event.ChatRoomMessageReflashEvent;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityAlarm;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.kv1;
import dc.u51;
import dc.zb2;
import dc.zt3;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.disco.bean.request.RequestMessageRecord;
import org.jivesoftware.smackx.disco.bean.request.RequestPatternOrAlarmList;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.ResponsePatternOrAlarmMessage;

/* loaded from: classes3.dex */
public class GroupAlarmInfoActivity extends BaseActivity {
    public CommunMessage a;
    public String b;
    public GroupAlarmSaveMemberAdapter c;
    public ArrayList<ResponsePatternOrAlarmMessage.DataBean> d = new ArrayList<>();
    public EntityAlarm e;

    @BindView(R.id.iv_alarm_status_accept)
    public ImageView ivAlarmStatusAccept;

    @BindView(R.id.iv_alarm_status_decline)
    public ImageView ivAlarmStatusDecline;

    @BindView(R.id.iv_alarm_status_expired)
    public ImageView ivAlarmStatusExpired;

    @BindView(R.id.iv_user_img)
    public RoundedImageView ivUserImg;

    @BindView(R.id.ll_alarm_status)
    public LinearLayout llAlarmStatus;

    @BindView(R.id.ll_alarm_status_accept)
    public LinearLayout llAlarmStatusAccept;

    @BindView(R.id.ll_alarm_status_decline)
    public LinearLayout llAlarmStatusDecline;

    @BindView(R.id.ll_alarm_status_expired)
    public LinearLayout llAlarmStatusExpired;

    @BindView(R.id.rv_member_accept)
    public RecyclerView rvMemberAccept;

    @BindView(R.id.tv_accepted_members)
    public TextView tvAcceptedMembers;

    @BindView(R.id.tv_alarm_name)
    public TextView tvAlarmName;

    @BindView(R.id.tv_alarm_state)
    public TextView tvAlarmState;

    @BindView(R.id.tv_alarm_status_accept)
    public TextView tvAlarmStatusAccept;

    @BindView(R.id.tv_alarm_status_decline)
    public TextView tvAlarmStatusDecline;

    @BindView(R.id.tv_alarm_status_expired)
    public TextView tvAlarmStatusExpired;

    @BindView(R.id.tv_user_name)
    public TextView tvUserName;

    public class a implements kv1 {
        public a() {
        }

        @Override // dc.kv1
        public void a(String str) {
            try {
                ResponsePatternOrAlarmMessage responsePatternOrAlarmMessage = (ResponsePatternOrAlarmMessage) JSON.parseObject(str, ResponsePatternOrAlarmMessage.class);
                if (responsePatternOrAlarmMessage.getCode() != 1) {
                    GroupAlarmInfoActivity.this.x4(false, 0, null);
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
                GroupAlarmInfoActivity.this.x4(true, 0, responsePatternOrAlarmMessage.getData());
            } catch (Exception e2) {
                e2.printStackTrace();
                GroupAlarmInfoActivity.this.x4(false, 0, null);
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            GroupAlarmInfoActivity.this.x4(false, 0, null);
        }
    }

    public class b implements kv1 {
        public b() {
        }

        @Override // dc.kv1
        public void a(String str) {
            try {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).getCode() == 1) {
                    GroupAlarmInfoActivity.this.x4(true, 1, null);
                } else {
                    GroupAlarmInfoActivity.this.x4(false, 1, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                GroupAlarmInfoActivity.this.x4(false, 1, null);
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            GroupAlarmInfoActivity.this.x4(false, 1, null);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;

        public c(boolean z, int i, List list) {
            this.a = z;
            this.b = i;
            this.c = list;
        }

        @Override // java.lang.Runnable
        public void run() throws ParseException {
            if (this.a) {
                if (this.b == 1) {
                    String id = GroupAlarmInfoActivity.this.e.getId();
                    GroupAlarmInfoActivity.this.e.setId(WearUtils.E());
                    GroupAlarmInfoActivity.this.a.setStatus(AlarmListItems.ALARM_STATUS_ACCEPT + id);
                    GroupAlarmInfoActivity groupAlarmInfoActivity = GroupAlarmInfoActivity.this;
                    groupAlarmInfoActivity.a.sendEntity(groupAlarmInfoActivity.e);
                    DaoUtils.getCommunMessageDao().update((CommunMessageDao) GroupAlarmInfoActivity.this.a);
                    AlarmListItems alarmListItemsFindAlarmByreceiveAlarmId = DaoUtils.getAlarmListDao().findAlarmByreceiveAlarmId(id);
                    if (alarmListItemsFindAlarmByreceiveAlarmId != null) {
                        alarmListItemsFindAlarmByreceiveAlarmId.setAccept(1);
                        alarmListItemsFindAlarmByreceiveAlarmId.setIsSelected(1);
                        DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindAlarmByreceiveAlarmId);
                        zt3.t(GroupAlarmInfoActivity.this, alarmListItemsFindAlarmByreceiveAlarmId.getId(), false, true, false);
                    }
                    GroupAlarmInfoActivity.this.B4();
                    EventBus.getDefault().post(new ChatRoomMessageReflashEvent());
                    GroupAlarmInfoActivity.this.A4();
                } else if (this.c != null) {
                    GroupAlarmInfoActivity.this.d.clear();
                    GroupAlarmInfoActivity.this.d.addAll(this.c);
                    GroupAlarmInfoActivity.this.tvAcceptedMembers.setText(String.format(ah4.e(R.string.group_chat_accept_members), GroupAlarmInfoActivity.this.d.size() + ""));
                    GroupAlarmInfoActivity.this.c.notifyDataSetChanged();
                }
            }
            GroupAlarmInfoActivity.this.progressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z4(List list, boolean z) {
        if (z) {
            s4();
        }
    }

    public final void A4() {
        if (WearUtils.e1(this.a.getMsgId())) {
            return;
        }
        this.progressDialog.show();
        zb2.O().C0(new RequestPatternOrAlarmList(this.b, this.a.getMsgId(), 2), WearUtils.j0(this.b), new a());
    }

    public final void B4() {
        String status = this.a.getStatus();
        this.llAlarmStatus.setVisibility(0);
        Group groupK = ch3.n().k(this.b);
        if (!status.startsWith(AlarmListItems.ALARM_STATUS_WAIT)) {
            this.ivAlarmStatusAccept.setEnabled(false);
            this.ivAlarmStatusDecline.setEnabled(false);
            if (status.startsWith(AlarmListItems.ALARM_STATUS_ACCEPT)) {
                this.llAlarmStatusAccept.setVisibility(0);
                this.ivAlarmStatusAccept.setImageResource(R.drawable.chat_group_saved);
                this.tvAlarmStatusAccept.setText(ah4.e(R.string.common_accepted));
                this.llAlarmStatusDecline.setVisibility(8);
                this.llAlarmStatusExpired.setVisibility(8);
                return;
            }
            if (status.startsWith(AlarmListItems.ALARM_STATUS_REJECT)) {
                this.llAlarmStatusAccept.setVisibility(8);
                this.llAlarmStatusDecline.setVisibility(0);
                this.ivAlarmStatusDecline.setImageResource(R.drawable.recording_pause);
                this.tvAlarmStatusDecline.setText(ah4.e(R.string.common_declined));
                this.llAlarmStatusExpired.setVisibility(8);
                return;
            }
            return;
        }
        if (AlarmMessagingService.b(this.e)) {
            this.llAlarmStatusAccept.setVisibility(8);
            this.llAlarmStatusDecline.setVisibility(8);
            this.llAlarmStatusExpired.setVisibility(0);
            this.ivAlarmStatusExpired.setImageResource(R.drawable.recording_expired);
            this.tvAlarmStatusExpired.setText(ah4.e(R.string.common_expired));
            return;
        }
        this.llAlarmStatusAccept.setVisibility(0);
        this.ivAlarmStatusAccept.setImageResource(R.drawable.chat_group_save);
        this.tvAlarmStatusAccept.setText(ah4.e(R.string.common_accept));
        this.llAlarmStatusDecline.setVisibility(0);
        this.ivAlarmStatusDecline.setImageResource(R.drawable.chat_group_decline);
        this.tvAlarmStatusDecline.setText(ah4.e(R.string.common_decline));
        this.llAlarmStatusExpired.setVisibility(8);
        if (groupK == null || groupK.isExit()) {
            this.ivAlarmStatusAccept.setEnabled(false);
            this.ivAlarmStatusDecline.setEnabled(false);
            this.llAlarmStatusAccept.setVisibility(0);
            this.ivAlarmStatusAccept.setImageResource(R.drawable.chat_group_saved);
            this.tvAlarmStatusAccept.setText(ah4.e(R.string.common_accept));
            this.llAlarmStatusDecline.setVisibility(8);
            this.llAlarmStatusExpired.setVisibility(8);
            this.llAlarmStatusDecline.setVisibility(0);
            this.ivAlarmStatusDecline.setImageResource(R.drawable.recording_pause);
            this.tvAlarmStatusDecline.setText(ah4.e(R.string.common_decline));
            this.llAlarmStatusExpired.setVisibility(8);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        CommunMessage communMessageFindById;
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_alarm_info);
        ButterKnife.bind(this);
        CommunMessage communMessage = (CommunMessage) getIntent().getSerializableExtra("message");
        this.a = communMessage;
        if (WearUtils.e1(communMessage.getMsgId()) && (communMessageFindById = DaoUtils.getCommunMessageDao().findById(this.a.getId())) != null) {
            this.a.setMsgId(communMessageFindById.getMsgId());
        }
        String stringExtra = getIntent().getStringExtra("avatar");
        this.b = getIntent().getStringExtra("roomId");
        WearUtils.u2(this.ivUserImg, stringExtra);
        this.tvUserName.setText(String.format(ah4.e(R.string.group_chat_sync_from), this.a.getRealFromNickName()));
        EntityAlarm entityAlarm = (EntityAlarm) this.a.getDataBean();
        this.e = entityAlarm;
        this.tvAlarmName.setText(entityAlarm.getName());
        this.tvAlarmState.setText(SetAlarmActivity.K4(this.e.getPattern().getFrequency(), this.e.getPattern().getDates() == null ? null : WearUtils.A.toJson(this.e.getPattern().getDates())));
        GroupAlarmSaveMemberAdapter groupAlarmSaveMemberAdapter = new GroupAlarmSaveMemberAdapter(this.d, R.layout.item_group_pattern_save_member);
        this.c = groupAlarmSaveMemberAdapter;
        cg3.f(this.rvMemberAccept, groupAlarmSaveMemberAdapter);
        this.ivAlarmStatusAccept.setEnabled(true);
        this.ivAlarmStatusDecline.setEnabled(true);
        if (this.a.isSelfMessage(WearUtils.y.r())) {
            this.llAlarmStatus.setVisibility(8);
        } else {
            B4();
        }
        this.tvAcceptedMembers.setText(String.format(ah4.e(R.string.group_chat_accept_members), this.d.size() + ""));
        A4();
    }

    @OnClick({R.id.iv_alarm_status_accept, R.id.iv_alarm_status_decline})
    public void onViewClicked(View view) throws ParseException {
        switch (view.getId()) {
            case R.id.iv_alarm_status_accept /* 2131363080 */:
                if (!zt3.f()) {
                    zt3.v(this, new u51() { // from class: dc.m82
                        @Override // dc.u51
                        public /* synthetic */ void a(List list, boolean z) {
                            t51.a(this, list, z);
                        }

                        @Override // dc.u51
                        public final void b(List list, boolean z) {
                            this.a.z4(list, z);
                        }
                    });
                    break;
                } else {
                    s4();
                    break;
                }
            case R.id.iv_alarm_status_decline /* 2131363081 */:
                this.ivAlarmStatusDecline.setEnabled(false);
                AlarmListItems alarmListItemsFindAlarmByreceiveAlarmId = DaoUtils.getAlarmListDao().findAlarmByreceiveAlarmId(this.e.getId());
                if (alarmListItemsFindAlarmByreceiveAlarmId != null) {
                    alarmListItemsFindAlarmByreceiveAlarmId.setAccept(2);
                    DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindAlarmByreceiveAlarmId);
                    zt3.t(this, alarmListItemsFindAlarmByreceiveAlarmId.getId(), true, true, false);
                }
                this.a.setStatus(AlarmListItems.ALARM_STATUS_REJECT);
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.a);
                this.llAlarmStatusAccept.setVisibility(8);
                this.llAlarmStatusDecline.setVisibility(0);
                this.ivAlarmStatusDecline.setImageResource(R.drawable.recording_pause);
                this.tvAlarmStatusDecline.setText(ah4.e(R.string.common_declined));
                this.llAlarmStatusExpired.setVisibility(8);
                EventBus.getDefault().post(new ChatRoomMessageReflashEvent());
                break;
        }
    }

    public final void s4() {
        this.ivAlarmStatusAccept.setEnabled(false);
        this.progressDialog.show();
        zb2.O().C0(new RequestMessageRecord(this.b, this.a.getMsgId(), 2), WearUtils.j0(this.b), new b());
    }

    public final void x4(boolean z, int i, List<ResponsePatternOrAlarmMessage.DataBean> list) {
        this.parentHandler.post(new c(z, i, list));
    }
}
