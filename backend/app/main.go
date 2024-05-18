package main

import (
	"log"
	"net/http"
	"sis/backend/api/routes"
)

func main() {
	log.Println("Starting server on port :8080")
	server := http.Server{Addr: ":8080", Handler: routes.Router}

	err := server.ListenAndServe()
	if err != nil {
		log.Println("Failed to start server on port :8080")
	}
}
