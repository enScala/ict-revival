package endava.ict

import org.scalatest.{Matchers, WordSpecLike}

class QuicksortTests extends WordSpecLike with Matchers {

  "quicksort imperative" should {
    import com.endava.ict.QuicksortImperative._
    
    "correctly sort a list" in {
      sort(Array(2,3,1)) shouldEqual Array(1,2,3)
    }
  }

  "quicksort functional" should {
    import com.endava.ict.QuicksortFunctional._

    "correctly sort a list" in {
      sort(Array(2,3,1)) shouldEqual Array(1,2,3)
    }
  }

  "quicksort imperative java" should {
    import com.endava.ict.QuicksortImperativeJava

    "correctly sort a list" in {
      val instance = new QuicksortImperativeJava(Array(2, 3, 1))
      instance.sort() shouldEqual Array(1,2,3)
    }
  }

}
