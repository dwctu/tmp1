package com.wear.main.toy;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.toy.ToyAddVirtualAdapter;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.util.WearUtils;
import dc.pc1;
import dc.sg3;
import java.util.Random;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class AddVirtualToyActivity extends BaseActivity {
    public ToyAddVirtualAdapter a;
    public int b = 0;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_virtual_toy);
        ButterKnife.bind(this);
        this.a = new ToyAddVirtualAdapter(this, Toy.toyConfigBean);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        this.recyclerView.setAdapter(this.a);
    }

    public void s4(ToyConfigInfoBean toyConfigInfoBean) {
        String strU4 = u4();
        String str = toyConfigInfoBean.getSymbol().get(0) + SignatureImpl.INNER_SEP + 300 + SignatureImpl.INNER_SEP + strU4 + ";";
        String strT4 = t4(strU4);
        if (WearUtils.e1(strT4)) {
            sg3.k(WearUtils.x, "Error!");
            return;
        }
        Toy toy = new Toy();
        toy.setName(toyConfigInfoBean.getShowName());
        toy.setId(strT4);
        toy.setAddress(strT4);
        toy.setVersion(300);
        toy.setDeviceType(str);
        toy.setDeviceName(null);
        toy.setStatus(1);
        toy.setBattery(50);
        toy.setIsSelect(1);
        toy.setType(toyConfigInfoBean.getType());
        toy.setToyConfigDataBean();
        toy.setSimpleToy(1);
        pc1.a.u(toy);
        int i = this.b + 1;
        this.b = i;
        if (i == 2) {
            finish();
        }
    }

    public final String t4(String str) {
        if (str.length() != 12) {
            return "";
        }
        String string = "";
        int i = 0;
        while (i <= 5) {
            int i2 = i + 1;
            int i3 = i2 * 2;
            int i4 = i == 0 ? 0 : i3 - 2;
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(str.substring(i4, i3).toUpperCase());
            sb.append(i == 5 ? "" : SignatureImpl.INNER_SEP);
            string = sb.toString();
            i = i2;
        }
        return string;
    }

    public String u4() {
        String[] strArr = {"0", "1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "a", "b", "c", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "e", "f"};
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 12; i++) {
            str = str + strArr[random.nextInt(16)];
        }
        return str;
    }
}
