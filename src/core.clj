(ns core
  (:require [ring.adapter.jetty :as jetty]
            [reitit.ring :as ring]
            [todo.http.handlers :as handlers]
            [todo.http.routing :as routing]
            [todo.http.middleware :as middleware]
            [ring.middleware.reload :as reload]))

;; build the http request handler
(defn ->http-handler []
  (-> routing/router
      (ring/ring-handler handlers/not-found)
      middleware/wrap-stores
      reload/wrap-reload))

;; returns a function that stops the server when invoked
(defn -main [& args]
  (jetty/run-jetty (->http-handler)
                   {:port 3000
                    :join? false}))

(comment
  (def stop-server (-main))
  
  (.stop stop-server)

  ;; TODO
  ;; query params middleware
  ;; form params middleware
  ;; params middleware
  
  nil)