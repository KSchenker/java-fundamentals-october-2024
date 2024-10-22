package de.iad.test;

import de.iad.contacts.Address;
import de.iad.contacts.Contact;
import de.iad.contacts.TelephoneNumber;

import java.util.Arrays;
import java.util.Objects;

public class ContactsDemo {
    public static void main(String[] args) {
        var workPhone = new TelephoneNumber("049", "0987", "2468135");
        var mobilePhone = new TelephoneNumber("049", "0191", "987654");
        System.out.println(workPhone);
        var address = new Address("Villa Kunterbunt", "123a", "8765", "Berlin", "Schlaraffenland");
        System.out.println(address);

        var phoneList = new TelephoneNumber[]{workPhone, mobilePhone};
        var phoneList2 = new TelephoneNumber[]{workPhone, mobilePhone};

        var contact = new Contact("Max", "Mustermann",
                address, phoneList, "max@mustermann.de");
        System.out.println(contact);

        var max = new Contact("Max", "Mustermann",
                address, phoneList2, "max@mustermann.de");
        System.out.println(contact.equals(max)); // true
        System.out.println(contact.hashCode() == max.hashCode()); // true


        Contact copyOfMax = max.deepCopy();
        System.out.println(max.equals(copyOfMax)); // true :-)
        System.out.println(copyOfMax.hashCode());
        System.out.println(max.hashCode());

//        Integer[] numbers = {2, 4, 6, 9};
//        Integer[] copyOfNumbers = Arrays.copyOf(numbers, numbers.length);
//        System.out.println(numbers == copyOfNumbers); // false (nicht dasselbe Array-Objekt)
//        System.out.println(numbers.equals(copyOfNumbers)); // false (unerwartet)
//        System.out.println(Arrays.deepEquals(numbers, copyOfNumbers)); // true (da die Elemente der Arrays gleich sind)



    }
}
