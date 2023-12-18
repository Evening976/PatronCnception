package patron.visitordecorator;

public class Food implements Item {
    public String name;
    public double price, peremptionDate;

    @Override
    public Double price() {
        return price;
    }

    @Override
    public String name() {
        return name;
    }

    public double peremptionDate() {
        return peremptionDate;
    }

    @Override
    public <T> T accept(ItemVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
