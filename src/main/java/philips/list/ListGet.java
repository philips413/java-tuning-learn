package philips.list;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Chapter 4. List중에서 성능이 좋은 부분
 * ArrayList를 많이 쓰지만, 여러가지 것들이 존재했다.
 * 데이터 삽입하는 것은 모두들 비슷비슷한 성능이었지만, 가져오는 부분에 대해서는 성능차이가 있었다.
 * ArrayList는 불러오는 부분이 가장 빨랐고, Vector가 그다음이고, LinkedList가 제일 느렸었다.
 * 이유는 LinkedList는 Queue 인터페이스를 구현하고 있어서 그런것 같다.
 * 순차적으로 하기 위해서는 LinkedList에서 peek()로 가져오는 것이 제일 좋은 것 같다.
 *
 */
@State(Scope.Thread)
@BenchmarkMode({Mode.Throughput})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
public class ListGet {

    int LOOP_COUNT = 1000;
    List<Integer> arrayList;
    List<Integer> vector;
    List<Integer> linkedList;
    LinkedList<Integer> linkedListPeek;

    int result = 0;
    @Setup
    public void setUp() {
        arrayList = new ArrayList<Integer>();
        vector = new Vector<Integer>();
        linkedList = new LinkedList<Integer>();
        linkedListPeek = new LinkedList<Integer>();

        for (int loop = 0 ; loop < LOOP_COUNT ; loop++) {
            arrayList.add(loop);
            vector.add(loop);
            linkedList.add(loop);
            linkedListPeek.add(loop);
        }
    }

    @Benchmark
    public void getArrayList() {
        for (int loop = 0 ; loop < LOOP_COUNT; loop++) {
            result = arrayList.get(loop);
        }
    }

    @Benchmark
    public void getVector() {
        for (int loop = 0 ; loop < LOOP_COUNT; loop++) {
            result = vector.get(loop);
        }
    }


    @Benchmark
    public void getLinkedList() {
        for (int loop = 0 ; loop < LOOP_COUNT; loop++) {
            result = linkedList.get(loop);
        }
    }

    @Benchmark
    public void getLinkedListForPeek() {
        for (int loop = 0 ; loop < LOOP_COUNT; loop++) {
            result = linkedListPeek.peek();
        }
    }


}
