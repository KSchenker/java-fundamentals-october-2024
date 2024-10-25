public class PizzaMaker {

    public static void main(String[] args) {

        Pizza decoratedPizza = new TomatoSauce(new Mozzarella(new PlainPizza())); //Aufruf an alle diese  verschiedene  Konstruktoren
        System.out.println("Decorated Pizza Ingredients: " + decoratedPizza.getDescription());
        System.out.println("Decorated Pizza Price: " + decoratedPizza.getCost());
        System.out.println();

        Pizza margarita = new Mozzarella(new TomatoSauce(new PlainPizza()));
        System.out.println("Pizza Margarita Ingredients: " + margarita.getDescription());
        System.out.println("Pizza Margarita Costs: " + margarita.getCost());
        System.out.println();

        Pizza diavolo = new SalamiTopping(new TomatoSauce(new PlainPizza()));
        System.out.println("Pizza Diavolo Ingredients: " + diavolo.getDescription());
        System.out.printf("Pizza Diavolo Costs: %.2f€", diavolo.getCost());

    }
}
