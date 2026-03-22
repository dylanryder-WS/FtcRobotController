package org.firstinspires.ftc.teamcode.LearnJavaBook.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms.ProgrammingBoard8;

@TeleOp()
public class GyroOpMode extends OpMode {
    ProgrammingBoard8 board = new ProgrammingBoard8();
    @Override
    public void init() {
        board.init(hardwareMap);    // read the config file
    }

    @Override
    public void loop(){
        telemetry.addData("Our Heading: ", board.getHeading(AngleUnit.DEGREES));
        board.setServoPosition(gamepad1.left_trigger);
    }
}
