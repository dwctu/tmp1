package com.wear.main.closeRange.alarm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.bean.AlarmListItems;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.AlarmListDao;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.alarm.SlideTopViewDragHelper;
import dc.ah4;
import dc.be3;
import dc.zt3;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public class ShowAlarmPopwindow extends Dialog implements View.OnClickListener, SlideTopViewDragHelper.b {
    public Context a;
    public String b;
    public AlarmListItems c;

    @BindView(R.id.cl_root)
    public ConstraintLayout clRoot;
    public b d;

    @BindView(R.id.iv_close)
    public ImageView ivClose;

    @BindView(R.id.iv_snooze_bg)
    public ImageView ivSnoozeBg;

    @BindView(R.id.iv_up)
    public ImageView ivUp;

    @BindView(R.id.stl_root)
    public SlideTopViewDragHelper stlRoot;

    @BindView(R.id.tv_alarm_from)
    public TextView tvAlarmFrom;

    @BindView(R.id.tv_am_or_pm)
    public TextView tvAmOrPm;

    @BindView(R.id.tv_snooze)
    public TextView tvSnooze;

    @BindView(R.id.tv_snooze_count)
    public TextView tvSnoozeCount;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_turn_off)
    public TextView tvTurnOff;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ShowAlarmPopwindow.this.clRoot.clearAnimation();
            ShowAlarmPopwindow showAlarmPopwindow = ShowAlarmPopwindow.this;
            b bVar = showAlarmPopwindow.d;
            if (bVar != null) {
                bVar.c(showAlarmPopwindow.c);
            }
            ShowAlarmPopwindow.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public interface b {
        void c(AlarmListItems alarmListItems);

        void g(int i);
    }

    public ShowAlarmPopwindow(Activity activity, String str, AlarmListItems alarmListItems, b bVar) {
        super(activity, R.style.Dialog_Fullscreen);
        this.a = activity;
        this.b = str;
        this.c = alarmListItems;
        this.d = bVar;
    }

    public final void a() {
        setContentView(View.inflate(this.a, R.layout.pop_show_alarm, null));
        ButterKnife.bind(this);
        setCancelable(false);
        this.ivClose.setOnClickListener(this);
        this.ivSnoozeBg.setOnClickListener(this);
        this.tvSnooze.setOnClickListener(this);
        this.tvSnoozeCount.setOnClickListener(this);
        this.tvAlarmFrom.setText(this.b);
        this.tvTime.setText(this.c.getTime());
        if (this.c.getHaveSnoozeCount() == 1) {
            this.tvSnoozeCount.setText(this.c.getHaveSnoozeCount() + "st/" + this.c.getSnoozeCount());
        }
        if (this.c.getHaveSnoozeCount() == 2) {
            this.tvSnoozeCount.setText(this.c.getHaveSnoozeCount() + "nd/" + this.c.getSnoozeCount());
        }
        if (this.c.getHaveSnoozeCount() > 2) {
            this.tvSnoozeCount.setText(this.c.getHaveSnoozeCount() + "th/" + this.c.getSnoozeCount());
        }
        try {
            if (!be3.A(this.a)) {
                Date dateJ = be3.j("2019-7-18 " + this.c.getTime(), be3.j);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(dateJ.getTime());
                if (calendar.get(9) == 0) {
                    this.tvTime.setText(be3.f.format(dateJ));
                    this.tvAmOrPm.setText(ah4.e(R.string.app_hourformat_12_am));
                } else {
                    this.tvTime.setText(be3.f.format(dateJ));
                    this.tvAmOrPm.setText(ah4.e(R.string.app_hourformat_12_pm));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.c.getSnoozeCount() == 0 || this.c.getHaveSnoozeCount() > this.c.getSnoozeCount() || this.c.getHaveSnoozeCount() == 0) {
            this.ivSnoozeBg.setVisibility(4);
            this.tvSnoozeCount.setVisibility(4);
            this.tvSnooze.setVisibility(4);
            if (this.c.getFrequency().equals("customer")) {
                this.c.setRingTime(null);
                this.c.setIsSelected(0);
                this.c.setHaveSnoozeCount(0);
                DaoUtils.getAlarmListDao().update((AlarmListDao) this.c);
                AlarmMessagingService.d(this.c.getId(), false);
            }
        } else {
            this.ivSnoozeBg.setVisibility(0);
            this.tvSnoozeCount.setVisibility(0);
            this.tvSnooze.setVisibility(0);
        }
        this.stlRoot.setOnReleasedListener(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close /* 2131363116 */:
                dismiss();
                break;
            case R.id.iv_snooze_bg /* 2131363308 */:
            case R.id.tv_snooze /* 2131365318 */:
            case R.id.tv_snooze_count /* 2131365319 */:
                zt3.r(this.a, this.c);
                b bVar = this.d;
                if (bVar != null) {
                    bVar.g(1);
                }
                dismiss();
                break;
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // com.wear.main.closeRange.alarm.SlideTopViewDragHelper.b
    public void onReleased() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.alarm_hide);
        animationLoadAnimation.setAnimationListener(new a());
        this.clRoot.startAnimation(animationLoadAnimation);
    }
}
