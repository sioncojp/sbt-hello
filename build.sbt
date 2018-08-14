lazy val root = (project in file("."))
  .settings(
    scalaVersion := "2.12.5",
    name := "hello-world"
  )

val hello = taskKey[Unit]("hello world")

hello := {
  println("hello world")
}

// Keyの定義
// 引数を使うときはinputKey
// sbt "hello2 hoge"
val hello2 = inputKey[Unit]("hello world")

// helloの実装
hello2 := {
  val args: Seq[String] = complete.DefaultParsers.spaceDelimited("<arg>").parsed
  println("args.size=" + args.size)
  println(s"hello ${args.head}!!")
}