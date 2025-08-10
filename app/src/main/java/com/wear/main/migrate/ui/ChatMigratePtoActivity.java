package com.wear.main.migrate.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.database.annotations.NotNull;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.dao.DaoUtils;
import dc.ah4;
import dc.cs3;
import dc.kd2;
import dc.pj3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatMigratePtoActivity extends BaseActivity {
    public boolean a;

    @BindView(R.id.ac_migrate_receive_tv_entire)
    public TextView tvEntire;

    @BindView(R.id.ac_migrate_receive_tv_partical)
    public TextView tvPartical;

    public class a implements Observer<Boolean> {
        public a() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@NotNull Boolean bool) {
            ChatMigratePtoActivity.this.u4(bool.booleanValue());
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

    public class b implements ObservableOnSubscribe<Boolean> {
        public b(ChatMigratePtoActivity chatMigratePtoActivity) {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(@NotNull ObservableEmitter<Boolean> observableEmitter) throws Exception {
            try {
                observableEmitter.onNext(Boolean.valueOf(DaoUtils.getCommunMessageDao().findAllHaveMsgs()));
            } catch (Exception e) {
                e.printStackTrace();
                observableEmitter.onNext(Boolean.FALSE);
            }
        }
    }

    @OnClick({R.id.ac_migrate_receive_tv_entire, R.id.ac_migrate_receive_tv_partical})
    public void onClick(View view) {
        if (!this.a) {
            v4();
        }
        switch (view.getId()) {
            case R.id.ac_migrate_receive_tv_entire /* 2131361887 */:
                pj3.l(this, ChatMigrateQrcodeActivity.class);
                break;
            case R.id.ac_migrate_receive_tv_partical /* 2131361888 */:
                pj3.f(this, ChatMigrateSelectActivity.class);
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_migrate_pto);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        t4();
        kd2.C().s(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        kd2.C().J(this);
    }

    public final void t4() {
        showDialog();
        Observable.create(new b(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public final void u4(boolean z) {
        dissDialog();
        this.a = z;
        this.tvEntire.setEnabled(true);
        this.tvPartical.setEnabled(true);
    }

    public final void v4() {
        cs3.j(this, ah4.e(R.string.no_chat_history_found)).show();
    }
}
