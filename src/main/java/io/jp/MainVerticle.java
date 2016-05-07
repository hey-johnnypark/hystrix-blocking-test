package io.jp;

import io.vertx.core.Vertx;

public class MainVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(HystrixVerticle.class.getName());

        vertx.setTimer(2000, e -> {
            vertx.close();
        });
    }

}
