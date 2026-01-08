// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterIO;
import frc.robot.subsystems.ShooterIOHardware;
import frc.robot.subsystems.ShooterIOSim;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {

  private final ShooterIO simIO = new ShooterIOSim();
  private final ShooterIO realIO = new ShooterIOHardware();

  private final ShooterSubsystem shooterSubsystem;

  public RobotContainer() {

    if (Robot.isReal()) {
      shooterSubsystem = new ShooterSubsystem(realIO);
    } else {
      shooterSubsystem = new ShooterSubsystem(simIO);
    }

    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
