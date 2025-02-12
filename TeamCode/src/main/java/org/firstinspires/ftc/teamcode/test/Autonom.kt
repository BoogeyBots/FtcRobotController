package org.firstinspires.ftc.teamcode.test

import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive

/*
* This is an example of a more complex path to really test the tuning.
*/
@Autonomous(group = "drive")
class SplineTest : LinearOpMode() {

    override fun runOpMode() {
        val drive = SampleMecanumDrive(hardwareMap)


        waitForStart()

        if (isStopRequested) return

        val traj = drive.trajectoryBuilder(Pose2d())
                .splineTo(Vector2d(30.0, 30.0), 0.0)
                .build()
        drive.followTrajectory(traj)

        sleep(2000)

        drive.followTrajectory(
                drive.trajectoryBuilder(traj.end(), true)
                        .splineTo(Vector2d(0.0, 0.0), Math.toRadians(180.0))
                        .build()
        )

    }
}