package main

import "strconv"

func main() {
	m := make(map[string]int, 500)
	for i := 0; i < 300; i++ {
		key := strconv.Itoa(i) + "_key"
		m[key] = i
	}
	//寻找 map 的写的源码执行步骤
	m["test_source_code"] = 50

	delete(m, "test_source_code")
}
