package client.controllers

import client.services.DataService

class HelloController {
 val scope: dynamic
 val dataService: DataService

 constructor(scope: dynamic, dataService: DataService) {
  this.scope = scope
  this.dataService = dataService

  dataService.hello({ err: dynamic, data: String ->
   if(err == null) {
    scope.message = data
   }
  })
 }
}

inline fun helloControllerFactory(): Array<Any> {
 return arrayOf("\$scope", "dataService", { scope: dynamic, dataService: DataService -> HelloController(scope, dataService) })
}
