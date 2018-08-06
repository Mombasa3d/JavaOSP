import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Random;

import org.junit.Test;

import contactdb.main.Contact;
import contactdb.main.JustDB;

public class DBUnitTests {

	private Random rando = new Random();
	
	@Test
	public void testThreeThousand() throws IOException {
		JustDB test1DB = new JustDB("C:\\Users\\Mooba\\Desktop\\UTest1.db");
		for(int i = 0; i < 3001; i++)
		{
			test1DB.add(randomContact());
		}
		assert(test1DB.findEntry(3000) != null);
	}
	
	public void testPrintContacts() throws IOException {
		JustDB test2DB = new JustDB("C:\\Users\\Mooba\\Desktop\\UTest2.db");
		
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
