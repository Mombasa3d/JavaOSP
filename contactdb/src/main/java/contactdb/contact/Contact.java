package contactdb.contact;

import contactdb.main.IDatabaseable;
import javafx.fxml.FXML;

public class Contact implements IDatabaseable {
	
	public static final int ID_LEN = 20, FNAME_LEN = 255, LNAME_LEN = 255, PMAIL_LEN = 255, SMAIL_LEN = 255,
			PPHONE_LEN = 12, SPHONE_LEN = 12;

	public static final int CONTACT_LEN = (ID_LEN + FNAME_LEN + LNAME_LEN + PMAIL_LEN + SMAIL_LEN + PPHONE_LEN + SPHONE_LEN);

	@FXML
	private static long idIndex = 1;
	@FXML
	private long id;
	@FXML
	private String fName;
	@FXML
	private String lName;
	@FXML
	private String pEmail;
	@FXML
	private String sEmail;
	@FXML
	private String pPhone;
	@FXML
	private String sPhone;

	
	
	public Contact() {
	}

	public Contact(String fName, String lName, String pMail, String sMail, String pPhone, String sPhone) {
		this.setId(idIndex);
		Contact.idIndex++;
		this.setfName(fName);
		this.setlName(lName);
		this.setpEmail(pMail);
		this.setsEmail(sMail);
		this.setpPhone(pPhone);
		this.setsPhone(sPhone);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getpEmail() {
		return pEmail;
	}

	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getpPhone() {
		return pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	@Override
	public boolean equals(Object obj) {
		Contact toCompare = (Contact) obj;
		return this.id == toCompare.id;
	}

	@Override
	public String toString() {
		return "{ " + this.getId() + " " + this.getfName() + " " + this.getlName()  + " " + this.getpEmail() + " " + this.getsEmail() + " " + this.getpPhone() + " " + this.getsPhone() + " " + "}";
	}

	public byte[] serialize() {
		String serializedString = String.format(
				"%" + ID_LEN + "d%" + FNAME_LEN + "s%" + LNAME_LEN + "s%" + PMAIL_LEN + "s%" + SMAIL_LEN + "s%"
						+ PPHONE_LEN + "s%" + SPHONE_LEN + "s",
				this.getId(), this.getfName(), this.getlName(), this.getpEmail(), this.getsEmail(), this.getpPhone(),
				this.getsPhone());
		return serializedString.getBytes();
	}

	public void deserialize(byte[] bytes) {
		String data = new String(bytes);
		int index = 0;
		String id = data.substring(index, ID_LEN).trim();
		index += ID_LEN;
		String fName = data.substring(index, index + FNAME_LEN).trim();
		index += FNAME_LEN;
		String lName = data.substring(index, index + LNAME_LEN).trim();
		index += LNAME_LEN;
		String pEmail = data.substring(index, index + PMAIL_LEN).trim();
		index += PMAIL_LEN;
		String sEmail = data.substring(index, index + SMAIL_LEN).trim();
		index += SMAIL_LEN;
		String pPhone = data.substring(index, index + PPHONE_LEN).trim();
		index += PPHONE_LEN;
		String sPhone = data.substring(index, index + SPHONE_LEN).trim();
		this.setId(Long.parseLong(id));
		this.setfName(fName);
		this.setlName(lName);
		this.setpEmail(pEmail);
		this.setsEmail(sEmail);
		this.setpPhone(pPhone);
		this.setsPhone(sPhone);
	}
}
