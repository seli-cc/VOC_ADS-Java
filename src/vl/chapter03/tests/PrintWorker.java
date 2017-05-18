package vl.chapter03.tests;

import vl.chapter03.IWorker;

public class PrintWorker implements IWorker {
    public void work(Object data) {
        System.out.println(data);
    }
}
