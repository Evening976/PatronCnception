package patron.visitordecorator;

import java.util.Arrays;

public class CompositeDecorator extends PrintItemDecorator{
    PrintItemDecorator[] decorators;
    public CompositeDecorator(PrintItemDecorator... decorators){
        this.decorators = Arrays.copyOf(decorators, decorators.length);
    }
    @Override
    public String description() {
        String s = "";
        for(PrintItemDecorator d : decorators){
            s += d.description();
        }
        return s;
    }
}
