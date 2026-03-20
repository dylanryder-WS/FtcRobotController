package org.firstinspires.ftc.teamcode.LearnJavaBook;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfOpmode extends OpMode {

    @Override
    public void init(){
    }

    @Override
    public void loop(){
        double forwardSpeed = gamepad1.left_stick_y;
        double reportedX = gamepad1.left_stick_x;
        double reportedY = gamepad1.left_stick_y;


        // 1. Turbo button
        if (!gamepad1.a) {
            forwardSpeed *= 0.5;
        }
        telemetry.addData("Turbo", gamepad1.a);
        telemetry.addData("Speed", forwardSpeed);

        // 2. "crazy mode"
        if (gamepad1.b){
            reportedX = gamepad1.left_stick_y;
            reportedY = gamepad1.left_stick_x;
            telemetry.addData("Crazy Mode", "ON!");
        }
        telemetry.addData("X", reportedX);
        telemetry.addData("Y", reportedY);
    }
}
