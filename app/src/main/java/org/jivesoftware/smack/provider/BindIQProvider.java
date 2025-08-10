package org.jivesoftware.smack.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Bind;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class BindIQProvider extends IQProvider<Bind> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Bind parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        Bind bindNewResult = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("resource")) {
                    bindNewResult = Bind.newSet(xmlPullParser.nextText());
                } else if (name.equals(PSOProgramService.JobID_Key)) {
                    bindNewResult = Bind.newResult(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getDepth() == i) {
                return bindNewResult;
            }
        }
    }
}
