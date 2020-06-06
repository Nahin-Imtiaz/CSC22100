import javafx.scene.paint.Color;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *this is an enumerator class with constant color values 
 */
public enum MyColor{
	ORANGE(255,165,0,1.0),RED(255,0,0,1.0),GREEN(0,255,0,1.0),BLUE(0,0,255,1.0),YELLOW(250,233,2,1.0),PINK(255,0,153,1.0),CYAN(0,255,255,1.0),MAGENTA(255,0,255,1.0),SILVER(192,192,192,1.0),GRAY(128,128,128,1.0),MAROON(128,0,0,1.0),OLIVE(128,128,0,1.0),LIME(0,128,0,1.0),TEAL(0,128,128,1.0),NAVY(0,128,128,1.0),DARKRED(139,0,0,1.0),BROWN(165,42,42,1.0),CORAL(255,127,80,1.0),PALEGREEN(152,251,152,1.0),STEELBLUE(70,130,180,1.0),PLUM(221,160,221,1.0),WHEAT(245,222,179,1.0),CHOCOLATE(210,105,30,1.0),MINT(245,255,250,1.0),LAVENDER(230,230,250,1.0),HONEYDEW(240,255,240,1.0),WHITE(255,255,255,1.0),BLACK(0,0,0,1.0);
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