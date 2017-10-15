package client.services

class DataService(val http: dynamic) {
 fun hello(callback: dynamic) {
  return this.http.get("/hello").then({ res: dynamic ->
   callback(null, res.data)
  }, { res: dynamic ->
   callback("Failed")
  })
 }
}

inline fun dataServiceFactory(): Array<Any> {
 return arrayOf("\$http", { http: dynamic -> DataService(http) })
}
