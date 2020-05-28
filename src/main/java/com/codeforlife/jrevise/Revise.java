package com.codeforlife.jrevise;

abstract class AbstractServer {

    private final String name;

    public AbstractServer(String name) {
        this.name = name;
    }

    protected void start() {
        startImpl();
        System.out.println(" hello world");
    }

    protected abstract void startImpl();
}

abstract class AdminServer extends AbstractServer {

    public AdminServer(String name) {
        super(name);
    }

    @Override
    protected void startImpl() {
        System.out.println(" startImpl from adminServer");
    }
}

abstract class HttpAdminServer extends AdminServer {
    protected HttpAdminServer(String name) {
        super(name);
    }

    protected void startImpl() {
        super.startImpl();
        System.out.println(" startImpl from httpAdminServer");
    }
}

class Work extends HttpAdminServer {
    private Work() {
        super("work is my name ..");
    }

    public static void run() {
        new Work().start();
        // new Work().exec();
        //new Work().startImpl();
    }

    public void exec() {
        super.startImpl();
    }

}

public class Revise {
    public static void main(String[] args) {
        Work.run();
    }
}
