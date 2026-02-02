// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.VelocityPIDSparkMax;
import frc.robot.subsystems.VelocityPIDTalon;

public class RobotContainer {
  private PowerDistribution m_pdh = new PowerDistribution(1, ModuleType.kRev);
  private Swerve swerveDrive = new Swerve();
  private VelocityPIDSparkMax m_velPID = new VelocityPIDSparkMax();
  private VelocityPIDTalon m_velPIDTalon = new VelocityPIDTalon();
  private CommandXboxController driveController = new CommandXboxController(0);
  
  public RobotContainer() {
    SmartDashboard.putData(CommandScheduler.getInstance());
    SmartDashboard.putData("PDH", m_pdh);
    SmartDashboard.putData("Velocity PID", m_velPID);
    setDefaultCommands();
    configureBindings();
  }

  private void configureBindings() {
    driveController.a().whileTrue(new RunCommand(() -> m_velPIDTalon.spin(0.5), m_velPIDTalon));
  }

  private void setDefaultCommands(){
    swerveDrive.setDefaultCommand(new Drive(
      ()->driveController.getLeftX(),
      ()->driveController.getLeftY(),
      ()->driveController.getRightX(),
      swerveDrive
    ));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
