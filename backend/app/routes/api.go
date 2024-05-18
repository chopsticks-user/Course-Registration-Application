package routes

import "net/http"

var apiRoutePrefix = "/api/v1"

var Router = http.NewServeMux()

func exportHandler(method string, route string,
	handler func(http.ResponseWriter, *http.Request)) {
	Router.HandleFunc(method+" "+apiRoutePrefix+route, handler)
}
