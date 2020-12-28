package berlin.charles.addressbook.packets.requestgenerators.impl;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.DeleteContactRequest;

import java.util.Locale;

public class DeleteContactRequestGenerator implements RequestGenerator<DeleteContactRequest> {
    @Override
    public DeleteContactRequest generateRequest(String[] str) {
        DeleteContactRequest newRequest = new DeleteContactRequest();
        if (str.length != 2) {
            throw new RuntimeException("Insufficient number of arguments to to delete APi");
        } else {
            String[] arg = str[1].split("=");
            if (arg.length != 2) {
                throw new RuntimeException("Insufficient number of arguments");
            } else if (arg[0].toLowerCase(Locale.ROOT).equals("id")) {
                newRequest.setId(arg[1]);
            } else {
                throw new RuntimeException("Incorrect arguments to delete api");
            }
        }
        return newRequest;
    }
}
