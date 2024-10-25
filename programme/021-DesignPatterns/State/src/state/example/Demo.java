
package state.example;
import state.example.ui.Player;
import state.example.ui.UI;


public class Demo {

    /**
     * Demo class. All the classes, functions and methods come together here.
     * This class creates an object of Player from player Class that is using the class ui to display the player
     */

        public static void main(String[] args) {
            Player player = new Player();
            UI ui = new UI(player);
            ui.init();
        }
    }


