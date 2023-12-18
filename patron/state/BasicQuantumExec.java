package patron.state;

public class BasicQuantumExec implements QuantumExec {

    Process running = null;
    private int date = 0;

    @Override
    public void execQuantum(ProcessManager p) {
        Process candidate = p.selectNext();
        if (candidate != null) {
            if (running != null)
                running.handleSignal("sleep");
            candidate.handleSignal("awake");
            running = candidate;
            running.execQuantum(date);
            if (running.isOver())
                p.processes.remove(running);
        }
        date = date + 1;

    }
}
