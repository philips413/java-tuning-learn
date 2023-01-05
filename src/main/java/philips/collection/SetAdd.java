package philips.collection;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
public class SetAdd {

    int LOOP_COUNT=1000;
    Set<String> set;
    String data = "abcdefghijklmnopqrstuvwxyz";


    @Benchmark
    public void addHashSet() {
        set = new HashSet<String>();
        for(int loop=0;loop<LOOP_COUNT;loop++) {
            set.add(data+loop);
        }
    }

    @Benchmark
    public void addTreeSet() {
        set = new TreeSet<String>();
        for(int loop=0;loop<LOOP_COUNT;loop++) {
            set.add(data+loop);
        }
    }

    @Benchmark
    public void addLinkedHashSet() {
        set = new LinkedHashSet<String>();
        for(int loop=0;loop<LOOP_COUNT;loop++) {
            set.add(data+loop);
        }
    }

    @Benchmark
    public void addHashSetWithInitialSize() {
        set = new HashSet<String>(LOOP_COUNT);
        for(int loop=0;loop<LOOP_COUNT;loop++) {
            set.add(data+loop);
        }
    }

}
