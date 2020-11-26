(ns todo.http.middleware
  (:require [todo.data.stores.memory :as memory]))

(defn wrap-stores [handler]
  (fn [request]
    ;; assoc the memory store onto the request map
    (let [request-with-store (assoc request :store (memory/->MemoryStore))]
      (handler request-with-store))))