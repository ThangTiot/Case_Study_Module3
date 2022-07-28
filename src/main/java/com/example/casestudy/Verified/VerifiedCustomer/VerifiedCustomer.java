package com.example.casestudy.Verified.VerifiedCustomer;

import java.util.regex.Pattern;

public class VerifiedCustomer {
    public boolean verifiedPassword(String password) {
        String regex = "^[A-Z][a-zA-Z0-9]{7,}$";
        boolean result = Pattern.matches(regex,password);
        return result;
    }

    public boolean verifiedPhoneNumber(String phoneNumber) {
        String regex = "^[0-9]{10}$";
        boolean result = Pattern.matches(regex,phoneNumber);
        return result;
    }
    public boolean verifiedEmail(String email) {
        String regex = "^[A-Za-z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)$";
        boolean result = Pattern.matches(regex,email);
        return result;
    }
}
