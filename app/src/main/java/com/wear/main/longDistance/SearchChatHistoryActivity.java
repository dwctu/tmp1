package com.wear.main.longDistance;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.database.annotations.NotNull;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.SearchChatHistoryAdapter;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityChat;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.cg3;
import dc.nv1;
import dc.pj3;
import dc.ue3;
import dc.ye3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class SearchChatHistoryActivity extends BaseActivity {
    public String a;
    public String b;
    public String c;
    public boolean d;
    public String e;

    @BindView(R.id.et_search)
    public EditText et_search;
    public List<CommunMessage> f = new ArrayList();
    public SearchChatHistoryAdapter g;
    public Disposable h;

    @BindView(R.id.iv_delete)
    public ImageView iv_delete;

    @BindView(R.id.ll_search_category)
    public LinearLayout ll_search_category;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @BindView(R.id.tv_no_result)
    public TextView tv_no_result;

    public class a extends nv1 {
        public a() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                SearchChatHistoryActivity.this.iv_delete.setVisibility(8);
                SearchChatHistoryActivity.this.ll_search_category.setVisibility(0);
                SearchChatHistoryActivity.this.f.clear();
                SearchChatHistoryActivity.this.g.notifyDataSetChanged();
                if (SearchChatHistoryActivity.this.h != null && !SearchChatHistoryActivity.this.h.isDisposed()) {
                    SearchChatHistoryActivity.this.h.dispose();
                }
            } else {
                SearchChatHistoryActivity.this.iv_delete.setVisibility(0);
                SearchChatHistoryActivity.this.ll_search_category.setVisibility(8);
                if (!TextUtils.isEmpty(editable.toString().trim())) {
                    SearchChatHistoryActivity.this.D4();
                }
            }
            if (SearchChatHistoryActivity.this.tv_no_result.getVisibility() == 0) {
                SearchChatHistoryActivity.this.tv_no_result.setVisibility(8);
            }
            if (SearchChatHistoryActivity.this.recyclerView.getVisibility() == 0) {
                SearchChatHistoryActivity.this.recyclerView.setVisibility(8);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 1) {
                return false;
            }
            SearchChatHistoryActivity searchChatHistoryActivity = SearchChatHistoryActivity.this;
            ue3.a(searchChatHistoryActivity.et_search, searchChatHistoryActivity);
            SearchChatHistoryActivity.this.D4();
            return false;
        }
    }

    public class c implements SearchChatHistoryAdapter.a {
        public c() {
        }

        @Override // com.wear.adapter.longdistance.SearchChatHistoryAdapter.a
        public void c(CommunMessage communMessage) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("searchMessage", communMessage);
            if (SearchChatHistoryActivity.this.d) {
                bundle.putString("roomId", SearchChatHistoryActivity.this.c);
                pj3.g(SearchChatHistoryActivity.this, ChatRoomActivity.class, bundle);
            } else {
                bundle.putString("userId", SearchChatHistoryActivity.this.a);
                pj3.g(SearchChatHistoryActivity.this, ChatActivity.class, bundle);
            }
        }
    }

    public class d implements Consumer<List<CommunMessage>> {
        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<CommunMessage> list) throws Exception {
            SearchChatHistoryActivity.this.dissDialog();
            SearchChatHistoryActivity.this.f.clear();
            SearchChatHistoryActivity.this.f.addAll(list);
            SearchChatHistoryActivity.this.g.n(SearchChatHistoryActivity.this.e);
            SearchChatHistoryActivity.this.g.notifyDataSetChanged();
            SearchChatHistoryActivity searchChatHistoryActivity = SearchChatHistoryActivity.this;
            searchChatHistoryActivity.recyclerView.setVisibility(searchChatHistoryActivity.f.isEmpty() ? 8 : 0);
            SearchChatHistoryActivity searchChatHistoryActivity2 = SearchChatHistoryActivity.this;
            searchChatHistoryActivity2.tv_no_result.setVisibility(searchChatHistoryActivity2.f.isEmpty() ? 0 : 8);
        }
    }

    public class e implements Function<Long, ObservableSource<List<CommunMessage>>> {

        public class a implements ObservableOnSubscribe<List<CommunMessage>> {
            public a() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(@NotNull ObservableEmitter<List<CommunMessage>> observableEmitter) throws Exception {
                List<CommunMessage> listFindByMsgType = !SearchChatHistoryActivity.this.d ? DaoUtils.getCommunMessageDao().findByMsgType(WearUtils.y.p(), SearchChatHistoryActivity.this.b, MessageType.chat) : DaoUtils.getCommunMessageDao().findByMsgType(WearUtils.y.p(), WearUtils.k0(SearchChatHistoryActivity.this.c), MessageType.chat);
                List<CommunMessage> arrayList = new ArrayList<>();
                if (listFindByMsgType != null && !listFindByMsgType.isEmpty()) {
                    for (CommunMessage communMessage : listFindByMsgType) {
                        EntityChat entityChat = (EntityChat) communMessage.syncDecryptBean();
                        communMessage.setDataBean(entityChat);
                        if (entityChat.getText().toLowerCase().contains(SearchChatHistoryActivity.this.e)) {
                            arrayList.add(communMessage);
                        }
                    }
                }
                observableEmitter.onNext(arrayList);
            }
        }

        public e() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<List<CommunMessage>> apply(@org.jetbrains.annotations.NotNull Long l) throws Exception {
            return Observable.create(new a());
        }
    }

    public final void B4(String str) {
        HashMap map = new HashMap();
        map.put("chat_type", this.d ? "2" : "1");
        map.put("type", str);
        ye3.e("M0041", map);
    }

    public final void C4() {
        this.et_search.addTextChangedListener(new a());
        this.et_search.setOnKeyListener(new b());
        List<CommunMessage> list = this.f;
        boolean z = this.d;
        SearchChatHistoryAdapter searchChatHistoryAdapter = new SearchChatHistoryAdapter(this, list, z ? this.c : this.a, z, new c());
        this.g = searchChatHistoryAdapter;
        cg3.f(this.recyclerView, searchChatHistoryAdapter);
    }

    public final void D4() {
        Disposable disposable = this.h;
        if (disposable != null && !disposable.isDisposed()) {
            this.h.dispose();
        }
        if (TextUtils.isEmpty(this.et_search.getText().toString().trim())) {
            return;
        }
        this.e = this.et_search.getText().toString().trim().toLowerCase();
        this.h = Observable.timer(400L, TimeUnit.MILLISECONDS).flatMap(new e()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        ue3.a(this.et_search, this);
    }

    @OnClick({R.id.iv_delete, R.id.tv_cancel, R.id.ll_category_date, R.id.ll_category_audio, R.id.ll_category_members, R.id.ll_category_photo_and_video})
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        if (this.d) {
            bundle.putString("roomId", this.c);
        } else {
            bundle.putString("userId", this.a);
        }
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.et_search.setText("");
        }
        if (id == R.id.tv_cancel) {
            onBackPressed();
            return;
        }
        switch (id) {
            case R.id.ll_category_audio /* 2131363458 */:
                pj3.g(this, SearchChatAudioActivity.class, bundle);
                B4("2");
                break;
            case R.id.ll_category_date /* 2131363459 */:
                pj3.g(this, SearchChatCalendarActivity.class, bundle);
                B4("1");
                break;
            case R.id.ll_category_members /* 2131363460 */:
                pj3.g(this, SearchChatUserActivity.class, bundle);
                B4(ExifInterface.GPS_MEASUREMENT_3D);
                break;
            case R.id.ll_category_photo_and_video /* 2131363461 */:
                pj3.g(this, SearchChatMediaActivity.class, bundle);
                B4("4");
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_chat_history);
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            String string = getIntent().getExtras().getString("userId");
            this.a = string;
            this.b = WearUtils.i0(string);
            this.c = getIntent().getExtras().getString("roomId");
            this.d = !TextUtils.isEmpty(r2);
        }
        C4();
    }
}
