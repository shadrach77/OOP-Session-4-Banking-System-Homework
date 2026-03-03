import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Customer> customers = new ArrayList<>();
    private static int numberOfCustomers;

    public Bank(String bankName) {
        this.bankName = bankName;
    }
    
    public void addCustomer(String fName, String lName){
        customers.add(new Customer(fName,lName));
        numberOfCustomers++;
    }

    public String searchCustomer(String firstName){
      for (int i=0; i<numberOfCustomers; i++){
        Customer currCustomer = customers.get(i);
        if (firstName.equals(currCustomer.getFirstName())){
          return String.format("=====\nCustomer Details:\nFirst Name: %s\nLast Name:%s\nBalance: %s\n=====", currCustomer.getFirstName(), currCustomer.getLastName(), currCustomer.getAccount().getBalance());
        }
      }
      return "Customer with first name" + firstName + "not found";
    }

    public boolean deleteCustomer(int index){
      if (index < numberOfCustomers){
          customers.remove(index);
          numberOfCustomers--;
          return true;
      } return false;

    }

    public String displayCustomers(){
      String toDisplay = "Displaying all customers:\n";

      for (int i=0; i<numberOfCustomers; i++){
        Customer currCustomer = customers.get(i);
        toDisplay += searchCustomer(currCustomer.getFirstName());
      }
      return toDisplay;
    }

    public boolean createAccount(Customer customer){
      customer.setAccount(new Account());
      return true;
    }
   
    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }
    
    public Customer getCustomer(int index){
        return customers.get(index);
    }
}
