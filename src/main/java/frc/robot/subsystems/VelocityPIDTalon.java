// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VelocityPIDTalon extends SubsystemBase {
  private TalonFX m_motor = new TalonFX(51);

  /** Creates a new VelocityPDITalon. */
  public VelocityPIDTalon() {
    SmartDashboard.putData("Talon PID", m_motor);
  }

  public void spin(double speed){
    m_motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
