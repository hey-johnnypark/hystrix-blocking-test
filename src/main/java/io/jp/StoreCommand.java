package io.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class StoreCommand extends HystrixCommand<Long> {

    private static Logger LOG = LoggerFactory.getLogger(StoreCommand.class);

    protected StoreCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(StoreCommand.class.getSimpleName())));
    }

    @Override
    protected Long run() throws Exception {
        LOG.info("run()");
        return new Long(666);
    }

}
