package pbouda.youtube.finalkeyword;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.I_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

@JCStressTest
@Outcome(id = "-1", expect = ACCEPTABLE, desc = "Object is not seen yet.")
@Outcome(id = {"0", "1", "2", "3", "4", "5", "6", "7"}, expect = ACCEPTABLE_INTERESTING, desc = "Seeing partially constructed object.")
@Outcome(id = "8", expect = ACCEPTABLE, desc = "Seen the complete object.")
@State
public class PlainInit {
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
            r.r1 = o.x8 + o.x7 + o.x6 + o.x5 + o.x4 + o.x3 + o.x2 + o.x1;
        } else {
            r.r1 = -1;
        }
    }

    public static class MyObject {
        int x1, x2, x3, x4;
        int x5, x6, x7, x8;

        public MyObject(int v) {
            x1 = v;
            x2 = v;
            x3 = v;
            x4 = v;
            x5 = v;
            x6 = v;
            x7 = v;
            x8 = v;
        }
    }
}