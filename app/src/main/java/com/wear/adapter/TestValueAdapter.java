package com.wear.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.bean.TestValue;
import com.wear.util.WearUtils;
import dc.nd3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TestValueAdapter extends android.widget.BaseAdapter {
    public Activity a;
    public LayoutInflater b;
    public List<TestValue> c;
    public c d;

    public static class ViewHolder {

        @BindView(R.id.action_icon)
        public ImageView actionIcon;

        @BindView(R.id.select_icon)
        public ImageView selectIcon;

        @BindView(R.id.test_key)
        public TextView testKey;

        @BindView(R.id.test_value)
        public TextView testValue;

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
            viewHolder.testKey = (TextView) Utils.findRequiredViewAsType(view, R.id.test_key, "field 'testKey'", TextView.class);
            viewHolder.testValue = (TextView) Utils.findRequiredViewAsType(view, R.id.test_value, "field 'testValue'", TextView.class);
            viewHolder.actionIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.action_icon, "field 'actionIcon'", ImageView.class);
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
            viewHolder.testKey = null;
            viewHolder.testValue = null;
            viewHolder.actionIcon = null;
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ TestValue a;

        public a(TestValue testValue) {
            this.a = testValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = TestValueAdapter.this.d;
            if (cVar != null) {
                cVar.b(this.a);
            }
            TestValueAdapter.this.b(this.a);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ TestValue a;

        public b(TestValue testValue) {
            this.a = testValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = TestValueAdapter.this.d;
            if (cVar != null) {
                cVar.a(this.a);
            }
        }
    }

    public interface c {
        void a(TestValue testValue);

        void b(TestValue testValue);
    }

    public TestValueAdapter(Activity activity, List<TestValue> list, c cVar) {
        this.b = null;
        this.c = new ArrayList();
        this.a = activity;
        this.c = list;
        this.b = LayoutInflater.from(activity);
        this.d = cVar;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TestValue getItem(int i) {
        List<TestValue> list = this.c;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public void b(TestValue testValue) {
        this.c.remove(testValue);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TestValue> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.b.inflate(R.layout.adapter_test_value_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        TestValue item = getItem(i);
        viewHolder.selectIcon.setVisibility(8);
        viewHolder.testKey.setText(WearUtils.e1(item.getKey()) ? "" : nd3.i(item.getKey()));
        viewHolder.testValue.setText("");
        viewHolder.actionIcon.setOnClickListener(new a(item));
        view.setOnClickListener(new b(item));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }
}
