package com.wear.ui.discover.voicecontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lovense.wear.R;
import com.wear.databinding.DialogCommandBottomBinding;
import com.wear.ui.discover.voicecontrol.CommandBottomDialog;
import dc.ah4;
import dc.eg3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommandBottomDialog.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/CommandBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/wear/databinding/DialogCommandBottomBinding;", "initEventListener", "", "initView", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CommandBottomDialog extends BottomSheetDialog {

    @NotNull
    public DialogCommandBottomBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandBottomDialog(@NotNull Context context) {
        super(context, R.style.BottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        DialogCommandBottomBinding dialogCommandBottomBindingC = DialogCommandBottomBinding.c(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(dialogCommandBottomBindingC, "inflate(LayoutInflater.from(context))");
        this.a = dialogCommandBottomBindingC;
        setContentView(dialogCommandBottomBindingC.getRoot());
        c();
        a();
        eg3.d(context, "newGuide", true);
    }

    public static final void b(CommandBottomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public final void a() {
        eg3.d(getContext(), "newGuide", true);
        this.a.b.setOnClickListener(new View.OnClickListener() { // from class: dc.kz2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommandBottomDialog.b(this.a, view);
            }
        });
    }

    public final void c() {
        DialogCommandBottomBinding dialogCommandBottomBinding = this.a;
        dialogCommandBottomBinding.d.setText(ah4.e(R.string.voice_command_title1));
        dialogCommandBottomBinding.n.setText("1. " + ah4.e(R.string.voice_command_title2));
        dialogCommandBottomBinding.o.setText("2. " + ah4.e(R.string.voice_command_title3));
        dialogCommandBottomBinding.p.setText("3. " + ah4.e(R.string.voice_command_title4));
        dialogCommandBottomBinding.g.setText(ah4.e(R.string.voice_elementary_command1));
        dialogCommandBottomBinding.h.setText(ah4.e(R.string.voice_elementary_command2));
        dialogCommandBottomBinding.c.setText(ah4.e(R.string.voice_elementary_command3));
        dialogCommandBottomBinding.e.setText(ah4.e(R.string.voice_elementary_command4));
        dialogCommandBottomBinding.j.setText(ah4.e(R.string.voice_elementary_command5));
        dialogCommandBottomBinding.k.setText(ah4.e(R.string.voice_elementary_command6));
        dialogCommandBottomBinding.i.setText(ah4.e(R.string.voice_intermediate_command1) + " + (0-20)");
        dialogCommandBottomBinding.f.setText(ah4.e(R.string.voice_intermediate_command2) + " + (0-5)");
        dialogCommandBottomBinding.m.setText(ah4.e(R.string.voice_command_example));
        dialogCommandBottomBinding.l.setText(ah4.e(R.string.voice_pattern_command1));
        dialogCommandBottomBinding.q.setText(ah4.e(R.string.voice_pattern_command2));
        dialogCommandBottomBinding.r.setText(ah4.e(R.string.voice_pattern_command3));
    }
}
