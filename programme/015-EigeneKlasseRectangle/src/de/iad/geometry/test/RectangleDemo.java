package de.iad.geometry.test;

import de.iad.geometry.Rectangle;

public class RectangleDemo {

    public static void main(String[] args) {

        Rectangle area52 = new Rectangle(100, 200);
        System.out.println(area52.getArea()); // 20_000
        System.out.println(area52.getPerimeter()); // 600
        System.out.println(area52.isSquare()); // false

        Rectangle nineByNine = Rectangle.ofSquare(9);
        System.out.println(nineByNine.isSquare()); // true
        System.out.println(nineByNine.getPerimeter()); // 36
        System.out.println(nineByNine.getArea()); // 81

        Rectangle r1 = new Rectangle(2, 5);
        Rectangle r2 = new Rectangle(2, 5);
        System.out.println(r1 == r2); // false
        System.out.println(r1.equals(r2)); // true
        System.out.println(r1);
        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());


        area52.length = -2;
        System.out.println(area52.getArea());


    }

}
