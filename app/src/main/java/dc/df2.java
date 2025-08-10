package dc;

import com.alibaba.fastjson.JSON;
import com.wear.bean.server.base.MessageType;
import com.wear.bean.server.bean.G010Bean;
import com.wear.bean.server.bean.G020Bean;
import com.wear.bean.server.bean.H010Bean;
import com.wear.bean.server.bean.T010ToyBean;
import com.wear.bean.server.bean.T011ToyBean;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HandlerMessageTool.java */
/* loaded from: classes3.dex */
public class df2 {
    public static final Map<String, Class<? extends m32>> a = new a();

    /* compiled from: HandlerMessageTool.java */
    public class a extends HashMap<String, Class<? extends m32>> {
        public a() {
            put(MessageType.T011, T011ToyBean.class);
            put(MessageType.T010, T010ToyBean.class);
            put(MessageType.G010, G010Bean.class);
            put(MessageType.G020, G020Bean.class);
            put(MessageType.H010, H010Bean.class);
        }
    }

    public static m32 a(String str) {
        return new l32((m32) JSON.parseObject(str, a.get(JSON.parseObject(str).get("type").toString())));
    }
}
