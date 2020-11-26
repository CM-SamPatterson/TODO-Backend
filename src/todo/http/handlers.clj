(ns todo.http.handlers
  (:require [clojure.data.json :as json]
            [todo.data.protocols :as protocols]))

(defn get-todos-index [{:keys [store]}]
  (println store)
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/write-str (protocols/get-all-todos store))})

;; destructure request to extract todo id, then query data using that id
(defn get-todo [request])

;; take form values from request and add a new todo to the data
;; requires form parsing middleware
(defn create-todo [request])

;; update an existing todo using the values sent up in the post
(defn update-todo [request])

;; removes a todo by id
(defn delete-todo [request])

(defn not-found [request]
  {:status 404
   :header {"Content-Type" "application/json"}
   :body (json/write-str {:message "Not Found"})})