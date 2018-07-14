import java.util.Scanner;

import voorbeeldQien.Zee;

import java.util.Random;

// eerst een uml van alle classes fields en constructors
public class Zeeslag {
	public static void main (String[] args) {
		Zee zee1 = new Zee();
		Speler p1 = new Speler();
		Schip v1 = new Verkenner();
		
		v1.plaatsenHorizontaal(zee1);
		for (int i = 0; i <Zee.zee.length; i++) {
			for (int j = 0; j <Zee.zee.length; j++) {
			System.out.print(Zee.zee[i][j] + " ");
			}
			System.out.println("");
		}
		
		while (v1.zinken() == false) {
			p1.bombarderen();
			v1.zinken();
			if (v1.zinken() == true) {
				
			}
		System.out.println("");
		}
		System.out.println("Het schip is gezonken! :(");
	}
}
	




abstract class Schip {
	int lengte;
	int RI;
	abstract void plaatsenHorizontaal(Zee ZE);
	abstract boolean zinken();
}

class Verkenner extends Schip{
	int lengte = 2;
	public void plaatsenHorizontaal(Zee ZE) {
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
			} else if (ZE.zee [RIy][RIx] == 1) {
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
		plaatsenHorizontaal(ZE);
		
	}
	
	
	public boolean zinken() {
		boolean gzk = false;
		for (int i = 0; i < Zee.zee.length; i++) {
			int counter = 0;
			for (int j = 0; j < Zee.zee.length; j++) {
				if (Zee.zee[i][j] == 3){
					counter = counter + 1;
				}
				if (counter == lengte) {
					gzk = true;
				}
			}
		}
		return gzk;
	}
}

class Onderzeeer extends Schip {
	int length= 3;
	public void plaatsenHorizontaal(Zee ZE) {
		public void plaatsenHorizontaal(Zee ZE) {
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
				} else if (ZE.zee [RIy][RIx] == 1) {
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
			plaatsenHorizontaal(ZE);
			
		}
		
	public boolean zinken() {
		boolean gzk = false;
		for (int i = 0; i < Zee.zee.length; i++) {
			int counter = 0;
			for (int j = 0; j <Zee.zee.length; j++) {
				if (Zee.zee[i][j] == 3){
					counter = counter + 1;
				}
				if (counter == lengte) {
					gzk = true;
				}
			}
		}
		return gzk;
	}
	
}

class Slagschip extends Schip {
	int length= 4;
	public void plaatsenHorizontaal(Zee ZE) {
		Random randx = new Random ();
		int randomIntx = randx.nextInt(Zee.zee.length);
		int RIx = randomIntx;
		Random randy = new Random ();
		int randomInty = randy.nextInt(Zee.zee.length);
		int RIy = randomInty;
		
		ZE.zee[RIy][RIx] = 1;
		ZE.zee[RIy][RIx+1] = 1;
		ZE.zee[RIy][RIx+1] = 1;
		ZE.zee[RIy][RIx+1] = 1;
	}
	
	public boolean zinken() {
		boolean gzk = false;
		for (int i = 0; i < Zee.zee.length; i++) {
			int counter = 0;
			for (int j = 0; j < Zee.zee.length; j++) {
				if (Zee.zee[i][j] == 3){
					counter = counter + 1;
				}
				if (counter == lengte) {
					gzk = true;
				}
			}
		}
		return gzk;
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
							{0,0,0,0,0,0,0,0}};
	
}		

class Speler {
	public void bombarderen () {
		System.out.println("Welke invoer voor de horizontale as?");
		Scanner sc = new Scanner(System.in);
		int antwoord1 = sc.nextInt();
		System.out.println("Welke invoer voor de verticale as?");
		Scanner sc2 = new Scanner(System.in);
		int antwoord2 = sc2.nextInt();
		
		if (Zee.zee[antwoord1][antwoord2] == 0) {
			System.out.println("Mis");
		} else {
			System.out.println("Raak");
			Zee.zee[antwoord1][antwoord2] = 3;	
			for (int i = 0; i < Zee.zee.length ; i++) {
				for (int j = 0; j < Zee.zee.length; j++) {
					System.out.print(Zee.zee[i][j] + " ");
				}
					System.out.println("");
			}
		}	
		
		/*for (int i = 0; i <4; i++) {
			for (int j = 0; j <3; j++) {
			System.out.print(Zee.zee[i][j] + " ");
			}
			System.out.println("");
		}*/
	}
}
		
	
	
