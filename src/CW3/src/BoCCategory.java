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




	public void addExpense(BigDecimal valueToAdd) {
		CategorySpend = CategorySpend.add(valueToAdd);
	}

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

	public BigDecimal getRemainingBudget() {
		BigDecimal remainingBudget = CategoryBudget.subtract(CategorySpend);
		return remainingBudget;
	}

	@Override
	public String toString() {
		return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
				+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
	}

}
