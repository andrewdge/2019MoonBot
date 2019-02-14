/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.Commands.BallPushCommand;

/**
 * Add your docs here.
 */
public class BallSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Robot robot;

  DoubleSolenoid ballinout = new DoubleSolenoid(IO.ballIn, IO.ballOut);
  Servo ballServo = new Servo(IO.ballServo);


  public BallSubsystem(){};

  public BallSubsystem(Robot robotInstance){
    robot = robotInstance;
  }

  public void pistonIN(){
      ballinout.set(Value.kForward);
  }

  public void pistonOUT(){
      ballinout.set(Value.kReverse);
  }

  public void ballTrapOpen(){
      ballServo.setSpeed(.5);
  }

  public void ballTrapClose(){
      ballServo.setSpeed(-.5);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new BallPushCommand(robot));
  }
}
