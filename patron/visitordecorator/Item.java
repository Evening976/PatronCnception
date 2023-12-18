package patron.visitordecorator;

public interface Item {
    String name();

    Double price();

    <T> T accept(ItemVisitor<T> visitor);
}
