package dc;

import dc.uc4;
import java.util.Map;
import org.jivesoftware.smack.roster.packet.RosterVer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;
import rx.Observable;

/* compiled from: NetService.java */
/* loaded from: classes3.dex */
public interface sn2 {
    @FormUrlEncoded
    @Headers({"Content-Type:application/x-www-form-urlencoded; charset=utf-8"})
    @POST
    Call<bd4> a(@Url String str, @Header("gtoken") String str2, @Header(RosterVer.ELEMENT) String str3, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @Headers({"Content-Type:application/x-www-form-urlencoded; charset=utf-8"})
    @POST
    Call<bd4> b(@Url String str, @Header("User-Agent") String str2, @FieldMap Map<String, String> map);

    @Headers({"Content-Type:application/json; charset=utf-8"})
    @POST
    Observable<bd4> c(@Url String str, @Body zc4 zc4Var);

    @FormUrlEncoded
    @Headers({"Content-Type:application/x-www-form-urlencoded; charset=utf-8"})
    @POST
    Observable<bd4> d(@Url String str, @FieldMap Map<String, String> map);

    @POST
    Observable<bd4> e(@Url String str, @Body zc4 zc4Var);

    @GET
    Observable<bd4> f(@Url String str);

    @POST
    Observable<bd4> g(@Url String str, @Body uc4 uc4Var);

    @POST
    Observable<bd4> h(@Url String str, @Body zc4 zc4Var);

    @POST
    @Multipart
    Observable<bd4> i(@Url String str, @PartMap Map<String, zc4> map, @Part uc4.b bVar);
}
