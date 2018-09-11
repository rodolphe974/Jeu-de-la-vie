import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	private Panneau pan = new Panneau();
	private String Text = "";
	//initialiser les valeurs du jeu
	private int size = pan.getSiz(); //taille du monde
	private boolean tab[][] = new boolean[this.size][this.size];	//tableau du monde
	private boolean newtab[][] = new boolean[this.size][this.size]; //tableau du nouveau monde
	private boolean flag = true ;

	public Fenetre(){
		//pan.setSiz(size);
		this.setTitle("It's alive !!!");
		this.setSize(size, size);
		this.setPreferredSize(new Dimension(size,size));
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);


		Random rnd = new Random();
		for (int i = 0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				this.tab[j][i]=rnd.nextBoolean() ;
			}
		}

		//lancer la fenetre avec le jeu
		go();
	}

	private void go(){
		for(;;){
			int x = pan.getPosX();
			int y = pan.getPosY();
//			pan.setPosX(x);
//			pan.setPosY(y);

			if (flag)
			{
				pan.setTab(this.tab);
				flag = false;
			}
			//on affiche dans la fenetre

			pan.repaint();  
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	} 

	//////////////////////////////// POUR LE JEU DE LA VIE //////////////////////////////////
	public void setSiz(int csize){
		this.size = csize;
	}
	//	Methode pour tester des cellules adjacente 
	public static boolean isAlive (boolean Tab[][], int y, int x) {

		boolean isAlive = Tab[y][x];
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

		// y a -t-il des cellules vivantes autour
		for (int i = y1; i<=y2; i++ )
		{
			for (int j = x1; j<=x2; j++)
			{
				if (Tab[i][j])
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