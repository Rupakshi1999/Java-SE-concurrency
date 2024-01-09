public class ProducerConsumer {
    private static int count = 0;

    private static  int[] buffer = new int[10];
    private Object lock;

    public Producer producer() {
        return new Producer();
    }

    public Consumer consumer() {
        return new Consumer();
    }

    public static class Producer {
        public void produce() {
            while(isFull(buffer)){}
            buffer[count++] = 1;
        }
    }

    public static class Consumer {
        public void consume() {
            while(isEmpty(buffer)){}
            buffer[--count] = 0;
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
