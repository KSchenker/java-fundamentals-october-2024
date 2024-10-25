package ObserverPatternDemo;


public class MessageListener implements Listener{
    private String name;

    public MessageListener(String name){
        this.name = name;
    }


    @Override
    public void onUpdate(String message) {
        System.out.println(name + " recieved: " + message);
    }
}
