package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class JoystickDrive extends CommandBase {
    private final DriveTrain driveTrain;
    private final static XboxController driverController = RobotContainer.driveController;
    
    public JoystickDrive(DriveTrain dt) {
        driveTrain = dt;
        addRequirements(driveTrain);
    }

    public void execute() {
        double throttle = driverController.getY(Hand.kLeft);
        double rotate = driverController.getX(Hand.kRight);

        if(Math.abs(throttle) < 0.25) {
            throttle = 0;
        }

        if(Math.abs(rotate) < 0.25) {
            rotate = 0;
        } else {
            rotate *= 2;
        }

        if(driverController.getTriggerAxis(Hand.kRight) > 0.25) {
            throttle = Math.signum(throttle) * 0.75; // Slow Mode
        } else if(driverController.getAButton()) {
            throttle *= 1.1; // Fast Mode
        } else {
            throttle *= 0.8; // Normal Mode
        }

        driveTrain.drive(throttle, rotate);

    }

}
