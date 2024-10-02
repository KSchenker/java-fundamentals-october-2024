public class ControlStructures {
    public static void main(String[] args) {

        // ifExamples();
        // switchExamples();
        // switchExpressionExamples();

        // while, do while, for, for(each)
        // Alle Schleifen unterstützen die break und die continue Anweisung.
        int i = 0;

        countingLoop:
        while (i <= 10) {
            if (i == 3) {
                i++;
                // Springe sofort zum Kopf bzw. Fuß der Schleife.
                continue countingLoop;
            }

            System.out.println(i);
            if (i == 5) {
                // Verlasse die while-Schleife sofort
                break countingLoop;
            }
            i++;
        }

        int x = 0, y = 0;
        rowLoop:
        while (y <= 5) { // Ausgabe der Zeilen
            x = 0;
            columnLoop:
            while (x <= 3) {
                // Spalten der Zeile ausgeben
                System.out.printf("(%02d , %02d) ", y, x);
                x++;
                if (x == 2 && y == 3) {
                    // Beende die äußere Schleife namens rowLoop.
                    break rowLoop;
                }
                if (x == 2 && y == 2) {
                    // Springe sofort zum Kopf der äußeren Schleife.
                    System.out.println();
                    y++;
                    continue rowLoop;
                }
            }
            y++;
            System.out.println(); // Zeilenumbruch
        }


        System.out.println("\nProgrammende\n");

    }

    private static void switchExpressionExamples() {
        int month = 3;
        int year = 2000;
        int daysOfMonth = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            // Bei Schaltjahren hat der Februar 29 Tage, andernfalls 28 Tage.
            default -> (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0) ? 29 : 28;
        };

        String nameOfMonth = switch (month) {
            case 1 -> "Januar";
            case 2 -> "Februar";
            case 3 -> "März";
            case 4 -> "April";
            case 5 -> "Mai";
            case 6 -> "Juni";
            case 7 -> "Juli";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "Oktober";
            case 11 -> "November";
            case 12 -> "Dezember";
            default -> "Unbekannt";
        };
        // Aufgabe: Gib Text aus: Monat XXX hat YYY Tage
        System.out.printf("Monat %s hat %d Tage\n", nameOfMonth, daysOfMonth);

        // Ein Jahr ist ein Schaltjahr, wenn es durch 4 teilbar ist. Ausnahme ist jedoch, wenn es durch 100
        // teilbar ist. Dann handelt es sich um kein Schaltjahr. Ausnahme: Das Jahr ist trotzdem ein Schaltjahr,
        // wenn es durch 400 teilbar ist.
        // Schaltjahre: 2000, 2004, 2008, 2012
        // keine Schaltjahre: 1700, 1800, 1900

        // Variante als kompakter boolescher Ausdruck
        boolean isLeapYear = (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);

        // Alternative: wie oben, aber mit expliziter if-Anweisung
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }

        // Alternative mit mehreren booleschen Variablen
        boolean isMultipleOf400 = year % 400 == 0;
        boolean isMultipleOf100 = year % 100 == 0;
        boolean isMultipleOf4 = year % 4 == 0;
        isLeapYear = isMultipleOf400 || (isMultipleOf4 && !isMultipleOf100);

        // Alternative mit if-Anweisung
        isLeapYear(year);
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void switchExamples() {
        int month = 6;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("Der Monat hat 31 Tage");
                // Anweisung break verhindert, dass die Anweisungen in den folgenden
                // cases mit ausgeführt werden.
                break;
            case 4, 6, 9, 11:
                System.out.println("Der Monat hat 30 Tage");
                break;
            default:
                System.out.println("Der Monat hat 28 Tage");
                break;
        }

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                System.out.println("Der Monat hat 31 Tage");
                System.out.println("Monat ist Jan, Mär, Mai, Jul, Aug, Okt oder Dez.");
            }
            case 4, 6, 9, 11 -> System.out.println("Der Monat hat 30 Tage");
            default -> System.out.println("Der Monat hat 28 Tage");
        }

        double bmi = 25.2;
        // switch kann (derzeit) noch nicht mit Gleitkommazahlen arbeiten.
        // switch (bmi) { }
        String name = "MaX";
        switch (name.toLowerCase()) {
            case "alice" -> System.out.println("Hi Alice");
            case "bob" -> System.out.println("Hi Bob");
            case "max" -> System.out.println("Wo hast du Moritz gelassen?");
            default -> System.out.println("Hallo Unbekannter");
        }

        System.out.println("Programmende");
    }

    private static void ifExamples() {
        double bmi = 20.2;

        if (bmi < 18.5) {
            System.out.println("Untergewicht");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Normalgewicht");
        } else if (bmi < 30) {
            System.out.println("Übergewicht");
        } else if (bmi < 35) {
            System.out.println("Adipositas 1");
        } else if (bmi < 40) {
            System.out.println("Adipositas 2");
        } else {
            System.out.println("Adipositas 3");
        }

        int n = 23;
        // Der Modulo-Operator a % b berechnet den Rest, der entsteht,
        // wenn man von a solange b abzieht, bis a kleiner als b
        // geworden ist. Mit anderen Worten: Er schaut, wie oft b in
        // a hineinpasst und gibt dann den verbleibenden Rest zurück.
        if (n % 2 == 0) {
            System.out.printf("%d ist gerade\n", n);
        } else {
            System.out.printf("%d ist ungerade\n", n);
        }

        int age = 17;
        boolean isAdult;
        if (age < 18) {
            isAdult = false;
        } else {
            isAdult = true;
        }
        // Mit dem Conditional Operator können wir simple if-else Strukturen deutlich
        // kompakter schreiben. Zuerst ist ein boolescher Ausruck zu nennen. Dieser wird
        // vom Operator ausgewertet. Falls der Ausdruck wahr ist, wird der Wert des zweiten
        // Operanden zurückgegeben, andernfalls der Wert des dritten Operanden.
        isAdult = age < 18 ? false : true;

        bmi = 21.2;
        String weightCategory = bmi < 18.5
                ? "Untergewicht"
                : bmi < 25
                    ? "Normalgewicht"
                    : bmi < 30
                        ? "Übergewicht"
                        : "Adipositas";

        System.out.println(weightCategory);
    }
}
