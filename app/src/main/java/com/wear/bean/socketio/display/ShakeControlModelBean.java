package com.wear.bean.socketio.display;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.pf2;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ShakeControlModelBean implements pf2 {
    public ToyCmd toyCmd = new ToyCmd();

    public static class ToyCmd {
        public String data;
        public String type = "command";

        public static class Data {
            public String cate = TtmlNode.ATTR_ID;
            public HashMap<String, Id> id = new HashMap<>();

            public static class Id {
                public int v = 0;
                public int p = 0;
                public int r = 0;
            }
        }
    }

    @Override // dc.pf2
    public String getAction() {
        return "shake_control_model";
    }
}
