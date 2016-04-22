package com.service;

import com.entity.Role;
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
@Service("RoleServiceJSON")
public class RoleService {

//    private final static String baseFile = "src/main/webapp/static/temp/role.json";
    private final static String baseFile = "C:/Users/user/Desktop/phoneBookJSON/target/phoneBookJSON/static/temp/role.json";


    public static void toJSON(List<Role> roles) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(baseFile), roles);

        System.out.println("json created!");
    }

    public static List<Role> toJavaObject() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Role> roles = mapper.readValue(new File(baseFile), new TypeReference<List<Role>>() {
            });


            return roles;
        } catch (IOException e) {
            List<Role> roles = new ArrayList<Role>();
            return roles;
        }

    }


    public void save(Role role) throws IOException {



            List<Role> roles = RoleService.toJavaObject();

            for (Role role1 : roles) {

                if (role1.getId() == role.getId()) {
                    break;
                }

            }
            roles.add(role);
            RoleService.toJSON(roles);



    }

    public List<Role> findAll() throws IOException {
        return RoleService.toJavaObject();
    }

    public Role findById(long id) throws IOException {
        List<Role> roles = RoleService.toJavaObject();

        for (Role role : roles) {

            if (role.getId() == id) {
                return role;
            }

        }
        return null;
    }

    public Role findByName(String name) throws IOException {
        List<Role> roles = RoleService.toJavaObject();

        for (Role role : roles) {

            if (role.getRoleName().equals(name)) {
                return role;
            }

        }
        return null;
    }

    public void delteById(long id) throws IOException {
        List<Role> roles = RoleService.toJavaObject();

        for (int i = 0; i <roles.size() ; i++) {

            if ( roles.get(i).getId()==id){
                roles.remove(i);


            }


        }

//        for (Role role : roles) {
//
//            if (role.getId() == id) {
//                roles.remove(role);
//            }
//
//        }
        RoleService.toJSON(roles);
    }
}
