package rover.navigation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CoordinateSpec extends AnyFlatSpec with Matchers {

  "delta" should "be (0, 0) when coordinates are the same" in {
    val current = Coordinate(4, 2)
    val destination = Coordinate(4, 2)

    current delta destination shouldBe (0, 0)
  }

  it should "not be (0, 0) when x coordinates are the same in magnitude but not sign" in {
    val current = Coordinate(4, 2)
    val destination = Coordinate(-4, 2)

    current delta destination should not be (0, 0)
  }

  it should "not be (0, 0) when y coordinates are the same in magnitude but not sign" in {
    val current = Coordinate(4, 2)
    val destination = Coordinate(4, -2)

    current delta destination should not be (0, 0)
  }

  it should "not be (0, 0) when x and y coordinates are the same in magnitude but not sign" in {
    val current = Coordinate(4, 2)
    val destination = Coordinate(-4, -2)

    current delta destination should not be (0, 0)
  }

}
