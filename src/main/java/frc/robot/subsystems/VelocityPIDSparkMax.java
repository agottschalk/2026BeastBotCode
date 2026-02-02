// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Class that holds a motor at a constant speed, controlled by a SparkMax
 */
@Logged
public class VelocityPIDSparkMax extends SubsystemBase {
  private SparkMax m_motor = new SparkMax(50, MotorType.kBrushless);

  /** Creates a new VelocityPIDSparkMax. */
  public VelocityPIDSparkMax() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void initSendable(SendableBuilder builder){
    builder.setSmartDashboardType(getName());
    builder.addDoubleProperty("Speed", m_motor::get, null);
    builder.addDoubleProperty("Temperature", m_motor::getMotorTemperature, null);
  }
}
