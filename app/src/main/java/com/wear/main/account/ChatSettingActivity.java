package com.wear.main.account;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.event.ClearAllMessageEvent;
import com.wear.bean.official.OfficialAcount;
import com.wear.dao.DaoUtils;
import com.wear.main.migrate.ui.MigrateChatHistoryActivity;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ch3;
import dc.cs3;
import dc.is3;
import dc.kd2;
import dc.pj3;
import dc.th4;
import dc.vg3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatSettingActivity extends BaseActivity {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.clear_all_message)
    public RelativeLayout clearAllMessage;

    @BindView(R.id.clear_all_message_text)
    public TextView clearAllMessageText;

    public class a implements is3.d {

        /* renamed from: com.wear.main.account.ChatSettingActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0085a implements Runnable {
            public RunnableC0085a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                WearUtils.A("");
                DaoUtils.getCommunMessageDao().deleteAll();
                WearUtils.Q1("temp");
                EventBus.getDefault().post(new ClearAllMessageEvent());
            }
        }

        public a() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            DaoUtils.getOfficialaMessageDao().deleteAll(ch3.n().o().getRemoteAccountId());
            OfficialaCountModel officialaCountModelA = OfficialaCountModel.g.a();
            officialaCountModelA.K(0L);
            OfficialAcount value = officialaCountModelA.o().getValue();
            if (value != null) {
                value.setMessage(null);
            }
            ChatSettingActivity.this.clearAllMessage.setEnabled(false);
            ChatSettingActivity.this.clearAllMessageText.setTextColor(Color.parseColor("#9a9a9a"));
            ChatSettingActivity chatSettingActivity = ChatSettingActivity.this;
            chatSettingActivity.clearAllMessageText.setTextColor(th4.b(chatSettingActivity, R.color.text_color_65));
            WearUtils.Q1("temp");
            EventBus.getDefault().post(new ClearAllMessageEvent());
            vg3.b().a(new RunnableC0085a(this));
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_setting);
        ButterKnife.bind(this);
        kd2.C().s(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        kd2.C().J(this);
    }

    @OnClick({R.id.rl_theme, R.id.rl_chat_bg, R.id.clear_all_message, R.id.rl_chat_migrate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clear_all_message /* 2131362388 */:
                is3.b bVar = new is3.b(this);
                bVar.p(ah4.e(R.string.clear_all_history_note));
                bVar.d(new a());
                bVar.o(ah4.e(R.string.common_yes));
                bVar.n(ah4.e(R.string.common_no));
                cs3.h(bVar).show();
                break;
            case R.id.rl_chat_bg /* 2131364248 */:
                pj3.f(this, ChatBackGroudActivity.class);
                break;
            case R.id.rl_chat_migrate /* 2131364253 */:
                pj3.f(this, MigrateChatHistoryActivity.class);
                break;
            case R.id.rl_theme /* 2131364307 */:
                ManagerRDBean.getManager().setShowChatTheme(false);
                ManagerRDBean.saveManager();
                EventBus.getDefault().post(ManagerRDBean.getManager());
                pj3.f(this, ChatThemeSettingActivity.class);
                break;
        }
    }
}
