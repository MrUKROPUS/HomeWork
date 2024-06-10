public interface Shape {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getStrokeColor();
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String strokeColor;

    public Circle(double radius, String fillColor, String strokeColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getStrokeColor() {
        return strokeColor;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String strokeColor;

    public Rectangle(double width, double height, String fillColor, String strokeColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getStrokeColor() {
        return strokeColor;
    }
}


class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String strokeColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String strokeColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double semiperimeter = getPerimeter() / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getStrokeColor() {
        return strokeColor;
    }
}

class Main2 {
    public static void main(String[] args) {
        Circle c = new Circle(5, "Синий", "Фиолетовый");
        Rectangle rectangle = new Rectangle(4, 6, "Зеленый", "Бордовый");
        Triangle triangle = new Triangle(3, 4, 5, "Желтый", "Голубой");

        System.out.println("Круг:");
        System.out.println("Периметр: " + c.getPerimeter());
        System.out.println("Площадь: " + c.getArea());
        System.out.println("Цвет заливки: " + c.getFillColor());
        System.out.println("Цвет обводки: " + c.getStrokeColor());

        System.out.println("Прямоугольник:");
        System.out.println("Периметр: " + rectangle.getPerimeter());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет обводки: " + rectangle.getStrokeColor());

        System.out.println("Триугольник:");
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет заливки: " + triangle.getStrokeColor());
    }
}
