import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import contactdb.contact.Contact;
import contactdb.contact.ContactFactory;
import contactdb.main.JustDB;
import contactdb.merchandise.Merchandise;
import contactdb.merchandise.MerchandiseFactory;

public class DBUnitTests {

	private Random rando = new Random();
	private	 JustDB<Contact> test1GenericContact; 
	private JustDB<Merchandise> testGenericMerchandise;
	private Contact testContact;
	private Merchandise testMerch;
	
//	@Test
//	public void testThreeThousand() throws IOException {
//		JustDB test1DB = new JustDB("C:\\Users\\Mooba\\Desktop\\UTest1.db");
//		for(int i = 0; i < 3001; i++)
//		{
//			test1DB.add(randomContact());
//		}
//		assert(test1DB.findEntry(3000) != null);
//	}
//	
//	public void testPrintContacts() throws IOException {
//		JustDB test2DB = new JustDB("C:\\Users\\Mooba\\Desktop\\UTest2.db");
//		
//	}
	
	@Before
	public void init() throws IOException
	{
		test1GenericContact  = new JustDB<>("C:\\Users\\Mooba\\Desktop\\UTestGen1.db", new ContactFactory());
		testGenericMerchandise = new JustDB<>("C:\\Users\\Mooba\\Desktop\\UTestGen2.db", new MerchandiseFactory());
	}
	
	@Test
	public void testContactInsert() throws IOException
	{
//		@SuppressWarnings("resource")
		testContact = new Contact("Joe", "Nobody", "joe@teamnowhere.com", "wowow", "7272567890", "9022223333");
		test1GenericContact.add(testContact);
		System.out.println(test1GenericContact.findEntry(1).toString());
		System.out.println(testContact.toString());
		assert(test1GenericContact.findEntry(1).toString().equals(testContact.toString()));
		
	}
	
	@Test
	public void testContactLookup() throws IOException
	{
		System.out.println(test1GenericContact.findEntry(1));
		assert(!test1GenericContact.findEntry(1).toString().isEmpty());
	}
	
	@Test
	public void testContactRemove() throws IOException
	{
		test1GenericContact.remove(1);
		assert(test1GenericContact.findEntry(1) == null);
	}
	
	@Test
	public void testMerchInsert() throws IOException
	{
//		@SuppressWarnings("resource")
		testMerch = new Merchandise("Double Soap", "Double the soap for single the price", 3.55f);
		testGenericMerchandise.add(testMerch);
		System.out.println(testGenericMerchandise.findEntry(1).toString());
		System.out.println(testMerch.toString());
		assert(testGenericMerchandise.findEntry(1).toString().equals(testMerch.toString()));
		
	}
	
	@Test
	public void testMerchLookup() throws IOException
	{
		System.out.println(testGenericMerchandise.findEntry(1));
		assert(!testGenericMerchandise.findEntry(1).toString().isEmpty());
	}
	
	public void testMerchRemove() throws IOException
	{
		testGenericMerchandise.remove(1);
		assert(test1GenericContact.findEntry(1) == null);
	}
	
	private Contact randomContact()
	{
		return new Contact(randomStr(), randomStr(), randomStr(), randomStr(), randomNum(), randomNum());
	}
	
	private String randomStr()
	{
		String retString = "";
		for(int i = 0; i < 16; i++)
		{
			retString += (char)rando.nextInt((90-65) + 65);
		}
		
		return retString;
	}

	private String randomNum()
	{
		String retString = "";
		for(int i = 0; i < 13; i++)
		{
			retString += (char)rando.nextInt((57-48) + 48);
		}
		return retString;
	}
}
