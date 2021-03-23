package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.JoystickDrive;

public class RobotContainer {
    public final DriveTrain driveTrain  = new DriveTrain(); //initializing the drive train
    public static XboxController driveController = new XboxController(0); //initializing the drive controller on the xbox controller

    public RobotContainer() {

        configureButtonBindings(); //setting up the buttons on the xbox controller to the default

        driveTrain.setDefaultCommand( //sets the default command for the drivetrain
            new JoystickDrive(driveTrain) //plugs the drive train into the joystick drive constructor so that requirements can be added
        );

    }

    public void configureButtonBindings() { 
        //sets autonomous path 
    }
}
