package homework_1;

import java.awt.geom.Point2D;

class Circle implements IFigure{
    private Point2D center;
    private float radius;

    Circle(Point2D center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void draw()
    {
        System.out.println("рисуем цирклу");
    }

    @Override
    public void transform(Point2D radiusVector)
    {
        System.out.println("трансформируем цирклу только по двум осям одновременно");
    }
}

class Triangle implements IFigure{
    private Point2D vertex1;
    private Point2D vertex2;
    private Point2D vertex3;

    Triangle(Point2D vert1, Point2D vert2, Point2D vert3) {
        vertex1 = vert1;
        vertex2 = vert2;
        vertex3 = vert3;
    }

    @Override
    public void draw()
    {
        System.out.println("рисуем треугольник");
    }

    @Override
    public void transform(Point2D radiusVector)
    {
        System.out.println("трансформируем треугольник");
    }
}

abstract class Quadrilateral implements IFigure {
    private Point2D vertex1;
    private Point2D vertex2;
    private Point2D vertex3;
    private Point2D vertex4;

    Quadrilateral(Point2D vert1, Point2D vert2, Point2D vert3, Point2D vert4)
    {
        vertex1 = vert1;
        vertex2 = vert2;
        vertex3 = vert3;
        vertex4 = vert4;
    }

    @Override
    public void draw()
    {
        System.out.println("рисуем четырехугольник по точкам");
    }

    @Override
    public void transform(Point2D radiusVector)
    {
        System.out.println("трансформируем четырехугольник");
    }
}

class Rect extends Quadrilateral{
    private Point2D leftBottomVertex;
    private float width;
    private float height;

    Rect(Point2D leftBottomVertex, float width, float height) {
        super(leftBottomVertex,
                new Point2D.Double(leftBottomVertex.getX(), leftBottomVertex.getY()+height),
                new Point2D.Double(leftBottomVertex.getX()+width, leftBottomVertex.getY()+height),
                new Point2D.Double(leftBottomVertex.getX()+width, leftBottomVertex.getY()));
        this.leftBottomVertex = leftBottomVertex;
        this.width = width;
        this.height = height;
    }
}

class Square extends Quadrilateral {
    private Point2D leftBottomVertex;
    private float lenOfEdge;

    Square(Point2D leftBottomVertex, float lenOfEdge){
        super(leftBottomVertex,
                new Point2D.Double(leftBottomVertex.getX(), leftBottomVertex.getY()+lenOfEdge),
                new Point2D.Double(leftBottomVertex.getX()+lenOfEdge, leftBottomVertex.getY()+lenOfEdge),
                new Point2D.Double(leftBottomVertex.getX()+lenOfEdge, leftBottomVertex.getY()));
        this.leftBottomVertex = leftBottomVertex;
        this.lenOfEdge = lenOfEdge;
    }

    @Override
    public void transform(Point2D radiusVector)
    {
        System.out.println("трансформируем квадрат только по двум осям одновременно");
    }
}

public interface IFigure {
    void draw();
    void transform(Point2D radiusVector);

    public static void main(String[] args) {
        IFigure circl = new Circle(new Point2D.Float(5,5), 2);
        IFigure triang = new Triangle(new Point2D.Float(0,0), new Point2D.Float(10,10), new Point2D.Float(15,0));
        IFigure rect = new Rect(new Point2D.Float(0,0), 8, 4);
        IFigure squar = new Square(new Point2D.Float(3,3), 7);

        circl.draw();
        triang.draw();
        rect.draw();
        squar.draw();

        circl.transform(new Point2D.Float(0.4f,1.5f));
        triang.transform(new Point2D.Float(0.4f,1.5f));
        rect.transform(new Point2D.Float(0.4f,1.5f));
        squar.transform(new Point2D.Float(0.4f,1.5f));
    }
}
