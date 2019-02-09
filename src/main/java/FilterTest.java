import io.reactivex.Observable;

import java.util.Arrays;

public class FilterTest {
    private static String[] EVEN = {""};

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Observable.fromArray(numbers)
                .filter(i -> 0 == (i % 2))
                .subscribe(
                        (number -> EVEN[0] += number),
                        (Throwable::printStackTrace)
                );

        System.out.println(Arrays.toString(EVEN));
    }
}
