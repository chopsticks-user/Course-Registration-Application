package routes

import (
	"encoding/json"
	"fmt"
	"net/http"
	"sis/backend/api/models"
)

func userLoginPost(w http.ResponseWriter, r *http.Request) {
	var login models.Login

	err := json.NewDecoder(r.Body).Decode(&login)
	if err != nil {
		http.Error(w, "failed to parse JSON request body", http.StatusBadRequest)
		return
	}

	err = login.Validate()
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	var responseData models.LoginResponse
	responseData.Token = login.Username
	json, err := json.Marshal(responseData)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	w.Write(json)
}

func userLoginDelete(w http.ResponseWriter, r *http.Request) {
	fmt.Println("DELETE /user/login")
}

func UserLoginHandler(w http.ResponseWriter, r *http.Request) {
	switch r.Method {
	case http.MethodPost:
		userLoginPost(w, r)
	case http.MethodDelete:
		userLoginDelete(w, r)
	default:
		http.Error(w, "Method not allowed", http.StatusMethodNotAllowed)
		return
	}
}
