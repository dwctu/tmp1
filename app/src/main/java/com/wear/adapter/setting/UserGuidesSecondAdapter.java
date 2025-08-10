package com.wear.adapter.setting;

import android.content.Context;
import android.os.Bundle;
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
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.bean.UserGuidesMenuBean;
import com.wear.main.account.WebViewActivity;
import dc.ce3;
import dc.pj3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.i18n.MessageBundle;

/* loaded from: classes3.dex */
public class UserGuidesSecondAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<UserGuidesMenuBean> a;
    public Context b;
    public Map<String, List<String>> c;
    public Map<String, Integer> d;
    public int e = 1;
    public int f;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.menu3_more)
        public ImageView menu3More;

        @BindView(R.id.user_guide_ll)
        public LinearLayout userGuideLl;

        @BindView(R.id.user_guide_menu2_ll)
        public LinearLayout userGuideMenu2Ll;

        @BindView(R.id.user_guide_three)
        public TextView userGuideThree;

        @BindView(R.id.user_guide_two)
        public TextView userGuideTwo;

        @BindView(R.id.view)
        public View viewLine;

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
            viewHolder.userGuideTwo = (TextView) Utils.findRequiredViewAsType(view, R.id.user_guide_two, "field 'userGuideTwo'", TextView.class);
            viewHolder.userGuideMenu2Ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.user_guide_menu2_ll, "field 'userGuideMenu2Ll'", LinearLayout.class);
            viewHolder.userGuideThree = (TextView) Utils.findRequiredViewAsType(view, R.id.user_guide_three, "field 'userGuideThree'", TextView.class);
            viewHolder.menu3More = (ImageView) Utils.findRequiredViewAsType(view, R.id.menu3_more, "field 'menu3More'", ImageView.class);
            viewHolder.userGuideLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.user_guide_ll, "field 'userGuideLl'", LinearLayout.class);
            viewHolder.viewLine = Utils.findRequiredView(view, R.id.view, "field 'viewLine'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.userGuideTwo = null;
            viewHolder.userGuideMenu2Ll = null;
            viewHolder.userGuideThree = null;
            viewHolder.menu3More = null;
            viewHolder.userGuideLl = null;
            viewHolder.viewLine = null;
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ UserGuidesMenuBean a;

        public a(UserGuidesMenuBean userGuidesMenuBean) {
            this.a = userGuidesMenuBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a.getMenu() == 3) {
                Bundle bundle = new Bundle();
                bundle.putString(MessageBundle.TITLE_ENTRY, this.a.getTitle());
                bundle.putString(ImagesContract.URL, this.a.getCLink());
                pj3.g(UserGuidesSecondAdapter.this.b, WebViewActivity.class, bundle);
            }
        }
    }

    public UserGuidesSecondAdapter(List<UserGuidesMenuBean> list, Context context) {
        this.a = list;
        this.b = context;
        this.f = ce3.a(context, 12.0f);
        l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public void l() {
        Map<String, List<String>> map = this.c;
        if (map == null) {
            this.c = new HashMap();
        } else {
            map.clear();
        }
        Map<String, Integer> map2 = this.d;
        if (map2 == null) {
            this.d = new HashMap();
        } else {
            map2.clear();
        }
        String title = "";
        for (UserGuidesMenuBean userGuidesMenuBean : this.a) {
            if (userGuidesMenuBean.getMenu() == 2) {
                title = userGuidesMenuBean.getTitle();
                this.c.put(title, new ArrayList());
            } else if (userGuidesMenuBean.getMenu() == 3 && this.c.get(title) != null) {
                this.c.get(title).add(userGuidesMenuBean.getTitle());
            }
        }
        for (List<String> list : this.c.values()) {
            if (list != null) {
                if (list.size() == 1) {
                    this.d.put(list.get(0), Integer.valueOf(R.drawable.card_status_bg));
                } else if (list.size() == 2) {
                    this.d.put(list.get(0), Integer.valueOf(R.drawable.card_status_bg_top));
                    this.d.put(list.get(1), Integer.valueOf(R.drawable.card_status_bg_bottom));
                } else if (list.size() > 2) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (i == 0) {
                            this.d.put(list.get(i), Integer.valueOf(R.drawable.card_status_bg_top));
                        } else if (i == size - 1) {
                            this.d.put(list.get(i), Integer.valueOf(R.drawable.card_status_bg_bottom));
                        } else {
                            this.d.put(list.get(i), Integer.valueOf(R.drawable.card_status_bg));
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        UserGuidesMenuBean userGuidesMenuBean = this.a.get(i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.userGuideLl.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, this.f);
        viewHolder.userGuideLl.setLayoutParams(layoutParams);
        if (userGuidesMenuBean.getMenu() == 2) {
            viewHolder.userGuideMenu2Ll.setVisibility(0);
            viewHolder.userGuideLl.setVisibility(8);
            viewHolder.userGuideTwo.setText(userGuidesMenuBean.getTitle());
            viewHolder.viewLine.setVisibility(8);
        } else {
            viewHolder.userGuideMenu2Ll.setVisibility(8);
            viewHolder.userGuideLl.setVisibility(0);
            if (this.e == 1 && this.d.get(userGuidesMenuBean.getTitle()) != null) {
                viewHolder.userGuideLl.setBackgroundResource(this.d.get(userGuidesMenuBean.getTitle()).intValue());
                if (this.d.get(userGuidesMenuBean.getTitle()).intValue() == R.drawable.card_status_bg_top || this.d.get(userGuidesMenuBean.getTitle()).intValue() == R.drawable.card_status_bg) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewHolder.userGuideLl.getLayoutParams();
                    layoutParams2.setMargins(0, 0, 0, 0);
                    viewHolder.userGuideLl.setLayoutParams(layoutParams2);
                    viewHolder.viewLine.setVisibility(0);
                } else {
                    viewHolder.viewLine.setVisibility(8);
                }
            }
            viewHolder.userGuideThree.setText(userGuidesMenuBean.getTitle());
            if (i != this.a.size() - 1) {
                this.a.get(i + 1).getMenu();
            }
        }
        viewHolder.userGuideLl.setOnClickListener(new a(userGuidesMenuBean));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.b).inflate(R.layout.item_user_guide_second, viewGroup, false));
    }

    public void o(int i) {
        if (i > 0) {
            this.e = i;
        }
        l();
    }
}
