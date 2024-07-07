package extensibilityViaFactory;

import java.util.List;
import java.util.Date;
import extensibilityViaFactory.Shape.ShapeType;

class ShapeFactory {
	
	/**
	 * Method to store all the objects.
	 * 
	 * @param shapeType for which shape object is to be create.
	 * @param point the starting point or origin.
	 * @param dimensions it contains the dimensions of the shape.
	 * @return the shape object based on the given shape.
	 */
	public static Shape createShape(ShapeType shapeType, Point point, List<Double> dimensions) {
		Shape shape = null;
		switch(shapeType) {
		case RECTANGLE:
			shape = new Rectangle(point, dimensions.get(0), dimensions.get(1), new Date());
			break;
			
		case SQUARE:
			shape = new Square(point, dimensions.get(0), new Date());
			break;
			
		case CIRCLE:
			shape = new Circle(point, dimensions.get(0), new Date());
			break;
			
		case TRIANGLE:
			shape = new Triangle(point, dimensions.get(0), dimensions.get(1), new Date());
			break;
			
		default:
			break;
		}
		return shape;
	}
}
