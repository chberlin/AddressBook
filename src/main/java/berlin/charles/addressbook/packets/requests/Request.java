package berlin.charles.addressbook.packets.requests;


public interface Request {


    public String getId();

    public void setId(String id);


    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getEmail();

}