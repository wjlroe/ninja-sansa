(ns ninja-sansa.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :as h]))

(defn index []
  (h/html5
    [:head
     [:meta {:charset "utf-8"}]
     [:title "Sansa"]]
    [:body
     [:h1 "Sansa>"]
     [:script {:src "js/sansa.js"}]]))

;; defroutes macro defines a function that chains individual route
;; functions together. The request map is passed to each function in
;; turn, until a non-nil response is returned.
(defroutes app-routes
           ; to serve document root address
           (GET "/" [] (index))
           ; to serve static pages saved in resources/public directory
           (route/resources "/")
           ; if page is not found
           (route/not-found "Page not found"))

;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))
