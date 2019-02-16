/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class BallPushCommand extends Command{

  private Robot robot;

  public BallPushCommand(){};

  public BallPushCommand(Robot robotInstance) {
    super();
    robot = robotInstance;
    requires(robot.ballSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //ball deploy
    if (Controls.getBumperLeft()){
      robot.ballSubsystem.pistonArmOUT();
    } else if(!Controls.getBumperLeft()){
      robot.ballSubsystem.pistonArmIN();
    }

    //servo flap
    if (Controls.getRightTriggerFlap()==0.0){
      robot.ballSubsystem.ballTrapClose();
    } else if (Controls.getRightTriggerFlap()==1.0){
      robot.ballSubsystem.ballTrapOpen();
    } else{
      robot.ballSubsystem.ballTrapStop();
    }

    //deliverer
    if (Controls.getBumperRight()){
      robot.ballSubsystem.delivererOUT();
    } else if (!Controls.getBumperRight()){
      robot.ballSubsystem.delivererIN();
    }

    //beater bar
    
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
