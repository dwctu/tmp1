package com.wear.main.longDistance;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.SearchChatAudioAdapter;
import com.wear.bean.Account;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.cg3;
import dc.ch3;
import dc.h12;
import dc.na2;
import dc.nv1;
import dc.pj3;
import dc.so3;
import dc.ue3;
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
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class SearchChatAudioActivity extends BaseActivity {
    public String a;
    public String b;
    public List<IPeopleInfo> c;
    public String d;
    public boolean e;

    @BindView(R.id.et_search)
    public EditText et_search;
    public String f;
    public Disposable g;
    public SearchChatAudioAdapter i;

    @BindView(R.id.iv_delete)
    public ImageView iv_delete;
    public IPeopleInfo j;
    public LinearLayoutManager l;
    public boolean m;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @BindView(R.id.tv_no_result)
    public TextView tv_no_result;
    public List<CommunMessage> h = new ArrayList();
    public so3 k = new so3();
    public int n = 0;
    public int o = 10;

    public class a extends nv1 {
        public a() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws IllegalStateException {
            if (TextUtils.isEmpty(editable)) {
                SearchChatAudioActivity.this.iv_delete.setVisibility(8);
            } else {
                SearchChatAudioActivity.this.iv_delete.setVisibility(0);
            }
            SearchChatAudioActivity.this.L4();
            SearchChatAudioActivity.this.n = 0;
            SearchChatAudioActivity.this.K4();
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 66 && keyEvent.getAction() == 1) {
                SearchChatAudioActivity searchChatAudioActivity = SearchChatAudioActivity.this;
                ue3.a(searchChatAudioActivity.et_search, searchChatAudioActivity);
                SearchChatAudioActivity.this.n = 0;
                SearchChatAudioActivity.this.K4();
            }
            return false;
        }
    }

    public class c implements SearchChatAudioAdapter.c {
        public c() {
        }

        @Override // com.wear.adapter.longdistance.SearchChatAudioAdapter.c
        public void c(CommunMessage communMessage) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("searchMessage", communMessage);
            if (SearchChatAudioActivity.this.e) {
                bundle.putString("roomId", SearchChatAudioActivity.this.d);
                pj3.g(SearchChatAudioActivity.this, ChatRoomActivity.class, bundle);
            } else {
                bundle.putString("userId", SearchChatAudioActivity.this.a);
                pj3.g(SearchChatAudioActivity.this, ChatActivity.class, bundle);
            }
        }
    }

    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (SearchChatAudioActivity.this.l.findLastVisibleItemPosition() < SearchChatAudioActivity.this.h.size() - 3 || i2 <= 0 || SearchChatAudioActivity.this.m) {
                return;
            }
            SearchChatAudioActivity.this.K4();
        }
    }

    public class e implements ObservableOnSubscribe<List<CommunMessage>> {
        public e() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(@com.google.firebase.database.annotations.NotNull ObservableEmitter<List<CommunMessage>> observableEmitter) throws Exception {
            ArrayList arrayList = new ArrayList();
            arrayList.add(MessageType.audio);
            List<CommunMessage> listFindMessageByType = DaoUtils.getCommunMessageDao().findMessageByType(WearUtils.y.p(), SearchChatAudioActivity.this.e ? WearUtils.k0(SearchChatAudioActivity.this.d) : SearchChatAudioActivity.this.b, null, true, false, arrayList, SearchChatAudioActivity.this.n, SearchChatAudioActivity.this.o);
            if (listFindMessageByType == null) {
                observableEmitter.onNext(new ArrayList());
                return;
            }
            for (CommunMessage communMessage : listFindMessageByType) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
            }
            observableEmitter.onNext(listFindMessageByType);
        }
    }

    public class f implements Function<Long, ObservableSource<?>> {

        public class a implements ObservableOnSubscribe<List<CommunMessage>> {
            public a() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(@com.google.firebase.database.annotations.NotNull ObservableEmitter<List<CommunMessage>> observableEmitter) throws Exception {
                ArrayList arrayList = new ArrayList();
                for (IPeopleInfo iPeopleInfo : SearchChatAudioActivity.this.c) {
                    if ((iPeopleInfo instanceof User) && iPeopleInfo.getShowNickName().toLowerCase().contains(SearchChatAudioActivity.this.f)) {
                        arrayList.add(iPeopleInfo.getUserJid());
                    } else if ((iPeopleInfo instanceof Account) && iPeopleInfo.getUserName().toLowerCase().contains(SearchChatAudioActivity.this.f)) {
                        arrayList.add(iPeopleInfo.getUserJid());
                    } else if ((iPeopleInfo instanceof GroupMember) && ((GroupMember) iPeopleInfo).getNickName().toLowerCase().contains(SearchChatAudioActivity.this.f)) {
                        arrayList.add(iPeopleInfo.getUserJid());
                    }
                }
                if (arrayList.isEmpty()) {
                    observableEmitter.onNext(new ArrayList());
                    return;
                }
                List<CommunMessage> listFindUserMessage = DaoUtils.getCommunMessageDao().findUserMessage(arrayList, WearUtils.y.p(), SearchChatAudioActivity.this.e ? WearUtils.k0(SearchChatAudioActivity.this.d) : SearchChatAudioActivity.this.b, MessageType.audio, SearchChatAudioActivity.this.e, SearchChatAudioActivity.this.n, SearchChatAudioActivity.this.o);
                if (listFindUserMessage != null) {
                    for (CommunMessage communMessage : listFindUserMessage) {
                        communMessage.setDataBean(communMessage.syncDecryptBean());
                    }
                    observableEmitter.onNext(listFindUserMessage);
                }
            }
        }

        public f() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<?> apply(@NotNull Long l) throws Exception {
            return Observable.create(new a());
        }
    }

    public class g implements Consumer<List<CommunMessage>> {
        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<CommunMessage> list) throws Exception {
            if (SearchChatAudioActivity.this.n == 0) {
                SearchChatAudioActivity.this.h.clear();
            }
            SearchChatAudioActivity.this.h.addAll(list);
            SearchChatAudioActivity.this.i.notifyItemRangeInserted(SearchChatAudioActivity.this.h.size() - list.size(), list.size());
            if (SearchChatAudioActivity.this.n == 0) {
                SearchChatAudioActivity.this.recyclerView.scrollToPosition(0);
            }
            SearchChatAudioActivity searchChatAudioActivity = SearchChatAudioActivity.this;
            searchChatAudioActivity.tv_no_result.setVisibility(searchChatAudioActivity.h.isEmpty() ? 0 : 8);
            SearchChatAudioActivity searchChatAudioActivity2 = SearchChatAudioActivity.this;
            searchChatAudioActivity2.recyclerView.setVisibility(searchChatAudioActivity2.h.isEmpty() ? 8 : 0);
            SearchChatAudioActivity.this.m = false;
            SearchChatAudioActivity.w4(SearchChatAudioActivity.this);
        }
    }

    public static /* synthetic */ int w4(SearchChatAudioActivity searchChatAudioActivity) {
        int i = searchChatAudioActivity.n;
        searchChatAudioActivity.n = i + 1;
        return i;
    }

    public final void J4() {
        this.et_search.addTextChangedListener(new a());
        this.et_search.setOnKeyListener(new b());
        SearchChatAudioAdapter searchChatAudioAdapter = new SearchChatAudioAdapter(this, this.h, this.k, this.e, this.j, new c());
        this.i = searchChatAudioAdapter;
        this.l = cg3.f(this.recyclerView, searchChatAudioAdapter);
        this.recyclerView.addOnScrollListener(new d());
    }

    public final void K4() {
        Observable observableFlatMap;
        Disposable disposable = this.g;
        if (disposable != null && !disposable.isDisposed()) {
            this.g.dispose();
        }
        this.m = true;
        String lowerCase = this.et_search.getText().toString().trim().toLowerCase();
        this.f = lowerCase;
        if (TextUtils.isEmpty(lowerCase)) {
            observableFlatMap = Observable.create(new e());
        } else {
            observableFlatMap = Observable.timer(this.n == 0 ? 400L : 0L, TimeUnit.MILLISECONDS).flatMap(new f());
        }
        this.g = observableFlatMap.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g());
    }

    public final void L4() throws IllegalStateException {
        so3 so3Var = this.k;
        if (so3Var != null && so3Var.s()) {
            h12.D.isPlayAudio = false;
            this.k.G();
            this.k.x();
            this.k.F();
            if (!na2.m().i()) {
                this.application.G().u0();
            }
        }
        SearchChatAudioAdapter searchChatAudioAdapter = this.i;
        if (searchChatAudioAdapter != null) {
            searchChatAudioAdapter.A(true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        ue3.a(this.et_search, this);
    }

    @OnClick({R.id.iv_delete, R.id.tv_cancel})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.et_search.setText("");
        } else {
            if (id != R.id.tv_cancel) {
                return;
            }
            onBackPressed();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_chat_audio);
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            String string = getIntent().getExtras().getString("userId");
            this.a = string;
            this.b = WearUtils.i0(string);
            this.d = getIntent().getExtras().getString("roomId");
            this.e = !TextUtils.isEmpty(r3);
        }
        this.c = new ArrayList();
        if (this.e) {
            this.j = ch3.n().k(WearUtils.A0(this.d));
            Group groupK = ch3.n().k(this.d);
            if (groupK == null) {
                finish();
                return;
            }
            this.c.addAll(groupK.getList());
        } else {
            this.j = WearUtils.y.v(this.a);
            this.c.add(ch3.n().s(this.a));
            this.c.add(ch3.n().u());
        }
        J4();
        K4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IllegalStateException {
        super.onDestroy();
        L4();
    }
}
