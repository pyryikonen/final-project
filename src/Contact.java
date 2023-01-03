


import java.util.regex.*;

public class Contact {

    //variables
    private int ContactId;
    private String personal;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;
    

    // Default constructor

    public Contact(){}
    

    //Constructor with parameters
    public Contact(int ContactId, String personal, String firstName, String lastName, String phoneNumber, String address, String email){
        this.ContactId = ContactId;
        this.personal = personal;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;

    }
    
    // getters and setters
    public int getContactId() {
        this.ContactId = ContactId;
        return ContactId;
         
    }


    public int setContactId(int contactId) {
        if(ContactId >= 0 && ContactId <=100){
        this.ContactId = ContactId;
        return ContactId;
        }
        else{
            throw new IllegalArgumentException("Contact id must be between 0 and 100");
        }
        
            
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        if(personal.length() == 12){
            throw new IllegalArgumentException("Personal id must contain 12 characters! ");
        }
        this.personal = personal;

    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        if(firstName.matches("[a-zA-Z]+")){
        this.firstName = firstName;}
        else{System.out.println("Not a valid First Name");}
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
    String regex = "^(([0-9]{3})[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4}))$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNumber);
    if (matcher.matches() == true){
        this.phoneNumber = phoneNumber;
    } else {
        System.out.println(phoneNumber + " Is not a valid phone number.");
    }
    }

    
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
         this.address = address;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        if(isValid(email)){
        this.email = email;
    }
    else{System.out.println("Not a valid Email Address");
}
    }

    @Override public String toString(){
        return "Contact Id: " + ContactId + "\nPersonal Id: " + personal + "\nFirst name: " + firstName + "\nLast name: " + lastName + 
        "\nPhonenumber: " + phoneNumber + "\nAddress: " + address + "\nEmail: " + email;
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
