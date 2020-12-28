package berlin.charles.addressbook.config;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requestgenerators.impl.*;
import berlin.charles.addressbook.packets.requests.Request;
import berlin.charles.addressbook.packets.requests.impl.*;
import berlin.charles.addressbook.packets.responses.Response;
import berlin.charles.addressbook.controller.Controller;
import berlin.charles.addressbook.controller.impl.*;
import berlin.charles.addressbook.data.AddressBookStore;
import berlin.charles.addressbook.data.impl.InMemoryAddressBookStore;
import berlin.charles.addressbook.manager.AddressBookManager;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ApplicationConfig {


    private static final RequestGenerator<CreateContactRequest> createRequestGenerator = new CreateContactRequestGenerator();
    private static final RequestGenerator<DeleteContactRequest> deleteContactRequestGenerator = new DeleteContactRequestGenerator();
    private static final RequestGenerator<GetContactRequest> getContactRequestGenerator = new GetContactRequestGenerator();
    private static final RequestGenerator<UpdateContactRequest> updateContactRequestGenerator = new UpdateContactsRequestGenerator();
    private static final RequestGenerator<ListContactRequest> listContactRequestGenerator = new ListContactsRequestGenerator();


    private static final AddressBookStore addressBookStore = new InMemoryAddressBookStore();
    private static final AddressBookManager addressBookManager = new AddressBookManager(addressBookStore);
    private static final Controller<Request, Response> createContactController = new CreateContactController(addressBookManager, createRequestGenerator);
    private static final Controller<Request, Response> deleteContactController = new DeleteContactController(addressBookManager, deleteContactRequestGenerator);
    private static final Controller<Request, Response> getContactController = new GetContactController(addressBookManager, getContactRequestGenerator);
    private static final Controller<Request, Response> updateContactController = new UpdateContactController(addressBookManager, updateContactRequestGenerator);
    private static final Controller<Request, Response> listContactsController = new ListContactsController(addressBookManager, listContactRequestGenerator);


    public static Response makeRequest(String[] tokens) {
        Map<String, Controller<Request, Response>> instanceMap = new HashMap<>();
        instanceMap.put("create", createContactController);
        instanceMap.put("get", getContactController);
        instanceMap.put("update", updateContactController);
        instanceMap.put("delete", deleteContactController);
        instanceMap.put("list", listContactsController);

        if (!instanceMap.containsKey(tokens[0].toLowerCase(Locale.ROOT))) {
            throw new RuntimeException("API " + tokens[0] + " not mapped");
        }
        else {
            return instanceMap.get(tokens[0].toLowerCase(Locale.ROOT)).callAPI(tokens);
        }
    }
}
