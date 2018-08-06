package contactdb.main;

import java.io.IOException;

import contactdb.contact.Contact;
import contactdb.contact.ContactFactory;
import contactdb.merchandise.Merchandise;
import contactdb.merchandise.MerchandiseFactory;

public class DBTest {

	public static void main(String[] args) throws IOException {
		try (JustDB<Contact> db = new JustDB<>("C:\\Users\\Mooba\\Desktop\\testDB.db", new ContactFactory()) ) {
			db.add(new Contact("Joe", "Nobody", "joe@teamnowhere.com", "wowow", "7272567890", "9022223333"));
		}
		
		try (JustDB<Merchandise> dbMerch = new JustDB<Merchandise>("C:\\Users\\Mooba\\Desktop\\testDB2.db", new MerchandiseFactory() )){
			dbMerch.add(new Merchandise("Soap", "A bar of citrus scented soap", 3.99f));
		}
		
	}

}
