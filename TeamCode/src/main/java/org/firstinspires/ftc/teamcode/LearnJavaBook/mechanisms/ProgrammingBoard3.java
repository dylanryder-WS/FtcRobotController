package org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ProgrammingBoard3 {
    private DigitalChannel touchSensor;
    private DcMotor pringlesDcMotor; // the single DC Motor on the programmer's rig
    private double ticksPerRotation;

    public void init(HardwareMap hwMap){
        touchSensor = hwMap.get(DigitalChannel.class, "touchSensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        pringlesDcMotor = hwMap.get(DcMotor.class, "motor");
        pringlesDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRotation = pringlesDcMotor.getMotorType().getTicksPerRev(); // stores the number of encoder ticks per revolution based on the motor selected in the config
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
}
