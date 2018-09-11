import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau extends JPanel {
//	private int posX = this.getWidth()/2;
//	private int posY = this.getHeight()/2;
	private int posX = 0;
	private int posY = 0;
	private String Text  = "";
	private int size;
	private boolean tab[][]= new boolean[size][size];
	private boolean newtab[][]= new boolean[size][size];

	public void paintComponent(Graphics g){
		
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		//calcul du nouveau monde;
		for (int i = 0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				if(Fenetre.isAlive(this.tab, j, i))
				{
					newtab[j][i]=true;
					g.setColor(Color.RED);
					g.fillOval(i*this.getWidth()/this.size, j*this.getHeight()/this.size, this.getWidth()/this.size+4, this.getHeight()/this.size+4);
	//				g.fillOval(i, j, this.getWidth()/this.size+4, this.getHeight()/this.size+4);

				}else
				{
					newtab[j][i]=false;
				}
			}
		}

		// on met à jour la table pour continuer la simulation
		for (int i = 0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				tab[i][j]=newtab[i][j];
			}
		}
	}
	public void setSiz(int size){
		this.size = size;
	}
	public int getSiz() {
		return size;
	}
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
	public void setTab(boolean extab[][]) {
		for (int i = 0; i<size; i++)
		{
			for(int j=0; j< size; j++)
			{
				this.tab[j][i]=extab[j][i];
			}
		}
	}
}