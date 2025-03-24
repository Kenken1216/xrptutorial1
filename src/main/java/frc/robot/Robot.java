// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// My added imports 
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;  //Any drivetrain runs motors when turning at different rates and directions 
import edu.wpi.first.wpilibj.Timer;   // Stop watch 

// For teleop mode (controller mode)
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.xrp.XRPServo; // Servo

/**
 * The in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // Add 4 motors, use 2 motors for testing 
  private final XRPMotor leftDrive = new XRPMotor(0);
  private final XRPMotor rightDrive = new XRPMotor(1); 

  // From Imports of Drivetrain and timer
  private final DifferentialDrive mDrive = new DifferentialDrive(leftDrive, rightDrive); 
  private final Timer mTimer = new Timer(); 

  // From Imports of Servo
  private final XRPServo backServo = new XRPServo(4); // Port 4, from wpi documentation 

  // From Imports for use of Xbox Controller 
  private final XboxController mController = new XboxController(0); 

  // This variable controls the max speed of robot 
  double driveSpeed = 1; 
 
  


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    // Multiplies all of the drive by (-1)
    // If true = Inverts the motor
    // If false = Does not invert motor
    rightDrive.setInverted(true);  
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    mTimer.start();
    mTimer.reset(); 

   
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        // Note: Default auto mode runs if you dont select anything
        //leftDrive.set(.6);    // Forward
        //rightDrive.set(.6);   // Forward

        // Replacement for left and right drive.set above with tankDrive
        if(mTimer.get() < 2.65){ // If stopwatch is < 2.65 second, drive forward aprox. 20 inches
          mDrive.tankDrive(.6, .6);
          backServo.setAngle(90);
        }
        else if (mTimer.get() < 3.15){ // Turn 90 degrees right, so the back is facing you
          mDrive.tankDrive(.7,-.7); // Left motor forward, right motor backwards 
        }
        else if (mTimer.get() < 6){ // Back up
          mDrive.tankDrive(-.5, -.5); // Left and right motor backwards
        }
        else { // Else more than 2.65 second then stop driving forward; last step 
          mDrive.tankDrive(0,0);
        }
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // Left and Right Joystick forward/backwards on robot and up/down on Joystick
    //mDrive.tankDrive(-mController.getLeftY(), -mController.getRightY()); 
    
    if (mController.getRightBumperButton()){ // Original speed when pressed
      driveSpeed = 1; 
    }
    else if (mController.getLeftBumperButton()){ // Slower speed when pressed
      driveSpeed = .6; 
    }
  

    // Left Joystick is forward/backwards on robot and up/down on joystick 
    // Right Joystick is right/left on robot and right/left on joystick 
    mDrive.arcadeDrive(-mController.getLeftY() * driveSpeed, -mController.getRightX() * driveSpeed); 

    if (mController.getAButton() == true){
      backServo.setPosition(1);
    }
    else if (mController.getXButton()){
      backServo.setPosition(.5);
    }
    else if (mController.getYButton()){
      backServo.setPosition(0);
    }
}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
