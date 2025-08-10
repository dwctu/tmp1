package com.wear.main.longDistance.controllink;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.ControlLinkDescriptionEvent;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ce3;
import dc.sg3;
import dc.th4;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class ControlLinkDescriptionActivity extends BaseActivity {
    public static int d = 21;

    @BindView(R.id.action_bar)
    public MyActionBar actionBar;
    public b c;

    @BindView(R.id.message_text)
    public EditText messageText;

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;
    public List<String> a = new ArrayList();
    public List<String> b = new ArrayList();

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ControlLinkDescriptionEvent controlLinkDescriptionEvent = new ControlLinkDescriptionEvent(ControlLinkDescriptionActivity.this.a, ControlLinkDescriptionActivity.this.messageText.getText().toString().trim());
            Intent intent = new Intent();
            intent.putExtra(ControlLinkDescriptionEvent.tag, WearUtils.A.toJson(controlLinkDescriptionEvent));
            ControlLinkDescriptionActivity.this.setResult(ControlLinkDescriptionActivity.d, intent);
            ControlLinkDescriptionActivity.this.finish();
        }
    }

    public class b extends RecyclerView.Adapter<C0130b> {
        public List<String> a = new ArrayList();

        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;
            public final /* synthetic */ C0130b b;

            public a(int i, C0130b c0130b) {
                this.a = i;
                this.b = c0130b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = b.this;
                boolean zU4 = ControlLinkDescriptionActivity.this.u4((String) bVar.a.get(this.a));
                View view2 = this.b.itemView;
                view2.setBackground(th4.d(view2.getContext(), zU4 ? R.drawable.item_select_toy_background_selected : R.drawable.description_tag_item_unselected_backgroud));
                C0130b c0130b = this.b;
                c0130b.a.setTextColor(th4.b(c0130b.itemView.getContext(), !zU4 ? R.color.description_item_color : R.color.white));
            }
        }

        /* renamed from: com.wear.main.longDistance.controllink.ControlLinkDescriptionActivity$b$b, reason: collision with other inner class name */
        public class C0130b extends RecyclerView.ViewHolder {
            public TextView a;

            public C0130b(@NonNull @NotNull b bVar, View view) {
                super(view);
                this.a = (TextView) view.findViewById(R.id.tagName);
            }
        }

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull @NotNull C0130b c0130b, int i) {
            c0130b.itemView.setOnClickListener(new a(i, c0130b));
            c0130b.a.setText(this.a.get(i));
            boolean zContains = ControlLinkDescriptionActivity.this.a.contains(this.a.get(i));
            View view = c0130b.itemView;
            view.setBackground(th4.d(view.getContext(), zContains ? R.drawable.item_select_toy_background_selected : R.drawable.description_tag_item_unselected_backgroud));
            c0130b.a.setTextColor(th4.b(c0130b.itemView.getContext(), !zContains ? R.color.description_item_color : R.color.white));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C0130b onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
            return new C0130b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_description_tag_layout, viewGroup, false));
        }

        public void o(List<String> list) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_control_link_description);
        ButterKnife.bind(this);
        this.actionBar.setYesAction(ah4.e(R.string.common_done), new a());
        ControlLinkDescriptionEvent controlLinkDescriptionEvent = (ControlLinkDescriptionEvent) WearUtils.A.fromJson(getIntent().getStringExtra(ControlLinkDescriptionEvent.tag), ControlLinkDescriptionEvent.class);
        if (controlLinkDescriptionEvent != null) {
            if (controlLinkDescriptionEvent.getSelectedTags() != null) {
                this.a = controlLinkDescriptionEvent.getSelectedTags();
            }
            if (!TextUtils.isEmpty(controlLinkDescriptionEvent.getContent())) {
                this.messageText.setText(controlLinkDescriptionEvent.getContent());
            }
        }
        this.c = new b();
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        this.recyclerView.addItemDecoration(new SpaceItemDecoration(ce3.a(this, 8.0f)));
        this.recyclerView.setLayoutManager(flowLayoutManager);
        this.recyclerView.setAdapter(this.c);
        t4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void t4() {
        this.b.add(ah4.e(R.string.control_link_hashtag1));
        this.b.add(ah4.e(R.string.control_link_hashtag2));
        this.b.add(ah4.e(R.string.control_link_hashtag3));
        this.b.add(ah4.e(R.string.control_link_hashtag4));
        this.b.add(ah4.e(R.string.control_link_hashtag5));
        this.b.add(ah4.e(R.string.control_link_hashtag6));
        this.b.add(ah4.e(R.string.control_link_hashtag7));
        this.b.add(ah4.e(R.string.control_link_hashtag8));
        this.b.add(ah4.e(R.string.control_link_hashtag9));
        this.b.add(ah4.e(R.string.control_link_hashtag10));
        this.c.o(this.b);
    }

    public boolean u4(String str) {
        if (this.a.contains(str)) {
            this.a.remove(str);
        } else {
            if (this.a.size() < 3) {
                this.a.add(str);
                return true;
            }
            sg3.l(ah4.e(R.string.toast_only_choose_4hashtag));
        }
        return false;
    }
}
