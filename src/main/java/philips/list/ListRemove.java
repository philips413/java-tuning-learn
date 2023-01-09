package philips.list;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.Throughput})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
public class ListRemove {

    int LOOP_COUNT = 10;

    List<Integer> arrayList;
    List<Integer> vector;
    List<Integer> linkedList;

    @Setup(Level.Trial)
    public void setUp() {
        arrayList = new ArrayList<Integer>();
        vector = new Vector<Integer>();
        linkedList = new LinkedList<Integer>();
        for(int loop = 0 ; loop < LOOP_COUNT; loop++) {
            arrayList.add(loop);
            vector.add(loop);
            linkedList.add(loop);
        }
    }

    @Benchmark
    public void removeArrayListFromFirst() {
        ArrayList<Integer> integers = new ArrayList<>(arrayList);
        for(int loop = 0 ; loop < LOOP_COUNT; loop++) {
            integers.remove(0);
        }
    }

    @Benchmark
    public void removeVectorFromFirst() {
        Vector<Integer> integers = new Vector<>(vector);
        for(int loop = 0 ; loop < LOOP_COUNT; loop++) {
            integers.remove(0);
        }
    }

    @Benchmark
    public void removeLinkedListFromFirst() {
        LinkedList<Integer> integers = new LinkedList<>(linkedList);
        for(int loop = 0 ; loop < LOOP_COUNT; loop++) {
            integers.remove(0);
        }
    }

    @Benchmark
    public void removeArrayListFromLast() {
        ArrayList<Integer> integers = new ArrayList<>(arrayList);
        for (int loop = LOOP_COUNT-1; loop >= 0 ; loop--){
            integers.remove(loop);
        }
    }

    @Benchmark
    public void removeVectorFromLast() {
        Vector<Integer> integers = new Vector<>(vector);
        for (int loop = LOOP_COUNT-1; loop >= 0 ; loop--){
            integers.remove(loop);
        }
    }

    @Benchmark
    public void removeLinkedListFromLast() {
        LinkedList<Integer> integers = new LinkedList<>(linkedList);
        for (int loop = LOOP_COUNT-1; loop >= 0 ; loop--){
            integers.remove(loop);
        }
    }

}
