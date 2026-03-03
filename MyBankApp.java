import java.util.Scanner;

public class MyBankApp {
    public static void main(String[] args) {

        boolean programRunning = true;
        char role = ' ';
        Scanner scnr = new Scanner(System.in);

        // pick role
        boolean roleCorrect = false;

        while (!roleCorrect) {
            System.out.print("Please choose a role ('A' for admin, or 'C' for customer): ");
            String input = scnr.nextLine().trim().toUpperCase();
            if (input.length() > 0) {
                role = input.charAt(0);
            }

            if (role == 'A' || role == 'C') {
                roleCorrect = true;
            } else {
                System.out.println("Invalid role. Try again.");
            }
        }

        // initialize bank and customer
        Bank currBank = null;

    
            System.out.print("Please initialize your bank: ");
            String bankName = scnr.nextLine();
            currBank = new Bank(bankName);
            System.out.println("Bank '" + bankName + "' created.");

          System.out.print("Initialize your customer.");
          System.out.print("Please add first name: ");
            String customerFirstName = scnr.nextLine();
            System.out.print("Please add last name: ");
            String customerLastName = scnr.nextLine();
            currBank.addCustomer(customerFirstName, customerLastName);
            Customer currCustomer = currBank.getCustomer(0);
            System.out.println("Customer '" + customerFirstName + " " + customerLastName + "' created. Account has also been initialized for this customer.");
            currCustomer.setAccount(new Account());


        // main program loop
        while (programRunning) {

            if (role == 'A') {
                System.out.println("\n===== ADMIN MENU =====");
                System.out.println("0 - Change role to customer");
                System.out.println("1 - Add customer");
                System.out.println("2 - Display customers");
                System.out.println("3 - Search customers");
                System.out.println("4 - Delete customers");
                System.out.println("5 - Create account for customer");
                System.out.println("6 - Exit");
                System.out.print("Enter selection: ");

                String choice = scnr.nextLine().trim();

                switch (choice) {
                    case "0":
                        role = 'C';
                        System.out.println("Role changed to customer.");
                        break;

                    case "1":
                        System.out.print("Enter first name: ");
                        String firstNameToAddCustomer = scnr.nextLine();
                        System.out.print("Enter last name: ");
                        String lastNameToAddCustomer = scnr.nextLine();
                        currBank.addCustomer(firstNameToAddCustomer, lastNameToAddCustomer);
                        System.out.println("Customer added.");
                        break;

                      case "2":
                        System.out.println("=== Customers ===");
                        System.out.println(currBank.displayCustomers());
                        break;

                      case "3":
                        System.out.print("Enter first name: ");
                        String firstNameToFindCustomer = scnr.nextLine();
                        System.out.println(currBank.searchCustomer(firstNameToFindCustomer));
                        break;

                        case "4":
                        System.out.print("Enter customer's index: ");
                        int indexToDeleteCustomer = scnr.nextInt();
                        System.out.println(currBank.deleteCustomer(indexToDeleteCustomer));
                        break;

                         case "5":
                        System.out.print("Enter customer's index: ");
                        int indexToCreateCustomerAccount = scnr.nextInt();
                        System.out.println(currBank.createAccount(currBank.getCustomer(indexToCreateCustomerAccount)));
                        break;

                    case "6":
                        programRunning = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } else if (role == 'C') {

System.out.println("\n===== CUSTOMER MENU =====");
                System.out.println("0 - Change role to admin");
                System.out.println("1 - Balance inquiry");
                System.out.println("2 - Deposit");
                System.out.println("3 - Withdraw");
                System.out.println("4 - Transfer");
                System.out.println("5 - Exit");
                System.out.print("Enter selection: ");

                String choice = scnr.nextLine().trim();

                switch (choice) {
                    case "0":
                        role = 'A';
                        System.out.println("Role changed to admin.");
                        break;

                    case "1":
                        System.out.print("Current Balance: " + currCustomer.getAccount().getBalance());
                        break;

                    case "2":
                        System.out.print("Enter deposit amount: ");
                        double deposit = scnr.nextDouble();
                        currCustomer.getAccount().deposit(deposit);
                        break;

                    case "3":
                        System.out.print("Enter withdrawal amount: ");
                        double withdraw = scnr.nextDouble();
                        currCustomer.getAccount().withdraw(withdraw);
                        break;

                    case "4":
                        System.out.print("Enter index of customer to transfer: ");
                        int indexToTransfer = scnr.nextInt();
                        System.out.print("\nEnter amount to transfer: ");
                        double amountToTransfer = scnr.nextDouble();
                        currCustomer.getAccount().transfer(currBank.getCustomer(indexToTransfer).getAccount(), amountToTransfer);
                        break;

                    case "5":
                        programRunning = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            }
        }

        scnr.close();
    }
}