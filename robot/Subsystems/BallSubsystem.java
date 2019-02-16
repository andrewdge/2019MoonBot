/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
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

  DoubleSolenoid ballinout = new DoubleSolenoid(IO.armIn, IO.armOut);
  Solenoid delivery = new Solenoid(IO.delivery);
  Servo ballServo = new Servo(IO.ballServo);
  WPI_VictorSPX intake = new WPI_VictorSPX(IO.motorBeaterBar);
  
  
  


  public BallSubsystem(){};

  public BallSubsystem(Robot robotInstance){
    robot = robotInstance;
  }

  //Arm piston
  public void pistonArmIN(){
      ballinout.set(DoubleSolenoid.Value.kForward);
  }

  public void pistonArmOUT(){
      ballinout.set(DoubleSolenoid.Value.kReverse);
  }

  //ball deliverer
  public void delivererIN(){
      delivery.set(true);
  }

  public void delivererOUT(){
      delivery.set(false);
  }

  

  //ball flap
  public void ballTrapOpen(){
      ballServo.set(0.0);
  }

  public void ballTrapClose(){
      ballServo.set(1.0);
  }

  public void ballTrapStop(){
      ballServo.stopMotor();
  }

  
  //beater bar
  public void beaterForward(){
      intake.set(1.0);
  }

  public void beaterReverse(){
      intake.set(-1.0);
  }

  public void beaterStop(){
      intake.stopMotor();
  }

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new BallPushCommand(robot));
    
    
  }
}
