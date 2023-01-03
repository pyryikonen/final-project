
import java.util.Scanner;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;





public class ContactManagement{ 
    ArrayList <Contact> list;
    Scanner scanner = new Scanner(System.in);
    

    public ContactManagement(){
        list = new ArrayList<>();
    
    }

//addContact method

    public void addContact(Contact contact){
        
            if(!find(contact.getContactId())){
                    list.add(contact);     
        }
            else{
                System.out.println("Contact already exists.");
            }
            }
    public void addNewContact(Contact contact){
        
        System.out.println("What is the Contact Id of the contact?");
        int ContactId = scanner.nextInt();         
        scanner.nextLine();
      
        System.out.println("What is the Personal Id of the contact?");
        String personal = scanner.nextLine();
        
        System.out.println("What is the First Name of the contact?");
        String firstName = scanner.nextLine();

        System.out.println("What is the Last Name of the contact?");
        String lastName = scanner.nextLine();

        System.out.println("What is the Phonenumber of the contact?");
        String phoneNumber = scanner.nextLine();

        System.out.println("What is the Address of the contact?");
        String address = scanner.nextLine();

        System.out.println("What is the Email of the contact?");
        String email = scanner.nextLine();
        

        contact = new Contact(ContactId, personal, firstName, lastName, phoneNumber, address, email);
        addContact(contact);
        System.out.println(contact.toString());
    }

    //find method to check personal
    // Searching Contact
    public boolean find(int checkContactId){     
            for(Contact l : list){

                if(l.getContactId() == checkContactId){
                    System.out.println(l);
                    return true;
            }
        } 
        return false;
    }

    //delete method for contacts
    public void deleteContact(int checkContactId){
            Contact contactDel = null;

            for(Contact ll : list){
                if(ll.getContactId() == checkContactId){
                    contactDel = ll;
                }
            }
            if (contactDel == null){
                System.out.println("Invalid personal id");
            }
            else{
                list.remove(contactDel);

                System.out.println("Contact: \n " + contactDel + "\n has been removed from Contacts.");
            }
    }
    //findContact method for updateContact to work

    public Contact findContact(int ContactId){
            for(Contact l : list){

                if(l.getContactId() == ContactId){
                    return l;
                }
            }
            return null;
        }


    //updateContact method
    public void updateContact(int id, Scanner scanner){
            if(find(id)){
                Contact con = findContact(id);

                System.out.println("What is the new Contact Id of the contact?");
                int ContactId = scanner.nextInt();
                scanner.nextLine();

                System.out.println("What is the new Personal Id of the contact?");
                String personal = scanner.nextLine();
            
                System.out.println("What is the new First Name  of the contact?");
                String firstName = scanner.nextLine();
            
                System.out.println("What is the new Last Name  of the contact?");
                String lastName = scanner.nextLine();
            
                System.out.println("What is the new Phonenumber of the contact?");
                String phoneNumber = scanner.nextLine();
            
                System.out.println("What is the new Address of the contact?");
                String address = scanner.nextLine();
            
                System.out.println("What is the new Email of the contact?");
                String email = scanner.nextLine();
                
                
                con.setContactId(ContactId);
                con.setPersonal(personal);
                con.setFirstName(firstName);
                con.setLastName(lastName);
                con.setPhoneNumber(phoneNumber);
                con.setAddress(address);
                con.setEmail(email);

                System.out.println("Contact updated!");
            
            }
            else{
                System.out.println("Contact not found from the Contactlist!");
            }
        }   
    

    public void displayContact()
        {
    
            // If record list is empty then
            // print the message below
            if (list.isEmpty()) {
    
                // Print statement
                System.out.println("The list has no contacts\n");
            }
            // Iterating Record list
            // using for each loop
            for (Contact contact : list) {
    
                // Printing the list
                System.out.println(contact.toString());
            }
        }

        public ArrayList<Contact> readData() throws IOException { 
            
            BufferedReader br = new BufferedReader(new FileReader("/Path/To/file.csv"));  
            String line = "";  
            String DELIMITER = "|";  
            
            while ((line = br.readLine()) != null) {
                    String[] values = line.split(DELIMITER);
                    list.addAll(values[2]);
            }
            return list;
        }

 
}

