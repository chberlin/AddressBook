package berlin.charles.addressbook.controller.impl;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.UpdateContactRequest;
import berlin.charles.addressbook.packets.responses.Response;
import berlin.charles.addressbook.packets.responses.impl.UpdateContactResponse;
import berlin.charles.addressbook.manager.AddressBookManager;

public class UpdateContactController extends AbstractController<UpdateContactRequest, UpdateContactResponse> {

    private final AddressBookManager addressBookManager;

    public UpdateContactController(AddressBookManager addressBookManager, RequestGenerator<UpdateContactRequest> requestGenerator) {
        super(requestGenerator);
        this.addressBookManager = addressBookManager;
    }

    @Override
    protected UpdateContactResponse callApi(UpdateContactRequest request) {

        return this.addressBookManager.updateContact(request);
    }

    @Override
    public Response callAPI(String[] tokens) {
        return callApi(this.requestGenerator.generateRequest(tokens));
    }
}
