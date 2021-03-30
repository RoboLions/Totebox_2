// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoMove extends CommandBase {
  private final DriveTrain drivetrain;
  private double start_dist_meters;
  private double target_distance;


  /** Creates a new AutoMove. */
  public AutoMove(final DriveTrain train, Mode mode, double distance_in_meters, double speed) {
    drivetrain = train;
    addRequirements(drivetrain);
    start_dist_meters = drivetrain.distanceTravelledInMeters();
    target_distance = distance_in_meters;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public AutoMove(final DriveTrain train, double distance){
    drivetrain = train;
    addRequirements(drivetrain);
    start_dist_meters = drivetrain.distanceTravelledInMeters();
    target_distance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.resetEncoders();
    drivetrain.ZeroYaw();
    start_dist_meters = drivetrain.distanceTravelledInMeters();
   // drivetrain.state_flag_motion_profile = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.drive(target_distance, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double distance_driven = drivetrain.distanceTravelledInMeters() - start_dist_meters;
    double positionError = Math.abs(target_distance - distance_driven);
    return (positionError < 0.01);
  }

  public enum Mode {
    DISTANCE, TIME
  }
}
