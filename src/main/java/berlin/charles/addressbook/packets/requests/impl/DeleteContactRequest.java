package berlin.charles.addressbook.packets.requests.impl;

import berlin.charles.addressbook.packets.requests.Request;

public class DeleteContactRequest implements Request {

    private String id;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;

    }

    @Override
    public String getFirstName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFirstName(String firstName) {
        throw new UnsupportedOperationException();

    }

    @Override
    public String getLastName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLastName(String lastName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getEmail() {
        throw new UnsupportedOperationException();
    }
}
