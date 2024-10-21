package de.iad.test;

import de.iad.access.BaseClass;

public class SomeTestClass {

    void m() {
        BaseClass bc = new BaseClass();
        bc.publicField = 1; // OK
        // bc.protectedField = 1; // Fehler: Klasse ist keine Unterklasse von BaseClass
        // bc.packagePrivateField = 1; // Fehler: Klasse gehört nicht zum Package de.iad.access
        // bc.privateField = 1; // Fehler: Nur BaseClass hat Zugriff auf privateField
    }
}
