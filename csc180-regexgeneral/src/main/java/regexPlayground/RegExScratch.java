package regexPlayground;

public class RegExScratch {

	//MNZ-RS-TUVZ
	// where M >= 2
	// and T>=1
	
	private static boolean isValidSocial(String ssn)
	{
		String regex = "[2-9][0-9]{2}-[0-9]{2}-[1-9][0-9]{3}";
		return ssn.matches(regex);
	}
	public static void main(String[] args)
	{
		System.out.println(isValidSocial("211-11-0111"));
	}
}
