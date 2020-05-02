import java.math.BigDecimal;

public class BoCCategory {
	private String CategoryName;
	private BigDecimal CategoryBudget;
	private BigDecimal CategorySpend;

	public BoCCategory() {
		CategoryName = "New Category";
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	public BoCCategory(String newTitle) {
		CategoryName = newTitle;
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	public String CategoryName() {
		return CategoryName;
	}

	public BigDecimal CategoryBudget() {
		return CategoryBudget;
	}

	public BigDecimal CategorySpend() {
		return CategorySpend;
	}

	public void setCategoryName(String newName) {
		CategoryName = newName;
	}

	public void setCategoryBudget(BigDecimal newValue) {
		// 1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
			CategoryBudget = newValue;
		}
	}



	/*
	1 – FAIL – Shiliang – 16:13 1/5
    Change: /
    Reason: Decimals are different
	Traceability: getRemainingBudgetTest 1
	
	2 – PASS – Jiawei – 22:35 1/5
    Change: /
    Reason: /
	Traceability: getRemainingBudgetTest 3, 4, 5, 6

	 */
	public void addExpense(BigDecimal valueToAdd) {
		CategorySpend = CategorySpend.add(valueToAdd);
	}

	/*
	1 – PASS – Jiawei – 16:00 1/5
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

	public void resetBudgetSpend() {
		CategorySpend = new BigDecimal("0.00");
	}

	/*
	1 – PASS – Jiawei – 16:13 1/5
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
			
		if(CategoryBudget.compareTo(CategorySpend) != -1)
			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
				+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
		else
		{
			BigDecimal OverSpent = new BigDecimal("0.00");
			OverSpent = getRemainingBudget();
			OverSpent = OverSpent.abs();
			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
			+ " (¥" + OverSpent.toPlainString() + " Overspent)";
		}
		
	}

}
