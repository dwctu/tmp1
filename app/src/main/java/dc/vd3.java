package dc;

import com.alibaba.fastjson.JSON;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/* compiled from: CollectionsCustom.java */
/* loaded from: classes4.dex */
public class vd3 {

    /* compiled from: CollectionsCustom.java */
    public class a implements Comparator<Integer> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            if (num.intValue() < num2.intValue()) {
                return 1;
            }
            return num.intValue() > num2.intValue() ? -1 : 0;
        }
    }

    public static void a(Object[] objArr, Object[] objArr2, int i, int i2, int i3, Comparator comparator) {
        int i4 = i2 - i;
        if (i4 < 7) {
            for (int i5 = i; i5 < i2; i5++) {
                for (int i6 = i5; i6 > i; i6--) {
                    int i7 = i6 - 1;
                    if (comparator.compare(objArr2[i7], objArr2[i6]) > 0) {
                        c(objArr2, i6, i7);
                    }
                }
            }
            return;
        }
        int i8 = i + i3;
        int i9 = i2 + i3;
        int i10 = (i8 + i9) >>> 1;
        int i11 = -i3;
        a(objArr2, objArr, i8, i10, i11, comparator);
        a(objArr2, objArr, i10, i9, i11, comparator);
        if (comparator.compare(objArr[i10 - 1], objArr[i10]) <= 0) {
            System.arraycopy(objArr, i8, objArr2, i, i4);
            return;
        }
        int i12 = i10;
        while (i < i2) {
            if (i12 >= i9 || (i8 < i10 && comparator.compare(objArr[i8], objArr[i12]) <= 0)) {
                objArr2[i] = objArr[i8];
                i8++;
            } else {
                objArr2[i] = objArr[i12];
                i12++;
            }
            i++;
        }
    }

    public static <T> void b(List<T> list, Comparator<? super T> comparator) {
        try {
            Object[] array = list.toArray();
            a((Object[]) array.clone(), array, 0, array.length, 0, comparator);
            ListIterator<T> listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public static void c(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static void d() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 30; i++) {
            arrayList.add(Integer.valueOf((int) (Math.random() * 1000.0d)));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        a aVar = new a();
        System.err.println("开始AAAA" + JSON.toJSONString(arrayList));
        long jCurrentTimeMillis = System.currentTimeMillis();
        Collections.sort(arrayList, aVar);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        System.err.println("完成AAAA" + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        System.err.println("完成AAAA" + JSON.toJSONString(arrayList));
        System.err.println("开始UUUU" + JSON.toJSONString(arrayList2));
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        b(arrayList2, aVar);
        long jCurrentTimeMillis4 = System.currentTimeMillis();
        System.err.println("完成UUUU" + (jCurrentTimeMillis4 - jCurrentTimeMillis3));
        System.err.println("完成UUUU" + JSON.toJSONString(arrayList2));
    }
}
