import io.reactivex.Observable;

import java.util.Arrays;

public class GroupByTest {
    private static String[] EVEN = {""};
    private static String[] ODD = {""};

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Observable.fromArray(numbers)
                .groupBy(i -> 0 == (i % 2) ? "EVEN" : "ODD")
                .subscribe((group ->

                        group.subscribe((number) -> {
                            System.out.println("group = " + group.getKey());
                            System.out.println("number = " + number);
                            if (group.getKey().equals("EVEN")) {
                                EVEN[0] += number;
                            } else {
                                ODD[0] += number;
                            }
                        })
                ), (Throwable::printStackTrace)
                );

        System.out.println(Arrays.toString(EVEN));
        System.out.println(Arrays.toString(ODD));
    }
}
