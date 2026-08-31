// Define the package that this class belongs to
package swing.scrollbar;

// Import the required classes
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.List;

public class PolygonCorner {

    // Method to get a GeneralPath with rounded corners based on a list of points and arcSize
    public GeneralPath getRoundedGeneralPathFromPoints(List<Point2D> l, float arcSize) {
        // Duplicate the first two points at the end of the list to close the polygon
        l.add(l.get(0));
        l.add(l.get(1));
        GeneralPath p = new GeneralPath(); // Create a new GeneralPath object to hold the path
        Point2D startPoint = calculatePoint(l.get(l.size() - 1), l.get(l.size() - 2), arcSize);
        p.moveTo(startPoint.getX(), startPoint.getY()); // Move to the starting point
        // Loop through the points to create the path
        for (int pointIndex = 1; pointIndex < l.size() - 1; pointIndex++) {
            Point2D p1 = l.get(pointIndex - 1);
            Point2D p2 = l.get(pointIndex);
            Point2D p3 = l.get(pointIndex + 1);
            Point2D mPoint = calculatePoint(p1, p2, arcSize); // Calculate the intermediate control point for the curve
            p.lineTo(mPoint.getX(), mPoint.getY()); // Create a line to the intermediate point
            mPoint = calculatePoint(p3, p2, arcSize); // Calculate the next intermediate control point for the curve
            p.curveTo(p2.getX(), p2.getY(), p2.getX(), p2.getY(), mPoint.getX(), mPoint.getY()); // Create a cubic Bezier curve
        }
        return p; // Return the final GeneralPath with the rounded corners
    }

    // Method to calculate an intermediate point on a line between two points with a specified arcSize
    private Point2D calculatePoint(Point2D p1, Point2D p2, float arcSize) {
        // Calculate the distance between the two points
        double d1 = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2f) + Math.pow(p1.getY() - p2.getY(), 2f));
        // Calculate the percentage of arcSize relative to the distance
        double per = arcSize / d1;
        // Calculate the offset in the x and y direction based on the percentage and the line direction
        double d_x = (p1.getX() - p2.getX()) * per;
        double d_y = (p1.getY() - p2.getY()) * per;
        // Calculate the x and y coordinates of the intermediate point
        double xx = p2.getX() + d_x;
        double yy = p2.getY() + d_y;
        return new Point.Double(xx, yy); // Return the intermediate point as a Point2D.Double object
    }
}
