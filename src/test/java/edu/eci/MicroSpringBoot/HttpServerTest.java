package edu.eci.MicroSpringBoot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.eci.MicroSpringBoot.framework.MicroSpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.*;

public class HttpServerTest {

    @BeforeAll
    public static void startServer() throws Exception {

        new Thread(() -> {
            try {
                MicroSpringBootApplication.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);
    }

    private String sendRequest(String endpoint) throws Exception {

        URL url = new URL("http://localhost:8080" + endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        return response.toString();
    }

    @Test
    public void testHelloEndpoint() throws Exception {

        String response = sendRequest("/hello");

        assertTrue(response.contains("Hello"),
                "The /hello endpoint should return Hello");
    }

    @Test
    public void testGreetingEndpointName() throws Exception {

        String response = sendRequest("/greeting?name=Camilo");

        assertTrue(response.contains("Camilo"),
                "The greeting endpoint should include the name");
    }

    @Test
    public void testPiEndpoint() throws Exception {

        String response = sendRequest("/pi");

        assertTrue(response.contains("3."),
                "The /pi endpoint should return a value of pi");
    }

    @Test
    public void testIndexPage() throws Exception {

        String response = sendRequest("/index.html");

        assertTrue(response.contains("AREP"),
                "Index page should contain the project title");
    }

    @Test
    public void testGreetingEndpont() throws Exception {

        String response = sendRequest("/greeting");

        assertTrue(response.contains("Hola World"),
                "The greeting endpoint should return a default greeting");
    }
}