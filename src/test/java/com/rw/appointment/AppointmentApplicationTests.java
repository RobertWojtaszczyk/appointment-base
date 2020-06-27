package com.rw.appointment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppointmentApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void regexUUIDTest() {
        final String regex = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}";
        final String regex2 =  "([a-fA-F0-9]{8}(-[a-fA-F0-9]{4}){4}[a-fA-F0-9]{8})";
        final String regex3 =  "^&lt;urn:uuid:(.{36})&gt;";
        // UUID uuid = UUID.fromString("32qffb1d-89cc-4a52-824c-73ff000f5f5c");
        String uuidString = "2effb1d-89cc-4a52-824c-73ff000f5f5c";

        //boolean isUuidValid = uuid.toString().matches(regex);
        boolean isUuidValid = uuidString.matches(regex);
        System.out.println("isUuidValid = " + isUuidValid);

        boolean isUuidValid2 = uuidString.matches(regex2);
        System.out.println("isUuidValid2 = " + isUuidValid2);

        boolean isUuidValid3 = uuidString.matches(regex3);
        System.out.println("isUuidValid3 = " + isUuidValid3);
    }
}
