package com.wear.main.longDistance.controllink;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.ChooseToysAdapter;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.sg3;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MulChooseToysActivity extends BaseActivity {
    public MyApplication a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public HashMap<String, String> b = new HashMap<>();
    public ChooseToysAdapter c;

    @BindView(R.id.toys_list)
    public ListView toysList;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            Iterator<String> it = MulChooseToysActivity.this.b.keySet().iterator();
            String strSubstring = "";
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next() + ",";
            }
            if (strSubstring.endsWith(",")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            Intent intent = new Intent();
            intent.putExtra("choose_toys_keys_split", strSubstring);
            MulChooseToysActivity.this.setResult(-1, intent);
            MulChooseToysActivity.this.finish();
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            MulChooseToysActivity.this.finish();
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            String andUpdateDeviceId = MulChooseToysActivity.this.c.getItem(i).getAndUpdateDeviceId();
            if (MulChooseToysActivity.this.b.containsKey(andUpdateDeviceId)) {
                MulChooseToysActivity.this.b.remove(andUpdateDeviceId);
            } else if (MulChooseToysActivity.this.b.size() < 2) {
                MulChooseToysActivity.this.b.put(andUpdateDeviceId, andUpdateDeviceId);
            } else {
                sg3.l(ah4.e(R.string.toast_too_many_toys));
            }
            MulChooseToysActivity.this.c.notifyDataSetChanged();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_choose_toys);
        ButterKnife.bind(this);
        this.a = (MyApplication) getApplication();
        this.actionbar.setYesAction(R.string.common_done, new a());
        this.actionbar.setBackAction(R.string.common_cancel, new b());
        this.b.clear();
        String stringExtra = getIntent().getStringExtra("choose_toys_keys_split");
        if (!WearUtils.e1(stringExtra)) {
            for (String str : stringExtra.split(",")) {
                if (this.b.size() == 2) {
                    break;
                }
                Toy toyR = WearUtils.x.G().R(str);
                if (toyR != null && toyR.isConnected()) {
                    this.b.put(str, str);
                }
            }
        }
        ChooseToysAdapter chooseToysAdapter = new ChooseToysAdapter(this);
        this.c = chooseToysAdapter;
        this.toysList.setAdapter((ListAdapter) chooseToysAdapter);
        this.toysList.setOnItemClickListener(new c());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.b();
        this.c.notifyDataSetChanged();
    }
}
