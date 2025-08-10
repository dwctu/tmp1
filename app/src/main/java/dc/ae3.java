package dc;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.wear.util.WearUtils;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: DateSerializer.java */
/* loaded from: classes4.dex */
public class ae3 implements JsonSerializer<Date>, JsonDeserializer<Date> {
    public DateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
    public DateFormat b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:S");

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            try {
                return this.a.parse(jsonElement.getAsString());
            } catch (ParseException unused) {
                return this.b.parse(jsonElement.getAsString());
            }
        } catch (ParseException unused2) {
            return null;
        }
    }

    @Override // com.google.gson.JsonSerializer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        String str;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:S");
        try {
            str = simpleDateFormat.format(date);
        } catch (Exception unused) {
            str = null;
        }
        if (WearUtils.e1(str)) {
            try {
                str = simpleDateFormat2.format(date);
            } catch (Exception unused2) {
            }
        }
        return new JsonPrimitive(str);
    }
}
