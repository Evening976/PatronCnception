package patron.state;

import java.util.ArrayList;

public class ProcessManager {
    ArrayList<Process> processes = new ArrayList<>();
    private int date = 0;

    ProcessSelection selection = new RoundRobin();
    QuantumExec quantumExec = new BasicQuantumExec();

    public void add(Process process) {
        processes.add(process);
        System.out.println(process.getName() + " new ");
    }

    public Process selectNext() { // Selection par round robin ( tourniquet )
        return selection.selectNext(processes);
    }

    public void execQuantum(int nbQuantum) {
        for (int i = 0; i < nbQuantum; i++) {
            quantumExec.execQuantum(this);
            date = date + 1;
        }
    }
}
