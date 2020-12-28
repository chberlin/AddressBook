AddressBook app

## Package Structure

Application -> Controller -> Manager -> Data

- [See **Controller** package-info](@link berlin.charles.addressbook.controller#package-info) for details.
An application relies on a set of APIs that the user will use. These API are the entrances to the application.
These APIs are declared in the **Controller** package. Each API is declared in its own class in this package.


- [See **Manager** package-info](@link berlin.charles.addressbook.manager#package-info) for details.
Each API controller relies on a set of business logic to vend a response to the application. This functionality is stored in
the **Manager** package. 

- [See **Data** package-info](@link berlin.charles.addressbook.data#package-info) for details.
Business logic ordinarily relies on interaction with data. Classes in the **Data** package interact with data stores, places
where data lives.

- [See **Config** package-info](@linkplain berlin.charles.addressbook.config#package-info.java) for details.
All of these class interactions are modeled in the **Config** package which explicitly instantiates objects with dependencies
in their constructors. If ClassA relies on ClassB, then ClassB is a dependency of ClassA and ClassA constructor will
look like this:
  
            public ClassA (final ClassB obj) {
                this.obj = obj;
            }
- [See **Packets** package-info](@linkplain berlin/charles/addressbook.packets#package-info.java) for details. These
classes handle Request validation, encapsulation of user parameters into Requests, and Response encapsulation.
            

