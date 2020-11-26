(ns tutorial
  (:require [clojure.repl :as repl]))

;; environment setup
;; go here https://clojure.org/guides/getting_started and follow the installation guide
;; install the 'Calva' plugin for VS Code
;; create a project folder
;; add a deps.edn file with the following content: {:paths ["src"]}
;; create a "src" folder
;; add a "core.clj" file to the src folder
;; open the core.clj file and using the following keyboard shortcuts to start the REPL
;; - ctrl + alt + c, then ctrl + alt + j (this can be configured)

;; - clojure is a LISP that is primarily functional however supports elements of OO programming
;; - everything in clojure is data, even the source code
;; - all data is immutable (for the most part), i.e. mutating state over time isn't possible
;;   - a concept known as structural sharing is used to keep memory usage low
;; - clojure primarily uses a data structure called S-Expressions, which is basically just nested lists
;;   - however clojure extends this idea to include other data-types
;; - the first thing in a list is always a function (specifically something that arguments can be applied to), everything after the first thing are the function's arguments

;; data types
42 ;; integer
-1.5 ;; floating point
36/6 ;; ratio
"hello" ;; string
nil ;; null value
\a ;; character
'hello ;; symbol - like the name of a variable but not quite, used to refer to functions, values etc.
true false ;; boolean
:hello ;; keyword - used primarily for lookups in data structures
::hello ;; namespaced keyword - same as a keyword but attaches the current namespace to the keyword

;; collections
'(1 2 3) ;; list - ordered, implemented as linked-lists O(n)

[1 2 3] ;; vector - ordered, supports random access O(1)

#{1 2 3} ;; set - unordered, distinct items

(set [1 2 3 3 3 4 5 6])

{:a 1} ;; map - unordered, values can be looked up like a dictionary, supports large number of different key types 

(+ 1 2) ;; example of an s-expression, '+' is the function, 1 and 2 are its arguments

(* 3
   (+ 4 5)
   (+ 1
      (+ 2 3))) ;; something a bit more complicated, sub expressions are evaluated first

;; functions
;; 1st argument is the name, second argument is a vector of argument symbols, everything else is the function's body
;; the last value in the function's body is the return value, println returns nil as it is a side effectful function
;; 'defn' is a special type of function called a 'special form', there are only a handful of these in clojure
(defn say-hello [name]
  (println "Hello," name)
  (str name "123")
  1)

;; invoked like so
(say-hello "Sam")

;; functions can also have different 'arities'
;; useful for specifiying default arguments, in this case 'b' gets a default argument of one
;; essentially clojure's version of method overloading but more succinct :)
(defn hello
  ([a]
   (hello a 1))
  ([a b]
   (println a b)))

;; variadic arguments
;; allows you specify any number of arguments, the variable specified after the '&' will be a list that contains all the additional arguments
(defn hello2 [a & rest]
  (println a rest))

;; let expression - used to create scoped local values, referenced by a symbol
(let [a 1
      b 2
      c 3
      d (str a b c)]
  (println d)
  123) ;; => prints "123"

;; value shadowing
;; if a symbol that already exists in the current scoped is redefined in a 'let', the symbol takes on the new value whilst in that scope
;; this applies not only to function arguments but also values that have been def'd
;; in the function below imagine the value '2' was passed in as the value of 'a'
(defn test [a]
  (println a) ; => 2
  (let [a 1]
    (println a)) ; => 1
  (println a)) ; => 2

;; namespaces - permits seperation of concerns, similiar to the idea of namespaces in C#
;; (ns this.is.a.namespace) ;; dots are used for directory levels

;; vars - defined using the 'def' function, the value represented by the symbol can then be accessed anywhere after the var
(def my-var 123)

(let [my-var-2 (+ my-var 1)]
  (println my-var-2) ;; => 124
  (println my-var)) ;; => 123, immutability :)

;; map destructuring
;; (blah {:a 1})
(defn blah [{:keys [a]}]
  a) ; => 1

;; vector destructuring - allows you to create symbols for each index you're interested in when binding a vector
;; (another [1 2 3])
(defn another [[a b c]]
  (println a b c)) ; => 1 2 3

;; lazy sequences
(def m-lazy (map (fn [val]
                   (println "hello!")
                   val)
                 (range 1 64)))

(def m-not-lazy (mapv (fn [val]
                        (println "hello")
                        val)
                      (range 1 64)))

;; REPL
;; All source code in clojure is evaluated at the 'REPL', which the interactive dev environment clojure programs are written in 
;; R - READ, this is when macros are expanded and your source code is transformed into clojure data structures
;; E - Eval, the clojure code is evaluated, this is when any errors in your program will be raised
;; P - Print
;; L - Loop

;; Other topics
;; Comment blocks
;; Multi-arity functions
;; Function shorthand
;; Function application
;; Partial application (manual currying)
;; Closures
;; Conj (differences between the different collection types)
;; Cond and case
;; For loop
;; Exception handling
;; Multi-methods
;; Dynamic vars
;; Core.async (advanced)
;; Transducers (advanced)
;; Zippers (advanced)