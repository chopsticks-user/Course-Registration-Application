package main

import (
	"fmt"
	"net/http"
	"sis/backend/api/routes"
)

func main() {
	http.HandleFunc("/user/login", routes.UserLoginHandler)
	http.HandleFunc("/course/", routes.CoursesHandler)

	if err := http.ListenAndServe(":8080", nil); err != nil {
		fmt.Println("Error encountered while starting Go API at port 8080:", err)
	}
}
