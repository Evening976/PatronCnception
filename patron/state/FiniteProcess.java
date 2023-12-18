package patron.state;

public class FiniteProcess implements Process {

    private final String name;
    private int timeLeft;

    private int lastExecDate = 0;

    protected ProcessState state = new ProcessStateReady();

    public FiniteProcess(String name, int duration) {
        this.name = name;
        this.timeLeft = duration;
    }

    @Override
    public void execQuantum(int date) {
        System.out.println(date + ":" + this.name);
        this.timeLeft--;
        this.lastExecDate = date;
    }

    @Override
    public void handleSignal(String signal) {
        this.state.handleSignal(this, signal);
    }

    public boolean isReady() {
        return this.state instanceof ProcessStateReady;
    }

    public String getName() {
        return this.name;
    }

    public ProcessState getState() {
        return this.state;
    }

    @Override
    public void setState(ProcessState state) {
        this.state = state;
    }

    public boolean isOver() {
        return this.timeLeft <= 0;
    }

    public int getLastExecDate() {
        return this.lastExecDate;
    }
}
