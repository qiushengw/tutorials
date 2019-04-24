package main

import "fmt"

func main() {
	message := make(chan string)
	signal := make(chan bool)

	select {
	case msg := <-message:
		fmt.Println("msg:", msg)
	default:
		fmt.Println("No msg received")
	}

	msg := "hi"

	select {
	case message <- msg:
		fmt.Println("message send", msg)
	default:
		fmt.Println("No message send")
	}

	select {
	case msg := <-message:
		fmt.Println("received message", msg)
	case sig := <-signal:
		fmt.Println("received signal", sig)
	default:
		fmt.Println("No activity")
	}

	
}
