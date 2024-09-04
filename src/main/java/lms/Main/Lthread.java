package lms.Main;

import java.util.Map;

public class Lthread implements Runnable {
    int threadsNumber;
    private final Map<String, Integer> map;
    public Lthread(Map<String, Integer> map ,int threadsNumber) {
        this.threadsNumber = threadsNumber;
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (map) {
                map.put("key " + threadsNumber+ " _ " +i, i);
                System.out.println("key "+ i+ " added on thread number " + threadsNumber);
            }
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
