package routes

import (
	"encoding/json"
	"net/http"
	"sis/backend/api/models"
	"sis/backend/api/services"
)

func studentLoginPost(w http.ResponseWriter, r *http.Request) {
	var login models.StudentModel

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

	token, err := services.GenerateToken(login.Username, login.Email)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	json, err := json.Marshal(token)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	w.Write(json)
}

func studentLoginDelete(w http.ResponseWriter, r *http.Request) {
}

func init() {
	exportHandler("POST", "/user/login", studentLoginPost)
	exportHandler("DELETE", "/user/login", studentLoginDelete)
}
