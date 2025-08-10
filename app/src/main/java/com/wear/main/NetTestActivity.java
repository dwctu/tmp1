package com.wear.main;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.broadcom.bt.util.io.IOUtils;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.widget.MyActionBar;
import dc.tf3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.net.InetAddress;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class NetTestActivity extends BaseActivity {
    public String a = "Address:";
    public String b = "Addresses:";

    @BindView(R.id.action_bar)
    public MyActionBar bar;
    public Disposable c;

    @BindView(R.id.tv_dns_address)
    public TextView tvDnsAddress;

    @BindView(R.id.tv_host_address)
    public TextView tvHostAddress;

    @BindView(R.id.tv_ping)
    public TextView tvPing;

    public class a implements Consumer<String[]> {
        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String[] strArr) throws Exception {
            if (strArr != null) {
                for (String str : strArr) {
                    NetTestActivity.t4(NetTestActivity.this, IOUtils.LINE_SEPARATOR_UNIX + str);
                }
                NetTestActivity netTestActivity = NetTestActivity.this;
                netTestActivity.tvHostAddress.setText(netTestActivity.b);
            }
        }
    }

    public class b implements Function<String, String[]> {
        public b(NetTestActivity netTestActivity) {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String[] apply(@NotNull String str) throws Exception {
            String[] strArr = null;
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    strArr = new String[allByName.length];
                    for (int i = 0; i < allByName.length; i++) {
                        strArr[i] = allByName[i].getHostAddress();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return strArr;
        }
    }

    public static /* synthetic */ String t4(NetTestActivity netTestActivity, Object obj) {
        String str = netTestActivity.b + obj;
        netTestActivity.b = str;
        return str;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_net_test);
        ButterKnife.bind(this);
        w4();
        u4();
        v4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.c;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.c.dispose();
    }

    public final void u4() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (Build.VERSION.SDK_INT >= 21) {
            for (Network network : connectivityManager.getAllNetworks()) {
                if (connectivityManager.getNetworkInfo(network).getType() == activeNetworkInfo.getType()) {
                    Iterator<InetAddress> it = connectivityManager.getLinkProperties(network).getDnsServers().iterator();
                    while (it.hasNext()) {
                        this.a += IOUtils.LINE_SEPARATOR_UNIX + it.next().getHostAddress();
                    }
                }
            }
        }
        this.tvDnsAddress.setText(this.a);
    }

    public final void v4() {
        this.c = Observable.just("apps.lovense-api.com").map(new b(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public final void w4() {
        int iC = tf3.c("https://apps.lovense-api.com/");
        this.tvPing.setText("ping:" + iC + "ms");
    }
}
