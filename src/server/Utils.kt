package server

object Utils {
 fun argsToMap(args: List<String>): HashMap<String, Any> {
  val m: HashMap<String, Any> = HashMap<String, Any>()
  for ((k, v) in args.map { arg -> arg.split("=") }) {
   m[k.toLowerCase()] = v
  }
  return m
 }
}
