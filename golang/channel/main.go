package main

import "fmt"

func main() {
	s := []int{1, 2, 3, 4, 5}
	c := make(chan int)

	go sum(s[:len(s)/2], c)
	go sum(s[len(s)/2:], c)

	x := <-c
	y := <-c
	fmt.Print(x, y, x+y)

	fmt.Println("---bufferred-channels------")
	ch := make(chan int, 2)
	ch <- 1
	ch <- 2
	// since defined the buff is 2, inside channle only 2 element allowed, if more then 2,
	// will got atal error: all goroutines are asleep - deadlock!
	fmt.Println(<-ch)
	fmt.Println(<-ch)

	fmt.Println("-----test chnnale closed--------------------")

	ch2 := make(chan int)
	go fibonacci(5, ch2)

	for i := range ch2 {
		fmt.Println(i)
	}

}

func sum(s []int, c chan int) {
	sum := 0
	for _, v := range s {
		sum += v
	}
	c <- sum

}

func fibonacci(n int, c chan int) {
	x, y := 0, 1
	for i := 0; i < n; i++ {
		c <- x
		x, y = y, x+y
	}

	//wihtout close, receiver side cannot use range to loop, also cannot judge it is closed or not
	close(c)

}
