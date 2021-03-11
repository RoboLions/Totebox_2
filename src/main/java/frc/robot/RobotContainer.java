package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.SubSystems.DriveTrain;

public class RobotContainer {
    private final DriveTrain DriveTrain  = new DriveTrain();
    public static XboxController driveController = new XboxController(0);

}
