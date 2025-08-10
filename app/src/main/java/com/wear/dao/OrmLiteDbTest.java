package com.wear.dao;

import com.wear.bean.User;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class OrmLiteDbTest {
    private UserDao dao = new UserDao();

    public void test() {
        testList();
        testDelUser(new User("abc"));
        testList();
        User user = new User("abc");
        user.setName("aaa");
        testAddUser(user);
        testList();
        User user2 = new User("abc");
        user2.setName("bbb");
        testAddUser(user2);
        testList();
        User user3 = new User("abc");
        user3.setName("ccc");
        testUpdateUser(user3);
        testList();
        User user4 = new User("abceeeee");
        user4.setName("ddddd");
        testUpdateUser(user4);
        testList();
    }

    public void testAddUser(User user) {
        System.err.println("=========add user：" + user.toString());
        this.dao.add(user);
    }

    public void testDelUser(User user) {
        System.err.println("=========del user：" + user.toString());
        this.dao.delT(user);
    }

    public void testList() {
        List<User> listFindAll = this.dao.findAll();
        if (listFindAll != null) {
            Iterator<User> it = listFindAll.iterator();
            while (it.hasNext()) {
                System.err.println(it.next().toString());
            }
        }
    }

    public void testUpdateUser(User user) {
        System.err.println("=========update user：" + user.toString());
        this.dao.update(user);
    }
}
