public class StringsDemo {

    public static void main(String[] args) {
        // Die Klasse String in Java wird gesondert behandelt.
        // Alle Klassen (also auch String) sind Referenzdatentypen.
        // Eine Variable vom Typ String speichert also nicht die Zeichenkette selbst, sondern lediglich eine Referenz
        // auf ein String-Objekt im Heap.
        // String-Objekte sind unveränderlich. Ihr Zustand lässt sich nicht nach ihrer Erstellung ändern. Das ist
        // eine Speicheroptimierung der Java Virtual Machine. Auf diese Weise kann ein String-Objekt geteilt werden.

        String a = "abc";
        String b = "abc";
        String c = "ABC".toLowerCase(); // "abc"
        // Prüfe, ob die Referenzvariablen a und b auf DASSELBE String-Objekt im Heap verweisen.
        System.out.println(a == b); // sehr wahrscheinlich true
        System.out.println(a == c); // sehr wahrscheinlich false

        // Um Zeichenketten zu vergleichen, ist der == Operator UNGEEIGNET.
        // In Java prüft == nur, ob zwei Variablen auf dasselbe Objekt zeigen.
        // Ausnahme: Werte primitiver Datentypen können problemlos mit == verglichen werden, da die Variablen den
        // tatsächlichen Wert enthalten und keine Referenz.
        if (c.equals(a)) {
            System.out.println("Zeichenkette a und c sind gleich (aber möglicherweise nicht identisch)");
        }

        // Erstelle Referenzvariable name und lasse sie auf ein neu erstelltes String-Objekt mit Inhalt "alice" zeigen.
        String name = new String("alice");
        name = "bob"; // Ausnahme in Java: String-Objekte können ohne new Operator erstellt werden.
        // Für Strings hat der + Operator eine Sonderfunktion
        name = "abc" + 123; // Ausnahme: Bei String-Objekten ist der + Operator "überladen". Hier kommt "abc123" heraus.
        name = ("abc" + 123) + new int[]{1, 2}; // abc123[I@6acbcfc0
        System.out.println(name);
        System.out.println("abc" + "uvw"); // + führt hier eine String-Konkatenation durch (Aneinanderhängen)

        name = 2 + 3 + "uvw";
        System.out.println(name); // Ergebnis ist 5uvw!

        // Ein Array von Char lässt sich mit einem String-Konstruktor in ein String umwandeln.
        char[] letters = {'a', 'b', 'c'};
        String lettersAsString = new String(letters);
        System.out.println(lettersAsString);
        // Die Instanzmethode toCharArray wandelt die Zeichen einer Zeichenkette in ein neues char-Array um.
        letters = lettersAsString.toCharArray();
        // Die einzelnen Zeichen einer Zeichenkette mit einer for-each Schleife durchlaufen.
        for (char aCharacter : "xyz".toCharArray()) {
            System.out.println(aCharacter);
        }

        System.out.printf("Die Zeichenkette %s hat %d Zeichen.\n", "abc", "abc".length());
        // Die statische Methode String.format funktioniert wie printf, aber schreibt das Ergebnis nicht auf die
        // Kommandozeile, sondern liefert es als String-Objekt an den Aufrufer zurück.
        String errorMessage = String.format("Fehler wurde entdeckt: %s", "Datei nicht gefunden");
        // Seit einiger Zeit gibt es auch die Instanzmethode formatted, mit der man dasselbe wie mit String.format
        // erreichen kann.
        errorMessage = "Fehler wurde entdeckt: %s".formatted("Nicht genügend Speicher");
        System.out.println(errorMessage);

        String friend = "Mustermann, Max";
        // friend.toLowerCase() liefert neues String-Objekt mit Kleinbuchstaben.
        // Auf diesem Objekt rufen wir gleich im Anschluss die contains Methode auf.
        if (friend.toLowerCase().contains("max")) {
            System.out.println("Die Zeichenkette max ist in %s enthalten".formatted(friend));
        }

        // Manche Zeichen lassen sich nicht buchstäblich in ein Zeichenkettenliteral einfügen. In solchen Fällen
        // verwenden wir sogenannte Escape-Codes wie z.B. \n für Zeilenumbruch, \t für Tabulator, \" für das
        // Doppelte Hochkomma und \\ für den Backslash selbst.
        String greeting = "Hello\n \"Max\"!";
        System.out.println(greeting);

        String helpText = "Programmname (c) 2020 by XYZ\n" +
                "Synopsis: programm <argument1> <argument>2\n" +
                "Description: Formats your hard disk :D";
        System.out.println(helpText);

        helpText = """
                Programmname (c) 2020 by XYZ
                Synopsis: programm <argument1> <argument>2
                Description: Formats your hard disk :D
                """;
        System.out.println(helpText);

        // Man kann statt eines Zeichens auch den Hexadezimalcode des Zeichens in den String einfügen. Das entspricht
        // stets 2 Byte in der UTF-16 Kodierung.
        System.out.println("AB\u1D01CD");
        System.out.println("ABᴁCD".length()); // 5

        // Mit der Instanzmethode charAt können wir einzelne Zeichen des Strings auslesen.
        // Ein char kann problemlos in ein int konvertiert werden. Das Ergebnis ist der Kodierungswert des Zeichens
        // (in Java ist das ein UTF-16 Codepoint)
        name = "Max";
        System.out.println(name.charAt(1)); // a
        System.out.println((int)name.charAt(1)); // 97 (Numerischer Wert des Zeichens a, also der Codepoint)
        System.out.println((int)'Ü');
        System.out.println('❤');
        // Ein int lässt sich auch problemlos in ein char konvertieren.
        System.out.println((char)198); // Æ
        // Um ein Zeichen in einen String zu konvertieren, verwende den + Operator mit einer leeren Zeichenkette.
        String charAsString = "" + 'x';
        // Grundsätzlich können alle primitiven Werte mit String.valueOf in eine Zeichenkette konvertiert werden.
        System.out.println(String.valueOf('x'));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(1.21));
        System.out.printf("%f\n", 1.21);
        System.out.println(String.valueOf("abc"));
        System.out.println(String.valueOf(2));

        System.out.println("Programmende");

        // Belies dich in der JDK Dokumentation zur Klasse String und führe folgende Operationen durch:
        // 1) Beliebig viele Zeichenketten aneinanderhängen
        // 2) Prüfen, ob eine Zeichenkette einen vorgegebenen Präfix enthält (unabhängig von der Groß und Kleinschreibung)
        // 3) Entferne alle führenden und nachfolgenden Leerzeichen einer Zeichenkette
        // 4) Eine Zeichenkette der Form xx.yy.zz in 3 Zeichenketten xx, yy und zz zerlegen.
        // 5) Ein Zeichen in einer Zeichenkette ersetzen.
        // 6) Du hast einen Dateipfad gegeben (z.B. C:\Programme\IntelliJ\settings.json) und sollst den Dateinamen
        //    (also settings.json) ermitteln.

        // String.join verknüpft beliebig viele Zeichenketten und fügt optional einen Trennstring ein.
        System.out.println(String.join(", ", "alice", "bob", "charlie", "damian"));
        System.out.println("C:\\" + String.join("\\", "programme", "microsoft", "office", "word"));
        System.out.println(String.join(";", new String[] {"alice", "bob", "charlie"}));
        // String.startsWith prüft, ob eine Zeichenkette mit einem bestimmten Wort beginnt.
        name = "Max Mustermann";
        System.out.println(name.toLowerCase().startsWith("Max")); // true
        System.out.println(name.toLowerCase().startsWith("max")); // false
        System.out.println(name.toLowerCase().startsWith("max")); // true
        System.out.println("Mustermann, Max".startsWith("Max")); // false
        System.out.println("Mustermann, Max".contains("Max")); // true
        System.out.println("  Max Mustermann".startsWith("Max")); // false

        // Die Methoden trim und strip entfernen führende und nachfolgende Leerzeichen einer Zeichenkette.
        System.out.println("   hallo\t\r\njava\n\t     ".strip());


    }


}
