package rover.navigation

import rover.MarsRover

sealed trait NavigationSystem {
  def findShortestPath(rover: MarsRover, destination: Coordinate): Option[Seq[Instruction]]
}

case object CityBlockNavigator extends NavigationSystem {

  def findShortestPath(rover: MarsRover, destination: Coordinate): Option[Seq[Instruction]] = {
      def loop(rover: MarsRover, destination: Coordinate, acc: Seq[Instruction]): Option[Seq[Instruction]] = {
        val deltaZero = rover.position.delta(destination)
        if (deltaZero == (0, 0)) Some(acc)
        else {
          val simulatedRovers = simulate(rover)
          val maybeNext: Option[(MarsRover, Seq[Instruction])] = simulatedRovers.collectFirst {
            case (simulatedRover, instructions) if isCloser(destination, deltaZero, simulatedRover) => {
              (simulatedRover, instructions)
            }
          }
          maybeNext.flatMap { case (r: MarsRover, i: Seq[Instruction]) =>
            loop(r, destination, acc ++ i)
          }
        }
      }
    loop(rover, destination, Seq.empty)
  }

  private def isCloser(destination: Coordinate, deltaZero: (Int, Int), simulatedRover: MarsRover) = {
    val deltaCurrent = simulatedRover.position.delta(destination)
    deltaCurrent._1 < deltaZero._1 || deltaCurrent._2 < deltaZero._2
  }

  private def simulate(rover: MarsRover): Stream[(MarsRover, Seq[Instruction])] = {
    Stream.fill(nextSteps.length)(rover).zip(nextSteps).map { case (simulatedRover, instructions) =>
      (MarsRover.process(simulatedRover, instructions), instructions)
    }
  }

  private val nextSteps: Stream[Seq[Instruction]] = Stream(
      Seq(MoveForward),
      Seq(RotateClockwise, MoveForward),
      Seq(RotateAnticlockwise, MoveForward),
      Seq(RotateClockwise, RotateClockwise, MoveForward)
  )

}