package patron.visitordecorator;

public interface ItemVisitor<S> {
    S visit(Book book);
    S visit(Food food);
}
