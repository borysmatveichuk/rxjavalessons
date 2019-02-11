import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleTest {
    public static void main(String[] args) {
        String[] result = {""};
        Single<String> single = Observable.just("Hello")
                .singleOrError()
                .doOnSuccess(i -> result[0] += i)
                .doOnError(error -> {
                    throw new RuntimeException(error.getMessage());
                } );

        single.subscribe();

        System.out.println("Result: " + result[0]);
    }
}
