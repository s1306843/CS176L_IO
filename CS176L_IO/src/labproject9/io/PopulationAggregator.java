package labproject9.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class PopulationAggregator 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		
		File input = new File("C:\\Users\\conno\\eclipse-workspace\\CS176L_IO\\populations.txt");
		
		PrintWriter output = new PrintWriter("C:\\Users\\conno\\eclipse-workspace\\CS176L_IO\\output.txt");
		
		Scanner scan = new Scanner(input);
		scan.useLocale(Locale.US);
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int total = 0;
		
		double count = 0.0;
		double avg = 0.0;
		String least = "";
		String most = "";
	
		while (scan.hasNextLine()) 
		{
			String text = scan.nextLine();
	
			int i = 0;
			while(!Character.isDigit(text.charAt(i))) {
				i++;
			}
			String cityName = text.substring(0,i);
			String pop = text.substring(i);
			
			int population = Integer.parseInt(pop);
			cityName.trim();
			
			if (population < min) 
			{
				min = population;
				least = cityName;
			}
			
			if (population > max) 
			{
				max = population;
				most = cityName;
			}
			
			total += population;
			
			count ++;
		}
		most.trim();
		least.trim();
		
		output.println("Most Populated: " + most + ": " + max);
		output.println("Least Populated: " + least + ": " + min);
		output.printf("Total Population: %d \n", total);
		output.printf("Average Population: %.2f \n", total/count);
		
		output.close();
	
	}
}




