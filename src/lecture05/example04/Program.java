package lecture05.example04;

public class Program {
    public static void main(String args[]) {
    MyThread ob1 = new MyThread("One");
    MyThread ob2 = new MyThread("Two");
    MyThread ob3 = new MyThread("Three");

    System.out.println("Thread One is alive: "
            + ob1.t.isAlive());
    System.out.println("Thread Two is alive: "
            + ob2.t.isAlive());
    System.out.println("Thread Three is alive: "
            + ob3.t.isAlive());
    try {
        System.out.println("Waiting for threads to finish.");
        ob1.t.join();
        ob2.t.join();
        ob3.t.join();
    } catch (InterruptedException e) {
        System.out.println("Main thread Interrupted");
    }

    System.out.println("Thread One is alive: "
            + ob1.t.isAlive());
    System.out.println("Thread Two is alive: "
            + ob2.t.isAlive());
    System.out.println("Thread Three is alive: "
            + ob3.t.isAlive());

    System.out.println("Main thread exiting.");
}
}
