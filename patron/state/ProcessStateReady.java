package patron.state;

public class ProcessStateReady implements ProcessState {
    @Override
    public void handleSignal(Process process, String signal) {
        if(signal.equals("awake")){
            System.out.println(process.getName() + " awake");
            process.setState(new ProcessStateRunning());
        }
    }
}
