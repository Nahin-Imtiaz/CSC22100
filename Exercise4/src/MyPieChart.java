/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *This class  displays a pie chart of the probabilities of the n most frequent occurrences of an event 
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class MyPieChart {
	int event;
	//An array of Alphabets
	Character[] gpa = new Character[6];
	//An array of probabilities for each events
	double[] probabilityOfEvent = new double[event];
	//An array of colors for each events
	MyColor[] col = MyColor.values();
	/**
	 * this is a constructor that takes parameters
	 * @param n
	 * this is the number of events
	 * @param characters
	 * this is an array of characters
	 * @param probability
	 * this is an array for probabilities of each event
	 */
	MyPieChart(int n,double[] probability) {
		this.event = n;
		this.probabilityOfEvent = probability;
		gpa[0]='A';gpa[1]='B';gpa[2]='C';gpa[3]='D';gpa[4]='F';gpa[5]='W';
	}
	/**
	 * this method draws a PieChart of the n most frequent occurrences of an event
	 * @param gc
	 * this is the graphic context
	 * @param w
	 * this is the width of the canvas
	 * @param h
	 * this is the height of the canvas
	 */
	public void draw(GraphicsContext gc,double w,double h) {
		
		//This is the starting angle for each event
		double startAngle = 0;
		//This is the angle of each event depending on their probability
		double arcExtent;
		//Setting probability of ALL OF THE OTHER events value to 1
		
		//Loop over each event and fill the graphics context with corresponding segment and color
		for(int i=0;i<event;i++) {
			//Setting the central angle and color of segment i and adding it to graphics context
			arcExtent = 360*probabilityOfEvent[i];
			gc.setFill(col[i].getColor());
			gc.fillArc(w/3,h/7, h/2, h/2, startAngle, arcExtent, ArcType.ROUND);
			//Setting the legend of each segment
			String str =gpa[i]+", "+probabilityOfEvent[i];
			gc.fillText(str, (90+(w/3)-((h/3)*Math.cos(1.2*startAngle+(arcExtent/2)))),(90+(h/7)-((h/3)*Math.sin(1.2*startAngle+(arcExtent/2)))));
			startAngle += arcExtent;
			//Calculating the probability of 'All Of the other' and parsing it to 4 digit decimal
		}
	}
}