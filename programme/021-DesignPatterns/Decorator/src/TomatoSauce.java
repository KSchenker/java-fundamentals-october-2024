public class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("TomatoSauce Constructor: Adding Sauce");
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", Tomato Sauce";  //Rückruf an PlainPizza
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 0.35;               //Rückruf an PlainPizza
    }
}