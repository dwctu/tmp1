package org.jivesoftware.smackx.muc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.xdata.Form;
import org.jivesoftware.smackx.xdata.FormField;

/* loaded from: classes5.dex */
public class RoomInfo {
    private static final Logger LOGGER = Logger.getLogger(RoomInfo.class.getName());
    private final List<String> contactJid;
    private final String description;
    private final Form form;
    private final String lang;
    private final String ldapgroup;
    private final URL logs;
    private final int maxhistoryfetch;
    private final boolean membersOnly;
    private final boolean moderated;
    private final String name;
    private final boolean nonanonymous;
    private final int occupantsCount;
    private final boolean passwordProtected;
    private final boolean persistent;
    private final String pubsub;
    private final String room;
    private final String subject;
    private final Boolean subjectmod;

    public RoomInfo(DiscoverInfo discoverInfo) throws NumberFormatException {
        String str;
        String str2;
        Boolean boolValueOf;
        URL url;
        String str3;
        String str4;
        int i;
        String str5;
        FormField field;
        this.room = discoverInfo.getFrom();
        this.membersOnly = discoverInfo.containsFeature("muc_membersonly");
        this.moderated = discoverInfo.containsFeature("muc_moderated");
        this.nonanonymous = discoverInfo.containsFeature("muc_nonanonymous");
        this.passwordProtected = discoverInfo.containsFeature("muc_passwordprotected");
        this.persistent = discoverInfo.containsFeature("muc_persistent");
        List<DiscoverInfo.Identity> identities = discoverInfo.getIdentities();
        String str6 = "";
        if (identities.isEmpty()) {
            LOGGER.warning("DiscoverInfo does not contain any Identity: " + ((Object) discoverInfo.toXML()));
            this.name = "";
        } else {
            this.name = identities.get(0).getName();
        }
        Form formFrom = Form.getFormFrom(discoverInfo);
        this.form = formFrom;
        int i2 = -1;
        List<String> list = null;
        str = null;
        String str7 = null;
        if (formFrom != null) {
            FormField field2 = formFrom.getField("muc#roominfo_description");
            str4 = (field2 == null || field2.getValues().isEmpty()) ? "" : field2.getValues().get(0);
            FormField field3 = formFrom.getField("muc#roominfo_subject");
            if (field3 != null && !field3.getValues().isEmpty()) {
                str6 = field3.getValues().get(0);
            }
            FormField field4 = formFrom.getField("muc#roominfo_occupants");
            int i3 = (field4 == null || field4.getValues().isEmpty()) ? -1 : Integer.parseInt(field4.getValues().get(0));
            FormField field5 = formFrom.getField("muc#maxhistoryfetch");
            if (field5 != null && !field5.getValues().isEmpty()) {
                i2 = Integer.parseInt(field5.getValues().get(0));
            }
            FormField field6 = formFrom.getField("muc#roominfo_contactjid");
            List<String> values = (field6 == null || field6.getValues().isEmpty()) ? null : field6.getValues();
            FormField field7 = formFrom.getField("muc#roominfo_lang");
            str = (field7 == null || field7.getValues().isEmpty()) ? null : field7.getValues().get(0);
            FormField field8 = formFrom.getField("muc#roominfo_ldapgroup");
            str2 = (field8 == null || field8.getValues().isEmpty()) ? null : field8.getValues().get(0);
            FormField field9 = formFrom.getField("muc#roominfo_subjectmod");
            boolValueOf = (field9 == null || field9.getValues().isEmpty()) ? null : Boolean.valueOf(field9.getValues().get(0));
            FormField field10 = formFrom.getField("muc#roominfo_logs");
            if (field10 == null || field10.getValues().isEmpty()) {
                url = null;
                field = this.form.getField("muc#roominfo_pubsub");
                if (field != null && !field.getValues().isEmpty()) {
                    str7 = field.getValues().get(0);
                }
                i = i2;
                str3 = str6;
                i2 = i3;
                str5 = str7;
                list = values;
            } else {
                try {
                    url = new URL(field10.getValues().get(0));
                } catch (MalformedURLException e) {
                    LOGGER.log(Level.SEVERE, "Could not parse URL", (Throwable) e);
                }
                field = this.form.getField("muc#roominfo_pubsub");
                if (field != null) {
                    str7 = field.getValues().get(0);
                }
                i = i2;
                str3 = str6;
                i2 = i3;
                str5 = str7;
                list = values;
            }
        } else {
            str = null;
            str2 = null;
            boolValueOf = null;
            url = null;
            str3 = "";
            str4 = str3;
            i = -1;
            str5 = null;
        }
        this.description = str4;
        this.subject = str3;
        this.occupantsCount = i2;
        this.maxhistoryfetch = i;
        this.contactJid = list;
        this.lang = str;
        this.ldapgroup = str2;
        this.subjectmod = boolValueOf;
        this.logs = url;
        this.pubsub = str5;
    }

    public List<String> getContactJids() {
        return this.contactJid;
    }

    public String getDescription() {
        return this.description;
    }

    public Form getForm() {
        return this.form;
    }

    public String getLang() {
        return this.lang;
    }

    public String getLdapGroup() {
        return this.ldapgroup;
    }

    public URL getLogsUrl() {
        return this.logs;
    }

    public int getMaxHistoryFetch() {
        return this.maxhistoryfetch;
    }

    public String getName() {
        return this.name;
    }

    public int getOccupantsCount() {
        return this.occupantsCount;
    }

    public String getPubSub() {
        return this.pubsub;
    }

    public String getRoom() {
        return this.room;
    }

    public String getSubject() {
        return this.subject;
    }

    public boolean isMembersOnly() {
        return this.membersOnly;
    }

    public boolean isModerated() {
        return this.moderated;
    }

    public boolean isNonanonymous() {
        return this.nonanonymous;
    }

    public boolean isPasswordProtected() {
        return this.passwordProtected;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public Boolean isSubjectModifiable() {
        return this.subjectmod;
    }
}
