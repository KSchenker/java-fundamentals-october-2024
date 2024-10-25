package state.example;

import state.ReadyState;
import state.State;
import state.example.ui.Player;

public class ClosedState extends State {

    ClosedState(Player player){
        super(player);

    }

    @Override
    public String onLock() {
        return "Das Programm schliesst gerade";
    }

    @Override
    public String onPlay() {
        return "Ne geht nicht das Programm schlisst";
    }

    @Override
    public String onNext() {
        return "Warte bis es beendet wird";
    }

    @Override
    public String onPrevious() {
        player.changeState(new ReadyState(player));
        return "Wieder zurück zum Player";
    }
}
