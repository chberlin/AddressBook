package berlin.charles.addressbook.data;

import berlin.charles.addressbook.model.Contact;

import java.util.Collection;

public interface AddressBookStore {

    boolean createContact(Contact contact);


    Contact getContact(String id);


    boolean deleteContact(String id);

    boolean updateContact(Contact contact);

    Collection<Contact> listContacts();

}
