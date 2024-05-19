package route

import (
	"net/http"
	"sis/backend/api/middleware"
)

var apiRoutePrefix = "/api/v1"
var router = http.NewServeMux()
var Handler http.Handler

func exportHandler(method string, route string,
	handler func(http.ResponseWriter, *http.Request),
	middlewares ...middleware.Middleware) {
	router.Handle(method+" "+apiRoutePrefix+route,
		middleware.CreateStack(middlewares...)(http.HandlerFunc(handler)))
}

func defaultMiddlewares() http.Handler {
	return middleware.CreateStack(middleware.Logging)(router)
}

func init() {
	Handler = defaultMiddlewares()
}
