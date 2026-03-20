package org.firstinspires.ftc.teamcode.LearnJavaBook.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms.ProgrammingBoard3;

@TeleOp()
public class MotorGamePadOpMode extends OpMode {
    ProgrammingBoard3 board = new ProgrammingBoard3();
    @Override
    public void init() {
        board.init(hardwareMap);    // read the config file
    }

    double squareInputWithSign(double input){
        double output = input * input;
        if (input < 0){
            output = output * -1;
        }
        return output;
    }

    @Override
    public void loop(){
        double motorSpeed = squareInputWithSign(gamepad1.left_stick_y) ; // calculate motor speed from joystick input
        String touchSensorString = "Not Pressed";


        board.setMotorSpeed(motorSpeed);    // apply motor speed to the motor
        telemetry.addData("Speed", motorSpeed);

        if (gamepad1.a){
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            telemetry.addData("Zero", "Brake");
        } else if (gamepad1.b) {
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            telemetry.addData("Zero", "Float");
        }

        if(board.isTouchSensorPressed()){   // if the touch sensor is pressed, activate the motor
            touchSensorString = "Pressed";
        }
        telemetry.addData("Touch sensor pressed", touchSensorString);
        telemetry.addData("Motor rotations", board.getMotorRotations());
    }
}
