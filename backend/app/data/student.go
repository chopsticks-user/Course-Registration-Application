package data

import (
	"database/sql"
	"encoding/json"
	"errors"
	"fmt"
	"log"
	"os"

	_ "github.com/lib/pq"
)

type Student struct {
	ID       int64
	Username string
	Email    string
	Password string
}

type dbInfo struct {
	User     string `json:"user"`
	DBName   string `json:"dbname"`
	SSLMode  string `json:"sslmode"`
	Password string `json:"password"`
	Driver   string `json:"driver"`
}

func connectDB() (*sql.DB, error) {
	data, err := os.ReadFile("./data/db.json")
	if err != nil {
		return nil, err
	}

	var info dbInfo
	err = json.Unmarshal(data, &info)
	if err != nil {
		return nil, err
	}

	connStr := fmt.Sprintf("user=%s dbname=%s sslmode=%s password=%s",
		info.User, info.DBName, info.SSLMode, info.Password)
	db, err := sql.Open(info.Driver, connStr)
	if err != nil {
		log.Println(err.Error())
		return nil, err
	}
	// Verify connection
	if err := db.Ping(); err != nil {
		log.Println(err.Error())
		return nil, err
	}
	return db, nil
}

func FetchPasswordFromEmail(email string) (string, error) {
	db, err := connectDB()
	if err != nil {
		return "", errors.New("error connecting to database")
	}
	defer db.Close()

	var password string
	query := "SELECT password FROM students WHERE students.email = $1"
	err = db.QueryRow(query, email).Scan(&password)
	if err != nil {
		return "", errors.New("error encountered while preparing a query")
	}

	return password, nil
}

func FetchPasswordFromUsername(username string) (string, error) {
	db, err := connectDB()
	if err != nil {
		return "", errors.New("error connecting to database")
	}
	defer db.Close()

	var password string
	query := "SELECT password FROM students WHERE students.username = $1"
	err = db.QueryRow(query, username).Scan(&password)
	if err != nil {
		return "", errors.New("error encountered while preparing a query")
	}

	return password, nil
}
