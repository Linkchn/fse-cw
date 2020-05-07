import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoCTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory;
	private Date transactionTime;

	/*
	1 - Pass - Haonan CHEN - 23:58/40/3
	Change:Initiate the transactionName to [Pending Transaction]
	Reason:keep same as requirement
	Tracabiliy:Default_Constructor_test1 
	*/
	public BoCTransaction() {
		transactionName ="[Pending Transaction]";
		transactionValue = null;
		transactionCategory = 0;
		transactionTime = null;
	}

	// PASS - Haonan - 23:58/40/3
	public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}

	// PASS - Haonan - 23:58/40/3
	public String transactionName() {
		return transactionName;
	}

	// PASS - Haonan - 23:58/40/3
	public BigDecimal transactionValue() {
		return transactionValue;
	}

	// PASS - Haonan - 23:58/40/3
	public int transactionCategory() {
		return transactionCategory;
	}

	// PASS - Haonan - 23:58/40/3
	public Date transactionTime() {
		return transactionTime;
	}
	
	/* 
	1 – Pass – Leo - 23:37/1/5  
	Change: considered situations that input is blank and only set name when no name exist before
	Reason: Class description asks to set name only once and considered anomorlies
	Traceability: setNameTest1,2,3,4,5,6
	*/
	public void setTransactionName(String tName) throws Exception {
		if (transactionName == null || transactionName == "[Pending Transaction]") {
			if (tName == null || tName.replaceAll(" ", "").equals("")) {
				throw new Exception("Set failed. Transaction name cannot be blank.");
			}else {
				transactionName = tName;
				if (transactionName.length()>25) {
					int start = 0;
					int finish = 25;
					transactionName = transactionName.substring(start, finish);
				}			
			}
		}
		else {
			throw new Exception("Set failed. This transaction name has already been set.");
		}
	}

	/* 
	1 – Pass – Leo - 00:55/2/5  
	Change: added a if statement that only allow positive numbers or it will throw an exception
	Reason: only positive numbers are allowed
	Traceability: setValueTest1,2,3,4,5,6
	*/
	public void setTransactionValue(BigDecimal tValue) throws Exception {
		if (transactionValue == null) {
			if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
				// 1 means bigger, -1 means smaller, 0 means same
				transactionValue = tValue;
			}
			if (tValue.scale()>2) {
				transactionValue = null;
			}
		}
		else {
			throw new Exception("Set failed. This transaction value has already been set.");

		}
	}

	/* 
	1 – Pass – Leo - 00:59/2/5  
	Change:
	Reason:
	Traceability: setCatTest1,2,3
	*/
	public void setTransactionCategory(int tCat) {
		if (tCat >= 0) {
			transactionCategory = tCat;
		}
	}


	/*
	1 - ERROR - Shiliang - 21:43 1/5
    Change: /
    Reason: isComplete is needed in class description
    Traceability: isCompleteTest 1

    2 - PASS - Shiliang - 22:37 1/5
    Change: Create a new method which check whether transaction name and value are complete
    Reason: /
	Traceability: isCompleteTest 2
	 */
	public boolean isComplete() {
		if (transactionName == null || transactionValue == null || transactionName.equals("[Pending Transaction]")) {
			return false;
		}
		else {
			return true;
		}
	}

	/* 
	1 – Pass – Leo - 22:37/1/5  
	Change:
	Reason:
	Traceability: toStringTest1,2,3
	*/
	@Override
	public String toString() {
		if ((transactionName != "[Pending Transaction]") && (transactionValue != null)) {
			transactionTime = new Date();
			long timeStamp = System.currentTimeMillis(); 
			SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String sd = sdff.format(new Date(timeStamp));
			return sd + " " + transactionName + " - ¥" + transactionValue.toString();
		}else {
			return null;
		}
	}
}
