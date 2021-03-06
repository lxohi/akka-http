/*
 * Copyright (C) 2009-2019 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.http

import akka.http.scaladsl.Http.ServerBinding
import akka.remote.testkit.MultiNodeSpecCallbacks
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{ BeforeAndAfterAll, Matchers, WordSpecLike }

trait STMultiNodeSpec extends MultiNodeSpecCallbacks with WordSpecLike with Matchers with BeforeAndAfterAll
  with ScalaFutures {

  def binding: Option[ServerBinding]

  override def beforeAll() =
    multiNodeSpecBeforeAll()

  override def afterAll() = {
    binding foreach { _.unbind().futureValue }
    multiNodeSpecAfterAll()
  }

}
