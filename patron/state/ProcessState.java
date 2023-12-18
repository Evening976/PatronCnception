package patron.state;

public interface ProcessState {
    void handleSignal(Process process, String signal);
}
