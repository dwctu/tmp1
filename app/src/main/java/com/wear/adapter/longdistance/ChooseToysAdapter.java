package com.wear.adapter.longdistance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.main.longDistance.controllink.MulChooseToysActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChooseToysAdapter extends BaseAdapter {
    public MyApplication a;
    public LayoutInflater b;
    public MulChooseToysActivity c;
    public List<Toy> d = new ArrayList();

    public static class ViewHolder {

        @BindView(R.id.select_icon)
        public ImageView selectIcon;

        @BindView(R.id.toy_defind_name)
        public TextView toyDefindName;

        @BindView(R.id.toy_name)
        public TextView toyName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.selectIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_icon, "field 'selectIcon'", ImageView.class);
            viewHolder.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_name, "field 'toyName'", TextView.class);
            viewHolder.toyDefindName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_defind_name, "field 'toyDefindName'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.selectIcon = null;
            viewHolder.toyName = null;
            viewHolder.toyDefindName = null;
        }
    }

    public ChooseToysAdapter(MulChooseToysActivity mulChooseToysActivity) {
        this.b = null;
        this.a = mulChooseToysActivity.a;
        this.c = mulChooseToysActivity;
        this.b = LayoutInflater.from(mulChooseToysActivity);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Toy getItem(int i) {
        return this.d.get(i);
    }

    public void b() {
        this.d = this.a.G().P();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        String str;
        if (view == null) {
            view = this.b.inflate(R.layout.adapter_choose_toys, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Toy item = getItem(i);
        if (item == null || !Toy.ICON_MAP.containsKey(item.getType())) {
            b();
            notifyDataSetChanged();
        } else {
            viewHolder.toyName.setText(item.getSimpleName());
            if (WearUtils.e1(item.getDefineRename())) {
                str = "";
            } else {
                str = " (" + item.getDefineRename() + ")";
            }
            if (WearUtils.e1(str)) {
                viewHolder.toyDefindName.setVisibility(8);
            } else {
                viewHolder.toyDefindName.setVisibility(0);
                viewHolder.toyDefindName.setText(str);
            }
            if (this.c.b.containsKey(item.getAndUpdateDeviceId())) {
                viewHolder.selectIcon.setImageResource(R.drawable.chat_pattern_item_select);
            } else {
                viewHolder.selectIcon.setImageResource(R.drawable.chat_pattern_item_unselect);
            }
        }
        return view;
    }
}
