package com.wear.main.longDistance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.df3;
import dc.hu3;
import dc.kn3;
import dc.ku1;
import dc.mu3;
import dc.n82;
import dc.nd3;
import dc.pj3;
import dc.sg3;
import dc.sl2;
import dc.to2;
import dc.ue3;
import dc.ye3;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* loaded from: classes3.dex */
public class AddFriendActivity extends BaseActivity implements View.OnClickListener, to2 {
    public sl2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public TextWatcher b = new a();
    public String c = "";

    @BindView(R.id.long_add_email)
    public EditText longAddEmail;

    @BindView(R.id.tv_invite_link)
    public TextView mTvInviteLink;

    @BindView(R.id.name_content_delete)
    public ImageView nameContentDelete;

    @BindView(R.id.tv_join_discord)
    public TextView tvJoinDiscord;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WearUtils.e1(AddFriendActivity.this.longAddEmail.getText().toString())) {
                AddFriendActivity.this.nameContentDelete.setVisibility(8);
            } else {
                AddFriendActivity.this.nameContentDelete.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6 || (keyEvent != null && keyEvent.getAction() == 1)) {
                String strTrim = textView.getText().toString().trim();
                if (WearUtils.e1(strTrim)) {
                    sg3.i(AddFriendActivity.this, R.string.user_add_email_empty);
                } else {
                    AddFriendActivity.this.u4(strTrim);
                }
            }
            return true;
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            String strTrim = AddFriendActivity.this.longAddEmail.getText().toString().trim();
            if (WearUtils.e1(strTrim)) {
                sg3.i(AddFriendActivity.this, R.string.user_add_email_empty);
            } else {
                AddFriendActivity.this.u4(strTrim);
            }
        }
    }

    public class d extends ClickableSpan {
        public d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            ye3.i("add people", "add_people_discord_server_link_click", "click", "add_people_discord_server_link", "link");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://discord.gg/lovense"));
            AddFriendActivity.this.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AddFriendActivity addFriendActivity = AddFriendActivity.this;
            ue3.a(addFriendActivity.longAddEmail, addFriendActivity);
        }
    }

    public class f implements kn3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ User b;

        public class a extends HashMap<String, String> {
            public a() {
                String str;
                if (WearUtils.y.y() == null) {
                    str = "0";
                } else {
                    str = "" + WearUtils.y.y().size();
                }
                put("count", str);
            }
        }

        public class b implements n82.d {

            public class a implements Runnable {
                public final /* synthetic */ boolean a;

                public a(boolean z) {
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.a) {
                        UserSetting userSettingZ = WearUtils.y.z(f.this.b.getId());
                        if (userSettingZ.isFriendsRequestClick()) {
                            mu3.c++;
                            userSettingZ.setFriendsRequestClick(false);
                            DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                            df3.e().a(f.this.b.getId());
                        }
                    }
                }
            }

            public b() {
            }

            @Override // dc.n82.d
            public void a(boolean z) {
                AddFriendActivity.this.runOnUiThread(new a(z));
            }
        }

        public f(String str, User user) {
            this.a = str;
            this.b = user;
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            WearUtils.x.q("longDistance_unblock_friend", new a());
            WearUtils.x.i.y(this.a, new b());
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public class a implements kn3.d {

            /* renamed from: com.wear.main.longDistance.AddFriendActivity$g$a$a, reason: collision with other inner class name */
            public class C0101a extends HashMap<String, String> {
                public C0101a() {
                    String str;
                    if (WearUtils.y.y() == null) {
                        str = "0";
                    } else {
                        str = "" + WearUtils.y.y().size();
                    }
                    put("count", str);
                }
            }

            public class b implements n82.d {

                /* renamed from: com.wear.main.longDistance.AddFriendActivity$g$a$b$a, reason: collision with other inner class name */
                public class RunnableC0102a implements Runnable {
                    public final /* synthetic */ boolean a;

                    public RunnableC0102a(boolean z) {
                        this.a = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (this.a) {
                            g gVar = g.this;
                            AddFriendActivity.this.w4(gVar.b);
                        }
                    }
                }

                public b() {
                }

                @Override // dc.n82.d
                public void a(boolean z) {
                    AddFriendActivity.this.runOnUiThread(new RunnableC0102a(z));
                }
            }

            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                WearUtils.x.q("longDistance_unblock_friend", new C0101a());
                WearUtils.x.i.y(g.this.a, new b());
            }
        }

        public g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            kn3 kn3Var = new kn3((Context) AddFriendActivity.this, String.format(ah4.e(R.string.add_blocke_friends_fail), AddFriendActivity.this.longAddEmail.getText().toString().trim()), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), true, (kn3.d) new a());
            kn3Var.show();
            kn3Var.p();
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.n(this);
        this.mPresenter = this.a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.name_content_delete) {
            this.longAddEmail.setText("");
            this.nameContentDelete.setVisibility(8);
        } else {
            if (id != R.id.tv_invite_link) {
                return;
            }
            pj3.f(this, InviteLinkActivity.class);
            ku1.f("Add People", "add_people_invite_link_click", "add_people_invite_link", null, null, null);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_add_friend);
        ButterKnife.bind(this);
        ye3.c("add people", "into page", null);
        ye3.i("add people", "add_people_page_exposure", "exposure", "add_people_page", "");
        this.nameContentDelete.setVisibility(8);
        this.longAddEmail.addTextChangedListener(this.b);
        this.longAddEmail.setOnEditorActionListener(new b());
        this.nameContentDelete.setOnClickListener(this);
        this.mTvInviteLink.setOnClickListener(this);
        this.actionbar.setYesAction(R.string.dfu_success_finish, new c());
        EventBus.getDefault().register(this);
        v4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ue3.a(this.longAddEmail, this);
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new e(), 100L);
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        if (WearUtils.e1(str)) {
            sg3.i(this, R.string.common_netError);
        } else {
            sg3.k(this, str);
        }
        String strR = nd3.r(this.longAddEmail.getText().toString().trim());
        if (strR == null) {
            strR = "";
        }
        ye3.d("D0002", strR);
    }

    public final void u4(String str) {
        this.c = str;
        Account accountU = WearUtils.y.u();
        if (accountU == null) {
            sg3.i(this, R.string.common_login_first);
            return;
        }
        if (str.equals(accountU.getId()) || str.toLowerCase().equals(WearUtils.H0(accountU.getUserName()))) {
            sg3.i(this, R.string.user_add_addSelf);
            return;
        }
        String strE2 = WearUtils.E2(str);
        if (!WearUtils.O1(strE2)) {
            sg3.i(this, R.string.add_friend_user_check);
            return;
        }
        User userW = WearUtils.y.w(strE2);
        if (userW == null || !userW.addSendToMe()) {
            ue3.a(this.longAddEmail, this);
            HashMap map = new HashMap();
            map.put("email", nd3.w(strE2));
            map.put("app", "wearables");
            map.put(RosterVer.ELEMENT, WearUtils.q);
            this.a.h(false, map);
            return;
        }
        String strI0 = WearUtils.i0(userW.getId());
        if (!this.application.i.p(strI0)) {
            sg3.k(this, String.format(ah4.e(R.string.add_friend_user_requested), userW.getUserName()));
            return;
        }
        kn3 kn3Var = new kn3((Context) this, String.format(ah4.e(R.string.add_blocke_friends_fail_1), strE2), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), true, (kn3.d) new f(strI0, userW));
        kn3Var.show();
        kn3Var.p();
    }

    public final void v4() {
        String strE = ah4.e(R.string.add_people_notice5);
        String strE2 = ah4.e(R.string.lovense_discord_server);
        String str = String.format(strE, strE2);
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.indexOf(strE2);
        if (iIndexOf != -1) {
            int length = strE2.length() + iIndexOf;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FF2D89"));
            d dVar = new d();
            spannableString.setSpan(foregroundColorSpan, iIndexOf, length, 33);
            spannableString.setSpan(dVar, iIndexOf, length, 33);
        }
        this.tvJoinDiscord.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvJoinDiscord.setHighlightColor(0);
        this.tvJoinDiscord.setText(spannableString);
    }

    public final void w4(String str) {
        User userW = WearUtils.y.w(str);
        if (userW == null || !userW.isFriend()) {
            if (!hu3.k(str)) {
                sg3.i(this, R.string.common_serverError);
                return;
            }
            sg3.i(this, R.string.user_add_success);
            User userV = WearUtils.y.v(str);
            if (userV == null) {
                userV = new User(str);
                try {
                    VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(WearUtils.i0(str));
                    if (vCardLoadVCard != null && !WearUtils.e1(vCardLoadVCard.getNickName())) {
                        userV.setName(vCardLoadVCard.getNickName());
                    }
                    if (!WearUtils.i1(vCardLoadVCard.getAvatar())) {
                        WearUtils.s2(new String(vCardLoadVCard.getAvatar(), "ISO-8859-1"), userV);
                    }
                    userV.setMoodMessage(vCardLoadVCard.getField("MOODMESSAGE"));
                    userV.setAge(vCardLoadVCard.getField("AGE"));
                    userV.setFriendGTMTime(vCardLoadVCard.getField("GMTTIME"));
                    userV.setDeviceType(vCardLoadVCard.getField("DEVICETYPE"));
                    userV.setDeviceAppVersion(vCardLoadVCard.getField("APPVERSION"));
                } catch (Exception unused) {
                }
                userV.resetFriendType(2);
            } else if (userV.haveFriendType(1)) {
                userV.resetFriendType(1);
            } else {
                userV.resetFriendType(2);
            }
            WearUtils.y.b(userV);
            HashMap map = new HashMap();
            map.put("add_channel", 2);
            map.put("jid_be_invited", this.c);
            ye3.d("F0010", WearUtils.A.toJson(map));
            finish();
        }
    }

    @Override // dc.to2
    public void x1(boolean z, BaseResponseBean baseResponseBean) {
        if (!baseResponseBean.isResult() || baseResponseBean.getData() == null) {
            return;
        }
        String string = baseResponseBean.getData().toString();
        Map map = (Map) WearUtils.A.fromJson(nd3.j(string), HashMap.class);
        if (map != null) {
            string = (String) map.get("email");
        }
        String strI0 = WearUtils.i0(string);
        if (WearUtils.x.i.k(strI0)) {
            x4(string, strI0);
            return;
        }
        User userW = WearUtils.y.w(string);
        if (userW == null || !userW.isFriend()) {
            w4(string);
        } else {
            sg3.i(this, R.string.add_friend_user_exist);
        }
    }

    public final void x4(String str, String str2) {
        runOnUiThread(new g(str2, str));
    }
}
