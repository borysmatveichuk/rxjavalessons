import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ConnectableTest {
    public static void main(String[] args) throws Exception {
        String[] result = {""};
        ConnectableObservable<Long> connectable =
                Observable.interval(200, TimeUnit.MILLISECONDS).publish();

        connectable.subscribe(i -> result[0] += i);
        System.out.println("After subscribe: " + result[0]);

        connectable.connect();
        Thread.sleep(1000);
        System.out.println("After connect: " + result[0]);
    }
}
