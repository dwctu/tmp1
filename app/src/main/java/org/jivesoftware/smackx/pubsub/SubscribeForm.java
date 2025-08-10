package org.jivesoftware.smackx.pubsub;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UnknownFormatConversionException;
import org.jivesoftware.smackx.xdata.Form;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.util.XmppDateTime;

/* loaded from: classes5.dex */
public class SubscribeForm extends Form {
    public SubscribeForm(DataForm dataForm) {
        super(dataForm);
    }

    private void addField(SubscribeOptionFields subscribeOptionFields, FormField.Type type) {
        String fieldName = subscribeOptionFields.getFieldName();
        if (getField(fieldName) == null) {
            FormField formField = new FormField(fieldName);
            formField.setType(type);
            addField(formField);
        }
    }

    private String getFieldValue(SubscribeOptionFields subscribeOptionFields) {
        return getField(subscribeOptionFields.getFieldName()).getValues().get(0);
    }

    private List<String> getFieldValues(SubscribeOptionFields subscribeOptionFields) {
        return getField(subscribeOptionFields.getFieldName()).getValues();
    }

    private static boolean parseBoolean(String str) {
        return "1".equals(str) || "true".equals(str);
    }

    public int getDigestFrequency() {
        return Integer.parseInt(getFieldValue(SubscribeOptionFields.digest_frequency));
    }

    public Date getExpiry() {
        String fieldValue = getFieldValue(SubscribeOptionFields.expire);
        try {
            return XmppDateTime.parseDate(fieldValue);
        } catch (ParseException e) {
            UnknownFormatConversionException unknownFormatConversionException = new UnknownFormatConversionException(fieldValue);
            unknownFormatConversionException.initCause(e);
            throw unknownFormatConversionException;
        }
    }

    public List<PresenceState> getShowValues() {
        ArrayList arrayList = new ArrayList(5);
        Iterator<String> it = getFieldValues(SubscribeOptionFields.show_values).iterator();
        while (it.hasNext()) {
            arrayList.add(PresenceState.valueOf(it.next()));
        }
        return arrayList;
    }

    public boolean isDeliverOn() {
        return parseBoolean(getFieldValue(SubscribeOptionFields.deliver));
    }

    public boolean isDigestOn() {
        return parseBoolean(getFieldValue(SubscribeOptionFields.digest));
    }

    public boolean isIncludeBody() {
        return parseBoolean(getFieldValue(SubscribeOptionFields.include_body));
    }

    public void setDeliverOn(boolean z) {
        SubscribeOptionFields subscribeOptionFields = SubscribeOptionFields.deliver;
        addField(subscribeOptionFields, FormField.Type.bool);
        setAnswer(subscribeOptionFields.getFieldName(), z);
    }

    public void setDigestFrequency(int i) {
        SubscribeOptionFields subscribeOptionFields = SubscribeOptionFields.digest_frequency;
        addField(subscribeOptionFields, FormField.Type.text_single);
        setAnswer(subscribeOptionFields.getFieldName(), i);
    }

    public void setDigestOn(boolean z) {
        SubscribeOptionFields subscribeOptionFields = SubscribeOptionFields.deliver;
        addField(subscribeOptionFields, FormField.Type.bool);
        setAnswer(subscribeOptionFields.getFieldName(), z);
    }

    public void setExpiry(Date date) {
        SubscribeOptionFields subscribeOptionFields = SubscribeOptionFields.expire;
        addField(subscribeOptionFields, FormField.Type.text_single);
        setAnswer(subscribeOptionFields.getFieldName(), XmppDateTime.formatXEP0082Date(date));
    }

    public void setIncludeBody(boolean z) {
        SubscribeOptionFields subscribeOptionFields = SubscribeOptionFields.include_body;
        addField(subscribeOptionFields, FormField.Type.bool);
        setAnswer(subscribeOptionFields.getFieldName(), z);
    }

    public void setShowValues(Collection<PresenceState> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<PresenceState> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        SubscribeOptionFields subscribeOptionFields = SubscribeOptionFields.show_values;
        addField(subscribeOptionFields, FormField.Type.list_multi);
        setAnswer(subscribeOptionFields.getFieldName(), arrayList);
    }

    public SubscribeForm(Form form) {
        super(form.getDataFormToSend());
    }

    public SubscribeForm(DataForm.Type type) {
        super(type);
    }
}
