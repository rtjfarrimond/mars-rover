package rover.navigation

import direction.Direction.{East, North, South, West}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import rover.MarsRover

class CityBlockNavigatorSpec extends AnyFlatSpec with Matchers {

  "findShortestPath" should "return 10 MoveForward instructions" in {
    val rover = MarsRover(0, 0, North)
    val destination = Coordinate(0, 10)
    val expected = Some(Seq.fill(10)(MoveForward))
    val actual = CityBlockNavigator.findShortestPath(rover, destination)

    actual shouldBe expected
  }

  it should "first rotate clockwise" in {
    val rover = MarsRover(0, 0, West)
    val destination = Coordinate(0, 10)

    val instructions = CityBlockNavigator.findShortestPath(rover, destination).get
    instructions.length shouldBe 11

    val actual = instructions.head
    actual shouldBe RotateClockwise
  }

  it should "first rotate anticlockwise" in {
    val rover = MarsRover(0, 0, East)
    val destination = Coordinate(0, 10)

    val instructions = CityBlockNavigator.findShortestPath(rover, destination).get
    instructions.length shouldBe 11

    val actual = instructions.head
    actual shouldBe RotateAnticlockwise
  }

  it should "first rotate clockwise twice" in {
    val rover = MarsRover(0, 0, South)
    val destination = Coordinate(0, 10)
    val expected = Seq.fill(2)(RotateClockwise)

    val instructions = CityBlockNavigator.findShortestPath(rover, destination).get
    instructions.length shouldBe 12

    val actual = instructions.take(2)
    actual shouldBe expected
  }

  it should "contain a rotate clockwise followed by three move forwards, repeated twice" in {
    val rover = MarsRover(0, 0, West)
    val destination = Coordinate(3, 3)
    val half = Seq(RotateClockwise) ++ Seq.fill(3)(MoveForward)
    val expected = Some(half ++ half)
    val actual = CityBlockNavigator.findShortestPath(rover, destination)

    actual shouldBe expected
  }

  it should "navigate to a destination with negative coordinates" in {
    val rover = MarsRover(0, 0, West)
    val destination = Coordinate(-3, -3)
    val threeForwards = Seq.fill(3)(MoveForward)
    val expected = Some((threeForwards :+ RotateAnticlockwise) ++ threeForwards)
    val actual = CityBlockNavigator.findShortestPath(rover, destination)

    actual shouldBe expected
  }

  it should "navigate to a destination with a negative x coordinate" in {
    val rover = MarsRover(0, 0, West)
    val destination = Coordinate(-3, 3)
    val threeForwards = Seq.fill(3)(MoveForward)
    val expected = Some((threeForwards :+ RotateClockwise) ++ threeForwards)
    val actual = CityBlockNavigator.findShortestPath(rover, destination)

    actual shouldBe expected
  }

  it should "navigate to a destination with a negative y coordinate" in {
    val rover = MarsRover(0, 0, West)
    val destination = Coordinate(3, -3)
    val threeForwards = Seq.fill(3)(MoveForward)
    val half = RotateAnticlockwise +: threeForwards
    val expected = Some(half ++ half)
    val actual = CityBlockNavigator.findShortestPath(rover, destination)

    actual shouldBe expected
  }

}
