package contactdb.contact;

import contactdb.main.IDatabaseable;
import contactdb.main.IDatabaseableFactory;

public class ContactFactory implements IDatabaseableFactory{

	@Override
	public IDatabaseable getInstance() {
		return new Contact();
	}

	@Override
	public int getRecordLength() {
		return Contact.CONTACT_LEN;
	}

}
