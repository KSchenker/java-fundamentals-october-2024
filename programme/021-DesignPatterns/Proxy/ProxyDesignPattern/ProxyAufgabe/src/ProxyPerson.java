// ------- ProxyPerson-KLASSE ---------
public class ProxyPerson implements IPerson {
    private OriginalPerson originalPerson;
    private String firstName;
    private String lastName;
    private String address;

    public ProxyPerson(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public void show() {

        // Gleicht ab, ob es dieses Objekt in der originalen Klasse schon gibt.
        // Falls nicht, wird ein neues originales Objekt der originalen Klasse erstellt.
        if(originalPerson == null){
            originalPerson = new OriginalPerson(firstName,lastName,address);
        }

        // Ruft die show-Methode der originalen Klasse auf.
        originalPerson.show();
    }

    @Override
    public void setFirstName(String newFirstName){

        // Vergleicht, ob die neue Eingabe identisch oder leer ist. Wenn beides false ist,
        // werden die Daten verändert.
        if(!newFirstName.equals(getFirstName()) && !newFirstName.isBlank()) {
            originalPerson.setFirstName(newFirstName);
        }
    }

    @Override
    public void setLastName(String newLastName){

        if(!newLastName.equals(getLastName()) && !newLastName.isBlank()){
            originalPerson.setLastName(newLastName);
        }
    }

    @Override
    public void setAddress(String newAddress){

        if(!newAddress.equals(getAddress()) && !newAddress.isBlank()){
            originalPerson.setAddress(newAddress);
        }
    }

    @Override
    public String getFirstName(){

        // ruft die Methode der originalen Klasse auf
        return originalPerson.getFirstName();
    }

    @Override
    public String getLastName(){
        return originalPerson.getLastName();
    }

    @Override
    public String getAddress(){
        return originalPerson.getAddress();
    }



}
