
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class ContactsApp {

public static void main(String [] args)
    {

        ContactManagement cm = new ContactManagement();
        Contact contact = new Contact();
        
        //CSVreader.readDataLineByLine("/Users/pyryw/Documents/exercise/github/2022-wk47-final-project-pyryikonen/src/contacts.csv");

        contact.setContactId(0);
        contact.setPersonal("010400A345C");
        contact.setFirstName("Pyry");
        contact.setLastName("Ikonen");
        contact.setPhoneNumber("041 325 8332");
        contact.setAddress("Kevatkatu 12 C");
        contact.setEmail("rypy2123@gmail.com");

        cm.addContact(contact);

        Scanner scanner = new Scanner(System.in);   // Searched StackOverflow to include "ä" but
                                                    // it seemed that there was no solution 

        int option = 0;
        // read csv file
        

        do{
        menu();
        option = scanner.nextInt();
        scanner.nextLine();
        
    
    
        switch(option){


        //display contact
        case 1:
        
        cm.displayContact();
        break;

        
        

        //case 2 add contact
        case 2: 
        cm.addNewContact(contact);
        break;


        case 3: // update a contact
        
            System.out.println("What is the Contact Id of the contact?");
            int cIdUp = scanner.nextInt();
            scanner.nextLine();
            cm.updateContact(cIdUp, scanner);
        
            break;

        case 4: //delete a contact

            System.out.println("What is the Contact Id of the contact?");
            int cId = scanner.nextInt();
            scanner.nextLine();
            cm.deleteContact(cId);

            break;





        case 5: //search a contact
            System.out.println("What is the Contact Id of the contact?");
            int sIdSr = scanner.nextInt();
            scanner.nextLine();
            if(!cm.find(sIdSr)){
                System.out.println("Contact Contact Id doesnt exist");
            }
                break;

        case 6: // exit the program
            System.out.println("Thank you for using the ContactsApp! Goodbye!");
            //save csv file
            File file = new File("/Users/pyryw/Documents/exercise/github/2022-wk47-final-project-pyryikonen/src/contacts.csv");
            try (FileWriter fw = new FileWriter(file)) {
                BufferedWriter bw = new BufferedWriter(fw);
    
                bw.write("| Contact Id | Personal Id | First Name | Last Name | Phonenumber | Address | Email | \n"
                );
                for(int i=0;i<cm.list.size();i++)
                {
                    bw.write(cm.list.get(i)+ "\n");
                }
                bw.newLine();
                bw.close();
                fw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.exit(0);
            break;

        default: // If you enter a wrong command

            System.out.println("Error Invalid input!");
            break;
        

            }
        }

        while (option !=6);
    }

    public static void menu(){
        System.out.println("MENU:");
        System.out.println("Enter 1 to display all the contacts");
        System.out.println("Enter 2 to add a contact");
        System.out.println("Enter 3 to update a contact ");
        System.out.println("Enter 4 to remove a contact ");
        System.out.println("Enter 5 to search a contact ");
        System.out.println("Enter 6 to quit the program");
        System.out.println("Enter a command: ");
        
    }


   
}






    
    
    





