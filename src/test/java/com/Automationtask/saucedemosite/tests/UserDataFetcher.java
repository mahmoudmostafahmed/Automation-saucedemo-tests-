package com.Automationtask.saucedemosite.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.fluent.Request;

public class UserDataFetcher {

    public static String[] fetchRandomUserData() throws Exception {
        String response = Request.get("https://jsonplaceholder.typicode.com/users/1")
                .execute().returnContent().asString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);

        String[] nameParts = node.get("name").asText().split(" ");
        String firstName = nameParts.length > 0 ? nameParts[0] : "John";
        String lastName = nameParts.length > 1 ? nameParts[1] : "Doe";
        String zip = node.get("address").get("zipcode").asText();

        return new String[]{firstName, lastName, zip};
    }
}
