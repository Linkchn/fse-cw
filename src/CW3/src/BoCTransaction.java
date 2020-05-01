package src;

import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;

public class BoCTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory, counter = 0;
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

	public void resetCounter() {
		counter = 0;
	}
	
	public void setTransactionName(String tName) {
		if (counter == 0) {
			if (tName == null && counter == 0) {
				transactionName = null;
			}else {
				transactionName = tName;
				counter += 1;
				if (transactionName.length()>25) {
					int start = 0;
					int finish = 25;
					transactionName = transactionName.substring(start, finish);
				}			
			}
		}
	}

	public void setTransactionValue(BigDecimal tValue) {
		if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
			// 1 means bigger, -1 means smaller, 0 means same
			transactionValue = tValue;
		}
		if (tValue.scale()>2) {
			transactionValue = null;
		}
	}

	public void setTransactionCategory(int tCat) {
		if (tCat > 0) {
			transactionCategory = tCat;
		}
	}

	@Override
	public String toString() {
		if (transactionName != null && transactionValue != null) {
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
			transactionTime = new Date();
			return sdf.format(transactionTime) + " " + transactionName + " - ¥" + transactionValue.toString();
		}else {
			return null;
		}
	}

}
