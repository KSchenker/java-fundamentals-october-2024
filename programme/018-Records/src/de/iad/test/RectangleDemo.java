package de.iad.test;

import de.iad.geometry.Rectangle;

public class RectangleDemo {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(10, 20);
        System.out.println(r1.toString()); // Rectangle[width=10, length=20]
        System.out.println(r1.equals(r2)); // true
        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());
        System.out.printf("Länge: %d Breite: %d\n", r1.length(), r1.width());
        System.out.println(r1.getPerimeter()); // 60
        System.out.println(r1.getArea()); // 200
        System.out.println(r1.withLength(50)); // Rectangle[width=10, length=50]
        System.out.println(r1.withWidth(80)); // Rectangle[width=80, length=20]
        System.out.println(r1); // Rectangle[width=10, length=20]
        // new Rectangle(-20, 4000); // Hier wird eine IllegalArgumentException ausgelöst
        r1.withWidth(-50); // Hier wird IllegalArgumentException ausgelöst.

    }

}
