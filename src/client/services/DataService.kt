package client.services

import kotlin.js.*

object DataService {
 fun get(): Array<Any> {
  val functions = fun(http: dynamic): dynamic {
   val hello = fun(callback: dynamic): Unit {
    http.get("/hello").then({ res: dynamic ->
     callback(null, res.data)
    }, { res:dynamic ->
     callback("Failed")
    })
   }
   return json(Pair("hello", hello))
  }
  return arrayOf("\$http", functions)
 }
}
