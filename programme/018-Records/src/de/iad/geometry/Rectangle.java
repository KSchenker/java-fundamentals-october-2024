package de.iad.geometry;

import org.w3c.dom.css.Rect;

// Ein Record ist ein Referenzdatentyp. Er wird dafür verwendet, um unveränderliche (immutable)
// Objekte zu erstellen. Bei der Übersetzung des Quelltextes baut der Compiler aus dem Record
// eine herkömmliche Klasse. Records eignen sich hervorragend für simple Datenstrukturen, also
// Aggregate hetrogener Variablen.
// Der Compiler erstellt automatisch eine passende hashCode, equals und toString Methode.
// Außerdem implementiert er einen Konstruktor mit Parametern für jedes Feld.
// Um die Felder auszulesen, wird für jedes Feld eine Getter-Methode implementiert, die denselben
// Namen wie das zugehörige Feld trägt.
//
// Einschränkungen für Records:
// - automatische Felder sind immer final
// - keine Vererbung von einem anderen Record / Klasse möglich
// - zusätzliche Felder müssen static sein, d.h. Instanzfelder sind verboten
//
// Hinweis: Records können zwar von keiner Klasse erben, allerdings dürfen sie Schnittstellen implementieren.
public record Rectangle(int width, int length) {

    // Um die Parameter zu validieren, können wir den automatisch erstellen Konstruktor mit
    // Validierungslogik erweitern.
    // Hinweis: Beachte die fehlende Parameterliste!
    public Rectangle {
        // Hier haben wir Zugriff auf die nicht sichtbaren Parameter width und length.
        // Wir müssen hier auch nicht die Werte an die Felder zuweisen, da dies der Compiler
        // automatisch macht.
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("Länge und Breite müssen > 0 sein!");
        }
    }

    // Theoretisch kann man den automatisch erstellten Konstruktor auch selbst komplett implementieren.
    // Dann muss man aber auch die Felder selbst initialisieren.
//    public Rectangle(int width, int length) {
//        if (width <= 0 || length <= 0) {
//            throw new IllegalArgumentException("Länge und Breite müssen > 0 sein!");
//        }
//        this.width = width;
//        this.length = length;
//    }

    public int getArea() {
        return this.length * this.width;
    }

    public int getPerimeter() {
        return 2 * (this.length + this.width);
    }

    // Da die Felder eines Records final sind, müssen wir neue Objekte erstellen,
    // wenn der Zustand verändert werden soll.
    public Rectangle withWidth(int width) {
        return new Rectangle(width, this.length);
    }

    public Rectangle withLength(int length) {
        return new Rectangle(this.width, length);
    }
}

// Der Code für den obigen Record sieht ungefähr so aus:
// public class Rectangle {
//  private final int width;
//  private final int length;
//
//  public Rectangle(int width, int length) {
//    this.width = width;
//    this.length = length;
//  }
//
//  public int width() { return this.width; }
//  public int length() { return this.length; }
//
//  @Override
//  public String toString() {
//      return "%s[width=%d, length=%d]".formatted(this.getClass().getName(), this.width, this.length);
//  }
//
//  @Override
//  public int hashCode() { ... }
//
//  @Override
//  public boolean equals(Object other) {
//      // Vergleiche this.width mit other.width, this.length mit other.length
//  }
// }
