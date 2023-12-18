package patron.visitordecorator;

public class Book implements Item {
    public Double price, numberOfpages;
    public String name;
    public Double price() {return price;}

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public String name() {return name;}
    public Double numberOfpages(){return numberOfpages;}
}
