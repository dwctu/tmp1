package org.jivesoftware.smack.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.jivesoftware.smack.util.TypedCloneable;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public final class Message extends Stanza implements TypedCloneable<Message> {
    public static final String BODY = "body";
    public static final String ELEMENT = "message";
    private final Set<Body> bodies;
    private String recId;
    private final Set<Subject> subjects;
    private String thread;
    private Type type;

    public static class Body {
        private final String language;
        private final String message;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Body body = (Body) obj;
            return this.language.equals(body.language) && this.message.equals(body.message);
        }

        public String getLanguage() {
            return this.language;
        }

        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return ((this.language.hashCode() + 31) * 31) + this.message.hashCode();
        }

        private Body(String str, String str2) {
            Objects.requireNonNull(str, "Language cannot be null.");
            Objects.requireNonNull(str2, "Message cannot be null.");
            this.language = str;
            this.message = str2;
        }
    }

    public static class Subject {
        private final String language;
        private final String subject;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Subject subject = (Subject) obj;
            return this.language.equals(subject.language) && this.subject.equals(subject.subject);
        }

        public String getLanguage() {
            return this.language;
        }

        public String getSubject() {
            return this.subject;
        }

        public int hashCode() {
            return ((this.language.hashCode() + 31) * 31) + this.subject.hashCode();
        }

        private Subject(String str, String str2) {
            Objects.requireNonNull(str, "Language cannot be null.");
            Objects.requireNonNull(str2, "Subject cannot be null.");
            this.language = str;
            this.subject = str2;
        }
    }

    public enum Type {
        normal,
        chat,
        groupchat,
        headline,
        broad,
        sub,
        offlinemsg,
        error;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public Message() {
        this.thread = null;
        this.subjects = new HashSet();
        this.bodies = new HashSet();
    }

    private String determineLanguage(String str) {
        String str2;
        if ("".equals(str)) {
            str = null;
        }
        return (str != null || (str2 = this.language) == null) ? str == null ? Stanza.getDefaultLanguage() : str : str2;
    }

    private Body getMessageBody(String str) {
        String strDetermineLanguage = determineLanguage(str);
        for (Body body : this.bodies) {
            if (strDetermineLanguage.equals(body.language)) {
                return body;
            }
        }
        return null;
    }

    private Subject getMessageSubject(String str) {
        String strDetermineLanguage = determineLanguage(str);
        for (Subject subject : this.subjects) {
            if (strDetermineLanguage.equals(subject.language)) {
                return subject;
            }
        }
        return null;
    }

    public Body addBody(String str, String str2) {
        Body body = new Body(determineLanguage(str), str2);
        this.bodies.add(body);
        return body;
    }

    public Subject addSubject(String str, String str2) {
        Subject subject = new Subject(determineLanguage(str), str2);
        this.subjects.add(subject);
        return subject;
    }

    public Set<Body> getBodies() {
        return Collections.unmodifiableSet(this.bodies);
    }

    public String getBody() {
        return getBody(null);
    }

    public List<String> getBodyLanguages() {
        Body messageBody = getMessageBody(null);
        ArrayList arrayList = new ArrayList();
        for (Body body : this.bodies) {
            if (!body.equals(messageBody)) {
                arrayList.add(body.language);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String getRecId() {
        return this.recId;
    }

    public String getSubject() {
        return getSubject(null);
    }

    public List<String> getSubjectLanguages() {
        Subject messageSubject = getMessageSubject(null);
        ArrayList arrayList = new ArrayList();
        for (Subject subject : this.subjects) {
            if (!subject.equals(messageSubject)) {
                arrayList.add(subject.language);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(this.subjects);
    }

    public String getThread() {
        return this.thread;
    }

    public Type getType() {
        Type type = this.type;
        return type == null ? Type.normal : type;
    }

    public boolean removeBody(String str) {
        String strDetermineLanguage = determineLanguage(str);
        for (Body body : this.bodies) {
            if (strDetermineLanguage.equals(body.language)) {
                return this.bodies.remove(body);
            }
        }
        return false;
    }

    public boolean removeSubject(String str) {
        String strDetermineLanguage = determineLanguage(str);
        for (Subject subject : this.subjects) {
            if (strDetermineLanguage.equals(subject.language)) {
                return this.subjects.remove(subject);
            }
        }
        return false;
    }

    public void setBody(String str) {
        if (str == null) {
            removeBody("");
        } else {
            addBody(null, str);
        }
    }

    public void setRecId(String str) {
        this.recId = str;
    }

    public void setSubject(String str) {
        if (str == null) {
            removeSubject("");
        } else {
            addSubject(null, str);
        }
    }

    public void setThread(String str) {
        this.thread = str;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override // org.jivesoftware.smack.util.TypedCloneable
    public Message clone() {
        return new Message(this);
    }

    public String getBody(String str) {
        Body messageBody = getMessageBody(str);
        if (messageBody == null) {
            return null;
        }
        return messageBody.message;
    }

    public String getSubject(String str) {
        Subject messageSubject = getMessageSubject(str);
        if (messageSubject == null) {
            return null;
        }
        return messageSubject.subject;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement("message");
        addCommonAttributes(xmlStringBuilder);
        xmlStringBuilder.optAttribute("type", this.type);
        xmlStringBuilder.rightAngleBracket();
        Subject messageSubject = getMessageSubject(null);
        if (messageSubject != null) {
            xmlStringBuilder.element("subject", messageSubject.subject);
        }
        for (Subject subject : getSubjects()) {
            if (!subject.equals(messageSubject)) {
                xmlStringBuilder.halfOpenElement("subject").xmllangAttribute(subject.language).rightAngleBracket();
                xmlStringBuilder.escape(subject.subject);
                xmlStringBuilder.closeElement("subject");
            }
        }
        Body messageBody = getMessageBody(null);
        if (messageBody != null) {
            xmlStringBuilder.element("body", messageBody.message);
        }
        for (Body body : getBodies()) {
            if (!body.equals(messageBody)) {
                xmlStringBuilder.halfOpenElement("body").xmllangAttribute(body.getLanguage()).rightAngleBracket();
                xmlStringBuilder.escape(body.getMessage());
                xmlStringBuilder.closeElement("body");
            }
        }
        xmlStringBuilder.optElement("thread", this.thread);
        if (this.type == Type.error) {
            appendErrorIfExists(xmlStringBuilder);
        }
        xmlStringBuilder.append(getExtensionsXML());
        xmlStringBuilder.closeElement("message");
        return xmlStringBuilder;
    }

    public Message(String str) {
        this.thread = null;
        this.subjects = new HashSet();
        this.bodies = new HashSet();
        setTo(str);
    }

    public boolean removeBody(Body body) {
        return this.bodies.remove(body);
    }

    public boolean removeSubject(Subject subject) {
        return this.subjects.remove(subject);
    }

    public Message(String str, Type type) {
        this(str);
        setType(type);
    }

    public Message(String str, String str2) {
        this(str);
        setBody(str2);
    }

    public Message(Message message) {
        super(message);
        this.thread = null;
        HashSet hashSet = new HashSet();
        this.subjects = hashSet;
        HashSet hashSet2 = new HashSet();
        this.bodies = hashSet2;
        this.type = message.type;
        this.thread = message.thread;
        this.recId = message.recId;
        hashSet.addAll(message.subjects);
        hashSet2.addAll(message.bodies);
    }
}
