package com.wear.main.account;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.setting.UserGuidesSecondAdapter;
import com.wear.bean.UserGuidesMenuBean;
import com.wear.network.presenter.bean.UserGuidesBean;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import com.wear.widget.SpaceItemDecoration;
import dc.ah4;
import dc.ce3;
import dc.pn2;
import dc.qp2;
import dc.sg3;
import dc.th4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class UserGuidesActivity extends BaseActivity implements qp2 {
    public ProgressDialog a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public UserGuidesSecondAdapter b;
    public pn2 c;
    public List<UserGuidesBean.DataBean.RemoteGuideBean> d = new ArrayList();
    public List<UserGuidesMenuBean> e = new ArrayList();

    @BindView(R.id.first_menu_one_data)
    public TextView firstMenuOneData;

    @BindView(R.id.first_menu_one_ll)
    public LinearLayout firstMenuOneLl;

    @BindView(R.id.first_menu_recycler_view)
    public RecyclerView firstMenuRecyclerView;

    @BindView(R.id.first_menu_two_ll)
    public LinearLayout firstMenuTwoLl;

    @BindView(R.id.first_menu_two_one)
    public TextView firstMenuTwoOne;

    @BindView(R.id.first_menu_two_two)
    public TextView firstMenuTwoTwo;

    @BindView(R.id.second_menu_recycler_view)
    public RecyclerView secondMenuRecyclerView;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserGuidesActivity.this.firstMenuTwoOne.setBackgroundResource(R.drawable.user_guides_menu_red);
            UserGuidesActivity userGuidesActivity = UserGuidesActivity.this;
            userGuidesActivity.firstMenuTwoOne.setTextColor(th4.b(userGuidesActivity, R.color.white));
            UserGuidesActivity.this.firstMenuTwoTwo.setBackgroundResource(R.drawable.user_guides_menu_white_new);
            UserGuidesActivity userGuidesActivity2 = UserGuidesActivity.this;
            userGuidesActivity2.firstMenuTwoTwo.setTextColor(th4.b(userGuidesActivity2, R.color.text_color_85));
            if (UserGuidesActivity.this.d.size() > 0) {
                UserGuidesActivity.this.e.clear();
                List<UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean> menu1 = ((UserGuidesBean.DataBean.RemoteGuideBean) UserGuidesActivity.this.d.get(0)).getMenu1();
                for (int i = 0; i < menu1.size(); i++) {
                    UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean menu1Bean = menu1.get(i);
                    if (!WearUtils.e1(menu1Bean.getMenu2Key())) {
                        UserGuidesActivity.this.e.add(new UserGuidesMenuBean(menu1Bean.getMenu2Key(), null, 2));
                    }
                    for (UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean.Menu2Bean menu2Bean : menu1Bean.getMenu2()) {
                        UserGuidesActivity.this.e.add(new UserGuidesMenuBean(menu2Bean.getTitle(), menu2Bean.getCLink(), 3));
                    }
                }
                UserGuidesActivity.this.b.o(1);
                UserGuidesActivity.this.b.notifyDataSetChanged();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserGuidesActivity.this.firstMenuTwoTwo.setBackgroundResource(R.drawable.user_guides_menu_red);
            UserGuidesActivity userGuidesActivity = UserGuidesActivity.this;
            userGuidesActivity.firstMenuTwoTwo.setTextColor(th4.b(userGuidesActivity, R.color.white));
            UserGuidesActivity.this.firstMenuTwoOne.setBackgroundResource(R.drawable.user_guides_menu_white_new);
            UserGuidesActivity userGuidesActivity2 = UserGuidesActivity.this;
            userGuidesActivity2.firstMenuTwoOne.setTextColor(th4.b(userGuidesActivity2, R.color.text_color_85));
            if (UserGuidesActivity.this.d.size() <= 1 || ((UserGuidesBean.DataBean.RemoteGuideBean) UserGuidesActivity.this.d.get(1)).getMenu1() == null) {
                return;
            }
            UserGuidesActivity.this.e.clear();
            List<UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean> menu1 = ((UserGuidesBean.DataBean.RemoteGuideBean) UserGuidesActivity.this.d.get(1)).getMenu1();
            for (int i = 0; i < menu1.size(); i++) {
                UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean menu1Bean = menu1.get(i);
                if (!WearUtils.e1(menu1Bean.getMenu2Key())) {
                    UserGuidesActivity.this.e.add(new UserGuidesMenuBean(menu1Bean.getMenu2Key(), null, 2));
                }
                for (UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean.Menu2Bean menu2Bean : menu1Bean.getMenu2()) {
                    UserGuidesActivity.this.e.add(new UserGuidesMenuBean(menu2Bean.getTitle(), menu2Bean.getCLink(), 3));
                }
            }
            UserGuidesActivity.this.b.o(2);
            UserGuidesActivity.this.b.notifyDataSetChanged();
        }
    }

    @Override // dc.qp2
    public void X0(boolean z, UserGuidesBean userGuidesBean) {
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        List<UserGuidesBean.DataBean.RemoteGuideBean> remoteGuide = userGuidesBean.getData().getRemoteGuide();
        if (remoteGuide == null || remoteGuide.size() <= 0) {
            return;
        }
        for (int i = 0; i < remoteGuide.size(); i++) {
            if (i == 0) {
                remoteGuide.get(i).setSelect(true);
            } else {
                remoteGuide.get(i).setSelect(false);
            }
        }
        this.d.clear();
        this.d.addAll(remoteGuide);
        if (this.d.size() == 1) {
            this.firstMenuRecyclerView.setVisibility(8);
            this.firstMenuTwoLl.setVisibility(8);
            this.firstMenuOneData.setVisibility(0);
            this.firstMenuOneData.setText(remoteGuide.get(0).getMenu1Key());
        } else if (this.d.size() == 2) {
            this.firstMenuRecyclerView.setVisibility(8);
            this.firstMenuTwoLl.setVisibility(0);
            this.firstMenuOneData.setVisibility(8);
            this.firstMenuTwoOne.setText(remoteGuide.get(0).getMenu1Key());
            this.firstMenuTwoTwo.setText(remoteGuide.get(1).getMenu1Key());
        } else {
            this.firstMenuRecyclerView.setVisibility(0);
            this.firstMenuTwoLl.setVisibility(8);
            this.firstMenuOneData.setVisibility(8);
        }
        this.e.clear();
        List<UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean> menu1 = remoteGuide.get(0).getMenu1();
        for (int i2 = 0; i2 < menu1.size(); i2++) {
            UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean menu1Bean = menu1.get(i2);
            if (!WearUtils.e1(menu1Bean.getMenu2Key())) {
                this.e.add(new UserGuidesMenuBean(menu1Bean.getMenu2Key(), null, 2));
            }
            for (UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean.Menu2Bean menu2Bean : menu1Bean.getMenu2()) {
                this.e.add(new UserGuidesMenuBean(menu2Bean.getTitle(), menu2Bean.getCLink(), 3));
            }
        }
        this.b.o(0);
        this.b.notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.r(this);
        this.mPresenter = this.c;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_user_guides);
        ButterKnife.bind(this);
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(this);
        recyclerViewNoBugLinearLayoutManager.setOrientation(0);
        this.firstMenuRecyclerView.setLayoutManager(recyclerViewNoBugLinearLayoutManager);
        this.b = new UserGuidesSecondAdapter(this.e, this);
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager2 = new RecyclerViewNoBugLinearLayoutManager(this);
        recyclerViewNoBugLinearLayoutManager2.setOrientation(1);
        this.secondMenuRecyclerView.setLayoutManager(recyclerViewNoBugLinearLayoutManager2);
        this.secondMenuRecyclerView.addItemDecoration(new SpaceItemDecoration(ce3.a(this, 20.0f)));
        this.secondMenuRecyclerView.setAdapter(this.b);
        this.firstMenuTwoOne.setOnClickListener(new a());
        this.firstMenuTwoTwo.setOnClickListener(new b());
        w4();
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        sg3.k(this, str);
    }

    public void v4(int i) {
        if (i < this.d.size() && this.d.size() > 0) {
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                if (i2 == i) {
                    this.d.get(i2).setSelect(true);
                } else {
                    this.d.get(i2).setSelect(false);
                }
            }
            this.e.clear();
            List<UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean> menu1 = this.d.get(i).getMenu1();
            for (int i3 = 0; i3 < menu1.size(); i3++) {
                UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean menu1Bean = menu1.get(i3);
                if (!WearUtils.e1(menu1Bean.getMenu2Key())) {
                    this.e.add(new UserGuidesMenuBean(menu1Bean.getMenu2Key(), null, 2));
                }
                for (UserGuidesBean.DataBean.RemoteGuideBean.Menu1Bean.Menu2Bean menu2Bean : menu1Bean.getMenu2()) {
                    this.e.add(new UserGuidesMenuBean(menu2Bean.getTitle(), menu2Bean.getCLink(), 3));
                }
            }
            this.b.o(0);
            this.b.notifyDataSetChanged();
        }
    }

    public final void w4() {
        this.a = ProgressDialog.show(this, "", ah4.e(R.string.common_submit));
        String language = WearUtils.x.getResources().getConfiguration().locale.getLanguage();
        HashMap map = new HashMap();
        map.put("lan", language);
        this.c.h(false, map);
    }
}
