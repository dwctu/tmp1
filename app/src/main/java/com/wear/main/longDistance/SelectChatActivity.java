package com.wear.main.longDistance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SearchButton;
import dc.ah4;
import dc.ch3;
import dc.rl1;
import dc.t12;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class SelectChatActivity extends BaseActivity {
    public List<IPeopleInfo> a;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;
    public rl1 b;
    public HashMap<String, IPeopleInfo> c;

    @BindView(R.id.chat_list)
    public ListView chat_list;

    @BindView(R.id.sb_search)
    public SearchButton sb_search;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("userJids", new ArrayList<>(SelectChatActivity.this.c.keySet()));
            SelectChatActivity.this.setResult(-1, intent);
            SelectChatActivity.this.finish();
        }
    }

    public class b implements SearchButton.e {
        public b() {
        }

        @Override // com.wear.widget.SearchButton.e
        public void p3(String str) {
            SelectChatActivity.this.b.b(str);
            SelectChatActivity.this.w4(str);
            SelectChatActivity.this.b.notifyDataSetChanged();
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            IPeopleInfo item = SelectChatActivity.this.b.getItem(i);
            if (SelectChatActivity.this.c.containsKey(item.getUserJid())) {
                SelectChatActivity.this.c.remove(item.getUserJid());
            } else {
                SelectChatActivity.this.c.put(item.getUserJid(), item);
            }
            SelectChatActivity.this.v4();
            SelectChatActivity.this.b.notifyDataSetChanged();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_forward_message);
        ButterKnife.bind(this);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionBar = myActionBar;
        myActionBar.setTitle(ah4.e(R.string.activity_forward));
        this.actionBar.setYesAction(R.string.common_send, new a());
        this.actionBar.getYesBtn().setEnabled(false);
        this.actionBar.getYesBtn().setAlpha(0.5f);
        this.sb_search.setListener(new b());
        this.a = new ArrayList();
        w4("");
        this.c = new HashMap<>();
        rl1 rl1Var = new rl1(this, this.c, this.a);
        this.b = rl1Var;
        this.chat_list.setAdapter((ListAdapter) rl1Var);
        this.chat_list.setOnItemClickListener(new c());
    }

    public final void v4() {
        if (this.c.entrySet().size() == 0) {
            this.actionBar.getYesBtn().setEnabled(false);
            this.actionBar.getYesBtn().setAlpha(0.5f);
        } else {
            this.actionBar.getYesBtn().setEnabled(true);
            this.actionBar.getYesBtn().setAlpha(1.0f);
        }
    }

    public final void w4(String str) {
        this.a.clear();
        ch3 ch3Var = WearUtils.y;
        for (IPeopleInfo iPeopleInfo : ch3.i) {
            if (!iPeopleInfo.isExit() && (TextUtils.isEmpty(str) || iPeopleInfo.showBykey(str))) {
                if (iPeopleInfo.isShowInFriendsList() && !iPeopleInfo.isDateIng()) {
                    this.a.add(iPeopleInfo);
                }
            }
        }
        Collections.sort(this.a, new t12());
    }
}
