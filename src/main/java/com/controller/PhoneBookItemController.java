package com.controller;


import com.entity.PhoneBookItem;
import com.entity.User;
import com.service.PhoneBookItemService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 16.04.2016.
 */

@Controller
public class PhoneBookItemController {


    @Autowired
    PhoneBookItemService phoneBookItemService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/listAdmin"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) throws IOException {
        List<PhoneBookItem> phoneBookItemss = phoneBookItemService.findAll();
        PhoneBookItem phoneBookItem = new PhoneBookItem();
        model.addAttribute("phoneBookItems", phoneBookItemss);
        model.addAttribute("phoneBookItem", phoneBookItem);
        return "main";
    }

    @RequestMapping(value = "/addPhoneBookItem", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        PhoneBookItem phoneBookItem = new PhoneBookItem();
        model.addAttribute("phoneBookItem", phoneBookItem);
        return "addItem";
    }


    @RequestMapping(value = "/addPhoneBookItem", method = RequestMethod.POST)
    public String savedRegistration(@Valid PhoneBookItem phoneBookItem,
                                    BindingResult result, ModelMap model) throws IOException {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "addItem";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user = userService.findByLogin(name);

        phoneBookItem.setUser(user);

        phoneBookItemService.save(phoneBookItem);


//        return "redirect:/login";
        return "welcome";
    }


    @RequestMapping(value = {"/edit-phoneBook-{phoneBookItemId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable Long phoneBookItemId, ModelMap model) throws IOException {
        PhoneBookItem phoneBookItem = phoneBookItemService.findById(phoneBookItemId);

        model.addAttribute("phoneBookItem", phoneBookItem);
        model.addAttribute("edit", true);
        return "addItem";
    }

    @RequestMapping(value = {"/edit-phoneBook-{phoneBookItemId}"}, method = RequestMethod.POST)
    public String updateBook(@Valid PhoneBookItem phoneBookItem, BindingResult result,
                             ModelMap model, @PathVariable Integer phoneBookItemId) throws IOException {

        if (result.hasErrors()) {
            return "addItem";
        }

        phoneBookItemService.updatePhoneBookItem(phoneBookItem);


        return "redirect:/listAdmin";
    }

    @RequestMapping(value = {"/delete-phoneBook-{phoneBookItemId}"}, method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long phoneBookItemId) throws IOException {
        phoneBookItemService.deleteById(phoneBookItemId);
        return "redirect:/listAdmin";
    }

    @RequestMapping(value = {"/finPhoneBookItemByName"}, method = RequestMethod.POST)
    public String finPhoneBookItemByName(@ModelAttribute PhoneBookItem phoneBookItem, @RequestParam String name, ModelMap model) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();

        List<PhoneBookItem> phoneBookItems = phoneBookItemService.findByName(name, login);
        if (phoneBookItems.isEmpty()) {
            model.addAttribute("fail", "No phoneBookItem with name  " + name + " in DB ");
            return "main";
        }
        model.addAttribute("phoneBookItems", phoneBookItems);
        PhoneBookItem phoneBookItem1 = new PhoneBookItem();
        model.addAttribute("phoneBookItem", phoneBookItem1);
//        model.addAttribute("name", name);
        return "main";
//        return "redirect:/listAdmin"+books;
    }

    @RequestMapping(value = {"/finPhoneBookItemBySurname"}, method = RequestMethod.POST)
    public String finPhoneBookItemBySurname(@ModelAttribute PhoneBookItem phoneBookItem, @RequestParam String surname, ModelMap model) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();

        List<PhoneBookItem> phoneBookItems = phoneBookItemService.findBySurname(surname, login);
        if (phoneBookItems.isEmpty()) {
            model.addAttribute("fail", "No phoneBookItem with surname  " + surname + " in DB ");
            return "main";
        }
        model.addAttribute("phoneBookItems", phoneBookItems);
        PhoneBookItem phoneBookItem1 = new PhoneBookItem();
        model.addAttribute("phoneBookItem", phoneBookItem1);

        return "main";
    }

    @RequestMapping(value = {"/finPhoneBookItemByMobPhone"}, method = RequestMethod.POST)
    public String finPhoneBookItemByMobPhone(@ModelAttribute PhoneBookItem phoneBookItem, @RequestParam String mobPhone, ModelMap model) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        List<PhoneBookItem> phoneBookItems = phoneBookItemService.findByMobPhone(mobPhone, name);
        if (phoneBookItems.isEmpty()) {
            model.addAttribute("fail", "No phoneBookItem with mobPhone  " + mobPhone + " in DB ");
            model.addAttribute("phoneBookItems", phoneBookItems);
            return "main";
        }
        model.addAttribute("phoneBookItems", phoneBookItems);
        PhoneBookItem phoneBookItem1 = new PhoneBookItem();
        model.addAttribute("phoneBookItem", phoneBookItem1);

        return "main";

    }


}
