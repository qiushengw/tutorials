package main

import "fmt"

func main() {
	var primie = [6]int{2, 3, 5, 7, 11}
	primie[5] = 13

	var s []int = primie[0:3]
	fmt.Println(s)

	names := []string{"a", "b", "c", "d", "e"}

	var s2 []string = names[1:4]
	fmt.Printf("cap=%d, len=%d", cap(s2), len(s2))

	fmt.Print(s2)
	s2[0] = "B"

	fmt.Println(names)

}
