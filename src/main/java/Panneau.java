import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	private int posX = this.getWidth()/2;
	private int posY = this.getHeight()/2;
	private String Text  = "";
	private int size = 200;
	private int Alive[][]= new int[size][size];


	public void paintComponent(Graphics g){
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//On le dessine aux coordonnées souhaitées
		for (int i =0; i<this.Alive.length;i++)
		{
			for (int j = 0; j<this.Alive.length;j++)
			{
				if (this.Alive[i][j]==1)
				{
					//On redéfinit une couleur pour le rond
					//on génére une couleur aleatoire
//					Random rnd = new Random();
//					Color couleur = new Color (rnd.nextFloat(),rnd.nextFloat(),rnd.nextFloat());
//					g.setColor(couleur);
					g.setColor(Color.RED);
					g.fillOval(i*this.getWidth()/this.size, j*this.getHeight()/this.size, this.getWidth()/this.size+4, this.getHeight()/this.size+4);
				}else
				{
//					g.setColor(Color.WHITE);
//					//g.fillOval(i*4, j*4, 5, 5);
//					g.fillOval(i*this.getWidth()/this.size, j*this.getHeight()/this.size, this.getWidth()/this.size+5, this.getHeight()/this.size+5);
//					
				}
			}
			
		}
		
		
		//on affiche un texte
			//		
//		for (int i = 1; i<=5;i++)
//		{
//		g.drawString(this.Text.substring(0, 15), posX, posY);
//		g.drawString(this.Text.substring(16, 31), posX, posY+12);
//		g.drawString(this.Text.substring(32, 47), posX, posY+24);
//		g.drawString(this.Text.substring(48, 63), posX, posY+36);
//		g.drawString(this.Text.substring(64, 79), posX, posY+48);
//		}
		
	}
	public void setAlive(char tab[][]) {
		//this.Alive = new int[tab.length][tab.length];
		for (int i = 0; i<tab.length; i++)
		{
			for (int j=0; j<tab.length; j++)
			{
				if (tab[i][j]=='X')
				{
					this.Alive[i][j]=1;
				}else
				{
					this.Alive[i][j]=0;
				}
			}
		}
	}
//	public void setColor(Color couleur) {
//		this.couleur = couleur;
//	}
	public void setText(String Text) {
		this.Text = Text;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}        
}