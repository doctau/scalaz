package scalaz.test

sealed trait Result {
  val arguments: Option[List[Argument[_]]]
  val status: Status
  val exception: Option[Throwable]
}

object Result {
  def result(as: List[Argument[_]], st: Status, ex: Throwable) = new Result {
    val arguments = Some(as)
    val status = st
    val exception = Some(ex)
  }

  def result(as: List[Argument[_]], st: Status) = new Result {
    val arguments = Some(as)
    val status = st
    val exception = None
  }

  def result(st: Status, ex: Throwable) = new Result {
    val arguments = None
    val status = st
    val exception = Some(ex)
  }

  def result(st: Status) = new Result {
    val arguments = None
    val status = st
    val exception = None
  }
}