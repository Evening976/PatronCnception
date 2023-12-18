package patron.visitordecorator;

public class TotalDecorator extends PrintItemDecorator{

    ShoppingCart cart;
    public TotalDecorator(ShoppingCart cart){
        this.cart = cart;
    }
    @Override
    public String description() {
        return "Total : " + printItemVisitor.total(cart) + "\n";
    }
}
