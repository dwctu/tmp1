package org.jivesoftware.smackx.search;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.search.ReportedData;
import org.jivesoftware.smackx.xdata.Form;
import org.jivesoftware.smackx.xdata.FormField;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class SimpleUserSearch extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:search";
    private ReportedData data;
    private Form form;

    public SimpleUserSearch() {
        super("query", "jabber:iq:search");
    }

    private String getItemsToSearch() {
        StringBuilder sb = new StringBuilder();
        if (this.form == null) {
            this.form = Form.getFormFrom(this);
        }
        Form form = this.form;
        if (form == null) {
            return "";
        }
        for (FormField formField : form.getFields()) {
            String variable = formField.getVariable();
            String singleValue = getSingleValue(formField);
            if (singleValue.trim().length() > 0) {
                sb.append(SimpleComparison.LESS_THAN_OPERATION);
                sb.append(variable);
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                sb.append(singleValue);
                sb.append("</");
                sb.append(variable);
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            }
        }
        return sb.toString();
    }

    private static String getSingleValue(FormField formField) {
        List<String> values = formField.getValues();
        return values.isEmpty() ? "" : values.get(0);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((CharSequence) getItemsToSearch());
        return iQChildElementXmlStringBuilder;
    }

    public ReportedData getReportedData() {
        return this.data;
    }

    public void parseItems(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ReportedData reportedData = new ReportedData();
        reportedData.addColumn(new ReportedData.Column("JID", PSOProgramService.JobID_Key, FormField.Type.text_single));
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!z) {
            if (xmlPullParser.getAttributeCount() > 0) {
                String attributeValue = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(attributeValue);
                arrayList.add(new ReportedData.Field(PSOProgramService.JobID_Key, arrayList2));
            }
            int next = xmlPullParser.next();
            boolean z2 = true;
            if (next == 2 && xmlPullParser.getName().equals("item")) {
                arrayList = new ArrayList();
            } else if (next == 3 && xmlPullParser.getName().equals("item")) {
                reportedData.addRow(new ReportedData.Row(arrayList));
            } else if (next == 2) {
                String name = xmlPullParser.getName();
                String strNextText = xmlPullParser.nextText();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(strNextText);
                arrayList.add(new ReportedData.Field(name, arrayList3));
                Iterator<ReportedData.Column> it = reportedData.getColumns().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else if (it.next().getVariable().equals(name)) {
                        break;
                    }
                }
                if (!z2) {
                    reportedData.addColumn(new ReportedData.Column(name, name, FormField.Type.text_single));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        this.data = reportedData;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
