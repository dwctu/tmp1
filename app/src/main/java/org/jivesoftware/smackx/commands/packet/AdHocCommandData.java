package org.jivesoftware.smackx.commands.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.AdHocCommandNote;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* loaded from: classes5.dex */
public class AdHocCommandData extends IQ {
    public static final String ELEMENT = "command";
    public static final String NAMESPACE = "http://jabber.org/protocol/commands";
    private AdHocCommand.Action action;
    private ArrayList<AdHocCommand.Action> actions;
    private AdHocCommand.Action executeAction;
    private DataForm form;
    private String id;
    private String name;
    private String node;
    private List<AdHocCommandNote> notes;
    private String sessionID;
    private AdHocCommand.Status status;

    public static class SpecificError implements ExtensionElement {
        public static final String namespace = "http://jabber.org/protocol/commands";
        public AdHocCommand.SpecificErrorCondition condition;

        public SpecificError(AdHocCommand.SpecificErrorCondition specificErrorCondition) {
            this.condition = specificErrorCondition;
        }

        public AdHocCommand.SpecificErrorCondition getCondition() {
            return this.condition;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return this.condition.toString();
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return "http://jabber.org/protocol/commands";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML() {
            return SimpleComparison.LESS_THAN_OPERATION + getElementName() + " xmlns=\"" + getNamespace() + "\"/>";
        }
    }

    public AdHocCommandData() {
        super("command", "http://jabber.org/protocol/commands");
        this.notes = new ArrayList();
        this.actions = new ArrayList<>();
    }

    public void addAction(AdHocCommand.Action action) {
        this.actions.add(action);
    }

    public void addNote(AdHocCommandNote adHocCommandNote) {
        this.notes.add(adHocCommandNote);
    }

    public AdHocCommand.Action getAction() {
        return this.action;
    }

    public List<AdHocCommand.Action> getActions() {
        return this.actions;
    }

    public AdHocCommand.Action getExecuteAction() {
        return this.executeAction;
    }

    public DataForm getForm() {
        return this.form;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("node", this.node);
        iQChildElementXmlStringBuilder.optAttribute("sessionid", this.sessionID);
        iQChildElementXmlStringBuilder.optAttribute("status", this.status);
        iQChildElementXmlStringBuilder.optAttribute(AMPExtension.Action.ATTRIBUTE_NAME, this.action);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (getType() == IQ.Type.result) {
            iQChildElementXmlStringBuilder.halfOpenElement("actions");
            iQChildElementXmlStringBuilder.optAttribute("execute", this.executeAction);
            if (this.actions.size() == 0) {
                iQChildElementXmlStringBuilder.closeEmptyElement();
            } else {
                iQChildElementXmlStringBuilder.rightAngleBracket();
                Iterator<AdHocCommand.Action> it = this.actions.iterator();
                while (it.hasNext()) {
                    iQChildElementXmlStringBuilder.emptyElement(it.next());
                }
                iQChildElementXmlStringBuilder.closeElement("actions");
            }
        }
        DataForm dataForm = this.form;
        if (dataForm != null) {
            iQChildElementXmlStringBuilder.append(dataForm.toXML());
        }
        for (AdHocCommandNote adHocCommandNote : this.notes) {
            iQChildElementXmlStringBuilder.halfOpenElement("note").attribute("type", adHocCommandNote.getType().toString()).rightAngleBracket();
            iQChildElementXmlStringBuilder.append((CharSequence) adHocCommandNote.getValue());
            iQChildElementXmlStringBuilder.closeElement("note");
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNode() {
        return this.node;
    }

    public List<AdHocCommandNote> getNotes() {
        return this.notes;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public AdHocCommand.Status getStatus() {
        return this.status;
    }

    public void remveNote(AdHocCommandNote adHocCommandNote) {
        this.notes.remove(adHocCommandNote);
    }

    public void setAction(AdHocCommand.Action action) {
        this.action = action;
    }

    public void setExecuteAction(AdHocCommand.Action action) {
        this.executeAction = action;
    }

    public void setForm(DataForm dataForm) {
        this.form = dataForm;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNode(String str) {
        this.node = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setStatus(AdHocCommand.Status status) {
        this.status = status;
    }
}
