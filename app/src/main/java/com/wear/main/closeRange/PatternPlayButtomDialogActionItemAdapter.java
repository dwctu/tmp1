package com.wear.main.closeRange;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import dc.ah4;

/* loaded from: classes3.dex */
public class PatternPlayButtomDialogActionItemAdapter extends RecyclerView.Adapter<c> {
    public boolean a;
    public d b;
    public b[] c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.RESHARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.SAVED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.SAVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.HIDE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.REPORT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[b.RENAME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[b.DELETE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[b.RESEND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public enum b {
        SHARE,
        SAVE,
        SAVED,
        EDIT,
        DOWNLOAD,
        HIDE,
        REPORT,
        DOWNLOADED,
        RESHARE,
        RENAME,
        DELETE,
        RESEND
    }

    public static class c extends RecyclerView.ViewHolder {
        public ImageView a;
        public TextView b;
        public ConstraintLayout c;

        public c(@NonNull View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.icon_view);
            this.b = (TextView) view.findViewById(R.id.action_name);
            this.c = (ConstraintLayout) view.findViewById(R.id.item_layout);
        }
    }

    public interface d {
        void a(b bVar);
    }

    public PatternPlayButtomDialogActionItemAdapter(b[] bVarArr) {
        this.a = false;
        this.c = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(int i, View view) {
        this.b.a(this.c[i]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, final int i) {
        String strE;
        cVar.c.setOnClickListener(new View.OnClickListener() { // from class: dc.r02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.m(i, view);
            }
        });
        int i2 = a.a[this.c[i].ordinal()];
        int i3 = R.drawable.pattern_item_download;
        switch (i2) {
            case 1:
                strE = ah4.e(R.string.command_edit);
                i3 = R.drawable.pattern_more_rename;
                break;
            case 2:
                strE = ah4.e(R.string.common_share);
                if (!this.a) {
                    cVar.c.setAlpha(0.4f);
                    cVar.c.setEnabled(false);
                    cVar.c.setOnClickListener(null);
                }
                i3 = R.drawable.pattern_item_share;
                break;
            case 3:
                strE = ah4.e(R.string.common_reshared);
                i3 = R.drawable.pattern_item_share;
                break;
            case 4:
                strE = ah4.e(R.string.button_download);
                break;
            case 5:
            case 6:
                i3 = R.drawable.pattern_download_done;
                strE = ah4.e(R.string.common_saved);
                break;
            case 7:
                strE = ah4.e(R.string.common_save);
                break;
            case 8:
                i3 = R.drawable.pattern_more_hide;
                strE = ah4.e(R.string.comman_hide);
                break;
            case 9:
                i3 = R.drawable.pattern_more_report;
                strE = ah4.e(R.string.patterns_menu_report);
                break;
            case 10:
                strE = ah4.e(R.string.common_rename);
                i3 = R.drawable.pattern_more_rename;
                break;
            case 11:
                i3 = R.drawable.pattern_more_delete;
                strE = ah4.e(R.string.common_delete);
                break;
            case 12:
                i3 = R.drawable.pattern_item_resend;
                strE = ah4.e(R.string.common_resend);
                break;
            default:
                strE = "";
                i3 = 0;
                break;
        }
        cVar.a.setBackgroundResource(i3);
        cVar.b.setText(strE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pattern_play_action_item, viewGroup, false));
    }

    public void p(d dVar) {
        this.b = dVar;
    }

    public PatternPlayButtomDialogActionItemAdapter(b[] bVarArr, boolean z) {
        this.a = false;
        this.c = bVarArr;
        this.a = z;
    }
}
