package pbouda.cracking.locks;

import java.util.concurrent.atomic.AtomicBoolean;

public class TTASLock {

    private final AtomicBoolean state = new AtomicBoolean(false);

    public void lock() {
        while (true) {
            while (state.get()) {}
            if (!state.getAndSet(true)) {
                return;
            }
        }
    }

    public void unlock() {
        state.set(false);
    }
}
