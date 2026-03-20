package org.firstinspires.ftc.teamcode.LearnJavaBook.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms.ProgrammingBoard3;

@TeleOp()
public class MotorOpMode extends OpMode {
    ProgrammingBoard3 board = new ProgrammingBoard3();
    @Override
    public void init() {
        board.init(hardwareMap);    // read the config file
    }

    @Override
    public void loop(){
        String touchSensorString = "Not Pressed";

        if(board.isTouchSensorPressed() || gamepad1.a){   // if the touch sensor is pressed, activate the motor
            touchSensorString = "Pressed";
            board.setMotorSpeed(0.5);
        }
        else {  // or else deactivate the motor
            board.setMotorSpeed(0.0);
        }
        telemetry.addData("Touch sensor pressed", touchSensorString);
        telemetry.addData("Motor rotations", board.getMotorRotations());
    }
}
