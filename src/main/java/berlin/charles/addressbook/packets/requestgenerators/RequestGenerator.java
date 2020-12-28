package berlin.charles.addressbook.packets.requestgenerators;

import berlin.charles.addressbook.packets.requests.Request;

public interface RequestGenerator<T extends Request> {

    T generateRequest(String[] str);
}
