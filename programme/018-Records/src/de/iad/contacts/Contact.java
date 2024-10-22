package de.iad.contacts;

import java.util.Arrays;

public record Contact(String firstName, String lastName, Address address, TelephoneNumber[] phone, String mailAddress) {
    @Override
    public String toString() {
        return
            """
            Vorname: %s
            Nachname: %s
            %s
            Telefonnummern: %s
            E-Mail: %s""".formatted(this.firstName, this.lastName, this.address, Arrays.toString(this.phone), this.mailAddress);
    }
}
