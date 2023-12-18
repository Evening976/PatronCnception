package patron.visitordecorator;

public abstract class PrintItemDecorator {
    protected PrintItemVisitor printItemVisitor = new PrintItemVisitor();
    public String print(ShoppingCart cart) {
        String s = "";
        s += printItemVisitor.print(cart);
        return s + description();
    }

    public abstract String description();
}
