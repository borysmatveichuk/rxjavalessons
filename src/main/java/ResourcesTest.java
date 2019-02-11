import io.reactivex.Observable;

public class ResourcesTest {
    public static void main(String[] args) {
        String[] result = {""};
        Observable<Character> values = Observable.using(
                () -> "NewResource",
                r -> {
                    return Observable.create(o -> {
                        for (Character c : r.toCharArray()) {
                            o.onNext(c);
                        }
                        o.onComplete();
                    });
                },
                r -> System.out.println("Disposed: " + r)
        );

        values.subscribe(
                v -> result[0] += v,
                e -> result[0] += e
        );

        System.out.println("Result: " + result[0]);
    }
}
