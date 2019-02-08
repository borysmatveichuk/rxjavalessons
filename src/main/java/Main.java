import io.reactivex.Observable;

public class Main {


    public static void main(String[] args) {

        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};

        Observable<String> observable = Observable.fromArray(letters);
        observable
                .map(String::toUpperCase)
                .subscribe(
                        System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Completed")
                );

    }
}
