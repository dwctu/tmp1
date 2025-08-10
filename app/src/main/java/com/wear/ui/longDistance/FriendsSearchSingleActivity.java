package com.wear.ui.longDistance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.ui.longDistance.FriendsSearchSingleActivity;
import com.wear.util.WearUtils;
import dc.kg3;
import dc.nv1;
import dc.th4;
import dc.ue3;

/* loaded from: classes3.dex */
public class FriendsSearchSingleActivity extends BaseActivity {

    @BindView(R.id.et_search)
    public EditText etSearch;

    @BindView(R.id.fragment_container)
    public FragmentContainerView fragmentContainerView;

    @BindView(R.id.iv_clear)
    public ImageView ivClear;

    public class a extends nv1 {
        public a() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = TextUtils.isEmpty(editable) ? 8 : 0;
            FriendsSearchSingleActivity.this.ivClear.setVisibility(i);
            FriendsSearchSingleActivity.this.fragmentContainerView.setVisibility(i);
            Fragment fragment = FriendsSearchSingleActivity.this.fragmentContainerView.getFragment();
            if (fragment instanceof AllFriendsFragment) {
                ((AllFriendsFragment) fragment).a0(editable.toString(), 999);
            }
        }
    }

    public static /* synthetic */ boolean s4(TextView textView, int i, KeyEvent keyEvent) {
        return keyEvent == null || keyEvent.getKeyCode() == 66;
    }

    public static void t4(Context context, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) FriendsSearchSingleActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent, bundle);
    }

    @OnClick({R.id.back, R.id.iv_clear})
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.back) {
            if (id != R.id.iv_clear) {
                return;
            }
            this.etSearch.setText("");
        } else {
            this.etSearch.setText("");
            ue3.a(this.etSearch, this);
            finishAfterTransition();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(150L);
        getWindow().setSharedElementEnterTransition(changeBounds);
        super.onCreate(bundle);
        setContentView(R.layout.activity_friends_request_single);
        getWindow().getDecorView().getRootView().setBackgroundColor(th4.b(this, R.color.bg));
        ButterKnife.bind(this);
        this.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: dc.e63
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return FriendsSearchSingleActivity.s4(textView, i, keyEvent);
            }
        });
        this.etSearch.addTextChangedListener(new a());
        this.etSearch.requestFocus();
        ue3.d(this.etSearch, this);
    }

    @Override // com.wear.BaseActivity
    public boolean skipBaseSettingBarColor() {
        kg3.i(this, !WearUtils.Y0());
        kg3.g(this, th4.b(this, R.color.lvs_ui_standard_systemBackground));
        return true;
    }
}
