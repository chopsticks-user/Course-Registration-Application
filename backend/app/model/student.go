package model

import (
	"errors"
	"sis/backend/api/common"
	"unicode"
)

type Student struct {
	Username string `json:"username"`
	Email    string `json:"email"`
	Password string `json:"password"`
}

func (s Student) Validate() error {
	err := validateUsername(s.Username)
	if err != nil {
		return err
	}

	err = validateEmail(s.Email)
	if err != nil {
		return err
	}

	err = validatePassword(s.Password)
	if err != nil {
		return err
	}

	return nil
}

func validateUsername(s string) error {
	if common.IsBlank(s) {
		return errors.New("username cannot be empty")

	}

	if !unicode.IsLetter(rune(s[0])) {
		return errors.New("the first character of username must be a letter")
	}

	for i := 1; i < len(s); i++ {
		var r = rune(s[i])
		if !unicode.IsDigit(r) && !unicode.IsLetter(r) && r != '_' {
			return errors.New("username must only contains digits, letters and _")
		}
	}

	return nil
}

func validateEmail(s string) error {
	return nil
}

func validatePassword(s string) error {
	if len(s) < 12 {
		return errors.New("password must contains at least 12 characters")
	}

	for _, c := range s {
		if !unicode.IsDigit(c) && !unicode.IsLetter(c) && !supportedSymbols(c) {
			return errors.New("username must only contains digits, letters and supported symbols: @ # & * _")
		}
	}

	return nil
}

func supportedSymbols(c rune) bool {
	return c == '@' || c == '#' || c == '&' || c == '*' || c == '_'
}
