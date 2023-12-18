package patron.state;

public interface Process {
    void execQuantum(int date);
    void handleSignal(String signal);
    boolean isReady();
    String getName();
    State getState();
    int getLastExecDate();
    boolean isOver();
}
