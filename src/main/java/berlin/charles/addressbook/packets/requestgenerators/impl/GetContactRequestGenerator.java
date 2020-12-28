package berlin.charles.addressbook.packets.requestgenerators.impl;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.GetContactRequest;

import java.util.Locale;

public class GetContactRequestGenerator implements RequestGenerator<GetContactRequest> {
    @Override
    public GetContactRequest generateRequest(String[] str) {
        GetContactRequest newRequest = new GetContactRequest();
        if (str.length != 2) {
            throw new RuntimeException("Insufficient number of arguments to to Get APi");
        } else {
            String[] arg = str[1].split("=");
            if (arg.length != 2) {
                throw new RuntimeException("Insufficient number of arguments");
            } else if (arg[0].toLowerCase(Locale.ROOT).equals("id")) {
                newRequest.setId(arg[1]);
            } else {
                throw new RuntimeException("Incorrect arguments to Get api");
            }
        }
        return newRequest;
    }
}
