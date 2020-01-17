package rover

import direction.Direction
import direction.Direction.{East, North, South, West}
import rover.navigation.{Coordinate, Instruction, MoveForward, RotateAnticlockwise, RotateClockwise}

import scala.annotation.tailrec

object MarsRover {

  @tailrec
  def process(marsRover: MarsRover, instructions: Seq[Instruction]): MarsRover = {
    if (instructions.isEmpty) marsRover
    else instructions.head match {
      case MoveForward => process(marsRover.moveForward, instructions.tail)
      case RotateAnticlockwise => process(marsRover.rotateAnticlockwise, instructions.tail)
      case RotateClockwise => process(marsRover.rotateClockwise, instructions.tail)
    }
  }
}

case class MarsRover(x: Int, y: Int, direction: Direction) {

  val position: Coordinate = Coordinate(x, y)

  def moveForward: MarsRover = direction match {
    case North => this.copy(y = y + 1)
    case East => this.copy(x = x + 1)
    case South => this.copy(y = y - 1)
    case West => this.copy(x = x - 1)
  }

  def rotateClockwise: MarsRover = this.copy(direction = Direction.clockwise(direction))

  def rotateAnticlockwise: MarsRover = this.copy(direction = Direction.anticlockwise(direction))

}
