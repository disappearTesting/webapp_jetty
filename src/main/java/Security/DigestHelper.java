package Security;

import java.util.UUID;

public class DigestHelper {

    public static String getUuid(){

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}