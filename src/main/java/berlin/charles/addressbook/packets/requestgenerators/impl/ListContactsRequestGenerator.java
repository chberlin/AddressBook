package berlin.charles.addressbook.packets.requestgenerators.impl;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.ListContactRequest;

public class ListContactsRequestGenerator implements RequestGenerator<ListContactRequest> {
    @Override
    public ListContactRequest generateRequest(String[] str) {
        if (str.length != 1) {
            throw new RuntimeException("Too many arguments to 'list' api");
        }
        return new ListContactRequest();
    }
}
