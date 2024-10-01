public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");

        int age; // 2^32 verschiedene Bitmuster
        System.out.println(Integer.MAX_VALUE); // 32 Bit Integer
        System.out.println(Integer.MIN_VALUE);

        long l;
        System.out.println(Long.MAX_VALUE); // 64 Bit Integer
        System.out.println(Long.MIN_VALUE);

        byte b; // 8 Bit Integer
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        short s; // 16 Bit Integer
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);


        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        boolean isAdult = false;

        char z = 'x'; // 16 Bits (Unicode Zeichensatz, UTF-16 Kodierung)




        // Beispiel für einen Überlauf / Unterlauf bei Integer-Arithmetik
        System.out.println(Integer.MIN_VALUE - 1);

    }


}
