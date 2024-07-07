package extensibilityViaFactory;

import java.util.Date;

class Circle implements Shape{
	private double radius;
	private Point point;
	private Date date;
	
	/**
	 * Constructor of the class
	 * 
	 * @param point Stores the origin/starting coordinates 
	 * @param radius of the circle
  	 * @param date to show the date and time when the object is created.
	 */
	public Circle(Point point, double radius, Date date) {
		this.point = point;
		this.radius = radius;
		this.date = date;
	}
	
	// return the area of the circle
	@Override
	public double getArea() {
		return 3.14 * radius * radius;
	}
	
	// return the perimeter of the circle
	@Override
	public double getPerimeter() {
		return 2 * 3.14 * radius;
	}
	
	// return the origin/starting point of the circle
	@Override
	public Point getOrigin() {
		return point;
	}
	
	// return the date and time when the object is created
	@Override
	public Date getDate() {
		return date;
	}
	
	// checks whether the given points is enclosed in the circle
	@Override
	public boolean isPointEnclosed(double x, double y) {
		boolean flag = false;
		double x1 = x - point.getX();
		double y1 = y - point.getY();
		double hypo = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
		if(radius >= hypo) {
			flag = true;
		}
		return flag;
	}
	
	@Override
	public ShapeType getShape() {
		// TODO Auto-generated method stub
		return ShapeType.CIRCLE;
	}

}
