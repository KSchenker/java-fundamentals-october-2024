package de.iad.access;

public class AnotherBaseClass {

    void m() {
        BaseClass bc = new BaseClass();
        bc.publicField = 1; // OK
        bc.packagePrivateField = 1; // OK
        bc.protectedField = 1; // OK
        // bc.privateField = 1; // Fehler: Zugriff verweigert, da private.

    }

}
