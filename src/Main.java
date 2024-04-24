import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }

        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i + 1, forks[i], forks[(i + 1) % 5]);
            philosophers[i].start();
        }
    }
}