package Servlets.security;

import java.util.UUID;

public class DigestHelper {

    public static String getUUID(){

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}