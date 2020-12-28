package berlin.charles.addressbook.packets.requests.impl;

import berlin.charles.addressbook.packets.requests.Request;

public class UpdateContactRequest implements Request {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }
    /**
     * Uses regex pattern matches to validate email argument</behavior>
     * @param email {@link String} - email to add
     */
    public void setEmail(String email) {

        final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (email.matches(EMAIL_REGEX)){
            this.email = email;
        }
        else{
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
    }
}