package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.wear.adapter.longdistance.EmojisAdapter;
import com.wear.adapter.longdistance.EmojisFavoriteAdapter;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.bean.TestValue;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.ext.ActivityKt;
import com.wear.main.longDistance.EmojisManagerActivity;
import com.wear.protocol.EntityChatABean;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.EmojisRecycleView;
import com.wear.widget.EmojisToastView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: EmojisUtils.java */
/* loaded from: classes4.dex */
public class ie3 {
    public static final Integer[] y = {Integer.valueOf(R.drawable.ic_redheart), Integer.valueOf(R.drawable.hearteyes1), Integer.valueOf(R.drawable.smiling1), Integer.valueOf(R.drawable.blowkiss), Integer.valueOf(R.drawable.grinning1), Integer.valueOf(R.drawable.grinning2), Integer.valueOf(R.drawable.grinning3), Integer.valueOf(R.drawable.beaming), Integer.valueOf(R.drawable.grinning4), Integer.valueOf(R.drawable.grinning5), Integer.valueOf(R.drawable.laughing), Integer.valueOf(R.drawable.tearsjoy1), Integer.valueOf(R.drawable.smiling2), Integer.valueOf(R.drawable.upsidedown), Integer.valueOf(R.drawable.winking1), Integer.valueOf(R.drawable.smiling3), Integer.valueOf(R.drawable.smiling4), Integer.valueOf(R.drawable.starstruck), Integer.valueOf(R.drawable.kissing1), Integer.valueOf(R.drawable.smiling5), Integer.valueOf(R.drawable.kissing2), Integer.valueOf(R.drawable.kissing3), Integer.valueOf(R.drawable.smiling6), Integer.valueOf(R.drawable.savoring), Integer.valueOf(R.drawable.tongue), Integer.valueOf(R.drawable.winking2), Integer.valueOf(R.drawable.zany), Integer.valueOf(R.drawable.squinting), Integer.valueOf(R.drawable.moneymouth), Integer.valueOf(R.drawable.hugging), Integer.valueOf(R.drawable.handover), Integer.valueOf(R.drawable.shushing), Integer.valueOf(R.drawable.thinking), Integer.valueOf(R.drawable.zipper), Integer.valueOf(R.drawable.eyebrow), Integer.valueOf(R.drawable.neutral), Integer.valueOf(R.drawable.expressionless), Integer.valueOf(R.drawable.withoutmouth), Integer.valueOf(R.drawable.smirking), Integer.valueOf(R.drawable.unamused), Integer.valueOf(R.drawable.rollingeyes), Integer.valueOf(R.drawable.grimacing), Integer.valueOf(R.drawable.lying), Integer.valueOf(R.drawable.relieved), Integer.valueOf(R.drawable.pensive), Integer.valueOf(R.drawable.sleepy), Integer.valueOf(R.drawable.drooling), Integer.valueOf(R.drawable.sleeping), Integer.valueOf(R.drawable.mask), Integer.valueOf(R.drawable.thermometer), Integer.valueOf(R.drawable.bandage), Integer.valueOf(R.drawable.nauseated), Integer.valueOf(R.drawable.vomiting), Integer.valueOf(R.drawable.sneezing), Integer.valueOf(R.drawable.hot), Integer.valueOf(R.drawable.cold), Integer.valueOf(R.drawable.woozy), Integer.valueOf(R.drawable.dizzy), Integer.valueOf(R.drawable.exploding), Integer.valueOf(R.drawable.partying), Integer.valueOf(R.drawable.sunglasses), Integer.valueOf(R.drawable.nerd), Integer.valueOf(R.drawable.confused), Integer.valueOf(R.drawable.worried), Integer.valueOf(R.drawable.frowning1), Integer.valueOf(R.drawable.openmouth), Integer.valueOf(R.drawable.hushed), Integer.valueOf(R.drawable.astonished), Integer.valueOf(R.drawable.flushed), Integer.valueOf(R.drawable.pleading), Integer.valueOf(R.drawable.frowning2), Integer.valueOf(R.drawable.anguished), Integer.valueOf(R.drawable.fearful), Integer.valueOf(R.drawable.anxious), Integer.valueOf(R.drawable.sad), Integer.valueOf(R.drawable.crying1), Integer.valueOf(R.drawable.crying2), Integer.valueOf(R.drawable.screaming), Integer.valueOf(R.drawable.confounded), Integer.valueOf(R.drawable.persevering), Integer.valueOf(R.drawable.disappointed), Integer.valueOf(R.drawable.downcast), Integer.valueOf(R.drawable.weary), Integer.valueOf(R.drawable.tired), Integer.valueOf(R.drawable.yawning), Integer.valueOf(R.drawable.steamnose), Integer.valueOf(R.drawable.pouting1), Integer.valueOf(R.drawable.symbols), Integer.valueOf(R.drawable.horns1), Integer.valueOf(R.drawable.horns2), Integer.valueOf(R.drawable.skull), Integer.valueOf(R.drawable.poo), Integer.valueOf(R.drawable.alien1), Integer.valueOf(R.drawable.alien2), Integer.valueOf(R.drawable.grinning6), Integer.valueOf(R.drawable.grinning7), Integer.valueOf(R.drawable.tearsjoy2), Integer.valueOf(R.drawable.hearteyes2), Integer.valueOf(R.drawable.wrysmile), Integer.valueOf(R.drawable.kissing), Integer.valueOf(R.drawable.scared), Integer.valueOf(R.drawable.crying3), Integer.valueOf(R.drawable.pouting2), Integer.valueOf(R.drawable.kissmark), Integer.valueOf(R.drawable.letter), Integer.valueOf(R.drawable.arrow), Integer.valueOf(R.drawable.ribbon), Integer.valueOf(R.drawable.sparkling), Integer.valueOf(R.drawable.growing), Integer.valueOf(R.drawable.beating), Integer.valueOf(R.drawable.twohearts), Integer.valueOf(R.drawable.exclamation), Integer.valueOf(R.drawable.broken), Integer.valueOf(R.drawable.heartfire), Integer.valueOf(R.drawable.mending), Integer.valueOf(R.drawable.anger), Integer.valueOf(R.drawable.collision), Integer.valueOf(R.drawable.sweat), Integer.valueOf(R.drawable.dashing), Integer.valueOf(R.drawable.bomb), Integer.valueOf(R.drawable.zzz), Integer.valueOf(R.drawable.waving), Integer.valueOf(R.drawable.back), Integer.valueOf(R.drawable.splayed), Integer.valueOf(R.drawable.ok), Integer.valueOf(R.drawable.victory), Integer.valueOf(R.drawable.crossed), Integer.valueOf(R.drawable.loveyou), Integer.valueOf(R.drawable.honour), Integer.valueOf(R.drawable.callme), Integer.valueOf(R.drawable.left), Integer.valueOf(R.drawable.right), Integer.valueOf(R.drawable.up1), Integer.valueOf(R.drawable.down1), Integer.valueOf(R.drawable.up2), Integer.valueOf(R.drawable.down2), Integer.valueOf(R.drawable.fist1), Integer.valueOf(R.drawable.fist2), Integer.valueOf(R.drawable.fist3), Integer.valueOf(R.drawable.fist4), Integer.valueOf(R.drawable.clapping), Integer.valueOf(R.drawable.openhands), Integer.valueOf(R.drawable.palmsup), Integer.valueOf(R.drawable.handshake), Integer.valueOf(R.drawable.folded), Integer.valueOf(R.drawable.ear), Integer.valueOf(R.drawable.nose), Integer.valueOf(R.drawable.sakura), Integer.valueOf(R.drawable.rose), Integer.valueOf(R.drawable.hibiscus), Integer.valueOf(R.drawable.sunflower), Integer.valueOf(R.drawable.blossom), Integer.valueOf(R.drawable.tulip), Integer.valueOf(R.drawable.grapes), Integer.valueOf(R.drawable.melon), Integer.valueOf(R.drawable.watermelon), Integer.valueOf(R.drawable.tangerine), Integer.valueOf(R.drawable.lemon), Integer.valueOf(R.drawable.banana), Integer.valueOf(R.drawable.pineapple), Integer.valueOf(R.drawable.apple1), Integer.valueOf(R.drawable.apple2), Integer.valueOf(R.drawable.pear), Integer.valueOf(R.drawable.peach), Integer.valueOf(R.drawable.cherries), Integer.valueOf(R.drawable.strawberry), Integer.valueOf(R.drawable.tomato), Integer.valueOf(R.drawable.eggplant), Integer.valueOf(R.drawable.hamburger), Integer.valueOf(R.drawable.pizza), Integer.valueOf(R.drawable.wineglass), Integer.valueOf(R.drawable.cocktail), Integer.valueOf(R.drawable.tropical), Integer.valueOf(R.drawable.beermug), Integer.valueOf(R.drawable.crescent), Integer.valueOf(R.drawable.sun), Integer.valueOf(R.drawable.star), Integer.valueOf(R.drawable.cloud1), Integer.valueOf(R.drawable.cloud2), Integer.valueOf(R.drawable.cloud3), Integer.valueOf(R.drawable.droplet), Integer.valueOf(R.drawable.halloween), Integer.valueOf(R.drawable.christmas), Integer.valueOf(R.drawable.santa), Integer.valueOf(R.drawable.balloon), Integer.valueOf(R.drawable.popper)};
    public he3 j;
    public FrameLayout l;
    public EmojisRecycleView m;
    public FrameLayout n;
    public EmojisRecycleView o;
    public ImageView p;
    public View q;
    public View r;
    public EditText s;
    public Context t;
    public EmojisAdapter u;
    public List v;
    public EmojisFavoriteAdapter w;
    public List<FavoriteEmojisBean> x;
    public String a = "delete";
    public List<String> b = new ArrayList();
    public List<String> c = new ArrayList();
    public Map<String, Bitmap> d = new HashMap();
    public Map<String, Integer> e = new HashMap();
    public Map<String, String> f = new HashMap();
    public Map<String, String> g = new HashMap();
    public int h = 0;
    public m i = null;
    public String k = "RedHeart";

    /* compiled from: EmojisUtils.java */
    public class a implements d7 {
        public final /* synthetic */ String a;

        public a(ie3 ie3Var, String str) {
            this.a = str;
        }

        @Override // dc.d7
        public Bitmap a(i7 i7Var) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            try {
                return BitmapFactory.decodeFile(this.a + File.separator + i7Var.b(), options);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: EmojisUtils.java */
    public class b implements j7<f7> {
        public final /* synthetic */ LottieAnimationView a;
        public final /* synthetic */ FileInputStream b;

        public b(ie3 ie3Var, LottieAnimationView lottieAnimationView, FileInputStream fileInputStream) {
            this.a = lottieAnimationView;
            this.b = fileInputStream;
        }

        @Override // dc.j7
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(f7 f7Var) throws IOException {
            this.a.setComposition(f7Var);
            this.a.r();
            try {
                this.b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: EmojisUtils.java */
    public class c implements Runnable {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<SpannableString> listP = ie3.this.p(this.a);
            if (listP.isEmpty()) {
                return;
            }
            boolean z = false;
            for (SpannableString spannableString : listP) {
                if (ie3.this.f.containsKey(spannableString.toString())) {
                    String strReplace = ie3.this.f.get(spannableString.toString());
                    if (ie3.this.c.contains(strReplace)) {
                        ie3.this.c.remove(strReplace);
                    } else if (ie3.this.c.size() == 7) {
                        ie3.this.c.remove(6);
                    } else if (strReplace.contains(".png")) {
                        strReplace = strReplace.replace(".png", "");
                    }
                    ie3.this.c.add(0, strReplace);
                    z = true;
                }
            }
            if (z) {
                DaoUtils.getTestValueDao().setDataList(TestValueDao.EMOJI_RECENT_KEY, ie3.this.c, TestValueDao.EMOJI_RECENT_TYPE);
            }
        }
    }

    /* compiled from: EmojisUtils.java */
    public class d extends TypeToken<List<String>> {
        public d(ie3 ie3Var) {
        }
    }

    /* compiled from: EmojisUtils.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ie3 ie3Var = ie3.this;
            ie3Var.x(ie3Var.a);
        }
    }

    /* compiled from: EmojisUtils.java */
    public class f implements View.OnClickListener {
        public final /* synthetic */ Context a;

        public f(Context context) {
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.emojis_image_panel) {
                ie3 ie3Var = ie3.this;
                ie3Var.h = 0;
                ie3Var.J();
                ie3.this.n.setVisibility(0);
                ie3.this.l.setVisibility(8);
                ie3.this.q.setBackgroundColor(th4.b(this.a, R.color.chat_emojis_bar_select));
                ie3.this.r.setBackgroundResource(R.color.transparent);
                return;
            }
            if (id != R.id.favorite_image_panel) {
                return;
            }
            ie3 ie3Var2 = ie3.this;
            ie3Var2.h = 1;
            ie3Var2.n.setVisibility(8);
            ie3.this.l.setVisibility(0);
            ie3.this.r.setBackgroundColor(th4.b(this.a, R.color.chat_emojis_bar_select));
            ie3.this.q.setBackgroundResource(R.color.transparent);
        }
    }

    /* compiled from: EmojisUtils.java */
    public class g implements EmojisAdapter.a {
        public g() {
        }

        @Override // com.wear.adapter.longdistance.EmojisAdapter.a
        public void a(String str, int[] iArr) {
            ie3.this.o.g(str, iArr[0], iArr[1]);
        }

        @Override // com.wear.adapter.longdistance.EmojisAdapter.a
        public void b(String str) {
            ie3.this.x(str);
        }
    }

    /* compiled from: EmojisUtils.java */
    public class h extends GridLayoutManager.SpanSizeLookup {
        public h() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return ie3.this.v.get(i) instanceof String ? 1 : 7;
        }
    }

    /* compiled from: EmojisUtils.java */
    public class i extends RecyclerView.ItemDecoration {
        public i(ie3 ie3Var) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            rect.top = ce3.a(view.getContext(), recyclerView.getChildAdapterPosition(view) == 0 ? 20.0f : 0.0f);
            rect.bottom = ce3.a(view.getContext(), view instanceof TextView ? 12.5f : 0.0f);
        }
    }

    /* compiled from: EmojisUtils.java */
    public class j implements EmojisFavoriteAdapter.b {
        public j() {
        }

        @Override // com.wear.adapter.longdistance.EmojisFavoriteAdapter.b
        public void a(FavoriteEmojisBean favoriteEmojisBean) {
            if (TextUtils.equals(favoriteEmojisBean.getId(), he3.a)) {
                pj3.o(ActivityKt.e(), EmojisManagerActivity.class, 545);
            } else {
                if (TextUtils.isEmpty(favoriteEmojisBean.getFileMd5())) {
                    return;
                }
                ie3.this.y(favoriteEmojisBean);
            }
        }

        @Override // com.wear.adapter.longdistance.EmojisFavoriteAdapter.b
        public void b(FavoriteEmojisBean favoriteEmojisBean, int[] iArr) {
            ie3.this.m.f(favoriteEmojisBean, iArr[0], iArr[1]);
        }
    }

    /* compiled from: EmojisUtils.java */
    public class k implements Comparator<Map.Entry<Integer, String>> {
        public k(ie3 ie3Var) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<Integer, String> entry, Map.Entry<Integer, String> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    /* compiled from: EmojisUtils.java */
    public class l implements Runnable {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;

        public l(TextView textView, int i) {
            this.a = textView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getLineCount() > 2) {
                int lineEnd = this.a.getLayout().getLineEnd(1);
                StringBuilder sb = new StringBuilder();
                sb.append((Object) this.a.getText().subSequence(0, lineEnd - 3));
                sb.append("...");
                String string = sb.toString();
                this.a.setText("");
                if (string.indexOf("[") == -1 || string.indexOf("]") == -1) {
                    this.a.setText(string);
                    return;
                }
                List<SpannableString> listQ = ie3.this.q(string, ce3.a(WearUtils.x, this.b), null);
                if (listQ.size() > 0) {
                    for (int i = 0; i < listQ.size(); i++) {
                        SpannableString spannableString = listQ.get(i);
                        if (i != listQ.size() - 1 || ie3.this.D(spannableString.toString()) || spannableString.toString().indexOf("[") == -1 || spannableString.toString().length() >= 14) {
                            this.a.append(spannableString);
                        } else {
                            this.a.append("...");
                        }
                    }
                }
            }
        }
    }

    /* compiled from: EmojisUtils.java */
    public interface m {
        void o2(File file, String str, String str2, String str3);
    }

    public ie3() {
        new ArrayList();
        this.v = new ArrayList();
        this.x = new ArrayList();
        this.b.clear();
        this.d.clear();
        this.f.clear();
        this.g.clear();
        G();
        v();
        H();
        this.j = new he3();
    }

    public static Bitmap h(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Drawable m(Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        return bitmapDrawable;
    }

    public static Bitmap n(Context context, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            return BitmapFactory.decodeResource(context.getResources(), i2);
        }
        Drawable drawable = ContextCompat.getDrawable(context, i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void A() {
    }

    public boolean B(String str) {
        return str.contains("RedHeart_Boom");
    }

    public boolean C(String str, int i2) {
        if (!String.valueOf(str.charAt(i2 - 1)).equals("]") || str.substring(0, i2).lastIndexOf("[") == -1) {
            return false;
        }
        String strSubstring = str.substring(str.substring(0, i2).lastIndexOf("["), i2);
        return (WearUtils.e1(strSubstring) || this.f.get(strSubstring) == null) ? false : true;
    }

    public boolean D(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = this.f.keySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    public Bitmap E(String str) {
        Bitmap bitmapN = this.d.get(str);
        if (bitmapN == null) {
            int iIntValue = 0;
            try {
                iIntValue = this.e.get(str).intValue();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
            if (iIntValue != 0 && (bitmapN = n(MyApplication.N().getApplicationContext(), iIntValue)) != null) {
                this.d.put(str, bitmapN);
            }
        }
        return bitmapN;
    }

    public Bitmap F(String str) {
        String str2 = this.f.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return E(str2);
    }

    public final void G() {
        String next;
        Object obj;
        String next2;
        Object obj2;
        try {
            JSONArray jSONArray = new JSONArray(WearUtils.M1(WearUtils.x.getAssets().open("emojis_list_new.json")));
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    Iterator<String> itKeys = jSONObject.keys();
                    if (itKeys != null && itKeys.hasNext() && (obj2 = jSONObject.get((next2 = itKeys.next()))) != null) {
                        String strReplace = obj2.toString().replace("[mark]", "").replace(".png", "");
                        this.b.add(strReplace.toString());
                        this.f.put(next2, strReplace.toString());
                        this.g.put(strReplace.toString(), next2);
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray(WearUtils.M1(WearUtils.x.getAssets().open("emojis_list_old.json")));
            if (jSONArray2.length() > 0) {
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i3);
                    Iterator<String> itKeys2 = jSONObject2.keys();
                    if (itKeys2 != null && itKeys2.hasNext() && (obj = jSONObject2.get((next = itKeys2.next()))) != null) {
                        String strReplace2 = obj.toString().replace("[mark]", "").replace(".png", "");
                        this.f.put(next, strReplace2.toString());
                        this.g.put(strReplace2.toString(), next);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str = "loadEmojisConfig: " + this.b + this.f + this.g;
    }

    public final void H() {
        List list;
        this.c.clear();
        TestValue existKey = DaoUtils.getTestValueDao().getExistKey(nd3.u(TestValueDao.EMOJI_RECENT_KEY), TestValueDao.EMOJI_RECENT_TYPE);
        if (existKey != null) {
            String strI = WearUtils.e1(existKey.getValue()) ? "" : nd3.i(existKey.getValue());
            if (WearUtils.e1(strI) || (list = (List) WearUtils.A.fromJson(strI, new d(this).getType())) == null || list.isEmpty()) {
                return;
            }
            for (Object obj : list) {
                if (obj.toString().contains(".png")) {
                    list.set(list.indexOf(obj), obj.toString().replace(".png", ""));
                }
            }
            this.c.addAll(list);
        }
    }

    public void I() {
        this.q.performClick();
    }

    public final void J() {
        this.v.clear();
        if (!this.c.isEmpty()) {
            this.v.add(3);
            this.v.addAll(this.c);
        }
        this.v.add(4);
        this.v.addAll(this.b);
        EmojisAdapter emojisAdapter = this.u;
        if (emojisAdapter != null) {
            emojisAdapter.notifyDataSetChanged();
            return;
        }
        this.u = new EmojisAdapter(this.t, this.v, this, new g());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.t, 7);
        gridLayoutManager.setSpanSizeLookup(new h());
        this.o.setLayoutManager(gridLayoutManager);
        this.o.addItemDecoration(new i(this));
        this.o.setAdapter(this.u);
    }

    public void K() {
        this.r.performClick();
        L();
    }

    public final void L() {
        this.x.clear();
        this.x.addAll(he3.g());
        if (this.x.isEmpty() || !TextUtils.equals(this.x.get(0).getId(), he3.a)) {
            FavoriteEmojisBean favoriteEmojisBean = new FavoriteEmojisBean();
            favoriteEmojisBean.setId(he3.a);
            this.x.add(favoriteEmojisBean);
        }
        EmojisFavoriteAdapter emojisFavoriteAdapter = this.w;
        if (emojisFavoriteAdapter != null) {
            emojisFavoriteAdapter.notifyDataSetChanged();
            return;
        }
        this.w = new EmojisFavoriteAdapter(this.t, this.x, new j());
        this.m.setLayoutManager(new GridLayoutManager(this.t, 5));
        this.m.setAdapter(this.w);
    }

    public void M(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return;
        }
        vg3.b().a(new c(str));
    }

    public void N(GridView gridView) {
    }

    public void O(LottieAnimationView lottieAnimationView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("images");
        File file = new File(sb.toString());
        File file2 = new File(str + str2 + "data.json");
        if (file2.exists() && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file2);
                lottieAnimationView.setImageAssetDelegate(new a(this, file.getAbsolutePath()));
                g7.h(fileInputStream, null).f(new b(this, lottieAnimationView, fileInputStream));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final List<Integer> g(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf == -1) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(iIndexOf));
            length = iIndexOf + str2.length();
        }
    }

    public void i(TextView textView, String str) {
        j(textView, str, 22);
    }

    public void j(TextView textView, String str, int i2) {
        textView.setText("");
        if (WearUtils.e1(str)) {
            return;
        }
        if (str.indexOf("[") == -1 || str.indexOf("]") == -1) {
            textView.setText(str);
            return;
        }
        List<SpannableString> listQ = q(str, ce3.a(WearUtils.x, i2), null);
        if (listQ.size() > 0) {
            Iterator<SpannableString> it = listQ.iterator();
            while (it.hasNext()) {
                textView.append(it.next());
            }
        }
    }

    public void k(TextView textView, String str, int i2, List<EntityChatABean> list) {
        textView.setText("");
        if (WearUtils.e1(str)) {
            return;
        }
        if (!(str.contains("[") && str.contains("]")) && (list == null || list.size() <= 0)) {
            textView.setText(str);
            return;
        }
        List<SpannableString> listQ = q(str, ce3.a(WearUtils.x, i2), list);
        if (listQ.size() > 0) {
            Iterator<SpannableString> it = listQ.iterator();
            while (it.hasNext()) {
                textView.append((SpannableString) it.next());
            }
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        SpannableString spannableString = new SpannableString(textView.getText());
        for (EntityChatABean entityChatABean : list) {
            String str2 = "@" + entityChatABean.getNickName() + " ";
            for (Integer num : g(spannableString.toString(), str2)) {
                spannableString.setSpan(new gf3(str2, entityChatABean.jid), num.intValue(), num.intValue() + str2.length(), 33);
            }
        }
        textView.setText(spannableString);
    }

    public void l(TextView textView, String str, int i2) {
        textView.setText("");
        if (!WearUtils.e1(str)) {
            if (str.indexOf("[") == -1 || str.indexOf("]") == -1) {
                textView.setText(str);
            } else {
                List<SpannableString> listQ = q(str, ce3.a(WearUtils.x, i2), null);
                listQ.size();
                if (listQ.size() > 0) {
                    Iterator<SpannableString> it = listQ.iterator();
                    while (it.hasNext()) {
                        textView.append(it.next());
                    }
                }
            }
        }
        textView.post(new l(textView, i2));
    }

    public void o(int i2, List<String> list, List<FavoriteEmojisBean> list2) {
    }

    public List<SpannableString> p(String str) {
        return q(str, ce3.a(WearUtils.x, 22.0f), null);
    }

    public List<SpannableString> q(String str, int i2, List<EntityChatABean> list) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (String str2 : this.f.keySet()) {
            List<Integer> listG = g(str, str2);
            if (listG.size() > 0) {
                map.put(str2, listG);
            }
        }
        if (map.size() > 0) {
            TreeMap treeMap = new TreeMap();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    treeMap.put(Integer.valueOf(((Integer) it.next()).intValue()), str3);
                }
            }
            if (treeMap.size() > 0) {
                ArrayList<Map.Entry> arrayList2 = new ArrayList(treeMap.entrySet());
                Collections.sort(arrayList2, new k(this));
                int length = 0;
                for (Map.Entry entry2 : arrayList2) {
                    int iIntValue = ((Integer) entry2.getKey()).intValue();
                    String str4 = (String) entry2.getValue();
                    if (length != iIntValue) {
                        arrayList.add(new SpannableString(str.substring(length, iIntValue)));
                        if (E(this.f.get(str4)) != null) {
                            tn3 tn3Var = new tn3(this.t, m(h(E(this.f.get(str4)), i2, i2)), 2, 2);
                            SpannableString spannableString = new SpannableString(str4);
                            spannableString.setSpan(tn3Var, 0, str4.length(), 33);
                            arrayList.add(spannableString);
                        } else {
                            arrayList.add(new SpannableString(str4));
                        }
                    } else if (E(this.f.get(str4)) != null) {
                        tn3 tn3Var2 = new tn3(this.t, m(h(E(this.f.get(str4)), i2, i2)), 2, 2);
                        SpannableString spannableString2 = new SpannableString(str4);
                        spannableString2.setSpan(tn3Var2, 0, str4.length(), 33);
                        arrayList.add(spannableString2);
                    } else {
                        arrayList.add(new SpannableString(str4));
                    }
                    length = str4.length() + iIntValue;
                }
                if (length < str.length()) {
                    arrayList.add(new SpannableString(str.substring(length, str.length())));
                }
            }
        } else {
            arrayList.add(new SpannableString(str));
        }
        return arrayList;
    }

    public File r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strReplace = str.replace("[", "").replace("]", "");
        StringBuilder sb = new StringBuilder();
        sb.append("emojis_anim");
        String str2 = File.separator;
        sb.append(str2);
        sb.append("big_emojis");
        sb.append(str2);
        sb.append(strReplace);
        sb.append(".png");
        return WearUtils.e0(sb.toString());
    }

    public String s(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<SpannableString> listP = p(str);
        if (listP.size() != 1) {
            return null;
        }
        String string = listP.get(0).toString();
        if (!this.f.containsKey(string)) {
            return null;
        }
        String strReplace = string.replace("[", "").replace("]", "");
        StringBuilder sb = new StringBuilder();
        sb.append("emojis_anim");
        sb.append(File.separator);
        sb.append(strReplace);
        sb.append(z ? "_Boom" : "");
        File fileE0 = WearUtils.e0(sb.toString());
        if (fileE0.exists()) {
            return fileE0.getAbsolutePath();
        }
        return null;
    }

    public String t(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        str.hashCode();
        switch (str) {
            case "[Smiling1]":
                return "33";
            case "[BlowKiss]":
                return "34";
            case "[HeartEyes1]":
                return "32";
            case "[RedHeart]":
                return z ? "35" : "31";
            default:
                return "0";
        }
    }

    public String u(String str) {
        return (WearUtils.e1(str) || WearUtils.e1(this.g.get(str))) ? "" : this.g.get(str);
    }

    public final void v() {
        int i2 = 0;
        while (true) {
            Integer[] numArr = y;
            if (i2 >= numArr.length) {
                String str = "initEmojisDrawableResource: " + this.e.toString();
                return;
            }
            this.e.put(this.b.get(i2), numArr[i2]);
            i2++;
        }
    }

    public void w(Context context, m mVar, View view, EditText editText, EmojisToastView emojisToastView) {
        this.i = mVar;
        this.t = context;
        this.s = editText;
        this.l = (FrameLayout) view.findViewById(R.id.fl_favorite);
        EmojisRecycleView emojisRecycleView = (EmojisRecycleView) view.findViewById(R.id.rv_favorite_emojis);
        this.m = emojisRecycleView;
        emojisRecycleView.a(emojisToastView);
        emojisRecycleView.b(this);
        emojisRecycleView.e(1);
        L();
        this.n = (FrameLayout) view.findViewById(R.id.fl_emojis);
        EmojisRecycleView emojisRecycleView2 = (EmojisRecycleView) view.findViewById(R.id.rv_emojis);
        this.o = emojisRecycleView2;
        emojisRecycleView2.a(emojisToastView);
        emojisRecycleView2.b(this);
        emojisRecycleView2.e(0);
        J();
        ImageView imageView = (ImageView) view.findViewById(R.id.emojis_delete_btn);
        this.p = imageView;
        imageView.setOnClickListener(new e());
        this.q = view.findViewById(R.id.emojis_image_panel);
        View viewFindViewById = view.findViewById(R.id.favorite_image_panel);
        this.r = viewFindViewById;
        if (context instanceof ControlLinkChatActivity) {
            viewFindViewById.setVisibility(8);
        }
        f fVar = new f(context);
        this.q.setOnClickListener(fVar);
        this.r.setOnClickListener(fVar);
        I();
        List<FavoriteEmojisBean> list = WearUtils.E;
        if (list == null || list.size() != 0) {
            return;
        }
        re3.m();
    }

    public void x(String str) {
        System.out.println(str);
        if (WearUtils.e1(str)) {
            return;
        }
        if (str.equals(this.a)) {
            this.s.onKeyDown(67, new KeyEvent(0, 67));
        } else if (E(this.f.get(str)) != null) {
            z(E(this.f.get(str)), str);
        }
    }

    public void y(FavoriteEmojisBean favoriteEmojisBean) {
        this.i.o2(new File(WearUtils.Y(), WearUtils.r0(favoriteEmojisBean.getId())), "emoji", favoriteEmojisBean.getFileMd5(), WearUtils.r0(favoriteEmojisBean.getId()));
    }

    public void z(Bitmap bitmap, String str) {
        if (this.s != null) {
            int iA = ce3.a(WearUtils.x, 22.0f);
            tn3 tn3Var = new tn3(this.t, m(h(bitmap, iA, iA)), 2, 2);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(tn3Var, 0, str.length(), 33);
            int selectionStart = this.s.getSelectionStart();
            Editable editableText = this.s.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) spannableString);
            } else {
                editableText.insert(selectionStart, spannableString);
            }
            WearUtils.x.q("chat_emoji", null);
        }
    }
}
