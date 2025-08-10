package dc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: ThrowableUtils.java */
/* loaded from: classes.dex */
public class te0 {
    public static final String a = System.getProperty("line.separator");

    public static String a(Throwable th) {
        List<String> listB;
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = th.getCause();
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i = size - 1;
        List<String> listB2 = b((Throwable) arrayList.get(i));
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (size != 0) {
                listB = b((Throwable) arrayList.get(size - 1));
                c(listB2, listB);
            } else {
                listB = listB2;
            }
            if (size == i) {
                arrayList2.add(((Throwable) arrayList.get(size)).toString());
            } else {
                arrayList2.add(" Caused by: " + ((Throwable) arrayList.get(size)).toString());
            }
            arrayList2.addAll(listB2);
            listB2 = listB;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(a);
        }
        return sb.toString();
    }

    public static List<String> b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), a);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf("at");
            if (iIndexOf != -1 && strNextToken.substring(0, iIndexOf).trim().isEmpty()) {
                arrayList.add(strNextToken);
                z = true;
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    public static void c(List<String> list, List<String> list2) {
        int size = list.size() - 1;
        for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
        }
    }
}
