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
