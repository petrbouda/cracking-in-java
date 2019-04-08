package pbouda.cracking.atomicupdater;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private final AtomicInteger counter = new AtomicInteger();

    public int incrementAndGet() {
        return counter.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(VM.current().details());

        System.out.println(ClassLayout.parseClass(AtomicCounter.class).toPrintable());
        System.out.println(ClassLayout.parseClass(AtomicInteger.class).toPrintable());
    }
}
