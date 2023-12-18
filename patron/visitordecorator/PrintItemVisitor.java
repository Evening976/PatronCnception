package patron.visitordecorator;

public class PrintItemVisitor implements Visitor<String> {
    @Override
    public String visit(Book book) {
        return book.name() + " " + book.price() + " " + book.numberOfpages() + " pages";
    }

    @Override
    public String visit(Food food) {
        return food.name() + " " + food.price() + " euros";
    }

    public String print(ShoppingCart cart) {
        String string = "";
        for (Item item : cart.items()) {
            string += item.accept(this) + "\n";
        }
        return string;
    }
}
