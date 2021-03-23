package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

public class RobotMap{
    public static final int LEFT_FRONT_PORT = 3;  
    public static final int LEFT_BACK_PORT = 4;
    public static final int RIGHT_FRONT_PORT = 1;
    public static final int RIGHT_BACK_PORT = 2;
    //assigns port numbers to each port
    public static WPI_TalonFX leftFrontMotor = new WPI_TalonFX(LEFT_FRONT_PORT); //setting instance of the left front Motor
    public static WPI_TalonFX rightFrontMotor = new WPI_TalonFX(RIGHT_FRONT_PORT); //setting instance of the right front Motor
    public static WPI_TalonFX leftBackMotor = new WPI_TalonFX(LEFT_BACK_PORT); //setting instance of the left back Motor
    public static WPI_TalonFX rightBackMotor = new WPI_TalonFX(RIGHT_BACK_PORT); //setting instance of the right back Motor

    public static PigeonIMU arm_imu = new PigeonIMU(0); //setting instance of pigeon imu to 0
    public static PigeonIMU drive_imu = new PigeonIMU(1); //setting instance of pigeon imu to 1

    

}