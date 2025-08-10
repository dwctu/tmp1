package dc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.spotify.sdk.android.player.Config;
import dc.zg4;

/* compiled from: SkinBuildInLoader.java */
/* loaded from: classes5.dex */
public class gi4 implements zg4.c {
    @Override // dc.zg4.c
    public Drawable a(Context context, String str, int i) {
        return null;
    }

    @Override // dc.zg4.c
    public String b(Context context, String str) {
        th4.e().s(context.getResources(), context.getPackageName(), str, this);
        return str;
    }

    @Override // dc.zg4.c
    public String c(Context context, String str, int i) {
        return context.getResources().getResourceEntryName(i) + Config.IN_FIELD_SEPARATOR + str;
    }

    @Override // dc.zg4.c
    public ColorStateList d(Context context, String str, int i) {
        return null;
    }

    @Override // dc.zg4.c
    public ColorStateList e(Context context, String str, int i) {
        return null;
    }

    @Override // dc.zg4.c
    public int getType() {
        return 1;
    }
}
