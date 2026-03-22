package org.firstinspires.ftc.teamcode.LearnJavaBook.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms.ProgrammingBoard5;

@TeleOp()
public class ServoGamePadOpMode extends OpMode {
    ProgrammingBoard5 board = new ProgrammingBoard5();
    @Override
    public void init() {
        board.init(hardwareMap);    // read the config file
    }

    @Override
    public void loop(){
        /*
        if (gamepad1.a) {
           board.setServoPosition(1.0);
       } else if (gamepad1.b) {
           board.setServoPosition(0.0);
       } else {
           board.setServoPosition(0.5);
       }

         */

       board.setServoPosition(gamepad1.left_trigger);
    }
}
