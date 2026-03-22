package org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class ProgrammingBoard6 {
    private DigitalChannel touchSensor;
    private DcMotor pringlesDcMotor; // the single DC Motor on the programmer's rig
    private double ticksPerRotation;
    private Servo servo;
    private AnalogInput potentiometer;

    public void init(HardwareMap hwMap){
        touchSensor = hwMap.get(DigitalChannel.class, "touchSensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        pringlesDcMotor = hwMap.get(DcMotor.class, "motor");
        pringlesDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRotation = pringlesDcMotor.getMotorType().getTicksPerRev(); // stores the number of encoder ticks per revolution based on the motor selected in the config
        servo = hwMap.get(Servo.class, "servo");
        servo.setDirection(Servo.Direction.REVERSE);
        //servo.scaleRange(-1.0, 0.5); // constrains the servo range of motion to left to middle position
        potentiometer = hwMap.get(AnalogInput.class, "potentiometer");
    }

    public boolean getTouchSensorState(){
        return touchSensor.getState();
    }

    public boolean isTouchSensorPressed(){
        return !touchSensor.getState();
    }

    public void setMotorSpeed(double speed){
        pringlesDcMotor.setPower(speed);
    }

    public double getMotorRotations(){
        return pringlesDcMotor.getCurrentPosition() / ticksPerRotation; // divide the number of ticks by the number of ticks in a revolution
    }

    public void setMotorZeroBehavior(DcMotor.ZeroPowerBehavior zeroBehavior){
        pringlesDcMotor.setZeroPowerBehavior(zeroBehavior);
    }

    public void setServoPosition(double position){
        servo.setPosition(position);
    }

    public double getPotentiometerAngle(){
        return Range.scale(potentiometer.getVoltage(), 0, potentiometer.getMaxVoltage(), 0, 270);
    }

    public double getPotentiometerRange(){
        return Range.scale(potentiometer.getVoltage(), 0, potentiometer.getMaxVoltage(), 0, 1.0);
    }

}
