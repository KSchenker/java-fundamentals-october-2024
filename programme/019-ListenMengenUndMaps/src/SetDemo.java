import java.util.*;

import org.apache.commons.lang3.ArrayUtils;

public class SetDemo {

    public static void main(String[] args) {
        // Sets und Lists sind Collections. Alle vom JDK bereitgestellten
        // Set und List-Implementierungen implementieren das Collection Interface.
        // Maps sind streng genommen keine Collections, deshalb implementieren sie
        // auch nicht das Collection Interface.

        // Das Interface Set wird von allen Set-Implementierungen implementiert.
        // Set definiert die gemeinsame Schnittstelle aller Set-Implementierungen.
        // Hier erstellen wir eine Referenzvariable vom Typ Set<Integer>.
        Set<Integer> lottoNumbers;
        // Die Klasse HashSet ist eine konkrete Implementierung der Schnittstelle Set.
        // Sie verwendet intern eine Hashtabelle um die Elemente zu verwalten.
        lottoNumbers = new HashSet<Integer>();
        lottoNumbers.add(2);
        lottoNumbers.add(7);
        lottoNumbers.add(49);
        lottoNumbers.add(7); // Duplikat wird nicht hinzugefügt.
        System.out.println(lottoNumbers.size()); // 3
        lottoNumbers.remove(49);
        System.out.println(lottoNumbers.size()); // 2
        lottoNumbers.remove(30); // Dieses Element wird nicht entfernt, da nicht vorhanden.
        System.out.println(lottoNumbers.size()); // 2
        System.out.println(lottoNumbers.contains(2)); // true
        System.out.println(lottoNumbers.contains(30)); // false
        System.out.println(lottoNumbers.isEmpty()); // false
        lottoNumbers.clear();
        System.out.println(lottoNumbers.isEmpty()); // true

        Set<String> partyA = new HashSet<>();
        Set<String> partyB = new HashSet<>();
        partyA.add("alice");
        partyA.add("bob");
        partyA.add("charlie");
        partyB.add("charlie");
        partyB.add("damian");
        partyB.add("elon");
        partyB.add("fred");
        System.out.println(partyA); // [bob, alice, charlie]
        System.out.println(partyB); // [damian, elon, fred, charlie]

        Set<String> allMembers = new HashSet<>();
        allMembers.addAll(partyA);
        allMembers.addAll(partyB); // addAll ist mit Union gleichzusetzen bei Sets.
        System.out.println(allMembers); // [bob, damian, alice, elon, fred, charlie]

        Set<String> commonMembers = new HashSet<>();
        commonMembers.addAll(partyA);
        commonMembers.retainAll(partyB); // retainAll bildet Schnittmenge aus A und B
        System.out.println(commonMembers); // [charlie]

        Set<String> uniqueMembersInPartyA = new HashSet<>();
        uniqueMembersInPartyA.addAll(partyA);
        uniqueMembersInPartyA.removeAll(partyB); // removeAll bildet Differenz A-B
        System.out.println(uniqueMembersInPartyA); // [bob, alice]

        // Die Symmetrische Differenz von A und B berechnen wir aus der
        // Vereinigung von A und B abzüglich der Schnittmenge von A und B.
        Set<String> nonCommonMembers = new HashSet<>();
        nonCommonMembers.addAll(partyA);
        nonCommonMembers.addAll(partyB);
        nonCommonMembers.removeAll(commonMembers);
        System.out.println(nonCommonMembers); // [bob, damian, alice, elon, fred]

        // Aufgabe: Konvertiere die Set nonCommonMembers in einen Array von Strings.
        String[] membersAsArray = nonCommonMembers.toArray(new String[]{});
        System.out.println(Arrays.toString(membersAsArray));

        int[] numberArray = {1, 2, 3};
        // Die statische Set.of Methode kann neue Set-Objekte aus vorgegebenen Elementen erstellen.
        // Das Ergebnis von Set.of ist ein Set-Objekt, welches unveränderlich ist. Da wir
        // eine veränderliche Set haben wollen, erstellen wir mittels new eine eigene Set
        // und initialisieren diese mit der unveränderlichen Set.
        Set<Integer> numberSet = new TreeSet<>(Set.of(5,3,2,4));
        numberSet.addAll(Set.of(7, 9, 0));
        System.out.println(numberSet);
        // Set.of(2, 3, 4).add(7); // Fehler: Set.of liefert nur eine unveränderliche Set!

        // Um diese Collection in ein int[] zu konvertieren, können wir nicht direkt
        // toArray nutzen, da wir damit nur Integer[] erhalten würden.
        Integer[] numberSetAsArray = numberSet.toArray(new Integer[]{});
        int[] arrayOfNumbers = new int[numberSet.size()];
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = numberSetAsArray[i].intValue();
        }
        System.out.println(Arrays.toString(arrayOfNumbers));

        // Obige Variante liese sich auch mit Hilfe der Java Stream API umsetzen.
        int[] someNumbers = Arrays.stream(numberSetAsArray).mapToInt(Integer::intValue).toArray();

        // Obige Variante liese sich auch mit Hilfe einer Zusatzbibliothek umsetzen.
        // Wir verwenden hier die Bibliothek org.apache.commons.lang
        int[] myNumbers = ArrayUtils.toPrimitive(numberSetAsArray);

        List<Integer> orderedNumbers = new ArrayList<>();
        orderedNumbers.addAll(List.of(5, 1, 2, 5, 3, 4, 5));
        System.out.println(orderedNumbers); // [5, 1, 2, 5, 3, 4, 5]
        // Liste in Set umwandeln (und dabei Duplikate entfernen)
        Set<Integer> uniqueNumbers = new HashSet<>(orderedNumbers);
        System.out.println(uniqueNumbers); // [1, 2, 3, 4, 5]
        // Eine Set in eine Liste konvertieren.
        orderedNumbers = new ArrayList<>(uniqueNumbers);
        System.out.println(orderedNumbers); // [1,2,3,4,5]

    }
}
