import java.util.*;

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

        // Da Listen die Schnittstelle Iterable implementieren, können wir sie mit der for-each Schleife
        // durchlaufen.
        for (String aName : names) {
            System.out.println(aName);
        }

        // Jede Implementierung (konkrete Klasse) von Set und List hat einen Konstruktor, dessen Parameter
        // vom Typ Collection ist. Das bedeutet, dass wir jede Collection mit einer beliebigen anderen Collection
        // initialisieren können. Bsp. eine Liste mit den Elementen einer Set erstellen oder umgekehrt.
        List<String> enemies = new LinkedList<>(Set.of("xaver", "yve", "zach"));
        System.out.println(enemies);
        System.out.println(enemies.size()); // LinkedList.size(), ArrayList.size()
        // Polymorphie bedeutet, dass ein Programmsymbol (z.B. ein Bezeichner) mehrere Bedeutungen haben kann.
        // In der Regel entscheidet der Ausführungskontext, welche genaue Bedeutung der Bezeichner hat.
        // Die bekannteste Form von Polymorphie ist das sogenannte Sub-Typing. Das bedeutet, dass man einer Variablen
        // einer Klasse C ein Objekt einer Unterklasse von C zuweisen kann.
        // Beispiel: List<String> l = new ArrayList<String>(); Hier ist die Variable l polymorph, da sie den Super-Type
        // List hat, aber auf der rechten Seite ein Objekt des Sub-Types ArrayList zugewiesen wird. (in Java: Upcasting)
        // Eine weitere Form von Polymorphie ist das Überladen von Methoden. Zum Beispiel remove(Object o) und remove(int index).
        // Hier sagt man: remove ist polymorph, da es für zwei verschiedene Methodenvarianten stehen kann. Der Aufruf
        // entscheidet über die konkrete Bedeutung bzw. Auswahl der Variante.
        // Eine weitere Form von Polymorphie sind generische Datentypen wie List<E> oder Set<E>. Sie benötigen ein
        // Typargument wie z.B. String oder Integer um eine konkrete Form / Datentyp anzunehmen, also z.B.
        // List<String> oder List<Integer>.
        // Auch Typkonvertierungen zählen zur Polymorphie etwa (int)x. Hier wird der Wert von x in ein int konvertiert.
        // Dadurch nimmt die polymorphe Variable x eine andere "Form" an.
        // Polymorphie = viele (poly) Formen (morph) haben

        // Weiteres Beispiel für Polymorphie. Der Variablen someStrings vom Typ Iterable<String> wird ein
        // Nachfahre vom Typ List<String> zugewiesen.
        // Der Compiler führt diesen sogenannten Upcast automatisch durch, da er weiß, dass ein List Objekt alle
        // Merkmale besitzt, die auch ein Iterable-Objekt hat.
        // Hinweis: Ein List-Objekt hat wesentlich mehr Merkmale als ein Iterable-Objekt. Trotzdem lässt uns der
        // Compiler nur auf die Merkmale von Typ Iterable zugreifen.
        Iterable<String> someStrings = enemies;
        someStrings.iterator(); // OK: Methode iterator ist in Iterable spezifiziert.
        // someStrings.add("alice"); // Fehler: Methode add ist nicht in Iterable spezifiziert, sondern in Collection

        // Beispiel für einen sogenannten Downcast. Hier wird ein Super-Type Objekt in ein Sub-Type Objekt konvertiert.
        // Der Compiler macht das nicht automatisch, da nicht sichergestellt werden kann, dass diese Konvertierung
        // immer erfolgreich ist. Wenn der Downcast durchgeführt werden konnte, können wir die spezifischen Merkmale
        // des Datentyps List<String> über die Referenzvariable aList nutzen.
        if (someStrings instanceof List<String> aList) {
            aList.add("alice"); // OK: aList hat Datentyp List<String> und add wird von List<String> unterstützt.
        }

        printCollectionInfo(Set.of(1, 2, 3));
        printCollectionInfo(List.of("alice", "bob", "charlie"));
        int[] primes = {2, 3, 5, 7, 11};
        List<Integer> primeList = new LinkedList<>();
        for (int p : primes) primeList.add(p);
        printCollectionInfo(primeList);

        List<Name> attendants = new LinkedList<>();
        attendants.add(new Name("John", "Doe"));
        attendants.add(new Name("Max", "Mustermann"));
        attendants.add(new Name("Alice", "Wonderland"));
        attendants.add(new Name("Bob", "Ross"));
        printCollectionInfo(attendants);
    }

    // Eine generische Methode, die die Elemente einer Collection und zusätzliche Infos ausgibt.
    // Das <?> bedeutet, dass der Elementdatentyp der Collection keine Rolle spielt. Die Methode kann
    // also mit Collection<String> genauso arbeiten wie z.B. mit Collection<Double>.
    public static void printCollectionInfo(Collection<?> collection) {
        System.out.printf("Anzahl Elemente in Collection: %d\n", collection.size());
        System.out.println("Das sind die einzelnen Elemente:");
        for (var element : collection) {
            System.out.println(" " + element);
        }
    }

}
