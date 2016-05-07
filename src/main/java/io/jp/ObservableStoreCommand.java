package io.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class ObservableStoreCommand extends HystrixObservableCommand<Long> {

    private static Logger LOG = LoggerFactory.getLogger(ObservableStoreCommand.class);

    protected ObservableStoreCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(ObservableStoreCommand.class.getSimpleName())));
    }

    @Override
    protected Observable<Long> construct() {
        LOG.info("construct()");
        return Observable.create(new OnSubscribe<Long>() {

            @Override
            public void call(Subscriber<? super Long> observer) {
                LOG.info("call()");
                observer.onNext(new Long(0));
                observer.onCompleted();
            }

        });
    }

}
