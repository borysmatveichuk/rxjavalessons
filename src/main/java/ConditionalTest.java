import io.reactivex.Observable;

public class ConditionalTest {
    public static void main(String[] args) {
        Observable.empty()
                .defaultIfEmpty("empty")
                .map(s -> s.toString().toUpperCase())
                .subscribe(System.out::println);

        String[] letters = {"a", "B", "c", "d"};
        Observable.fromArray(letters)
                .defaultIfEmpty("empty")
                .firstElement()
                .subscribe(System.out::println);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Observable.fromArray(numbers)
                .takeWhile(i -> i < 7)
                .subscribe(System.out::println);
    }
}
