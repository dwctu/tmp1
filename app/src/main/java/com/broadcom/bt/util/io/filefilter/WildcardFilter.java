package com.broadcom.bt.util.io.filefilter;

import com.broadcom.bt.util.io.FilenameUtils;
import java.io.File;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class WildcardFilter extends AbstractFileFilter implements Serializable {
    private final String[] wildcards;

    public WildcardFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{str};
    }

    @Override // com.broadcom.bt.util.io.filefilter.AbstractFileFilter, com.broadcom.bt.util.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (file != null && new File(file, str).isDirectory()) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.wildcards;
            if (i >= strArr.length) {
                return false;
            }
            if (FilenameUtils.wildcardMatch(str, strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public WildcardFilter(String[] strArr) {
        if (strArr != null) {
            this.wildcards = strArr;
            return;
        }
        throw new IllegalArgumentException("The wildcard array must not be null");
    }

    @Override // com.broadcom.bt.util.io.filefilter.AbstractFileFilter, com.broadcom.bt.util.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (int i = 0; i < this.wildcards.length; i++) {
            if (FilenameUtils.wildcardMatch(file.getName(), this.wildcards[i])) {
                return true;
            }
        }
        return false;
    }

    public WildcardFilter(List list) {
        if (list != null) {
            this.wildcards = (String[]) list.toArray(new String[list.size()]);
            return;
        }
        throw new IllegalArgumentException("The wildcard list must not be null");
    }
}
