package ObserverPatternDemo;

import java.util.ArrayList;
import java.util.List;

class MessagePublisher implements Publisher {

    private List<Listener> listeners = new ArrayList<>();


    @Override
    public void subscribe(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyListeners(String message) {
        for (Listener listener : listeners){
            listener.onUpdate(message);
        }
    }


    public void publish(String message){
    System.out.println("Published broadcast: " + message);
    notifyListeners(message);
}

}






