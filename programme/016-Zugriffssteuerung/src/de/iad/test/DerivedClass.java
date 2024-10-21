package de.iad.test;

import de.iad.access.BaseClass;

public class DerivedClass extends BaseClass {

    void m() {
        BaseClass bc = new BaseClass();
        bc.publicField = 1; // OK
        // bc.packagePrivateField = 1; // Fehler: DerivedClass gehört nicht zu de.iad.access
        // bc.privateField = 1; // Fehler: Nur BaseClass hat Zugriff auf privateField
        // bc.protectedField = 1; // Fehler: Zugriff nicht gestattet, da bc ein Objekt einer Oberklasse ist.
        this.protectedField = 1; // OK: Zugriff auf geerbtes protectedField erlaubt.

        DerivedClass dc = new DerivedClass();
        dc.publicField = 1; // OK
        dc.protectedField = 1; // OK: dc ist Objekt dieser Klasse
        // dc.packagePrivateField = 1; // Fehler: DerivedClass kein Mitglied von de.iad.access
        // dc.privateField = 1; // Fehler: Nur BaseClass hat Zugriff auf privateField.
    }

}
