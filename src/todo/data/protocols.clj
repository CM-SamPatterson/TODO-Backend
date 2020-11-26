(ns todo.data.protocols)

(defprotocol Store
  (add-todo [store todo])
  (update-todo [store todo])
  (delete-todo [store id])
  (get-todo [store id])
  (get-all-todos [store ]))