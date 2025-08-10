package org.jivesoftware.smack.roster.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.util.WearUtils;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.util.JidTransformUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class RosterPacketProvider extends IQProvider<RosterPacket> {
    public static final RosterPacketProvider INSTANCE = new RosterPacketProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public RosterPacket parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        String strNextText;
        RosterPacket rosterPacket = new RosterPacket();
        String attributeValue = xmlPullParser.getAttributeValue("", RosterVer.ELEMENT);
        String attributeValue2 = xmlPullParser.getAttributeValue("", "ev");
        rosterPacket.setVersion(attributeValue);
        RosterPacket.Item item = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("item")) {
                    RosterPacket.Item item2 = new RosterPacket.Item(JidTransformUtil.transform(xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key), false, WearUtils.n1(attributeValue2) ? Integer.parseInt(attributeValue2) : 0), xmlPullParser.getAttributeValue("", "name"));
                    item2.setItemStatus(RosterPacket.ItemStatus.fromString(xmlPullParser.getAttributeValue("", "ask")));
                    String attributeValue3 = xmlPullParser.getAttributeValue("", "subscription");
                    if (attributeValue3 == null) {
                        attributeValue3 = "none";
                    }
                    item2.setItemType(RosterPacket.ItemType.valueOf(attributeValue3));
                    item = item2;
                } else if (name.equals("group") && (strNextText = xmlPullParser.nextText()) != null && strNextText.trim().length() > 0) {
                    item.addGroupName(strNextText);
                }
            } else if (next != 3) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                name2.hashCode();
                if (name2.equals("item")) {
                    rosterPacket.addRosterItem(item);
                } else if (name2.equals("query")) {
                    return rosterPacket;
                }
            }
        }
    }
}
