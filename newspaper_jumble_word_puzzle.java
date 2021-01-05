

import java.util.ArrayList;


public class main {
	
	public static int mycounter=0;

	public static void main(String[] args) {
		
		//(1) start with scrambled word
		//(2) if 6 letters, then pick char to be first, for each first letter 5! words == 120 possibilities
		//(3) for loop -- get first letter, smash other letters into string
		//(4) recursive, pick 2nd letter, smash other letters into string
		//(5) 
		
		
		//String scrambled_str = "MGADEA";
		String scrambled_str = "SNTIGR";
		
		
		String save_letters = "";
		for (int ii=0; ii < scrambled_str.length(); ii++)
		{
			save_letters = "";
			
			String temp_letter = scrambled_str.substring(ii, ii+1);
			save_letters += temp_letter;
			
			String smash_str;
			if (ii==0)
				smash_str = scrambled_str.substring(ii+1);
			else if (ii==(scrambled_str.length() - 1))
				smash_str = scrambled_str.substring(0, ii);
			else
			{
				smash_str  = scrambled_str.substring(0, ii);
				smash_str += scrambled_str.substring(ii+1);
			}
			
			System.out.println(temp_letter + " " + smash_str);
			
			Recursive_Add_Letter(ii+1, smash_str, save_letters);
		}
		System.out.println("MAIN DONE");
	}//main
	
	public static void Recursive_Add_Letter(int index, String smash_str, String save_letters)
	{
		if (smash_str.length() == 1)
		{
			System.out.println(mycounter + ": " + save_letters + smash_str);
			mycounter++;
		}
		else
		{
			for (int xx=0; xx < smash_str.length(); xx++)
			{
				String next_save = save_letters;
				
				String temp_letter = smash_str.substring(xx, xx+1);
				next_save += temp_letter;
				
				String next_smash;
				if (xx==0)
					next_smash = smash_str.substring(xx+1);
				else if (xx==(smash_str.length() - 1))
					next_smash = smash_str.substring(0, xx);
				else
				{
					next_smash  = smash_str.substring(0, xx);
					next_smash += smash_str.substring(xx+1);
				}
				
				Recursive_Add_Letter(xx+1, next_smash, next_save);
			}
		}
	}//Recursive_Add_Letter

}//class
