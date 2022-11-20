package org.tugas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatUtil {

    public static Boolean isPassword(String input){
        Pattern pattern = Pattern.compile("^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d).{8,}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static Boolean isAlfabet(String input){
        Pattern pattern = Pattern.compile("^[A-Za-z\\s]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static Boolean isEmail(String input) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static Boolean isPhoneNuber(String input) {
        Pattern pattern = Pattern.compile("\\+?([ -]?\\d+)+|\\(\\d+\\)([ -]\\d+)");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
