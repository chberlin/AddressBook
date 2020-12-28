package berlin.charles.addressbook.controller.impl;

import berlin.charles.addressbook.packets.responses.Response;
import berlin.charles.addressbook.packets.responses.impl.CreateContactResponse;
import berlin.charles.addressbook.manager.AddressBookManager;
import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.CreateContactRequest;

public class CreateContactController extends AbstractController<CreateContactRequest, CreateContactResponse>  {

    private final AddressBookManager addressBookManager;

    public CreateContactController(AddressBookManager addressBookManager, RequestGenerator<CreateContactRequest> requestGenerator) {
        super(requestGenerator);
        this.addressBookManager = addressBookManager;
    }

    @Override
    protected CreateContactResponse callApi(CreateContactRequest request) {
        /**
         * Sends request to AddressBookManger layer
         * @param request
         * @return response from application
         */
        return this.addressBookManager.createContact(request);
    }

    @Override
    public Response callAPI(String[] tokens) {
        return callApi(this.requestGenerator.generateRequest(tokens));
    }
}
