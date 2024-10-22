package de.iad.contacts;

import java.util.Arrays;
import java.util.Objects;

public record Contact(String firstName, String lastName, Address address, TelephoneNumber[] phones, String mailAddress) {
    @Override
    public String toString() {
        return
            """
            Vorname: %s
            Nachname: %s
            %s
            Telefonnummern: %s
            E-Mail: %s""".formatted(this.firstName, this.lastName, this.address, Arrays.toString(this.phones), this.mailAddress);
    }

    public Contact deepCopy() {
        // Um ein Contact-Objekt vollständig zu kopieren, muss das Array der Telefonnummern dupliziert werden,
        // da ein Array-Objekt veränderlich (mutable) ist. Alle anderen Felder sind Strings oder Records.
        TelephoneNumber[] copyOfPhones = Arrays.copyOf(this.phones, this.phones.length);
        return new Contact(firstName, lastName, address, copyOfPhones, mailAddress);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;

        if (other instanceof Contact otherContact) {
            return this.firstName.equals(otherContact.firstName)
                    && this.lastName.equals(otherContact.lastName)
                    && this.address.equals(otherContact.address)
                    && this.mailAddress.equals(otherContact.mailAddress)
                    && Arrays.deepEquals(this.phones, otherContact.phones);
        }

        return false;
    }

    @Override
    public int hashCode() {
        long phoneListHashCode = Objects.hash((Object[])this.phones);
        return Objects.hash(firstName, lastName, address, mailAddress, phoneListHashCode);
    }
}
