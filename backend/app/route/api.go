package route

import (
	"net/http"
	"sis/backend/api/middleware"
)

var apiRoutePrefix = "/api/v1"
var router = http.NewServeMux()
var Handler http.Handler

func exportHandler(
	parttern string,
	handler func(http.ResponseWriter, *http.Request),
	middlewares ...middleware.Middleware) {
	router.Handle(parttern,
		middleware.CreateStack(middlewares...)(http.HandlerFunc(handler)))
}

func initDefaultMiddlewares() {
	Handler = middleware.CreateStack(middleware.Logging)(router)
}

func stripAPIRoutePrefix() {
	router.Handle(apiRoutePrefix+"/", http.StripPrefix(apiRoutePrefix, router))
}

func init() {
	stripAPIRoutePrefix()
	initDefaultMiddlewares()
}
