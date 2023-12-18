package patron.state;

import java.util.ArrayList;

public class RoundRobin implements ProcessSelection{
    @Override
    public Process selectNext(ArrayList<Process> processes){
        Process candidate = null;
        int lastDate = Integer.MAX_VALUE;
        for (Process process : processes)
            if (process.isReady() && process.getLastExecDate() < lastDate) {
                candidate = process;
                lastDate = process.getLastExecDate();
            }
        return candidate;
    }
}
