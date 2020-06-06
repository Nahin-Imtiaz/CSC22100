import javafx.scene.paint.Color;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *this is an enumerator class with constant color values 
 */
public enum MyColor{
	RED(255,0,0,1.0),GREEN(0,255,0,1.0),BLUE(0,0,255,1.0),YELLOW(250,233,2,1.0),PINK(255,0,153,1.0),WHITE(255,255,255,1.0),BLACK(0,0,0,1.0);
	private  int R;
	private  int G;
	private  int B;
	private double C;
	Color myColor;
	/**
	 * this constructor is used to create an object of MyColor with parameters
	 * @param R
	 * this is the value of red
	 * @param G
	 * this is the value of green
	 * @param B
	 * this is the value of blue
	 * @param C
	 * this is value of opacity
	 */
	MyColor(int R, int G, int B, double C) {
		this.R= R;
		this.G= G;
		this.B= B;
		this.C= C;
		// sets the corresponding Color value 
		this.myColor= Color.rgb(R,G,B,C);
	}
	/**
	 * this method returns color of this object
	 * @return Color
	 */
	public Color getColor() {
		return this.myColor;
	}
}
