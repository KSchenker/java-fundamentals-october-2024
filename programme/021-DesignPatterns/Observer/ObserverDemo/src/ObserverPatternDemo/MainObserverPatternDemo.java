package ObserverPatternDemo;

public class MainObserverPatternDemo {
    public static void main(String[] args) {

        MessagePublisher publisher = new MessagePublisher();
        Listener listener1 = new MessageListener("Arnold Strong");
        Listener listener2 = new MessageListener("Uwe Neuer");
        Listener listener3 = new MessageListener("Alte Socke");
        Listener listener4 = new MessageListener("Hubert Mustermann");

        publisher.subscribe(listener1);
        publisher.subscribe(listener2);
        publisher.subscribe(listener3);
        publisher.subscribe(listener4);
        System.out.println("-".repeat(20));
        publisher.publish("Hallo, ihr Subscriber!");

        System.out.println("-".repeat(20));
        System.out.println("Alle Subscriber haben Ihre Nachricht erhalten\n");

        publisher.unsubscribe(listener3);

        System.out.println("-".repeat(20));
        publisher.publish("Goodbye, Ihr Subcriber!");
        System.out.println("-".repeat(20));
        System.out.println("Alle Subscriber ausser Alte Socke haben Ihre Nachricht erhalten.Er ist nicht mehr in der Subscriberliste\n");
        System.out.println("-".repeat(20));

    }
}
