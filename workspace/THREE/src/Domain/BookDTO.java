package Domain;

public class BookDTO {
	private String BOOK_CODE;
	private String CLASSIFICATION_ID;
	private String BOOK_AUTHOR;
	private String BOOK_NAME;	
	private String PUBLISHER;
	private String ISRESERVE;
	
	public BookDTO() {}

	public BookDTO(String bOOK_CODE, String cLASSIFICATION_ID, String bOOK_AUTHOR, String bOOK_NAME, String pUBLISHER,
			String iSRESERVE) {
		super();
		BOOK_CODE = bOOK_CODE;
		CLASSIFICATION_ID = cLASSIFICATION_ID;
		BOOK_AUTHOR = bOOK_AUTHOR;
		BOOK_NAME = bOOK_NAME;
		PUBLISHER = pUBLISHER;
		ISRESERVE = iSRESERVE;
	}

	public String getBOOK_CODE() {
		return BOOK_CODE;
	}

	public void setBOOK_CODE(String bOOK_CODE) {
		BOOK_CODE = bOOK_CODE;
	}

	public String getCLASSIFICATION_ID() {
		return CLASSIFICATION_ID;
	}

	public void setCLASSIFICATION_ID(String cLASSIFICATION_ID) {
		CLASSIFICATION_ID = cLASSIFICATION_ID;
	}

	public String getBOOK_AUTHOR() {
		return BOOK_AUTHOR;
	}

	public void setBOOK_AUTHOR(String bOOK_AUTHOR) {
		BOOK_AUTHOR = bOOK_AUTHOR;
	}

	public String getBOOK_NAME() {
		return BOOK_NAME;
	}

	public void setBOOK_NAME(String bOOK_NAME) {
		BOOK_NAME = bOOK_NAME;
	}

	public String getPUBLISHER() {
		return PUBLISHER;
	}

	public void setPUBLISHER(String pUBLISHER) {
		PUBLISHER = pUBLISHER;
	}

	public String getISRESERVE() {
		return ISRESERVE;
	}

	public void setISRESERVE(String iSRESERVE) {
		ISRESERVE = iSRESERVE;
	}

	@Override
	public String toString() {
		return "BookDTO [BOOK_CODE=" + BOOK_CODE + ", CLASSIFICATION_ID=" + CLASSIFICATION_ID + ", BOOK_AUTHOR="
				+ BOOK_AUTHOR + ", BOOK_NAME=" + BOOK_NAME + ", PUBLISHER=" + PUBLISHER + ", ISRESERVE=" + ISRESERVE
				+ "]";
	}

	
}
