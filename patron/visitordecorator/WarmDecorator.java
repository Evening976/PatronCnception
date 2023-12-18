package patron.visitordecorator;

public class WarmDecorator extends PrintItemDecorator{

    @Override
    public String description() {
        return "Nous pensons à vous chaleureusement\n";
    }
}
