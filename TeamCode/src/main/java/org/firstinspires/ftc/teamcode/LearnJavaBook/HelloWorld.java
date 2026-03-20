package org.firstinspires.ftc.teamcode.LearnJavaBook;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HelloWorld extends OpMode {

    // This is when the driver presses INIT on the Driver Station
    @Override
    public void init(){
        // This sends telemetry to the Driver Station
        telemetry.addData("Hello", "World");
    }

    // This loop runs repeatedly while OpMode is playing
    @Override
    public void loop(){
        // intentionally left blank
    }
}

