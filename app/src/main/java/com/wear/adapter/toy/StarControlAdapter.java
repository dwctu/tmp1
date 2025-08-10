package com.wear.adapter.toy;

import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Toy;
import dc.th4;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StarControlAdapter extends BaseAdapter<Toy> {
    public StarControlAdapter(ArrayList<Toy> arrayList, int i) {
        super(arrayList, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, Toy toy, int i) {
        ((TextView) viewHolder.getView(R.id.tv_text)).setText(toy.getSimpleName());
        ImageView imageView = (ImageView) viewHolder.getView(R.id.toy_rssi_img);
        if (toy.isF01Toy()) {
            viewHolder.getView(R.id.toy_battery_img).setVisibility(8);
            return;
        }
        if (!toy.isConnected()) {
            viewHolder.getView(R.id.ll_connected_show).setVisibility(4);
            viewHolder.getView(R.id.tv_status).setVisibility(0);
        } else {
            viewHolder.getView(R.id.ll_connected_show).setVisibility(0);
            viewHolder.getView(R.id.tv_status).setVisibility(4);
            Toy.updateToyBattery((ImageView) viewHolder.getView(R.id.toy_battery_img), toy.getBattery());
            imageView.setImageDrawable(th4.d(this.c, toy.getRssiImg()));
        }
    }
}
