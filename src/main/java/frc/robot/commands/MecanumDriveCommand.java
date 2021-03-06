/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MecanumDriveCommand extends Command {
  public MecanumDriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.dt);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Robot.dt.setThrottle(RobotMap.kHighThrottle);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Robot.dt.feed();
    Robot.dt.DriveMecanumGeneric(
      -Robot.m_oi.DriveX() * 0.75,
      Robot.m_oi.DriveY() * Robot.dt.getThrottle(),
      -Robot.m_oi.DriveTwist() * 0.7
    );
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
