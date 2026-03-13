package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Demo Mecanum Drive", group="Drive")
public class DemoMecanumDrive extends OpMode {

    // DOES NOT YET WORK PROPERLY 3-12-2026

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    @Override
    public void init() {
        frontLeftMotor  = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        backLeftMotor   = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRightMotor  = hardwareMap.get(DcMotor.class, "backRightMotor");

        // Reverse left side motors (common for mecanum)
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Brake when sticks are released
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {

        // Gamepad inputs
        double y = -gamepad1.left_stick_y;   // Forward/backward
        double x = -gamepad1.left_stick_x;    // Strafe
        double rx = -gamepad1.right_stick_x;  // Rotation

        // Mecanum math
        double frontLeftPower  = -(x-y+rx);
        double backLeftPower   = -(x+y+rx);
        double frontRightPower = -(x+y-rx);
        double backRightPower  = -(x-y-rx);

        // Normalize powers so no value exceeds 1.0
//        double max = Math.max(
//                Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower)),
//                Math.max(Math.abs(frontRightPower), Math.abs(backRightPower))
//        );
//
//        if (max > 1.0) {
//            frontLeftPower  /= max;
//            backLeftPower   /= max;
//            frontRightPower /= max;
//            backRightPower  /= max;
//        }

        // Set motor powers
        frontLeftMotor.setPower(frontLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backLeftMotor.setPower(backLeftPower);
        backRightMotor.setPower(backRightPower);

        // Telemetry
        telemetry.addData("FL", frontLeftPower);
        telemetry.addData("FR", frontRightPower);
        telemetry.addData("BL", backLeftPower);
        telemetry.addData("BR", backRightPower);
        telemetry.update();
    }
}
