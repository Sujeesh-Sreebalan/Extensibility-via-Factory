package extensibilityViaFactory;

import java.util.Date;

class Square implements Shape {
	
	private double side;
	private Point point;
	private Date date;
	
	/**
	 * Constructor of the class
	 * 
	 * @param point point Stores the origin/starting coordinates 
	 * @param side 
	 */
	public Square(Point point, double side, Date date) {
		this.point = point;
		this.side = side;
		this.date = date;
	}
	
	// return the area of the square
	@Override
	public double getArea() {
		return side*side;
	}

	// return the perimeter of the square
	@Override
	public double getPerimeter() {
		return 4*side;
	}
	
	// // return the origin/starting point of the square
	@Override
	public Point getOrigin() {
		return point;
	}
	
	// return the date and time when the object is created
	@Override
	public Date getDate() {
		return date;
	}
	
	// checks whether the given points is enclosed in the square
	@Override
	public boolean isPointEnclosed(double x, double y) {
		boolean flag = false;
		if(x >= point.getX() && x <= point.getX()+side && y >= point.getY() && y <= point.getY() + side) {
			flag = true;
		}
		return flag;
	}

	@Override
	public ShapeType getShape() {
		return ShapeType.SQUARE;
	}
	
	
}
