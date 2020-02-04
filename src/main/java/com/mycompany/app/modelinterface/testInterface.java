package com.mycompany.app.modelinterface;

public class testInterface {
    public testInterface(){
        CustomerService customer = new CustomerImpl();
        DrawService cusDraw = new CustomerImpl();

        customer.setProfile("kanata", "indonesia", "bogor", "bantarjati", "bogor utara", 1223132131, 1321312);
        customer.setAddressOptional("address optional");
        customer.setAddressPrimary("address primary");
        customer.getProfile();

        cusDraw.circle();
    }

    public static void main(String[] args){
        new testInterface();
    }
}
