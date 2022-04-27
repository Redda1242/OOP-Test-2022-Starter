package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematode = new ArrayList<Nematode>();
	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();	
		loadNematodes();			
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
        for(TableRow r:table.rows())
        {
            Nematode n = new Nematode(r);
            nematode.add(n);
        }

		nematode.toString();
	}

	void drawNematode(int index)
	{
		
		background(0);
		stroke(255, 0, 255);
		noFill();
        textAlign(CENTER, CENTER);
        textSize(20);
		float xPosition = width/2;
		float yPosition = 80;

		//line(xPosition, yPosition, xPosition+100, yPosition+200);
		//rect(xPosition, yPosition, 220, 100);
		
		for(Nematode n: nematode)
		{
			n.toString();
			
			yPosition = 80;
			if(index == nematode.indexOf(n))
				text(n.getName(), 20, 20);
				for(int i = 0; i < n.getLength(); i++)
				{
					if(n.getLimbs() == 1)
					{
						line(xPosition-10, yPosition, xPosition - 20, yPosition);
						line(xPosition+10, yPosition, xPosition +20, yPosition);

					}
					stroke(255, 0, 255);
					circle(xPosition, yPosition, 20);
					yPosition = yPosition +20;

				}
		}
	}


	public void draw()
	{	
		drawNematode(0);
	}
}
