package mars

import direction._

case class MarsRover(x: Int, y: Int, direction: Direction) {

  def moveForward: MarsRover = direction match {
    case North => this.copy(y = y + 1)
    case East => this.copy(x = x + 1)
    case South => this.copy(y = y - 1)
    case West => this.copy(x = x - 1)
  }

}