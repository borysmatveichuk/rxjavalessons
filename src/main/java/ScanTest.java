import io.reactivex.Observable;

public class ScanTest {
    private static String result = "";

    public static void main(String[] args) {
        String[] letters = {"a", "B", "c", "d"};
        Observable.fromArray(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(total -> result += total.toString());

        System.out.println(result);
    }
}
