package ObserverPatternDemo;

interface Publisher {
    void subscribe (Listener listener);
    void unsubscribe(Listener listener);
    void notifyListeners(String message);
    }
