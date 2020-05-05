import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class BoCApp {
	public static ArrayList<BoCTransaction> UserTransactions;
	public static ArrayList<BoCCategory> UserCategories;

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
				"\nWhat do you want to do?\n T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it");
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
				} else if (Integer.parseInt(s) != -1) {
					ListTransactionsForCategory((int) Integer.parseInt(s));
				} else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.toString() + "\n");
			}

			System.out.println(
					"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
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
	 Programmer: Hongming Ping
	 Fix:
	 1. The input number and serial number have been fixed to be equal.
	 2. When print on the console, the name of Category could also been shown
	 3. When input number out of the range of Category, there would be an error message.
	 */
	public static void ListTransactionsForCategory(int chosenCategory) {
		if (chosenCategory<=UserCategories.size()) { //Check for input that is out of the range of category
			chosenCategory--; //The no. of a category is smaller than it is printed out
			BoCCategory copy =UserCategories.get(chosenCategory);
			String name = copy.CategoryName(); // Get the Name of Category and print it together with transaction name
			for (int x = 0; x < UserTransactions.size(); x++) {
				BoCTransaction temp = UserTransactions.get(x);
				if (temp.transactionCategory() == chosenCategory) {
					System.out.print( name + ": " +(x + 1) + ") " + temp.toString());
					System.out.print('\n');
				}
			}
		}else{			
			System.out.print("The Category doesn't exit"); //if out of range, then print error message
			System.out.print('\n');
		}
	}

	private static void AddTransaction(Scanner in) throws Exception {
		System.out.println("What is the title of the transaction?\r\nNOTE: It should not be blank and less than 25 characters.");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();

		if (title.replaceAll(" ", "").equals("")) {
			throw new Exception("Wrong name. It should not be blank!");
		}
		else if (title.length() > 25){
			throw new Exception("Wrong name. It should not be more than 25 characters!");
		}

		System.out.println("What is the value of the transaction?\r\nNOTE: It should be greater than 0 with two decimal places e.g. 10.00.");
		String value = in.nextLine();
		if (value.replaceAll(" ", "").equals("")) {
			throw new Exception("Wrong value. It should not be blank!");
		} else if (value.matches("[0-9]+.[0-9]{2}") != true) {
			throw new Exception("Wrong value. It should be a positive number with two decimal places e.g. 10.00.");
		}
		BigDecimal tvalue = new BigDecimal(value);

		System.out.println("What is the category of the transaction?\r\nNote: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.");
		String cat = new String(in.nextLine());
		int range = UserCategories.size();
		if (cat.equals("")) {
			cat = cat.concat("1");
		} else if (cat.matches("[0-9]*") != true) {
			throw new Exception("Wrong category. It should be an integer between 1 - " + range);
		} else if (Integer.parseInt(cat) < 1){
			throw new Exception("Wrong category. It should be an integer between 1 - " + range);
		} else if (Integer.parseInt(cat) > UserCategories.size()) {
			throw new Exception("Wrong category. It should be an integer between 1 - " + range);
		}
		int tcat = Integer.parseInt(cat) - 1;

		UserTransactions.add(new BoCTransaction(title, tvalue, tcat));

		System.out.println(title + "(¥" + tvalue + ")" + " was added to " + UserCategories.get(tcat).CategoryName());
	}

	private static void ChangeTransactionCategory(Scanner in) {
		System.out.println("Which transaction ID?");
		in.nextLine();
		int tID = Integer.parseInt(in.nextLine());
		System.out.println("\t- " + UserTransactions.get(tID - 1).toString());
		System.out.println("Which category will it move to?");
		CategoryOverview();
		int newCat = Integer.parseInt(in.nextLine());
		BoCTransaction temp = UserTransactions.get(tID);
		temp.setTransactionCategory(newCat);
		UserTransactions.set(tID, temp);
		BoCCategory temp2 = UserCategories.get(newCat);
		temp2.addExpense(temp.transactionValue());
		UserCategories.set(newCat, temp2);
	}

	private static void AddCategory(Scanner in) {
		System.out.println("What is the title of the category?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();
		System.out.println("What is the budget for this category?");
		BigDecimal cbudget = new BigDecimal(in.nextLine());
		BoCCategory temp = new BoCCategory(title);
		temp.setCategoryBudget(cbudget);
		UserCategories.add(temp);
		System.out.println("[Category added]");
		CategoryOverview();
	}

}
