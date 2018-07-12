import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	public static void main (String[] args) {
		welkom();
		
		boolean found = true;	
		int[] arrData = new int[4];
		
		for (int x = 0; x < arrData.length; x++) {
			if (true) {
				Random rand = new Random ();
				int randomInt = rand.nextInt(6) + 1;
				arrData[x] = randomInt;
			}
		}
		
		//print de huidige reeks ter controle voor invoer
		for (int i = 0; i < arrData.length; i++) {										
			System.out.print(arrData[i]);
		}
		System.out.println("");	
		
		
		
		while (found == true) {		
			System.out.println("Voer 4 cijfers in:");
			Scanner sc = new Scanner(System.in);
			int[] inputArray = new int[4];
			for(int a = 0; a < 4; a++)	{
				inputArray[a] = sc.nextInt();
			}
			
			System.out.println("    " + inputArray[0] + "  |    " + inputArray[1] + "    |    "+ inputArray[2] + "    |    " + inputArray[3]);
			System.out.println("");
			
			//de vergelijking
			String[] output = new String[4];
			for (int i = 0; i < arrData.length; i++) {
				String p;
				if (arrData[i] == inputArray[i]) {
					p = "Zwart";
				} else {
					int toFind = inputArray[i];
					boolean foundInput = false;
					for (int n : arrData) {
						if (n == toFind) {
							foundInput = true;
							break;
						} else {
							foundInput = false;
							
						}
					}
					if(foundInput) {
						p = "Wit";
					}else 
					p = "Fout";
				}
			output[i] = p;
			}
			
			
			System.out.println(output[0] + "  |  " + output[1] + "  |  "+ output[2] + "  |  " + output[3]);
			
			
		//vergelijker
			String eindCheckerWit = "Wit";
			String eindCheckerFout = "Fout";
			for (int i = 0; i < output.length; i++) {
				for (String n : output) {
					if (n == eindCheckerWit || n == eindCheckerFout) {
						found = true;
						break;
					} else {
						found = false;
							
					}
				}
			}
			
		}
		System.out.println("");	
		System.out.println("Joepie! Je hebt gewonnen!");
	}
	
	static void welkom() {
		System.out.println(	"Welkom bij Mastermind!  \n" + 
				"De regels zijn simpel: \n" + 
				"Er zijn 6 cijfers en ik heb er 4 in gedachten. \n" +
				"Voer elk cijfer in. Druk tussen elk cijfer op enter. \n" +
				"Ik vertel je de of de cijfers in mijn reeks zitten door middel van de volgende uitkomsten: \n" +
				"Fout	Dit cijfer zit niet in mijn reeks. \n" +
				"Wit	Dit cijfer is aanwezig in mijn reeks, maar zit niet op de juiste plek. \n" +
				"Zwart	Dit cijfer klopt en zit op de juiste plek. \n" +
				"Succes!");
	}
}	
	