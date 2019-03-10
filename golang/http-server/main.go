package main

import (
	"fmt"
	"net/http"
)

func main() {
	fmt.Printf("this is a test")

	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "This is a website server by a Go HTTP server.")
	})

	http.ListenAndServe(":3001", nil)
}
