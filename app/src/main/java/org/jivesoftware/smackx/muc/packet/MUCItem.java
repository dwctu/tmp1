package org.jivesoftware.smackx.muc.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.muc.MUCRole;
import org.jivesoftware.smackx.nick.packet.Nick;

/* loaded from: classes5.dex */
public class MUCItem implements NamedElement {
    public static final String ELEMENT = "item";
    private final String actor;
    private final MUCAffiliation affiliation;
    private final String binval;
    private final String jid;
    private final String nick;
    private final String reason;
    private final MUCRole role;

    public MUCItem(MUCAffiliation mUCAffiliation) {
        this(mUCAffiliation, null, null, null, null, null, null);
    }

    public String getActor() {
        return this.actor;
    }

    public MUCAffiliation getAffiliation() {
        return this.affiliation;
    }

    public String getBinval() {
        return this.binval;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "item";
    }

    public String getJid() {
        return this.jid;
    }

    public String getNick() {
        return this.nick;
    }

    public String getReason() {
        return this.reason;
    }

    public MUCRole getRole() {
        return this.role;
    }

    public MUCItem(MUCRole mUCRole) {
        this(null, mUCRole, null, null, null, null, null);
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
        xmlStringBuilder.optAttribute(FirebaseAnalytics.Param.AFFILIATION, getAffiliation());
        xmlStringBuilder.optAttribute(PSOProgramService.JobID_Key, getJid());
        xmlStringBuilder.optAttribute(Nick.ELEMENT_NAME, getNick());
        xmlStringBuilder.optAttribute("role", getRole());
        xmlStringBuilder.optAttribute("binval", getBinval());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("reason", getReason());
        if (getActor() != null) {
            xmlStringBuilder.halfOpenElement("actor").attribute(PSOProgramService.JobID_Key, getActor()).closeEmptyElement();
        }
        xmlStringBuilder.closeElement("item");
        return xmlStringBuilder;
    }

    public MUCItem(MUCRole mUCRole, String str) {
        this(null, mUCRole, null, null, null, str, null);
    }

    public MUCItem(MUCAffiliation mUCAffiliation, String str, String str2) {
        this(mUCAffiliation, null, null, str2, str, null, null);
    }

    public MUCItem(MUCAffiliation mUCAffiliation, String str) {
        this(mUCAffiliation, null, null, null, str, null, null);
    }

    public MUCItem(MUCRole mUCRole, String str, String str2) {
        this(null, mUCRole, null, str2, null, str, null);
    }

    public MUCItem(MUCAffiliation mUCAffiliation, MUCRole mUCRole, String str, String str2, String str3, String str4, String str5) {
        this.affiliation = mUCAffiliation;
        this.role = mUCRole;
        this.actor = str;
        this.reason = str2;
        this.jid = str3;
        this.nick = str4;
        this.binval = str5;
    }
}
