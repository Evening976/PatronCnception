package patron.state;

public class Daemon implements Process{
    private int lastExecDate;
    private String name;
    private ProcessState state = new ProcessStateReady();

    public Daemon(String name){
        this.name = name;
    }

    @Override
    public void execQuantum(int date) {
        System.out.println(date + ": " + this.name);
        this.lastExecDate = date;
    }

    @Override
    public void handleSignal(String signal) {
        this.state.handleSignal(this, signal);
    }

    @Override
    public boolean isReady() {
        return state instanceof ProcessStateReady;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ProcessState getState() {
        return state;
    }

    @Override
    public void setState(ProcessState state) {
        this.state = state;
    }


    @Override
    public int getLastExecDate() {
        return lastExecDate;
    }

    @Override
    public boolean isOver() {
        return false;
    }
}
