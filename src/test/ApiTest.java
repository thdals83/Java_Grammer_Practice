package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApiTest {
    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 1000000; i++) {
            executorService.submit(() -> {
                urlTest();
            });
        }
        executorService.shutdown();
    }

    public static void urlTest() {
        URLConnection connection = null;
        try {
            URL url = new URL("http://localhost:8080/test");
            connection = url.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
