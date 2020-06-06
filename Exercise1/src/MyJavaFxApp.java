import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
/**
 * @author Nahin Imtiaz
 *		email: nimtiaz000@citymail.cuny.edu
 *		CCNY ID : 23556198
 *
 *This class uses JavaFX graphics and the class hierarchy to draw a geometric configuration comprised of a sequence of alternating concentric circles and their inscribed hexagons
 */
public class MyJavaFxApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Initializing a Canvas object from addCanvas() method with given width and height
		Canvas cv = addCanvas(700,400 );
		int w = (int)cv.getWidth();
		int h = (int)cv.getHeight();
		// Creating a Pane and setting the canvas in the center of the Pane
		Pane p = new Pane();
		p.getChildren().add(cv);
		// Creating Scene object and setting the Scene in Stage
		Scene sc =new Scene(p,w,h,MyColor.WHITE.getColor());
		primaryStage.setScene(sc);
		primaryStage.setTitle("Geometric Configuration ");
		primaryStage.show();
	}
	/**
	 * this method is used to create a canvas object with parameters and draw geometric configuration on GraphicsContxt object
	 * @param w
	 * this is the width of the canvas
	 * @param h
	 * this is the height of the canvas
	 * @return Canvas
	 */
	public Canvas addCanvas(int w, int h) {
		Canvas cv= new Canvas(w,h); 
		GraphicsContext gc = cv.getGraphicsContext2D();
		// radius of MyPolygon object proportionate to the height of the canvas
		int radius = h/2;
		//creating and drawing the first MyPolygon object with 6 sides
		MyPolygon hexagon1 = new MyPolygon(6,radius,MyColor.BLUE);			
		hexagon1.setX(w/2);
		hexagon1.setY(h/2);
		hexagon1.draw(gc);
		
		//radius of MyCircle object proportionate to the radius of the hexagon1		
		double radius1= radius* Math.cos(Math.toRadians(180/6));	
		//creating and drawing the first MyCircle object
		MyCircle circle1 = new MyCircle(radius1,MyColor.GREEN);
		circle1.setX(w/2-radius1);
		circle1.setY(h/2-radius1);
		circle1.draw(gc);
		//creating and drawing the second MyPolygon object with 6 sides	
		MyPolygon hexagon2 = new MyPolygon(6,radius1,MyColor.PINK);			
		hexagon2.setX(w/2);
		hexagon2.setY(h/2);
		hexagon2.draw(gc);
		//radius of MyCircle object proportionate to the radius of the hexagon2		
		double radius2= radius1* Math.cos(Math.toRadians(180/6));		
		//creating and drawing the second MyCircle object
		MyCircle circle2= new MyCircle(radius2,MyColor.YELLOW);		
		circle2.setX(w/2-radius2);
		circle2.setY(h/2-radius2);
		circle2.draw(gc);
		//creating and drawing the third MyPolygon object with 6 sides				
		MyPolygon hexagon3 = new MyPolygon(6,radius2,MyColor.RED);			
		hexagon3.setX(w/2);
		hexagon3.setY(h/2);
		hexagon3.draw(gc);
		
		//creating and drawing MyLine object (Diagonal)
		MyLine line1 = new MyLine(0,0,w,h,MyColor.BLACK);
		line1.setX(w);
		line1.setY(h/2);
		line1.draw(gc);
		//creating and drawing MyLine object (Reverse Diagonal)
		MyLine line2 = new MyLine(0,h,w,0,MyColor.BLACK);
		line2.setX(w);
		line2.setY(h/2);
		line2.draw(gc);
		//creating and drawing MyLine object (Top Horizontal)
		MyLine line3 = new MyLine(0,0,w,0,MyColor.BLACK);
		line3.setX(w);
		line3.setY(h/2);
		line3.draw(gc);
		//creating and drawing MyLine object (Bottom Horizontal)
		MyLine line4 = new MyLine(0,h,w,h,MyColor.BLACK);
		line4.setX(w);
		line4.setY(h/2);
		line4.draw(gc);
		//creating and drawing MyLine object (Left Vertical)
		MyLine line5 = new MyLine(0,0,0,h,MyColor.BLACK);
		line5.setX(w);
		line5.setY(h/2);
		line5.draw(gc);
		//creating and drawing MyLine object (Right Vertical)
		MyLine line6 = new MyLine(w,0,w,h,MyColor.BLACK);
		line6.setX(w);
		line6.setY(h/2);
		line6.draw(gc);
		
		return cv;
	}
}
