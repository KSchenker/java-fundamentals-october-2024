public class Mozzarella extends ToppingDecorator {

    public Mozzarella(Pizza newPizza) { //Konstruktor für Pizza, referenz auf PlainPizza
        super(newPizza);   // Aufruf an  newPizza, Referenz auf ToppingDecorator

        System.out.println("Mozzarella Constructor: Adding Dough"); //von PlainPizza
        System.out.println("Mozzarella Constructor: Adding Mozz");
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", Mozzarella";   //Rückruf an PlainPizza, add Mozzarella in Desription
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 0.50;             // Rückruf an PlainPizza, add extra Kost

    }


}
