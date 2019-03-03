import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class CreateObservable {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        log("Before");
        Observable
                .range(5, 3)
                .subscribe(i -> {
                    log(i);
                });
        log("After");

        Observable<Integer> ints =
                Observable.<Integer>create(subscriber -> {
                            log("Create");
                            subscriber.onNext(42);
                            subscriber.onComplete();
                        }
                ).cache();
        log("Starting");
        ints.subscribe(i -> log("Element A: " + i));
        ints.subscribe(i -> log("Element B: " + i));
        log("Exit");

    }

    private static void log(Object msg) {
        System.out.println(
                Thread.currentThread().getName() +
                        ": " + msg);
    }
}
