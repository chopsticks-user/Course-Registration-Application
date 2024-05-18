package main

import (
	"fmt"
	"net/http"
	"sis/backend/api/common"
	"sis/backend/api/routes"
)

func main() {
	http.HandleFunc(common.URLWithPrefix("/user/login"), routes.UserLoginHandler)
	http.HandleFunc(common.URLWithPrefix("/course/"), routes.CoursesHandler)

	if err := http.ListenAndServe(":8080", nil); err != nil {
		fmt.Println("Error encountered while starting Go API at port 8080:", err)
	}
}
