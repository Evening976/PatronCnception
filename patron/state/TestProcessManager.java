package patron.state;

    public class TestProcessManager {
        public static void main(String[] args) {
            Process p1 = new FiniteProcess(" p1 ", 5);
            Process p2 = new FiniteProcess(" p2 ", 7);
            Process p3 = new FiniteProcess(" p3 ", 4);
            ProcessManager processManager = new ProcessManager();
            processManager.add(p1); // affiche " p1 new "
            processManager.execQuantum(1); // affiche "0: p1 "
            processManager.add(p2); // affiche " p2 new "
            processManager.execQuantum(2); // affiche "1: p2 " puis "2: p1 "
            processManager.add(p3); // affiche " p3 new "
            p1.handleSignal("block"); // affiche " p1 blocked "
            processManager.execQuantum(3); // affiche "3: p3 " , "4: p2 " , "5: p3 "
            p1.handleSignal("unblock"); // affiche " p1 unblocked "
            processManager.execQuantum(10); // affiche "6: p1 " , "7: p2 " , "8: p3 " , "9: p1 " , etc
        }
    }
