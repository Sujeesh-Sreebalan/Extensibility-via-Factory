package extensibilityViaFactory;

class Point {
	private double x;
	private double y;
	
	/**
	 * Constructor of the class which stores the origin points
	 *  
	 * @param x input point
	 * @param y input point
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// return the x coordinate of the origin
	public double getX() {
		return x;
	}
	
	// return the y coordinate of the origin
	public double getY() {
		return y;
	}
}
