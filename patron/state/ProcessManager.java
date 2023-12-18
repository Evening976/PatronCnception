package patron.state;

import java.util.ArrayList;

public class ProcessManager {
    ArrayList<Process> processes = new ArrayList<>();
    private int date = 0;
    Process running = null;

    public void add(Process process) {
        processes.add(process);
        System.out.println(process.getName() + " new ");
    }

    public Process selectNext() { // Selection par round robin ( tourniquet )
        Process candidate = null;
        int lastDate = Integer.MAX_VALUE;
        for (Process process : processes)
            if (process.isReady() && process.getLastExecDate() < lastDate) {
                candidate = process;
                lastDate = process.getLastExecDate();
            }
        return candidate;
    }

    public void execQuantum(int nbQuantum) {
        for (int i = 0; i < nbQuantum; i++) {
            Process candidate = selectNext();
            if (candidate != null) {
                if (running != null)
                    running.handleSignal(" sleep ");
                candidate.handleSignal(" awake ");
                running = candidate;
                running.execQuantum(date);
                if (running.isOver())
                    processes.remove(running);
            }
            date = date + 1;
        }
    }
}
