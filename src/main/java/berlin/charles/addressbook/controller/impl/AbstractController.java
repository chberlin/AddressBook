package berlin.charles.addressbook.controller.impl;

import berlin.charles.addressbook.packets.responses.Response;
import berlin.charles.addressbook.controller.Controller;
import berlin.charles.addressbook.packets.requests.Request;
import berlin.charles.addressbook.packets.requestgenerators.RequestGenerator;

public abstract class AbstractController <A extends Request, B extends Response> implements Controller<Request,Response>{

    final RequestGenerator<A> requestGenerator;


    public AbstractController(final RequestGenerator<A> requestGenerator) {
        this.requestGenerator = requestGenerator;

    }

    public B callApi(String[] str) {
        A request = this.requestGenerator.generateRequest(str);
        return callApi(request);
    }

    protected abstract B callApi(final A request);


}