package philips.collection;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
public class SetIterate {
    int LOOP_COUNT = 1000;
    Set<String> hashSet;
    Set<String> treeSet;
    Set<String> linkedHashSet;

    String data= "abcdefghijklmnopqrstuvwxyz";
    String[] keys;

    String result =null;
    @Setup(Level.Trial)
    public void setup() {
        hashSet= new HashSet<String>();
        treeSet= new TreeSet<String>();
        linkedHashSet = new LinkedHashSet<String>();

        for (int loop=0;loop<LOOP_COUNT;loop++) {
            String tempData = data+loop;
            hashSet.add(tempData);
            treeSet.add(tempData);
            linkedHashSet.add(tempData);
        }
    }

    @Benchmark
    public void iterateHashSet() {
        Iterator<String> iter = hashSet.iterator();
        while (iter.hasNext()) {
            result = iter.next();
        }
    }

    @Benchmark
    public void iterateTreeset() {
        Iterator<String> iter = treeSet.iterator();
        while (iter.hasNext()) {
            result = iter.next();
        }
    }

    @Benchmark
    public void iterateLinkedHashSet() {
        Iterator<String> iter = linkedHashSet.iterator();
        while(iter.hasNext()) {
            result = iter.next();
        }
    }
}
