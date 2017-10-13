package server

external fun require(module: String): dynamic

fun Main(args: List<String>) {
 val express = require("express")
 val app = express()

 val m = Utils.argsToMap(args)

 app.use(express.static("public"))
 app.set("view engine", "pug")

 app.get("/hello", { _, res ->
  res.send("Hello, Kotlin!")
 })

 app.get("/", { _, res ->
  res.render("index")
 })

 app.get("/views/:name", { req, res ->
  res.render(req.params.name)
 })

 val port = m["port"] ?: 3000
 app.listen(port, {
  println("Listening on port $port")
 })
}

external val process: dynamic
fun main(args: Array<String>) {
 Main((process["argv"] as Array<String>).drop(2))
}
