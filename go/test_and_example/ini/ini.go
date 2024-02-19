package main

import (
	/**
	   import 下划线（如：import hello/imp）的作用：当导入一个包时，该包下的文件里所有init()函数都会被执行，
	然而，有些时候我们并不需要把整个包都导入进来，仅仅是是希望它执行init()函数而已。这个时候就可以使用 import 引用该包。即使用【import _ 包路径】
	只是引用该包，仅仅是为了调用init()函数，所以无法通过包名来调用包中的其他函数。
	*/
	_ "auxiliaryJ/go/test_and_example/ini/hello"
)

func main() {
	//hello.Print()
	//编译报错：./main.go:6:5: undefined: hello
}
