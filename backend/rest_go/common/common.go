package common

import (
	"strings"
)

var apiURLPrefix = "/api/v1"

func IsBlank(s string) bool {
	return s == "" || strings.TrimSpace(s) == ""
}

func URLWithPrefix(s string) string {
	return apiURLPrefix + s
}
