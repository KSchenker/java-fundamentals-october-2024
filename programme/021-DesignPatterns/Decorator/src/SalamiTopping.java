public class SalamiTopping extends ToppingDecorator {

    public SalamiTopping(Pizza newPizza) {
        super(newPizza);
        System.out.println("Salami Topping Constructor: Adding hot salami");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Hot Salami";
    }

    @Override
    public double getCost() {
        // Scharfe Salami kostet 1.95 extra.
        return super.getCost() + 1.95;
    }
}
