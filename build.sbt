lazy val root = (project in file("."))
  .settings(
    organization := "com.github.sioncojp",
    version := "1.0.0",
    name := "sbt-hello",
    sbtPlugin := true
  )

val hi = taskKey[Unit]("hi world")

hi := {
  println("hi world")
}

// Keyの定義
// 引数を使うときはinputKey
// sbt "hi2 hoge"
val hi2 = inputKey[Unit]("hi world")

hi2 := {
  val args: Seq[String] = complete.DefaultParsers.spaceDelimited("<arg>").parsed
  println("args.size=" + args.size)
  println(s"hi ${args.head}!!")
}