package com.wear.main.migrate.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.database.annotations.NotNull;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.MigrateChatSelectAdapter;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.cg3;
import dc.ch3;
import dc.pj3;
import dc.t12;
import dc.vd3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatMigrateSelectActivity extends BaseActivity implements MigrateChatSelectAdapter.a {
    public MigrateChatSelectAdapter a;
    public ArrayList<IPeopleInfo> b;
    public ArrayList<IPeopleInfo> c;

    @BindView(R.id.ac_migrate_select_iv_all)
    public ImageView ivAll;

    @BindView(R.id.actionbar)
    public MyActionBar myActionBar;

    @BindView(R.id.ac_migrate_select_rcv)
    public RecyclerView recyclerViewUsers;

    @BindView(R.id.ac_migrate_select_tv_next)
    public TextView tvNext;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatMigrateSelectActivity.this.finish();
        }
    }

    public class b implements Observer<List<IPeopleInfo>> {
        public b() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@NotNull List<IPeopleInfo> list) {
            ChatMigrateSelectActivity.this.c.addAll(list);
            ChatMigrateSelectActivity.this.a.B(ChatMigrateSelectActivity.this.c);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(@NotNull Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(@NotNull Disposable disposable) {
        }
    }

    public class c implements ObservableOnSubscribe<List<IPeopleInfo>> {
        public c() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(@NotNull ObservableEmitter<List<IPeopleInfo>> observableEmitter) throws Exception {
            observableEmitter.onNext(ChatMigrateSelectActivity.this.u4());
        }
    }

    @Override // com.wear.adapter.MigrateChatSelectAdapter.a
    public boolean i(IPeopleInfo iPeopleInfo, boolean z) {
        if (z) {
            return this.b.contains(iPeopleInfo);
        }
        if (this.b.contains(iPeopleInfo)) {
            if (this.b.size() == this.c.size()) {
                x4(false);
            }
            this.b.remove(iPeopleInfo);
            w4();
            return false;
        }
        this.b.add(iPeopleInfo);
        if (this.b.size() == this.c.size()) {
            x4(true);
        }
        w4();
        return true;
    }

    @OnClick({R.id.ac_migrate_select_iv_all, R.id.ac_migrate_select_tv_all, R.id.ac_migrate_select_tv_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_migrate_select_iv_all /* 2131361890 */:
            case R.id.ac_migrate_select_tv_all /* 2131361892 */:
                if (this.b.size() == this.c.size()) {
                    this.b.clear();
                    x4(false);
                } else {
                    this.b.clear();
                    this.b.addAll(this.c);
                    x4(true);
                }
                this.a.B(this.c);
                this.a.notifyDataSetChanged();
                w4();
                break;
            case R.id.ac_migrate_select_tv_next /* 2131361893 */:
                if (this.b.size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("listSelected", this.b);
                    pj3.m(this, ChatMigrateQrcodeActivity.class, bundle);
                    finish();
                    break;
                }
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_migrate_select);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        v4();
        this.myActionBar.setImageBackAction(Integer.valueOf(R.drawable.nav_migrate_close), new a(), 8);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public final List<IPeopleInfo> u4() {
        ArrayList arrayList = new ArrayList();
        List<IPeopleInfo> list = ch3.i;
        if (list != null && list.size() > 0) {
            ArrayList<IPeopleInfo> arrayList2 = new ArrayList();
            arrayList2.addAll(ch3.i);
            vd3.b(arrayList2, new t12());
            for (IPeopleInfo iPeopleInfo : arrayList2) {
                if (DaoUtils.getCommunMessageDao().findHaveMsgs(iPeopleInfo.isGroup() ? WearUtils.k0(iPeopleInfo.getId()) : WearUtils.i0(iPeopleInfo.getId()))) {
                    arrayList.add(iPeopleInfo);
                }
            }
        }
        return arrayList;
    }

    public final void v4() {
        this.b = new ArrayList<>();
        ArrayList<IPeopleInfo> arrayList = new ArrayList<>();
        this.c = arrayList;
        MigrateChatSelectAdapter migrateChatSelectAdapter = new MigrateChatSelectAdapter(arrayList, R.layout.item_migrate_select);
        this.a = migrateChatSelectAdapter;
        migrateChatSelectAdapter.C(this);
        cg3.f(this.recyclerViewUsers, this.a);
        Observable.create(new c()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
    }

    public void w4() {
        this.tvNext.setEnabled(this.b.size() > 0);
    }

    public void x4(boolean z) {
        this.ivAll.setImageResource(z ? R.drawable.chat_pattern_item_select : R.drawable.chat_pattern_item_unselect);
    }
}
