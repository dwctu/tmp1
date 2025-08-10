package com.wear.ui.me;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import dc.ah4;

/* loaded from: classes4.dex */
public class BirthDayTermsAndConditions extends BaseActivity {

    @BindView(R.id.actionbar_back)
    public ImageButton backButton;

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t4(View view) {
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.birthday_conditions_layout);
        ButterKnife.bind(this);
        this.backButton.setOnClickListener(new View.OnClickListener() { // from class: dc.wa3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t4(view);
            }
        });
        this.recyclerView.setAdapter(new BirthDayConditionsAdapter(new String[]{ah4.e(R.string.birthday_offer_terms_txt3), ah4.e(R.string.birthday_offer_terms_txt4), ah4.e(R.string.birthday_offer_terms_txt5), ah4.e(R.string.birthday_offer_terms_txt6), ah4.e(R.string.birthday_offer_terms_txt7)}));
    }
}
