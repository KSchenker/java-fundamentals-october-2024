import java.util.*;

public class MapDemo {

    public static void main(String[] args) {
        // Eine Map ist eine mathematische Funktion, die Schlüsselwerte auf Werte abbildet.
        // Man kann sich eine Map wie eine zweispaltige Tabelle vorstellen. In der ersten Spalte stehen die Keys
        // und in der zweiten Spalte stehen die Werte.
        // Maps sind daraufhin optimiert anhand eines Schlüssels den dazugehörigen Wert performant zu ermitteln.
        // Umgekehrt kann anhand eines Wertes der bzw. die dazugehörigen Schlüssel nicht performant gefunden werden.
        // Maps erlauben standardmäßig keine null-Werte. Die Keys müssen außerdem eindeutig sein.
        // Es gibt erweiterte Formen von Maps, z.B. BiMaps. Diese erlauben auch die effiziente Suche nach Schlüsseln
        // anhand eines Wertes. Dafür gilt aber zusätzlich die Restriktion, dass die Werte (Values) eindeutig sein
        // müssen.
        // Im Gegensatz zu Set und List sind Maps keine klassischen Collections, d.h. sie implementieren auch nicht
        // die Schnittstelle Collection, gehören aber trotzdem zu dem Java Collection Framework.

        var alice = new Employee("Alice Wonderland", "123", "Development");
        var bob = new Employee("Bob Ross", "456", "Development");
        var charlie = new Employee("Charlie Brown", "789", "Sales");
        var damian = new Employee("Damian Rice", "654", "Management");

        Map<String, Employee> employeeById = new HashMap<>();
        // Hinweis: put wird den Wert eines bereits existierenden Schlüssels überschreiben.
        employeeById.put(alice.id(), alice);
        employeeById.put(bob.id(), bob);
        employeeById.put(charlie.id(), charlie);
        employeeById.put(damian.id(), damian);
        // Hinweis: putIfAbsent fügt das Key,Value Paar nur dann hinzu, wenn der Schlüssel noch nicht in der Map
        // existiert.
        employeeById.putIfAbsent(damian.id(), damian);
        System.out.println(employeeById);

        // Prüfen, ob Schlüssel und Werte vorhanden sind.
        System.out.println(employeeById.containsKey("777")); // false
        System.out.println(employeeById.containsKey("123")); // true (Alice)
        System.out.println(employeeById.containsValue(damian)); // true

        // Mehrere Einträge zur Map hinzufügen mit putAll
        var elon = new Employee("Elon Musk", "007", "Executive");
        var fred = new Employee("Fred Durst", "107", "Entertainment");
        // Analog zu Set.of und List.of erstellt Map.of eine unbenannte und unveränderliche Map von Schlüssel-Wert-Paaren.
        // Map.of erwartet zuerst einen Schlüssel, dann den dazugehörigen Wert, dann den zweiten Schlüssel mit dem dazugehörigen Wert usw.
        employeeById.putAll(Map.of(elon.id(), elon, fred.id(), fred));

        // Eine Map lässt sich auch sehr gut als Cache verwenden. Das ist besonders dann sinnvoll, wenn die Werte
        // sehr aufwändig berechnet werden müssen. Statt das Ergebnis immer wieder neu zu berechnen, könnte man
        // bereits berechnete Ergebnisse in der Map ablegen und als Schlüssel den Input wählen.

        // Mit Methode keySet erhalten wir alle Schlüssel der Map.
        for (String key : employeeById.keySet()) {
            System.out.println(key);
        }

        // Mit Methode values erhalten wir alle Values der Map.
        for (Employee value : employeeById.values()) {
            System.out.println(value);
        }

        // Mit Methode entrySet können wir alle Einträge (Schlüssel-Wert-Paare) der Map auslesen.
        for (var entry : employeeById.entrySet()) {
            System.out.printf("Key: %s Value: %s\n", entry.getKey(), entry.getValue());
        }

        // Aufgabe: Eine Liste von Wörtern soll nach Wortlänge gruppiert werden. Verwende dafür eine
        // Map<Integer, List<String>>. Der Key repräsentiert die Wortlänge. Das Value ist eine Liste der Wörter
        // mit der entsprechenden Länge.
        List<String> words = List.of("alice", "bob", "charlie", "damian", "fred", "gerald", "hans", "ian", "james");
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        for (String aWord : words) {
            // Der Schlüssel ist die Wortlänge.
            int length = aWord.length();
            // Wir fragen die Map nach dem Schlüssel. Sofern der Schlüssel nicht eingetragen ist, also auch kein Value
            // hat, soll eine neue leere Liste erstellt werden.
            List<String> group = wordsByLength.getOrDefault(length, new ArrayList<String>());
            // Wir fügen das Wort zur Liste (dem Value des Keys) hinzu.
            group.add(aWord);
            // Da die Liste eventuell neu erstellt wurde, müssen wir sie noch unter dem Key abspeichern.
            wordsByLength.put(length, group);
        }
        System.out.println(wordsByLength);

        // Wir wollen nun die Einträge der Map absteigend nach Key (also Wortlänge) ausgeben.
        // 1) Wir erstellen aus der EntrySet der Map eine herkömmliche Liste von Entry Objekten.
        // 2) Wir sortieren die Liste absteigend nach den Entry Keys.
        // 3) Wir geben die sortierte Liste von Entry-Objekten aus.
        List<Map.Entry<Integer, List<String>>> mapEntries = new ArrayList<>(wordsByLength.entrySet());
        Collections.sort(mapEntries, (firstEntry, secondEntry) -> secondEntry.getKey().compareTo(firstEntry.getKey()));
        for (var entry : mapEntries) {
            System.out.printf("Wortlänge: %d Wörter: %s\n", entry.getKey(), entry.getValue());
        }

        // Dieser Code gibt ebenfalls die Paare der Map absteigend nach Key aus. Hier sortieren wir nur die Keys
        // und ermitteln dann für jeden Key das Value bei der Ausgabe.
        List<Integer> lengths = new ArrayList<>(wordsByLength.keySet());
        Collections.sort(lengths, (a, b) -> b - a);
        for (var key : lengths) {
            System.out.printf("Key: %d Wörter: %s\n", key, wordsByLength.get(key));
        }

        wordsByLength.remove(6); // Entferne das Key-Value-Pair mir Key = 6.
        System.out.println(wordsByLength); // {3=[bob, ian], 4=[fred, hans], 5=[alice, james], 7=[charlie]}

        // Die KeySet ist eine View über die Schlüssel der Map. Wenn wir diese View modifizieren, verändern wir damit
        // auch die Map.
        wordsByLength.keySet().remove(4);
        System.out.println(wordsByLength); // {3=[bob, ian], 5=[alice, james], 7=[charlie]}

        // Analog zu keySet ist auch das Ergebnis von values() eine View über die Map. Wenn wir die View verändern
        // dann modifizieren wir damit auch die Map.
        // Hinweis: Methode removeIf entfernt Elemente aus einer Collection, für die eine angegebene Bedingung erfüllt ist.
        // Hier wollen wir aus der Collection der Values alle Values entfernen, deren Länge exakt 2 ist. Values sind in
        // unserem Fall die Wortlisten.
        wordsByLength.values().removeIf(list -> list.size() == 2);
        System.out.println(wordsByLength); // {7=[charlie]}
    }
}
