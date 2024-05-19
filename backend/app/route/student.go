package route

import (
	"encoding/json"
	"net/http"
	"sis/backend/api/data"
	"sis/backend/api/model"
	"sis/backend/api/service"
)

func studentLoginPost(w http.ResponseWriter, r *http.Request) {
	var student model.Student

	err := json.NewDecoder(r.Body).Decode(&student)
	if err != nil {
		http.Error(w, "failed to parse JSON request body", http.StatusBadRequest)
		return
	}

	err = student.Validate()
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	password, err := data.FetchPasswordFromUsername(student.Username)
	if err != nil || password != student.Password {
		password, err := data.FetchPasswordFromEmail(student.Email)
		if err != nil || password != student.Password {
			http.Error(w, "Authentication failed", http.StatusBadRequest)
			return
		}
	}

	token, err := service.GenerateToken(student.Username, student.Email)
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

func studentSignupPost(w http.ResponseWriter, r *http.Request) {
}

func init() {
	exportHandler("POST /student/login", studentLoginPost)
	exportHandler("DELETE /student/login", studentLoginDelete)
	exportHandler("POST /student/signup", studentSignupPost)
}
