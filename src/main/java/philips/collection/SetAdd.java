package philips.collection;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Chapter 4. Collection부분에 나오는 소스코드
 * HashSet, TreeSet, LinkedHashSet에 대한 성능비교가 나온다.
 * 여기에서 중요한 것은 TreeSet이 성능이 느리지만 나올수밖에 없는 이유는 넣자마자 정렬이 되기 때문이다.
 * TreeSet은 NavigableSet 클래스를 상속받기 때문에 삽입시에는 느리다 .
 * 데이터 순서대로 탐색시에는 TreeSet을 사용하도록 하자
 *
 */

@State(Scope.Thread)
@BenchmarkMode({Mode.Throughput, Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
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
