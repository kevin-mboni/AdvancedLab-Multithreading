package lms.Main;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // Thread-safe
        Map<String, Integer> concurrencyMap = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Lthread(concurrencyMap, i));
        }

        do {
            executorService.shutdown();
        } while (!executorService.isTerminated());

        Lthread t1 = new Lthread(concurrencyMap, 2);
        Thread safeThreads = new Thread(t1);
        safeThreads.start();
    }
}