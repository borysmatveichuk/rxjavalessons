import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class BackpressureTest {
    public static void main(String[] args) {
        Observable.range(1, 1_000_000)
                .observeOn(Schedulers.computation())
                .subscribe(ComputeFunction::compute);
    }

    public static class ComputeFunction {
        public static void compute(Integer v) {
            try {
                System.out.println("compute integer v: " + v);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


