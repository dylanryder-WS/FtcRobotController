package org.firstinspires.ftc.teamcode.LearnJavaBook;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamepadOpMode extends OpMode{
    @Override
    public void init(){
            }

    public void loop(){
        double stickDifference = gamepad1.left_stick_y - gamepad1.right_stick_y;
        double triggerSum = gamepad1.right_trigger + gamepad1.left_trigger;

        telemetry.addData("Right stick x", gamepad1.right_stick_x);
        telemetry.addData("Button B status", gamepad1.b);
        telemetry.addData("Stick Y difference", stickDifference);
        telemetry.addData("LR trigger sum", triggerSum);

    }
}
