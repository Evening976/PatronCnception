package patron.state;

public class ProcessStateRunning implements ProcessState{
    @Override
    public void handleSignal(Process process, String signal) {
        if (signal.equals("block")) {
            System.out.println(process.getName() + " blocked");
            process.setState(new ProcessStateBlocked());
        } else if (signal.equals("sleep")) {
            System.out.println(process.getName() + " sleeping");
            process.setState(new ProcessStateReady());
        }
    }
}
