package patron.state;

public class FiniteProcess implements Process{

    private final String name;
    private int timeLeft;

    private int lastExecDate = 0;

    private State state = State.READY;

    public FiniteProcess(String name, int duration){
        this.name = name;
        this.timeLeft = duration;
    }

    @Override
    public void execQuantum(int date) {
        System.out.println(date + ": " + this.name);
        this.timeLeft--;
        this.lastExecDate = date;
    }

    @Override
    public void handleSignal(String signal) {
        switch(signal){
            case "block":
                if(this.state == State.RUNNING){
                    System.out.println(name + "blocked");
                    this.state = State.BLOCKED;
                }
                break;
            case "unblock":
                if(this.state == State.BLOCKED){
                    System.out.println(name + "unblocked");
                    this.state = State.READY;
                }
                break;
            case "sleep":
                if(this.state == State.RUNNING){
                    this.state = State.READY;
                }
                break;
            case "awake":
                if(this.state == State.READY){
                    this.state = State.RUNNING;
                }
                break;
            default:
                System.out.println("Signal not recognized");
        }
    }
    public boolean isReady(){
        return this.state == State.READY;
    }

    public String getName(){
        return this.name;
    }

    public State getState(){
        return this.state;
    }

    public boolean isOver(){
        return this.timeLeft <= 0;
    }

    public int getLastExecDate(){
        return this.lastExecDate;
    }
}
