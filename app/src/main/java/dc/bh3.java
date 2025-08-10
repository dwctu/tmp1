package dc;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.wear.protocol.MessageType;
import java.lang.reflect.Type;

/* compiled from: UserMessageTypeEnumSerializer.java */
/* loaded from: classes4.dex */
public class bh3 implements JsonSerializer<MessageType>, JsonDeserializer<MessageType> {
    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return MessageType.fromString(jsonElement.getAsString());
    }

    @Override // com.google.gson.JsonSerializer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JsonElement serialize(MessageType messageType, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(messageType.toString());
    }
}
