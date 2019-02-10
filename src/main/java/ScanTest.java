import io.reactivex.Observable;

public class ScanTest {
    private static String result = "";
    private static Integer resultInt = 0;

    public static void main(String[] args) {
        String[] letters = {"a", "B", "c", "d"};
        Observable.fromArray(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(total -> result += total.toString());

        System.out.println(result);

        Integer[] numbers = {1, 2, 3, 4, 5};
        Observable.fromArray(numbers)
                .scan((integer, integer2) -> {

                    System.out.println("integer " + integer);
                    System.out.println("integer2 " + integer2);
                    return integer + integer2;
                })
                .subscribe(total -> {
                    resultInt = total;
                    System.out.println("total " + total);
                });

        System.out.println("total " + resultInt);
    }
}
