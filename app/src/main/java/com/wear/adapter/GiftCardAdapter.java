package com.wear.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.bean.GiftCard;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.be3;
import dc.de3;
import dc.kf;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.wg0;
import dc.ye3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import skin.support.constraint.SkinCompatConstraintLayout;
import skin.support.widget.SkinCompatImageView;

/* loaded from: classes3.dex */
public class GiftCardAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public Context a;
    public View b;
    public List<GiftCard> c;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.gift_card_amount)
        public TextView giftCardAmount;

        @BindView(R.id.giftCardImage)
        public ImageView giftCardImage;

        @BindView(R.id.gift_card_item_copy)
        public SkinCompatImageView giftCardItemCopy;

        @BindView(R.id.gift_card_link)
        public TextView giftCardLink;

        @BindView(R.id.gift_card_name)
        public TextView giftCardName;

        @BindView(R.id.gift_card_noteLinear)
        public LinearLayout giftCardNoteLinear;

        @BindView(R.id.gift_card_refund)
        public LinearLayout giftCardRefund;

        @BindView(R.id.gift_card_share)
        public ImageView giftCardShare;

        @BindView(R.id.gift_card_status)
        public TextView giftCardStatus;

        @BindView(R.id.layout)
        public SkinCompatConstraintLayout layout;

        @BindView(R.id.view1)
        public View view1;

        @BindView(R.id.view2)
        public View view2;

        public MyViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class MyViewHolder_ViewBinding implements Unbinder {
        public MyViewHolder a;

        @UiThread
        public MyViewHolder_ViewBinding(MyViewHolder myViewHolder, View view) {
            this.a = myViewHolder;
            myViewHolder.giftCardImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.giftCardImage, "field 'giftCardImage'", ImageView.class);
            myViewHolder.giftCardLink = (TextView) Utils.findRequiredViewAsType(view, R.id.gift_card_link, "field 'giftCardLink'", TextView.class);
            myViewHolder.giftCardStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.gift_card_status, "field 'giftCardStatus'", TextView.class);
            myViewHolder.giftCardName = (TextView) Utils.findRequiredViewAsType(view, R.id.gift_card_name, "field 'giftCardName'", TextView.class);
            myViewHolder.giftCardAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.gift_card_amount, "field 'giftCardAmount'", TextView.class);
            myViewHolder.view1 = Utils.findRequiredView(view, R.id.view1, "field 'view1'");
            myViewHolder.view2 = Utils.findRequiredView(view, R.id.view2, "field 'view2'");
            myViewHolder.giftCardShare = (ImageView) Utils.findRequiredViewAsType(view, R.id.gift_card_share, "field 'giftCardShare'", ImageView.class);
            myViewHolder.giftCardRefund = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.gift_card_refund, "field 'giftCardRefund'", LinearLayout.class);
            myViewHolder.giftCardNoteLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.gift_card_noteLinear, "field 'giftCardNoteLinear'", LinearLayout.class);
            myViewHolder.giftCardItemCopy = (SkinCompatImageView) Utils.findRequiredViewAsType(view, R.id.gift_card_item_copy, "field 'giftCardItemCopy'", SkinCompatImageView.class);
            myViewHolder.layout = (SkinCompatConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout, "field 'layout'", SkinCompatConstraintLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MyViewHolder myViewHolder = this.a;
            if (myViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            myViewHolder.giftCardImage = null;
            myViewHolder.giftCardLink = null;
            myViewHolder.giftCardStatus = null;
            myViewHolder.giftCardName = null;
            myViewHolder.giftCardAmount = null;
            myViewHolder.view1 = null;
            myViewHolder.view2 = null;
            myViewHolder.giftCardShare = null;
            myViewHolder.giftCardRefund = null;
            myViewHolder.giftCardNoteLinear = null;
            myViewHolder.giftCardItemCopy = null;
            myViewHolder.layout = null;
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ GiftCard a;

        public a(GiftCard giftCard) {
            this.a = giftCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (TextUtils.isEmpty(this.a.getRefundLink())) {
                return;
            }
            String refundLink = this.a.getRefundLink();
            if (WearUtils.v) {
                str = refundLink + "?_utm_pro=2203031253";
            } else {
                str = refundLink + "?_utm_pro=2203031110";
            }
            ye3.d("M0017", "");
            MyApplication.y0(GiftCardAdapter.this.a, str);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ GiftCard a;

        public b(GiftCard giftCard) {
            this.a = giftCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GiftCardAdapter.this.o(this.a);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ GiftCard a;
        public final /* synthetic */ MyViewHolder b;

        public class a implements PopupWindow.OnDismissListener {
            public a(c cVar) {
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
            }
        }

        public c(GiftCard giftCard, MyViewHolder myViewHolder) {
            this.a = giftCard;
            this.b = myViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View viewInflate = LayoutInflater.from(GiftCardAdapter.this.a).inflate(R.layout.popwindow_gift_card, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.note_content);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.recipient_content);
            SkinCompatImageView skinCompatImageView = (SkinCompatImageView) viewInflate.findViewById(R.id.pop_up_image);
            SkinCompatImageView skinCompatImageView2 = (SkinCompatImageView) viewInflate.findViewById(R.id.pop_down_image);
            NestedScrollView nestedScrollView = (NestedScrollView) viewInflate.findViewById(R.id.scroll_view);
            textView.setText(this.a.getSenderNote());
            textView2.setText(this.a.getReceiverNote());
            wg0.c cVar = new wg0.c(GiftCardAdapter.this.a);
            cVar.f(viewInflate);
            cVar.c(0.6f);
            cVar.b(true);
            cVar.e(true);
            cVar.d(new a(this));
            wg0 wg0VarA = cVar.a();
            WindowManager windowManager = (WindowManager) GiftCardAdapter.this.a.getSystemService("window");
            Rect rect = new Rect();
            windowManager.getDefaultDisplay().getRectSize(rect);
            int[] iArr = new int[2];
            this.b.giftCardNoteLinear.getLocationOnScreen(iArr);
            String str = "onClick: holder.giftCardNoteLinear   width=" + iArr[0] + "  height=" + iArr[1];
            String str2 = "onClick: popwindow width=" + viewInflate.getMeasuredWidth() + "height=" + viewInflate.getMeasuredHeight() + "windowWidth=" + (rect.right - rect.left) + " widowHeight=" + (rect.bottom - rect.top);
            int i = (rect.bottom - rect.top) / 2;
            if (viewInflate.getMeasuredHeight() > i - 100) {
                skinCompatImageView.setVisibility(8);
                skinCompatImageView2.setVisibility(8);
                nestedScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, de3.a(GiftCardAdapter.this.a, 500.0f)));
                wg0VarA.o(GiftCardAdapter.this.b, 17, 0, 0);
                return;
            }
            nestedScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (iArr[1] > i) {
                skinCompatImageView.setVisibility(8);
                skinCompatImageView2.setVisibility(0);
                LinearLayout linearLayout = this.b.giftCardNoteLinear;
                wg0VarA.n(linearLayout, (-iArr[0]) + (linearLayout.getMeasuredWidth() / 2), -(viewInflate.getMeasuredHeight() + this.b.giftCardNoteLinear.getMeasuredHeight()));
                return;
            }
            skinCompatImageView.setVisibility(0);
            skinCompatImageView2.setVisibility(8);
            LinearLayout linearLayout2 = this.b.giftCardNoteLinear;
            wg0VarA.n(linearLayout2, (-iArr[0]) + (linearLayout2.getMeasuredWidth() / 2), 0);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ GiftCard a;

        public d(GiftCard giftCard) {
            this.a = giftCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String cardLink = this.a.getCardLink();
            if (WearUtils.v) {
                str = cardLink + "?_utm_pro=2203032057";
            } else {
                str = cardLink + "?_utm_pro=2203032511";
            }
            HashMap map = new HashMap();
            map.put("type", 1);
            ye3.d("M0015", WearUtils.A.toJson(map));
            WearUtils.p(str, GiftCardAdapter.this.a);
            sg3.l(ah4.e(R.string.system_copy_success));
        }
    }

    public GiftCardAdapter(Context context, List<GiftCard> list) {
        this.c = new ArrayList();
        this.a = context;
        this.c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void o(GiftCard giftCard) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setDataBean(giftCard.toEntityGiftCard());
        communMessage.setType(MessageType.giftcard);
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_message", communMessage);
        pj3.g(this.a, ForwardMessageActivity.class, bundle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        GiftCard giftCard = this.c.get(i);
        myViewHolder.giftCardShare.setVisibility(8);
        myViewHolder.giftCardRefund.setVisibility(8);
        myViewHolder.giftCardLink.setText(giftCard.getCardLink());
        myViewHolder.giftCardName.setText(giftCard.getCardName());
        myViewHolder.layout.setAlpha(1.0f);
        kf.w(this.a).v(giftCard.getCardImage()).X(R.drawable.gift_card_error).h(R.drawable.gift_card_error).A0(myViewHolder.giftCardImage);
        myViewHolder.giftCardAmount.setText(ah4.c(R.string.common_status4) + ":$" + giftCard.getAmount());
        myViewHolder.giftCardStatus.setTextColor(th4.b(this.a, R.color.gift_card_status_color));
        int status = giftCard.getStatus();
        if (status == 1) {
            if (TextUtils.equals("yes", giftCard.getShowExpireItem())) {
                String strH = be3.h(giftCard.getExpireTime().longValue() - System.currentTimeMillis());
                String str = String.format(ah4.c(R.string.common_status1), strH);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(th4.b(this.a, R.color.wish_list_guild_text_color_2));
                SpannableString spannableString = new SpannableString(str);
                int iIndexOf = str.indexOf(strH);
                if (iIndexOf != -1) {
                    spannableString.setSpan(foregroundColorSpan, iIndexOf, strH.length() + iIndexOf, 33);
                }
                myViewHolder.giftCardStatus.setText(spannableString);
            } else {
                myViewHolder.giftCardStatus.setText(ah4.e(R.string.auto_tip_state_runing));
            }
            myViewHolder.giftCardShare.setVisibility(0);
        } else if (status == 2) {
            myViewHolder.giftCardStatus.setText(ah4.c(R.string.common_status2));
            myViewHolder.giftCardStatus.setTextColor(th4.b(this.a, R.color.gift_card_expired_color));
            myViewHolder.giftCardRefund.setVisibility(0);
        } else if (status == 3) {
            myViewHolder.giftCardStatus.setText(ah4.c(R.string.common_status3));
            myViewHolder.layout.setAlpha(0.5f);
        } else if (status == 4) {
            myViewHolder.giftCardStatus.setText(ah4.c(R.string.refunded_notice));
        }
        myViewHolder.giftCardRefund.setOnClickListener(new a(giftCard));
        myViewHolder.giftCardShare.setOnClickListener(new b(giftCard));
        myViewHolder.giftCardNoteLinear.setOnClickListener(new c(giftCard, myViewHolder));
        myViewHolder.giftCardItemCopy.setOnClickListener(new d(giftCard));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.b = viewGroup;
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gift_card, viewGroup, false));
    }

    public void r(List<GiftCard> list) {
        this.c = list;
        notifyDataSetChanged();
    }
}
