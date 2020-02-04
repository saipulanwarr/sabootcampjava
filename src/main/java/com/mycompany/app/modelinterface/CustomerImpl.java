package com.mycompany.app.modelinterface;

public class CustomerImpl implements CustomerService, DrawService {

    private String name;
    private String state;
    private String city;
    private String district;
    private String address;
    private int phoneNumber;
    private int postalCode;
    private String addressOptional;
    private String addressPrimary;

    @Override
    public void setProfile(String name, String state, String city, String district, String address, int phoneNumber, int postalCode) {
        this.name = name;
        this.state = state;
        this.city = city;
        this.district = district;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
    }

    @Override
    public void setAddressPrimary(String addressPrimary) {
        this.addressPrimary = addressPrimary;
    }

    public void setAddressOptional(String addressOptional){
        this.addressOptional = addressOptional;
    }

    @Override
    public void getProfile(){
        System.out.println(name + " " + state + " " + city + " " + district + " " + address + " " + phoneNumber + " " + postalCode + " " + addressOptional + " " + addressPrimary);
    }

    @Override
    public void circle() {
        System.out.println("Draw Circle");
    }

    @Override
    public void rectangle() {
        System.out.println("Draw Rectangle");
    }

    @Override
    public void lineGraphic() {
        System.out.println("Draw line graphic");
    }
}
