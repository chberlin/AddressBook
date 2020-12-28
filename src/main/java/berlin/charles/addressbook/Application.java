package berlin.charles.addressbook;


import berlin.charles.addressbook.config.ApplicationConfig;
import berlin.charles.addressbook.packets.responses.Response;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // This class is responsible for instantiating ApplicationConfig and responding to user input to trigger API.
        // This function should continuously ask the user for input and respond with output until the user explicity
        //quits the application
        //api add, get, update, delete
        //ApplicationConfig applicationConfig = new ApplicationConfig();
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        while (scanner.hasNextLine()) {
            try {
                Response controller = ApplicationConfig.makeRequest(scanner.nextLine().split("\\s+"));
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }

        }
    }
    private static void displayMenu(){
        System.out.println("Address Book Commands:");
        System.out.println("create id=[IdNumber] f=[firstName] l=[lastname] e=[email]");
        System.out.println("get id=[IdNumber]");
        System.out.println("update id=[IdNumber] f=[firstname] l=[lastname] e=[email]");
        System.out.println("delete id=[IdNumber]");
        System.out.println("list");
    }


}
