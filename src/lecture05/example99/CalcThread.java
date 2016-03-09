package lecture05.example99;

public class CalcThread implements Runnable {
    Thread thread;
    Main main;
    int number;

    public CalcThread(Main main, int number) {
        thread = new Thread(this);
        this.main = main;
        this.number = number;
        thread.start();
    }

    @Override
    public void run() {
        main.setFire(number);
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(50);
                main.setProgress(number, i/100.0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.setStart(number);
        main.setProgress(number, 0.0);
    }
}