package com.wear.adapter.closeRange;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.bean.AlarmListItems;
import com.wear.main.closeRange.alarm.AlarmListActivity;
import com.wear.main.longDistance.alarm.SetAlarmActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.be3;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class AlarmListAdapter extends RecyclerView.Adapter {
    public LayoutInflater a;
    public AlarmListActivity b;
    public d c;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String a;

        @BindView(R.id.alarm_activat_swith)
        public SwitchView alarmActivatSwith;

        @BindView(R.id.alarm_arrow)
        public ImageView alarmArrow;

        @BindView(R.id.alarm_edit_action)
        public ImageView alarmEditAction;

        @BindView(R.id.alart_frequency)
        public TextView alartFrequency;

        @BindView(R.id.alart_time)
        public TextView alartTime;

        @BindView(R.id.ll_root)
        public LinearLayout llRoot;

        @BindView(R.id.tv_alarm_name)
        public TextView tvAlarmName;

        @BindView(R.id.tv_next_time)
        public TextView tv_next_time;

        @BindView(R.id.v_bg)
        public View vBg;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.alarmEditAction = (ImageView) Utils.findRequiredViewAsType(view, R.id.alarm_edit_action, "field 'alarmEditAction'", ImageView.class);
            viewHolder.alartTime = (TextView) Utils.findRequiredViewAsType(view, R.id.alart_time, "field 'alartTime'", TextView.class);
            viewHolder.alartFrequency = (TextView) Utils.findRequiredViewAsType(view, R.id.alart_frequency, "field 'alartFrequency'", TextView.class);
            viewHolder.alarmActivatSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.alarm_activat_swith, "field 'alarmActivatSwith'", SwitchView.class);
            viewHolder.alarmArrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.alarm_arrow, "field 'alarmArrow'", ImageView.class);
            viewHolder.tvAlarmName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_name, "field 'tvAlarmName'", TextView.class);
            viewHolder.vBg = Utils.findRequiredView(view, R.id.v_bg, "field 'vBg'");
            viewHolder.tv_next_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_next_time, "field 'tv_next_time'", TextView.class);
            viewHolder.llRoot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root, "field 'llRoot'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.alarmEditAction = null;
            viewHolder.alartTime = null;
            viewHolder.alartFrequency = null;
            viewHolder.alarmActivatSwith = null;
            viewHolder.alarmArrow = null;
            viewHolder.tvAlarmName = null;
            viewHolder.vBg = null;
            viewHolder.tv_next_time = null;
            viewHolder.llRoot = null;
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ AlarmListItems a;

        public a(AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = this.a.getIsSelected() <= 0;
            if (AlarmListAdapter.this.c != null) {
                AlarmListAdapter.this.c.a(z, this.a);
            }
        }
    }

    public class b implements View.OnLongClickListener {
        public final /* synthetic */ AlarmListItems a;

        public b(AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AlarmListAdapter.this.b.F4(this.a);
            return false;
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlarmListAdapter.this.b.D4(this.a);
        }
    }

    public interface d {
        void a(boolean z, AlarmListItems alarmListItems);
    }

    public AlarmListAdapter(AlarmListActivity alarmListActivity, MyApplication myApplication) {
        this.a = null;
        this.a = LayoutInflater.from(alarmListActivity);
        this.b = alarmListActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(AlarmListItems alarmListItems, View view) {
        this.b.F4(alarmListItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<AlarmListItems> list = this.b.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        final AlarmListItems alarmListItems = this.b.e.get(i);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.a = alarmListItems.getId();
        if (this.b.f) {
            viewHolder2.alarmEditAction.setVisibility(0);
            viewHolder2.alarmActivatSwith.setVisibility(8);
        } else {
            viewHolder2.alarmEditAction.setVisibility(8);
            viewHolder2.alarmActivatSwith.setVisibility(0);
        }
        viewHolder2.alarmEditAction.setOnClickListener(new View.OnClickListener() { // from class: dc.xj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.o(alarmListItems, view);
            }
        });
        String strK4 = SetAlarmActivity.K4(alarmListItems.getFrequency(), alarmListItems.getDates());
        if (alarmListItems.getSnoozeCount() == 0) {
            str = strK4 + "  |  " + ah4.e(R.string.str_alarm_never_snooze);
        } else {
            str = strK4 + "   |  " + ah4.e(R.string.str_alarm_snooze) + SignatureImpl.INNER_SEP + alarmListItems.getSnoozeCount();
        }
        viewHolder2.tvAlarmName.setText(alarmListItems.getAlarmTitle());
        viewHolder2.alartFrequency.setText(str);
        if (str.equals(SetAlarmActivity.u.get(Integer.valueOf(R.id.touch_once)))) {
            String str2 = ((String[]) WearUtils.A.fromJson(alarmListItems.getDates(), String[].class))[0];
            viewHolder2.alartTime.setText(be3.c(alarmListItems.getTime(), this.b));
        } else {
            viewHolder2.alartTime.setText(be3.c(alarmListItems.getTime(), this.b));
        }
        if (!WearUtils.e1(this.b.b)) {
            viewHolder2.alarmActivatSwith.setVisibility(8);
        }
        viewHolder2.alarmActivatSwith.setChecked(alarmListItems.getIsSelected() > 0);
        viewHolder2.alarmActivatSwith.setOnClickListener(new a(alarmListItems));
        viewHolder2.llRoot.setOnLongClickListener(new b(alarmListItems));
        viewHolder2.llRoot.setOnClickListener(new c(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(this.a.inflate(R.layout.alarm_item_layout, viewGroup, false));
    }

    public void p(d dVar) {
        this.c = dVar;
    }
}
