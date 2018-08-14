package sbthello

import sbt._

object HelloPlugin extends AutoPlugin {

  // これを書いておくと、プラグイン利用者が面倒なimportを書かなくてすむ
  object autoImport {
    val hello = inputKey[Unit]("hello")
  }

  import autoImport._

  // このプラグインが有効化されるトリガ
  // `allRequirements`はこのプラグインの依存性が全て解決されたら有効化される
  override def trigger = allRequirements

  // プロジェクトのビルドセッティングにこのプラグインを設定する
  override lazy val buildSettings = Seq(
    hello := helloTask.evaluated // 引数を取らないTaskのときは `helloTask.value` になる
  )

  // helloタスクの実装
  lazy val helloTask = Def.inputTask {
    val args: Seq[String] = complete.DefaultParsers.spaceDelimited("<arg>").parsed
    println(s"hello ${args.mkString(",")} !!")
  }

}