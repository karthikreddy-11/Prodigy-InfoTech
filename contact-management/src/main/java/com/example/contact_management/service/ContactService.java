package com.example.contact_management.service;

import com.example.contact_management.model.Contact;
import com.example.contact_management.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact updatedContact) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            Contact contact = existingContact.get();
            contact.setName(updatedContact.getName());
            contact.setPhone(updatedContact.getPhone());
            contact.setEmail(updatedContact.getEmail());
            return contactRepository.save(contact);
        }
        return null;
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
