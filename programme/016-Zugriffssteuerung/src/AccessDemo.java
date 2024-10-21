public class AccessDemo {
    public static void main(String[] args) {

        // In der OOP verwenden wir Zugriffssteuerung, um folgendes zu erreichen:
        // 1) den direkten Zugriff auf Instanzfelder verbieten, damit keine unzulässigen
        //    Objektzustände auftreten können (Bsp.: Rechteck-Objekt mit negativer Länge/Breite,
        //    ein Bruch-Objekt mit Nenner Null)
        // 2) die Abhängigkeiten der Programmteile minimal zu halten. Je mehr ein Programmteil A über
        //    die Details eines anderen Programmteils B Bescheid weiß, umso anfälliger wird
        //    A gegenüber Veränderungen in Programmteil B. Indem wir bewusst Details von B "verstecken", kann
        //    sich A nicht unnötig abhängig machen von B.
        // 3) die Code-Anpassungen reduzieren und die Freiheit bewahren, die Internas einer Klasse zu
        //    ändern. Der Code, der eine Klasse nutzt, sollte im Idealfall unabhängig von den Internas der
        //    Klasse sein, denn dann muss er nicht angepasst werden, wenn sich die Internas ändern.

        // In Java gibt es 4 verschiedene Zugriffsebenen für die Mitglieder einer Klasse.
        // Mitglieder einer Klasse sind Felder, Methoden und geschachtelte Datentypen.
        // Zugriffsebenen:
        // - public: auf ein solches Mitglied kann im gesamten Modul einer Klasse zugegriffen werden, also
        //           auch über die Package-Grenzen hinweg.
        // - private: auf ein solches Mitglied kann nur die Klasse selbst zugreifen.
        // - protected: auf ein solches Mitglied können alle Nachfahren der Klasse zugreifen inklusive aller
        //              Klassen, die sich im selben Package befinden.
        // - package private: auf ein solches Mitglied können nur Klassen zugreifen, die sich im selben
        //                    Package befinden.
    }
}
