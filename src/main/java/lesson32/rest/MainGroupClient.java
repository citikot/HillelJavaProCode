package lesson32.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author spasko
 */
public class MainGroupClient {

    public static void main(String[] args) {
        try {

            HttpURLConnection conn = getGroup();
            showInfo(conn);

            conn = addStudent("123/students");
            showInfo(conn);

            conn = addStudent("18122018/students");
            showInfo(conn);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void showInfo(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK
                && conn.getResponseCode() != HttpURLConnection.HTTP_ACCEPTED) {
            System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
            return;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        conn.disconnect();
    }

    private static HttpURLConnection addStudent(String pathParam) throws IOException {
        URL url = new URL("http://localhost:9998/api/" + pathParam);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        String input = "{\"name\": \"Rebecca\",\"yearOfBorn\": 1907	}";

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();
        return conn;
    }

    private static HttpURLConnection getGroup() throws IOException {
        URL url = new URL("http://localhost:9998/api/18122018");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        return conn;
    }

}
