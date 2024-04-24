import java.util.concurrent.Semaphore;
class Fork extends Semaphore {
    public Fork() {
        super(1, true); // Ініціалізуємо семафор з одним дозволом
    }
}
