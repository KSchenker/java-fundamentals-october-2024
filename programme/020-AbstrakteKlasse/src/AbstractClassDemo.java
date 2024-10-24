public class AbstractClassDemo {

    public static void main(String[] args) {

        // Eine abstrakte Klasse wird implementiert, um als reine Elternklasse zu dienen. Ihr Sinn besteht darin,
        // gemeinsame Logik/Verhalten/Handlungskompetenz und Zustand (Instanzfelder) von Unterklassen auszulagern und
        // wiederverwendbar zu machen.
        // Wie Interfaces (Schnittstellen) kann auch eine abstrakte Klasse sogenannte abstrakte Methoden definieren.
        // Eine abstrakte Methode hat keinen Rumpf, sondern definiert nur Rückgabedatentyp, Name und Parameterliste.
        // Die Unterklassen der abstrakten Klasse müssen dann für diese abstrakte Methode einen Rumpf (also eine Implementierung)
        // bereitstellen.
        // Da eine abstrakte Klasse abstrakte Methoden besitzen darf, kann man keine Objekte von ihr erstellen. Denn
        // die abstrakte Klasse ist ja dann nicht vollständig und der Aufruf von abstrakten Methoden würde zu einem Absturz
        // führen.
        // Wo liegt nun der Unterschied zu einem Interface mit Default-Methoden? Ein Interface kann keine Instanzfelder
        // (Zustand) vererben, sondern nur Handlungskompetenz (Verhalten). Der Sinn des Interfaces ist es, ein Kommunikationsprotokoll
        // zu spezifizieren ohne die genauen Details anzugeben. Eine abstrakte Klasse hingegen kann sehrwohl die Details
        // angeben, nämlich die konkreten Felder.
        // Eine Klasse kann beliebig viele Interfaces implementieren, aber nur von EINER Klasse erben. (zumindest in Java und C#)

        // Hinweis: Wenn eine Methode einen Parameter vom Typ "abstrakte Klasse" verwendet, dann kann diese Methode
        // mit allen Objekten aller Nachfahren der abstrakten Klasse verwendet werden.
        // Würde die Methode hingegen einen Parameter vom Typ "Interface" verwenden, dann kann diese Methode theoretisch
        // mit Objekten aller Klassen arbeiten. Voraussetzung ist, dass die Klasse die Schnittstelle implementiert.
        // In der OOP sagt man deshalb auch: Interfaces bieten die "loseste Kopplung" zwischen Programmbestandteilen.

        // Die Beziehung zwischen Eltern und Kindklasse ist sehr "eng". Die Kindklasse (Unterklasse) muss in der Regel
        // sehr viel über die Internas der Elternklasse wissen. Deshalb bezeichnet man die Beziehung zwischen Eltern und
        // Kindklasse als "enge Kopplung".

        // Tipp / Faustregel: Wenn du Code wiederverwenden willst, ist Vererbung nicht immer die beste Wahl. Versuche
        // eher durch Komposition den Code auszulagern und an vielen Stellen einzusetzen. "Vererbung ist nicht der
        // heilige Gral" :-)


        AbstractStoryGenerator generator = new DisneyStoryGenerator();
        System.out.println(generator.getStory());
        System.out.println(generator.getStory());
        System.out.println(generator.getStory());

        generator = new HorrorStoryGenerator();
        System.out.println(generator.getStory());
        System.out.println(generator.getStory());
        System.out.println(generator.getStory());

    }

}
