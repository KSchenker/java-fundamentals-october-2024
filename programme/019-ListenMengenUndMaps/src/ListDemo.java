import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        // List ist wie Set eine Collection. Listen unterstützen jedoch noch ein paar weitere Methoden,
        // die die Tatsache ausnutzen, dass die Elemente in einer Liste eine Position haben.
        // Im Gegensatz zu Sets unterstützen Listen Duplikate.
        List<String> names = new ArrayList<>();
        names.add("alice");
        names.add("bob");
        names.remove("alice");
        System.out.println(names.contains("bob")); // true
        System.out.println(names.size()); // 1
        System.out.println(names.isEmpty()); // false
        names.clear();
        System.out.println(names.isEmpty()); // true
        names.addAll(List.of("damian", "elon", "fred", "damian", "gerald"));
        System.out.println(names); // [damian, elon, fred, damian, gerald]
        names.remove("damian");
        System.out.println(names); // [elon, fred, damian, gerald]
        names.addAll(List.of("damian", "hans", "damian"));
        System.out.println(names); // [elon, fred, damian, gerald, damian, hans, damian]
        // Trick: Um alle Vorkommen eines Elements aus der Liste zu entfernen, verwendet man
        // die Methode removeAll und eine einelementige Collection als Argument.
        names.removeAll(List.of("damian"));
        System.out.println(names); // [elon, fred, gerald, hans]

        List<String> friends = new ArrayList<>(List.of("Alma", "Selma", "Marge", "Lisa", "fred"));
        List<String> commonFriends = new ArrayList<>(friends);
        commonFriends.retainAll(names); // Schnittmenge aus friends und names in commonFriends speichern.
        System.out.println(commonFriends);

        System.out.println(names); // [elon, fred, gerald, hans]
        System.out.println(names.get(0)); // "elon"
        System.out.println(names.get(1)); // "fred"
        names.set(0, "elsa"); // "elon" -> "elsa"
        System.out.println(names); // [elsa, fred, gerald, hans]
        names.add(0, "adam"); // "adam" vor "elsa" einfügen
        System.out.println(names); // [adam, elsa, fred, gerald, hans]
        names.addAll(1, List.of("bart", "charles", "dustin", "erik")); // insert
        System.out.println(names); // [adam, bart, charles, dustin, erik, elsa, fred, gerald, hans]
        names.remove(1); // entferne "bart"
        System.out.println(names); // [adam, charles, dustin, erik, elsa, fred, gerald, hans]
        Collections.sort(names); // aufsteigend sortieren (verwendet natürliche Ordnung der Elemente)
        System.out.println(names); // [adam, charles, dustin, elsa, erik, fred, gerald, hans]
        Collections.reverse(names);
        System.out.println(names); // [hans, gerald, fred, erik, elsa, dustin, charles, adam]
    }

}
