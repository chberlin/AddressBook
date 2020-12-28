package berlin.charles.addressbook.controller;

import berlin.charles.addressbook.packets.requests.Request;
import berlin.charles.addressbook.packets.responses.Response;

public interface Controller<A extends Request, B extends Response> {

    //public B callApi(String[] str);

    B callAPI(String[] tokens);
}
