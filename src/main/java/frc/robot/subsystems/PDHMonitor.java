// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Class that collects data from PDH and records it in logs and sends it to Dashboard
 */
public class PDHMonitor extends SubsystemBase {
  PowerDistribution m_pdh = new PowerDistribution(1, ModuleType.kRev);

  /** Creates a new PDHMonitor. */
  public PDHMonitor() {  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
