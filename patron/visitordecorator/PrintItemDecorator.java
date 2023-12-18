package patron.visitordecorator;

public abstract class PrintItemDecorator {
    protected CartItemsVisitor visitor = new CartItemsVisitor();
    public String print(ShoppingCart cart) {
        String s = "";
        s += visitor.print(cart);
        return s + description();
    }

    public abstract String description();
}
