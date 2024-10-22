package de.iad.test;

import de.iad.contacts.Address;
import de.iad.contacts.Contact;
import de.iad.contacts.TelephoneNumber;

public class ContactsDemo {
    public static void main(String[] args) {
        var workPhone = new TelephoneNumber("049", "0987", "2468135");
        var mobilePhone = new TelephoneNumber("049", "0191", "987654");
        System.out.println(workPhone);
        var address = new Address("Villa Kunterbunt", "123a", "8765", "Berlin", "Schlaraffenland");
        System.out.println(address);

        var phoneList = new TelephoneNumber[]{workPhone, mobilePhone};

        var contact = new Contact("Max", "Mustermann",
                address, phoneList, "max@mustermann.de");
        System.out.println(contact);

        var max = new Contact("Max", "Mustermann",
                address, phoneList, "max@mustermann.de");
        System.out.println(contact.equals(max));
    }
}
