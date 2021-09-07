
public class SkateLetters 
{
	int numLetter;
	String letters;
	public SkateLetters()
	{
		numLetter=0;
		letters="";
	}
	public void addLetter()
	{
		numLetter++;
	}
	public void subtractLetter()
	{
		numLetter--;
	}
	public String getLetters()
	{
		if(numLetter>5)
		{
			numLetter=5;
			return "SKATE";
		}
		else if(numLetter<0)
		{
			numLetter=0;
			return "";
		}
		switch(numLetter)
		{
		case 1:
			return "S";
			
		case 2:
			return "SK";
			
		case 3:
			return "SKA";
			
		case 4:
			return "SKAT";
			
		case 5:
			return "SKATE";
			
		}
		return "";
	}
}
