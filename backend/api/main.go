package main

import (
	"encoding/json"
	"fmt"
	"io"
	"net"
	"net/http"
	"strings"
)

// https://stackoverflow.com/questions/23558425/how-do-i-get-the-local-ip-address-in-go
// GetLocalIP returns the non loopback local IP of the host
func GetLocalIP() string {
	addrs, err := net.InterfaceAddrs()
	if err != nil {
		return ""
	}
	for _, address := range addrs {
		// check the address type and if it is not a loopback the display it
		if ipnet, ok := address.(*net.IPNet); ok && !ipnet.IP.IsLoopback() {
			if ipnet.IP.To4() != nil {
				return ipnet.IP.String()
			}
		}
	}
	return ""
}

type LoginData struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func isBlank(s string) bool {
	return s == "" || len(strings.TrimSpace(s)) == 0
}

func sessionsHandler(w http.ResponseWriter, r *http.Request) {
	body, err := io.ReadAll(r.Body)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	var loginData LoginData
	if err := json.Unmarshal(body, &loginData); err != nil {
		http.Error(w, "Failed to parse JSON data", http.StatusBadRequest)
		return
	}

	if isBlank(loginData.Username) || isBlank(loginData.Password) {
		http.Error(w, "Username and password cannot be empty", http.StatusBadRequest)
	}

	w.Write([]byte(`{"token": "logged in"}`))
	w.WriteHeader(http.StatusOK)
}

func main() {
	http.HandleFunc("/sessions/login", sessionsHandler)

	fmt.Println("API server listening at", GetLocalIP(), ":", 8080)
	if err := http.ListenAndServe(":8080", nil); err != nil {
		fmt.Println("Error:", err)
	}
}
