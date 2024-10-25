public class PlainPizza implements Pizza {

    // implementiert Pizza-Interface mit alle  Methoden
    // jede Pizza wird basierend auf PlainPizza


    public PlainPizza() {
        super();
        System.out.println("PlainPizza Constructor: -");
    }

    @Override
    public String getDescription() {
        return "Thin Dough";     // jede Pizza hat dünner Teig
    }

    @Override
    public double getCost() {
        return 4.00;            //jede basic Pizza kostet 4€
    }
}


// auf diese Klasse PlainPizza addieren wir jetzt die Toppings