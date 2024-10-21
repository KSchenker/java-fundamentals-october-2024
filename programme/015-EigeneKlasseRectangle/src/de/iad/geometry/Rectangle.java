package de.iad.geometry;

import java.util.Objects;

public class Rectangle {

    // Instanzfelder: Die Werte für Umfang und Fläche werden nicht gespeichert, sondern bei
    // Bedarf aus width und length berechnet.
    public int width;
    public int length;

    // Ein parameterloser Konstruktor
    public Rectangle() {
        // Wir delegieren die Initialisierung des Objekts an einen anderen Konstruktor dieser Klasse.
        this(1, 1);
    }

    // Ein Konstruktor zum Erstellen eines Quadrats der Kantenlänge length.
    public Rectangle(int length) {
        this(length, length);
    }

    public Rectangle(int width, int length) {
        this.setDimensions(width, length);
    }

    // Instanzmethoden
    public boolean isSquare() {
        return this.width == this.length;
    }

    public int getArea() {
        return this.length * this.width;
    }

    public int getPerimeter() {
        return 2 * this.length + 2 * this.width;
    }

    public void setDimensions(int width, int length) {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("Breite und Länge müssen > 0 sein");
        }
        this.width = width;
        this.length = length;
    }

    // Diese statische Methode bezeichnet man als Factory-Methode. Sie erstellt ein
    // neues Objekt dieser Klasse mit bestimmten Eigenschaften (hier ein Quadrat).
    public static Rectangle ofSquare(int length) {
        return new Rectangle(length);
    }

    // Aufgabe: Überschreibe die geerbte Methode toString und implementiere sie
    // so, dass folgender Text erstellt wird: <Vollqualifizierter Klassenname> { width=XXX, length=XXX, area=XXX }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName())
                .append("{")
                .append("width=" + this.width)
                .append(", length=" + this.length)
                .append(", area=" + this.getArea())
                .append(", perimeter=" + this.getPerimeter())
                .append("}");
        // Erstelle aus dem StringBuilder einen herkömmlichen String.
        return builder.toString();
    }

    // Aufgabe: Überschreibe die geerbte Methode equals und implementiere sie so, dass zwei Rectangle-Objekte gleich sind,
    // wenn sie identische Werte in den Feldern width und length haben.
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (other instanceof Rectangle r) {
            // Zwei Rectangle-Objekte sind gleich, wenn sie identische Werte
            // für width und length verwenden.
            return this.width == r.width && this.length == r.length;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // Die Implikation a.equals(b) == true => a.hashCode() == b.hashCode()
        // ist erfüllt.
        return Objects.hash(this.width, this.length);
    }
}
