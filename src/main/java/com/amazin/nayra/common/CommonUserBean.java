package com.amazin.nayra.common;


import org.springframework.stereotype.Component;

import com.amazin.nayra.model.MenuMain;
import com.amazin.nayra.model.Users;



@Component
public class CommonUserBean {
    private Users users;
   private Iterable<MenuMain> menuMain;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Iterable<MenuMain> getMenuMain() {
        return menuMain;
    }

    public void setMenuMain(Iterable<MenuMain> menuMain) {
        this.menuMain = menuMain;
    }
}
