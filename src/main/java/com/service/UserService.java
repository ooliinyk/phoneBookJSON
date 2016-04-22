package com.service;

import com.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 19.04.2016.
 */

@Service("UserServiceJSON")
public class UserService {

//    private final static String baseFile = "src/main/webapp/static/temp/user.json";

    private final static String baseFile = "C:/Users/user/Desktop/phoneBookJSON/target/phoneBookJSON/static/temp/user.json";

    public static void toJSON(List<User> users) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(baseFile), users);

        System.out.println("json created!");
    }

    public static List<User> toJavaObject() throws IOException {

        try {


            ObjectMapper mapper = new ObjectMapper();
            List<User> users = mapper.readValue(new File(baseFile), new TypeReference<List<User>>() {
            });
            return users;
        } catch (IOException e) {
            List<User> users = new ArrayList<User>();
            return users;
        }

    }


    public void save(User user) throws IOException {

        List<User> users = UserService.toJavaObject();

        for (User userr : users) {

            if (userr.getId() == user.getId()) {
                break;
            }

        }
        users.add(user);
        UserService.toJSON(users);


    }

    public List<User> findAll() throws IOException {
        return UserService.toJavaObject();
    }

    public User findById(long id) throws IOException {
        List<User> users = UserService.toJavaObject();

        for (User user : users) {

            if (user.getId() == id) {
                return user;
            }

        }

        return null;
    }

    public User findByLogin(String login) throws IOException {
        List<User> users = UserService.toJavaObject();

        for (User user : users) {

            if (user.getLogin().equals(login)) {
                return user;
            }

        }
        return null;
    }

    public void delteById(long id) throws IOException {
        List<User> users = UserService.toJavaObject();

        for (int i = 0; i <users.size() ; i++) {

            if ( users.get(i).getId()==id){
                users.remove(i);


            }


        }


    }


    public boolean isUserLoginUnique(Long id, String login) throws IOException {
        User user = findByLogin(login);
        return (user == null || ((id != null) && (user.getId() == id)));

    }


}
