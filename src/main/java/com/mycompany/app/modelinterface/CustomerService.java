package com.mycompany.app.modelinterface;

public interface CustomerService {
    void setProfile(String name, String state, String city, String district, String address, int phoneNumber, int postalCode);
    void setAddressPrimary(String addressPrimary);
    void setAddressOptional(String addressOptional);
    void getProfile();
}
