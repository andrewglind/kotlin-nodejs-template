package client

import client.controllers.*
import client.services.*

import kotlin.js.*

@JsName("angular")
external val angular: dynamic

fun HashMap<String, Any>.toJson(): Json {
 val js = json()
 this.forEach { (k, v) -> js.set(k, v) }
 return js
}

fun main(args: Array<String>) {
 val controllers = angular.module("controllers", arrayOfNulls<Any>(0))
 controllers.controller("HelloController", helloControllerFactory())

 val services = angular.module("services", arrayOfNulls<Any>(0))
 services.service("dataService", dataServiceFactory())

 val app = angular.module("app", arrayOf("ngRoute", "services", "controllers"))

 val config: Array<Any> = arrayOf("\$routeProvider", { routeProvider: dynamic ->
  val hello: HashMap<String, Any> = hashMapOf("templateUrl" to "/views/hello", "controller" to "HelloController")
  val redirect: HashMap<String, Any> = hashMapOf("redirectTo" to "/")
  routeProvider["when"]("/", hello.toJson()).otherwise(redirect.toJson())
 })

 app.config(config)
}
