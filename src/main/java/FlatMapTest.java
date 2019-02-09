import io.reactivex.Observable;

public class FlatMapTest {
    public static void main(String[] args) {
        Observable.just("Book 1", "Book 2", "Book 3")
                .flatMap(s -> getTitle())
                .subscribe(System.out::println);
    }

    public static Observable<String> getTitle() {
        String[] titleList = {"Article a", "Article b", "Article c", "Article d", "Article e", "Article f", "Article g"};
        return Observable.fromArray(titleList);
    }
}
