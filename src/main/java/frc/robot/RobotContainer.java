package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.JoystickDrive;

public class RobotContainer {
    public final DriveTrain driveTrain  = new DriveTrain();
    public static XboxController driveController = new XboxController(0);

    public RobotContainer() {

        configureButtonBindings();

        driveTrain.setDefaultCommand(
            new JoystickDrive(driveTrain)
        );

    }

    public void configureButtonBindings() {

    }
}
