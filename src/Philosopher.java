import java.util.concurrent.Semaphore;
class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Philosopher " + id + " thinking");
                sleep(1000); // Філософ роздумує протягом 1 секунди

                System.out.println("Philosopher " + id + " waiting for forks");
                if (id % 2 == 0) { // Якщо id парне, то захоплюємо виделки в зворотному порядку
                    rightFork.acquire();
                    leftFork.acquire();
                } else {
                    leftFork.acquire();
                    rightFork.acquire();
                }
                System.out.println("Philosopher " + id + " eating");
                sleep(1000); // Філософ їсть протягом 1 секунди

                leftFork.release();
                rightFork.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
