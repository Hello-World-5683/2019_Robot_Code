/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class RumbleCommand extends Command {
  double diff;
  double duration;
  double endTime;

  public RumbleCommand() {
    // Use requires() here to declare subsystem dependencies
    diff = Math.abs(Robot.ultraSys.UltraConversion(Robot.ultraSys.Ultra1) 
      - Robot.ultraSys.UltraConversion(Robot.ultraSys.Ultra2));
    duration = 2000.0;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Starting... Current time: " + System.currentTimeMillis());
    endTime = System.currentTimeMillis() + duration;
    System.out.println("End time: " + endTime);
    Robot.m_oi.setDualRumble(1);
    System.out.println("Begin rumble... Current time: " + System.currentTimeMillis());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() > endTime;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Ended. Stopping rumble. Curent time: " + System.currentTimeMillis());
    Robot.m_oi.setDualRumble(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
