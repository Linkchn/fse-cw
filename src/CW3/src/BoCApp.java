import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoCApp {
    public static ArrayList<BoCTransaction> UserTransactions;
    public static ArrayList<BoCCategory> UserCategories;
    /*
    Programmer: Haonan CHEN
    Fix:
    1.Add a static int to record the number of default categoryName.
    */
    public static int defaultCategoryNum = 0;
    public static void main(String[] args) {
        UserCategories = new ArrayList<BoCCategory>();
        UserTransactions = new ArrayList<BoCTransaction>();

        // SETUP EXAMPLE DATA //
        UserCategories.add(new BoCCategory("Unknown"));

        BoCCategory BillsCategory = new BoCCategory("Bills");
        BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
        UserCategories.add(BillsCategory);

        BoCCategory Groceries = new BoCCategory("Groceries");
        Groceries.setCategoryBudget(new BigDecimal("75.00"));
        UserCategories.add(Groceries);

        BoCCategory SocialSpending = new BoCCategory("Social");
        SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
        UserCategories.add(SocialSpending);

        UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
        UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
        UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
        UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
        UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
        UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
        UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));

        for (int x = 0; x < UserTransactions.size(); x++) {
            BoCTransaction temp = UserTransactions.get(x);
            int utCat = temp.transactionCategory();
            BoCCategory temp2 = UserCategories.get(utCat);
            temp2.addExpense(temp.transactionValue());
            UserCategories.set(utCat, temp2);
        }

        // MAIN FUNCTION LOOP

        CategoryOverview();
        System.out.println(
        		"\nWhat do you want to do?\nO = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.next();
            try {
                if (s.equals("T")) {
                    ListTransactions();
                } else if (s.equals("O")) {
                    CategoryOverview();
                } else if (s.equals("C")) {
                    ChangeTransactionCategory(in);
                } else if (s.equals("N")) {
                    AddCategory(in);
                } else if (s.equals("A")) {
                    AddTransaction(in);
                } else if (s.equals("X")) {
                    System.out.println("Goodbye!");
                    break;
                } else if ((s.matches("[0-9]+"))&&(Integer.parseInt(s) != -1)) {
                	/*
                    1. Failed - Hongming - 20:55 6/5
                    Reason: If there is an unknown input, the method Integer.parseInt(s) would lead to
                    	crash and the program throws an exception, but not output the "Command not recognised".
                    Change: Add a if statement to lead the program to output "Command not recognised", 
                    	if the input is noit completely constructed by numbers, the statement return false and 
                    	the program output "Command not recognised".
                    2. Passed - Hongming - 21:25 6/5
                    
                    Traceability:  BoCAppmainTest2
                    */
                    ListTransactionsForCategory((int) Integer.parseInt(s));
                } else {
                    System.out.println("Command not recognised");
                }
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.toString() + "\n");
            }

            System.out.println(
            		"\nWhat do you want to do?\nO = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it");        
            }
        in.close();
    }

    public static void ListTransactions() {
        for (int x = 0; x < UserTransactions.size(); x++) {
            BoCTransaction temp = UserTransactions.get(x);
            System.out.println((x + 1) + ") " + temp.toString());
        }
    }

    public static void CategoryOverview() {
        for (int x = 0; x < UserCategories.size(); x++) {
            BoCCategory temp = UserCategories.get(x);
            System.out.println((x + 1) + ") " + temp.toString());
        }

    }

    /*
    1. Failed Hongming Ping 22:14/4/5
    Reason: The output doesn't include the name of Category as required.
    If a number larger than bound is input, no tips is output. 
    2. Failed Hongming Ping 17:48/5/5
    Reason: The output doesn't include the name of Category as required.
    Change: The problem of out of bound has been solved.
    3. Passed Hongming Ping 20:45/5/5
    Fix:
    1. The input number and serial number have been fixed to be equal.
    2. When print on the console, the name of Category could also been shown
    3. When input number out of the range of Category, there would be an error message.
    Traceability: listTransactionsForCategoryTest
    */
    public static void ListTransactionsForCategory(int chosenCategory) {
    	 if ((chosenCategory<=UserCategories.size())&&(chosenCategory>0)) { //Check for input that is out of the range of category
            chosenCategory--; //The no. of a category is smaller than it is printed out
            BoCCategory copy =UserCategories.get(chosenCategory);
            String name = copy.CategoryName(); // Get the Name of Category and print it together with transaction name
            for (int x = 0; x < UserTransactions.size(); x++) {
                BoCTransaction temp = UserTransactions.get(x);
                if (temp.transactionCategory() == chosenCategory) {
                    System.out.println( name + ": " +(x + 1) + ") " + temp.toString());
                }
            }
        }else{            
            System.out.println("The Category doesn't exit"); //if out of range, then print error message
        }
    }


    /*
    1 - FAIL - Shiliang - 23:15 4/5
    Change: /
    Reason: 1. No category input is set up
            2. The original message does not match new expected one
            3. Confirmation message has not been created yet
            4. Exception catcher has not been created yet
            5. BigDecimal get a ""
            6. blank input has not been banned
    Traceability: addTransactionTest 1 - 14

    2 - PASS - Jiawei Shiliang- 16:15 5/5
    Change: 1. Add a module for category setup, updated the prompt message string, reconstructed confirmation message
            2. Add if statement for exception throw
            3. Adjust \n to proper places
            4. modified category setup and messages
            5. add if for "   " situation
    Reason: /
    Traceability: addTransactionTest 1' - 3', 5' - 14'

    3 - FAIL - Jiawei Shiliang- 16:15 5/5
    Change: /
    Reason: the third argument went wrong, haven't handled \n
    Traceability: addTransactionTest 4'

    4 - PASS - Shiliang- 16:31 5/5
    Change: add if for "" situation (blank input)
    Reason: /
	Traceability: addTransactionTest 4''
	 */
    private static void AddTransaction(Scanner in) {
        in.nextLine(); // to remove read-in bug
        String title;
        String value;
        String cat;
        int flag1 = 0;
        int tcat;
        BigDecimal tvalue;
        BoCTransaction temp = new BoCTransaction();
        while (flag1 == 0) {
            System.out.println("What is the title of the transaction?\r\nNOTE: It should not be blank and less than 25 characters.");
            title = in.nextLine();

            if (title.replaceAll(" ", "").equals("")) {
                System.out.println("Wrong name. It should not be blank!");
                continue;
            }
            else if (title.length() > 25){
                title = title.substring(0, 25);
            }
            try {
                temp.setTransactionName(title);
            } catch (Exception e) {
                System.out.println("Wrong name. It should not be blank!");
                continue;
            }
            
            flag1 = 1;

        }

        
		while (flag1 == 1) {
            System.out.println("What is the value of the transaction?\r\nNOTE: It should be greater than 0 with two decimal places e.g. 10.00.");
            value = in.nextLine();
            if (value.replaceAll(" ", "").equals("")) {
                System.out.println("Wrong value. It should not be blank!");
                continue;
            } else if (value.matches("^[0-9]+\\.[0-9]{2}$") != true) {
                System.out.println("Wrong value. It should be a positive number with two decimal places e.g. 10.00.");
                continue;
            }
            tvalue = new BigDecimal(value);
            try {
                temp.setTransactionValue(tvalue);
            } catch (Exception e) {
                System.out.println("Wrong value. It should be a positive number with two decimal places e.g. 10.00.");
                continue;
            }
            flag1 = 2;
        }

        
		while (flag1 == 2) {
            System.out.println("What is the category of the transaction?\r\nNote: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.");
            cat = in.nextLine();
            int range = UserCategories.size();
            if (cat.equals("")) {
                cat = cat.concat("1");
            } else if (cat.matches("[0-9]*") != true) {
                System.out.println("Wrong category. It should be an integer between 1 - " + range);
                continue;
            } else if (Integer.parseInt(cat) < 1){
                System.out.println("Wrong category. It should be an integer between 1 - " + range);
                continue;
            } else if (Integer.parseInt(cat) > UserCategories.size()) {
                System.out.println("Wrong category. It should be an integer between 1 - " + range);
                continue;
            }
            tcat = Integer.parseInt(cat) - 1;
            temp.setTransactionCategory(tcat);
            flag1 = 3;
        }

		UserTransactions.add(temp);

		System.out.println(temp.transactionName() + "(¥" + temp.transactionValue() + ")" + " was added to " + UserCategories.get(temp.transactionCategory()).CategoryName());
	}

    /* 
	1 - Pass - Leo - 00:18/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest1,2,3,4
	
	2 - Pass - Leo - 00:48/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest5, 6
	
	3 - Pass - Leo - 11:38/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest7 ,8 ,9 ,10
	
	4 - Pass - Leo - 12ï¼š42/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest11, 12, 13, 14
	*/
	private static void ChangeTransactionCategory(Scanner in) throws Exception {
		int flag = 0, tID = 0;
		in.nextLine();
		while(flag == 0) {
			System.out.println("Which transaction ID?");
			String input =in.nextLine();
			Pattern pattern = Pattern.compile("[0-9]*");
	           Matcher isNum = pattern.matcher(input);
	           if( !isNum.matches() || input.equals("")){
	        	   System.out.println("Please input valid transaction value!");
					flag = 0;
	           }
	           else {
					tID = Integer.parseInt(input)-1;
					if(tID>=0&&tID<=UserTransactions.size()) {
						flag = 1;
					}
					else {
						System.out.println("Please input valid transaction value!");
						flag = 0;
					}
	           }
		}
		System.out.println("\t- " + UserTransactions.get(tID).toString());
		flag = 0;
		while(flag == 0) {
			System.out.println("Which category will it move to?");
			CategoryOverview();
			String input =in.nextLine();
			Pattern pattern = Pattern.compile("[0-9]*");
	           Matcher isNum = pattern.matcher(input);
	           if( !isNum.matches()  || input.equals("")){
	        	   System.out.println("Please input valid category!");
					flag = 0;
	           }
	           else {
	        	    int newCat = Integer.parseInt(input)-1;
					if(newCat>=0&&newCat<=UserCategories.size()) {
						BoCTransaction temp = UserTransactions.get(tID);
						int oldCat = temp.transactionCategory();
						temp.setTransactionCategory(newCat);
						UserTransactions.set(tID, temp);
						if(oldCat != newCat) {
							BoCCategory temp2 = UserCategories.get(newCat);
							temp2.addExpense(temp.transactionValue());
							UserCategories.set(newCat, temp2);
							BoCCategory temp3 = UserCategories.get(oldCat);
							temp3.removeExpense(temp.transactionValue());
							UserCategories.set(oldCat, temp3);
						}
						System.out.println("Change complete!");
						BoCCategory newCatSpend = UserCategories.get(newCat);
						System.out.println("Target category: " + (newCat + 1) + ") " + newCatSpend.toString());
						BoCCategory oldCatSpend = UserCategories.get(oldCat);
						System.out.println("Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString());
						flag = 1;
					}
					else {
						System.out.println("Please input valid category!");
						flag = 0;
					}
	           }
		}
	}

	/*
    1 - FAIL - 14:06 5/6 - Jiawei
    Change: /
    Reason: 1. The original message does not match new expected one 
            2. Confirmation message has not been created yet
            3. Exception catcher has not been created yet
            4. blank input has not been banned
    Traceability: AddCategoryTest
    2 - PASS - 14:06 5/6 - Jiawei
	Change: modify the prompts, throw some new exceptions and alert
    Reason: 1. modify the prompt message
            2. throw some new exceptions the avoid illegal input
            3. modify the alert message
    3 - FAIL - 14:06 5/6 - Jiawei
    Change: /
    Reason: miss a test that the budget is 0
    TraceabilityL AddCategoryTest
    4 - PASS - 14:06 5/6 - Jiawei
    Change: it will alert and stop if the budget is not larger than 0
    Reason: /
    Traceability: AddCategoryTest

    
    
     */
	private static void AddCategory(Scanner in)throws Exception {
        System.out.println("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters.");
        in.nextLine(); // to remove read-in bug
        String title = in.nextLine();
        for (int x = 0; x < UserCategories.size(); x++) {
            BoCCategory temp1 = UserCategories.get(x);
            if (title.equals(temp1.CategoryName())) {
                throw new Exception("Wrong title! It should not be the same as the existed name.");
            }
        }
        if (title.replaceAll(" ", "").equals("")) {
            throw new Exception("Wrong title! It should not be blank.");
        }
        else if(title.length()>15) {
            title = title.substring(0, 15);
        }
        System.out.println("What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.");
        String budget = in.nextLine();
        if(budget.replaceAll(" ", "").equals("")) {
            throw new Exception("Wrong budget! It should not be blank.");
        }
        else if(budget.matches("[0-9]+.[0-9]{2}") != true ) {
            throw new Exception("Wrong budget! It should be a positive decimal number with exact two decimal places.");
        }
        
        BigDecimal cbudget = new BigDecimal(budget);
        if (cbudget.compareTo(BigDecimal.ZERO) != 1) {
            throw new Exception("Wrong budget! It should be a positive decimal number with exact two decimal places.");
        }
        BoCCategory temp = new BoCCategory(title);
        temp.setCategoryBudget(cbudget);
        UserCategories.add(temp);
        System.out.println("[Category added]");
        CategoryOverview();
    }

}
