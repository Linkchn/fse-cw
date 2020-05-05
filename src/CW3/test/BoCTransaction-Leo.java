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
	/*
	 * method that count the times the content has been successfully filled
	 * can be used to achieve that name and value can be only set once 
	 */
		counter = 0;
	}
	
	public void setTransactionName(String tName) {
		if (counter == 0) {
			if (tName == null) {
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
		if (counter == 0) {
			if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
				// 1 means bigger, -1 means smaller, 0 means same
				transactionValue = tValue;
				counter += 1;
			}
			if (tValue.scale()>2) {
				transactionValue = null;
			}
		}
	}

	public void setTransactionCategory(int tCat) {
		if (counter == 0) {
			if (tCat >= 0) {
				transactionCategory = tCat;
			}
		}
	}

	@Override
	public String toString() {
		if ((transactionName != null) && (transactionValue != null)) {
			transactionTime = new Date();
			long timeStamp = System.currentTimeMillis(); 
			SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sd = sdff.format(new Date(timeStamp));
			return sd + " " + transactionName + " - ¥" + transactionValue.toString();
		}else {
			return null;
		}
	}

}
