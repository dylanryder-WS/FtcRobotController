package org.firstinspires.ftc.teamcode.LearnJavaBook;

public class RobotLocation {
    double angle;
    double x;
    double y;

    public RobotLocation(double angle){     // constructor
        this.angle = angle;
    }

    public double getHeading(){     // returns the robot's heading within 180 to -180
        double angle = this.angle;
        while(angle > 180){
            angle -= 360;
        }
        while(angle < -180){
            angle += 360;
        }
        return angle;
    }

    @Override
    public String toString(){       // pass the angle value
        return "RobotLocation: angle (" + angle + ")";
    }

    public void turn(double angleChange){       // specify how much to turn
        angle += angleChange;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public double getAngle(){
        return angle;
    }

    public double getX() {
        return x;
    }

    public void changeX(double change){
        x += change;
    }

    public void setX(double x) {
        this.x = x;
    }
}
