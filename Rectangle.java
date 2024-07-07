package extensibilityViaFactory;

import java.util.Date;

class Rectangle implements Shape {
	private double length;
	private double breadth;
	private Point point;
	private Date date;
	
	/**
	 * Constructor of the class
	 * 
	 * @param point Stores the origin/starting coordinates 
	 * @param length of the rectangle
	 * @param breadth of the rectangle
    	 * @param date to show the date and time when the object is created.
	 */
	public Rectangle(Point point, double length, double breadth, Date date) {
		this.breadth = breadth;
		this.length = length;
		this.point = point;
		this.date = date;
	}
	
	// return the area of the rectangle
	@Override
	public double getArea() {
		return length*breadth;
	}
	
	// return the perimeter of the rectangle
	@Override
	public double getPerimeter() {
		return 2 *(length + breadth);
	}
	
	// return the origin/starting point of the rectangle
	@Override
	public Point getOrigin() {
		return point;
	}
	
	// return the date and time when the object is created
	@Override
	public Date getDate() {
		return date;
	}
	
	// checks whether the given points is enclosed in the rectangle
	@Override
	public boolean isPointEnclosed(double x, double y) {
		boolean flag = false;
		if(x >= point.getX() && x <= point.getX()+breadth && y >= point.getY() && y <= point.getY()+length) {
			flag = true;
		}
		return flag;
	}
	
	@Override
	public ShapeType getShape() {
		return ShapeType.RECTANGLE;
	}
	
}
