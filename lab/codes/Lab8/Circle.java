import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;
public class Circle {
    public double radius;
    public double x;
    public double y;
    public double distance;
    public int number;
    public Circle() {
        this.radius = radius;
    }

    public Circle(double radius, double x, double y,double distance) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.distance=distance;
    }
    public String toString(){
        return "Circle "+ String.valueOf(x)+": radius ="+ String.valueOf(radius) +"x = %.2f"+ "y = %.2f\n";
    }

    public void distanceToOrigin() {
        Random n = new Random();
        int N=n.nextInt(9)+5;
        number=0;
        int smallest=0,furthest=0;
        double areamin=100,dismax=0;
        ArrayList<Circle> circle = new ArrayList<>();
        for (int i=0;i<N;i++){
            number+=1;
            radius=n.nextDouble()*3+1;
            x=n.nextDouble()*5+2;
            y=n.nextDouble()*5+2;
            distance=Math.sqrt(x*x+y*y);
            circle.add(new Circle(radius,x,y,distance));
            System.out.printf("Circle #%d: radius = %.2f, x = %.2f, y = %.2f\n",number,radius,x,y);
        }
        for (int i=0;i<N;i++){
            if (areamin>=circle.get(i).radius*circle.get(i).radius*Math.PI){
                areamin=circle.get(i).radius*circle.get(i).radius*Math.PI;
                smallest=i;
            }
            if (dismax<=circle.get(i).distance){
                dismax=circle.get(i).distance;
                furthest=i;
            }
        }
        System.out.printf("Circle #%d is the smallest circle, area %.2f\n",smallest+1,areamin);
        System.out.printf("Circle #%d is the farthest circle, area %.2f",furthest+1,dismax);
    }
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.distanceToOrigin();
    }
}
