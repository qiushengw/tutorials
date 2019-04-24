package main

import (
	"encoding/json"
	"fmt"
	"net/http"
)

type Person struct {
	ID        string `json:"id,omitempty"`
	Firstname string `json:"firstname,omitempty"`
	Lastname  string `json:"lastname,omitempty"`
}

func main() {
	fmt.Printf("this is a test")
	http.HandleFunc("/", handler)
	http.ListenAndServe(":3001", nil)
}

func handler(w http.ResponseWriter, r *http.Request) {
	var person Person
	person.Firstname = "Wang"
	person.Lastname = "Qiusheng"
	person.ID = "123456"
	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(http.StatusCreated)

	json.NewEncoder(w).Encode(person)
}
