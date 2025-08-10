package dc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.spotify.sdk.android.player.Config;
import dc.zg4;

/* compiled from: SkinPrefixBuildInLoader.java */
/* loaded from: classes5.dex */
public class ii4 implements zg4.c {
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
        return str + Config.IN_FIELD_SEPARATOR + context.getResources().getResourceEntryName(i);
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
        return 2;
    }
}
