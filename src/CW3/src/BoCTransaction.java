import java.math.BigDecimal;
import java.util.Date;

public class BoCTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory;
	private Date transactionTime;

	public BoCTransaction() {
		transactionName = null;
		transactionValue = null;
		transactionCategory = 0;
		transactionTime = null;
	}

	public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}

	public String transactionName() {
		return transactionName;
	}

	public BigDecimal transactionValue() {
		return transactionValue;
	}

	public int transactionCategory() {
		return transactionCategory;
	}

	public Date transactionTime() {
		return transactionTime;
	}

	public void setTransactionName(String tName) {
		if (tName != null) {
			transactionName = tName;
		}
	}

	public void setTransactionValue(BigDecimal tValue) {
		if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
			// 1 means bigger, -1 means smaller, 0 means same
			transactionValue = tValue;
		}
	}

	public void setTransactionCategory(int tCat) {
		if (tCat > 0) {
			transactionCategory = tCat;
		}
	}

	public void setTransactionTime(Date tTime) {
		if (tTime != null) {
			transactionTime = tTime;
		}
	}


	/*
	1 – ERROR – Shiliang – 21:43 1/5
    Change: /
    Reason: isComplete is needed in class description
	Traceability: isCompleteTest 1

	2 – PASS – Shiliang – 22:37 1/5
    Change: Create a new method which check whether transaction name and value are complete
    Reason: /
	Traceability: isCompleteTest 2

	 */
	public boolean isComplete() {
		if (transactionName == null || transactionValue == null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public String toString() {
		return transactionName + " - ¥" + transactionValue.toString();
	}

}
