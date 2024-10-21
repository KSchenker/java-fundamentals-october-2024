package de.iad.access;

public class BaseClass {

    public int publicField;
    private int privateField;
    int packagePrivateField;
    protected int protectedField;

    void m() {
        BaseClass bc = new BaseClass();
        bc.publicField = 1;
        bc.protectedField = 1;
        bc.packagePrivateField = 1;
        bc.privateField = 1; // OK
        this.privateField = 1;
        this.publicField = 1;
        this.protectedField = 1;
        this.packagePrivateField = 1;
    }

    class Inner {

    }


}
