package client

import client.controllers.*
import client.services.*
import kotlin.js.*

@JsName("angular")
external val angular: dynamic

fun main(args: Array<String>) {
 val controllers = angular.module("controllers", js("[]"))
 controllers.controller("HelloController", helloControllerFactory())

 val services = angular.module("services", js("[]"))
 services.service("dataService", dataServiceFactory())

 val app = angular.module("app", arrayOf("ngRoute", "services", "controllers"))

 val config: Array<Any> = arrayOf("\$routeProvider", { routeProvider: dynamic ->
  //val hello = mapOf("templateUrl" to "/views/hello", "controller" to "HelloController")
  //val redirect = mapOf("redirectTo" to "/") why doesn't mapOf create a JavaScript object, arrayOf creates a JavaScript array...
  val hello = json(Pair("templateUrl", "/views/hello"), Pair("controller", "HelloController"))
  val redirect = json(Pair("redirectTo", "/"))
  routeProvider["when"]("/", hello).otherwise(redirect)
 })

 app.config(config)
}
