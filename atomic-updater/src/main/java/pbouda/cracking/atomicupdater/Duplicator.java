package pbouda.cracking.atomicupdater;

public class Duplicator {

    public static void main(String[] args) throws InterruptedException {
        int count = 1_000_000;
        AtomicUpdater[] cache = new AtomicUpdater[count];
        for (int i = 0; i < count; i++) {
//            cache[i] = new AtomicCounter();
            cache[i] = new AtomicUpdater();
        }

        System.out.println("DONE!");
        Thread.currentThread().join();
    }
}
