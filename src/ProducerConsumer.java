public class ProducerConsumer {
    private static int count = 0;

    private static  int[] buffer = new int[10];
    private static final Object lock = new Object();

    public Producer producer() {
        return new Producer();
    }

    public Consumer consumer() {
        return new Consumer();
    }

    public static class Producer {
        public void produce() throws InterruptedException {
            synchronized (lock) {
                if (isFull(buffer)) {
                    lock.wait();
                }
                buffer[count++] = 1;
                lock.notify();
            }
        }
    }

    public static class Consumer {
        public void consume() throws InterruptedException {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    lock.wait();
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }

    }

    private static boolean isEmpty(int[] buffer) {
        return count ==0;
    }
    private static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static int getCount() {
        return count;
    }

}
