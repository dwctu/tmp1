package com.wear.bean;

import com.wear.bean.response.BaseResponseBeanNew;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public class PatternFileUploadBean extends BaseResponseBeanNew<PatternFileUploadItem> {

    public static class PatternFileUploadItem {
        public String[] patternIdFail;
        public LinkedHashMap<String, String> patternIdSuc;
    }
}
