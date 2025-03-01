package com.example.contact_management.controller;

import com.example.contact_management.model.Contact;
import com.example.contact_management.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add-contact";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "edit-contact";
    }

    @PostMapping("/update/{id}")
    public String updateContact(@PathVariable Long id, @ModelAttribute Contact contact) {
        contactService.updateContact(id, contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/";
    }
}
