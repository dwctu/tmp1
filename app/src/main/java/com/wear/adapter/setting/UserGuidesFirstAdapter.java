package com.wear.adapter.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.wear.main.account.UserGuidesActivity;
import com.wear.network.presenter.bean.UserGuidesBean;
import dc.ce3;
import dc.gg3;
import java.util.List;

/* loaded from: classes3.dex */
public class UserGuidesFirstAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<UserGuidesBean.DataBean.RemoteGuideBean> a;
    public UserGuidesActivity b;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_guide_first)
        public TextView userGuideFirst;

        @BindView(R.id.user_guide_first_ll)
        public LinearLayout userGuideFirstLl;

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
            viewHolder.userGuideFirst = (TextView) Utils.findRequiredViewAsType(view, R.id.user_guide_first, "field 'userGuideFirst'", TextView.class);
            viewHolder.userGuideFirstLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.user_guide_first_ll, "field 'userGuideFirstLl'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.userGuideFirst = null;
            viewHolder.userGuideFirstLl = null;
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserGuidesFirstAdapter.this.b.v4(this.a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        UserGuidesBean.DataBean.RemoteGuideBean remoteGuideBean = this.a.get(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.userGuideFirstLl.getLayoutParams();
        gg3.e(this.b);
        if (i == this.a.size() - 1) {
            marginLayoutParams.setMargins(ce3.a(this.b, 5.0f), 0, ce3.a(this.b, 15.0f), 0);
        }
        viewHolder.userGuideFirstLl.setLayoutParams(marginLayoutParams);
        if (remoteGuideBean.isSelect()) {
            viewHolder.userGuideFirst.setBackgroundResource(R.drawable.user_guides_menu_red);
            viewHolder.userGuideFirst.setTextColor(this.b.getResources().getColor(R.color.white));
        } else {
            viewHolder.userGuideFirst.setBackgroundResource(R.drawable.user_guides_menu_white);
            viewHolder.userGuideFirst.setTextColor(this.b.getResources().getColor(R.color.text_color_85));
        }
        viewHolder.userGuideFirst.setText(remoteGuideBean.getMenu1Key());
        viewHolder.userGuideFirst.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.b).inflate(R.layout.item_user_guide_first, viewGroup, false));
    }
}
