package mars

import direction.Direction.{East, North, South, West}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import rover.MarsRover

class MarsRoverSpec extends AnyFlatSpec with Matchers {

  "moveForward" should "only increment the y coordinate when facing North" in {
    val rover = MarsRover(0, 0, North)
    val movedRover = rover.moveForward

    movedRover.x shouldBe rover.x
    movedRover.y shouldBe 1
    movedRover.direction shouldBe rover.direction
  }

  it should "only increment the x coordinate when facing East" in {
    val rover = MarsRover(0, 0, East)
    val movedRover = rover.moveForward

    movedRover.x shouldBe 1
    movedRover.y shouldBe rover.y
    movedRover.direction shouldBe rover.direction
  }

  it should "only decrement the y coordinate when facing South" in {
    val rover = MarsRover(0, 0, South)
    val movedRover = rover.moveForward

    movedRover.x shouldBe rover.x
    movedRover.y shouldBe -1
    movedRover.direction shouldBe rover.direction
  }

  it should "only decrement the x coordinate when facing West" in {
    val rover = MarsRover(0, 0, West)
    val movedRover = rover.moveForward

    movedRover.x shouldBe -1
    movedRover.y shouldBe rover.y
    movedRover.direction shouldBe rover.direction
  }

  it should "wrap around the grid East to West" in {
    val rover = MarsRover(Int.MaxValue, 0, East)
    val movedRover = rover.moveForward

    movedRover.x shouldBe Int.MinValue
    movedRover.y shouldBe rover.y
    movedRover.direction shouldBe rover.direction
  }

  it should "wrap around the grid West to East" in {
    val rover = MarsRover(Int.MinValue, 0, West)
    val movedRover = rover.moveForward

    movedRover.x shouldBe Int.MaxValue
    movedRover.y shouldBe rover.y
    movedRover.direction shouldBe rover.direction
  }

  it should "wrap around the grid North to South" in {
    val rover = MarsRover(0, Int.MaxValue, North)
    val movedRover = rover.moveForward

    movedRover.x shouldBe rover.x
    movedRover.y shouldBe Int.MinValue
    movedRover.direction shouldBe rover.direction
  }

  it should "wrap around the grid South to North" in {
    val rover = MarsRover(0, Int.MinValue, South)
    val movedRover = rover.moveForward

    movedRover.x shouldBe rover.x
    movedRover.y shouldBe Int.MaxValue
    movedRover.direction shouldBe rover.direction
  }

  "rotateClockwise" should "return a rover facing East given a rover facing North" in {
    val rover = MarsRover(0, 0, North)
    val rotatedRover = rover.rotateClockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe East
  }

  it should "return a rover facing South given a rover facing East" in {
    val rover = MarsRover(0, 0, East)
    val rotatedRover = rover.rotateClockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe South
  }

  it should "return a rover facing West given a rover facing South" in {
    val rover = MarsRover(0, 0, South)
    val rotatedRover = rover.rotateClockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe West
  }

  it should "return a rover facing North given a rover facing West" in {
    val rover = MarsRover(0, 0, West)
    val rotatedRover = rover.rotateClockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe North
  }

  "rotateAnticlockwise" should "return a rover facing West given a rover facing North" in {
    val rover = MarsRover(0, 0, North)
    val rotatedRover = rover.rotateAnticlockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe West
  }

  it should "return a rover facing North given a rover facing East" in {
    val rover = MarsRover(0, 0, East)
    val rotatedRover = rover.rotateAnticlockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe North
  }

  it should "return a rover facing East given a rover facing South" in {
    val rover = MarsRover(0, 0, South)
    val rotatedRover = rover.rotateAnticlockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe East
  }

  it should "return a rover facing South given a rover facing West" in {
    val rover = MarsRover(0, 0, West)
    val rotatedRover = rover.rotateAnticlockwise

    rotatedRover.y shouldBe rover.y
    rotatedRover.x shouldBe rover.x
    rotatedRover.direction shouldBe South
  }

}
