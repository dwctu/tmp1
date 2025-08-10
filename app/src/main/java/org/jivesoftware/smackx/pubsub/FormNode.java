package org.jivesoftware.smackx.pubsub;

import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.text.Typography;
import org.jivesoftware.smackx.xdata.Form;

/* loaded from: classes5.dex */
public class FormNode extends NodeExtension {
    private Form configForm;

    public FormNode(FormNodeType formNodeType, Form form) {
        super(formNodeType.getNodeElement());
        if (form == null) {
            throw new IllegalArgumentException("Submit form cannot be null");
        }
        this.configForm = form;
    }

    public Form getForm() {
        return this.configForm;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public CharSequence toXML() {
        if (this.configForm == null) {
            return super.toXML();
        }
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        if (getNode() != null) {
            sb.append(" node='");
            sb.append(getNode());
            sb.append("'>");
        } else {
            sb.append(Typography.greater);
        }
        sb.append((CharSequence) this.configForm.getDataFormToSend().toXML());
        sb.append("</");
        sb.append(getElementName() + Typography.greater);
        return sb.toString();
    }

    public FormNode(FormNodeType formNodeType, String str, Form form) {
        super(formNodeType.getNodeElement(), str);
        if (form != null) {
            this.configForm = form;
            return;
        }
        throw new IllegalArgumentException("Submit form cannot be null");
    }
}
