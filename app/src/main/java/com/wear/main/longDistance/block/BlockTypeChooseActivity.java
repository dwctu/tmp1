package com.wear.main.longDistance.block;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.pj3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class BlockTypeChooseActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.actionbar_account)
    public MyActionBar actionbarAccount;

    @BindView(R.id.contacts_friends)
    public LinearLayout contactsFriends;

    @BindView(R.id.rejected_requests)
    public LinearLayout rejectedRequests;

    @BindView(R.id.tv_contacts_friends)
    public TextView tvContactsFriends;

    @BindView(R.id.tv_rejected_requests)
    public TextView tvRejectedRequests;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.contacts_friends) {
            pj3.h(this, BlockContactsActivity.class, "block_list_type", 0);
        } else {
            if (id != R.id.rejected_requests) {
                return;
            }
            pj3.h(this, BlockContactsActivity.class, "block_list_type", 1);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remote_block_contacts_type);
        ButterKnife.bind(this);
        this.contactsFriends.setOnClickListener(this);
        this.rejectedRequests.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (WearUtils.x.i.h()) {
            this.contactsFriends.setEnabled(true);
            this.tvContactsFriends.setTextColor(getResources().getColor(R.color.text_primary_light));
        } else {
            this.contactsFriends.setEnabled(false);
            this.tvContactsFriends.setTextColor(getResources().getColor(R.color.text_third_light));
        }
        if (WearUtils.x.i.i()) {
            this.rejectedRequests.setEnabled(true);
            this.tvRejectedRequests.setTextColor(getResources().getColor(R.color.text_primary_light));
        } else {
            this.rejectedRequests.setEnabled(false);
            this.tvRejectedRequests.setTextColor(getResources().getColor(R.color.text_third_light));
        }
    }
}
