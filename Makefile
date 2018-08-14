.PHONY: run

run:
	@sbt hi "hi2 hoge" "hello hoge fuga"

build:
	@sbt publishLocal