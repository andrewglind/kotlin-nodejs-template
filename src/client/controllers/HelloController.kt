package client.controllers

object HelloController {
 fun get(): Array<Any> {
  return arrayOf("\$scope", "dataService", { scope: dynamic, dataService: dynamic ->
   dataService.hello({ err: dynamic, data: String ->
    if(err == null) {
     scope.message = data
    }
   })
  })
 }
}