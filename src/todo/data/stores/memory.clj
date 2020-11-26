(ns todo.data.stores.memory
  (:require [todo.data.protocols :as protocols]))

;; any changes made to data will need to happen in a call to 'swap!' since it's an atom
(def data (atom (->> (range 1 11)
                     (map (fn [id]
                            [id {:id id
                                 :name (str "Todo" id)
                                 :description "This is a todo!"}]))
                     (into (sorted-map)))))

(defrecord MemoryStore []
  protocols/Store
  ;; tip: 'assoc' can be used to add a key-value to a map
  (add-todo [store todo])
  ;; tip: 'update' can be used to update the value of an existing key-value
  (update-todo [store todo])
  ;; tip: 'dissoc' can be used to remove a key-value from a map
  (delete-todo [store id])
  ;; tip: maps can be used like functions where the key is the first argument, e.g. ({:a 1} :a) => 1
  (get-todo [store id])
  (get-all-todos [store]
    @data))

