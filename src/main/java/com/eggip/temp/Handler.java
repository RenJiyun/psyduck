package com.eggip.temp;

import java.util.List;

public interface Handler {
    void handle(String request);
}


class AHandler implements Handler {

    @Override
    public void handle(String request) {
        System.out.println("A");
    }
}

class BHandler implements Handler {

    @Override
    public void handle(String request) {
        System.out.println("B");
    }
}

class ListHandler implements Handler {
    private List<Handler> handlerList;

    @Override
    public void handle(String request) {
        for (Handler handler : handlerList) {
            handler.handle(request);
        }
    }
}


