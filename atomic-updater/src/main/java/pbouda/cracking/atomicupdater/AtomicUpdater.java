package pbouda.cracking.atomicupdater;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicUpdater {

    private volatile int counter = 0;

    private static final AtomicIntegerFieldUpdater<AtomicUpdater> ATOMIC_COUNTER =
            AtomicIntegerFieldUpdater.newUpdater(AtomicUpdater.class, "counter-xxx");

    public int incrementAndGet() {
        return ATOMIC_COUNTER.incrementAndGet(this);
    }

    public static void main(String[] args) {
        System.out.println(VM.current().details());

        System.out.println(ClassLayout.parseClass(AtomicUpdater.class).toPrintable());
        System.out.println(ClassLayout.parseInstance(ATOMIC_COUNTER).toPrintable());
    }
}
