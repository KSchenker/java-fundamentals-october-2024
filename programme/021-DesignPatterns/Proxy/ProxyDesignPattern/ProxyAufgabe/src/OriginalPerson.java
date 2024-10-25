//------- OriginalPerson-KLASSE ---------
public class OriginalPerson implements IPerson {
    private String firstName;
    private String lastName;
    private String address;

    public OriginalPerson(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    @Override
    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    @Override
    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    @Override
    public String getFirstName(){
        return firstName;
    }

    @Override
    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public void show(){

        // zeigt die Werte der Klasse an
        System.out.printf("Vornamen: %s, Nachnamen: %s, Adresse: %s\n", firstName, lastName, address);
    }
}
