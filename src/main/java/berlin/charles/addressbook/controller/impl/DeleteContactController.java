package berlin.charles.addressbook.controller.impl;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.DeleteContactRequest;
import berlin.charles.addressbook.packets.responses.Response;
import berlin.charles.addressbook.packets.responses.impl.DeleteContactResponse;
import berlin.charles.addressbook.manager.AddressBookManager;

public class DeleteContactController extends AbstractController<DeleteContactRequest, DeleteContactResponse>  {

    private final AddressBookManager addressBookManager;

    public DeleteContactController(AddressBookManager addressBookManager, RequestGenerator<DeleteContactRequest> requestGenerator) {
        super(requestGenerator);
        this.addressBookManager = addressBookManager;
    }

    @Override
    protected DeleteContactResponse callApi(DeleteContactRequest request) {
        return this.addressBookManager.deleteContact(request);
    }

    @Override
    public Response callAPI(String[] tokens) {
        return callApi(this.requestGenerator.generateRequest(tokens));
    }
}
