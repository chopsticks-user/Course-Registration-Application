package models

import (
	"sis/backend/api/common"
	"unicode"
)

type Login struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func (s Login) ValidUsername() bool {
	return validUsername(s.Username)
}

func (s Login) ValidPassword() bool {
	return validPassword(s.Password)
}

type Signup struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func (s Signup) ValidUsername() bool {
	return validUsername(s.Username)
}

func (s Signup) ValidPassword() bool {
	return validPassword(s.Password)
}

type LoginResponse struct {
	Token string `json:"token"`
}

func validUsername(s string) bool {
	if common.IsBlank(s) || !unicode.IsLetter(rune(s[0])) {
		return false
	}

	for i := 1; i < len(s); i++ {
		var r = rune(s[i])
		if !unicode.IsDigit(r) && !unicode.IsLetter(r) && r != '_' {
			return false
		}
	}

	return true
}

func validPassword(s string) bool {
	if len(s) < 12 {
		return false
	}

	for _, c := range s {
		if !unicode.IsDigit(c) && !unicode.IsLetter(c) && !supportedSymbols(c) {
			return false
		}
	}

	return true
}

func supportedSymbols(c rune) bool {
	return c == '@' || c == '#' || c == '&' || c == '*' || c == '_'
}
