/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeCommand extends Command {

  int ticks = -1;

  public IntakeCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.intakeSys);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double position;  
      if (Robot.intakeSys.isAtZero) {
        position = Robot.intakeSys.moveToTarget(2048);
        SmartDashboard.putString("Intake_Pos", "Up");
      } else {
        position = Robot.intakeSys.moveToTarget(0);
        SmartDashboard.putString("Intake_Pos", "Down");
      }
      Robot.intakeSys.printer(position);
 }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
    //return Robot.intakeSys.getError(Robot.intakeSys.intake) == 0;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
