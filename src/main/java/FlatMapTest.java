import io.reactivex.Observable;

public class FlatMapTest {
    public static void main(String[] args) {

    }

    Observable<String> getTitle() {
        String[] titleList = {"Article a", "Article b", "Article c", "Article d", "Article e", "Article f", "Article g"};
        return Observable.fromArray(titleList);
    }
}
