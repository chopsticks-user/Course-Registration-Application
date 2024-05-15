package common

import (
	"strings"
)

func IsBlank(s string) bool {
	return s == "" || strings.TrimSpace(s) == ""
}
