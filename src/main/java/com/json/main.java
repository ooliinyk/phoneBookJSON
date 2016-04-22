package com.json;

import com.entity.PhoneBookItem;
import com.entity.Role;
import com.entity.User;
import com.service.PhoneBookItemService;
import com.service.RoleService;
import com.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.04.2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        User user= new User();

        user.setId(1);
        user.setName("sada");
        user.setPassword("asd");
        user.setSurname("asdasd");
        user.setLogin("adsasd");

//
//
//        PhoneBookItem phoneBookItem=new PhoneBookItem();
//        phoneBookItem.setEmail("sadads");
//        phoneBookItem.setId(123);
//        phoneBookItem.setName("adsdas");
//
//        List<PhoneBookItem> phoneBookItems=new ArrayList<PhoneBookItem>();
//        phoneBookItems.add(phoneBookItem);
//        phoneBookItems.add(phoneBookItem);
//        PhoneBookItemService.toJSON(phoneBookItems);
//        PhoneBookItemService.sout();
//        System.out.println(PhoneBookItemService.toJavaObject().toString());
//
////
//
//
        List<User> users =new ArrayList<User>();
        users.add(user);
        users.add(user);
        UserService userService=new UserService();

        UserService.toJSON(users);
        System.out.println(UserService.toJavaObject().toString());
        System.out.println(userService.findById(2));
        System.out.println(userService.findByLogin("adsasd"));

        userService.save(user);
        System.out.println(userService.findAll().toString());

        long l=1;
        Role role=new Role();
        role.setId(l);
        role.setRoleName("USER");
//        List<Role> roles=new ArrayList<Role>();
//        roles.add(role);
        RoleService roleService=new RoleService();


//        roleService.save(role);

        roleService.delteById(l);


        System.out.println(roleService.findAll().toString());
//        roleService.save(roles);

//        UserDAO dao=new UserDAO();
//
//        dao.save(user);
//
//        System.out.println(Converter.toJavaObject().toString());

    }
}
