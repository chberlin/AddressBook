package berlin.charles.addressbook.manager;

import berlin.charles.addressbook.packets.requests.impl.*;
import berlin.charles.addressbook.packets.responses.impl.*;
import berlin.charles.addressbook.data.AddressBookStore;
import berlin.charles.addressbook.model.Contact;

import java.util.Collection;

public class AddressBookManager {

    private final AddressBookStore dataStore;

    public AddressBookManager (AddressBookStore addressBookStore){
        this.dataStore = addressBookStore;
    }

    public CreateContactResponse createContact(CreateContactRequest request) {
        Contact contact = new Contact();
        contact.setId(request.getId());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        CreateContactResponse response = new CreateContactResponse();
        if(this.dataStore.createContact(contact)){
            //generate json response for success
            return response;
        }
        else{
            throw new RuntimeException("Unable to add new contact to data store");
        }
    }
    public DeleteContactResponse deleteContact(DeleteContactRequest request){
        if(this.dataStore.deleteContact(request.getId())){
            DeleteContactResponse response = new DeleteContactResponse();
            //generate some json response
            return response;
        }
        else{
            throw new RuntimeException("Contact with id: " + request.getId() + "cannot be deleted or does not exist");
        }
    }
    public GetContactResponse getContact(GetContactRequest request){
        if(this.dataStore.getContact(request.getId()) != null){
            GetContactResponse response = new GetContactResponse();
            //generate some json response
            return response;
        }
        else{
            throw new RuntimeException("Contact with id: " + request.getId() + "does not exist or can't be found right now");
        }
    }
    public UpdateContactResponse updateContact(UpdateContactRequest request){
        Contact contact = new Contact();
        contact.setId(request.getId());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        UpdateContactResponse response = new UpdateContactResponse();
        if(this.dataStore.updateContact(contact)){
            //generate json response for success
            return response;
        }
        else{
            //generate response for failed
            throw new RuntimeException("Unable to update contact with Id: " + request.getId());
        }
    }
    public ListContactsResponse listContacts(ListContactRequest request) {
        Collection<Contact> allContacts = this.dataStore.listContacts();
        if(allContacts.isEmpty()){
            throw new RuntimeException("No contacts to display");
        }
        else{
            ListContactsResponse response = new ListContactsResponse();
            //generate some json response with contacts
            return response;
        }
    }

}
