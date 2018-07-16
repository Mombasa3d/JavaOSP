package contactdb;

public class Contact {

	public static final int F_NAME_MAX = 255,
			L_NAME_MAX = 255,
			P_EMAIL_MAX = 255,
			S_EMAIL_MAX = 255,
			P_PHONE_MAX = 12,
			S_PHONE_MAX = 12;
	
	public static final int CONTACT_REC_LEN = (F_NAME_MAX + L_NAME_MAX + P_EMAIL_MAX + S_EMAIL_MAX + P_PHONE_MAX + S_PHONE_MAX);
	
	String firstName;
	String lastName;
	String primaryEmail;
	String secondaryEmail;
	String primaryPhone;
	String secondaryPhone;
	static long idNumGen;
	private long idNum;
	
	public Contact()
	{
		this.idNum = idNumGen + 1;
	}
	
	public Contact(String fName, String lName, String PEmail, String SEmail, String PPhone, String SPhone)
	{
		this.setFirstName(fName);
		this.setLastName(lName);
		this.setPrimaryEmail(SEmail);
		this.setSecondaryEmail(SEmail);
		this.setPrimaryPhone(PPhone);
		this.setSecondaryPhone(SPhone);
		this.idNum = idNumGen + 1;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName.length() > 255)
		{
			this.firstName = "INVALID";
		}
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName.length() > 255)
		{
			this.firstName = "INVALID";
		}
		this.lastName = lastName;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String pMail) {
		if(pMail.length() > 255)
		{
			this.primaryEmail = "INVALID";
		}
		this.primaryEmail = pMail;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		if(secondaryEmail.length() > 255)
		{
			this.secondaryEmail = "INVALID";
		}
		this.secondaryEmail = secondaryEmail;
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		if(primaryPhone.length() > 255)
		{
			this.primaryPhone = "INVALID";
		}
		this.primaryPhone = primaryPhone;
	}
	public String getSecondaryPhone() {
		return secondaryPhone;
	}
	public void setSecondaryPhone(String secondaryPhone) {
		if(secondaryPhone.length() > 255)
		{
			this.secondaryPhone = "INVALID";
		}
		this.secondaryPhone = secondaryPhone;
	}
	
	
	public long getIdNum() {
		return idNum;
	}

	@Override
	public String toString() {
		StringBuilder fn = new StringBuilder(this.getFirstName());
		fn.setLength(F_NAME_MAX);
		StringBuilder ln = new StringBuilder(this.getLastName());
		ln.setLength(L_NAME_MAX);
		StringBuilder pMail = new StringBuilder(this.getPrimaryEmail());
		pMail.setLength(P_EMAIL_MAX);
		StringBuilder sMail = new StringBuilder(this.getSecondaryEmail());
		sMail.setLength(S_EMAIL_MAX);
		StringBuilder pNum = new StringBuilder(this.getPrimaryPhone());
		pNum.setLength(P_PHONE_MAX);
		StringBuilder sNum = new StringBuilder(this.getSecondaryPhone());
		sNum.setLength(S_PHONE_MAX);
//		return "{" + this.firstName + " " + this.lastName + " " + this.primaryEmail + " " + this.secondaryEmail + "}";
		return fn.toString() + ln.toString() + pMail.toString() + sMail.toString() + pNum.toString() + sNum.toString();
	}
	
	
	public byte[] serialize()
	{
		String serialStr = String.format(
				"%" + F_NAME_MAX + "d%" + L_NAME_MAX + "s%" + P_EMAIL_MAX + "s%" + S_EMAIL_MAX + "d%" + P_PHONE_MAX + "d%" + S_PHONE_MAX + "f",
				this.getFirstName(), this.getLastName(), this.getPrimaryEmail(), this.getSecondaryEmail(), this.getPrimaryPhone(), this.getSecondaryPhone());
		return serialStr.getBytes();
	}
	
}
