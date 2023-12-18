package patron.visitordecorator;

public class TestShoppinCart {
    public static void main(String[] args) {
        Book book = new Book();
        book.name = "La vie devant soi";
        book.price = 8.0;
        book.numberOfpages = 240.0;
        Food pizza = new Food();
        pizza.name = "frozen pizza";
        pizza.price = 6;
        ShoppingCart cart = new ShoppingCart();
        PrintItemVisitor visitor = new PrintItemVisitor();
        cart.addItem(book);
        cart.addItem(pizza);
        String string = visitor.print(cart);
        System.out.println(string);
        WarmDecorator a = new WarmDecorator();
        CompositeDecorator d = new CompositeDecorator(new WarmDecorator(), new TotalDecorator(cart));
        String string1 = a.print(cart);
        System.out.println(string1);
        System.out.println(d.print(cart));
    }
}
