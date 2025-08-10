package com.wear.ui.discover.wishlist;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.WishListDisappearRedDotEvent;
import com.wear.bean.response.WishListBean;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityWishList;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ii;
import dc.kf;
import dc.lg3;
import dc.me3;
import dc.pj3;
import dc.pl;
import dc.qo;
import dc.sg3;
import dc.t13;
import dc.u13;
import dc.ye3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class WishListViewActivity extends BaseActivity<u13> implements t13 {
    public u13 a;
    public WishListBean.DataBean b = null;

    @BindView(R.id.copy_btn)
    public ImageView copyBtn;

    @BindView(R.id.edit_btn)
    public TextView editTextView;

    @BindView(R.id.fan_layout)
    public ConstraintLayout fanLayout;

    @BindView(R.id.fund_description)
    public TextView fundDescription;

    @BindView(R.id.link_text)
    public TextView link;

    @BindView(R.id.nav_back)
    public ImageView navBack;

    @BindView(R.id.contribution_bar)
    public ConstraintLayout noticeBar;

    @BindView(R.id.num_contribute_view)
    public TextView num_contribute_view;

    @BindView(R.id.people_contribution_text_view)
    public TextView peopleContribution;

    @BindView(R.id.percent_text_view)
    public TextView percentView;

    @BindView(R.id.profile_view)
    public ImageView profileView;

    @BindView(R.id.progress_number)
    public ImageView progressNumber;

    @BindView(R.id.refresh_layout_view)
    public SwipeRefreshLayout refreshLayout;

    @BindView(R.id.share_wish_list_btn)
    public Button shareBtn;

    @BindView(R.id.toy_name_view)
    public TextView toyNameView;

    @BindView(R.id.toys_recycler_view)
    public RecyclerView toyRecyclerView;

    @BindView(R.id.toys_layout)
    public ConstraintLayout toysLayout;

    @BindView(R.id.wishlist_description_view)
    public TextView wishListDescription;

    @BindView(R.id.wishlist_name_view)
    public TextView wishListName;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C4(WishListBean.DataBean dataBean, View view) {
        this.a.l(dataBean.getWishListName(), dataBean.getWishListAvatar());
        showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E4(WishListBean.DataBean dataBean, View view) {
        s4(dataBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u4(String str) {
        this.a.m(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w4(View view) {
        this.a.n();
        this.noticeBar.setVisibility(8);
        this.a.l(this.b.getWishListName(), this.b.getWishListAvatar());
        showDialog();
        EventBus.getDefault().post(new WishListDisappearRedDotEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(View view) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.link.getText().toString() + (!WearUtils.v ? "?_utm_pro=2112141049" : "?_utm_pro=2201181285")));
        ye3.d("M0009", "");
        sg3.l(getString(R.string.chat_message_item_copy_notice));
    }

    @Override // dc.t13
    @SuppressLint({"SetTextI18n"})
    public void S(final WishListBean.DataBean dataBean) {
        this.refreshLayout.setRefreshing(false);
        dissDialog();
        this.b = dataBean;
        this.editTextView.setOnClickListener(new View.OnClickListener() { // from class: dc.o13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.C4(dataBean, view);
            }
        });
        this.shareBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.n13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E4(dataBean, view);
            }
        });
        kf.x(this.profileView).v(dataBean.getWishListAvatar()).f(ii.e).a(qo.p0(new pl())).X(R.drawable.default_avatar_wish_list).A0(this.profileView);
        this.wishListName.setText(String.format(ah4.e(R.string.wish_list_titile), dataBean.getWishListName()));
        this.wishListDescription.setText(dataBean.getWishListDesc());
        this.link.setText(dataBean.getWishListUrl());
        if (dataBean.getWishToyList().size() == 0) {
            this.toysLayout.setVisibility(8);
        } else {
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
            flexboxLayoutManager.setFlexDirection(0);
            flexboxLayoutManager.setJustifyContent(0);
            flexboxLayoutManager.canScrollVertically();
            this.toyRecyclerView.setLayoutManager(flexboxLayoutManager);
            this.toyRecyclerView.setAdapter(new ToyTagAdapter(dataBean.getWishToyList()));
            this.toyRecyclerView.setEnabled(false);
        }
        if (dataBean.getWishFanFund() == null) {
            this.fanLayout.setVisibility(8);
            return;
        }
        this.fundDescription.setText(dataBean.getWishFanFund().getDesc());
        this.toyNameView.setText(dataBean.getWishFanFund().getToyName());
        ClipDrawable clipDrawable = (ClipDrawable) this.progressNumber.getBackground();
        double d = Double.parseDouble(dataBean.getWishFanFund().getFunded()) / Double.parseDouble(dataBean.getWishFanFund().getTotalCost());
        clipDrawable.setLevel((int) (10000.0d * d));
        String strE = ah4.e(R.string.fan_funding_detail);
        String str = dataBean.getWishFanFund().getPeopleContributedNum() + "";
        String str2 = String.format(strE, str);
        int iIndexOf = str2.indexOf(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orgy_background_color)), iIndexOf, str.length() + iIndexOf, 33);
        }
        this.peopleContribution.setText(spannableStringBuilder);
        this.percentView.setText(((int) (d * 100.0d)) + "%");
    }

    @Override // dc.t13
    public void W1(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(ImagesContract.URL, str);
        bundle.putString("wishlist_name", str2);
        bundle.putString("image_url", str3);
        pj3.g(this, VisitWishListConfirmActivity.class, bundle);
        dissDialog();
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
        this.mActivityComponent.u(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wishlist_edit_layout);
        me3.c(me3.c.WISH_LIST_UI_ENTER);
        ye3.c("wish list", "into page", null);
        ButterKnife.bind(this);
        final String strC = lg3.c(lg3.e(this));
        this.a.m(strC);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: dc.m13
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.a.u4(strC);
            }
        });
        int intExtra = getIntent().getIntExtra("contribute_num", 0);
        if (intExtra > 0) {
            this.noticeBar.setVisibility(0);
            String str = intExtra + "";
            if (intExtra > 99) {
                str = "99+";
            }
            this.num_contribute_view.setText(str);
            this.noticeBar.setOnClickListener(new View.OnClickListener() { // from class: dc.l13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.w4(view);
                }
            });
        }
        showDialog();
        this.navBack.setOnClickListener(new View.OnClickListener() { // from class: dc.j13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.y4(view);
            }
        });
        this.copyBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.k13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A4(view);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.WISH_LIST_UI_EXIT);
    }

    public final void s4(WishListBean.DataBean dataBean) {
        CommunMessage communMessage = new CommunMessage();
        EntityWishList entityWishList = new EntityWishList();
        entityWishList.setWishListDesc(dataBean.getWishListDesc());
        entityWishList.setWishListUrl(dataBean.getWishListUrl());
        entityWishList.setWishListName(dataBean.getWishListName());
        communMessage.setDataBean(entityWishList);
        communMessage.setType(MessageType.wishlist);
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_message", communMessage);
        pj3.g(this, ForwardMessageActivity.class, bundle);
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        super.showErrorMsg(str, z);
        sg3.l(str);
        this.refreshLayout.setRefreshing(false);
        dissDialog();
    }
}
