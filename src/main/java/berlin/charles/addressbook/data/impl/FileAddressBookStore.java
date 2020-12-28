package berlin.charles.addressbook.data.impl;

import berlin.charles.addressbook.data.AddressBookStore;
import berlin.charles.addressbook.model.Contact;

import java.util.Collection;

public class FileAddressBookStore implements AddressBookStore {
    @Override
    public boolean createContact(Contact contact) {
        return false;
    }

    @Override
    public Contact getContact(String id) {

        return null;
    }

    @Override
    public boolean deleteContact(String id) {
        return false;

    }

    @Override
    public boolean updateContact(Contact contact) {
        return false;
    }

    @Override
    public Collection<Contact> listContacts() {
        return null;
    }
}
