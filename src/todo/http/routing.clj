(ns todo.http.routing
  (:require [todo.http.handlers :as handlers]
            [todo.web.views :as views]
            [reitit.ring :as ring]))

(def router (ring/router [["/" {:get handlers/get-todos-index}]
                          ["/todos"
                           ["" {:get handlers/get-todos-index}]
                           ["/:id" {:get handlers/get-todo}]]]))

