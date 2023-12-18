package patron.visitordecorator;

public interface Visitor<S> {
    S visit(Book book);
    S visit(Food food);
}
