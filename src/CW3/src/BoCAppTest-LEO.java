    /* 
	1 - Pass - Leo - 00:18/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest1,2,3,4
	
	2 - Pass - Leo - 00:48/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest5，6
	*/
	@DisplayName("ChangeTransactionCategoryTest")
	@ParameterizedTest
	@MethodSource
	void ChangeTransactionCategoryTest(String tID, String newCat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Method ChangeTransactionCategoryTest = a.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
	    ChangeTransactionCategoryTest.setAccessible(true);
	    
	    try {
		    if(alert.equals("1")) {
			    String input = "\n" + tID + "\n" + newCat + "\n";
			    inp = new Scanner(input);
			    catList = "1) " + BoCApp.UserCategories.get(0).toString() + "\r\n";
		    	for (int x = 1; x < BoCApp.UserCategories.size(); x++) {
					BoCCategory temp = BoCApp.UserCategories.get(x);
					catList += (x+1) + ") " + temp.toString() + "\r\n";
				}
		    	int tIDi = Integer.parseInt( tID )-1;
		    	int newCati = Integer.parseInt( newCat )-1;
			    
		    	BoCTransaction temp = BoCApp.UserTransactions.get(tIDi);
				int oldCat = temp.transactionCategory();
		    	
	        	ChangeTransactionCategoryTest.invoke(a, inp);
	        	BoCCategory newCatSpend = BoCApp.UserCategories.get(newCati);
	        	BoCCategory oldCatSpend = BoCApp.UserCategories.get(oldCat);
	            assertEquals(prompt7 + "\t- " + BoCApp.UserTransactions.get( tIDi ).toString() + "\r\n" + prompt8 + catList + prompt9 + "Target category: " + (newCati + 1) + ") " + newCatSpend.toString() + "\r\n" + "Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString() + "\r\n", outContent.toString());
	            assertEquals(newCati, temp.transactionCategory());
		    }
	    }
	    catch (Exception e) {
            assertEquals(alert, e.getCause().getMessage());
        }
        
	    outContent.reset(); 
	}
	static List<Arguments> ChangeTransactionCategoryTest() {
        return List.of( // arguments:
                Arguments.arguments("1", "3", "1"),
                Arguments.arguments("1", "1", "1"),
                Arguments.arguments("4", "2", "1"),
                Arguments.arguments("4", "3", "1"),
                Arguments.arguments("7", "1", "1"),
                Arguments.arguments("7", "4", "1")
        );
    }
	
	/* 
	1 - Pass - Leo - 11:38/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest7, 8, 9, 10
	*/
	@DisplayName("ChangeTransactionCategoryTest")
	@ParameterizedTest
	@MethodSource
	void ChangeTransactionCategoryTestD(String tID1, String tID2, String newCat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Method ChangeTransactionCategoryTest = a.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
	    ChangeTransactionCategoryTest.setAccessible(true);
	    
	    try {
		    if(alert.equals("1")) {
			    String input = "\n" + tID1 + "\n" + tID2 + "\n" + newCat + "\n";
			    inp = new Scanner(input);
			    catList = "1) " + BoCApp.UserCategories.get(0).toString() + "\r\n";
		    	for (int x = 1; x < BoCApp.UserCategories.size(); x++) {
					BoCCategory temp = BoCApp.UserCategories.get(x);
					catList += (x+1) + ") " + temp.toString() + "\r\n";
				}
		    	int tIDi = Integer.parseInt( tID2 )-1;
		    	int newCati = Integer.parseInt( newCat )-1;
			    
		    	BoCTransaction temp = BoCApp.UserTransactions.get(tIDi);
				int oldCat = temp.transactionCategory();
		    	
	        	ChangeTransactionCategoryTest.invoke(a, inp);
	        	BoCCategory newCatSpend = BoCApp.UserCategories.get(newCati);
	        	BoCCategory oldCatSpend = BoCApp.UserCategories.get(oldCat);
	            assertEquals(prompt7 + "Please input valid transaction value!\r\n" + "Which transaction ID?\r\n" + "\t- " + BoCApp.UserTransactions.get( tIDi ).toString() + "\r\n" + prompt8 + catList + prompt9 + "Target category: " + (newCati + 1) + ") " + newCatSpend.toString() + "\r\n" + "Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString() + "\r\n", outContent.toString());
	            assertEquals(newCati, temp.transactionCategory());
		    }
	    }
	    catch (Exception e) {
            assertEquals(alert, e.getCause().getMessage());
        }
        
	    outContent.reset(); 
	}
	static List<Arguments> ChangeTransactionCategoryTestD() {
        return List.of( // arguments:
                Arguments.arguments("100", "1", "3", "1"),
                Arguments.arguments(" ", "1", "1", "1"),
                Arguments.arguments("-5", "7", "2", "1"),
                Arguments.arguments("", "7", "4", "1")
        );
    }
	

	/* 
	1 - Pass - Leo - 12：42/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest11, 12, 13, 14
	*/
	@DisplayName("ChangeTransactionCategoryTest")
	@ParameterizedTest
	@MethodSource
	void ChangeTransactionCategoryTestC(String tID, String newCat1, String newCat2, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Method ChangeTransactionCategoryTest = a.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
	    ChangeTransactionCategoryTest.setAccessible(true);
	    
	    try {
		    if(alert.equals("1")) {
			    String input = "\n" + tID + "\n" + newCat1 + "\n" + newCat2 + "\n";
			    inp = new Scanner(input);
			    catList = "1) " + BoCApp.UserCategories.get(0).toString() + "\r\n";
		    	for (int x = 1; x < BoCApp.UserCategories.size(); x++) {
					BoCCategory temp = BoCApp.UserCategories.get(x);
					catList += (x+1) + ") " + temp.toString() + "\r\n";
				}
		    	int tIDi = Integer.parseInt( tID )-1;
		    	int newCati = Integer.parseInt( newCat2 )-1;
			    
		    	BoCTransaction temp = BoCApp.UserTransactions.get(tIDi);
				int oldCat = temp.transactionCategory();
		    	
	        	ChangeTransactionCategoryTest.invoke(a, inp);
	        	BoCCategory newCatSpend = BoCApp.UserCategories.get(newCati);
	        	BoCCategory oldCatSpend = BoCApp.UserCategories.get(oldCat);
	            assertEquals(prompt7 + "\t- " + BoCApp.UserTransactions.get( tIDi ).toString() + "\r\n" + prompt8 + catList + "Please input valid category!\r\n" + prompt8 + catList + prompt9 + "Target category: " + (newCati + 1) + ") " + newCatSpend.toString() + "\r\n" + "Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString() + "\r\n", outContent.toString());
	            assertEquals(newCati, temp.transactionCategory());
		    }
	    }
	    catch (Exception e) {
            assertEquals(alert, e.getCause().getMessage());
        }
        
	    outContent.reset(); 
	}
	static List<Arguments> ChangeTransactionCategoryTestC() {
        return List.of( // arguments:
                Arguments.arguments("1", "100", "3", "1"),
                Arguments.arguments("1", " ", "1", "1"),
                Arguments.arguments("7", "-5", "2", "1"),
                Arguments.arguments("7", "", "4", "1")
        );
    }