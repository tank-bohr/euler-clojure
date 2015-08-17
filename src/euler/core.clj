(ns euler.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn multiples?
  [n x]
  (== 0 (mod n x)))

(defn multiples-of-3-or-5
  [edge]
  (filter #(or (multiples? % 3) (multiples? % 5))
    (range 1 edge)))

(defn fibonacci-next
  [s]
  (cons (reduce + (take 2 s)) s))

(defn fibonacci-recur
  [edge acc]
  (if (< edge (first acc))
    (rest acc)
    (recur edge (fibonacci-next acc))))

(defn fibonacci
  [edge]
  (fibonacci-recur edge '(1 1)))

(defn problem1
  "Find the sum of all the multiples of 3 or 5 below x"
  [x]
  (reduce + (multiples-of-3-or-5 x)))

(defn problem2
  "Even Fibonacci numbers"
  [x]
  (reduce + (filter even? (fibonacci x))))
