package client.controllers

import client.services.DataService

class HelloController(val scope: dynamic, val dataService: DataService) {
 fun hello() {
  dataService.hello({ err: dynamic, data: String ->
   if(err == null) {
    scope.message = data
   }
  })
 }
}

inline fun helloControllerFactory(): Array<Any> {
 return arrayOf("\$scope", "dataService", { scope: dynamic, dataService: DataService ->
  val helloController = HelloController(scope, dataService)
  helloController.hello()
  helloController
 })
}
