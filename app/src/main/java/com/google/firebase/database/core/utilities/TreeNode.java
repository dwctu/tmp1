package com.google.firebase.database.core.utilities;

import com.broadcom.bt.util.io.IOUtils;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    public String toString(String str) {
        String string = str + "<value>: " + this.value + IOUtils.LINE_SEPARATOR_UNIX;
        if (this.children.isEmpty()) {
            return string + str + "<empty>";
        }
        for (Map.Entry<ChildKey, TreeNode<T>> entry : this.children.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(str);
            sb.append(entry.getKey());
            sb.append(":\n");
            sb.append(entry.getValue().toString(str + "\t"));
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            string = sb.toString();
        }
        return string;
    }
}
