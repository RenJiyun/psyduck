package com.eggip.pikachu;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CompletableFuture1 {

    public Future<Double> getPriceSync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);

        }).start();
        return futurePrice;
    }

    public static double calculatePrice(String product) {
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
