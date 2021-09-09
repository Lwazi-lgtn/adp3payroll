package za.ac.cput.Util;

import java.util.UUID;

public class GenericHelper {
    public static String generateId() {

        return UUID.randomUUID().toString();
    }
    public static boolean isNullorEmpty(String s){
        if(s == null || s.isEmpty())
            return true;
        else
            return false;
    }
}
