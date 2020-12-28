package berlin.charles.addressbook.packets.requestgenerators.impl;

import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;
import berlin.charles.addressbook.packets.requests.impl.UpdateContactRequest;

import java.util.Locale;

public class UpdateContactsRequestGenerator implements RequestGenerator<UpdateContactRequest> {
    @Override
    public UpdateContactRequest generateRequest(String[] str) {
        if(str.length < 2){
            throw new RuntimeException("Fail: Update takes 1 or more arguments");
        }
        UpdateContactRequest newRequest = new UpdateContactRequest();
        for (int i = 1; i < str.length; i++) {
            String[] param = str[i].split("=");
            if (param.length != 2) {
                throw new RuntimeException("Argument " + param[0] + " was not given a value");
            } else {
                switch (param[0].toLowerCase(Locale.ROOT)) {
                    case "id":
                        newRequest.setId(param[1]);
                        break;
                    case "f":
                        newRequest.setFirstName(param[1]);
                        break;
                    case "l":
                        newRequest.setLastName(param[1]);
                        break;
                    case "e":
                        newRequest.setEmail(param[1]);
                        break;
                    default:
                        throw new RuntimeException("Invalid param: " + param[0]);
                }
            }
        }
        return newRequest;
    }
}
