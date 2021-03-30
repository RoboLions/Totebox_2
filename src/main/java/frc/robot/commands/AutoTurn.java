// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoTurn extends CommandBase {
  private final DriveTrain drivetrain;
  private double initial_heading;
  private double target_heading;


  /** Creates a new AutoMove. */
  public AutoTurn(final DriveTrain train, double heading, double speed) {
    drivetrain = train;
    addRequirements(drivetrain);
    drivetrain.ZeroYaw();
    initial_heading = drivetrain.getYaw();
    target_heading = heading;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public AutoTurn(final DriveTrain train, double heading){
    drivetrain = train;
    addRequirements(train);
    drivetrain.ZeroYaw();
    initial_heading = drivetrain.getYaw();
    target_heading = heading;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.ZeroYaw();
   // drivetrain.state_flag_motion_profile = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.drive(0.0, target_heading);
    System.out.println("drive works");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double current_heading = drivetrain.getYaw() - initial_heading;
    double headingError = Math.abs(target_heading - current_heading);
    return (headingError < 0.2);
    //return(tempReturn)
  }

  public enum Mode {
    DISTANCE, TIME
  }
}

