package extensibilityViaFactory;

class Circle implements Shape{
	private double radius;
	private Point point;
	
	/**
	 * Constructor of the class
	 * 
	 * @param point Stores the origin/starting coordinates 
	 * @param radius of the circle
	 */
	public Circle(Point point, double radius) {
		this.point = point;
		this.radius = radius;
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
	
	// checks whether the given points is enclosed in the circle
	@Override
	public boolean isPointEnclosed(double x, double y) {
		boolean flag = false;
		double hypo = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double area = 3.14 * hypo * hypo;
		if(getArea() >= area) {
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
