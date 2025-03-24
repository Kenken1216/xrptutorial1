# First Robotics Competition Test 1

This project contains Java code developed for the FIRST Robotics Competition (FRC). It demonstrates both autonomous and teleoperated control modes for a robot, utilizing WPILib libraries.

## Overview

The codebase includes:

- **Autonomous Mode**: Executes a predefined sequence of movements.
- **Teleoperated Mode**: Allows manual control via an Xbox controller.

Key components:

- **Differential Drive**: Manages the robot's drivetrain.
- **XRPMotors**: Controls the left and right motors.
- **XRPServo**: Operates the servo mechanism.
- **XboxController**: Handles user input for teleoperation.

## Features

**Autonomous Routine:**
- Drive forward for approximately 20 inches.
- Execute a 90-degree right turn.
- Reverse for a specified distance.
- Control the servo position during movements.

**Teleoperated Controls:**
- *Left Joystick*: Forward and backward movement.
- *Right Joystick*: Rotational movement.
- *Right Bumper*: Sets driving speed to full.
- *Left Bumper*: Reduces driving speed to 60%.
- *Button A*: Sets servo to position 1.
- *Button X*: Sets servo to position 0.5.
- *Button Y*: Sets servo to position 0.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- WPILib (https://docs.wpilib.org)
- Java Development Kit (JDK)
- Visual Studio Code with WPILib extension

### Installation

1. Clone the repository:
   
       git clone https://github.com/yourusername/First-Robotics-Competition-Test-1.git

2. Open the project in Visual Studio Code.

3. Use the WPILib Command Palette:
   - Set your team number.
   - Configure build and deploy options.

4. Build the project using WPILib tools.

## Usage

- **Autonomous Mode**: Runs the default pre-programmed sequence.
- **Teleop Mode**: Use the Xbox controller to drive and control the servo.

## Contributing

1. Fork the repository.
2. Create a branch:  
   
       git checkout -b feature/YourFeature

3. Commit your changes:  
   
       git commit -m "Add feature"

4. Push to GitHub:  
   
       git push origin feature/YourFeature

5. Open a Pull Request.

## License

This project is licensed under the WPILib BSD license. See the `LICENSE` file for more info.

## Acknowledgments

- WPILib and FIRST for tools and documentation.
- FRC community for ongoing support.


