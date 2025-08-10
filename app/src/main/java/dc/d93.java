package dc;

import android.content.Context;
import com.lovense.wear.R;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaHandler.java */
/* loaded from: classes4.dex */
public class d93 {

    /* compiled from: MediaHandler.java */
    public class a implements Comparator<MediaFile> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaFile mediaFile, MediaFile mediaFile2) {
            if (mediaFile.a() > mediaFile2.a()) {
                return -1;
            }
            return mediaFile.a() < mediaFile2.a() ? 1 : 0;
        }
    }

    /* compiled from: MediaHandler.java */
    public class b implements Comparator<y83> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(y83 y83Var, y83 y83Var2) {
            if (y83Var.d().size() > y83Var2.d().size()) {
                return -1;
            }
            return y83Var.d().size() < y83Var2.d().size() ? 1 : 0;
        }
    }

    /* compiled from: MediaHandler.java */
    public class c implements Comparator<MediaFile> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaFile mediaFile, MediaFile mediaFile2) {
            return mediaFile.a() < mediaFile2.a() ? 1 : -1;
        }
    }

    public static List<y83> a(Context context, ArrayList<MediaFile> arrayList) {
        return b(context, arrayList, null);
    }

    public static List<y83> b(Context context, ArrayList<MediaFile> arrayList, ArrayList<MediaFile> arrayList2) {
        HashMap map = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        if (arrayList2 != null) {
            arrayList3.addAll(arrayList2);
        }
        Collections.sort(arrayList3, new a());
        if (!arrayList3.isEmpty()) {
            map.put(-1, new y83(-1, context.getString(R.string.all_media), ((MediaFile) arrayList3.get(0)).f(), ((MediaFile) arrayList3.get(0)).e(), arrayList3));
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            map.put(-2, new y83(-2, context.getString(R.string.all_video), arrayList2.get(0).f(), ((MediaFile) arrayList3.get(0)).e(), arrayList2));
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                MediaFile mediaFile = arrayList.get(i);
                int iIntValue = mediaFile.c().intValue();
                y83 y83Var = (y83) map.get(Integer.valueOf(iIntValue));
                if (y83Var == null) {
                    y83Var = new y83(iIntValue, mediaFile.d(), mediaFile.f(), mediaFile.e(), new ArrayList());
                }
                ArrayList<MediaFile> arrayListD = y83Var.d();
                arrayListD.add(mediaFile);
                d(arrayListD);
                y83Var.e(arrayListD);
                map.put(Integer.valueOf(iIntValue), y83Var);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            arrayList4.add((y83) map.get((Integer) it.next()));
        }
        Collections.sort(arrayList4, new b());
        return arrayList4;
    }

    public static List<y83> c(Context context, ArrayList<MediaFile> arrayList) {
        return b(context, null, arrayList);
    }

    public static ArrayList<MediaFile> d(ArrayList<MediaFile> arrayList) {
        Collections.sort(arrayList, new c());
        return arrayList;
    }
}
