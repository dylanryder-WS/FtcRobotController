package org.firstinspires.ftc.teamcode.LearnJavaBook.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms.ProgrammingBoard5;
import org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms.ProgrammingBoard6;

@TeleOp()
public class PotentiometerOpMode extends OpMode {
    ProgrammingBoard6 board = new ProgrammingBoard6();
    @Override
    public void init() {
        board.init(hardwareMap);    // read the config file
    }

    @Override
    public void loop(){
        double potentiometerValue = board.getPotentiometerRange();

        telemetry.addData("Potentiometer Angle", board.getPotentiometerAngle());
        telemetry.addData("Potentiometer Range", potentiometerValue);

        board.setServoPosition(potentiometerValue);
    }
}
