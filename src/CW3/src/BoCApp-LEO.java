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
	
	4 - Pass - Leo - 12：42/6/5  
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