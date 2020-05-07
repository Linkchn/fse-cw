import java.math.BigDecimal;

public class BoCCategory {
    private String CategoryName;
    private BigDecimal CategoryBudget;
    private BigDecimal CategorySpend;

    /*
    1 - PASS - Haonan CHEN - 16:13 1/5
    Change: add the static int to record the number of default categoryName
    Reason: unique name of the categoryName
    Traceability: default constructor test
     */
    public BoCCategory() {
    	BoCApp.defaultCategoryNum++;
    	CategoryName = "New Category"+ BoCApp.defaultCategoryNum;
        CategoryBudget = new BigDecimal("0.00");
        CategorySpend = new BigDecimal("0.00");
    }

    // PASS
    public BoCCategory(String newTitle) {
        CategoryName = newTitle;
        CategoryBudget = new BigDecimal("0.00");
        CategorySpend = new BigDecimal("0.00");
    }

    // PASS
    public String CategoryName() {
        return CategoryName;
    }

    // PASS
    public BigDecimal CategoryBudget() {
        return CategoryBudget;
    }

    // PASS
    public BigDecimal CategorySpend() {
        return CategorySpend;
    }

    /*1. - Fail - Hongming PING - 21:38/2/5
	Problem: If newName is sapce only or empty, the result still returns the value of
	newName.
	Change: set throw when it is empty
	Traceability: setCNTest234
	2. - Fail - Hongming Ping - 22:57/2/5
	Problem: If the newName is set to be "Unknown", the result still returns "newName"
	while whose newName is empty or sapce or more than 15
	change: set throw when it is "Unknown"
	Traceability: setCNTest234
	3. - Pass - Hongming Ping - 23:27/2/5
	Problem:/
	Change:/
	Traceability: setCNTest234
	*/
    public void setCategoryName(String newName) throws Exception {
        newName = newName.trim();   
        if (newName.length() != 0 && newName.length() <= 15 && (!(newName.equals("Unknown")))) CategoryName = newName;
        else {
        	throw new Exception("Set Failed, please set a valid name"); 
        }
    }
    
    /* - Pass - Hongming PING - 16:52/1/5
	Change: /
    Reason: /
    Traceability: setCBTest1,2,3
	 */
    public void setCategoryBudget(BigDecimal newValue) {
        if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
            CategoryBudget = newValue;
        }
    }


    /*
    1 - FAIL - Shiliang - 16:13 1/5
    Change: /
    Reason: Decimals are different
    Traceability: getRemainingBudgetTest 1
    
    2 - PASS - Jiawei Shiliang- 22:35 1/5
    Change: /
    Reason: /
    Traceability: getRemainingBudgetTest 3, 4, 5, 6
     */
    public void addExpense(BigDecimal valueToAdd) {
        CategorySpend = CategorySpend.add(valueToAdd);
    }

    /*
    1 - PASS - Jiawei - 16:00 1/5
    Change: Add an parameter 'temp' to check whether the result is negative. Then
            the new code will throw new exception "Expense should not be negative" if 
            the result is negative.
    Reason: The source code does not handle this problem
    Traceability: removeExpenseTest 6
     */
    public void removeExpense(BigDecimal valueToRemove) throws Exception {
        BigDecimal temp = CategorySpend.subtract(valueToRemove);
        if (temp.compareTo(BigDecimal.ZERO) == -1) {
            throw new Exception("Expense should not be less than 0!");
        }
        else {
            CategorySpend = temp;
        }
    }

    /*
    1 - PASS - Jiawei - 16:37 1/5
    Change: /
    Reason: /
    Traceability: resetBudgetSpendTest 1
     */
    public void resetBudgetSpend() {
        CategorySpend = new BigDecimal("0.00");
    }

    /*
    1 - PASS - Jiawei Shiliang- 16:13 1/5
    Change: /
    Reason: /
    Traceability: getRemainingBudgetTest 1
     */
    public BigDecimal getRemainingBudget() {
        BigDecimal remainingBudget = CategoryBudget.subtract(CategorySpend);
        return remainingBudget;
    }


    /*
    1 - PASS - Jiawei - 15:57 2/5
    Change: the code will return a new result if the remaining is negative, which becomes overspend
    Reason: the previous code only explain the result that the remaining is positive, Therefore, it neeeds
            to explain the situation that the remaining is negative with a if condition
    Traceability: testToString1, testToString2
     */
    @Override
    public String toString() {
        // for the situation that has remaining
        if(CategoryBudget.compareTo(CategorySpend) != -1) {
            return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
                    + " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
        } else {   // for the situation that overspent
            BigDecimal OverSpent = new BigDecimal("0.00");
            OverSpent = getRemainingBudget();
            OverSpent = OverSpent.abs();
            return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
            + " (¥" + OverSpent.toPlainString() + " Overspent)";
        }
    }

}
