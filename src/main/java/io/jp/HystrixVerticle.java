package io.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;

public class HystrixVerticle extends AbstractVerticle {

    private static Logger LOG = LoggerFactory.getLogger(HystrixVerticle.class);

    @Override
    public void start() throws Exception {
        LOG.info("BEFORE");
        new StoreCommand().toObservable().subscribe(result -> {
            LOG.info("StoreCommand().toObservable().subscribe: {}", result);
        }, error -> {
            LOG.error("StoreCommand().toObservable().subscribe: ", error);
        });
        LOG.info("AFTER");
    }
    
    

}
