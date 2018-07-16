package contactdb;

import java.io.IOException;
import java.io.RandomAccessFile;

import cox.ryan.studentdatabase.Student;

public class ContactDatabase {

	private RandomAccessFile file;
	private Contact flashContact;
	
	public Contact lookup(long id) throws IOException
	{
		file.seek(findOffset(id));
		byte[] bytes = new byte[Contact.CONTACT_REC_LEN];
		file.read(bytes, 0, bytes.length);
		Contact c = new Contact();
		c.deserialize(bytes);
		return c;
	}
	
	
	private long findOffset(long idNum) {
		return idNum * Contact.CONTACT_REC_LEN;
	}
	
	public void addContact(Contact c) throws IOException {
		byte[] bytes = c.serialize();
		file.seek(findOffset(c.getIdNum()));
		file.write(bytes, 0, bytes.length);
	}
	
}
