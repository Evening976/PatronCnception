package patron.state;

import java.util.ArrayList;

public interface ProcessSelection {
    Process selectNext(ArrayList<Process> processes);
}
