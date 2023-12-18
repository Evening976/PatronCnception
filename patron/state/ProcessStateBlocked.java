package patron.state;

public class ProcessStateBlocked implements ProcessState {

    @Override
    public void handleSignal(Process process, String signal) {
        if (signal.equals("unblock")) {
            System.out.println(process.getName() + "unblocked");
            process.setState(new ProcessStateReady());
        }
    }
}
