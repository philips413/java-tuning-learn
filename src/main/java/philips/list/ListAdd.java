package philips.list;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.Throughput, Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
public class ListAdd {

    int LOOP_COUNT = 1000;
    List<Integer> arrayList;
    List<Integer> vector;
    List<Integer> linkedList;

    @Benchmark
    public void addArrayList() {
        arrayList = new ArrayList<Integer>();
        for (int loop = 0 ; loop < LOOP_COUNT ; loop++) {
            arrayList.add(loop);
        }
    }

    @Benchmark
    public void addVector() {
        arrayList = new Vector<Integer>();
        for (int loop = 0 ; loop < LOOP_COUNT ; loop++) {
            arrayList.add(loop);
        }
    }

    @Benchmark
    public void addLinkedList() {
        arrayList = new LinkedList<Integer>();
        for (int loop = 0 ; loop < LOOP_COUNT ; loop++) {
            arrayList.add(loop);
        }
    }

}
