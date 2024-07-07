package extensibilityViaFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import extensibilityViaFactory.Shape.ShapeType;

class ShapeFactoryTest {

	@Test
	public void squareTest() {
		Shape shape = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0,0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		assertEquals(4, shape.getArea());
		assertEquals(8, shape.getPerimeter());
		assertEquals(true, shape.isPointEnclosed(1, 1));
	}
	
	@Test
	public void rectangleTest() {
		Shape shape = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		assertEquals(12, shape.getArea());
		assertEquals(14, shape.getPerimeter());
		assertEquals(true, shape.isPointEnclosed(1, 1));
	}
	
	@Test
	public void triangleTest() {
		Shape shape = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		assertEquals(0.5 * 3 * 4, shape.getArea());
		assertEquals(12, shape.getPerimeter());
	}
	
	@Test
	public void circleTest() {
		Shape shape = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(5.0);
			}
		});
		assertEquals(3.14 * 5 * 5, shape.getArea());
		assertEquals(2 * 3.14 * 5, shape.getPerimeter());
	}
	
	@Test
	public void addShapeTest() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0,0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		
		ArrayList<Shape> arr = new ArrayList<Shape>();
		arr.add(shape1);
		arr.add(shape2);
		
		assertEquals(arr, screen.getShapeList());
	}
	
	@Test
	public void deleteShapeTest() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0,0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.deleteShape(shape2);
		
		ArrayList<Shape> arr = new ArrayList<Shape>();
		arr.add(shape1);
		
		assertEquals(arr, screen.getShapeList());
	}
	
	@Test
	public void deleteShapeOfSimilarTypeTest() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0,0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		
		Shape shape3 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0,0), new ArrayList<Double>() {
			{
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.addShape(shape3);
		screen.deleteSameTypeShapes(ShapeType.SQUARE);
		ArrayList<Shape> arr = new ArrayList<Shape>();
		arr.add(shape2);
		assertEquals(arr, screen.getShapeList());
	}
	
	@Test
	public void sortedByAreaTest() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0,0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		
		Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(1.0);
			}
		});
		
		Shape shape4 = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.addShape(shape3);
		screen.addShape(shape4);
		screen.sortByArea();
		
		ArrayList<Shape> arr = new ArrayList<Shape>();
		arr.add(shape3);
		arr.add(shape1);
		arr.add(shape4);
		arr.add(shape2);
		assertEquals(arr, screen.getShapeList());
	}
	
	@Test
	public void sortedByPerimeterTest() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0,0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		
		Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(1.0);
			}
		});
		
		Shape shape4 = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(0,0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.addShape(shape3);
		screen.addShape(shape4);
		screen.sortByPerimeter();
		
		ArrayList<Shape> arr = new ArrayList<Shape>();
		arr.add(shape3);
		arr.add(shape1);
		arr.add(shape4);
		arr.add(shape2);
		assertEquals(arr, screen.getShapeList());
	}
	
	@Test
	public void sortedByOriginTest() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1,1), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(2,2), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		
		Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(3,3), new ArrayList<Double>() {
			{
				add(1.0);
			}
		});
		
		Shape shape4 = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(4,4), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.addShape(shape3);
		screen.addShape(shape4);
		screen.sortByOrigin();
		
		ArrayList<Shape> arr = new ArrayList<Shape>();
		arr.add(shape1);
		arr.add(shape2);
		arr.add(shape3);
		arr.add(shape4);
		assertEquals(arr, screen.getShapeList());
	}

}
