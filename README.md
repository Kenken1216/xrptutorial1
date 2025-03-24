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

- **Autonomous Routine**:
  - Drive forward for approximately 20 inches.
  - Execute a 90-degree right turn.
  - Reverse for a specified distance.
  - Control the servo position during movements.

- **Teleoperated Controls**:
  - **Left Joystick**: Forward and backward movement.
  - **Right Joystick**: Rotational movement.
  - **Right Bumper**: Sets driving speed to full.
  - **Left Bumper**: Reduces driving speed to 60%.
  - **Button A**: Sets servo to position 1.
  - **Button X**: Sets servo to position 0.5.
  - **Button Y**: Sets servo to position 0.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- [WPILib](https://docs.wpilib.org/en/stable/docs/zero-to-robot/step-2/wpilib-setup.html): The official library for FRC robot programming.
- Java Development Kit (JDK): Required for compiling and running Java code.
- [Visual Studio Code](https://code.visualstudio.com/): Recommended IDE for FRC development, with WPILib extension installed.

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/First-Robotics-Competition-Test-1.git

    Open the Project:

        Launch Visual Studio Code.

        Open the cloned repository folder.

    Set Up WPILib:

        Ensure the WPILib extension is installed in VS Code.

        Open the WPILib Command Palette and select "Set Team Number" to configure your team's number.

    Build the Project:

        Use the WPILib build commands to compile the code and deploy it to your robot.

Usage

    Autonomous Mode:

        The robot will execute the predefined sequence upon entering autonomous mode.

    Teleoperated Mode:

        Use the Xbox controller to manually control the robot as per the mappings described above.

Contributing

Contributions are welcome! Please follow these steps:

    Fork the repository.

    Create a new branch (git checkout -b feature/YourFeature).

    Commit your changes (git commit -m 'Add some feature').

    Push to the branch (git push origin feature/YourFeature).

    Open a pull request.

License

This project is licensed under the WPILib BSD license. See the LICENSE file for details.
Acknowledgments

    WPILib: For providing the libraries and tools necessary for FRC robot development.

    The FRC community for continuous support and resources.


