package com.service;

import com.entity.PhoneBookItem;
import com.entity.Role;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//@PropertySource(value = { "classpath:applicationJSON.properties" })
@Service("PhoneBookItemDAO_JSON")

public class PhoneBookItemService {


//    private final static String baseFile = "src/main/webapp/static/temp/phoneBookItem.json" ;

    private final static String baseFile = "C:/Users/user/Desktop/phoneBookJSON/target/phoneBookJSON/static/temp/phoneBookItem.json";


    public static void sout() {
        System.out.println(PhoneBookItemService.class.getResource(""));
        System.out.println(PhoneBookItemService.class.getClassLoader().getResource(""));
        System.out.println(PhoneBookItemService.class.getPackage());
        System.out.println(PhoneBookItemService.class.getResourceAsStream(""));
//        System.out.println(phoneBookItem.json);
    }

    public static void toJSON(List<PhoneBookItem> phoneBookItems) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(baseFile), phoneBookItems);

        System.out.println("json created!");
    }

    public static List<PhoneBookItem> toJavaObject() throws IOException {

        try {


            ObjectMapper mapper = new ObjectMapper();
            List<PhoneBookItem> phoneBookItems = mapper.readValue(new File(baseFile), new TypeReference<List<PhoneBookItem>>() {
            });
//        List<User> users=mapper.readValue(new File(baseFile) ,User.class);
            return phoneBookItems;
        } catch (IOException e) {
            List<PhoneBookItem> phoneBookItems = new ArrayList<PhoneBookItem>();
            return phoneBookItems;
        }
    }


    public void save(PhoneBookItem phoneBookItem) throws IOException {

        List<PhoneBookItem> phoneBookItems = PhoneBookItemService.toJavaObject();

        for (PhoneBookItem phoneBookItemm : phoneBookItems) {

            if (phoneBookItemm.getId() == phoneBookItem.getId()) {
                break;
            }

        }
        phoneBookItems.add(phoneBookItem);
        PhoneBookItemService.toJSON(phoneBookItems);


    }

    public List<PhoneBookItem> findAll() throws IOException {
        return PhoneBookItemService.toJavaObject();
    }

    public PhoneBookItem findById(long id) throws IOException {

        List<PhoneBookItem> phoneBookItems = PhoneBookItemService.toJavaObject();

        for (PhoneBookItem phoneBookItem : phoneBookItems) {

            if (phoneBookItem.getId() == id) {
                return phoneBookItem;
            }

        }

        return null;
    }


    public void deleteById(long id) throws IOException {
        List<PhoneBookItem> phoneBookItems = PhoneBookItemService.toJavaObject();

        for (int i = 0; i < phoneBookItems.size(); i++) {
            if (phoneBookItems.get(i).getId() == id) {
                phoneBookItems.remove(i);
            }
        }
//        for (PhoneBookItem phoneBookItem:phoneBookItems){
//
//            if (phoneBookItem.getId()==id){
//                phoneBookItems.remove(phoneBookItem);
//            }
//
//        }
        PhoneBookItemService.toJSON(phoneBookItems);
    }

    public List<PhoneBookItem> findByName(String name, String login) throws IOException {
        List<PhoneBookItem> phoneBookItems = PhoneBookItemService.toJavaObject();

        List<PhoneBookItem> phoneBookItemsFind = new ArrayList<PhoneBookItem>();
        for (PhoneBookItem phoneBookItem : phoneBookItems) {

            if (phoneBookItem.getUser().getLogin().equals(login) && phoneBookItem.getName().equals(name)) {
                phoneBookItemsFind.add(phoneBookItem);
            }

        }
        return phoneBookItemsFind;
    }

    public List<PhoneBookItem> findBySurname(String surname, String login) throws IOException {
        List<PhoneBookItem> phoneBookItems = PhoneBookItemService.toJavaObject();

        List<PhoneBookItem> phoneBookItemsFind = new ArrayList<PhoneBookItem>();
        for (PhoneBookItem phoneBookItem : phoneBookItems) {

            if (phoneBookItem.getUser().getLogin().equals(login) &&(phoneBookItem.getSurname().equals(surname))) {
                phoneBookItemsFind.add(phoneBookItem);
            }

        }
        return phoneBookItemsFind;
    }

    public List<PhoneBookItem> findByMobPhone(String mobPhone, String login) throws IOException {
        List<PhoneBookItem> phoneBookItems = PhoneBookItemService.toJavaObject();

        List<PhoneBookItem> phoneBookItemsFind = new ArrayList<PhoneBookItem>();
        for (PhoneBookItem phoneBookItem : phoneBookItems) {

                if (phoneBookItem.getUser().getLogin().equals(login) && phoneBookItem.getMobPhone().indexOf(mobPhone) != -1) {
                    phoneBookItemsFind.add(phoneBookItem);
                }


        }
        return phoneBookItemsFind;
    }

    public void updatePhoneBookItem(PhoneBookItem phoneBookItem) throws IOException {
        List<PhoneBookItem> phoneBookItems = findAll();
        for (PhoneBookItem entity : phoneBookItems) {

            if (phoneBookItem.getId() == entity.getId()) {
                entity.setName(phoneBookItem.getName());
                entity.setSurname(phoneBookItem.getSurname());
                entity.setPatronymic(phoneBookItem.getPatronymic());
                entity.setEmail(phoneBookItem.getEmail());
                entity.setAddress(phoneBookItem.getAddress());
                entity.setMobPhone(phoneBookItem.getMobPhone());
                entity.setHomePhone(phoneBookItem.getHomePhone());
            }


        }

        PhoneBookItemService.toJSON(phoneBookItems);


    }

}
