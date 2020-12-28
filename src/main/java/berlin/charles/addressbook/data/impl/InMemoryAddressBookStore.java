package berlin.charles.addressbook.data.impl;

import berlin.charles.addressbook.data.AddressBookStore;
import berlin.charles.addressbook.model.Contact;

import java.util.*;

public class InMemoryAddressBookStore implements AddressBookStore {

    private Map<String, Contact> addressBook;

    public InMemoryAddressBookStore() {
        this.addressBook = new HashMap<>();
    }
    /**
     * Creates a new contact table in the database
     */
    @Override
    public boolean createContact(Contact contact) {
        if (!this.addressBook.containsKey(contact.getId())) {
            this.addressBook.put(contact.getId(), contact);
            return true;
        } else {
            //throw new RuntimeException("Contact already exists");
            return false; //move runtime exception to manager class

        }
    }

    /**
     Takes a query and returns a list of matching results where the query matches a field in a contact table
     <param> String query
     <return> List object containing matching contacts from the database
     */
    public Contact getContact(String id){
        if(this.addressBook.containsKey(id)){
            return this.addressBook.get(id);
        }
        else{
            return null;
        }

    }

    /**
     * Checks if database contains contact id. If found, deletes contact. Else, returns false
     */
    @Override
    public boolean deleteContact(String id){
        if(this.addressBook.containsKey(id)){
            this.addressBook.remove(id);
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean updateContact(Contact contact) {
        if(!addressBook.containsKey(contact.getId())){
            return false;
        }
        else{
            this.addressBook.remove(contact.getId());
            this.addressBook.put(contact.getId(), contact);
            return true;
        }
    }

    @Override
    public Collection<Contact> listContacts() {
        return this.addressBook.values();
    }
}
