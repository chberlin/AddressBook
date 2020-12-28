package berlin.charles.addressbook.controller.impl;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.GetContactRequest;
import berlin.charles.addressbook.packets.responses.Response;
import berlin.charles.addressbook.packets.responses.impl.GetContactResponse;
import berlin.charles.addressbook.manager.AddressBookManager;

public class GetContactController extends AbstractController<GetContactRequest, GetContactResponse> {

    private final AddressBookManager addressBookManager;

    public GetContactController(AddressBookManager addressBookManager, RequestGenerator<GetContactRequest> requestGenerator) {
        super(requestGenerator);
        this.addressBookManager = addressBookManager;
    }

    @Override
    protected GetContactResponse callApi(GetContactRequest request) {

        return this.addressBookManager.getContact(request);
    }

    @Override
    public Response callAPI(String[] tokens) {
        return callApi(this.requestGenerator.generateRequest(tokens));
    }
}
