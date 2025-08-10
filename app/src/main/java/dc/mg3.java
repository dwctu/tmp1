package dc;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.bean.GroupMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: StringTool.java */
/* loaded from: classes4.dex */
public class mg3 {
    public static CharSequence a(Context context, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                int iIndexOf = str.toLowerCase().indexOf(str2.toLowerCase());
                if (iIndexOf != -1 && str2.length() + iIndexOf <= spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.color_accent)), iIndexOf, str2.length() + iIndexOf, 34);
                }
                return spannableStringBuilder;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static CharSequence b(Context context, List<GroupMember> list, String str) {
        ArrayList arrayList = new ArrayList(list);
        String str2 = "";
        if (arrayList.size() == 0) {
            return "";
        }
        ArrayList<String> arrayList2 = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String nickName = ((GroupMember) it.next()).getNickName();
            if (nickName.toLowerCase().contains(str.toLowerCase())) {
                str2 = str2 + nickName + ", ";
                arrayList2.add(nickName);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            String strSubstring = str2.substring(0, str2.length() - 2);
            spannableStringBuilder.append((CharSequence) strSubstring);
            try {
                for (String str3 : arrayList2) {
                    int iIndexOf = strSubstring.indexOf(str3) + str3.toLowerCase().indexOf(str.toLowerCase());
                    if (iIndexOf != -1 && str.length() + iIndexOf <= spannableStringBuilder.length()) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.color_accent)), iIndexOf, str.length() + iIndexOf, 34);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return spannableStringBuilder;
    }
}
