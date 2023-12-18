package patron.state;

public interface Process {
    void execQuantum(int date);
    void handleSignal(String signal);
    boolean isReady();
    String getName();
    ProcessState getState();
    void setState(ProcessState state);
    int getLastExecDate();
    boolean isOver();
}
