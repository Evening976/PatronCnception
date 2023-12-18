package patron.visitordecorator;

public class CartItemsVisitor implements ItemVisitor<String> {
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

    public double total(ShoppingCart cart){
        double total = 0;
        for(Item item: cart.items()){
            total += item.price();
        }
        return total;
    }
}
