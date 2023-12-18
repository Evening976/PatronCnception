package patron.visitordecorator;

public class XmasDecorator extends PrintItemDecorator {

    @Override
    public String description() {
        return "Merry Xmas\n";
    }
}
