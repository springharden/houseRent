package utils;

import java.util.UUID;

public class UuidUtils {
    public static String getId(){
        String id = UUID.randomUUID().toString().replace("-","").toUpperCase();
        return id;
    }

    public static void main(String[] args) {
        System.out.println(UuidUtils.getId());
    }
}
