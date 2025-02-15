import java.time.LocalDateTime;
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

        // Die Elemente der Liste mit einem Iterator durchlaufen.
        for (Iterator<Name> it = attendants.iterator(); it.hasNext(); ) {
            Name nextElement = it.next();
            System.out.println(nextElement);
            if (nextElement.lastName().length() > 4) {
                it.remove(); // Lösche zuletzt gelesenes Element aus der Liste.
            }
        }
        System.out.println(attendants); // ["Doe, John", "Ross, Bob"]

        // Elemente während des Iterierens zu löschen, geht meist schief. Verwende stattdessen einen Iterator.
        attendants = new LinkedList<>();
        attendants.addAll(List.of(
                new Name("John", "Doe"),
                new Name("Max", "Mustermann"),
                new Name("Alice", "Wonderland"),
                new Name("Bob", "Ross")
        ));
        for (int i = 0; i < attendants.size(); ++i) {
            Name nextElement = attendants.get(i);
            System.out.println(nextElement);
            if (nextElement.lastName().length() > 4) {
                attendants.remove(i);
                i--; // Wir müssen den Index händisch zurücksetzen, da ansonsten das erste "nachgerutschte" Element
                     // nicht geprüft würde.
            }
        }
        System.out.println(attendants);

        // Listen haben einen erweiterten Iterator, den sogenannten ListIterator. Dieser kann positioniert werden
        // und in beide Richtungen (vorwärts, rückwärts) die Liste durchlaufen.
        List<Integer> numbers = new LinkedList<>();
        numbers.addAll(List.of(10, 20, 30, 40, 50, 60, 70));
        // Beginne die Iteration an Stelle 3, also zwischen Element 30 und 40.
        // Bewege dich anschließend in Rückwärtsrichtung mit den Methoden previous und hasPrevious.
        // ListIteratoren können Elemente entfernen und auch einfügen.
        for (ListIterator<Integer> it = numbers.listIterator(3); it.hasPrevious(); ) {
            it.add(99); // Füge vor dem Iterator das Element 99 ein. Dadurch wandert der Iterator um eine Stelle nach rechts.
            it.previous(); // Lasse den Iterator eine Stelle nach links wandern und "verschlucke" die 99.
            System.out.print(it.previous() + "  ");
        }
        System.out.println(numbers);

        // Aufgabe: Durchlaufe die Elemente einer String-Liste in Rückwärtsrichtung. Nutze dafür einen
        // ListIterator<String>.
        List<String> words = new ArrayList<>(List.of("java", "ist", "mega", "toll"));
        for (ListIterator<String> it = words.listIterator(words.size()); it.hasPrevious(); ) {
            System.out.printf("%s ", it.previous());
        }

        // Die Methode subList erstellt eine sogenannte View (Sicht) auf die darunterliegende Liste.
        // Mit subList sehen wir also nur einen Ausschnitt der Originalliste.
        // Wichtig: Alle Modifikationen an der View wirken sich auch auf das Original aus.
        // WIr können damit Teilbereiche der Liste entfernen, einfügen, verändern etc.
        System.out.println(words.subList(1, words.size())); // ["ist", "mega", "toll"]
        System.out.println(words.subList(1, 3)); // ["ist", "mega"]
        words.subList(1, 3).clear(); // Entfernt die Worte "ist" und "mega" aus der Originalliste!!!
        System.out.println(words); // ["java", "toll"]
        words.subList(1, 1).addAll(List.of("ist", "C#"));
        System.out.println(words); // ["java", "ist", "C#", "toll"]
        Collections.sort(words.subList(1, words.size())); // Sortiere die letzten 3 Elemente aus vorheriger Liste
        System.out.println(words); // ["java", "C#", "ist", "toll"]

        // Die Collections.sort Methode kann Listen aufsteigend sortieren. Sie verwendet standardmäßig die
        // natürliche Ordnung des Elementdatentyps. Wenn wir einen benutzerdefinierten Datentyp für die Elemente der
        // Liste verwenden, haben für die Sortierung folgende Möglichkeiten:
        // 1) Wir implementieren die Schnittstelle Comparable im benutzerdefinierten Datentyp
        // 2) Wir erstellen ein Comparator-Objekt und geben es der sort-Methode mit. Ein Comparator ist ein Objekt
        //    dass die Aufgabe hat, andere Objekte zu vergleichen (<, >, ==)
        Name max = new Name("Max", "Mustermann");
        Name charlie = new Name("Charlie", "Brown");
        Name adam = new Name("Adam", "Brown");

        System.out.println(max.compareTo(charlie)); // max > charlie, da Mustermann > Brown, also return > 0
        System.out.println(charlie.compareTo(max)); // charlie < max, da Brown < Mustermann, also return < 0
        System.out.println(charlie.compareTo(charlie)); // charlie == charlie, da Brown == Brown, also return == 0
        System.out.println(charlie.compareTo(adam)); // charlie > adam, da Charlie > Adam, also return > 0
        System.out.println(adam.compareTo(charlie)); // adam < charlie, da Adam < Charlie, also return < 0

        List<Name> employees = new ArrayList<>();
        employees.add(max);
        employees.add(new Name("Charlie", "Brown"));
        employees.add(new Name("Damian", "Duff"));
        employees.add(new Name("Elon", "Austin"));
        Collections.sort(employees);
        System.out.println(employees); // ["Austin, Elon", "Brown, Charlie", "Duff, Damian", "Mustermann, Max"]

        // Wir verwenden einen anderen Comparator um die Sortierreihenfolge zu ändern.
//        Comparator<Name> comparator = new Name.FirstNameOrder();
        Collections.sort(employees, Name.FIRST_NAME_ORDER);
        System.out.println(employees); // ["Brown, Charlie", "Duff, Damian", "Austin, Elon", "Mustermann, Max"]

        List<String> months = new ArrayList<>(List.of("Januar", "März", "februar"));
        // Die Klasse String hat ein öffentliches statisches Feld namens CASE_INSENSITIVE_ORDER. Dieses Feld
        // referenziert ein Comparator-Objekt welches Zeichenketten ohne Berücksichtigung der Groß- und Kleinschreibung
        // vergleicht.
        Collections.sort(months, String.CASE_INSENSITIVE_ORDER);
        System.out.println(months); // ["februar", "Januar", "März"]
        Collections.sort(months);
        System.out.println(months); // ["Januar", "März", "februar"]

        // Aufgabe: Der Record LogEntry (siehe im voherigen Projekt) soll die Schnittstelle Comparable<LogEntry>
        // implementieren. Die Reihenfolge soll anhand des Zeitstempels (timestamp) bestimmt werden.
        // Erstelle anschließend eine Liste von LogEntry Objekten und sortiere sie aufsteigend.
        // Im Anschluss sollst du eine Comparator Klasse schreiben, die LogEntry Objekte vergleicht.
        // Hier soll anhand des Origin (Herkunft) sortiert werden. Teste deinen Comparator mit der Collections.sort
        // Methode.
        LocalDateTime now = LocalDateTime.now();
        List<LogEntry> entries = new ArrayList<>(List.of(
                new LogEntry(now.minusDays(2), "Festplatte voll", "Dateisystem"),
                new LogEntry(now.minusDays(1), "Virus erkannt", "Virenscanner"),
                new LogEntry(now.minusDays(5), "Internetverbindung unterbrochen", "Netzwerk")
        ));
        Collections.sort(entries);
        System.out.println(entries);
        Collections.sort(entries, LogEntry.ORIGIN_ORDER); // Sortiere aufsteigend nach Origin
        System.out.println(entries);

        // Statt einer geschachtelten Comparator-Klasse könnte man auch eine anonyme Klasse in Java verwenden.
        // Da eine anonyme Klasse keinen Namen besitzt, kann sie nicht mehrfach verwendet werden.
        Comparator<LogEntry> messageOrder = new Comparator<LogEntry>() {
            @Override
            public int compare(LogEntry first, LogEntry second) {
                return first.message().compareToIgnoreCase(second.message());
            }
        };
        Collections.sort(entries, messageOrder); // sortiere aufsteigend nach der Message
        System.out.println(entries);

        // Statt eines anonymen Datentyps wie oben, können wir auch eine sogenannte Lambda-Funktion verwenden.
        // Die Lambda-Funktion muss dieselbe Signatur haben wie die compare Methode aus der Schnittstelle Comparable.
        // Wir sortieren die Einträge nach Message, aber diesmal absteigend. Wir erreichen das, indem wir
        // beim Vergleich von first und second die Operanden umdrehen, also in Wahrheit second mit first vergleichen.
        Comparator<LogEntry> comparator = (first, second) -> second.message().compareToIgnoreCase(first.message());
        Collections.sort(entries, comparator);
        System.out.println(entries);
        Collections.sort(entries, comparator.reversed()); // sortiere aufsteigend nach Message (umgekehrte Variante des Comparators)
        System.out.println(entries);

        // Was ist eine Lambda-Funktion? Darunter versteht man eine anonyme Methode, die syntaktisch sehr kompakt
        // im Code formuliert werden kann. Da sie keinen Namen besitzt, kann man sie nicht direkt wiederverwenden.
        // Eine Lambda-Funktion kann überall dort verwenden werden, wo ein Objekt eines Interface-Typs erwartet wird.
        // Voraussetzung ist, dass das Interface genau eine abstrakte Methode besitzt (default Methoden werden hier
        // nicht mit betrachtet).

        System.out.println(employees); // ["Brown, Charlie", "Duff, Damian", "Austin, Elon", "Mustermann, Max"]
        employees.add(new Name("Zach", "Brown"));
        employees.add(new Name("Claire", "Redfield"));
        employees.add(new Name("Chris", "Redfield"));
        Comparator<Name> orderByLast = (first, second) -> first.lastName().compareToIgnoreCase(second.lastName());
        Comparator<Name> orderByFirst = (first, second) -> first.firstName().compareToIgnoreCase(second.firstName());
        // Comparator-Objekte lassen sich auch zu einem Comparator zusammensetzen. Zuerst wird hier nach
        // Nachnamen sortiert. Falls zwei Nachnamen aber gleich sind, wird anschließend nach Vornamen sortiert.
        Collections.sort(employees, orderByLast.thenComparing(orderByFirst));
        System.out.println(employees);

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
