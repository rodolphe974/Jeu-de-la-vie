import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	private Panneau pan = new Panneau();
	private String Text = "";
	
	
	//initialiser les valeurs du jeu
	private int size =200; //taille du monde
	//int cell = 3; //nbr de cell de départ   
	private char tab[][] = new char[this.size][this.size];	//tableau du monde
	private char newtab[][] = new char[this.size][this.size]; //tableau du nouveau monde
	
	public Fenetre(){        
		this.setTitle("It's alive !!!");
		this.setSize(1000, 1000);
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		
		//positions de départ
//		this.tab[2][1] = 'X';
//		this.tab[2][2] = 'X';
//		this.tab[2][3] = 'X';
		
		Random rnd = new Random();
		for (int i = 0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				if (rnd.nextBoolean())
				{
					this.tab[j][i]='X' ;
				}
				else
				{
					this.tab[j][i]=' ' ;
				}
			}
		}
		
		//lancer la fenetre avec le jeu
		go();
	}

	private void go(){
		for(;;){
			int x = pan.getPosX(), y = pan.getPosY();
			//x++;
			//y++;
			x = this.getWidth()/4;
			y = this.getHeight()/4;
			pan.setPosX(x);
			pan.setPosY(y);
			//afficher la condition de départ dans la console
			this.Text = this.Tab2String(tab);
			//String essai = Character.to
			//System.out.println(Text);

			//calcul du nouveau monde;
			for (int i = 0; i<this.tab.length; i++)
			{
				for (int j=0; j<this.tab.length; j++)
				{
					if(this.isAlive(this.tab, j, i))
					{
						newtab[j][i]='X';
					}else
					{
						newtab[j][i]=' ';
					}
				}
			}
			//on récupere le monde dans un texte
			Text = Tab2String(newtab);
			pan.setAlive(newtab);
			// on met à jour la table pour continuer la simulation
			for (int i = 0; i<size; i++)
			{
				for (int j=0; j<size; j++)
				{
					tab[i][j]=newtab[i][j];
				}
			}
			
			//on affiche dans la fenetre
								
			//pan.setText(this.Text);
			
			pan.repaint();  
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	} 
	public void setText(String Text) {
		this.Text = Text;
	}
	//////////////////////////////// POUR LE JEU DE LA VIE //////////////////////////////////

	//	Methode pour afficher un tableau 2 dimensions 
	public static void displayTab2 (char Tab[][]) {


		for (int i = 0; i<Tab.length; i++)
		{
			for (int j=0; j<Tab.length; j++)
			{
				System.out.print("["+Tab[i][j]+"]" );
				//System.out.print(Tab[i][j]);
			}
			System.out.print("\n" );
		}

	}
	//	//	Methode pour copier le tableau dans un string
	public static String Tab2String (char Tab[][]) {

		String Text ="";

		for (int i = 0; i<Tab.length; i++)
		{
			for (int j=0; j<Tab.length; j++)
			{
				//Text.concat("[").concat(Character.toString(Tab[i][j])).concat("]");
				//Text = Text+"["+Character.toString(Tab[i][j])+"]";
				Text = Text+Character.toString(Tab[i][j]);
				//Text = Text+" "+Character.toString(Tab[i][j])+" ";
			}
			//System.out.print("\n" );
			Text = Text+"\n";
		}
		return Text;

	}
	//	Methode pour tester des cellules adjacente 
	public static boolean isAlive (char Tab[][], int y, int x) {

		boolean isAlive = false;
		int counter = 0;
		//on définit la zone à inspecter dans un carré dont les coordonnées sont
		int x1 = x-1;
		int x2 = x+1;
		int y1 = y-1;
		int y2 = y+1;

		//la cellule considrée est-elle sur un bord de tableau ?
		//si oui on corrige la zone à couvrir
		if (x1<0)
		{
			x1 = 0;
		}
		if (y1<0)
		{
			y1=0;
		}
		if (x2>=Tab.length)
		{
			x2=Tab.length-1;
		}
		if (y2>=Tab.length)
		{
			y2=Tab.length-1;
		}

		//la cellule considérée est-elle vivante ?
		if (Tab[y][x]=='X')
		{
			isAlive = true;
		}

		// y a -t-il des cellules vivantes autour
		for (int i = y1; i<=y2; i++ )
		{
			for (int j = x1; j<=x2; j++)
			{
				if (Tab[i][j]=='X')
				{
					counter++;
				}
			}
		}
		//si la cellule était vivante elle ne doit pas compter dans le compte de cellule 
		// et elle ne reste vivante que si le compte de cellule vivante autour est >=3
		//si elle est morte, elle s'active si compteur >=3
		if (isAlive)
		{
			counter--;
			if (!(counter==3 || counter ==2))
			{
				isAlive = false;
			}
		}else
		{
			if (counter==3)
			{
				isAlive = true;
			}
		}
		return isAlive;
	} 
}