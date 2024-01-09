//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
//        implementRunnable();
        producerConsumer();
        System.out.println("\nend");
    }

    public static void implementRunnable(){
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("I am running in thread "+ name);
        };

        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public static void producerConsumer() throws InterruptedException {
        var producer = new ProducerConsumer.Producer();
        var consumer = new ProducerConsumer.Consumer();

        Runnable produceTask = () -> {
            for(int i = 0; i < 50; i++){
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            for(int i = 0; i < 50; i++){
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Done consuming");
        };

        Thread comsumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        comsumerThread.start();
        producerThread.start();

        comsumerThread.join();
        producerThread.join();

        System.out.println("data: " + ProducerConsumer.getCount());
    }

}