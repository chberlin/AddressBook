package berlin.charles.addressbook.controller.impl;


import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.ListContactRequest;
import berlin.charles.addressbook.packets.responses.Response;
import berlin.charles.addressbook.packets.responses.impl.ListContactsResponse;
import berlin.charles.addressbook.manager.AddressBookManager;

public class ListContactsController extends AbstractController<ListContactRequest, ListContactsResponse> {

    private final AddressBookManager addressBookManager;

    public ListContactsController(AddressBookManager addressBookManager, RequestGenerator<ListContactRequest> requestGenerator){
        super(requestGenerator);
        this.addressBookManager = addressBookManager;

    }

    @Override
    protected ListContactsResponse callApi(ListContactRequest request) {

        return this.addressBookManager.listContacts(request);
    }

    @Override
    public Response callAPI(String[] tokens) {
        return callApi(this.requestGenerator.generateRequest(tokens));
    }
}
