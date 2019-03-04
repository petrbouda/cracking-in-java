package pbouda.youtube.finalkeyword;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.I_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.FORBIDDEN;

@JCStressTest
@Outcome(id = "-1", expect = ACCEPTABLE, desc = "Object is not seen yet.")
@Outcome(id = "8", expect = ACCEPTABLE, desc = "Seen the complete object.")
@Outcome(expect = FORBIDDEN, desc = "Seeing partially constructed object.")
@State
public class OnlyOneInit {
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
        final int x1;
        final int x2, x3, x4;
        final int x5, x6, x7, x8;

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