package extensibilityViaFactory;

public interface Shape {
	/**
	 * Initializing enums
	 */
	public enum ShapeType{
		SQUARE,
		RECTANGLE,
		CIRCLE,
		TRIANGLE
	}
	
	public double getArea();
	
	public double getPerimeter();
	
	public Point getOrigin();
	
	public boolean isPointEnclosed(double x, double y);
	
	public ShapeType getShape();
	
}
