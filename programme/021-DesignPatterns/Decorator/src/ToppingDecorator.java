abstract class ToppingDecorator implements Pizza {

    // und  Zugang auf alle Methoden von PlainPizza

    protected Pizza tempPizza;       // die enthält Referenz auf PlainPizza file

    public ToppingDecorator(Pizza newPizza) {   // ein Konstruktor , Referenz auf PlainPizza Objekt
        tempPizza = newPizza;              //ein Objekt, das Änderungen auf diese 2 Methoden addiert
    }

    public String getDescription() {
        return tempPizza.getDescription();
    }

    public double getCost() {
        return tempPizza.getCost();
    }

}

