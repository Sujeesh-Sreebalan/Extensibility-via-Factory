package extensibilityViaFactory;

import java.util.Date;

class Triangle implements Shape{
	private double base;
	private double height;
	private Point point;
	private Date date;
	
	/**
	 * Constructor of the class
	 * 
	 * @param point point Stores the origin/starting coordinates
	 * @param base of the triangle
	 * @param height of the triangle
    	 * @param date to show the date and time when the object is created.
	 */
	public Triangle(Point point, double base, double height, Date date) {
		this.point = point;
		this.base = base;
		this.height = height;
		this.date = date;
	}
	
	// return the area of the triangle
	@Override
	public double getArea() {
		return (height * base)/2;
	}
	
	// return the perimeter of the trinagle
	@Override
	public double getPerimeter() {
		double hypo = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
		return hypo + base + height;
	}

	// return the origin/starting point of the triangle
	@Override
	public Point getOrigin() {
		return point;
	}
	
	// return the date and time when the object is created
	@Override
	public Date getDate() {
		return date;
	}
	
	// checks whether the given points is enclosed in the triangle
	@Override
	public boolean isPointEnclosed(double a, double b) {
		boolean flag = false;
		double x1 = point.getX();
		double y1 = point.getY();
		double x2 = x1 + base;
		double y2 = 0;
		double x3 = 0;
		double y3= y1 + height;
		double area1  = area(x1, y1, x2, y2, a, b);
		double area2  = area(x1, y1,a, b, x3, y3);
		double area3  = area(a, b, x2, y2, x3, y3);
		if(getArea() == (area1+ area2 + area3)) {
			flag = true;
		}
		return flag;
	}
	
	// Helper function to calculate the area of the triangle
	private double area(double x1, double y1, double x2, double y2, double x3, double y3) {
		return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2);
	}
	
	@Override
	public ShapeType getShape() {
		return ShapeType.TRIANGLE;
	}

}
