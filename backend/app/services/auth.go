package services

import (
	"crypto/sha256"
	"errors"
	"time"

	"github.com/golang-jwt/jwt/v5"
)

var secretKey []byte

type AuthToken struct {
	Token string `json:"token"`
}

func GenerateToken(username string, email string) (AuthToken, error) {
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, jwt.MapClaims{
		"username": username,
		"email":    email,
		"nbf":      time.Now().Add(time.Hour).Unix(),
	})

	tokenString, err := token.SignedString(secretKey)
	if err != nil {
		err = errors.New("failed to generate authentication token")
	}

	return AuthToken{Token: tokenString}, err
}

func init() {
	hash := sha256.New()
	hash.Write([]byte("sis-auth-secret-key"))
	secretKey = hash.Sum(nil)
}
