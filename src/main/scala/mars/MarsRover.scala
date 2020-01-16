package mars

import direction.Direction.{East, North, South, West}
import direction._

case class MarsRover(x: Int, y: Int, direction: Direction) {

  def moveForward: MarsRover = direction match {
    case North => this.copy(y = y + 1)
    case East => this.copy(x = x + 1)
    case South => this.copy(y = y - 1)
    case West => this.copy(x = x - 1)
  }

  def rotateClockwise: MarsRover = this.copy(direction = Direction.clockwise(direction))

  def rotateAnticlockwise: MarsRover = this.copy(direction = Direction.anticlockwise(direction))

}