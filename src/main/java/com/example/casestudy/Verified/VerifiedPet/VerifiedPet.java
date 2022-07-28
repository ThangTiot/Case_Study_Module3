package com.example.casestudy.Verified.VerifiedPet;

import java.util.regex.Pattern;

public class VerifiedPet {
    public boolean verifiedAge(String age) {
        String regex = "^[0-9]{2}$";
        boolean result = Pattern.matches(regex,age);
        return result;
    }
}
