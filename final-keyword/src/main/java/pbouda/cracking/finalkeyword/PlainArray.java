package pbouda.cracking.finalkeyword;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.I_Result;

import java.util.Arrays;

import static org.openjdk.jcstress.annotations.Expect.*;

@JCStressTest
@Outcome(id = "-1", expect = ACCEPTABLE, desc = "Array is not seen yet.")
@Outcome(id = {"0", "1", "2", "3", "4", "5", "6", "7"}, expect = ACCEPTABLE_INTERESTING, desc = "Seeing partially constructed array.")
@State
@SuppressWarnings("ALL")
public class PlainArray {
    int v = 1;

    MyObject o;

    @Actor
    public void actor1() {
        o = new MyObject(v);
    }

    @Actor
    public void actor2(I_Result r) {
        MyObject o = this.o;
        if (o != null) {
            r.r1 = Arrays.stream(o.ints).sum();
        } else {
            r.r1 = -1;
        }
    }

    public static class MyObject {
        int[] ints;

        public MyObject(int v) {
            ints = new int[8];
            ints[0] = v;
            ints[1] = v;
            ints[2] = v;
            ints[3] = v;
            ints[4] = v;
            ints[5] = v;
            ints[6] = v;
        }
    }
}