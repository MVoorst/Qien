import java.util.Scanner;
import java.util.Random;

/** Een korte uitleg over mijn Zeeslag code. Ik heb hier drie classes, of ook wel drie type "schepen" en twee classes Zee (ookwel het bord)
 * en de speler.Deze kunnen random op het bord worden geplaatst door middel van hun "plaatsen" methode. Dit gaat vrijwel zonder problemen, 
 * ik heb het zo gemaakt dat als de schepen geen plek beschikbaar zien, ze opnieuw zichzelf gaan plaatsen. 
 * Alleen het "Slagschip" wil zichzelf nog wel eens opdelen naar een random stuk bord.
 * 
 * - Het bord voor de speler was eigenlijk al het aangepaste bord voor de computer, dus de schepen zijn al zichtbaar voor de speler. 
 * Niet de bedoeling. Ik had gehoopt dat er met de maak van een nieuw bord, een schoon bord voor de speler zou verschijnen.
 * Dit werkt blijkbaar niet op deze manier :/.
 * 
 * Het runnen duurde op een gegeven moment zo lang, dat ik het niet goed meer kon testen. Er kunnen meerdere schepen bij worden gemaakt en
 * worden beschoten, maar hoe goed dat zou werken weet ik niet.
 * 
 * De regels voor het bord van de computer:
 * 0 = vrij
 * 1 = bezet door een Verkenner
 * 2 = bezet door een Onderzeeer
 * 3 = bezet door een Slagschip
 * 7 = geraakt door de speler
 * 
 * De regels voor het bord van de speler
 * 5 = mis
 * 8 = geraakt

**/

public class Zeeslag {
	public static void main (String[] args) {
		Zee zee1 = new Zee();
		Zee spelerZee = new Zee();
		Speler p1 = new Speler();
		Schip v1 = new Verkenner();
			
		v1.plaatsen(zee1);
		
		for (int i = 0; i <Zee.zee.length; i++) {
			for (int j = 0; j <Zee.zee.length; j++) {
			System.out.print(Zee.zee[i][j] + " ");
			}
			System.out.println("");
		}
		
		while (v1.zinken(1, zee1) == true) {
			p1.bombarderen(spelerZee);
			v1.zinken(1, zee1);

			if (v1.zinken(1, zee1) == false) {
				System.out.println("Niet gevonden");
			}else {
				System.out.println("Gevonden");
			}
			
		System.out.println("");
		}
		System.out.println("Alle schepen zijn gezonken!");
	}
}
	
abstract class Schip {
	int lengte;
	int RI;
	abstract void plaatsen(Zee ZE);
	abstract boolean zinken(int val, Zee ZE);
}

class Verkenner extends Schip{
	int lengte = 2;
	public void plaatsen(Zee ZE) {
		try {
			//een random coordinaat genereren
			Random randx = new Random ();
			int randomIntx = randx.nextInt(Zee.zee.length);
			int RIx = randomIntx;
			Random randy = new Random ();
			int randomInty = randy.nextInt(Zee.zee.length);
			int RIy = randomInty;
			
			//check of de plaats al bezet is
			if (	ZE.zee [RIy][RIx] == 0 & 
					ZE.zee [RIy][RIx +1] == 0 & 
					ZE.zee [RIy + 1][RIx] == 0  ) {
				ZE.zee[RIy][RIx] = 1;
			} else if (ZE.zee [RIy][RIx] == 1 | ZE.zee [RIy][RIx] == 2 | ZE.zee [RIy][RIx] == 3) {
				randx = new Random ();
				randomIntx = randx.nextInt(Zee.zee.length);
				RIx = randomIntx;
				randy = new Random ();
				randomInty = randy.nextInt(Zee.zee.length);
				RIy = randomInty;
			}
			
			
			//een random int voor horizontaal of verticaal.
			Random randz = new Random ();
			int randomIntz = randz.nextInt(2); // voor 0 horizontaal, voor 1 verticaal
			int RIz = randomIntz;
			switch (RIz) {
				case 0 : 
					ZE.zee[RIy][RIx + 1] = 1;
					
					break;
				case 1 :
					ZE.zee[RIy + 1][RIx] = 1;
					
					break;
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			failsafe (ZE);
		}
	}
	
	private void failsafe (Zee ZE) {
		plaatsen(ZE);
		
	}
	
	
	public boolean zinken(int val, Zee ZE){
	    for(int i = 0; i < ZE.zee.length; i++){
	        for(int j = 0; j < ZE.zee.length; j++){
	            if(ZE.zee[i][j] == val) return true;
	        }
	    }
	    return false;
	}
}

class Onderzeeer extends Schip {
	int length= 3;
	public void plaatsen(Zee ZE) {
		try {
			//een random coordinaat genereren
			Random randx = new Random ();
			int randomIntx = randx.nextInt(Zee.zee.length);
			int RIx = randomIntx;
			Random randy = new Random ();
			int randomInty = randy.nextInt(Zee.zee.length);
			int RIy = randomInty;
			
			//check of de plaats al bezet is
			if (	ZE.zee [RIy][RIx] == 0 & 
					ZE.zee [RIy][RIx +1] == 0 & 
					ZE.zee [RIy][RIx +2] == 0 &
					ZE.zee [RIy + 1][RIx] == 0 &
					ZE.zee [RIy + 2][RIx] == 0 ) {
				ZE.zee[RIy][RIx] = 2;
			} else if (ZE.zee [RIy][RIx] == 1 | ZE.zee [RIy][RIx] == 2 | ZE.zee [RIy][RIx] == 3) {
				randx = new Random ();
				randomIntx = randx.nextInt(Zee.zee.length);
				RIx = randomIntx;
				randy = new Random ();
				randomInty = randy.nextInt(Zee.zee.length);
				RIy = randomInty;
			}
				
			//een random int voor horizontaal of verticaal.
			Random randz = new Random ();
			int randomIntz = randz.nextInt(2); // voor 0 horizontaal, voor 1 verticaal
			int RIz = randomIntz;
			switch (RIz) {
				case 0 : 
					ZE.zee[RIy][RIx + 1] = 2;
					ZE.zee[RIy][RIx + 2] = 2;
					break;
				case 1 :
					ZE.zee[RIy + 1][RIx] = 2;
					ZE.zee[RIy + 2][RIx] = 2;
					break;
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			failsafe (ZE);
		}
	}
	
	private void failsafe (Zee ZE) {
		plaatsen(ZE);
		
	}
	// op zoek naar de waarde van het schip, in dit geval 2. Niet aanwezig is gezonken		
	public boolean zinken(int val, Zee ZE){
	    for(int i = 0; i < ZE.zee.length; i++){
	        for(int j = 0; j < ZE.zee.length; j++){
	            if(ZE.zee[i][j] == val) return true;
	        }
	    }
	    return false;
	}
	
}

class Slagschip extends Schip {
	int length= 4;
	public void plaatsen(Zee ZE) {
		try {
			//een random coordinaat genereren
			Random randx = new Random ();
			int randomIntx = randx.nextInt(Zee.zee.length);
			int RIx = randomIntx;
			Random randy = new Random ();
			int randomInty = randy.nextInt(Zee.zee.length);
			int RIy = randomInty;
			
			//check of de plaats al bezet is
			if (		ZE.zee [RIy][RIx] == 0 & 
						ZE.zee [RIy][RIx +1] == 0 & 
						ZE.zee [RIy][RIx +2] == 0 &
						ZE.zee [RIy][RIx +3] == 0 &
						ZE.zee [RIy + 1][RIx] == 0 &
						ZE.zee [RIy + 2][RIx] == 0 &
						ZE.zee [RIy + 3][RIx] == 0 ) {
				ZE.zee[RIy][RIx] = 3;
			} else {
				randx = new Random ();
				randomIntx = randx.nextInt(Zee.zee.length);
				RIx = randomIntx;
				randy = new Random ();
				randomInty = randy.nextInt(Zee.zee.length);
				RIy = randomInty;
			}
			
			
			//een random int voor horizontaal of verticaal.
			Random randz = new Random ();
			int randomIntz = randz.nextInt(2); // voor 0 horizontaal, voor 1 verticaal
			int RIz = randomIntz;
			switch (RIz) {
				case 0 : 
					ZE.zee[RIy][RIx + 1] = 3;
					ZE.zee[RIy][RIx + 2] = 3;
					ZE.zee[RIy][RIx + 3] = 3;
					break;
				case 1 :
					ZE.zee[RIy + 1][RIx] = 3;
					ZE.zee[RIy + 2][RIx] = 3;
					ZE.zee[RIy + 3][RIx] = 3;
					break;
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			failsafe (ZE);
		}
	}
	
	private void failsafe (Zee ZE) {
		plaatsen(ZE);
		
	}
	// op zoek naar de waarde van het schip, in dit geval 3. Niet aanwezig is gezonken.	
	public boolean zinken(int val, Zee ZE){
	    for(int i = 0; i < ZE.zee.length; i++){
	        for(int j = 0; j < ZE.zee.length; j++){
	            if(ZE.zee[i][j] == val) return true;
	        }
	    }
	    return false;
	}
}


class Zee {
	static int [][]zee = { 	{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							};
	
}		

class Speler {
	
	public void bombarderen (Zee speler) {
		System.out.println("Welke invoer voor de verticale as?");
		Scanner sc = new Scanner(System.in);
		int antwoord1 = sc.nextInt();
		System.out.println("Welke invoer voor de horizontale as?");
		Scanner sc2 = new Scanner(System.in);
		int antwoord2 = sc2.nextInt();
		
		if (Zee.zee[antwoord1][antwoord2] == 0) {
			System.out.println("Mis");
			speler.zee[antwoord1][antwoord2] = 5;
		} else {
			System.out.println("Raak");
			Zee.zee[antwoord1][antwoord2] = 7;	
			speler.zee[antwoord1][antwoord2] = 8;
		}	
		for (int i = 0; i < speler.zee.length ; i++) {
			for (int j = 0; j < speler.zee.length; j++) {
				System.out.print(speler.zee[i][j] + " ");
			}
				System.out.println("");
		}
	}
}
		
	
	
