package mars

import direction.{East, North, South, West}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MarsRoverSpec extends AnyFlatSpec with Matchers {

  "moveForward" should "only increment the y coordinate when facing North" in {
    val rover = MarsRover(0, 0, North)
    val movedRover = rover.moveForward
    val expectedY = 1
    val actualY = movedRover.y

    movedRover.x shouldBe rover.x
    actualY shouldBe expectedY
    movedRover.direction shouldBe rover.direction
  }

  "moveForward" should "only increment the x coordinate when facing East" in {
    val rover = MarsRover(0, 0, East)
    val movedRover = rover.moveForward
    val expectedX = 1
    val actualX = movedRover.x

    actualX shouldBe expectedX
    movedRover.y shouldBe rover.y
    movedRover.direction shouldBe rover.direction
  }

  "moveForward" should "only decrement the y coordinate when facing South" in {
    val rover = MarsRover(0, 0, South)
    val movedRover = rover.moveForward
    val expectedY = -1
    val actualY = movedRover.y

    movedRover.x shouldBe rover.x
    actualY shouldBe expectedY
    movedRover.direction shouldBe rover.direction
  }

  "moveForward" should "only decrement the x coordinate when facing West" in {
    val rover = MarsRover(0, 0, West)
    val movedRover = rover.moveForward
    val expectedX = -1
    val actualX = movedRover.x

    actualX shouldBe expectedX
    movedRover.y shouldBe rover.y
    movedRover.direction shouldBe rover.direction
  }

}
