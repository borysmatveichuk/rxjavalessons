import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class SubjectTest {

    private Integer subscriber1 = 0;
    private Integer subscriber2 = 0;

    public static void main(String[] args) {

        PublishSubject<Integer> subject = PublishSubject.create();
        SubjectTest test = new SubjectTest();
        subject.subscribe(test.getFirstObserver());
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
        subject.subscribe(test.getSecondObserver());
        subject.onNext(4);
        subject.onComplete();

        System.out.println("Subscriber1: " + test.subscriber1);
        System.out.println("Subscriber2: " + test.subscriber2);
    }


    Observer<Integer> getFirstObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                subscriber1 += integer;
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("Subscriber 1 completed.");
            }
        };
    }

    Observer<Integer> getSecondObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                subscriber2 += integer;
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("Subscriber 2 completed.");
            }
        };
    }
}