package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dlocke on 12/23/16.
 */
@Controller //controller for processing requests

public class MicroblogSpringController {


    //access Postgres repository
    @Autowired
    MessageRepository messages;

    public static HashMap<String, User> users = new HashMap<>();

    //get name(s) and message(s) from db
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home (Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        List<Message> messageList = (List<Message>)messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    //user input to login
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    //user input to logout
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //user input to add a new message
    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage (Model model, String text) {
        Message message = new Message (text);
        messages.save(message);
        return "redirect:/";
    }

    //user input to edit a message
    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage (Model model, int enterId, String editMessage) {
        Message mess = messages.findOne(enterId);
        mess.text = editMessage;
        messages.save(mess);

        return "redirect:/";
    }

    //user input to delete a message
    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage (Model model, int id) {
        //messages.remove(messages.remove(id-1));
        messages.delete(id);
        return "redirect:/";
    }

}//end class MicroblogSpringController