package pbouda.youtube.finalkeyword;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.I_Result;

import java.util.ArrayList;
import java.util.List;

import static org.openjdk.jcstress.annotations.Expect.*;

@JCStressTest
@Outcome(id = "-1", expect = ACCEPTABLE, desc = "Collection is not seen yet.")
@Outcome(id = {"0", "1", "2", "3", "4", "5", "6", "7"}, expect = ACCEPTABLE_INTERESTING, desc = "Seeing partially constructed collection.")
@State
@SuppressWarnings("ALL")
public class PlainCollection {
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
            r.r1 = o.ints.stream().mapToInt(Integer::intValue).sum();
        } else {
            r.r1 = -1;
        }
    }

    public static class MyObject {
        List<Integer> ints;

        public MyObject(int v) {
            ints = new ArrayList<>();
            ints.add(v);
            ints.add(v);
            ints.add(v);
            ints.add(v);
            ints.add(v);
            ints.add(v);
            ints.add(v);
        }
    }
}