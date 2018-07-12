import java.util.Scanner;

import voorbeeldQien.Zee;

import java.util.Random;

// eerst een uml van alle classes fields en constructors
public class Zeeslag {
	public static void main (String[] args) {
		Zee zee1 = new Zee();
		Speler p1 = new Speler();
		Schip verkenner = new Schip();
		//p1.bombarderen();
		
		verkenner.plaatsenHorizontaal(zee1);
		for (int i = 0; i <4; i++) {
			for (int j = 0; j <3; j++) {
			System.out.print(Zee.zee[i][j] + " ");
			}
			System.out.println("");
		}
		boolean geraakt = false;
		while (geraakt == false) {
			p1.bombarderen();
			for (int[] i : Zee.zee) {
				System.out.print("[");
				for (int j: i) {
					System.out.print(j);
					/*if (i[j] == 0 || i[j] == 1) {
						geraakt = false;
					}else {
						geraakt = true;
					}*/
				}
				System.out.print("]");
			}
			
			
			
			/*for (int j = 0; j < Zee.zee.length; j++) {										
				System.out.print(Zee.zee[j]);
			for (int i = 0; i <Zee.zee.length; i++) {
				for (int n : Zee.zee) {
					if (n == 0 || n == 1) {
						geraakt = false;
					}else {
						geraakt = true;
					}
					}
				}
			}*/
		System.out.println("");
		}
		System.out.println("Het schip is gezonken! :(");
	}
}
		
class Schip {
	int lengte = 4;
	int RI;
	public void plaatsenHorizontaal(Zee ZE) {
		Random randx = new Random ();
		int randomIntx = randx.nextInt(Zee.zee.length);
		int RIx = randomIntx;
		Random randy = new Random ();
		int randomInty = randy.nextInt(Zee.zee.length);
		int RIy = randomInty;
		
		ZE.zee[RIx][RIy] = 1;
	}
	
	public void zinken() {
		for (int j = 0; j < Zee.zee.length; j++) {										
			System.out.print(Zee.zee[j]);
			
		}
	}
}


class Zee {
	static int [][]zee = { 	{0,0,0},
							{0,0,0},
							{0,0,0},
							{0,0,0}};
	
	
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
			for (int i = 0; i <4; i++) {
				for (int j = 0; j <3; j++) {
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
		
	
	
