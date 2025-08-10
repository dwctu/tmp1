package com.wear.ui.longDistance.behavior;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lovense.wear.R;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.databinding.DialogGuideVideoBinding;
import com.wear.ui.longDistance.behavior.GuideVideoBottom;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.util.MyApplication;
import dc.ah4;
import dc.eg3;
import dc.lg3;
import dc.qd3;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GuideVideoBottom.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017¨\u0006\f"}, d2 = {"Lcom/wear/ui/longDistance/behavior/GuideVideoBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/DialogGuideVideoBinding;", "()V", "initVideo", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class GuideVideoBottom extends BaseBindingBottomDialogFragment<DialogGuideVideoBinding> {

    /* compiled from: GuideVideoBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogGuideVideoBinding> {
        public static final a a = new a();

        public a() {
            super(3, DialogGuideVideoBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/DialogGuideVideoBinding;", 0);
        }

        @NotNull
        public final DialogGuideVideoBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return DialogGuideVideoBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ DialogGuideVideoBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public GuideVideoBottom() {
        super(a.a);
    }

    public static final void B(GuideVideoBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eg3.i(MyApplication.N(), "key_show_video_by_connections", Boolean.FALSE);
        this$0.dismiss();
    }

    public static final void v(GuideVideoBottom this$0, File file) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.exists()) {
            String string = file.toURI().toString();
            Intrinsics.checkNotNullExpressionValue(string, "file.toURI().toString()");
            this$0.t().c.setUrl(string);
            this$0.t().c.setLooping(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) throws IOException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.t73
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuideVideoBottom.B(this.a, view2);
            }
        });
        t().a.setText(ah4.e(R.string.long_distance_tutorial_step3) + ' ' + ah4.e(R.string.long_distance_tutorial_step4));
        u();
    }

    public final void u() throws IOException {
        qd3.a(getContext(), lg3.d(MyApplication.N()).equals("ja") ? "video/long_distance_ja.mp4" : lg3.d(MyApplication.N()).equals("fr") ? "video/long_distance_fr.mp4" : lg3.d(MyApplication.N()).equals("es") ? "video/long_distance_es.mp4" : lg3.d(MyApplication.N()).equals("ru") ? "video/long_distance_ru.mp4" : "video/long_distance_en.mp4", new qd3.a() { // from class: dc.s73
            @Override // dc.qd3.a
            public final void a(File file) {
                GuideVideoBottom.v(this.a, file);
            }
        });
        MyVideoView myVideoView = t().c;
        final MyVideoView myVideoView2 = t().c;
        myVideoView.postDelayed(new Runnable() { // from class: dc.r73
            @Override // java.lang.Runnable
            public final void run() {
                myVideoView2.start();
            }
        }, 100L);
    }
}
