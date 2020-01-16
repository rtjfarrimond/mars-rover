package direction

import direction.Direction.{East, North, South, West}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DirectionSpec extends AnyFlatSpec with Matchers {

  "clockwise" should "return East given North" in {
    Direction.clockwise(North) shouldBe East
  }

  it should "return South given East" in {
    Direction.clockwise(East) shouldBe South
  }

  it should "return West given South" in {
    Direction.clockwise(South) shouldBe West
  }

  it should "return North given West" in {
    Direction.clockwise(West) shouldBe North
  }

  "anticlockwise" should "return West given North" in {
    Direction.anticlockwise(North) shouldBe West
  }

  it should "return North given East" in {
    Direction.anticlockwise(East) shouldBe North
  }

  it should "return East given South" in {
    Direction.anticlockwise(South) shouldBe East
  }

  it should "return South given West" in {
    Direction.anticlockwise(West) shouldBe South
  }

}
