package com.wear.adapter.longdistance;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.bean.Account;
import com.wear.bean.Contact;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IContactInfo;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.kf;
import dc.qo;
import dc.tg3;
import dc.th4;
import dc.uf3;
import dc.vd3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public LayoutInflater a;
    public Context b;
    public List<IContactInfo> c;
    public List<String> d;
    public List<Contact> e;
    public List<String> f;
    public qo g;
    public String h;
    public c i;

    public class CharacterHolder extends RecyclerView.ViewHolder {
        public TextView a;

        public CharacterHolder(ContactAdapter contactAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.character);
        }
    }

    public class ContactHolder extends RecyclerView.ViewHolder {
        public TextView a;

        public ContactHolder(ContactAdapter contactAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.contact_name);
        }
    }

    public class NoContactHolder extends RecyclerView.ViewHolder {
        public TextView a;

        public NoContactHolder(ContactAdapter contactAdapter, View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.tv_text);
            this.a = textView;
            textView.setText(contactAdapter.h);
            this.a.setTextColor(th4.b(view.getContext(), R.color.text_color_85));
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ContactAdapter contactAdapter = ContactAdapter.this;
            c cVar = contactAdapter.i;
            if (cVar != null) {
                cVar.q(((Contact) contactAdapter.e.get(this.a)).getGroupMember());
            }
        }
    }

    public class b implements Comparator<String> {
        public b(ContactAdapter contactAdapter) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iHashCode = (str.charAt(0) + "").toUpperCase().hashCode();
            int iHashCode2 = (str2.charAt(0) + "").toUpperCase().hashCode();
            boolean z = iHashCode < 65 || iHashCode > 90;
            boolean z2 = iHashCode2 < 65 || iHashCode2 > 90;
            if (z && !z2) {
                return 1;
            }
            if (z || !z2) {
                return iHashCode - iHashCode2;
            }
            return -1;
        }
    }

    public interface c {
        void q(IContactInfo iContactInfo);
    }

    public ContactAdapter(Context context, List<IContactInfo> list, String str) {
        this.b = context;
        this.a = LayoutInflater.from(context);
        this.c = list;
        n();
        this.g = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
        this.h = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Contact> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.e.get(i).getmType();
    }

    public int m(String str) {
        if (!this.f.contains(str)) {
            return -1;
        }
        for (int i = 0; i < this.e.size(); i++) {
            if (this.e.get(i).getmName().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public final void n() {
        this.d = new ArrayList();
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            if (i >= this.c.size()) {
                break;
            }
            if (this.c.get(i) != null) {
                String strA = uf3.a(this.c.get(i) instanceof Account ? ((Account) this.c.get(i)).getUserName() : this.c.get(i) instanceof GroupMember ? ((GroupMember) this.c.get(i)).getNickName() : this.c.get(i).getShowNickName());
                String str = TextUtils.isEmpty(strA) ? "#" : strA;
                if (this.c.get(i) instanceof Group) {
                    Group group = (Group) this.c.get(i);
                    this.d.add(str + group.getId());
                    map.put(str + group.getId(), this.c.get(i));
                } else {
                    map.put(str, this.c.get(i));
                    this.d.add(str);
                }
            }
            i++;
        }
        vd3.b(this.d, new b(this));
        this.e = new ArrayList();
        this.f = new ArrayList();
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            String str2 = this.d.get(i2);
            String upperCase = (str2.charAt(0) + "").toUpperCase(Locale.ENGLISH);
            if (!this.f.contains(upperCase)) {
                if (upperCase.hashCode() >= 65 && upperCase.hashCode() <= 90) {
                    this.f.add(upperCase);
                    this.e.add(new Contact(null, upperCase, 1));
                } else if (!this.f.contains("#")) {
                    this.f.add("#");
                    this.e.add(new Contact(null, "#", 1));
                }
            }
            this.e.add(new Contact((IContactInfo) map.get(str2), str2, 2));
        }
        if (this.e.size() == 0) {
            this.e.add(new Contact(null, null, 0));
        }
    }

    public void o(c cVar) {
        this.i = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof CharacterHolder) {
            ((CharacterHolder) viewHolder).a.setText(this.e.get(i).getmName());
            return;
        }
        if (viewHolder instanceof ContactHolder) {
            RoundedImageView roundedImageView = (RoundedImageView) viewHolder.itemView.findViewById(R.id.iv_photo);
            TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.tv_emotion);
            ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.iv_official);
            textView.setVisibility(8);
            imageView.setVisibility(8);
            IContactInfo groupMember = this.e.get(i).getGroupMember();
            String avatar = groupMember.getAvatar();
            if (!avatar.startsWith("http")) {
                avatar = WearUtils.e + avatar;
            }
            boolean z = groupMember instanceof Group;
            if (z) {
                Group group = (Group) groupMember;
                if (group.getMembers().size() == 1) {
                    roundedImageView.setBorderWidth(ce3.a(this.b, 4.0f) * 1.0f);
                } else {
                    roundedImageView.setBorderWidth(0.0f);
                }
                tg3.i(roundedImageView, group);
            } else if (groupMember instanceof OfficialAcount) {
                roundedImageView.setImageResource(((OfficialAcount) groupMember).getAvatarRes());
                imageView.setVisibility(0);
            } else {
                roundedImageView.setBorderWidth(0.0f);
                kf.w(this.b).v(avatar).a(this.g).A0(roundedImageView);
            }
            if (groupMember instanceof User) {
                User user = (User) groupMember;
                if (!TextUtils.isEmpty(user.getMoodMessage())) {
                    textView.setVisibility(0);
                    textView.setText(user.getMoodMessage());
                }
                ((ContactHolder) viewHolder).a.setText(user.getShowNickName());
            } else if (groupMember instanceof Account) {
                ((ContactHolder) viewHolder).a.setText(((Account) groupMember).getUserName());
            } else if (groupMember instanceof GroupMember) {
                ((ContactHolder) viewHolder).a.setText(((GroupMember) groupMember).getNickName());
            } else if (z) {
                ((ContactHolder) viewHolder).a.setText(((Group) groupMember).getShowNickName());
            } else {
                ((ContactHolder) viewHolder).a.setText(groupMember.getShowNickName());
            }
            View viewFindViewById = viewHolder.itemView.findViewById(R.id.fl_online_status);
            ImageView imageView2 = (ImageView) viewHolder.itemView.findViewById(R.id.online_status);
            if (groupMember instanceof IPeopleInfo) {
                p((IPeopleInfo) groupMember, imageView2, viewFindViewById);
            } else {
                viewFindViewById.setVisibility(4);
            }
            viewHolder.itemView.setOnClickListener(new a(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new CharacterHolder(this, this.a.inflate(R.layout.item_character, viewGroup, false)) : i == 2 ? new ContactHolder(this, this.a.inflate(R.layout.item_contact, viewGroup, false)) : new NoContactHolder(this, this.a.inflate(R.layout.view_recyclerview_no_data, viewGroup, false));
    }

    public void p(IPeopleInfo iPeopleInfo, ImageView imageView, View view) {
        if (iPeopleInfo.isGroup()) {
            view.setVisibility(4);
            return;
        }
        Presence.Mode statusMode = iPeopleInfo.getStatusMode();
        if (!iPeopleInfo.isOnline() || statusMode == null) {
            view.setVisibility(4);
            return;
        }
        if (statusMode == Presence.Mode.chat) {
            view.setVisibility(0);
            imageView.setImageResource(R.drawable.status_available);
        } else if (statusMode == Presence.Mode.dnd) {
            view.setVisibility(0);
            imageView.setImageResource(R.drawable.status_busy);
        } else if (statusMode == Presence.Mode.away) {
            view.setVisibility(4);
        }
    }
}
