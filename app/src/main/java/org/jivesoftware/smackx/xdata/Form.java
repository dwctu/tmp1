package org.jivesoftware.smackx.xdata;

import com.broadcom.bt.util.io.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* loaded from: classes5.dex */
public class Form {
    private DataForm dataForm;

    /* renamed from: org.jivesoftware.smackx.xdata.Form$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            int[] iArr = new int[FormField.Type.values().length];
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = iArr;
            try {
                iArr[FormField.Type.text_multi.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_private.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_single.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.list_single.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_single.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.hidden.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_multi.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.list_multi.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public Form(DataForm dataForm) {
        this.dataForm = dataForm;
    }

    public static Form getFormFrom(Stanza stanza) {
        DataForm dataFormFrom = DataForm.from(stanza);
        if (dataFormFrom == null || dataFormFrom.getReportedData() != null) {
            return null;
        }
        return new Form(dataFormFrom);
    }

    private boolean isFormType() {
        return DataForm.Type.form == this.dataForm.getType();
    }

    private boolean isSubmitType() {
        return DataForm.Type.submit == this.dataForm.getType();
    }

    private static void validateThatFieldIsText(FormField formField) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[formField.getType().ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalArgumentException("This field is not of type text (multi, private or single).");
        }
    }

    public void addField(FormField formField) {
        this.dataForm.addField(formField);
    }

    public Form createAnswerForm() {
        if (!isFormType()) {
            throw new IllegalStateException("Only forms of type \"form\" could be answered");
        }
        Form form = new Form(DataForm.Type.submit);
        for (FormField formField : getFields()) {
            if (formField.getVariable() != null) {
                FormField formField2 = new FormField(formField.getVariable());
                formField2.setType(formField.getType());
                form.addField(formField2);
                if (formField.getType() == FormField.Type.hidden) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it = formField.getValues().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                    form.setAnswer(formField.getVariable(), arrayList);
                }
            }
        }
        return form;
    }

    public DataForm getDataFormToSend() {
        if (!isSubmitType()) {
            return this.dataForm;
        }
        DataForm dataForm = new DataForm(getType());
        for (FormField formField : getFields()) {
            if (!formField.getValues().isEmpty()) {
                dataForm.addField(formField);
            }
        }
        return dataForm;
    }

    public FormField getField(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Variable must not be null or blank.");
        }
        for (FormField formField : getFields()) {
            if (str.equals(formField.getVariable())) {
                return formField;
            }
        }
        return null;
    }

    public List<FormField> getFields() {
        return this.dataForm.getFields();
    }

    public String getInstructions() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.dataForm.getInstructions().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        return sb.toString();
    }

    public String getTitle() {
        return this.dataForm.getTitle();
    }

    public DataForm.Type getType() {
        return this.dataForm.getType();
    }

    public void setAnswer(String str, String str2) {
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Field not found for the specified variable name.");
        }
        switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[field.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                setAnswer(field, str2);
                return;
            default:
                throw new IllegalArgumentException("This field is not of type String.");
        }
    }

    public void setDefaultAnswer(String str) {
        if (!isSubmitType()) {
            throw new IllegalStateException("Cannot set an answer if the form is not of type \"submit\"");
        }
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Couldn't find a field for the specified variable.");
        }
        field.resetValues();
        Iterator<String> it = field.getValues().iterator();
        while (it.hasNext()) {
            field.addValue(it.next());
        }
    }

    public void setInstructions(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, IOUtils.LINE_SEPARATOR_UNIX);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        this.dataForm.setInstructions(arrayList);
    }

    public void setTitle(String str) {
        this.dataForm.setTitle(str);
    }

    public Form(DataForm.Type type) {
        this.dataForm = new DataForm(type);
    }

    public void setAnswer(String str, int i) {
        FormField field = getField(str);
        if (field != null) {
            validateThatFieldIsText(field);
            setAnswer(field, Integer.valueOf(i));
            return;
        }
        throw new IllegalArgumentException("Field not found for the specified variable name.");
    }

    public void setAnswer(String str, long j) {
        FormField field = getField(str);
        if (field != null) {
            validateThatFieldIsText(field);
            setAnswer(field, Long.valueOf(j));
            return;
        }
        throw new IllegalArgumentException("Field not found for the specified variable name.");
    }

    public void setAnswer(String str, float f) {
        FormField field = getField(str);
        if (field != null) {
            validateThatFieldIsText(field);
            setAnswer(field, Float.valueOf(f));
            return;
        }
        throw new IllegalArgumentException("Field not found for the specified variable name.");
    }

    public void setAnswer(String str, double d) {
        FormField field = getField(str);
        if (field != null) {
            validateThatFieldIsText(field);
            setAnswer(field, Double.valueOf(d));
            return;
        }
        throw new IllegalArgumentException("Field not found for the specified variable name.");
    }

    public void setAnswer(String str, boolean z) {
        FormField field = getField(str);
        if (field != null) {
            if (field.getType() == FormField.Type.bool) {
                setAnswer(field, z ? "1" : "0");
                return;
            }
            throw new IllegalArgumentException("This field is not of type boolean.");
        }
        throw new IllegalArgumentException("Field not found for the specified variable name.");
    }

    private void setAnswer(FormField formField, Object obj) {
        if (isSubmitType()) {
            formField.resetValues();
            formField.addValue(obj.toString());
            return;
        }
        throw new IllegalStateException("Cannot set an answer if the form is not of type \"submit\"");
    }

    public void setAnswer(String str, List<String> list) {
        if (isSubmitType()) {
            FormField field = getField(str);
            if (field != null) {
                int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[field.getType().ordinal()];
                if (i != 1 && i != 4 && i != 6 && i != 7 && i != 8) {
                    throw new IllegalArgumentException("This field only accept list of values.");
                }
                field.resetValues();
                field.addValues(list);
                return;
            }
            throw new IllegalArgumentException("Couldn't find a field for the specified variable.");
        }
        throw new IllegalStateException("Cannot set an answer if the form is not of type \"submit\"");
    }
}
