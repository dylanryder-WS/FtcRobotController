package org.firstinspires.ftc.teamcode.LearnJavaBook.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.LearnJavaBook.mechanisms.ProgrammingBoard1;
@TeleOp()
public class TouchSensorOpMode extends OpMode {
    ProgrammingBoard1 board = new ProgrammingBoard1();
    @Override
    public void init() {
        board.init(hardwareMap);    // read the config file
    }

    @Override
    public void loop(){
        telemetry.addData("Touch sensor status", board.getTouchSensorState());
        telemetry.addData("Touch sensor pressed?: ", board.isTouchSensorPressed());

        String touchSensorString = "Not Pressed";
        if (board.isTouchSensorPressed()){
            touchSensorString = "Pressed";
        }
        telemetry.addData("Touch sensor pressed", touchSensorString);
    }
}
