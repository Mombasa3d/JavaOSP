package csc180.passwordChecker;

public class ComplexityChecker {

	public boolean isPassGoodEnoughRegEx(String pass)
	{
		//RegEx char ?: 0 - defined limit
		//RegEx char +: minimum of 1
		//RegEx char *: 0 or more
		//RegEx {}: {[minimum]}
		String regex = "[a-zA-Z0-9!-/]{8,}";
		return pass.matches(regex);
		
	}
	
	public boolean isPasswordGoodEnough(String pass)
	{
		
		boolean containsNumber = false;
		for(int i=0; i <= 9; i++)
		{
			if(pass.contains(String.valueOf(i)))
			{
				containsNumber = true;
			}
		}
		if(!containsNumber)
		{
			return false;
		}
		
		boolean containsUpper = false, containsLower = false, containsSpecial = false, meetsLength = false;
		
		for(char c : pass.toCharArray())
		{
			int i = (int)c;
			if(i >= 65 && i <= 90) {
				containsUpper = true;
			}
			else if(i >= 97 && i <= 122)
			{
				containsLower = true;
			}
			else if(i >= 48 && i <= 57)
			{
				containsNumber = true;
			}
			else if(i >= 33 && i <= 47)
			{
				containsSpecial = true;
			}
		}
		return containsUpper && containsLower && containsSpecial && meetsLength;
	}

}
