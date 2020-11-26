(ns todo.web.views
  (:require [hiccup.core :as hiccup]))

(defn ->template [body]
  (hiccup/html [:html 
                [:head
                 [:title "Todo"]]
                [:body
                 body]]))

(defn get-home [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (->template [:p "Hello World"])})

(defn not-found [request]
  {:status 404
   :headers {"Content-Type" "text/html"}
   :body "Not Found"})