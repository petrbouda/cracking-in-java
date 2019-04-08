package pbouda.cracking.locks;

import java.util.concurrent.atomic.AtomicBoolean;

public class TASLock {

    private final AtomicBoolean state = new AtomicBoolean(false);

    public void lock() {
        while (state.getAndSet(true)) {
        }
    }

    public void unlock() {
        state.set(false);
    }
}
